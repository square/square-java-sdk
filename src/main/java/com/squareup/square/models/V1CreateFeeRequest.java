
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for V1CreateFeeRequest type.
 */
public class V1CreateFeeRequest {
    private final V1Fee body;

    /**
     * Initialization constructor.
     * @param body V1Fee value for body.
     */
    @JsonCreator
    public V1CreateFeeRequest(
            @JsonProperty("body") V1Fee body) {
        this.body = body;
    }

    /**
     * Getter for Body.
     * V1Fee
     * @return Returns the V1Fee
     */
    @JsonGetter("body")
    public V1Fee getBody() {
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
        if (!(obj instanceof V1CreateFeeRequest)) {
            return false;
        }
        V1CreateFeeRequest other = (V1CreateFeeRequest) obj;
        return Objects.equals(body, other.body);
    }

    /**
     * Builds a new {@link V1CreateFeeRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1CreateFeeRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .body(getBody());
        return builder;
    }

    /**
     * Class to build instances of {@link V1CreateFeeRequest}.
     */
    public static class Builder {
        private V1Fee body;



        /**
         * Setter for body.
         * @param body V1Fee value for body.
         * @return Builder
         */
        public Builder body(V1Fee body) {
            this.body = body;
            return this;
        }

        /**
         * Builds a new {@link V1CreateFeeRequest} object using the set fields.
         * @return {@link V1CreateFeeRequest}
         */
        public V1CreateFeeRequest build() {
            return new V1CreateFeeRequest(body);
        }
    }
}
