
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for V1UpdateVariationRequest type.
 */
public class V1UpdateVariationRequest {
    private final V1Variation body;

    /**
     * Initialization constructor.
     * @param body V1Variation value for body.
     */
    @JsonCreator
    public V1UpdateVariationRequest(
            @JsonProperty("body") V1Variation body) {
        this.body = body;
    }

    /**
     * Getter for Body.
     * V1Variation
     * @return Returns the V1Variation
     */
    @JsonGetter("body")
    public V1Variation getBody() {
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
        if (!(obj instanceof V1UpdateVariationRequest)) {
            return false;
        }
        V1UpdateVariationRequest other = (V1UpdateVariationRequest) obj;
        return Objects.equals(body, other.body);
    }

    /**
     * Builds a new {@link V1UpdateVariationRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1UpdateVariationRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(body);
        return builder;
    }

    /**
     * Class to build instances of {@link V1UpdateVariationRequest}.
     */
    public static class Builder {
        private V1Variation body;

        /**
         * Initialization constructor.
         * @param body V1Variation value for body.
         */
        public Builder(V1Variation body) {
            this.body = body;
        }

        /**
         * Setter for body.
         * @param body V1Variation value for body.
         * @return Builder
         */
        public Builder body(V1Variation body) {
            this.body = body;
            return this;
        }

        /**
         * Builds a new {@link V1UpdateVariationRequest} object using the set fields.
         * @return {@link V1UpdateVariationRequest}
         */
        public V1UpdateVariationRequest build() {
            return new V1UpdateVariationRequest(body);
        }
    }
}
