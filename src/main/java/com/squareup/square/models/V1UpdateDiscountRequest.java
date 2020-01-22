package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1UpdateDiscountRequest type.
 */
public class V1UpdateDiscountRequest {

    /**
     * Initialization constructor.
     * @param body
     */
    @JsonCreator
    public V1UpdateDiscountRequest(
            @JsonProperty("body") V1Discount body) {
        this.body = body;
    }

    private final V1Discount body;
    /**
     * Getter for Body.
     * V1Discount
     */
    @JsonGetter("body")
    public V1Discount getBody() {
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
        if(!(obj instanceof V1UpdateDiscountRequest)) {
            return false;
        }
        V1UpdateDiscountRequest v1UpdateDiscountRequest = (V1UpdateDiscountRequest) obj;
        return Objects.equals(body, v1UpdateDiscountRequest.body);
    }

    /**
     * Builds a new {@link V1UpdateDiscountRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1UpdateDiscountRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(body);
            return builder;
    }

    /**
     * Class to build instances of {@link V1UpdateDiscountRequest}
     */
    public static class Builder {
        private V1Discount body;

        /**
         * Initialization constructor
         */
        public Builder(V1Discount body) {
            this.body = body;
        }

        /**
         * Setter for body
         * @param body
         * @return Builder
         */
        public Builder body(V1Discount body) {
            this.body = body;
            return this;
        }

        /**
         * Builds a new {@link V1UpdateDiscountRequest} object using the set fields.
         * @return {@link V1UpdateDiscountRequest}
         */
        public V1UpdateDiscountRequest build() {
            return new V1UpdateDiscountRequest(body);
        }
    }
}
