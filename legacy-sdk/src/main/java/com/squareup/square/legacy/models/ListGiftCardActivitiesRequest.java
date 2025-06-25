package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for ListGiftCardActivitiesRequest type.
 */
public class ListGiftCardActivitiesRequest {
    private final OptionalNullable<String> giftCardId;
    private final OptionalNullable<String> type;
    private final OptionalNullable<String> locationId;
    private final OptionalNullable<String> beginTime;
    private final OptionalNullable<String> endTime;
    private final OptionalNullable<Integer> limit;
    private final OptionalNullable<String> cursor;
    private final OptionalNullable<String> sortOrder;

    /**
     * Initialization constructor.
     * @param  giftCardId  String value for giftCardId.
     * @param  type  String value for type.
     * @param  locationId  String value for locationId.
     * @param  beginTime  String value for beginTime.
     * @param  endTime  String value for endTime.
     * @param  limit  Integer value for limit.
     * @param  cursor  String value for cursor.
     * @param  sortOrder  String value for sortOrder.
     */
    @JsonCreator
    public ListGiftCardActivitiesRequest(
            @JsonProperty("gift_card_id") String giftCardId,
            @JsonProperty("type") String type,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("begin_time") String beginTime,
            @JsonProperty("end_time") String endTime,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("sort_order") String sortOrder) {
        this.giftCardId = OptionalNullable.of(giftCardId);
        this.type = OptionalNullable.of(type);
        this.locationId = OptionalNullable.of(locationId);
        this.beginTime = OptionalNullable.of(beginTime);
        this.endTime = OptionalNullable.of(endTime);
        this.limit = OptionalNullable.of(limit);
        this.cursor = OptionalNullable.of(cursor);
        this.sortOrder = OptionalNullable.of(sortOrder);
    }

    /**
     * Initialization constructor.
     * @param  giftCardId  String value for giftCardId.
     * @param  type  String value for type.
     * @param  locationId  String value for locationId.
     * @param  beginTime  String value for beginTime.
     * @param  endTime  String value for endTime.
     * @param  limit  Integer value for limit.
     * @param  cursor  String value for cursor.
     * @param  sortOrder  String value for sortOrder.
     */
    protected ListGiftCardActivitiesRequest(
            OptionalNullable<String> giftCardId,
            OptionalNullable<String> type,
            OptionalNullable<String> locationId,
            OptionalNullable<String> beginTime,
            OptionalNullable<String> endTime,
            OptionalNullable<Integer> limit,
            OptionalNullable<String> cursor,
            OptionalNullable<String> sortOrder) {
        this.giftCardId = giftCardId;
        this.type = type;
        this.locationId = locationId;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.limit = limit;
        this.cursor = cursor;
        this.sortOrder = sortOrder;
    }

    /**
     * Internal Getter for GiftCardId.
     * If a gift card ID is provided, the endpoint returns activities related to the specified gift
     * card. Otherwise, the endpoint returns all gift card activities for the seller.
     * @return Returns the Internal String
     */
    @JsonGetter("gift_card_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetGiftCardId() {
        return this.giftCardId;
    }

    /**
     * Getter for GiftCardId.
     * If a gift card ID is provided, the endpoint returns activities related to the specified gift
     * card. Otherwise, the endpoint returns all gift card activities for the seller.
     * @return Returns the String
     */
    @JsonIgnore
    public String getGiftCardId() {
        return OptionalNullable.getFrom(giftCardId);
    }

    /**
     * Internal Getter for Type.
     * If a [type](entity:GiftCardActivityType) is provided, the endpoint returns gift card
     * activities of the specified type. Otherwise, the endpoint returns all types of gift card
     * activities.
     * @return Returns the Internal String
     */
    @JsonGetter("type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetType() {
        return this.type;
    }

    /**
     * Getter for Type.
     * If a [type](entity:GiftCardActivityType) is provided, the endpoint returns gift card
     * activities of the specified type. Otherwise, the endpoint returns all types of gift card
     * activities.
     * @return Returns the String
     */
    @JsonIgnore
    public String getType() {
        return OptionalNullable.getFrom(type);
    }

    /**
     * Internal Getter for LocationId.
     * If a location ID is provided, the endpoint returns gift card activities for the specified
     * location. Otherwise, the endpoint returns gift card activities for all locations.
     * @return Returns the Internal String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetLocationId() {
        return this.locationId;
    }

    /**
     * Getter for LocationId.
     * If a location ID is provided, the endpoint returns gift card activities for the specified
     * location. Otherwise, the endpoint returns gift card activities for all locations.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLocationId() {
        return OptionalNullable.getFrom(locationId);
    }

    /**
     * Internal Getter for BeginTime.
     * The timestamp for the beginning of the reporting period, in RFC 3339 format. This start time
     * is inclusive. The default value is the current time minus one year.
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
     * The timestamp for the beginning of the reporting period, in RFC 3339 format. This start time
     * is inclusive. The default value is the current time minus one year.
     * @return Returns the String
     */
    @JsonIgnore
    public String getBeginTime() {
        return OptionalNullable.getFrom(beginTime);
    }

    /**
     * Internal Getter for EndTime.
     * The timestamp for the end of the reporting period, in RFC 3339 format. This end time is
     * inclusive. The default value is the current time.
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
     * The timestamp for the end of the reporting period, in RFC 3339 format. This end time is
     * inclusive. The default value is the current time.
     * @return Returns the String
     */
    @JsonIgnore
    public String getEndTime() {
        return OptionalNullable.getFrom(endTime);
    }

    /**
     * Internal Getter for Limit.
     * If a limit is provided, the endpoint returns the specified number of results (or fewer) per
     * page. The maximum value is 100. The default value is 50. For more information, see
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @return Returns the Internal Integer
     */
    @JsonGetter("limit")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetLimit() {
        return this.limit;
    }

    /**
     * Getter for Limit.
     * If a limit is provided, the endpoint returns the specified number of results (or fewer) per
     * page. The maximum value is 100. The default value is 50. For more information, see
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getLimit() {
        return OptionalNullable.getFrom(limit);
    }

    /**
     * Internal Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this cursor to
     * retrieve the next set of results for the original query. If a cursor is not provided, the
     * endpoint returns the first page of the results. For more information, see
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
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
     * A pagination cursor returned by a previous call to this endpoint. Provide this cursor to
     * retrieve the next set of results for the original query. If a cursor is not provided, the
     * endpoint returns the first page of the results. For more information, see
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @return Returns the String
     */
    @JsonIgnore
    public String getCursor() {
        return OptionalNullable.getFrom(cursor);
    }

    /**
     * Internal Getter for SortOrder.
     * The order in which the endpoint returns the activities, based on `created_at`. - `ASC` -
     * Oldest to newest. - `DESC` - Newest to oldest (default).
     * @return Returns the Internal String
     */
    @JsonGetter("sort_order")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetSortOrder() {
        return this.sortOrder;
    }

    /**
     * Getter for SortOrder.
     * The order in which the endpoint returns the activities, based on `created_at`. - `ASC` -
     * Oldest to newest. - `DESC` - Newest to oldest (default).
     * @return Returns the String
     */
    @JsonIgnore
    public String getSortOrder() {
        return OptionalNullable.getFrom(sortOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(giftCardId, type, locationId, beginTime, endTime, limit, cursor, sortOrder);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListGiftCardActivitiesRequest)) {
            return false;
        }
        ListGiftCardActivitiesRequest other = (ListGiftCardActivitiesRequest) obj;
        return Objects.equals(giftCardId, other.giftCardId)
                && Objects.equals(type, other.type)
                && Objects.equals(locationId, other.locationId)
                && Objects.equals(beginTime, other.beginTime)
                && Objects.equals(endTime, other.endTime)
                && Objects.equals(limit, other.limit)
                && Objects.equals(cursor, other.cursor)
                && Objects.equals(sortOrder, other.sortOrder);
    }

    /**
     * Converts this ListGiftCardActivitiesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListGiftCardActivitiesRequest [" + "giftCardId=" + giftCardId + ", type=" + type
                + ", locationId=" + locationId + ", beginTime=" + beginTime + ", endTime=" + endTime
                + ", limit=" + limit + ", cursor=" + cursor + ", sortOrder=" + sortOrder + "]";
    }

    /**
     * Builds a new {@link ListGiftCardActivitiesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListGiftCardActivitiesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.giftCardId = internalGetGiftCardId();
        builder.type = internalGetType();
        builder.locationId = internalGetLocationId();
        builder.beginTime = internalGetBeginTime();
        builder.endTime = internalGetEndTime();
        builder.limit = internalGetLimit();
        builder.cursor = internalGetCursor();
        builder.sortOrder = internalGetSortOrder();
        return builder;
    }

    /**
     * Class to build instances of {@link ListGiftCardActivitiesRequest}.
     */
    public static class Builder {
        private OptionalNullable<String> giftCardId;
        private OptionalNullable<String> type;
        private OptionalNullable<String> locationId;
        private OptionalNullable<String> beginTime;
        private OptionalNullable<String> endTime;
        private OptionalNullable<Integer> limit;
        private OptionalNullable<String> cursor;
        private OptionalNullable<String> sortOrder;

        /**
         * Setter for giftCardId.
         * @param  giftCardId  String value for giftCardId.
         * @return Builder
         */
        public Builder giftCardId(String giftCardId) {
            this.giftCardId = OptionalNullable.of(giftCardId);
            return this;
        }

        /**
         * UnSetter for giftCardId.
         * @return Builder
         */
        public Builder unsetGiftCardId() {
            giftCardId = null;
            return this;
        }

        /**
         * Setter for type.
         * @param  type  String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = OptionalNullable.of(type);
            return this;
        }

        /**
         * UnSetter for type.
         * @return Builder
         */
        public Builder unsetType() {
            type = null;
            return this;
        }

        /**
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = OptionalNullable.of(locationId);
            return this;
        }

        /**
         * UnSetter for locationId.
         * @return Builder
         */
        public Builder unsetLocationId() {
            locationId = null;
            return this;
        }

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
         * Setter for limit.
         * @param  limit  Integer value for limit.
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = OptionalNullable.of(limit);
            return this;
        }

        /**
         * UnSetter for limit.
         * @return Builder
         */
        public Builder unsetLimit() {
            limit = null;
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
         * Setter for sortOrder.
         * @param  sortOrder  String value for sortOrder.
         * @return Builder
         */
        public Builder sortOrder(String sortOrder) {
            this.sortOrder = OptionalNullable.of(sortOrder);
            return this;
        }

        /**
         * UnSetter for sortOrder.
         * @return Builder
         */
        public Builder unsetSortOrder() {
            sortOrder = null;
            return this;
        }

        /**
         * Builds a new {@link ListGiftCardActivitiesRequest} object using the set fields.
         * @return {@link ListGiftCardActivitiesRequest}
         */
        public ListGiftCardActivitiesRequest build() {
            return new ListGiftCardActivitiesRequest(
                    giftCardId, type, locationId, beginTime, endTime, limit, cursor, sortOrder);
        }
    }
}
