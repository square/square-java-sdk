package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1UpdateItemRequest type.
 */
public class V1UpdateItemRequest {

    /**
     * Initialization constructor.
     * @param body
     */
    @JsonCreator
    public V1UpdateItemRequest(
            @JsonProperty("body") V1Item body) {
        this.body = body;
    }

    private final V1Item body;
    /**
     * Getter for Body.
     * V1Item
     */
    @JsonGetter("body")
    public V1Item getBody() {
        return this.body;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(body);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1UpdateItemRequest)) {
            return false;
        }
        V1UpdateItemRequest v1UpdateItemRequest = (V1UpdateItemRequest) obj;
        return Objects.equals(body, v1UpdateItemRequest.body);
    }

    /**
     * Builds a new {@link V1UpdateItemRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1UpdateItemRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(body);
            return builder;
    }

    /**
     * Class to build instances of {@link V1UpdateItemRequest}
     */
    public static class Builder {
        private V1Item body;

        /**
         * Initialization constructor
         */
        public Builder(V1Item body) {
            this.body = body;
        }

        /**
         * Setter for body
         * @param body
         * @return Builder
         */
        public Builder body(V1Item body) {
            this.body = body;
            return this;
        }

        /**
         * Builds a new {@link V1UpdateItemRequest} object using the set fields.
         * @return {@link V1UpdateItemRequest}
         */
        public V1UpdateItemRequest build() {
            return new V1UpdateItemRequest(body);
        }
    }
}
