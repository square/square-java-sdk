package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for BulkUpsertMerchantCustomAttributesResponseMerchantCustomAttributeUpsertResponse type.
 */
public class BulkUpsertMerchantCustomAttributesResponseMerchantCustomAttributeUpsertResponse {
    private final String merchantId;
    private final CustomAttribute customAttribute;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  merchantId  String value for merchantId.
     * @param  customAttribute  CustomAttribute value for customAttribute.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public BulkUpsertMerchantCustomAttributesResponseMerchantCustomAttributeUpsertResponse(
            @JsonProperty("merchant_id") String merchantId,
            @JsonProperty("custom_attribute") CustomAttribute customAttribute,
            @JsonProperty("errors") List<Error> errors) {
        this.merchantId = merchantId;
        this.customAttribute = customAttribute;
        this.errors = errors;
    }

    /**
     * Getter for MerchantId.
     * The ID of the merchant associated with the custom attribute.
     * @return Returns the String
     */
    @JsonGetter("merchant_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CustomAttribute getCustomAttribute() {
        return customAttribute;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred while processing the individual request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(merchantId, customAttribute, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BulkUpsertMerchantCustomAttributesResponseMerchantCustomAttributeUpsertResponse)) {
            return false;
        }
        BulkUpsertMerchantCustomAttributesResponseMerchantCustomAttributeUpsertResponse other =
                (BulkUpsertMerchantCustomAttributesResponseMerchantCustomAttributeUpsertResponse) obj;
        return Objects.equals(merchantId, other.merchantId)
                && Objects.equals(customAttribute, other.customAttribute)
                && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this BulkUpsertMerchantCustomAttributesResponseMerchantCustomAttributeUpsertResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkUpsertMerchantCustomAttributesResponseMerchantCustomAttributeUpsertResponse ["
                + "merchantId=" + merchantId + ", customAttribute=" + customAttribute + ", errors="
                + errors + "]";
    }

    /**
     * Builds a new {@link BulkUpsertMerchantCustomAttributesResponseMerchantCustomAttributeUpsertResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkUpsertMerchantCustomAttributesResponseMerchantCustomAttributeUpsertResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .merchantId(getMerchantId())
                .customAttribute(getCustomAttribute())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link BulkUpsertMerchantCustomAttributesResponseMerchantCustomAttributeUpsertResponse}.
     */
    public static class Builder {
        private String merchantId;
        private CustomAttribute customAttribute;
        private List<Error> errors;

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
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Builds a new {@link
         * BulkUpsertMerchantCustomAttributesResponseMerchantCustomAttributeUpsertResponse} object
         * using the set fields.
         * @return {@link BulkUpsertMerchantCustomAttributesResponseMerchantCustomAttributeUpsertResponse}
         */
        public BulkUpsertMerchantCustomAttributesResponseMerchantCustomAttributeUpsertResponse build() {
            return new BulkUpsertMerchantCustomAttributesResponseMerchantCustomAttributeUpsertResponse(
                    merchantId, customAttribute, errors);
        }
    }
}
