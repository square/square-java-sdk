package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1CreateVariationRequest {

    @JsonCreator
    public V1CreateVariationRequest(
            @JsonProperty("body") V1Variation body) {
        this.body = body;
    }

    private final V1Variation body;

    @Override
    public int hashCode() {
        return Objects.hash(body);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1CreateVariationRequest)) {
            return false;
        }
        V1CreateVariationRequest v1CreateVariationRequest = (V1CreateVariationRequest) o;
        return Objects.equals(body, v1CreateVariationRequest.body);
    }

    /**
     * Getter for Body.
     * V1Variation
     */
    @JsonGetter("body")
    public V1Variation getBody() { 
        return this.body;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .body(getBody());
            return builder;
    }

    public static class Builder {
        private V1Variation body;

        public Builder() { }

        public Builder body(V1Variation value) {
            body = value;
            return this;
        }

        public V1CreateVariationRequest build() {
            return new V1CreateVariationRequest(body);
        }
    }
}
