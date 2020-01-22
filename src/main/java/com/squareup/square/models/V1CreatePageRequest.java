package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1CreatePageRequest type.
 */
public class V1CreatePageRequest {

    /**
     * Initialization constructor.
     * @param body
     */
    @JsonCreator
    public V1CreatePageRequest(
            @JsonProperty("body") V1Page body) {
        this.body = body;
    }

    private final V1Page body;
    /**
     * Getter for Body.
     * V1Page
     */
    @JsonGetter("body")
    public V1Page getBody() {
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
        if(!(obj instanceof V1CreatePageRequest)) {
            return false;
        }
        V1CreatePageRequest v1CreatePageRequest = (V1CreatePageRequest) obj;
        return Objects.equals(body, v1CreatePageRequest.body);
    }

    /**
     * Builds a new {@link V1CreatePageRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1CreatePageRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .body(getBody());
            return builder;
    }

    /**
     * Class to build instances of {@link V1CreatePageRequest}
     */
    public static class Builder {
        private V1Page body;

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
        public Builder body(V1Page body) {
            this.body = body;
            return this;
        }

        /**
         * Builds a new {@link V1CreatePageRequest} object using the set fields.
         * @return {@link V1CreatePageRequest}
         */
        public V1CreatePageRequest build() {
            return new V1CreatePageRequest(body);
        }
    }
}
