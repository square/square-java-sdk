package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class RetrieveInventoryAdjustmentResponse {

    @JsonCreator
    public RetrieveInventoryAdjustmentResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("adjustment") InventoryAdjustment adjustment) {
        this.errors = errors;
        this.adjustment = adjustment;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final InventoryAdjustment adjustment;

    @Override
    public int hashCode() {
        return Objects.hash(errors, adjustment);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RetrieveInventoryAdjustmentResponse)) {
            return false;
        }
        RetrieveInventoryAdjustmentResponse retrieveInventoryAdjustmentResponse = (RetrieveInventoryAdjustmentResponse) o;
        return Objects.equals(errors, retrieveInventoryAdjustmentResponse.errors) &&
            Objects.equals(adjustment, retrieveInventoryAdjustmentResponse.adjustment);
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
     * Getter for Adjustment.
     * Represents a change in state or quantity of product inventory at a
     * particular time and location.
     */
    @JsonGetter("adjustment")
    public InventoryAdjustment getAdjustment() { 
        return this.adjustment;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .adjustment(getAdjustment());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private InventoryAdjustment adjustment;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }
        public Builder adjustment(InventoryAdjustment value) {
            adjustment = value;
            return this;
        }

        public RetrieveInventoryAdjustmentResponse build() {
            RetrieveInventoryAdjustmentResponse model = new RetrieveInventoryAdjustmentResponse(errors,
                adjustment);
            model.httpContext = httpContext;
            return model;
        }
    }
}
