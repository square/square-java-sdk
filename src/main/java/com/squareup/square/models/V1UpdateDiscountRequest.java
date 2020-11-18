
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for V1UpdateDiscountRequest type.
 */
public class V1UpdateDiscountRequest {
    private final V1Discount body;

    /**
     * Initialization constructor.
     * @param body V1Discount value for body.
     */
    @JsonCreator
    public V1UpdateDiscountRequest(
            @JsonProperty("body") V1Discount body) {
        this.body = body;
    }

    /**
     * Getter for Body.
     * V1Discount
     * @return Returns the V1Discount
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1UpdateDiscountRequest)) {
            return false;
        }
        V1UpdateDiscountRequest other = (V1UpdateDiscountRequest) obj;
        return Objects.equals(body, other.body);
    }

    /**
     * Converts this V1UpdateDiscountRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1UpdateDiscountRequest [" + "body=" + body + "]";
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
     * Class to build instances of {@link V1UpdateDiscountRequest}.
     */
    public static class Builder {
        private V1Discount body;

        /**
         * Initialization constructor.
         * @param body V1Discount value for body.
         */
        public Builder(V1Discount body) {
            this.body = body;
        }

        /**
         * Setter for body.
         * @param body V1Discount value for body.
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
