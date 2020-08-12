package com.squareup.square;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.request.MultipartFileWrapper;
import com.squareup.square.http.request.MultipartWrapper;

/**
 * This is a Helper class with commonly used utilities for the SDK.
 */
public class ApiHelper {
    // Deserialization of Json data
    public static ObjectMapper mapper = new ObjectMapper() {
        private static final long serialVersionUID = -174113593500315394L; {
            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            setSerializationInclusion(JsonInclude.Include.NON_NULL);
        }
    };

    /**
     * Json Serialization of a given object.
     * @param  obj The object to serialize into Json
     * @return The serialized Json String representation of the given object
     */
    public static String serialize(Object obj)
            throws JsonProcessingException {
        if (obj == null) {
            return null;
        }

        return mapper.writeValueAsString(obj);
    }


    /**
     * Json deserialization of the given Json string.
     * @param   json The Json string to deserialize
     * @param   clazz The type of the object to deserialize into
     * @return  The deserialized object
     */
    public static <T extends Object> T deserialize(String json, Class<T> clazz)
            throws IOException {
        if (isNullOrWhiteSpace(json))
            return null;

        return mapper.readValue(json, clazz);
    }

    /**
     * JSON Deserialization of the given json string.
     * @param   json The Json string to deserialize
     * @param   classArray The class of the array of objects to deserialize into
     * @return  The deserialized list of objects
     */
    public static <T extends Object> List<T> deserializeArray(String json, Class<T[]> classArray)
            throws IOException {
        if (isNullOrWhiteSpace(json)) {
            return null;
        }
        
        return Arrays.asList(mapper.readValue(json, classArray));
    }

    /**
     * Populates an object of an ApiException subclass with the required properties.
     * @param   json The Json string to deserialize
     * @param   obj The object to populate.
     */
    public static void populate(String json, ApiException obj)
            throws IOException {
        if (!isNullOrWhiteSpace(json)) {
            mapper.readerForUpdating(obj).readValue(json);
        }
    }

    /**
     * Json deserialization of the given Json string.
     * @param   json The Json string to deserialize
     * @return  The deserialized Json as a Map
     */
    public static LinkedHashMap<String, Object> deserialize(String json)
            throws IOException {
        if (isNullOrWhiteSpace(json)) {
            return null;
        }

        TypeReference<LinkedHashMap<String,Object>> typeRef 
            = new TypeReference<LinkedHashMap<String,Object>>(){};
        return deserialize(json, typeRef);
    }

    /**
     * JSON Deserialization of the given json string.
     * @param   json The json string to deserialize
     * @param   <T>  The type of the object to deserialize into
     * @return  The deserialized object
     */
    public static <T extends Object> T deserialize(String json, TypeReference<T> typeReference)
            throws IOException {
        if (isNullOrWhiteSpace(json))
            return null;

        return mapper.readValue(json, typeReference);
    }

    /**
     * Replaces template parameters in the given URL
     * @param   queryBuilder The query string builder to replace the template parameters
     * @param   parameters The parameters to replace in the URL
     */
    public static void appendUrlWithTemplateParameters(StringBuilder queryBuilder, Map<String, Object> parameters,
            boolean encode) {
        // Perform parameter validation
        if (null == queryBuilder) {
            throw new IllegalArgumentException("Given value for parameter \"queryBuilder\" is invalid." );
        }

        if (null == parameters) {
            return;
        }

        // Iterate and append parameters
        for (Map.Entry<String, Object> pair : parameters.entrySet()) {
        
            String replaceValue = "";
            
            // Load element value as string
            if (null == pair.getValue()) {
                replaceValue = "";
            }
            else if (pair.getValue() instanceof Collection<?>) {
                replaceValue = flattenCollection("", (Collection<?>) pair.getValue(), "%s%s%s", '/');
            }
            else {
                if (encode) {
                    replaceValue = tryUrlEncode(pair.getValue().toString());
                } else {
                    replaceValue = pair.getValue().toString();
                }
            }

            // Find the template parameter and replace it with its value
            replaceAll(queryBuilder, "{" + pair.getKey() + "}", replaceValue);
        }
    }

    /**
     * Appends the given set of parameters to the given query string
     * @param   queryBuilder The query URL string to append the parameters
     * @param   parameters The parameters to append
     */
    public static void appendUrlWithQueryParameters(StringBuilder queryBuilder, Map<String, Object> parameters) {
        // Perform parameter validation
        if (null == queryBuilder) {
            throw new IllegalArgumentException("Given value for parameter \"queryBuilder\" is invalid.");
        }
        if (null == parameters) {
            return;
        }
        
        // Check if query string already has parameters
        boolean hasParams = queryBuilder.indexOf("?") > 0;
        queryBuilder.append(hasParams ? '&' : '?');

        encodeObjectAsQueryString("", parameters, queryBuilder);
    }

    /**
     * Validates if the string is null, empty or whitespace
     * @param   s The string to validate
     * @return  The result of validation
     */
    public static boolean isNullOrWhiteSpace(String s) {
        if(s == null) {
            return true;
        }

        int length = s.length();
        if (length > 0) {
            for (int start = 0, middle = length / 2, end = length - 1; start <= middle; start++, end--) {
                if (s.charAt(start) > ' ' || s.charAt(end) > ' ') {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Replaces all occurrences of the given string in the string builder
     * @param   stringBuilder The string builder to update with replaced strings
     * @param   toReplace The string to replace in the string builder
     * @param   replaceWith The string to replace with
     */
    public static void replaceAll(StringBuilder stringBuilder, String toReplace, String replaceWith) {
        int index = stringBuilder.indexOf(toReplace);
        
        while (index != -1) {
            stringBuilder.replace(index, index + toReplace.length(), replaceWith);
            index += replaceWith.length(); // Move to the end of the replacement
            index = stringBuilder.indexOf(toReplace, index);
        }
    }

    /**
     * Removes null values from the given map
     * @param map Map of values
     */
    public static void removeNullValues(Map<String, ?> map) {
        if (map == null) {
            return;
        }

        map.values().removeAll(Collections.singleton(null));
    }

    /**
     * Validates and processes the given URL
     * @param    url The given URL to process
     * @return   Pre-process URL as string
     */
    public static String cleanUrl(StringBuilder url) {
        // Ensures that the URLs are absolute
        Pattern pattern = Pattern.compile("^(https?://[^/]+)");
        Matcher matcher = pattern.matcher(url);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Invalid Url format.");
        }

        // Get the http protocol match
        String protocol = matcher.group(1);

        // Removes redundant forward slashes
        String query = url.substring(protocol.length());
        query = query.replaceAll("//+", "/");

        // Returns processed URL
        return protocol.concat(query);
    }

    /**
     * Prepares Array style form fields from a given array of values
     * @param   value Value for the form fields
     * @return  Dictionary of form fields created from array elements
     */
    public static List<SimpleEntry<String, Object>> prepareFormFields(Map <?, ?> value) {
        List<SimpleEntry<String, Object>> formFields = new ArrayList<>();
        if(value != null) {
            objectToList("", value, formFields, new HashSet<Integer>());
        }
        return formFields;
    }

    /**
     * Encodes a given object to URL encoded string
     * @param name Name of the object
     * @param obj Raw object sent from caller
     * @param objBuilder String of elements
     */
    private static void encodeObjectAsQueryString(String name, Object obj, StringBuilder objBuilder) {
        if (obj == null) {
            return;
        }

        List<SimpleEntry<String, Object>> objectList = new ArrayList<>();
        objectToList(name, obj, objectList, new HashSet<Integer>());
        boolean hasParam = false;


        for (SimpleEntry<String, Object> pair : objectList) {
            String paramKeyValPair;
            String accessor = pair.getKey();
            // Ignore null
            Object value = pair.getValue();
            if(value == null) {
                continue;
            }
                
            hasParam = true;
            // Load element value as string
            paramKeyValPair = String.format("%s=%s&", accessor, tryUrlEncode(value.toString()));
            objBuilder.append(paramKeyValPair);

            }

        // Removing the last &
        if(hasParam) {
            objBuilder.setLength(objBuilder.length() - 1);
        }
    }

    /**
     * Flattening a collection of objects into a string
     * @param   array Array of elements to flatten
     * @param   fmt Format string to use for array flattening
     * @param   separator Separator to use for string concatenation
     * @return  Representative string made up of array elements
     */
    private static String flattenCollection(String elemName, Collection<?> array, String fmt, char separator) {
        StringBuilder builder = new StringBuilder();

        // Append all elements of the array into a string
        for (Object element : array) {
            String elemValue = null;

            // Replace null values with empty string to maintain index order
            if (element == null) {
                elemValue = "";
            } else {
                elemValue = element.toString();
            }
            elemValue = tryUrlEncode(elemValue);
            builder.append(String.format(fmt, elemName, elemValue, separator));
        }

        // Remove the last separator, if appended
        if ((builder.length() > 1) && (builder.charAt(builder.length() - 1) == separator)) {
            builder.deleteCharAt(builder.length() - 1);
        }

        return builder.toString();
    }

    /**
     * Tries URL encode using UTF-8
     * @param value The value to URL encode
     * @return
     */
    private static String tryUrlEncode(String value) {
        try {
            return URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            return value;
        }
    }

    private static void objectToList(String objName, Collection<?> obj,  
            List<SimpleEntry<String,Object>> objectList, 
            HashSet<Integer> processed) {
      
        Collection<?> array = (Collection<?>) obj;
        // Append all elements of the array into a string
        int index = 0;
        for (Object element : array) {
            //load key value pair
                      String key = String.format("%s[%d]", objName, index++);
            loadKeyValuePairForEncoding(key, element, objectList, processed);
        }
      
    }

    private static void objectToList(String objName, Map<?, ?> obj, 
            List<SimpleEntry<String,Object>> objectList, 
            HashSet<Integer> processed) {
        // Process map
        Map<?, ?> map = (Map<?, ?>) obj;
        // Append all elements of the array into a string
        for (Map.Entry<?, ?> pair : map.entrySet()) {
            String attribName = pair.getKey().toString();
            if ((objName != null) && (!objName.isEmpty())) {
                attribName = String.format("%s[%s]", objName, attribName);
            }
            loadKeyValuePairForEncoding(attribName, pair.getValue(), objectList, processed);
        }
    }

    /**
     * Converts a given object to a form encoded map
     * @param objName Name of the object
     * @param obj The object to convert into a map
     * @param objectList The object list to populate
     * @param processed List of object hashCodes that are already parsed
     */
    private static void objectToList(
            String objName, Object obj, List<SimpleEntry<String,Object>> objectList, HashSet<Integer> processed) {
        // Null values need not to be processed
        if(obj == null) {
            return;
        }

        // Wrapper types are autoboxed, so reference checking is not needed
        if (!isWrapperType(obj.getClass())) {
            // Avoid infinite recursion
            if (processed.contains(objName.hashCode())) {
                return;
            }
            processed.add(objName.hashCode());
        }

        // Process arrays
        if (obj instanceof Collection<?>) {
            objectToList(objName, (Collection<?>) obj, objectList,  processed);
        } else if (obj.getClass().isArray()) {
            // Process array

            Object[] array = (Object[]) obj;
            // Append all elements in the array into a string
            int index = 0;
            for (Object element : array) {
                // Load key value pair
                String key = String.format("%s[%d]", objName, index++);
                loadKeyValuePairForEncoding(key, element, objectList, processed);
            }
        } else if (obj instanceof Map) {
            objectToList(objName, (Map<?, ?>) obj, objectList,  processed);
        } else {
            // Process objects
            // Invoke getter methods
            Method[] methods = obj.getClass().getMethods();
            for (Method method : methods) {
                // Is a getter?
                if ((method.getParameterTypes().length != 0) || (!method.getName().startsWith("get"))) {
                    continue;
                }

                // Get Json attribute name
                Annotation getterAnnotation = method.getAnnotation(JsonGetter.class);
                if (getterAnnotation == null) {
                    continue;
                }

                // Load key name
                String attribName = ((JsonGetter) getterAnnotation).value();
                if ((objName != null) && (!objName.isEmpty())) {
                    attribName = String.format("%s[%s]", objName, attribName);
                }

                try {
                    // Load key value pair
                    Object value = method.invoke(obj);
                        loadKeyValuePairForEncoding(attribName, value, objectList, processed);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    // This block only calls getter methods.
                    // These getters do not throw any exception ruling out invocationTargetException.
                    // The getters are public so there is no chance of an IllegalAccessException
                    // Steps we've followed ensure that the object has the specified method.
                }
            }
        }
    }

    /**
     * While processing objects to map, decides whether to perform recursion or load value
     * @param key The key for creating key value pair
     * @param value The value to process against the given key
     * @param objectList The object list to process with key value pair
     * @param processed List of processed objects hashCodes
     */
    private static void loadKeyValuePairForEncoding(
            String key, Object value, List<SimpleEntry<String, Object>> objectList, HashSet<Integer> processed) {
        if (value == null) {
            return;
        }
        if (isWrapperType(value)) {
            objectList.add(new SimpleEntry<String, Object>(key, value));
        } else if (value instanceof UUID) {
            // UUIDs can be converted to string
            objectList.add( new SimpleEntry<String, Object>(key, value.toString()));
        } else {
            objectToList(key, value, objectList, processed);
        }
    }

    /**
     * List of classes that are wrapped directly. This information is needed when
     * traversing object trees for reference matching
     */
    private static final Set<Object> WRAPPER_TYPES = new HashSet<Object>(Arrays.asList(
            Boolean.class, Character.class, Byte.class, Short.class, String.class,
            Integer.class, Long.class, Float.class, Double.class, Void.class, File.class, 
            MultipartWrapper.class, MultipartFileWrapper.class));

    /**
     * Check if the given object can be wrapped directly
     * @param object The given object
     * @return true if the class is an autoboxed class e.g., Integer
     */
    private static boolean isWrapperType(Object object) {
        return WRAPPER_TYPES.contains(object.getClass()) || object.getClass().isPrimitive() || object.getClass().isEnum();
    }
}
