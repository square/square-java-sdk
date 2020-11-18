
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for V1ListTimecardsRequest type.
 */
public class V1ListTimecardsRequest {
    private final String order;
    private final String employeeId;
    private final String beginClockinTime;
    private final String endClockinTime;
    private final String beginClockoutTime;
    private final String endClockoutTime;
    private final String beginUpdatedAt;
    private final String endUpdatedAt;
    private final Boolean deleted;
    private final Integer limit;
    private final String batchToken;

    /**
     * Initialization constructor.
     * @param order String value for order.
     * @param employeeId String value for employeeId.
     * @param beginClockinTime String value for beginClockinTime.
     * @param endClockinTime String value for endClockinTime.
     * @param beginClockoutTime String value for beginClockoutTime.
     * @param endClockoutTime String value for endClockoutTime.
     * @param beginUpdatedAt String value for beginUpdatedAt.
     * @param endUpdatedAt String value for endUpdatedAt.
     * @param deleted Boolean value for deleted.
     * @param limit Integer value for limit.
     * @param batchToken String value for batchToken.
     */
    @JsonCreator
    public V1ListTimecardsRequest(
            @JsonProperty("order") String order,
            @JsonProperty("employee_id") String employeeId,
            @JsonProperty("begin_clockin_time") String beginClockinTime,
            @JsonProperty("end_clockin_time") String endClockinTime,
            @JsonProperty("begin_clockout_time") String beginClockoutTime,
            @JsonProperty("end_clockout_time") String endClockoutTime,
            @JsonProperty("begin_updated_at") String beginUpdatedAt,
            @JsonProperty("end_updated_at") String endUpdatedAt,
            @JsonProperty("deleted") Boolean deleted,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("batch_token") String batchToken) {
        this.order = order;
        this.employeeId = employeeId;
        this.beginClockinTime = beginClockinTime;
        this.endClockinTime = endClockinTime;
        this.beginClockoutTime = beginClockoutTime;
        this.endClockoutTime = endClockoutTime;
        this.beginUpdatedAt = beginUpdatedAt;
        this.endUpdatedAt = endUpdatedAt;
        this.deleted = deleted;
        this.limit = limit;
        this.batchToken = batchToken;
    }

    /**
     * Getter for Order.
     * The order (e.g., chronological or alphabetical) in which results from a request are returned.
     * @return Returns the String
     */
    @JsonGetter("order")
    public String getOrder() {
        return this.order;
    }

    /**
     * Getter for EmployeeId.
     * If provided, the endpoint returns only timecards for the employee with the specified ID.
     * @return Returns the String
     */
    @JsonGetter("employee_id")
    public String getEmployeeId() {
        return this.employeeId;
    }

    /**
     * Getter for BeginClockinTime.
     * If filtering results by their clockin_time field, the beginning of the requested reporting
     * period, in ISO 8601 format.
     * @return Returns the String
     */
    @JsonGetter("begin_clockin_time")
    public String getBeginClockinTime() {
        return this.beginClockinTime;
    }

    /**
     * Getter for EndClockinTime.
     * If filtering results by their clockin_time field, the end of the requested reporting period,
     * in ISO 8601 format.
     * @return Returns the String
     */
    @JsonGetter("end_clockin_time")
    public String getEndClockinTime() {
        return this.endClockinTime;
    }

    /**
     * Getter for BeginClockoutTime.
     * If filtering results by their clockout_time field, the beginning of the requested reporting
     * period, in ISO 8601 format.
     * @return Returns the String
     */
    @JsonGetter("begin_clockout_time")
    public String getBeginClockoutTime() {
        return this.beginClockoutTime;
    }

    /**
     * Getter for EndClockoutTime.
     * If filtering results by their clockout_time field, the end of the requested reporting period,
     * in ISO 8601 format.
     * @return Returns the String
     */
    @JsonGetter("end_clockout_time")
    public String getEndClockoutTime() {
        return this.endClockoutTime;
    }

    /**
     * Getter for BeginUpdatedAt.
     * If filtering results by their updated_at field, the beginning of the requested reporting
     * period, in ISO 8601 format.
     * @return Returns the String
     */
    @JsonGetter("begin_updated_at")
    public String getBeginUpdatedAt() {
        return this.beginUpdatedAt;
    }

    /**
     * Getter for EndUpdatedAt.
     * If filtering results by their updated_at field, the end of the requested reporting period, in
     * ISO 8601 format.
     * @return Returns the String
     */
    @JsonGetter("end_updated_at")
    public String getEndUpdatedAt() {
        return this.endUpdatedAt;
    }

    /**
     * Getter for Deleted.
     * If true, only deleted timecards are returned. If false, only valid timecards are returned.If
     * you don't provide this parameter, both valid and deleted timecards are returned.
     * @return Returns the Boolean
     */
    @JsonGetter("deleted")
    public Boolean getDeleted() {
        return this.deleted;
    }

    /**
     * Getter for Limit.
     * The maximum integer number of employee entities to return in a single response. Default 100,
     * maximum 200.
     * @return Returns the Integer
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return this.limit;
    }

    /**
     * Getter for BatchToken.
     * A pagination cursor to retrieve the next set of results for your original query to the
     * endpoint.
     * @return Returns the String
     */
    @JsonGetter("batch_token")
    public String getBatchToken() {
        return this.batchToken;
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, employeeId, beginClockinTime, endClockinTime, beginClockoutTime,
                endClockoutTime, beginUpdatedAt, endUpdatedAt, deleted, limit, batchToken);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1ListTimecardsRequest)) {
            return false;
        }
        V1ListTimecardsRequest other = (V1ListTimecardsRequest) obj;
        return Objects.equals(order, other.order)
            && Objects.equals(employeeId, other.employeeId)
            && Objects.equals(beginClockinTime, other.beginClockinTime)
            && Objects.equals(endClockinTime, other.endClockinTime)
            && Objects.equals(beginClockoutTime, other.beginClockoutTime)
            && Objects.equals(endClockoutTime, other.endClockoutTime)
            && Objects.equals(beginUpdatedAt, other.beginUpdatedAt)
            && Objects.equals(endUpdatedAt, other.endUpdatedAt)
            && Objects.equals(deleted, other.deleted)
            && Objects.equals(limit, other.limit)
            && Objects.equals(batchToken, other.batchToken);
    }

    /**
     * Converts this V1ListTimecardsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1ListTimecardsRequest [" + "order=" + order + ", employeeId=" + employeeId
                + ", beginClockinTime=" + beginClockinTime + ", endClockinTime=" + endClockinTime
                + ", beginClockoutTime=" + beginClockoutTime + ", endClockoutTime="
                + endClockoutTime + ", beginUpdatedAt=" + beginUpdatedAt + ", endUpdatedAt="
                + endUpdatedAt + ", deleted=" + deleted + ", limit=" + limit + ", batchToken="
                + batchToken + "]";
    }

    /**
     * Builds a new {@link V1ListTimecardsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1ListTimecardsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .order(getOrder())
                .employeeId(getEmployeeId())
                .beginClockinTime(getBeginClockinTime())
                .endClockinTime(getEndClockinTime())
                .beginClockoutTime(getBeginClockoutTime())
                .endClockoutTime(getEndClockoutTime())
                .beginUpdatedAt(getBeginUpdatedAt())
                .endUpdatedAt(getEndUpdatedAt())
                .deleted(getDeleted())
                .limit(getLimit())
                .batchToken(getBatchToken());
        return builder;
    }

    /**
     * Class to build instances of {@link V1ListTimecardsRequest}.
     */
    public static class Builder {
        private String order;
        private String employeeId;
        private String beginClockinTime;
        private String endClockinTime;
        private String beginClockoutTime;
        private String endClockoutTime;
        private String beginUpdatedAt;
        private String endUpdatedAt;
        private Boolean deleted;
        private Integer limit;
        private String batchToken;



        /**
         * Setter for order.
         * @param order String value for order.
         * @return Builder
         */
        public Builder order(String order) {
            this.order = order;
            return this;
        }

        /**
         * Setter for employeeId.
         * @param employeeId String value for employeeId.
         * @return Builder
         */
        public Builder employeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        /**
         * Setter for beginClockinTime.
         * @param beginClockinTime String value for beginClockinTime.
         * @return Builder
         */
        public Builder beginClockinTime(String beginClockinTime) {
            this.beginClockinTime = beginClockinTime;
            return this;
        }

        /**
         * Setter for endClockinTime.
         * @param endClockinTime String value for endClockinTime.
         * @return Builder
         */
        public Builder endClockinTime(String endClockinTime) {
            this.endClockinTime = endClockinTime;
            return this;
        }

        /**
         * Setter for beginClockoutTime.
         * @param beginClockoutTime String value for beginClockoutTime.
         * @return Builder
         */
        public Builder beginClockoutTime(String beginClockoutTime) {
            this.beginClockoutTime = beginClockoutTime;
            return this;
        }

        /**
         * Setter for endClockoutTime.
         * @param endClockoutTime String value for endClockoutTime.
         * @return Builder
         */
        public Builder endClockoutTime(String endClockoutTime) {
            this.endClockoutTime = endClockoutTime;
            return this;
        }

        /**
         * Setter for beginUpdatedAt.
         * @param beginUpdatedAt String value for beginUpdatedAt.
         * @return Builder
         */
        public Builder beginUpdatedAt(String beginUpdatedAt) {
            this.beginUpdatedAt = beginUpdatedAt;
            return this;
        }

        /**
         * Setter for endUpdatedAt.
         * @param endUpdatedAt String value for endUpdatedAt.
         * @return Builder
         */
        public Builder endUpdatedAt(String endUpdatedAt) {
            this.endUpdatedAt = endUpdatedAt;
            return this;
        }

        /**
         * Setter for deleted.
         * @param deleted Boolean value for deleted.
         * @return Builder
         */
        public Builder deleted(Boolean deleted) {
            this.deleted = deleted;
            return this;
        }

        /**
         * Setter for limit.
         * @param limit Integer value for limit.
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Setter for batchToken.
         * @param batchToken String value for batchToken.
         * @return Builder
         */
        public Builder batchToken(String batchToken) {
            this.batchToken = batchToken;
            return this;
        }

        /**
         * Builds a new {@link V1ListTimecardsRequest} object using the set fields.
         * @return {@link V1ListTimecardsRequest}
         */
        public V1ListTimecardsRequest build() {
            return new V1ListTimecardsRequest(order, employeeId, beginClockinTime, endClockinTime,
                    beginClockoutTime, endClockoutTime, beginUpdatedAt, endUpdatedAt, deleted,
                    limit, batchToken);
        }
    }
}
