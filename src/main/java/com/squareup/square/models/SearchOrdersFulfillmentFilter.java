package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for SearchOrdersFulfillmentFilter type.
 */
public class SearchOrdersFulfillmentFilter {

    /**
     * Initialization constructor.
     * @param fulfillmentTypes
     * @param fulfillmentStates
     */
    @JsonCreator
    public SearchOrdersFulfillmentFilter(
            @JsonProperty("fulfillment_types") List<String> fulfillmentTypes,
            @JsonProperty("fulfillment_states") List<String> fulfillmentStates) {
        this.fulfillmentTypes = fulfillmentTypes;
        this.fulfillmentStates = fulfillmentStates;
    }

    private final List<String> fulfillmentTypes;
    private final List<String> fulfillmentStates;
    /**
     * Getter for FulfillmentTypes.
     * List of [fulfillment types](#type-orderfulfillmenttype) to filter
     * for. Will return orders if any of its fulfillments match any of the fulfillment types
     * listed in this field.
     * See [OrderFulfillmentType](#type-orderfulfillmenttype) for possible values
     */
    @JsonGetter("fulfillment_types")
    public List<String> getFulfillmentTypes() {
        return this.fulfillmentTypes;
    }

    /**
     * Getter for FulfillmentStates.
     * List of [fulfillment states](#type-orderfulfillmentstate) to filter
     * for. Will return orders if any of its fulfillments match any of the
     * fulfillment states listed in this field.
     * See [OrderFulfillmentState](#type-orderfulfillmentstate) for possible values
     */
    @JsonGetter("fulfillment_states")
    public List<String> getFulfillmentStates() {
        return this.fulfillmentStates;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(fulfillmentTypes, fulfillmentStates);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SearchOrdersFulfillmentFilter)) {
            return false;
        }
        SearchOrdersFulfillmentFilter searchOrdersFulfillmentFilter = (SearchOrdersFulfillmentFilter) obj;
        return Objects.equals(fulfillmentTypes, searchOrdersFulfillmentFilter.fulfillmentTypes) &&
            Objects.equals(fulfillmentStates, searchOrdersFulfillmentFilter.fulfillmentStates);
    }

    /**
     * Builds a new {@link SearchOrdersFulfillmentFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchOrdersFulfillmentFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(fulfillmentTypes)
            .fulfillmentStates(getFulfillmentStates());
            return builder;
    }

    /**
     * Class to build instances of {@link SearchOrdersFulfillmentFilter}
     */
    public static class Builder {
        private List<String> fulfillmentTypes;
        private List<String> fulfillmentStates;

        /**
         * Initialization constructor
         */
        public Builder(List<String> fulfillmentTypes) {
            this.fulfillmentTypes = fulfillmentTypes;
        }

        /**
         * Setter for fulfillmentTypes
         * @param fulfillmentTypes
         * @return Builder
         */
        public Builder fulfillmentTypes(List<String> fulfillmentTypes) {
            this.fulfillmentTypes = fulfillmentTypes;
            return this;
        }
        /**
         * Setter for fulfillmentStates
         * @param fulfillmentStates
         * @return Builder
         */
        public Builder fulfillmentStates(List<String> fulfillmentStates) {
            this.fulfillmentStates = fulfillmentStates;
            return this;
        }

        /**
         * Builds a new {@link SearchOrdersFulfillmentFilter} object using the set fields.
         * @return {@link SearchOrdersFulfillmentFilter}
         */
        public SearchOrdersFulfillmentFilter build() {
            return new SearchOrdersFulfillmentFilter(fulfillmentTypes,
                fulfillmentStates);
        }
    }
}
