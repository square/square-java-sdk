
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for UpsertCustomerCustomAttributeRequest type.
 */
public class UpsertCustomerCustomAttributeRequest {
    private final CustomAttribute customAttribute;
    private final String idempotencyKey;

    /**
     * Initialization constructor.
     * @param  customAttribute  CustomAttribute value for customAttribute.
     * @param  idempotencyKey  String value for idempotencyKey.
     */
    @JsonCreator
    public UpsertCustomerCustomAttributeRequest(
            @JsonProperty("custom_attribute") CustomAttribute customAttribute,
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.customAttribute = customAttribute;
        this.idempotencyKey = idempotencyKey;
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
     * Getter for IdempotencyKey.
     * A unique identifier for this request, used to ensure idempotency. For more information, see
     * [Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency).
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customAttribute, idempotencyKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpsertCustomerCustomAttributeRequest)) {
            return false;
        }
        UpsertCustomerCustomAttributeRequest other = (UpsertCustomerCustomAttributeRequest) obj;
        return Objects.equals(customAttribute, other.customAttribute)
            && Objects.equals(idempotencyKey, other.idempotencyKey);
    }

    /**
     * Converts this UpsertCustomerCustomAttributeRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpsertCustomerCustomAttributeRequest [" + "customAttribute=" + customAttribute
                + ", idempotencyKey=" + idempotencyKey + "]";
    }

    /**
     * Builds a new {@link UpsertCustomerCustomAttributeRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpsertCustomerCustomAttributeRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(customAttribute)
                .idempotencyKey(getIdempotencyKey());
        return builder;
    }

    /**
     * Class to build instances of {@link UpsertCustomerCustomAttributeRequest}.
     */
    public static class Builder {
        private CustomAttribute customAttribute;
        private String idempotencyKey;

        /**
         * Initialization constructor.
         * @param  customAttribute  CustomAttribute value for customAttribute.
         */
        public Builder(CustomAttribute customAttribute) {
            this.customAttribute = customAttribute;
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
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        /**
         * Builds a new {@link UpsertCustomerCustomAttributeRequest} object using the set fields.
         * @return {@link UpsertCustomerCustomAttributeRequest}
         */
        public UpsertCustomerCustomAttributeRequest build() {
            return new UpsertCustomerCustomAttributeRequest(customAttribute, idempotencyKey);
        }
    }
}
