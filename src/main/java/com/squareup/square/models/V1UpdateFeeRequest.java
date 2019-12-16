package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1UpdateFeeRequest {

    @JsonCreator
    public V1UpdateFeeRequest(
            @JsonProperty("body") V1Fee body) {
        this.body = body;
    }

    private final V1Fee body;

    @Override
    public int hashCode() {
        return Objects.hash(body);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1UpdateFeeRequest)) {
            return false;
        }
        V1UpdateFeeRequest v1UpdateFeeRequest = (V1UpdateFeeRequest) o;
        return Objects.equals(body, v1UpdateFeeRequest.body);
    }

    /**
     * Getter for Body.
     * V1Fee
     */
    @JsonGetter("body")
    public V1Fee getBody() { 
        return this.body;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(body);
            return builder;
    }

    public static class Builder {
        private V1Fee body;

        public Builder(V1Fee body) {
            this.body = body;
        }

        public Builder body(V1Fee value) {
            body = value;
            return this;
        }

        public V1UpdateFeeRequest build() {
            return new V1UpdateFeeRequest(body);
        }
    }
}
