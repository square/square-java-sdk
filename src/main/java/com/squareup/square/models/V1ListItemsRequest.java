package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1ListItemsRequest {

    @JsonCreator
    public V1ListItemsRequest(
            @JsonProperty("batch_token") String batchToken) {
        this.batchToken = batchToken;
    }

    private final String batchToken;

    @Override
    public int hashCode() {
        return Objects.hash(batchToken);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1ListItemsRequest)) {
            return false;
        }
        V1ListItemsRequest v1ListItemsRequest = (V1ListItemsRequest) o;
        return Objects.equals(batchToken, v1ListItemsRequest.batchToken);
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
            .batchToken(getBatchToken());
            return builder;
    }

    public static class Builder {
        private String batchToken;

        public Builder() { }

        public Builder batchToken(String value) {
            batchToken = value;
            return this;
        }

        public V1ListItemsRequest build() {
            return new V1ListItemsRequest(batchToken);
        }
    }
}
