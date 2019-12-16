package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1ListEmployeesRequest {

    @JsonCreator
    public V1ListEmployeesRequest(
            @JsonProperty("order") String order,
            @JsonProperty("begin_updated_at") String beginUpdatedAt,
            @JsonProperty("end_updated_at") String endUpdatedAt,
            @JsonProperty("begin_created_at") String beginCreatedAt,
            @JsonProperty("end_created_at") String endCreatedAt,
            @JsonProperty("status") String status,
            @JsonProperty("external_id") String externalId,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("batch_token") String batchToken) {
        this.order = order;
        this.beginUpdatedAt = beginUpdatedAt;
        this.endUpdatedAt = endUpdatedAt;
        this.beginCreatedAt = beginCreatedAt;
        this.endCreatedAt = endCreatedAt;
        this.status = status;
        this.externalId = externalId;
        this.limit = limit;
        this.batchToken = batchToken;
    }

    private final String order;
    private final String beginUpdatedAt;
    private final String endUpdatedAt;
    private final String beginCreatedAt;
    private final String endCreatedAt;
    private final String status;
    private final String externalId;
    private final Integer limit;
    private final String batchToken;

    @Override
    public int hashCode() {
        return Objects.hash(order, beginUpdatedAt, endUpdatedAt, beginCreatedAt, endCreatedAt, status, externalId, limit, batchToken);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1ListEmployeesRequest)) {
            return false;
        }
        V1ListEmployeesRequest v1ListEmployeesRequest = (V1ListEmployeesRequest) o;
        return Objects.equals(order, v1ListEmployeesRequest.order) &&
            Objects.equals(beginUpdatedAt, v1ListEmployeesRequest.beginUpdatedAt) &&
            Objects.equals(endUpdatedAt, v1ListEmployeesRequest.endUpdatedAt) &&
            Objects.equals(beginCreatedAt, v1ListEmployeesRequest.beginCreatedAt) &&
            Objects.equals(endCreatedAt, v1ListEmployeesRequest.endCreatedAt) &&
            Objects.equals(status, v1ListEmployeesRequest.status) &&
            Objects.equals(externalId, v1ListEmployeesRequest.externalId) &&
            Objects.equals(limit, v1ListEmployeesRequest.limit) &&
            Objects.equals(batchToken, v1ListEmployeesRequest.batchToken);
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
     * Getter for BeginUpdatedAt.
     * If filtering results by their updated_at field, the beginning of the requested reporting period, in ISO 8601 format
     */
    @JsonGetter("begin_updated_at")
    public String getBeginUpdatedAt() { 
        return this.beginUpdatedAt;
    }

    /**
     * Getter for EndUpdatedAt.
     * If filtering results by there updated_at field, the end of the requested reporting period, in ISO 8601 format.
     */
    @JsonGetter("end_updated_at")
    public String getEndUpdatedAt() { 
        return this.endUpdatedAt;
    }

    /**
     * Getter for BeginCreatedAt.
     * If filtering results by their created_at field, the beginning of the requested reporting period, in ISO 8601 format.
     */
    @JsonGetter("begin_created_at")
    public String getBeginCreatedAt() { 
        return this.beginCreatedAt;
    }

    /**
     * Getter for EndCreatedAt.
     * If filtering results by their created_at field, the end of the requested reporting period, in ISO 8601 format.
     */
    @JsonGetter("end_created_at")
    public String getEndCreatedAt() { 
        return this.endCreatedAt;
    }

    /**
     * Getter for Status.
     */
    @JsonGetter("status")
    public String getStatus() { 
        return this.status;
    }

    /**
     * Getter for ExternalId.
     * If provided, the endpoint returns only employee entities with the specified external_id.
     */
    @JsonGetter("external_id")
    public String getExternalId() { 
        return this.externalId;
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
            .beginUpdatedAt(getBeginUpdatedAt())
            .endUpdatedAt(getEndUpdatedAt())
            .beginCreatedAt(getBeginCreatedAt())
            .endCreatedAt(getEndCreatedAt())
            .status(getStatus())
            .externalId(getExternalId())
            .limit(getLimit())
            .batchToken(getBatchToken());
            return builder;
    }

    public static class Builder {
        private String order;
        private String beginUpdatedAt;
        private String endUpdatedAt;
        private String beginCreatedAt;
        private String endCreatedAt;
        private String status;
        private String externalId;
        private Integer limit;
        private String batchToken;

        public Builder() { }

        public Builder order(String value) {
            order = value;
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
        public Builder beginCreatedAt(String value) {
            beginCreatedAt = value;
            return this;
        }
        public Builder endCreatedAt(String value) {
            endCreatedAt = value;
            return this;
        }
        public Builder status(String value) {
            status = value;
            return this;
        }
        public Builder externalId(String value) {
            externalId = value;
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

        public V1ListEmployeesRequest build() {
            return new V1ListEmployeesRequest(order,
                beginUpdatedAt,
                endUpdatedAt,
                beginCreatedAt,
                endCreatedAt,
                status,
                externalId,
                limit,
                batchToken);
        }
    }
}
