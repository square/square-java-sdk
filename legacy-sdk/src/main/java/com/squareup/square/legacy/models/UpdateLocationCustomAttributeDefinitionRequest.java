package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for UpdateLocationCustomAttributeDefinitionRequest type.
 */
public class UpdateLocationCustomAttributeDefinitionRequest {
    private final CustomAttributeDefinition customAttributeDefinition;
    private final OptionalNullable<String> idempotencyKey;

    /**
     * Initialization constructor.
     * @param  customAttributeDefinition  CustomAttributeDefinition value for
     *         customAttributeDefinition.
     * @param  idempotencyKey  String value for idempotencyKey.
     */
    @JsonCreator
    public UpdateLocationCustomAttributeDefinitionRequest(
            @JsonProperty("custom_attribute_definition") CustomAttributeDefinition customAttributeDefinition,
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.customAttributeDefinition = customAttributeDefinition;
        this.idempotencyKey = OptionalNullable.of(idempotencyKey);
    }

    /**
     * Initialization constructor.
     * @param  customAttributeDefinition  CustomAttributeDefinition value for
     *         customAttributeDefinition.
     * @param  idempotencyKey  String value for idempotencyKey.
     */
    protected UpdateLocationCustomAttributeDefinitionRequest(
            CustomAttributeDefinition customAttributeDefinition, OptionalNullable<String> idempotencyKey) {
        this.customAttributeDefinition = customAttributeDefinition;
        this.idempotencyKey = idempotencyKey;
    }

    /**
     * Getter for CustomAttributeDefinition.
     * Represents a definition for custom attribute values. A custom attribute definition specifies
     * the key, visibility, schema, and other properties for a custom attribute.
     * @return Returns the CustomAttributeDefinition
     */
    @JsonGetter("custom_attribute_definition")
    public CustomAttributeDefinition getCustomAttributeDefinition() {
        return customAttributeDefinition;
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
        return Objects.hash(customAttributeDefinition, idempotencyKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateLocationCustomAttributeDefinitionRequest)) {
            return false;
        }
        UpdateLocationCustomAttributeDefinitionRequest other = (UpdateLocationCustomAttributeDefinitionRequest) obj;
        return Objects.equals(customAttributeDefinition, other.customAttributeDefinition)
                && Objects.equals(idempotencyKey, other.idempotencyKey);
    }

    /**
     * Converts this UpdateLocationCustomAttributeDefinitionRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpdateLocationCustomAttributeDefinitionRequest [" + "customAttributeDefinition="
                + customAttributeDefinition + ", idempotencyKey=" + idempotencyKey + "]";
    }

    /**
     * Builds a new {@link UpdateLocationCustomAttributeDefinitionRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateLocationCustomAttributeDefinitionRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(customAttributeDefinition);
        builder.idempotencyKey = internalGetIdempotencyKey();
        return builder;
    }

    /**
     * Class to build instances of {@link UpdateLocationCustomAttributeDefinitionRequest}.
     */
    public static class Builder {
        private CustomAttributeDefinition customAttributeDefinition;
        private OptionalNullable<String> idempotencyKey;

        /**
         * Initialization constructor.
         * @param  customAttributeDefinition  CustomAttributeDefinition value for
         *         customAttributeDefinition.
         */
        public Builder(CustomAttributeDefinition customAttributeDefinition) {
            this.customAttributeDefinition = customAttributeDefinition;
        }

        /**
         * Setter for customAttributeDefinition.
         * @param  customAttributeDefinition  CustomAttributeDefinition value for
         *         customAttributeDefinition.
         * @return Builder
         */
        public Builder customAttributeDefinition(CustomAttributeDefinition customAttributeDefinition) {
            this.customAttributeDefinition = customAttributeDefinition;
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
         * Builds a new {@link UpdateLocationCustomAttributeDefinitionRequest} object using the set
         * fields.
         * @return {@link UpdateLocationCustomAttributeDefinitionRequest}
         */
        public UpdateLocationCustomAttributeDefinitionRequest build() {
            return new UpdateLocationCustomAttributeDefinitionRequest(customAttributeDefinition, idempotencyKey);
        }
    }
}
