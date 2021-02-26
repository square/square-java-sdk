
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for V1ListEmployeesRequest type.
 */
public class V1ListEmployeesRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String order;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String beginUpdatedAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String endUpdatedAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String beginCreatedAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String endCreatedAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String externalId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer limit;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String batchToken;

    /**
     * Initialization constructor.
     * @param  order  String value for order.
     * @param  beginUpdatedAt  String value for beginUpdatedAt.
     * @param  endUpdatedAt  String value for endUpdatedAt.
     * @param  beginCreatedAt  String value for beginCreatedAt.
     * @param  endCreatedAt  String value for endCreatedAt.
     * @param  status  String value for status.
     * @param  externalId  String value for externalId.
     * @param  limit  Integer value for limit.
     * @param  batchToken  String value for batchToken.
     */
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

    /**
     * Getter for Order.
     * The order (e.g., chronological or alphabetical) in which results from a request are returned.
     * @return Returns the String
     */
    @JsonGetter("order")
    public String getOrder() {
        return order;
    }

    /**
     * Getter for BeginUpdatedAt.
     * If filtering results by their updated_at field, the beginning of the requested reporting
     * period, in ISO 8601 format
     * @return Returns the String
     */
    @JsonGetter("begin_updated_at")
    public String getBeginUpdatedAt() {
        return beginUpdatedAt;
    }

    /**
     * Getter for EndUpdatedAt.
     * If filtering results by there updated_at field, the end of the requested reporting period, in
     * ISO 8601 format.
     * @return Returns the String
     */
    @JsonGetter("end_updated_at")
    public String getEndUpdatedAt() {
        return endUpdatedAt;
    }

    /**
     * Getter for BeginCreatedAt.
     * If filtering results by their created_at field, the beginning of the requested reporting
     * period, in ISO 8601 format.
     * @return Returns the String
     */
    @JsonGetter("begin_created_at")
    public String getBeginCreatedAt() {
        return beginCreatedAt;
    }

    /**
     * Getter for EndCreatedAt.
     * If filtering results by their created_at field, the end of the requested reporting period, in
     * ISO 8601 format.
     * @return Returns the String
     */
    @JsonGetter("end_created_at")
    public String getEndCreatedAt() {
        return endCreatedAt;
    }

    /**
     * Getter for Status.
     * @return Returns the String
     */
    @JsonGetter("status")
    public String getStatus() {
        return status;
    }

    /**
     * Getter for ExternalId.
     * If provided, the endpoint returns only employee entities with the specified external_id.
     * @return Returns the String
     */
    @JsonGetter("external_id")
    public String getExternalId() {
        return externalId;
    }

    /**
     * Getter for Limit.
     * The maximum integer number of employee entities to return in a single response. Default 100,
     * maximum 200.
     * @return Returns the Integer
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return limit;
    }

    /**
     * Getter for BatchToken.
     * A pagination cursor to retrieve the next set of results for your original query to the
     * endpoint.
     * @return Returns the String
     */
    @JsonGetter("batch_token")
    public String getBatchToken() {
        return batchToken;
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, beginUpdatedAt, endUpdatedAt, beginCreatedAt, endCreatedAt,
                status, externalId, limit, batchToken);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1ListEmployeesRequest)) {
            return false;
        }
        V1ListEmployeesRequest other = (V1ListEmployeesRequest) obj;
        return Objects.equals(order, other.order)
            && Objects.equals(beginUpdatedAt, other.beginUpdatedAt)
            && Objects.equals(endUpdatedAt, other.endUpdatedAt)
            && Objects.equals(beginCreatedAt, other.beginCreatedAt)
            && Objects.equals(endCreatedAt, other.endCreatedAt)
            && Objects.equals(status, other.status)
            && Objects.equals(externalId, other.externalId)
            && Objects.equals(limit, other.limit)
            && Objects.equals(batchToken, other.batchToken);
    }

    /**
     * Converts this V1ListEmployeesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1ListEmployeesRequest [" + "order=" + order + ", beginUpdatedAt=" + beginUpdatedAt
                + ", endUpdatedAt=" + endUpdatedAt + ", beginCreatedAt=" + beginCreatedAt
                + ", endCreatedAt=" + endCreatedAt + ", status=" + status + ", externalId="
                + externalId + ", limit=" + limit + ", batchToken=" + batchToken + "]";
    }

    /**
     * Builds a new {@link V1ListEmployeesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1ListEmployeesRequest.Builder} object
     */
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

    /**
     * Class to build instances of {@link V1ListEmployeesRequest}.
     */
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



        /**
         * Setter for order.
         * @param  order  String value for order.
         * @return Builder
         */
        public Builder order(String order) {
            this.order = order;
            return this;
        }

        /**
         * Setter for beginUpdatedAt.
         * @param  beginUpdatedAt  String value for beginUpdatedAt.
         * @return Builder
         */
        public Builder beginUpdatedAt(String beginUpdatedAt) {
            this.beginUpdatedAt = beginUpdatedAt;
            return this;
        }

        /**
         * Setter for endUpdatedAt.
         * @param  endUpdatedAt  String value for endUpdatedAt.
         * @return Builder
         */
        public Builder endUpdatedAt(String endUpdatedAt) {
            this.endUpdatedAt = endUpdatedAt;
            return this;
        }

        /**
         * Setter for beginCreatedAt.
         * @param  beginCreatedAt  String value for beginCreatedAt.
         * @return Builder
         */
        public Builder beginCreatedAt(String beginCreatedAt) {
            this.beginCreatedAt = beginCreatedAt;
            return this;
        }

        /**
         * Setter for endCreatedAt.
         * @param  endCreatedAt  String value for endCreatedAt.
         * @return Builder
         */
        public Builder endCreatedAt(String endCreatedAt) {
            this.endCreatedAt = endCreatedAt;
            return this;
        }

        /**
         * Setter for status.
         * @param  status  String value for status.
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Setter for externalId.
         * @param  externalId  String value for externalId.
         * @return Builder
         */
        public Builder externalId(String externalId) {
            this.externalId = externalId;
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
         * Setter for batchToken.
         * @param  batchToken  String value for batchToken.
         * @return Builder
         */
        public Builder batchToken(String batchToken) {
            this.batchToken = batchToken;
            return this;
        }

        /**
         * Builds a new {@link V1ListEmployeesRequest} object using the set fields.
         * @return {@link V1ListEmployeesRequest}
         */
        public V1ListEmployeesRequest build() {
            return new V1ListEmployeesRequest(order, beginUpdatedAt, endUpdatedAt, beginCreatedAt,
                    endCreatedAt, status, externalId, limit, batchToken);
        }
    }
}
