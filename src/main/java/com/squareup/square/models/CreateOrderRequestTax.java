package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CreateOrderRequestTax {

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

    @Override
    public int hashCode() {
        return Objects.hash(catalogObjectId, name, type, percentage);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CreateOrderRequestTax)) {
            return false;
        }
        CreateOrderRequestTax createOrderRequestTax = (CreateOrderRequestTax) o;
        return Objects.equals(catalogObjectId, createOrderRequestTax.catalogObjectId) &&
            Objects.equals(name, createOrderRequestTax.name) &&
            Objects.equals(type, createOrderRequestTax.type) &&
            Objects.equals(percentage, createOrderRequestTax.percentage);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .catalogObjectId(getCatalogObjectId())
            .name(getName())
            .type(getType())
            .percentage(getPercentage());
            return builder;
    }

    public static class Builder {
        private String catalogObjectId;
        private String name;
        private String type;
        private String percentage;

        public Builder() { }

        public Builder catalogObjectId(String value) {
            catalogObjectId = value;
            return this;
        }
        public Builder name(String value) {
            name = value;
            return this;
        }
        public Builder type(String value) {
            type = value;
            return this;
        }
        public Builder percentage(String value) {
            percentage = value;
            return this;
        }

        public CreateOrderRequestTax build() {
            return new CreateOrderRequestTax(catalogObjectId,
                name,
                type,
                percentage);
        }
    }
}
