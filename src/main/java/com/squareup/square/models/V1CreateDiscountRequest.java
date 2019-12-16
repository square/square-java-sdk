package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1CreateDiscountRequest {

    @JsonCreator
    public V1CreateDiscountRequest(
            @JsonProperty("body") V1Discount body) {
        this.body = body;
    }

    private final V1Discount body;

    @Override
    public int hashCode() {
        return Objects.hash(body);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1CreateDiscountRequest)) {
            return false;
        }
        V1CreateDiscountRequest v1CreateDiscountRequest = (V1CreateDiscountRequest) o;
        return Objects.equals(body, v1CreateDiscountRequest.body);
    }

    /**
     * Getter for Body.
     * V1Discount
     */
    @JsonGetter("body")
    public V1Discount getBody() { 
        return this.body;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .body(getBody());
            return builder;
    }

    public static class Builder {
        private V1Discount body;

        public Builder() { }

        public Builder body(V1Discount value) {
            body = value;
            return this;
        }

        public V1CreateDiscountRequest build() {
            return new V1CreateDiscountRequest(body);
        }
    }
}
