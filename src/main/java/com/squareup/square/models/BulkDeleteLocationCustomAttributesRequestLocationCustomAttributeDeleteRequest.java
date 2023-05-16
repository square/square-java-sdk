
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for BulkDeleteLocationCustomAttributesRequestLocationCustomAttributeDeleteRequest type.
 */
public class BulkDeleteLocationCustomAttributesRequestLocationCustomAttributeDeleteRequest {
    private final String key;

    /**
     * Initialization constructor.
     * @param  key  String value for key.
     */
    @JsonCreator
    public BulkDeleteLocationCustomAttributesRequestLocationCustomAttributeDeleteRequest(
            @JsonProperty("key") String key) {
        this.key = key;
    }

    /**
     * Getter for Key.
     * The key of the associated custom attribute definition. Represented as a qualified key if the
     * requesting app is not the definition owner.
     * @return Returns the String
     */
    @JsonGetter("key")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getKey() {
        return key;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BulkDeleteLocationCustomAttributesRequestLocationCustomAttributeDeleteRequest)) {
            return false;
        }
        BulkDeleteLocationCustomAttributesRequestLocationCustomAttributeDeleteRequest other =
                (BulkDeleteLocationCustomAttributesRequestLocationCustomAttributeDeleteRequest) obj;
        return Objects.equals(key, other.key);
    }

    /**
     * Converts this BulkDeleteLocationCustomAttributesRequestLocationCustomAttributeDeleteRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkDeleteLocationCustomAttributesRequestLocationCustomAttributeDeleteRequest ["
                + "key=" + key + "]";
    }

    /**
     * Builds a new {@link BulkDeleteLocationCustomAttributesRequestLocationCustomAttributeDeleteRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkDeleteLocationCustomAttributesRequestLocationCustomAttributeDeleteRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .key(getKey());
        return builder;
    }

    /**
     * Class to build instances of {@link BulkDeleteLocationCustomAttributesRequestLocationCustomAttributeDeleteRequest}.
     */
    public static class Builder {
        private String key;



        /**
         * Setter for key.
         * @param  key  String value for key.
         * @return Builder
         */
        public Builder key(String key) {
            this.key = key;
            return this;
        }

        /**
         * Builds a new {@link
         * BulkDeleteLocationCustomAttributesRequestLocationCustomAttributeDeleteRequest} object
         * using the set fields.
         * @return {@link BulkDeleteLocationCustomAttributesRequestLocationCustomAttributeDeleteRequest}
         */
        public BulkDeleteLocationCustomAttributesRequestLocationCustomAttributeDeleteRequest build() {
            return new BulkDeleteLocationCustomAttributesRequestLocationCustomAttributeDeleteRequest(
                    key);
        }
    }
}
