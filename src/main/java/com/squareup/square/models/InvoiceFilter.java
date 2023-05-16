
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for InvoiceFilter type.
 */
public class InvoiceFilter {
    private final List<String> locationIds;
    private final OptionalNullable<List<String>> customerIds;

    /**
     * Initialization constructor.
     * @param  locationIds  List of String value for locationIds.
     * @param  customerIds  List of String value for customerIds.
     */
    @JsonCreator
    public InvoiceFilter(
            @JsonProperty("location_ids") List<String> locationIds,
            @JsonProperty("customer_ids") List<String> customerIds) {
        this.locationIds = locationIds;
        this.customerIds = OptionalNullable.of(customerIds);
    }

    /**
     * Internal initialization constructor.
     */
    protected InvoiceFilter(List<String> locationIds,
            OptionalNullable<List<String>> customerIds) {
        this.locationIds = locationIds;
        this.customerIds = customerIds;
    }

    /**
     * Getter for LocationIds.
     * Limits the search to the specified locations. A location is required. In the current
     * implementation, only one location can be specified.
     * @return Returns the List of String
     */
    @JsonGetter("location_ids")
    public List<String> getLocationIds() {
        return locationIds;
    }

    /**
     * Internal Getter for CustomerIds.
     * Limits the search to the specified customers, within the specified locations. Specifying a
     * customer is optional. In the current implementation, a maximum of one customer can be
     * specified.
     * @return Returns the Internal List of String
     */
    @JsonGetter("customer_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetCustomerIds() {
        return this.customerIds;
    }

    /**
     * Getter for CustomerIds.
     * Limits the search to the specified customers, within the specified locations. Specifying a
     * customer is optional. In the current implementation, a maximum of one customer can be
     * specified.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getCustomerIds() {
        return OptionalNullable.getFrom(customerIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationIds, customerIds);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InvoiceFilter)) {
            return false;
        }
        InvoiceFilter other = (InvoiceFilter) obj;
        return Objects.equals(locationIds, other.locationIds)
            && Objects.equals(customerIds, other.customerIds);
    }

    /**
     * Converts this InvoiceFilter into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "InvoiceFilter [" + "locationIds=" + locationIds + ", customerIds=" + customerIds
                + "]";
    }

    /**
     * Builds a new {@link InvoiceFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link InvoiceFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(locationIds);
        builder.customerIds = internalGetCustomerIds();
        return builder;
    }

    /**
     * Class to build instances of {@link InvoiceFilter}.
     */
    public static class Builder {
        private List<String> locationIds;
        private OptionalNullable<List<String>> customerIds;

        /**
         * Initialization constructor.
         * @param  locationIds  List of String value for locationIds.
         */
        public Builder(List<String> locationIds) {
            this.locationIds = locationIds;
        }

        /**
         * Setter for locationIds.
         * @param  locationIds  List of String value for locationIds.
         * @return Builder
         */
        public Builder locationIds(List<String> locationIds) {
            this.locationIds = locationIds;
            return this;
        }

        /**
         * Setter for customerIds.
         * @param  customerIds  List of String value for customerIds.
         * @return Builder
         */
        public Builder customerIds(List<String> customerIds) {
            this.customerIds = OptionalNullable.of(customerIds);
            return this;
        }

        /**
         * UnSetter for customerIds.
         * @return Builder
         */
        public Builder unsetCustomerIds() {
            customerIds = null;
            return this;
        }

        /**
         * Builds a new {@link InvoiceFilter} object using the set fields.
         * @return {@link InvoiceFilter}
         */
        public InvoiceFilter build() {
            return new InvoiceFilter(locationIds, customerIds);
        }
    }
}
