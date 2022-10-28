
package com.squareup.square.utilities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.JsonNode;
import com.squareup.square.ApiHelper;
import io.apimatic.core.utilities.CoreJsonObject;
import java.io.IOException;

/**
 * This is a wrapper class for JSON object.
 */
public class JsonObject extends CoreJsonObject {

    /**
     * Initialization private constructor.
     * @param jsonNode The JSON of type JsonNode.
     */
    @JsonCreator
    private JsonObject(JsonNode jsonNode) {
        super(jsonNode);
    }
    
    /**
     * Initializes JsonObject with provided JSON.
     * @param jsonString The JSON string.
     * @return The JsonObject instance.
     * @throws IOException signals that provided JSON string does not contain a valid JSON object.
     */
    public static JsonObject fromJsonString(String jsonString) throws IOException {
        if (jsonString == null) {
            return new JsonObject(null);
        }
        JsonNode node = ApiHelper.mapper.readTree(jsonString);
        if (node.isObject()) {
            return new JsonObject(node);
        }
        throw new IOException("Provided JSON string must contain a valid JSON object.");
    }
    
    /**
     * Converts the JSON into string.
     * @return String representation of JSON
     */
    public String toString() {
        return super.toString();
    }
}