
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for ListTransactionsRequest type.
 */
public class ListTransactionsRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String beginTime;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String endTime;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String sortOrder;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  beginTime  String value for beginTime.
     * @param  endTime  String value for endTime.
     * @param  sortOrder  String value for sortOrder.
     * @param  cursor  String value for cursor.
     */
    @JsonCreator
    public ListTransactionsRequest(
            @JsonProperty("begin_time") String beginTime,
            @JsonProperty("end_time") String endTime,
            @JsonProperty("sort_order") String sortOrder,
            @JsonProperty("cursor") String cursor) {
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.sortOrder = sortOrder;
        this.cursor = cursor;
    }

    /**
     * Getter for BeginTime.
     * The beginning of the requested reporting period, in RFC 3339 format. See [Date
     * ranges](https://developer.squareup.com/docs/build-basics/working-with-dates) for details on
     * date inclusivity/exclusivity. Default value: The current time minus one year.
     * @return Returns the String
     */
    @JsonGetter("begin_time")
    public String getBeginTime() {
        return beginTime;
    }

    /**
     * Getter for EndTime.
     * The end of the requested reporting period, in RFC 3339 format. See [Date
     * ranges](https://developer.squareup.com/docs/build-basics/working-with-dates) for details on
     * date inclusivity/exclusivity. Default value: The current time.
     * @return Returns the String
     */
    @JsonGetter("end_time")
    public String getEndTime() {
        return endTime;
    }

    /**
     * Getter for SortOrder.
     * The order (e.g., chronological or alphabetical) in which results from a request are returned.
     * @return Returns the String
     */
    @JsonGetter("sort_order")
    public String getSortOrder() {
        return sortOrder;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve
     * the next set of results for your original query. See [Paginating
     * results](https://developer.squareup.com/docs/working-with-apis/pagination) for more
     * information.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(beginTime, endTime, sortOrder, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListTransactionsRequest)) {
            return false;
        }
        ListTransactionsRequest other = (ListTransactionsRequest) obj;
        return Objects.equals(beginTime, other.beginTime)
            && Objects.equals(endTime, other.endTime)
            && Objects.equals(sortOrder, other.sortOrder)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this ListTransactionsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListTransactionsRequest [" + "beginTime=" + beginTime + ", endTime=" + endTime
                + ", sortOrder=" + sortOrder + ", cursor=" + cursor + "]";
    }

    /**
     * Builds a new {@link ListTransactionsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListTransactionsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .beginTime(getBeginTime())
                .endTime(getEndTime())
                .sortOrder(getSortOrder())
                .cursor(getCursor());
        return builder;
    }

    /**
     * Class to build instances of {@link ListTransactionsRequest}.
     */
    public static class Builder {
        private String beginTime;
        private String endTime;
        private String sortOrder;
        private String cursor;



        /**
         * Setter for beginTime.
         * @param  beginTime  String value for beginTime.
         * @return Builder
         */
        public Builder beginTime(String beginTime) {
            this.beginTime = beginTime;
            return this;
        }

        /**
         * Setter for endTime.
         * @param  endTime  String value for endTime.
         * @return Builder
         */
        public Builder endTime(String endTime) {
            this.endTime = endTime;
            return this;
        }

        /**
         * Setter for sortOrder.
         * @param  sortOrder  String value for sortOrder.
         * @return Builder
         */
        public Builder sortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }

        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Builds a new {@link ListTransactionsRequest} object using the set fields.
         * @return {@link ListTransactionsRequest}
         */
        public ListTransactionsRequest build() {
            return new ListTransactionsRequest(beginTime, endTime, sortOrder, cursor);
        }
    }
}
