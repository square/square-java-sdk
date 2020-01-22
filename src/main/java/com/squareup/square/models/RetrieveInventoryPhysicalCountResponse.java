package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for RetrieveInventoryPhysicalCountResponse type.
 */
public class RetrieveInventoryPhysicalCountResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param count
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, count);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof RetrieveInventoryPhysicalCountResponse)) {
            return false;
        }
        RetrieveInventoryPhysicalCountResponse retrieveInventoryPhysicalCountResponse = (RetrieveInventoryPhysicalCountResponse) obj;
        return Objects.equals(errors, retrieveInventoryPhysicalCountResponse.errors) &&
            Objects.equals(count, retrieveInventoryPhysicalCountResponse.count);
    }

    /**
     * Builds a new {@link RetrieveInventoryPhysicalCountResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveInventoryPhysicalCountResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .count(getCount());
            return builder;
    }

    /**
     * Class to build instances of {@link RetrieveInventoryPhysicalCountResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private InventoryPhysicalCount count;

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
         * Setter for count
         * @param count
         * @return Builder
         */
        public Builder count(InventoryPhysicalCount count) {
            this.count = count;
            return this;
        }

        /**
         * Builds a new {@link RetrieveInventoryPhysicalCountResponse} object using the set fields.
         * @return {@link RetrieveInventoryPhysicalCountResponse}
         */
        public RetrieveInventoryPhysicalCountResponse build() {
            RetrieveInventoryPhysicalCountResponse model = new RetrieveInventoryPhysicalCountResponse(errors,
                count);
            model.httpContext = httpContext;
            return model;
        }
    }
}
