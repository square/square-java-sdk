package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1CreateDiscountRequest type.
 */
public class V1CreateDiscountRequest {

    /**
     * Initialization constructor.
     * @param body
     */
    @JsonCreator
    public V1CreateDiscountRequest(
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
        if(!(obj instanceof V1CreateDiscountRequest)) {
            return false;
        }
        V1CreateDiscountRequest v1CreateDiscountRequest = (V1CreateDiscountRequest) obj;
        return Objects.equals(body, v1CreateDiscountRequest.body);
    }

    /**
     * Builds a new {@link V1CreateDiscountRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1CreateDiscountRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .body(getBody());
            return builder;
    }

    /**
     * Class to build instances of {@link V1CreateDiscountRequest}
     */
    public static class Builder {
        private V1Discount body;

        /**
         * Initialization constructor
         */
        public Builder() {
           
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
         * Builds a new {@link V1CreateDiscountRequest} object using the set fields.
         * @return {@link V1CreateDiscountRequest}
         */
        public V1CreateDiscountRequest build() {
            return new V1CreateDiscountRequest(body);
        }
    }
}
