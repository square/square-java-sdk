package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1ListItemsRequest type.
 */
public class V1ListItemsRequest {

    /**
     * Initialization constructor.
     * @param batchToken
     */
    @JsonCreator
    public V1ListItemsRequest(
            @JsonProperty("batch_token") String batchToken) {
        this.batchToken = batchToken;
    }

    private final String batchToken;
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
        return Objects.hash(batchToken);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1ListItemsRequest)) {
            return false;
        }
        V1ListItemsRequest v1ListItemsRequest = (V1ListItemsRequest) obj;
        return Objects.equals(batchToken, v1ListItemsRequest.batchToken);
    }

    /**
     * Builds a new {@link V1ListItemsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1ListItemsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .batchToken(getBatchToken());
            return builder;
    }

    /**
     * Class to build instances of {@link V1ListItemsRequest}
     */
    public static class Builder {
        private String batchToken;

        /**
         * Initialization constructor
         */
        public Builder() {
           
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
         * Builds a new {@link V1ListItemsRequest} object using the set fields.
         * @return {@link V1ListItemsRequest}
         */
        public V1ListItemsRequest build() {
            return new V1ListItemsRequest(batchToken);
        }
    }
}
