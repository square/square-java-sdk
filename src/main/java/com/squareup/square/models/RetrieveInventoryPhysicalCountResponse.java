
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for RetrieveInventoryPhysicalCountResponse type.
 */
public class RetrieveInventoryPhysicalCountResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final InventoryPhysicalCount count;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  count  InventoryPhysicalCount value for count.
     */
    @JsonCreator
    public RetrieveInventoryPhysicalCountResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("count") InventoryPhysicalCount count) {
        this.errors = errors;
        this.count = count;
    }

    @JsonIgnore
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
     * Getter for Count.
     * Represents the quantity of an item variation that is physically present at a specific
     * location, verified by a seller or a seller's employee. For example, a physical count might
     * come from an employee counting the item variations on hand or from syncing with an external
     * system.
     * @return Returns the InventoryPhysicalCount
     */
    @JsonGetter("count")
    public InventoryPhysicalCount getCount() {
        return count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, count);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveInventoryPhysicalCountResponse)) {
            return false;
        }
        RetrieveInventoryPhysicalCountResponse other = (RetrieveInventoryPhysicalCountResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(count, other.count);
    }

    /**
     * Converts this RetrieveInventoryPhysicalCountResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveInventoryPhysicalCountResponse [" + "errors=" + errors + ", count=" + count
                + "]";
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
     * Class to build instances of {@link RetrieveInventoryPhysicalCountResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private InventoryPhysicalCount count;



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
         * Setter for count.
         * @param  count  InventoryPhysicalCount value for count.
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
            RetrieveInventoryPhysicalCountResponse model =
                    new RetrieveInventoryPhysicalCountResponse(errors, count);
            model.httpContext = httpContext;
            return model;
        }
    }
}
