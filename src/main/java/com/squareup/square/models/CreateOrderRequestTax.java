package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CreateOrderRequestTax type.
 */
public class CreateOrderRequestTax {

    /**
     * Initialization constructor.
     * @param catalogObjectId
     * @param name
     * @param type
     * @param percentage
     */
    @JsonCreator
    public CreateOrderRequestTax(
            @JsonProperty("catalog_object_id") String catalogObjectId,
            @JsonProperty("name") String name,
            @JsonProperty("type") String type,
            @JsonProperty("percentage") String percentage) {
        this.catalogObjectId = catalogObjectId;
        this.name = name;
        this.type = type;
        this.percentage = percentage;
    }

    private final String catalogObjectId;
    private final String name;
    private final String type;
    private final String percentage;
    /**
     * Getter for CatalogObjectId.
     * Only used for catalog taxes. The catalog object ID of an existing [CatalogTax](#type-catalogtax).
     * Do not provide a value for this field if you provide values in other fields for an ad hoc tax.
     */
    @JsonGetter("catalog_object_id")
    public String getCatalogObjectId() {
        return this.catalogObjectId;
    }

    /**
     * Getter for Name.
     * Only used for ad hoc taxes. The tax's name.
     * Do not provide a value for this field if you set `catalog_object_id`.
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for Type.
     * Indicates how the tax is applied to the associated line item or order.
     */
    @JsonGetter("type")
    public String getType() {
        return this.type;
    }

    /**
     * Getter for Percentage.
     * Only used for ad hoc taxes. The percentage of the tax, as a string representation of a decimal number.
     * A value of `7.25` corresponds to a percentage of 7.25%. This value range between 0.0 up to 100.0
     */
    @JsonGetter("percentage")
    public String getPercentage() {
        return this.percentage;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(catalogObjectId, name, type, percentage);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CreateOrderRequestTax)) {
            return false;
        }
        CreateOrderRequestTax createOrderRequestTax = (CreateOrderRequestTax) obj;
        return Objects.equals(catalogObjectId, createOrderRequestTax.catalogObjectId) &&
            Objects.equals(name, createOrderRequestTax.name) &&
            Objects.equals(type, createOrderRequestTax.type) &&
            Objects.equals(percentage, createOrderRequestTax.percentage);
    }

    /**
     * Builds a new {@link CreateOrderRequestTax.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateOrderRequestTax.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .catalogObjectId(getCatalogObjectId())
            .name(getName())
            .type(getType())
            .percentage(getPercentage());
            return builder;
    }

    /**
     * Class to build instances of {@link CreateOrderRequestTax}
     */
    public static class Builder {
        private String catalogObjectId;
        private String name;
        private String type;
        private String percentage;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for catalogObjectId
         * @param catalogObjectId
         * @return Builder
         */
        public Builder catalogObjectId(String catalogObjectId) {
            this.catalogObjectId = catalogObjectId;
            return this;
        }
        /**
         * Setter for name
         * @param name
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        /**
         * Setter for type
         * @param type
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }
        /**
         * Setter for percentage
         * @param percentage
         * @return Builder
         */
        public Builder percentage(String percentage) {
            this.percentage = percentage;
            return this;
        }

        /**
         * Builds a new {@link CreateOrderRequestTax} object using the set fields.
         * @return {@link CreateOrderRequestTax}
         */
        public CreateOrderRequestTax build() {
            return new CreateOrderRequestTax(catalogObjectId,
                name,
                type,
                percentage);
        }
    }
}
