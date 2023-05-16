
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
 * This is a model class for BulkUpsertMerchantCustomAttributesRequestMerchantCustomAttributeUpsertRequest type.
 */
public class BulkUpsertMerchantCustomAttributesRequestMerchantCustomAttributeUpsertRequest {
    private final String merchantId;
    private final CustomAttribute customAttribute;
    private final OptionalNullable<String> idempotencyKey;

    /**
     * Initialization constructor.
     * @param  merchantId  String value for merchantId.
     * @param  customAttribute  CustomAttribute value for customAttribute.
     * @param  idempotencyKey  String value for idempotencyKey.
     */
    @JsonCreator
    public BulkUpsertMerchantCustomAttributesRequestMerchantCustomAttributeUpsertRequest(
            @JsonProperty("merchant_id") String merchantId,
            @JsonProperty("custom_attribute") CustomAttribute customAttribute,
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.merchantId = merchantId;
        this.customAttribute = customAttribute;
        this.idempotencyKey = OptionalNullable.of(idempotencyKey);
    }

    /**
     * Internal initialization constructor.
     */
    protected BulkUpsertMerchantCustomAttributesRequestMerchantCustomAttributeUpsertRequest(
            String merchantId, CustomAttribute customAttribute,
            OptionalNullable<String> idempotencyKey) {
        this.merchantId = merchantId;
        this.customAttribute = customAttribute;
        this.idempotencyKey = idempotencyKey;
    }

    /**
     * Getter for MerchantId.
     * The ID of the target [merchant](entity:Merchant).
     * @return Returns the String
     */
    @JsonGetter("merchant_id")
    public String getMerchantId() {
        return merchantId;
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
        return Objects.hash(merchantId, customAttribute, idempotencyKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BulkUpsertMerchantCustomAttributesRequestMerchantCustomAttributeUpsertRequest)) {
            return false;
        }
        BulkUpsertMerchantCustomAttributesRequestMerchantCustomAttributeUpsertRequest other =
                (BulkUpsertMerchantCustomAttributesRequestMerchantCustomAttributeUpsertRequest) obj;
        return Objects.equals(merchantId, other.merchantId)
            && Objects.equals(customAttribute, other.customAttribute)
            && Objects.equals(idempotencyKey, other.idempotencyKey);
    }

    /**
     * Converts this BulkUpsertMerchantCustomAttributesRequestMerchantCustomAttributeUpsertRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkUpsertMerchantCustomAttributesRequestMerchantCustomAttributeUpsertRequest ["
                + "merchantId=" + merchantId + ", customAttribute=" + customAttribute
                + ", idempotencyKey=" + idempotencyKey + "]";
    }

    /**
     * Builds a new {@link BulkUpsertMerchantCustomAttributesRequestMerchantCustomAttributeUpsertRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkUpsertMerchantCustomAttributesRequestMerchantCustomAttributeUpsertRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(merchantId, customAttribute);
        builder.idempotencyKey = internalGetIdempotencyKey();
        return builder;
    }

    /**
     * Class to build instances of {@link BulkUpsertMerchantCustomAttributesRequestMerchantCustomAttributeUpsertRequest}.
     */
    public static class Builder {
        private String merchantId;
        private CustomAttribute customAttribute;
        private OptionalNullable<String> idempotencyKey;

        /**
         * Initialization constructor.
         * @param  merchantId  String value for merchantId.
         * @param  customAttribute  CustomAttribute value for customAttribute.
         */
        public Builder(String merchantId, CustomAttribute customAttribute) {
            this.merchantId = merchantId;
            this.customAttribute = customAttribute;
        }

        /**
         * Setter for merchantId.
         * @param  merchantId  String value for merchantId.
         * @return Builder
         */
        public Builder merchantId(String merchantId) {
            this.merchantId = merchantId;
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
         * BulkUpsertMerchantCustomAttributesRequestMerchantCustomAttributeUpsertRequest} object
         * using the set fields.
         * @return {@link BulkUpsertMerchantCustomAttributesRequestMerchantCustomAttributeUpsertRequest}
         */
        public BulkUpsertMerchantCustomAttributesRequestMerchantCustomAttributeUpsertRequest build() {
            return new BulkUpsertMerchantCustomAttributesRequestMerchantCustomAttributeUpsertRequest(
                    merchantId, customAttribute, idempotencyKey);
        }
    }
}
