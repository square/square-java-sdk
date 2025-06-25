package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for BulkDeleteOrderCustomAttributesRequestDeleteCustomAttribute type.
 */
public class BulkDeleteOrderCustomAttributesRequestDeleteCustomAttribute {
    private final String key;
    private final String orderId;

    /**
     * Initialization constructor.
     * @param  orderId  String value for orderId.
     * @param  key  String value for key.
     */
    @JsonCreator
    public BulkDeleteOrderCustomAttributesRequestDeleteCustomAttribute(
            @JsonProperty("order_id") String orderId, @JsonProperty("key") String key) {
        this.key = key;
        this.orderId = orderId;
    }

    /**
     * Getter for Key.
     * The key of the custom attribute to delete. This key must match the key of an existing custom
     * attribute definition.
     * @return Returns the String
     */
    @JsonGetter("key")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getKey() {
        return key;
    }

    /**
     * Getter for OrderId.
     * The ID of the target [order](entity:Order).
     * @return Returns the String
     */
    @JsonGetter("order_id")
    public String getOrderId() {
        return orderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, orderId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BulkDeleteOrderCustomAttributesRequestDeleteCustomAttribute)) {
            return false;
        }
        BulkDeleteOrderCustomAttributesRequestDeleteCustomAttribute other =
                (BulkDeleteOrderCustomAttributesRequestDeleteCustomAttribute) obj;
        return Objects.equals(key, other.key) && Objects.equals(orderId, other.orderId);
    }

    /**
     * Converts this BulkDeleteOrderCustomAttributesRequestDeleteCustomAttribute into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkDeleteOrderCustomAttributesRequestDeleteCustomAttribute [" + "orderId=" + orderId + ", key=" + key
                + "]";
    }

    /**
     * Builds a new {@link BulkDeleteOrderCustomAttributesRequestDeleteCustomAttribute.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkDeleteOrderCustomAttributesRequestDeleteCustomAttribute.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(orderId).key(getKey());
        return builder;
    }

    /**
     * Class to build instances of {@link BulkDeleteOrderCustomAttributesRequestDeleteCustomAttribute}.
     */
    public static class Builder {
        private String orderId;
        private String key;

        /**
         * Initialization constructor.
         * @param  orderId  String value for orderId.
         */
        public Builder(String orderId) {
            this.orderId = orderId;
        }

        /**
         * Setter for orderId.
         * @param  orderId  String value for orderId.
         * @return Builder
         */
        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

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
         * Builds a new {@link BulkDeleteOrderCustomAttributesRequestDeleteCustomAttribute} object
         * using the set fields.
         * @return {@link BulkDeleteOrderCustomAttributesRequestDeleteCustomAttribute}
         */
        public BulkDeleteOrderCustomAttributesRequestDeleteCustomAttribute build() {
            return new BulkDeleteOrderCustomAttributesRequestDeleteCustomAttribute(orderId, key);
        }
    }
}
