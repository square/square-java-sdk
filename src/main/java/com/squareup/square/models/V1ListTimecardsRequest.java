package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1ListTimecardsRequest {

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

    @Override
    public int hashCode() {
        return Objects.hash(order, employeeId, beginClockinTime, endClockinTime, beginClockoutTime, endClockoutTime, beginUpdatedAt, endUpdatedAt, deleted, limit, batchToken);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1ListTimecardsRequest)) {
            return false;
        }
        V1ListTimecardsRequest v1ListTimecardsRequest = (V1ListTimecardsRequest) o;
        return Objects.equals(order, v1ListTimecardsRequest.order) &&
            Objects.equals(employeeId, v1ListTimecardsRequest.employeeId) &&
            Objects.equals(beginClockinTime, v1ListTimecardsRequest.beginClockinTime) &&
            Objects.equals(endClockinTime, v1ListTimecardsRequest.endClockinTime) &&
            Objects.equals(beginClockoutTime, v1ListTimecardsRequest.beginClockoutTime) &&
            Objects.equals(endClockoutTime, v1ListTimecardsRequest.endClockoutTime) &&
            Objects.equals(beginUpdatedAt, v1ListTimecardsRequest.beginUpdatedAt) &&
            Objects.equals(endUpdatedAt, v1ListTimecardsRequest.endUpdatedAt) &&
            Objects.equals(deleted, v1ListTimecardsRequest.deleted) &&
            Objects.equals(limit, v1ListTimecardsRequest.limit) &&
            Objects.equals(batchToken, v1ListTimecardsRequest.batchToken);
    }

    /**
     * Getter for Order.
     * The order (e.g., chronological or alphabetical) in which results from a request are returned.
     */
    @JsonGetter("order")
    public String getOrder() { 
        return this.order;
    }

    /**
     * Getter for EmployeeId.
     * If provided, the endpoint returns only timecards for the employee with the specified ID.
     */
    @JsonGetter("employee_id")
    public String getEmployeeId() { 
        return this.employeeId;
    }

    /**
     * Getter for BeginClockinTime.
     * If filtering results by their clockin_time field, the beginning of the requested reporting period, in ISO 8601 format.
     */
    @JsonGetter("begin_clockin_time")
    public String getBeginClockinTime() { 
        return this.beginClockinTime;
    }

    /**
     * Getter for EndClockinTime.
     * If filtering results by their clockin_time field, the end of the requested reporting period, in ISO 8601 format.
     */
    @JsonGetter("end_clockin_time")
    public String getEndClockinTime() { 
        return this.endClockinTime;
    }

    /**
     * Getter for BeginClockoutTime.
     * If filtering results by their clockout_time field, the beginning of the requested reporting period, in ISO 8601 format.
     */
    @JsonGetter("begin_clockout_time")
    public String getBeginClockoutTime() { 
        return this.beginClockoutTime;
    }

    /**
     * Getter for EndClockoutTime.
     * If filtering results by their clockout_time field, the end of the requested reporting period, in ISO 8601 format.
     */
    @JsonGetter("end_clockout_time")
    public String getEndClockoutTime() { 
        return this.endClockoutTime;
    }

    /**
     * Getter for BeginUpdatedAt.
     * If filtering results by their updated_at field, the beginning of the requested reporting period, in ISO 8601 format.
     */
    @JsonGetter("begin_updated_at")
    public String getBeginUpdatedAt() { 
        return this.beginUpdatedAt;
    }

    /**
     * Getter for EndUpdatedAt.
     * If filtering results by their updated_at field, the end of the requested reporting period, in ISO 8601 format.
     */
    @JsonGetter("end_updated_at")
    public String getEndUpdatedAt() { 
        return this.endUpdatedAt;
    }

    /**
     * Getter for Deleted.
     * If true, only deleted timecards are returned. If false, only valid timecards are returned.If you don't provide this parameter, both valid and deleted timecards are returned.
     */
    @JsonGetter("deleted")
    public Boolean getDeleted() { 
        return this.deleted;
    }

    /**
     * Getter for Limit.
     * The maximum integer number of employee entities to return in a single response. Default 100, maximum 200.
     */
    @JsonGetter("limit")
    public Integer getLimit() { 
        return this.limit;
    }

    /**
     * Getter for BatchToken.
     * A pagination cursor to retrieve the next set of results for your
     * original query to the endpoint.
     */
    @JsonGetter("batch_token")
    public String getBatchToken() { 
        return this.batchToken;
    }

 
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

        public Builder() { }

        public Builder order(String value) {
            order = value;
            return this;
        }
        public Builder employeeId(String value) {
            employeeId = value;
            return this;
        }
        public Builder beginClockinTime(String value) {
            beginClockinTime = value;
            return this;
        }
        public Builder endClockinTime(String value) {
            endClockinTime = value;
            return this;
        }
        public Builder beginClockoutTime(String value) {
            beginClockoutTime = value;
            return this;
        }
        public Builder endClockoutTime(String value) {
            endClockoutTime = value;
            return this;
        }
        public Builder beginUpdatedAt(String value) {
            beginUpdatedAt = value;
            return this;
        }
        public Builder endUpdatedAt(String value) {
            endUpdatedAt = value;
            return this;
        }
        public Builder deleted(Boolean value) {
            deleted = value;
            return this;
        }
        public Builder limit(Integer value) {
            limit = value;
            return this;
        }
        public Builder batchToken(String value) {
            batchToken = value;
            return this;
        }

        public V1ListTimecardsRequest build() {
            return new V1ListTimecardsRequest(order,
                employeeId,
                beginClockinTime,
                endClockinTime,
                beginClockoutTime,
                endClockoutTime,
                beginUpdatedAt,
                endUpdatedAt,
                deleted,
                limit,
                batchToken);
        }
    }
}
