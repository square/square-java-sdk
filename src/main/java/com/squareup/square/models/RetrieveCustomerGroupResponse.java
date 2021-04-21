
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for RetrieveCustomerGroupResponse type.
 */
public class RetrieveCustomerGroupResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final CustomerGroup group;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  group  CustomerGroup value for group.
     */
    @JsonCreator
    public RetrieveCustomerGroupResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("group") CustomerGroup group) {
        this.errors = errors;
        this.group = group;
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
     * Getter for Group.
     * Represents a group of customer profiles. Customer groups can be created, be modified, and
     * have their membership defined using the Customers API or within the Customer Directory in the
     * Square Seller Dashboard or Point of Sale.
     * @return Returns the CustomerGroup
     */
    @JsonGetter("group")
    public CustomerGroup getGroup() {
        return group;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, group);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveCustomerGroupResponse)) {
            return false;
        }
        RetrieveCustomerGroupResponse other = (RetrieveCustomerGroupResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(group, other.group);
    }

    /**
     * Converts this RetrieveCustomerGroupResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveCustomerGroupResponse [" + "errors=" + errors + ", group=" + group + "]";
    }

    /**
     * Builds a new {@link RetrieveCustomerGroupResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveCustomerGroupResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .group(getGroup());
        return builder;
    }

    /**
     * Class to build instances of {@link RetrieveCustomerGroupResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private CustomerGroup group;



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
         * Setter for group.
         * @param  group  CustomerGroup value for group.
         * @return Builder
         */
        public Builder group(CustomerGroup group) {
            this.group = group;
            return this;
        }

        /**
         * Builds a new {@link RetrieveCustomerGroupResponse} object using the set fields.
         * @return {@link RetrieveCustomerGroupResponse}
         */
        public RetrieveCustomerGroupResponse build() {
            RetrieveCustomerGroupResponse model =
                    new RetrieveCustomerGroupResponse(errors, group);
            model.httpContext = httpContext;
            return model;
        }
    }
}
