package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1ListInventoryRequest type.
 */
public class V1ListInventoryRequest {

    /**
     * Initialization constructor.
     * @param limit
     * @param batchToken
     */
    @JsonCreator
    public V1ListInventoryRequest(
            @JsonProperty("limit") Integer limit,
            @JsonProperty("batch_token") String batchToken) {
        this.limit = limit;
        this.batchToken = batchToken;
    }

    private final Integer limit;
    private final String batchToken;
    /**
     * Getter for Limit.
     * The maximum number of inventory entries to return in a single response. This value cannot exceed 1000.
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

 
    @Override
    public int hashCode() {
        return Objects.hash(limit, batchToken);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1ListInventoryRequest)) {
            return false;
        }
        V1ListInventoryRequest v1ListInventoryRequest = (V1ListInventoryRequest) obj;
        return Objects.equals(limit, v1ListInventoryRequest.limit) &&
            Objects.equals(batchToken, v1ListInventoryRequest.batchToken);
    }

    /**
     * Builds a new {@link V1ListInventoryRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1ListInventoryRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .limit(getLimit())
            .batchToken(getBatchToken());
            return builder;
    }

    /**
     * Class to build instances of {@link V1ListInventoryRequest}
     */
    public static class Builder {
        private Integer limit;
        private String batchToken;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for limit
         * @param limit
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }
        /**
         * Setter for batchToken
         * @param batchToken
         * @return Builder
         */
        public Builder batchToken(String batchToken) {
            this.batchToken = batchToken;
            return this;
        }

        /**
         * Builds a new {@link V1ListInventoryRequest} object using the set fields.
         * @return {@link V1ListInventoryRequest}
         */
        public V1ListInventoryRequest build() {
            return new V1ListInventoryRequest(limit,
                batchToken);
        }
    }
}
