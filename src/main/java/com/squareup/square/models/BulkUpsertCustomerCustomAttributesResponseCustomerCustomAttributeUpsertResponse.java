
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for BulkUpsertCustomerCustomAttributesResponseCustomerCustomAttributeUpsertResponse type.
 */
public class BulkUpsertCustomerCustomAttributesResponseCustomerCustomAttributeUpsertResponse {
    private final String customerId;
    private final CustomAttribute customAttribute;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  customerId  String value for customerId.
     * @param  customAttribute  CustomAttribute value for customAttribute.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public BulkUpsertCustomerCustomAttributesResponseCustomerCustomAttributeUpsertResponse(
            @JsonProperty("customer_id") String customerId,
            @JsonProperty("custom_attribute") CustomAttribute customAttribute,
            @JsonProperty("errors") List<Error> errors) {
        this.customerId = customerId;
        this.customAttribute = customAttribute;
        this.errors = errors;
    }

    /**
     * Getter for CustomerId.
     * The ID of the customer profile associated with the custom attribute.
     * @return Returns the String
     */
    @JsonGetter("customer_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
        return Objects.hash(customerId, customAttribute, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BulkUpsertCustomerCustomAttributesResponseCustomerCustomAttributeUpsertResponse)) {
            return false;
        }
        BulkUpsertCustomerCustomAttributesResponseCustomerCustomAttributeUpsertResponse other =
                (BulkUpsertCustomerCustomAttributesResponseCustomerCustomAttributeUpsertResponse) obj;
        return Objects.equals(customerId, other.customerId)
            && Objects.equals(customAttribute, other.customAttribute)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this BulkUpsertCustomerCustomAttributesResponseCustomerCustomAttributeUpsertResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkUpsertCustomerCustomAttributesResponseCustomerCustomAttributeUpsertResponse ["
                + "customerId=" + customerId + ", customAttribute=" + customAttribute + ", errors="
                + errors + "]";
    }

    /**
     * Builds a new {@link BulkUpsertCustomerCustomAttributesResponseCustomerCustomAttributeUpsertResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkUpsertCustomerCustomAttributesResponseCustomerCustomAttributeUpsertResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .customerId(getCustomerId())
                .customAttribute(getCustomAttribute())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link BulkUpsertCustomerCustomAttributesResponseCustomerCustomAttributeUpsertResponse}.
     */
    public static class Builder {
        private String customerId;
        private CustomAttribute customAttribute;
        private List<Error> errors;



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
         * BulkUpsertCustomerCustomAttributesResponseCustomerCustomAttributeUpsertResponse} object
         * using the set fields.
         * @return {@link BulkUpsertCustomerCustomAttributesResponseCustomerCustomAttributeUpsertResponse}
         */
        public BulkUpsertCustomerCustomAttributesResponseCustomerCustomAttributeUpsertResponse build() {
            return new BulkUpsertCustomerCustomAttributesResponseCustomerCustomAttributeUpsertResponse(
                    customerId, customAttribute, errors);
        }
    }
}
