package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for RetrieveInventoryAdjustmentResponse type.
 */
public class RetrieveInventoryAdjustmentResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param adjustment
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, adjustment);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof RetrieveInventoryAdjustmentResponse)) {
            return false;
        }
        RetrieveInventoryAdjustmentResponse retrieveInventoryAdjustmentResponse = (RetrieveInventoryAdjustmentResponse) obj;
        return Objects.equals(errors, retrieveInventoryAdjustmentResponse.errors) &&
            Objects.equals(adjustment, retrieveInventoryAdjustmentResponse.adjustment);
    }

    /**
     * Builds a new {@link RetrieveInventoryAdjustmentResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveInventoryAdjustmentResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .adjustment(getAdjustment());
            return builder;
    }

    /**
     * Class to build instances of {@link RetrieveInventoryAdjustmentResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private InventoryAdjustment adjustment;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for httpContext
         * @param httpContext
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        /**
         * Setter for errors
         * @param errors
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }
        /**
         * Setter for adjustment
         * @param adjustment
         * @return Builder
         */
        public Builder adjustment(InventoryAdjustment adjustment) {
            this.adjustment = adjustment;
            return this;
        }

        /**
         * Builds a new {@link RetrieveInventoryAdjustmentResponse} object using the set fields.
         * @return {@link RetrieveInventoryAdjustmentResponse}
         */
        public RetrieveInventoryAdjustmentResponse build() {
            RetrieveInventoryAdjustmentResponse model = new RetrieveInventoryAdjustmentResponse(errors,
                adjustment);
            model.httpContext = httpContext;
            return model;
        }
    }
}
