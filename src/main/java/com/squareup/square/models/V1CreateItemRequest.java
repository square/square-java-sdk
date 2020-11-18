
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for V1CreateItemRequest type.
 */
public class V1CreateItemRequest {
    private final V1Item body;

    /**
     * Initialization constructor.
     * @param body V1Item value for body.
     */
    @JsonCreator
    public V1CreateItemRequest(
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
        if (!(obj instanceof V1CreateItemRequest)) {
            return false;
        }
        V1CreateItemRequest other = (V1CreateItemRequest) obj;
        return Objects.equals(body, other.body);
    }

    /**
     * Converts this V1CreateItemRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1CreateItemRequest [" + "body=" + body + "]";
    }

    /**
     * Builds a new {@link V1CreateItemRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1CreateItemRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .body(getBody());
        return builder;
    }

    /**
     * Class to build instances of {@link V1CreateItemRequest}.
     */
    public static class Builder {
        private V1Item body;



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
         * Builds a new {@link V1CreateItemRequest} object using the set fields.
         * @return {@link V1CreateItemRequest}
         */
        public V1CreateItemRequest build() {
            return new V1CreateItemRequest(body);
        }
    }
}
