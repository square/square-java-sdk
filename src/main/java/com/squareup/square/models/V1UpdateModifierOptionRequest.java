package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1UpdateModifierOptionRequest {

    @JsonCreator
    public V1UpdateModifierOptionRequest(
            @JsonProperty("body") V1ModifierOption body) {
        this.body = body;
    }

    private final V1ModifierOption body;

    @Override
    public int hashCode() {
        return Objects.hash(body);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1UpdateModifierOptionRequest)) {
            return false;
        }
        V1UpdateModifierOptionRequest v1UpdateModifierOptionRequest = (V1UpdateModifierOptionRequest) o;
        return Objects.equals(body, v1UpdateModifierOptionRequest.body);
    }

    /**
     * Getter for Body.
     * V1ModifierOption
     */
    @JsonGetter("body")
    public V1ModifierOption getBody() { 
        return this.body;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(body);
            return builder;
    }

    public static class Builder {
        private V1ModifierOption body;

        public Builder(V1ModifierOption body) {
            this.body = body;
        }

        public Builder body(V1ModifierOption value) {
            body = value;
            return this;
        }

        public V1UpdateModifierOptionRequest build() {
            return new V1UpdateModifierOptionRequest(body);
        }
    }
}
