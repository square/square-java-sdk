
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for V1UpdateItemRequest type.
 */
public class V1UpdateItemRequest {
    private final V1Item body;

    /**
     * Initialization constructor.
     * @param body V1Item value for body.
     */
    @JsonCreator
    public V1UpdateItemRequest(
            @JsonProperty("body") V1Item body) {
        this.body = body;
    }

    /**
     * Getter for Body.
     * V1Item
     * @return Returns the V1Item
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1UpdateItemRequest)) {
            return false;
        }
        V1UpdateItemRequest other = (V1UpdateItemRequest) obj;
        return Objects.equals(body, other.body);
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
     * Class to build instances of {@link V1UpdateItemRequest}.
     */
    public static class Builder {
        private V1Item body;

        /**
         * Initialization constructor.
         * @param body V1Item value for body.
         */
        public Builder(V1Item body) {
            this.body = body;
        }

        /**
         * Setter for body.
         * @param body V1Item value for body.
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
