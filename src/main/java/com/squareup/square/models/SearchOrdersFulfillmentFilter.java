package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class SearchOrdersFulfillmentFilter {

    @JsonCreator
    public SearchOrdersFulfillmentFilter(
            @JsonProperty("fulfillment_types") List<String> fulfillmentTypes,
            @JsonProperty("fulfillment_states") List<String> fulfillmentStates) {
        this.fulfillmentTypes = fulfillmentTypes;
        this.fulfillmentStates = fulfillmentStates;
    }

    private final List<String> fulfillmentTypes;
    private final List<String> fulfillmentStates;

    @Override
    public int hashCode() {
        return Objects.hash(fulfillmentTypes, fulfillmentStates);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SearchOrdersFulfillmentFilter)) {
            return false;
        }
        SearchOrdersFulfillmentFilter searchOrdersFulfillmentFilter = (SearchOrdersFulfillmentFilter) o;
        return Objects.equals(fulfillmentTypes, searchOrdersFulfillmentFilter.fulfillmentTypes) &&
            Objects.equals(fulfillmentStates, searchOrdersFulfillmentFilter.fulfillmentStates);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder(fulfillmentTypes)
            .fulfillmentStates(getFulfillmentStates());
            return builder;
    }

    public static class Builder {
        private List<String> fulfillmentTypes;
        private List<String> fulfillmentStates;

        public Builder(List<String> fulfillmentTypes) {
            this.fulfillmentTypes = fulfillmentTypes;
        }

        public Builder fulfillmentTypes(List<String> value) {
            fulfillmentTypes = value;
            return this;
        }
        public Builder fulfillmentStates(List<String> value) {
            fulfillmentStates = value;
            return this;
        }

        public SearchOrdersFulfillmentFilter build() {
            return new SearchOrdersFulfillmentFilter(fulfillmentTypes,
                fulfillmentStates);
        }
    }
}
