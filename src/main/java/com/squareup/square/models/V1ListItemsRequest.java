
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for V1ListItemsRequest type.
 */
public class V1ListItemsRequest {
    private final String batchToken;

    /**
     * Initialization constructor.
     * @param batchToken String value for batchToken.
     */
    @JsonCreator
    public V1ListItemsRequest(
            @JsonProperty("batch_token") String batchToken) {
        this.batchToken = batchToken;
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
        return Objects.hash(batchToken);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1ListItemsRequest)) {
            return false;
        }
        V1ListItemsRequest other = (V1ListItemsRequest) obj;
        return Objects.equals(batchToken, other.batchToken);
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
     * Class to build instances of {@link V1ListItemsRequest}.
     */
    public static class Builder {
        private String batchToken;



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
         * Builds a new {@link V1ListItemsRequest} object using the set fields.
         * @return {@link V1ListItemsRequest}
         */
        public V1ListItemsRequest build() {
            return new V1ListItemsRequest(batchToken);
        }
    }
}
