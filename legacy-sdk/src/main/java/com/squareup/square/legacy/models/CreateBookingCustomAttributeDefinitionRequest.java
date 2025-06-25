package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CreateBookingCustomAttributeDefinitionRequest type.
 */
public class CreateBookingCustomAttributeDefinitionRequest {
    private final CustomAttributeDefinition customAttributeDefinition;
    private final String idempotencyKey;

    /**
     * Initialization constructor.
     * @param  customAttributeDefinition  CustomAttributeDefinition value for
     *         customAttributeDefinition.
     * @param  idempotencyKey  String value for idempotencyKey.
     */
    @JsonCreator
    public CreateBookingCustomAttributeDefinitionRequest(
            @JsonProperty("custom_attribute_definition") CustomAttributeDefinition customAttributeDefinition,
            @JsonProperty("idempotency_key") String idempotencyKey) {
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
        return Objects.hash(customAttributeDefinition, idempotencyKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateBookingCustomAttributeDefinitionRequest)) {
            return false;
        }
        CreateBookingCustomAttributeDefinitionRequest other = (CreateBookingCustomAttributeDefinitionRequest) obj;
        return Objects.equals(customAttributeDefinition, other.customAttributeDefinition)
                && Objects.equals(idempotencyKey, other.idempotencyKey);
    }

    /**
     * Converts this CreateBookingCustomAttributeDefinitionRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateBookingCustomAttributeDefinitionRequest [" + "customAttributeDefinition="
                + customAttributeDefinition + ", idempotencyKey=" + idempotencyKey + "]";
    }

    /**
     * Builds a new {@link CreateBookingCustomAttributeDefinitionRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateBookingCustomAttributeDefinitionRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(customAttributeDefinition).idempotencyKey(getIdempotencyKey());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateBookingCustomAttributeDefinitionRequest}.
     */
    public static class Builder {
        private CustomAttributeDefinition customAttributeDefinition;
        private String idempotencyKey;

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
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        /**
         * Builds a new {@link CreateBookingCustomAttributeDefinitionRequest} object using the set
         * fields.
         * @return {@link CreateBookingCustomAttributeDefinitionRequest}
         */
        public CreateBookingCustomAttributeDefinitionRequest build() {
            return new CreateBookingCustomAttributeDefinitionRequest(customAttributeDefinition, idempotencyKey);
        }
    }
}
