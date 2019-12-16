package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1UpdateTimecardRequest {

    @JsonCreator
    public V1UpdateTimecardRequest(
            @JsonProperty("body") V1Timecard body) {
        this.body = body;
    }

    private final V1Timecard body;

    @Override
    public int hashCode() {
        return Objects.hash(body);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1UpdateTimecardRequest)) {
            return false;
        }
        V1UpdateTimecardRequest v1UpdateTimecardRequest = (V1UpdateTimecardRequest) o;
        return Objects.equals(body, v1UpdateTimecardRequest.body);
    }

    /**
     * Getter for Body.
     * Represents a timecard for an employee.
     */
    @JsonGetter("body")
    public V1Timecard getBody() { 
        return this.body;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(body);
            return builder;
    }

    public static class Builder {
        private V1Timecard body;

        public Builder(V1Timecard body) {
            this.body = body;
        }

        public Builder body(V1Timecard value) {
            body = value;
            return this;
        }

        public V1UpdateTimecardRequest build() {
            return new V1UpdateTimecardRequest(body);
        }
    }
}
