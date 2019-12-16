package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1UpdatePageCellRequest {

    @JsonCreator
    public V1UpdatePageCellRequest(
            @JsonProperty("body") V1PageCell body) {
        this.body = body;
    }

    private final V1PageCell body;

    @Override
    public int hashCode() {
        return Objects.hash(body);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1UpdatePageCellRequest)) {
            return false;
        }
        V1UpdatePageCellRequest v1UpdatePageCellRequest = (V1UpdatePageCellRequest) o;
        return Objects.equals(body, v1UpdatePageCellRequest.body);
    }

    /**
     * Getter for Body.
     * V1PageCell
     */
    @JsonGetter("body")
    public V1PageCell getBody() { 
        return this.body;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(body);
            return builder;
    }

    public static class Builder {
        private V1PageCell body;

        public Builder(V1PageCell body) {
            this.body = body;
        }

        public Builder body(V1PageCell value) {
            body = value;
            return this;
        }

        public V1UpdatePageCellRequest build() {
            return new V1UpdatePageCellRequest(body);
        }
    }
}
