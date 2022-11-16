
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for ListRefundsRequest type.
 */
public class ListRefundsRequest {
    private final OptionalNullable<String> beginTime;
    private final OptionalNullable<String> endTime;
    private final String sortOrder;
    private final OptionalNullable<String> cursor;

    /**
     * Initialization constructor.
     * @param  beginTime  String value for beginTime.
     * @param  endTime  String value for endTime.
     * @param  sortOrder  String value for sortOrder.
     * @param  cursor  String value for cursor.
     */
    @JsonCreator
    public ListRefundsRequest(
            @JsonProperty("begin_time") String beginTime,
            @JsonProperty("end_time") String endTime,
            @JsonProperty("sort_order") String sortOrder,
            @JsonProperty("cursor") String cursor) {
        this.beginTime = OptionalNullable.of(beginTime);
        this.endTime = OptionalNullable.of(endTime);
        this.sortOrder = sortOrder;
        this.cursor = OptionalNullable.of(cursor);
    }

    /**
     * Internal initialization constructor.
     */
    protected ListRefundsRequest(OptionalNullable<String> beginTime,
            OptionalNullable<String> endTime, String sortOrder, OptionalNullable<String> cursor) {
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.sortOrder = sortOrder;
        this.cursor = cursor;
    }

    /**
     * Internal Getter for BeginTime.
     * The beginning of the requested reporting period, in RFC 3339 format. See [Date
     * ranges](https://developer.squareup.com/docs/build-basics/working-with-dates) for details on
     * date inclusivity/exclusivity. Default value: The current time minus one year.
     * @return Returns the Internal String
     */
    @JsonGetter("begin_time")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetBeginTime() {
        return this.beginTime;
    }

    /**
     * Getter for BeginTime.
     * The beginning of the requested reporting period, in RFC 3339 format. See [Date
     * ranges](https://developer.squareup.com/docs/build-basics/working-with-dates) for details on
     * date inclusivity/exclusivity. Default value: The current time minus one year.
     * @return Returns the String
     */
    @JsonIgnore
    public String getBeginTime() {
        return OptionalNullable.getFrom(beginTime);
    }

    /**
     * Internal Getter for EndTime.
     * The end of the requested reporting period, in RFC 3339 format. See [Date
     * ranges](https://developer.squareup.com/docs/build-basics/working-with-dates) for details on
     * date inclusivity/exclusivity. Default value: The current time.
     * @return Returns the Internal String
     */
    @JsonGetter("end_time")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetEndTime() {
        return this.endTime;
    }

    /**
     * Getter for EndTime.
     * The end of the requested reporting period, in RFC 3339 format. See [Date
     * ranges](https://developer.squareup.com/docs/build-basics/working-with-dates) for details on
     * date inclusivity/exclusivity. Default value: The current time.
     * @return Returns the String
     */
    @JsonIgnore
    public String getEndTime() {
        return OptionalNullable.getFrom(endTime);
    }

    /**
     * Getter for SortOrder.
     * The order (e.g., chronological or alphabetical) in which results from a request are returned.
     * @return Returns the String
     */
    @JsonGetter("sort_order")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getSortOrder() {
        return sortOrder;
    }

    /**
     * Internal Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve
     * the next set of results for your original query. See [Paginating
     * results](https://developer.squareup.com/docs/working-with-apis/pagination) for more
     * information.
     * @return Returns the Internal String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCursor() {
        return this.cursor;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve
     * the next set of results for your original query. See [Paginating
     * results](https://developer.squareup.com/docs/working-with-apis/pagination) for more
     * information.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCursor() {
        return OptionalNullable.getFrom(cursor);
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
        if (!(obj instanceof ListRefundsRequest)) {
            return false;
        }
        ListRefundsRequest other = (ListRefundsRequest) obj;
        return Objects.equals(beginTime, other.beginTime)
            && Objects.equals(endTime, other.endTime)
            && Objects.equals(sortOrder, other.sortOrder)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this ListRefundsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListRefundsRequest [" + "beginTime=" + beginTime + ", endTime=" + endTime
                + ", sortOrder=" + sortOrder + ", cursor=" + cursor + "]";
    }

    /**
     * Builds a new {@link ListRefundsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListRefundsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .sortOrder(getSortOrder());
        builder.beginTime = internalGetBeginTime();
        builder.endTime = internalGetEndTime();
        builder.cursor = internalGetCursor();
        return builder;
    }

    /**
     * Class to build instances of {@link ListRefundsRequest}.
     */
    public static class Builder {
        private OptionalNullable<String> beginTime;
        private OptionalNullable<String> endTime;
        private String sortOrder;
        private OptionalNullable<String> cursor;



        /**
         * Setter for beginTime.
         * @param  beginTime  String value for beginTime.
         * @return Builder
         */
        public Builder beginTime(String beginTime) {
            this.beginTime = OptionalNullable.of(beginTime);
            return this;
        }

        /**
         * UnSetter for beginTime.
         * @return Builder
         */
        public Builder unsetBeginTime() {
            beginTime = null;
            return this;
        }

        /**
         * Setter for endTime.
         * @param  endTime  String value for endTime.
         * @return Builder
         */
        public Builder endTime(String endTime) {
            this.endTime = OptionalNullable.of(endTime);
            return this;
        }

        /**
         * UnSetter for endTime.
         * @return Builder
         */
        public Builder unsetEndTime() {
            endTime = null;
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
            this.cursor = OptionalNullable.of(cursor);
            return this;
        }

        /**
         * UnSetter for cursor.
         * @return Builder
         */
        public Builder unsetCursor() {
            cursor = null;
            return this;
        }

        /**
         * Builds a new {@link ListRefundsRequest} object using the set fields.
         * @return {@link ListRefundsRequest}
         */
        public ListRefundsRequest build() {
            return new ListRefundsRequest(beginTime, endTime, sortOrder, cursor);
        }
    }
}
