
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for BulkUpsertOrderCustomAttributesRequestUpsertCustomAttribute type.
 */
public class BulkUpsertOrderCustomAttributesRequestUpsertCustomAttribute {
    private final CustomAttribute customAttribute;
    private final OptionalNullable<String> idempotencyKey;
    private final String orderId;

    /**
     * Initialization constructor.
     * @param  customAttribute  CustomAttribute value for customAttribute.
     * @param  orderId  String value for orderId.
     * @param  idempotencyKey  String value for idempotencyKey.
     */
    @JsonCreator
    public BulkUpsertOrderCustomAttributesRequestUpsertCustomAttribute(
            @JsonProperty("custom_attribute") CustomAttribute customAttribute,
            @JsonProperty("order_id") String orderId,
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.customAttribute = customAttribute;
        this.idempotencyKey = OptionalNullable.of(idempotencyKey);
        this.orderId = orderId;
    }

    /**
     * Initialization constructor.
     * @param  customAttribute  CustomAttribute value for customAttribute.
     * @param  orderId  String value for orderId.
     * @param  idempotencyKey  String value for idempotencyKey.
     */

    protected BulkUpsertOrderCustomAttributesRequestUpsertCustomAttribute(
            CustomAttribute customAttribute, String orderId,
            OptionalNullable<String> idempotencyKey) {
        this.customAttribute = customAttribute;
        this.idempotencyKey = idempotencyKey;
        this.orderId = orderId;
    }

    /**
     * Getter for CustomAttribute.
     * A custom attribute value. Each custom attribute value has a corresponding
     * `CustomAttributeDefinition` object.
     * @return Returns the CustomAttribute
     */
    @JsonGetter("custom_attribute")
    public CustomAttribute getCustomAttribute() {
        return customAttribute;
    }

    /**
     * Internal Getter for IdempotencyKey.
     * A unique identifier for this request, used to ensure idempotency. For more information, see
     * [Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency).
     * @return Returns the Internal String
     */
    @JsonGetter("idempotency_key")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetIdempotencyKey() {
        return this.idempotencyKey;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique identifier for this request, used to ensure idempotency. For more information, see
     * [Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency).
     * @return Returns the String
     */
    @JsonIgnore
    public String getIdempotencyKey() {
        return OptionalNullable.getFrom(idempotencyKey);
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
        return Objects.hash(customAttribute, idempotencyKey, orderId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BulkUpsertOrderCustomAttributesRequestUpsertCustomAttribute)) {
            return false;
        }
        BulkUpsertOrderCustomAttributesRequestUpsertCustomAttribute other =
                (BulkUpsertOrderCustomAttributesRequestUpsertCustomAttribute) obj;
        return Objects.equals(customAttribute, other.customAttribute)
            && Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(orderId, other.orderId);
    }

    /**
     * Converts this BulkUpsertOrderCustomAttributesRequestUpsertCustomAttribute into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkUpsertOrderCustomAttributesRequestUpsertCustomAttribute [" + "customAttribute="
                + customAttribute + ", orderId=" + orderId + ", idempotencyKey=" + idempotencyKey
                + "]";
    }

    /**
     * Builds a new {@link BulkUpsertOrderCustomAttributesRequestUpsertCustomAttribute.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkUpsertOrderCustomAttributesRequestUpsertCustomAttribute.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(customAttribute, orderId);
        builder.idempotencyKey = internalGetIdempotencyKey();
        return builder;
    }

    /**
     * Class to build instances of {@link BulkUpsertOrderCustomAttributesRequestUpsertCustomAttribute}.
     */
    public static class Builder {
        private CustomAttribute customAttribute;
        private String orderId;
        private OptionalNullable<String> idempotencyKey;

        /**
         * Initialization constructor.
         * @param  customAttribute  CustomAttribute value for customAttribute.
         * @param  orderId  String value for orderId.
         */
        public Builder(CustomAttribute customAttribute, String orderId) {
            this.customAttribute = customAttribute;
            this.orderId = orderId;
        }

        /**
         * Setter for customAttribute.
         * @param  customAttribute  CustomAttribute value for customAttribute.
         * @return Builder
         */
        public Builder customAttribute(CustomAttribute customAttribute) {
            this.customAttribute = customAttribute;
            return this;
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
         * Setter for idempotencyKey.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = OptionalNullable.of(idempotencyKey);
            return this;
        }

        /**
         * UnSetter for idempotencyKey.
         * @return Builder
         */
        public Builder unsetIdempotencyKey() {
            idempotencyKey = null;
            return this;
        }

        /**
         * Builds a new {@link BulkUpsertOrderCustomAttributesRequestUpsertCustomAttribute} object
         * using the set fields.
         * @return {@link BulkUpsertOrderCustomAttributesRequestUpsertCustomAttribute}
         */
        public BulkUpsertOrderCustomAttributesRequestUpsertCustomAttribute build() {
            return new BulkUpsertOrderCustomAttributesRequestUpsertCustomAttribute(customAttribute,
                    orderId, idempotencyKey);
        }
    }
}
