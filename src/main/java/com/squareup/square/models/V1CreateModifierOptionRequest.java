package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1CreateModifierOptionRequest {

    @JsonCreator
    public V1CreateModifierOptionRequest(
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
        if (!(o instanceof V1CreateModifierOptionRequest)) {
            return false;
        }
        V1CreateModifierOptionRequest v1CreateModifierOptionRequest = (V1CreateModifierOptionRequest) o;
        return Objects.equals(body, v1CreateModifierOptionRequest.body);
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
        Builder builder = new Builder()
            .body(getBody());
            return builder;
    }

    public static class Builder {
        private V1ModifierOption body;

        public Builder() { }

        public Builder body(V1ModifierOption value) {
            body = value;
            return this;
        }

        public V1CreateModifierOptionRequest build() {
            return new V1CreateModifierOptionRequest(body);
        }
    }
}
