package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class ListAdditionalRecipientReceivablesRequest {

    @JsonCreator
    public ListAdditionalRecipientReceivablesRequest(
            @JsonProperty("begin_time") String beginTime,
            @JsonProperty("end_time") String endTime,
            @JsonProperty("sort_order") String sortOrder,
            @JsonProperty("cursor") String cursor) {
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.sortOrder = sortOrder;
        this.cursor = cursor;
    }

    private final String beginTime;
    private final String endTime;
    private final String sortOrder;
    private final String cursor;

    @Override
    public int hashCode() {
        return Objects.hash(beginTime, endTime, sortOrder, cursor);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ListAdditionalRecipientReceivablesRequest)) {
            return false;
        }
        ListAdditionalRecipientReceivablesRequest listAdditionalRecipientReceivablesRequest = (ListAdditionalRecipientReceivablesRequest) o;
        return Objects.equals(beginTime, listAdditionalRecipientReceivablesRequest.beginTime) &&
            Objects.equals(endTime, listAdditionalRecipientReceivablesRequest.endTime) &&
            Objects.equals(sortOrder, listAdditionalRecipientReceivablesRequest.sortOrder) &&
            Objects.equals(cursor, listAdditionalRecipientReceivablesRequest.cursor);
    }

    /**
     * Getter for BeginTime.
     * The beginning of the requested reporting period, in RFC 3339 format.
     * See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.
     * Default value: The current time minus one year.
     */
    @JsonGetter("begin_time")
    public String getBeginTime() { 
        return this.beginTime;
    }

    /**
     * Getter for EndTime.
     * The end of the requested reporting period, in RFC 3339 format.
     * See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.
     * Default value: The current time.
     */
    @JsonGetter("end_time")
    public String getEndTime() { 
        return this.endTime;
    }

    /**
     * Getter for SortOrder.
     * The order (e.g., chronological or alphabetical) in which results from a request are returned.
     */
    @JsonGetter("sort_order")
    public String getSortOrder() { 
        return this.sortOrder;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint.
     * Provide this to retrieve the next set of results for your original query.
     * See [Paginating results](#paginatingresults) for more information.
     */
    @JsonGetter("cursor")
    public String getCursor() { 
        return this.cursor;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .beginTime(getBeginTime())
            .endTime(getEndTime())
            .sortOrder(getSortOrder())
            .cursor(getCursor());
            return builder;
    }

    public static class Builder {
        private String beginTime;
        private String endTime;
        private String sortOrder;
        private String cursor;

        public Builder() { }

        public Builder beginTime(String value) {
            beginTime = value;
            return this;
        }
        public Builder endTime(String value) {
            endTime = value;
            return this;
        }
        public Builder sortOrder(String value) {
            sortOrder = value;
            return this;
        }
        public Builder cursor(String value) {
            cursor = value;
            return this;
        }

        public ListAdditionalRecipientReceivablesRequest build() {
            return new ListAdditionalRecipientReceivablesRequest(beginTime,
                endTime,
                sortOrder,
                cursor);
        }
    }
}
