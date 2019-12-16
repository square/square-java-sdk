package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1UpdateEmployeeRequest {

    @JsonCreator
    public V1UpdateEmployeeRequest(
            @JsonProperty("body") V1Employee body) {
        this.body = body;
    }

    private final V1Employee body;

    @Override
    public int hashCode() {
        return Objects.hash(body);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1UpdateEmployeeRequest)) {
            return false;
        }
        V1UpdateEmployeeRequest v1UpdateEmployeeRequest = (V1UpdateEmployeeRequest) o;
        return Objects.equals(body, v1UpdateEmployeeRequest.body);
    }

    /**
     * Getter for Body.
     * Represents one of a business's employees.
     */
    @JsonGetter("body")
    public V1Employee getBody() { 
        return this.body;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(body);
            return builder;
    }

    public static class Builder {
        private V1Employee body;

        public Builder(V1Employee body) {
            this.body = body;
        }

        public Builder body(V1Employee value) {
            body = value;
            return this;
        }

        public V1UpdateEmployeeRequest build() {
            return new V1UpdateEmployeeRequest(body);
        }
    }
}
