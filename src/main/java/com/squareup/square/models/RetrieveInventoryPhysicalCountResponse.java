package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class RetrieveInventoryPhysicalCountResponse {

    @JsonCreator
    public RetrieveInventoryPhysicalCountResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("count") InventoryPhysicalCount count) {
        this.errors = errors;
        this.count = count;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final InventoryPhysicalCount count;

    @Override
    public int hashCode() {
        return Objects.hash(errors, count);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RetrieveInventoryPhysicalCountResponse)) {
            return false;
        }
        RetrieveInventoryPhysicalCountResponse retrieveInventoryPhysicalCountResponse = (RetrieveInventoryPhysicalCountResponse) o;
        return Objects.equals(errors, retrieveInventoryPhysicalCountResponse.errors) &&
            Objects.equals(count, retrieveInventoryPhysicalCountResponse.count);
    }


    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() { 
        return this.errors;
    }

    /**
     * Getter for Count.
     * Represents the quantity of an item variation that is physically present
     * at a specific location, verified by a seller or a seller's employee. For example,
     * a physical count might come from an employee counting the item variations on
     * hand or from syncing with an external system.
     */
    @JsonGetter("count")
    public InventoryPhysicalCount getCount() { 
        return this.count;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .count(getCount());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private InventoryPhysicalCount count;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }
        public Builder count(InventoryPhysicalCount value) {
            count = value;
            return this;
        }

        public RetrieveInventoryPhysicalCountResponse build() {
            RetrieveInventoryPhysicalCountResponse model = new RetrieveInventoryPhysicalCountResponse(errors,
                count);
            model.httpContext = httpContext;
            return model;
        }
    }
}
