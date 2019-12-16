package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1ListInventoryRequest {

    @JsonCreator
    public V1ListInventoryRequest(
            @JsonProperty("limit") Integer limit,
            @JsonProperty("batch_token") String batchToken) {
        this.limit = limit;
        this.batchToken = batchToken;
    }

    private final Integer limit;
    private final String batchToken;

    @Override
    public int hashCode() {
        return Objects.hash(limit, batchToken);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1ListInventoryRequest)) {
            return false;
        }
        V1ListInventoryRequest v1ListInventoryRequest = (V1ListInventoryRequest) o;
        return Objects.equals(limit, v1ListInventoryRequest.limit) &&
            Objects.equals(batchToken, v1ListInventoryRequest.batchToken);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .limit(getLimit())
            .batchToken(getBatchToken());
            return builder;
    }

    public static class Builder {
        private Integer limit;
        private String batchToken;

        public Builder() { }

        public Builder limit(Integer value) {
            limit = value;
            return this;
        }
        public Builder batchToken(String value) {
            batchToken = value;
            return this;
        }

        public V1ListInventoryRequest build() {
            return new V1ListInventoryRequest(limit,
                batchToken);
        }
    }
}
