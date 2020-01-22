package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1UpdateModifierOptionRequest type.
 */
public class V1UpdateModifierOptionRequest {

    /**
     * Initialization constructor.
     * @param body
     */
    @JsonCreator
    public V1UpdateModifierOptionRequest(
            @JsonProperty("body") V1ModifierOption body) {
        this.body = body;
    }

    private final V1ModifierOption body;
    /**
     * Getter for Body.
     * V1ModifierOption
     */
    @JsonGetter("body")
    public V1ModifierOption getBody() {
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
        if(!(obj instanceof V1UpdateModifierOptionRequest)) {
            return false;
        }
        V1UpdateModifierOptionRequest v1UpdateModifierOptionRequest = (V1UpdateModifierOptionRequest) obj;
        return Objects.equals(body, v1UpdateModifierOptionRequest.body);
    }

    /**
     * Builds a new {@link V1UpdateModifierOptionRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1UpdateModifierOptionRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(body);
            return builder;
    }

    /**
     * Class to build instances of {@link V1UpdateModifierOptionRequest}
     */
    public static class Builder {
        private V1ModifierOption body;

        /**
         * Initialization constructor
         */
        public Builder(V1ModifierOption body) {
            this.body = body;
        }

        /**
         * Setter for body
         * @param body
         * @return Builder
         */
        public Builder body(V1ModifierOption body) {
            this.body = body;
            return this;
        }

        /**
         * Builds a new {@link V1UpdateModifierOptionRequest} object using the set fields.
         * @return {@link V1UpdateModifierOptionRequest}
         */
        public V1UpdateModifierOptionRequest build() {
            return new V1UpdateModifierOptionRequest(body);
        }
    }
}
