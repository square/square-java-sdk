package com.squareup.square.legacy.models;

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
 * This is a model class for SearchSubscriptionsFilter type.
 */
public class SearchSubscriptionsFilter {
    private final OptionalNullable<List<String>> customerIds;
    private final OptionalNullable<List<String>> locationIds;
    private final OptionalNullable<List<String>> sourceNames;

    /**
     * Initialization constructor.
     * @param  customerIds  List of String value for customerIds.
     * @param  locationIds  List of String value for locationIds.
     * @param  sourceNames  List of String value for sourceNames.
     */
    @JsonCreator
    public SearchSubscriptionsFilter(
            @JsonProperty("customer_ids") List<String> customerIds,
            @JsonProperty("location_ids") List<String> locationIds,
            @JsonProperty("source_names") List<String> sourceNames) {
        this.customerIds = OptionalNullable.of(customerIds);
        this.locationIds = OptionalNullable.of(locationIds);
        this.sourceNames = OptionalNullable.of(sourceNames);
    }

    /**
     * Initialization constructor.
     * @param  customerIds  List of String value for customerIds.
     * @param  locationIds  List of String value for locationIds.
     * @param  sourceNames  List of String value for sourceNames.
     */
    protected SearchSubscriptionsFilter(
            OptionalNullable<List<String>> customerIds,
            OptionalNullable<List<String>> locationIds,
            OptionalNullable<List<String>> sourceNames) {
        this.customerIds = customerIds;
        this.locationIds = locationIds;
        this.sourceNames = sourceNames;
    }

    /**
     * Internal Getter for CustomerIds.
     * A filter to select subscriptions based on the subscribing customer IDs.
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
     * A filter to select subscriptions based on the subscribing customer IDs.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getCustomerIds() {
        return OptionalNullable.getFrom(customerIds);
    }

    /**
     * Internal Getter for LocationIds.
     * A filter to select subscriptions based on the location.
     * @return Returns the Internal List of String
     */
    @JsonGetter("location_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetLocationIds() {
        return this.locationIds;
    }

    /**
     * Getter for LocationIds.
     * A filter to select subscriptions based on the location.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getLocationIds() {
        return OptionalNullable.getFrom(locationIds);
    }

    /**
     * Internal Getter for SourceNames.
     * A filter to select subscriptions based on the source application.
     * @return Returns the Internal List of String
     */
    @JsonGetter("source_names")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetSourceNames() {
        return this.sourceNames;
    }

    /**
     * Getter for SourceNames.
     * A filter to select subscriptions based on the source application.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getSourceNames() {
        return OptionalNullable.getFrom(sourceNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerIds, locationIds, sourceNames);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchSubscriptionsFilter)) {
            return false;
        }
        SearchSubscriptionsFilter other = (SearchSubscriptionsFilter) obj;
        return Objects.equals(customerIds, other.customerIds)
                && Objects.equals(locationIds, other.locationIds)
                && Objects.equals(sourceNames, other.sourceNames);
    }

    /**
     * Converts this SearchSubscriptionsFilter into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchSubscriptionsFilter [" + "customerIds=" + customerIds + ", locationIds=" + locationIds
                + ", sourceNames=" + sourceNames + "]";
    }

    /**
     * Builds a new {@link SearchSubscriptionsFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchSubscriptionsFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.customerIds = internalGetCustomerIds();
        builder.locationIds = internalGetLocationIds();
        builder.sourceNames = internalGetSourceNames();
        return builder;
    }

    /**
     * Class to build instances of {@link SearchSubscriptionsFilter}.
     */
    public static class Builder {
        private OptionalNullable<List<String>> customerIds;
        private OptionalNullable<List<String>> locationIds;
        private OptionalNullable<List<String>> sourceNames;

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
         * Setter for locationIds.
         * @param  locationIds  List of String value for locationIds.
         * @return Builder
         */
        public Builder locationIds(List<String> locationIds) {
            this.locationIds = OptionalNullable.of(locationIds);
            return this;
        }

        /**
         * UnSetter for locationIds.
         * @return Builder
         */
        public Builder unsetLocationIds() {
            locationIds = null;
            return this;
        }

        /**
         * Setter for sourceNames.
         * @param  sourceNames  List of String value for sourceNames.
         * @return Builder
         */
        public Builder sourceNames(List<String> sourceNames) {
            this.sourceNames = OptionalNullable.of(sourceNames);
            return this;
        }

        /**
         * UnSetter for sourceNames.
         * @return Builder
         */
        public Builder unsetSourceNames() {
            sourceNames = null;
            return this;
        }

        /**
         * Builds a new {@link SearchSubscriptionsFilter} object using the set fields.
         * @return {@link SearchSubscriptionsFilter}
         */
        public SearchSubscriptionsFilter build() {
            return new SearchSubscriptionsFilter(customerIds, locationIds, sourceNames);
        }
    }
}
