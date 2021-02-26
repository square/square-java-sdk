
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for RetrieveInventoryAdjustmentResponse type.
 */
public class RetrieveInventoryAdjustmentResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final InventoryAdjustment adjustment;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  adjustment  InventoryAdjustment value for adjustment.
     */
    @JsonCreator
    public RetrieveInventoryAdjustmentResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("adjustment") InventoryAdjustment adjustment) {
        this.errors = errors;
        this.adjustment = adjustment;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Adjustment.
     * Represents a change in state or quantity of product inventory at a particular time and
     * location.
     * @return Returns the InventoryAdjustment
     */
    @JsonGetter("adjustment")
    public InventoryAdjustment getAdjustment() {
        return adjustment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, adjustment);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveInventoryAdjustmentResponse)) {
            return false;
        }
        RetrieveInventoryAdjustmentResponse other = (RetrieveInventoryAdjustmentResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(adjustment, other.adjustment);
    }

    /**
     * Converts this RetrieveInventoryAdjustmentResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveInventoryAdjustmentResponse [" + "errors=" + errors + ", adjustment="
                + adjustment + "]";
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
     * Class to build instances of {@link RetrieveInventoryAdjustmentResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private InventoryAdjustment adjustment;



        /**
         * Setter for httpContext.
         * @param  httpContext  HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Setter for adjustment.
         * @param  adjustment  InventoryAdjustment value for adjustment.
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
            RetrieveInventoryAdjustmentResponse model =
                    new RetrieveInventoryAdjustmentResponse(errors, adjustment);
            model.httpContext = httpContext;
            return model;
        }
    }
}
