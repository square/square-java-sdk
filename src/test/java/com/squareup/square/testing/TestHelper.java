
package com.squareup.square.testing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.squareup.square.ApiHelper;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**  
 * Contains utility methods for comparing objects, arrays and files.
 *
 */
public class TestHelper {
    /**
    *GUID to represent NUll string.
    */
    public static final String nullString = "b9cb2f80-1b64-43ee-a6da-71f7ef686fa9";

    /**
     * Modify a json String according to a given TypeReference, 
     * ensuring that inner fields are dealt with properly.
     *
     * @param json The json String to modify
     * @param typeReference The TypeReference to use
     * @return The modified json String
     */
    public static <T extends Object> String prepareForComparison(String json, 
        TypeReference<T> typeReference) throws JsonProcessingException, IOException {
        return ApiHelper.serialize(ApiHelper.deserialize(json, typeReference));
    }

    /**
     * Convert an InputStream to a String (utility function).
     * @param is Input stream to read from
     * @return All data
     */
    public static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is);
        String str = s.useDelimiter("\\A").hasNext() ? s.next() : "";
        s.close();
        return str;
    }

    /**
     * Utility to delegate call to suitable method.
     * @param leftObject Left array as a JSON string
     * @param rightObject Right array as a JSON string
     * @param checkValues Check primitive values for equality?
     * @param allowExtra Are extra elements allowed in right array?
     * @param isOrdered Should elements in right be compared in order to left?
     * @return True if it is a subset
     * @throws IOException if deserialization got failed
     */
    public static boolean isProperSubsetOf(String leftObject, String rightObject,
            boolean checkValues, boolean allowExtra, boolean isOrdered) throws IOException {
        JsonNode leftNode = ApiHelper.mapper.readTree(leftObject);
        if (leftNode.isObject()) {
            return isJsonObjectProperSubsetOf(leftObject, rightObject, checkValues, allowExtra,
                    isOrdered);
        } else if (leftNode.isArray()) {
            if (leftNode.get(0).isArray()) {
                return isArrayOfArrayOfJsonObjectsProperSubsetOf(leftObject, rightObject,
                        checkValues, allowExtra, isOrdered);
            }
            return isArrayOfJsonObjectsProperSubsetOf(leftObject, rightObject, checkValues,
                    allowExtra, isOrdered);
        }
        throw new IOException("Unable to find suitable method call");
    }

    /**
     * Recursively check whether the left tree is a proper subset of the right tree.
     * @param leftTree Left tree
     * @param rightTree Right tree
     * @param checkValues Check primitive values for equality?
     * @param allowExtra Are extra elements allowed in right array?
     * @param isOrdered Should elements in right be compared in order to left?
     * @return <tt>true</tt> if left left tree is a proper subset of right tree
     */
    @SuppressWarnings({ "unchecked", "rawtypes", "unused" })
    private static boolean isProperSubsetOf(Map<String, Object> leftTree,
        Map<String, Object> rightTree, boolean checkValues, boolean allowExtra, boolean isOrdered) {
        for (Iterator<String> iterator = leftTree.keySet().iterator(); iterator.hasNext();) {
            String key = iterator.next();
            Object leftVal = leftTree.get(key);
            Object rightVal = rightTree.get(key);

            // Check if key exists
            if (!rightTree.containsKey(key)) {
                return false;
            }
            if (leftVal instanceof Map) {
                // If left value is tree, right value should be be tree too
                if (rightVal instanceof Map) {
                    if (!isProperSubsetOf(
                            (Map<String, Object>) leftVal,
                            (Map<String, Object>) rightVal,
                            checkValues, allowExtra, isOrdered)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                // Value comparison if checkValues 
                if (checkValues) {
                    // If left value is a primitive, check if it equals right value
                    if (leftVal == null) {
                        if (rightVal != null) {
                            return false;
                        }
                    } else if (leftVal instanceof List) {
                        if (!(rightVal instanceof List)) {
                            return false;
                        }
                        // If both lists are empty then move on
                        if (((List) leftVal).isEmpty() && (((List) rightVal).isEmpty())) {
                            continue;
                        }
                        if (((List) leftVal).get(0) instanceof Map) {
                            if (!isArrayOfJsonObjectsProperSubsetOf(
                                    (List<LinkedHashMap<String, Object>>) leftVal,
                                    (List<LinkedHashMap<String, Object>>) rightVal,
                                    checkValues, allowExtra, isOrdered)) {
                                return false;
                            }
                        } else {
                            if (!isListProperSubsetOf(
                                    (List<Object>) leftVal,
                                    (List<Object>) rightVal,
                                    allowExtra, isOrdered)) {
                                return false;
                            }
                        }
                    } else if (!leftVal.equals((rightTree).get(key)) && leftVal != nullString) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Recursively check whether the left JSON object is a proper subset of the right JSON object.
     * @param leftObject Left JSON object as string
     * @param rightObject Right JSON object as string
     * @param checkValues Check primitive values for equality? 
     * @return <tt>true</tt> if left left JSON object is a proper subset of right JSON object
     */
    public static boolean isJsonObjectProperSubsetOf(String leftObject, String rightObject, 
            boolean checkValues, boolean allowExtra, boolean isOrdered) throws IOException {
        return isProperSubsetOf(ApiHelper.deserialize(leftObject),
            ApiHelper.deserialize(rightObject), checkValues, allowExtra, isOrdered);
    }

    /**
     * Check if left array of objects is a subset of right array.
     * @param leftObject Left array as a JSON string
     * @param rightObject Right array as a JSON string
     * @param checkValues Check primitive values for equality?
     * @param allowExtra Are extra elements allowed in right array?
     * @param isOrdered Should elements in right be compared in order to left?
     * @return True if it is a subset
     * @throws IOException if deserialization got failed
     */
    public static boolean isArrayOfJsonObjectsProperSubsetOf(String leftObject, String rightObject, 
            boolean checkValues, boolean allowExtra, boolean isOrdered) throws IOException {
        // Deserialize left and right objects from their respective strings
        LinkedList<LinkedHashMap<String, Object>> obj = new 
            LinkedList<LinkedHashMap<String, Object>>();
        @SuppressWarnings("unchecked")
        LinkedList<LinkedHashMap<String, Object>> left = ApiHelper.deserialize(leftObject,
            obj.getClass());
        @SuppressWarnings("unchecked")
        LinkedList<LinkedHashMap<String, Object>> right = ApiHelper.deserialize(rightObject,
            obj.getClass());
        
        return isArrayOfJsonObjectsProperSubsetOf(left, right, checkValues, allowExtra, isOrdered);
    }

    /**
     * Check if left array of array of objects is a subset of right array of array of objects.
     * @param leftObject Left array as a JSON string
     * @param rightObject Right array as a JSON string
     * @param checkValues Check primitive values for equality?
     * @param allowExtra Are extra elements allowed in right array?
     * @param isOrdered Should elements in right be compared in order to left?
     * @return True if it is a subset
     * @throws IOException if deserialization got failed
     */
    public static boolean isArrayOfArrayOfJsonObjectsProperSubsetOf(String leftObject, String rightObject, 
            boolean checkValues, boolean allowExtra, boolean isOrdered) throws IOException {
        // Deserialize left and right objects from their respective strings
        LinkedList<LinkedList<LinkedHashMap<String, Object>>> obj = new 
                LinkedList<LinkedList<LinkedHashMap<String, Object>>>();
        @SuppressWarnings("unchecked")
        LinkedList<LinkedList<LinkedHashMap<String, Object>>> left = ApiHelper.deserialize(leftObject,
            obj.getClass());
        @SuppressWarnings("unchecked")
        LinkedList<LinkedList<LinkedHashMap<String, Object>>> right = ApiHelper.deserialize(rightObject,
            obj.getClass());
        
        return isArrayOfArrayOfJsonObjectsProperSubsetOf(left, right, checkValues, allowExtra, isOrdered);
    }

    /**
     * Check if left array of array of objects is a subset of right array of array of objects.
     * @param left Left array as a JSON string
     * @param right Right array as a JSON string
     * @param checkValues Check primitive values for equality?
     * @param allowExtra Are extra elements allowed in right array?
     * @param isOrdered Should elements in right be compared in order to left?
     * @return True if it is a subset
     */
    private static boolean isArrayOfArrayOfJsonObjectsProperSubsetOf(List<LinkedList<LinkedHashMap<String, Object>>> left, 
            List<LinkedList<LinkedHashMap<String, Object>>> right, 
            boolean checkValues, boolean allowExtra, boolean isOrdered) {
        if (!allowExtra && left.size() != right.size()) {
            return false;
        }
        
        // Create list iterators
        Iterator<LinkedList<LinkedHashMap<String, Object>>> leftIter = left.iterator();
        Iterator<LinkedList<LinkedHashMap<String, Object>>> rightIter = right.iterator();
        
        while (leftIter.hasNext()) {
            List<LinkedHashMap<String, Object>> leftTree = leftIter.next();
            boolean found = false;
            
            if (!isOrdered) {
                rightIter = right.iterator();
            }
            
            while (rightIter.hasNext()) {
                if (isArrayOfJsonObjectsProperSubsetOf(leftTree, rightIter.next(), checkValues, allowExtra, 
                    isOrdered)) {
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                return false;
            }
        }
        
        return true;
    }

    /**
     * Check if left array of objects is a subset of right array.
     * @param left Left array as a JSON string
     * @param right Right array as a JSON string
     * @param checkValues Check primitive values for equality?
     * @param allowExtra Are extra elements allowed in right array?
     * @param isOrdered Should elements in right be compared in order to left?
     * @return True if it is a subset
     */
    private static boolean isArrayOfJsonObjectsProperSubsetOf(
            List<LinkedHashMap<String, Object>> left, 
            List<LinkedHashMap<String, Object>> right, 
            boolean checkValues, boolean allowExtra, boolean isOrdered) {
        // Return false if size different and checking was strict
        if (!allowExtra && left.size() != right.size()) {
            return false;
        }
        
        // Create list iterators
        Iterator<LinkedHashMap<String, Object>> leftIter = left.iterator();
        Iterator<LinkedHashMap<String, Object>> rightIter = right.iterator();
        
        // Iterate left list and check if each value is present in the right list
        while (leftIter.hasNext()) {
            LinkedHashMap<String, Object> leftTree = leftIter.next();
            boolean found = false;
            
            if (!isOrdered) {
                rightIter = right.iterator();
            }
            
            while (rightIter.hasNext()) {
                if (isProperSubsetOf(leftTree, rightIter.next(), checkValues, allowExtra, 
                    isOrdered)) {
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                return false;
            }
        }
        
        return true;
    }

    /**
     * Check whether the a list is a subset of another list.
     * @param leftList Expected List
     * @param rightList List to check
     * @param allowExtra Are extras allowed in the list to check?
     * @param isOrdered Should checking be in order?
     * @return <tt>true</tt> if list is a subset of another list
     */
    private static boolean isListProperSubsetOf(List<Object> leftList, List<Object> rightList, 
            boolean allowExtra, boolean isOrdered) {
        if (isOrdered && !allowExtra) {
            return rightList.equals(leftList);
        } else if (isOrdered && allowExtra) {
            return rightList.subList(0, leftList.size()).equals(leftList);
        } else if (!isOrdered && !allowExtra) {
            return leftList.size() == rightList.size() && rightList.containsAll(leftList);
        } else if (!isOrdered && allowExtra) {
            return rightList.containsAll(leftList);
        }
        return true;
    }

    /**
     * Recursively check whether the left headers map is a proper subset of the right headers map.
     * @param leftTree Left headers map
     * @param rightTree Right headers map
     * @param checkValues Check header values for equality? 
     * @return <tt>true</tt> if left headers map is a proper subset of right headers map
     */
    public static boolean areHeadersProperSubsetOf(Map<String, String> leftTree, 
            Map<String, String> rightTree, boolean checkValues) {
        Map<String, Object> l = new TreeMap<String, Object>(String.CASE_INSENSITIVE_ORDER);
        Map<String, Object> r = new TreeMap<String, Object>(String.CASE_INSENSITIVE_ORDER);
        l.putAll(leftTree);
        r.putAll(rightTree);
        return isProperSubsetOf(l, r, checkValues, false, false);
    }

    /**
     * Compare two input streams.
     *
     * @param input1 First stream
     * @param input2 Second stream
     * @return true True if streams contain the same content
     * @throws IOException If error reading either stream
     */
    private static boolean isSameInputStream(InputStream input1, InputStream input2) 
            throws IOException {
        if (input1 == input2) {
            return true;
        }
        if (!(input1 instanceof BufferedInputStream)) {
            input1 = new BufferedInputStream(input1);
        }
        if (!(input2 instanceof BufferedInputStream)) {
            input2 = new BufferedInputStream(input2);
        }

        int ch = input1.read();
        while (ch != -1) {
            final int ch2 = input2.read();
            if (ch != ch2) {
                return false;
            }
            ch = input1.read();
        }

        final int ch2 = input2.read();
        return ch2 == -1;
    }

    /**
     * Compare the input stream to file byte-by-byte.
     * @param file First input
     * @param input Second input
     * @return true True if stream contains the same content as the file
     * @throws IOException If error reading either stream
     * @throws FileNotFoundException If file could not be opened
     */
    public static boolean isSameAsFile(String file, InputStream input) 
            throws FileNotFoundException, IOException {
        return isSameInputStream(new FileInputStream(getFile(file)), input);
    }

    /**
     * Downloads a given url and return a path to its local version.
     * Files are cached. Second call for the same URL will return cached
     * version. Files are deleted when VM exits.
     * @param urlString URL to download
     * @return Absolute path to the local downloaded version of file
     */
    public static File getFile(String urlString) throws IOException {
        String filename = "sdk_tests" + toSha1(urlString) + ".tmp";
        String tmpPath = System.getProperty("java.io.tmpdir");
        File f = new File(tmpPath, filename);
        
        // if file does not exist locally, download it
        if (!f.exists()) {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream in = connection.getInputStream();
            f.createNewFile();
            FileOutputStream out = new FileOutputStream(f);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            out.close();
            in.close();
            
            // when VM closes, temporary file should be deleted
            f.deleteOnExit();
        }
        return f;
    }

    /**
     * Get SHA1 hash of a string.
     * @param convertme The string to convert
     * @return SHA1 hash
     */
    private static String toSha1(String convertme) {
        byte[] data = convertme.getBytes();
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } 
        return byteArrayToHexString(md.digest(data));
    }

    /**
     * Convert byte array to the hexadecimal representation in string.
     * @param b Byte array
     * @return Hex representation in string
     */
    private static String byteArrayToHexString(byte[] b) {
        String result = "";
        for (int i = 0; i < b.length; i++) {
            result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
        }
        return result;
    }

    /**
     * Checks actual list against expected list to have same order and count 
     * and all corresponding values must be equal.
     * @param actual List of BigDecimal
     * @param expected List of BigDecimal
     * @return true if both lists are exactly same
     */
    public static boolean equalsBigDecimalList(List<BigDecimal> actual, List<BigDecimal> expected) {
        if (actual.size() != expected.size()) {
            return false;
        }

        for (int i = 0; i < actual.size(); i++) {
            if (actual.get(i).compareTo(expected.get(i)) != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks actual list against expected list, without considering order of elements
     * and actual list must have all the expected elements.
     * @param actual List of BigDecimal
     * @param expected List of BigDecimal
     * @return true if actual list is a super set of expected list
     */
    public static boolean containsBigDecimalList(List<BigDecimal> actual,
        List<BigDecimal> expected) {
        for (BigDecimal expectedValue : expected) {
            boolean found = false;
            for (BigDecimal actualValue : actual) {
                if (actualValue.compareTo(expectedValue) == 0) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
}
