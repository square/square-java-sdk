package com.squareup.square.http;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Class for creating and managing HTTP Headers.
 */
public class Headers {
    private Map<String, List<String>> headers;
    
    /**
     * Default constructor
     */
    public Headers() {
        this.headers = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    }

    /**
     * Constructor that creates a new instance using a given Map
     * @param headers The Map to use for creating an instance of this class
     */
    public Headers(Map<String, List<String>> headers) {
        this.headers = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, List<String>> kv : headers.entrySet()) {
            this.headers.put(kv.getKey(), kv.getValue());
        }
    }

    /**
     * Copy Constructor
     */
    public Headers(Headers h) {
        this.headers = cloneHeaderMap(h.headers);
    }

    /**
     * Use to check if the given name is present in headers
     * @param headerName
     * @return true if headerName is found, false otherwise
     */
    public boolean has(String headerName) {
        return this.headers.containsKey(headerName);
    }	

    /**
     * Returns a Set containing all header names
     * @return A Set containing all header names
     */
    public Set<String> names() {
        return headers.keySet();
    }
    
    /**
     * Returns the first value associated with a given header name, or null if the header name is not found
     * @param headerName The header name to find the associated value for
     * @return The first value associated with the given header name, or null if the header name is not found
     */
    public String value(String headerName) {
        if (headers.containsKey(headerName)) {
            return headers.get(headerName).get(0);
        } else {
            return null;
        }
    }
    
    /**
     * Returns a List of all values associated with a given header name, or null if the header name is not found
     * @param headerName The header name to find the associated values for
     * @return A List of values associated with the given header name, or null if the header name is not found
     */
    public List<String> values(String headerName) {
        if (headers.containsKey(headerName)) {
            return headers.get(headerName);
        } else {
            return null;
        }
    }
    
    /**
     * Returns a Map of the headers, giving only one value for each header name
     * @return A Map of header names and values
     */
    public Map<String, String> asSimpleMap() {
        Map<String, String> copy = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, List<String>> kv : this.headers.entrySet()) {
            if (kv.getValue() != null) {
                copy.put(kv.getKey(), kv.getValue().get(0));
            }
        }
        
        return copy;
    }

    /**
     * Returns a simulated MultiMap of the headers
     * @return A Map of header names and values
     */
    public Map<String, List<String>> asMultimap() {
        return cloneHeaderMap(this.headers);
    }

    /**
     * Clones a header map
     * @param headerMap A Map containing header names and values as Entry pairs
     * @return A Map of header names and values
     */
    private static Map<String, List<String>> cloneHeaderMap(Map<String, List<String>> headerMap) {
        Map<String, List<String>> copy = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, List<String>> kv : headerMap.entrySet()) {
            if (kv.getValue() != null) {
                copy.put(kv.getKey(), kv.getValue());
            }
        }
        
        return copy;
    }

    /**
     * Adds a value for a header name to this object.
     * <p>
     * Neither headerName nor value can be null
     * @param headerName The header name to add the value against
     * @param value The value to add
     */
    public void add(String headerName, Object value) {
        if (headerName == null || value == null) {
            return;
        }
        
        if (this.headers.containsKey(headerName)) {
            this.headers.get(headerName).add(String.valueOf(value));
        } else {
            List<String> values = new ArrayList<String>();
            values.add(String.valueOf(value));
            this.headers.put(headerName, values);
        }
    }
    
    /**
     * Adds a List of values for a header name to this object.
     * <p>
     * Neither headerName nor values can be null
     * @param headerName The header name to add the values against
     * @param values The List of values to add
     */
    public void add(String headerName, List<Object> values) {
        if (headerName == null || values == null) {
            return;
        }
        
        if (this.headers.containsKey(headerName)) {
            for (Object value : values) {
                if (value != null) {
                    this.headers.get(headerName).add(String.valueOf(value));
                }
            }
        } else {
            List<String> copyOfValues = new ArrayList<String>();
            for (Object value : values) {
                if (value != null) {
                    copyOfValues.add(String.valueOf(value));
                }
            }
            
            if (!copyOfValues.isEmpty()) {
                this.headers.put(headerName, copyOfValues);
            }
        }
    }

    /**
     * Adds values from a Map to this object
     * @param headers A Map containing header names and values as Entry pairs
     */
    public void addAllFromMap(Map<String, String> headers) {
        for (Map.Entry<String, String> kv : headers.entrySet()) {
            this.add(kv.getKey(), kv.getValue());
        }
    }

    /**
     * Adds values from a simulated Multi-Map to this object
     * @param headers A Map containing header names and values as Entry pairs
     */
    public void addAllFromMultiMap(Map<String, List<String>> headers) {
        for (Map.Entry<String, List<String>> kv : headers.entrySet()) {
            this.add(kv.getKey(), kv.getValue());
        }
    }

    /**
     * Adds all the entries in a Headers object to this object
     * @param headers The object whose values are to be added to this object
     */
    public void addAll(Headers headers) {
        for (Map.Entry<String, List<String>> kv : headers.asMultimap().entrySet()) {
            this.add(kv.getKey(), kv.getValue());
        }		
    }
    
    /**
     * Removes the mapping for a header name if it is present. 
     * <p>
     * Returns the value to which this map previously associated the key, or null if the map contained no mapping for
     * the key.
     * @param headerName The header name to remove the associated values for
     * @return A List of values associated with the given header name, or null if the header name is not found
     */
    public List<String> remove(String headerName) {
        if (headers.containsKey(headerName)) {
            return headers.remove(headerName);
        } else {
            return null;
        }
    }	
}
