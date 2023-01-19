
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
 * This is a model class for UpsertLocationCustomAttributeRequest type.
 */
public class UpsertLocationCustomAttributeRequest {
    private final CustomAttribute customAttribute;
    private final OptionalNullable<String> idempotencyKey;

    /**
     * Initialization constructor.
     * @param  customAttribute  CustomAttribute value for customAttribute.
     * @param  idempotencyKey  String value for idempotencyKey.
     */
    @JsonCreator
    public UpsertLocationCustomAttributeRequest(
            @JsonProperty("custom_attribute") CustomAttribute customAttribute,
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.customAttribute = customAttribute;
        this.idempotencyKey = OptionalNullable.of(idempotencyKey);
    }

    /**
     * Internal initialization constructor.
     */
    protected UpsertLocationCustomAttributeRequest(CustomAttribute customAttribute,
            OptionalNullable<String> idempotencyKey) {
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

    @Override
    public int hashCode() {
        return Objects.hash(customAttribute, idempotencyKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpsertLocationCustomAttributeRequest)) {
            return false;
        }
        UpsertLocationCustomAttributeRequest other = (UpsertLocationCustomAttributeRequest) obj;
        return Objects.equals(customAttribute, other.customAttribute)
            && Objects.equals(idempotencyKey, other.idempotencyKey);
    }

    /**
     * Converts this UpsertLocationCustomAttributeRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpsertLocationCustomAttributeRequest [" + "customAttribute=" + customAttribute
                + ", idempotencyKey=" + idempotencyKey + "]";
    }

    /**
     * Builds a new {@link UpsertLocationCustomAttributeRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpsertLocationCustomAttributeRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(customAttribute);
        builder.idempotencyKey = internalGetIdempotencyKey();
        return builder;
    }

    /**
     * Class to build instances of {@link UpsertLocationCustomAttributeRequest}.
     */
    public static class Builder {
        private CustomAttribute customAttribute;
        private OptionalNullable<String> idempotencyKey;

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
         * Builds a new {@link UpsertLocationCustomAttributeRequest} object using the set fields.
         * @return {@link UpsertLocationCustomAttributeRequest}
         */
        public UpsertLocationCustomAttributeRequest build() {
            return new UpsertLocationCustomAttributeRequest(customAttribute, idempotencyKey);
        }
    }
}
