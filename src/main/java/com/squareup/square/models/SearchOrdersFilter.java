package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class SearchOrdersFilter {

    @JsonCreator
    public SearchOrdersFilter(
            @JsonProperty("state_filter") SearchOrdersStateFilter stateFilter,
            @JsonProperty("date_time_filter") SearchOrdersDateTimeFilter dateTimeFilter,
            @JsonProperty("fulfillment_filter") SearchOrdersFulfillmentFilter fulfillmentFilter,
            @JsonProperty("source_filter") SearchOrdersSourceFilter sourceFilter,
            @JsonProperty("customer_filter") SearchOrdersCustomerFilter customerFilter) {
        this.stateFilter = stateFilter;
        this.dateTimeFilter = dateTimeFilter;
        this.fulfillmentFilter = fulfillmentFilter;
        this.sourceFilter = sourceFilter;
        this.customerFilter = customerFilter;
    }

    private final SearchOrdersStateFilter stateFilter;
    private final SearchOrdersDateTimeFilter dateTimeFilter;
    private final SearchOrdersFulfillmentFilter fulfillmentFilter;
    private final SearchOrdersSourceFilter sourceFilter;
    private final SearchOrdersCustomerFilter customerFilter;

    @Override
    public int hashCode() {
        return Objects.hash(stateFilter, dateTimeFilter, fulfillmentFilter, sourceFilter, customerFilter);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SearchOrdersFilter)) {
            return false;
        }
        SearchOrdersFilter searchOrdersFilter = (SearchOrdersFilter) o;
        return Objects.equals(stateFilter, searchOrdersFilter.stateFilter) &&
            Objects.equals(dateTimeFilter, searchOrdersFilter.dateTimeFilter) &&
            Objects.equals(fulfillmentFilter, searchOrdersFilter.fulfillmentFilter) &&
            Objects.equals(sourceFilter, searchOrdersFilter.sourceFilter) &&
            Objects.equals(customerFilter, searchOrdersFilter.customerFilter);
    }

    /**
     * Getter for StateFilter.
     * Filter by current Order `state`.
     */
    @JsonGetter("state_filter")
    public SearchOrdersStateFilter getStateFilter() { 
        return this.stateFilter;
    }

    /**
     * Getter for DateTimeFilter.
     * Filter for `Order` objects based on whether their `CREATED_AT`,
     * `CLOSED_AT` or `UPDATED_AT` timestamps fall within a specified time range.
     * You can specify the time range and which timestamp to filter for. You can filter
     * for only one time range at a time.
     * For each time range, the start time and end time are inclusive. If the end time
     * is absent, it defaults to the time of the first request for the cursor.
     * __Important:__ If you use the DateTimeFilter in a SearchOrders query,
     * you must also set the `sort_field` in [OrdersSort](#type-searchorderordersort)
     * to the same field you filter for. For example, if you set the `CLOSED_AT` field
     * in DateTimeFilter, you must also set the `sort_field` in SearchOrdersSort to
     * `CLOSED_AT`. Otherwise, SearchOrders will throw an error.
     * [Learn more about filtering orders by time range](https://developer.squareup.com/docs/orders-api/manage-orders#important-note-on-filtering-orders-by-time-range).
     */
    @JsonGetter("date_time_filter")
    public SearchOrdersDateTimeFilter getDateTimeFilter() { 
        return this.dateTimeFilter;
    }

    /**
     * Getter for FulfillmentFilter.
     * Filter based on [Order Fulfillment](#type-orderfulfillment) information.
     */
    @JsonGetter("fulfillment_filter")
    public SearchOrdersFulfillmentFilter getFulfillmentFilter() { 
        return this.fulfillmentFilter;
    }

    /**
     * Getter for SourceFilter.
     * Filter based on order `source` information.
     */
    @JsonGetter("source_filter")
    public SearchOrdersSourceFilter getSourceFilter() { 
        return this.sourceFilter;
    }

    /**
     * Getter for CustomerFilter.
     * Filter based on Order `customer_id` and any Tender `customer_id`
     * associated with the Order. Does not filter based on the
     * [FulfillmentRecipient](#type-orderfulfillmentrecipient) `customer_id`.
     */
    @JsonGetter("customer_filter")
    public SearchOrdersCustomerFilter getCustomerFilter() { 
        return this.customerFilter;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .stateFilter(getStateFilter())
            .dateTimeFilter(getDateTimeFilter())
            .fulfillmentFilter(getFulfillmentFilter())
            .sourceFilter(getSourceFilter())
            .customerFilter(getCustomerFilter());
            return builder;
    }

    public static class Builder {
        private SearchOrdersStateFilter stateFilter;
        private SearchOrdersDateTimeFilter dateTimeFilter;
        private SearchOrdersFulfillmentFilter fulfillmentFilter;
        private SearchOrdersSourceFilter sourceFilter;
        private SearchOrdersCustomerFilter customerFilter;

        public Builder() { }

        public Builder stateFilter(SearchOrdersStateFilter value) {
            stateFilter = value;
            return this;
        }
        public Builder dateTimeFilter(SearchOrdersDateTimeFilter value) {
            dateTimeFilter = value;
            return this;
        }
        public Builder fulfillmentFilter(SearchOrdersFulfillmentFilter value) {
            fulfillmentFilter = value;
            return this;
        }
        public Builder sourceFilter(SearchOrdersSourceFilter value) {
            sourceFilter = value;
            return this;
        }
        public Builder customerFilter(SearchOrdersCustomerFilter value) {
            customerFilter = value;
            return this;
        }

        public SearchOrdersFilter build() {
            return new SearchOrdersFilter(stateFilter,
                dateTimeFilter,
                fulfillmentFilter,
                sourceFilter,
                customerFilter);
        }
    }
}
