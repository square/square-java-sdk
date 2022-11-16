
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for BulkUpsertCustomerCustomAttributesRequestCustomerCustomAttributeUpsertRequest type.
 */
public class BulkUpsertCustomerCustomAttributesRequestCustomerCustomAttributeUpsertRequest {
    private final String customerId;
    private final CustomAttribute customAttribute;
    private final OptionalNullable<String> idempotencyKey;

    /**
     * Initialization constructor.
     * @param  customerId  String value for customerId.
     * @param  customAttribute  CustomAttribute value for customAttribute.
     * @param  idempotencyKey  String value for idempotencyKey.
     */
    @JsonCreator
    public BulkUpsertCustomerCustomAttributesRequestCustomerCustomAttributeUpsertRequest(
            @JsonProperty("customer_id") String customerId,
            @JsonProperty("custom_attribute") CustomAttribute customAttribute,
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.customerId = customerId;
        this.customAttribute = customAttribute;
        this.idempotencyKey = OptionalNullable.of(idempotencyKey);
    }

    /**
     * Internal initialization constructor.
     */
    protected BulkUpsertCustomerCustomAttributesRequestCustomerCustomAttributeUpsertRequest(
            String customerId, CustomAttribute customAttribute,
            OptionalNullable<String> idempotencyKey) {
        this.customerId = customerId;
        this.customAttribute = customAttribute;
        this.idempotencyKey = idempotencyKey;
    }

    /**
     * Getter for CustomerId.
     * The ID of the target [customer profile]($m/Customer).
     * @return Returns the String
     */
    @JsonGetter("customer_id")
    public String getCustomerId() {
        return customerId;
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
     * A unique identifier for this individual upsert request, used to ensure idempotency. For more
     * information, see
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
     * A unique identifier for this individual upsert request, used to ensure idempotency. For more
     * information, see
     * [Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency).
     * @return Returns the String
     */
    @JsonIgnore
    public String getIdempotencyKey() {
        return OptionalNullable.getFrom(idempotencyKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customAttribute, idempotencyKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BulkUpsertCustomerCustomAttributesRequestCustomerCustomAttributeUpsertRequest)) {
            return false;
        }
        BulkUpsertCustomerCustomAttributesRequestCustomerCustomAttributeUpsertRequest other =
                (BulkUpsertCustomerCustomAttributesRequestCustomerCustomAttributeUpsertRequest) obj;
        return Objects.equals(customerId, other.customerId)
            && Objects.equals(customAttribute, other.customAttribute)
            && Objects.equals(idempotencyKey, other.idempotencyKey);
    }

    /**
     * Converts this BulkUpsertCustomerCustomAttributesRequestCustomerCustomAttributeUpsertRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkUpsertCustomerCustomAttributesRequestCustomerCustomAttributeUpsertRequest ["
                + "customerId=" + customerId + ", customAttribute=" + customAttribute
                + ", idempotencyKey=" + idempotencyKey + "]";
    }

    /**
     * Builds a new {@link BulkUpsertCustomerCustomAttributesRequestCustomerCustomAttributeUpsertRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkUpsertCustomerCustomAttributesRequestCustomerCustomAttributeUpsertRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(customerId, customAttribute);
        builder.idempotencyKey = internalGetIdempotencyKey();
        return builder;
    }

    /**
     * Class to build instances of {@link BulkUpsertCustomerCustomAttributesRequestCustomerCustomAttributeUpsertRequest}.
     */
    public static class Builder {
        private String customerId;
        private CustomAttribute customAttribute;
        private OptionalNullable<String> idempotencyKey;

        /**
         * Initialization constructor.
         * @param  customerId  String value for customerId.
         * @param  customAttribute  CustomAttribute value for customAttribute.
         */
        public Builder(String customerId, CustomAttribute customAttribute) {
            this.customerId = customerId;
            this.customAttribute = customAttribute;
        }

        /**
         * Setter for customerId.
         * @param  customerId  String value for customerId.
         * @return Builder
         */
        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
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
         * Builds a new {@link
         * BulkUpsertCustomerCustomAttributesRequestCustomerCustomAttributeUpsertRequest} object
         * using the set fields.
         * @return {@link BulkUpsertCustomerCustomAttributesRequestCustomerCustomAttributeUpsertRequest}
         */
        public BulkUpsertCustomerCustomAttributesRequestCustomerCustomAttributeUpsertRequest build() {
            return new BulkUpsertCustomerCustomAttributesRequestCustomerCustomAttributeUpsertRequest(
                    customerId, customAttribute, idempotencyKey);
        }
    }
}
