
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for ListGiftCardActivitiesRequest type.
 */
public class ListGiftCardActivitiesRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String giftCardId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String type;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String locationId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String beginTime;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String endTime;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer limit;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cursor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String sortOrder;

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
     * Getter for GiftCardId.
     * If a gift card ID is provided, the endpoint returns activities related to the specified gift
     * card. Otherwise, the endpoint returns all gift card activities for the seller.
     * @return Returns the String
     */
    @JsonGetter("gift_card_id")
    public String getGiftCardId() {
        return giftCardId;
    }

    /**
     * Getter for Type.
     * If a [type]($m/GiftCardActivityType) is provided, the endpoint returns gift card activities
     * of the specified type. Otherwise, the endpoint returns all types of gift card activities.
     * @return Returns the String
     */
    @JsonGetter("type")
    public String getType() {
        return type;
    }

    /**
     * Getter for LocationId.
     * If a location ID is provided, the endpoint returns gift card activities for the specified
     * location. Otherwise, the endpoint returns gift card activities for all locations.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for BeginTime.
     * The timestamp for the beginning of the reporting period, in RFC 3339 format. This start time
     * is inclusive. The default value is the current time minus one year.
     * @return Returns the String
     */
    @JsonGetter("begin_time")
    public String getBeginTime() {
        return beginTime;
    }

    /**
     * Getter for EndTime.
     * The timestamp for the end of the reporting period, in RFC 3339 format. This end time is
     * inclusive. The default value is the current time.
     * @return Returns the String
     */
    @JsonGetter("end_time")
    public String getEndTime() {
        return endTime;
    }

    /**
     * Getter for Limit.
     * If a limit is provided, the endpoint returns the specified number of results (or fewer) per
     * page. The maximum value is 100. The default value is 50. For more information, see
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @return Returns the Integer
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return limit;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this cursor to
     * retrieve the next set of results for the original query. If a cursor is not provided, the
     * endpoint returns the first page of the results. For more information, see
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return cursor;
    }

    /**
     * Getter for SortOrder.
     * The order in which the endpoint returns the activities, based on `created_at`. - `ASC` -
     * Oldest to newest. - `DESC` - Newest to oldest (default).
     * @return Returns the String
     */
    @JsonGetter("sort_order")
    public String getSortOrder() {
        return sortOrder;
    }

    @Override
    public int hashCode() {
        return Objects.hash(giftCardId, type, locationId, beginTime, endTime, limit, cursor,
                sortOrder);
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
        Builder builder = new Builder()
                .giftCardId(getGiftCardId())
                .type(getType())
                .locationId(getLocationId())
                .beginTime(getBeginTime())
                .endTime(getEndTime())
                .limit(getLimit())
                .cursor(getCursor())
                .sortOrder(getSortOrder());
        return builder;
    }

    /**
     * Class to build instances of {@link ListGiftCardActivitiesRequest}.
     */
    public static class Builder {
        private String giftCardId;
        private String type;
        private String locationId;
        private String beginTime;
        private String endTime;
        private Integer limit;
        private String cursor;
        private String sortOrder;



        /**
         * Setter for giftCardId.
         * @param  giftCardId  String value for giftCardId.
         * @return Builder
         */
        public Builder giftCardId(String giftCardId) {
            this.giftCardId = giftCardId;
            return this;
        }

        /**
         * Setter for type.
         * @param  type  String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

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
         * Setter for limit.
         * @param  limit  Integer value for limit.
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
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
         * Setter for sortOrder.
         * @param  sortOrder  String value for sortOrder.
         * @return Builder
         */
        public Builder sortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }

        /**
         * Builds a new {@link ListGiftCardActivitiesRequest} object using the set fields.
         * @return {@link ListGiftCardActivitiesRequest}
         */
        public ListGiftCardActivitiesRequest build() {
            return new ListGiftCardActivitiesRequest(giftCardId, type, locationId, beginTime,
                    endTime, limit, cursor, sortOrder);
        }
    }
}
