package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1CreateModifierListRequest {

    @JsonCreator
    public V1CreateModifierListRequest(
            @JsonProperty("body") V1ModifierList body) {
        this.body = body;
    }

    private final V1ModifierList body;

    @Override
    public int hashCode() {
        return Objects.hash(body);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1CreateModifierListRequest)) {
            return false;
        }
        V1CreateModifierListRequest v1CreateModifierListRequest = (V1CreateModifierListRequest) o;
        return Objects.equals(body, v1CreateModifierListRequest.body);
    }

    /**
     * Getter for Body.
     * V1ModifierList
     */
    @JsonGetter("body")
    public V1ModifierList getBody() { 
        return this.body;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .body(getBody());
            return builder;
    }

    public static class Builder {
        private V1ModifierList body;

        public Builder() { }

        public Builder body(V1ModifierList value) {
            body = value;
            return this;
        }

        public V1CreateModifierListRequest build() {
            return new V1CreateModifierListRequest(body);
        }
    }
}
