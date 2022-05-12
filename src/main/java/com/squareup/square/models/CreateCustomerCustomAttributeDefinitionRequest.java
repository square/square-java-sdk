
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CreateCustomerCustomAttributeDefinitionRequest type.
 */
public class CreateCustomerCustomAttributeDefinitionRequest {
    private final CustomAttributeDefinition customAttributeDefinition;
    private final String idempotencyKey;

    /**
     * Initialization constructor.
     * @param  customAttributeDefinition  CustomAttributeDefinition value for
     *         customAttributeDefinition.
     * @param  idempotencyKey  String value for idempotencyKey.
     */
    @JsonCreator
    public CreateCustomerCustomAttributeDefinitionRequest(
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
        if (!(obj instanceof CreateCustomerCustomAttributeDefinitionRequest)) {
            return false;
        }
        CreateCustomerCustomAttributeDefinitionRequest other =
                (CreateCustomerCustomAttributeDefinitionRequest) obj;
        return Objects.equals(customAttributeDefinition, other.customAttributeDefinition)
            && Objects.equals(idempotencyKey, other.idempotencyKey);
    }

    /**
     * Converts this CreateCustomerCustomAttributeDefinitionRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateCustomerCustomAttributeDefinitionRequest [" + "customAttributeDefinition="
                + customAttributeDefinition + ", idempotencyKey=" + idempotencyKey + "]";
    }

    /**
     * Builds a new {@link CreateCustomerCustomAttributeDefinitionRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateCustomerCustomAttributeDefinitionRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(customAttributeDefinition)
                .idempotencyKey(getIdempotencyKey());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateCustomerCustomAttributeDefinitionRequest}.
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
        public Builder customAttributeDefinition(
                CustomAttributeDefinition customAttributeDefinition) {
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
         * Builds a new {@link CreateCustomerCustomAttributeDefinitionRequest} object using the set
         * fields.
         * @return {@link CreateCustomerCustomAttributeDefinitionRequest}
         */
        public CreateCustomerCustomAttributeDefinitionRequest build() {
            return new CreateCustomerCustomAttributeDefinitionRequest(customAttributeDefinition,
                    idempotencyKey);
        }
    }
}
