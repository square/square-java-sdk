package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1UpdateCategoryRequest type.
 */
public class V1UpdateCategoryRequest {

    /**
     * Initialization constructor.
     * @param body
     */
    @JsonCreator
    public V1UpdateCategoryRequest(
            @JsonProperty("body") V1Category body) {
        this.body = body;
    }

    private final V1Category body;
    /**
     * Getter for Body.
     * V1Category
     */
    @JsonGetter("body")
    public V1Category getBody() {
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
        if(!(obj instanceof V1UpdateCategoryRequest)) {
            return false;
        }
        V1UpdateCategoryRequest v1UpdateCategoryRequest = (V1UpdateCategoryRequest) obj;
        return Objects.equals(body, v1UpdateCategoryRequest.body);
    }

    /**
     * Builds a new {@link V1UpdateCategoryRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1UpdateCategoryRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(body);
            return builder;
    }

    /**
     * Class to build instances of {@link V1UpdateCategoryRequest}
     */
    public static class Builder {
        private V1Category body;

        /**
         * Initialization constructor
         */
        public Builder(V1Category body) {
            this.body = body;
        }

        /**
         * Setter for body
         * @param body
         * @return Builder
         */
        public Builder body(V1Category body) {
            this.body = body;
            return this;
        }

        /**
         * Builds a new {@link V1UpdateCategoryRequest} object using the set fields.
         * @return {@link V1UpdateCategoryRequest}
         */
        public V1UpdateCategoryRequest build() {
            return new V1UpdateCategoryRequest(body);
        }
    }
}
