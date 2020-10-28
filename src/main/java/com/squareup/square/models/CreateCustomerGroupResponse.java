
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for CreateCustomerGroupResponse type.
 */
public class CreateCustomerGroupResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final CustomerGroup group;

    /**
     * Initialization constructor.
     * @param errors List of Error value for errors.
     * @param group CustomerGroup value for group.
     */
    @JsonCreator
    public CreateCustomerGroupResponse(
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
        return this.errors;
    }

    /**
     * Getter for Group.
     * Represents a group of customer profiles. Customer groups can be created, modified, and have
     * their membership defined either via the Customers API or within Customer Directory in the
     * Square Dashboard or Point of Sale.
     * @return Returns the CustomerGroup
     */
    @JsonGetter("group")
    public CustomerGroup getGroup() {
        return this.group;
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
        if (!(obj instanceof CreateCustomerGroupResponse)) {
            return false;
        }
        CreateCustomerGroupResponse other = (CreateCustomerGroupResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(group, other.group);
    }

    /**
     * Builds a new {@link CreateCustomerGroupResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateCustomerGroupResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .group(getGroup());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateCustomerGroupResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private CustomerGroup group;



        /**
         * Setter for httpContext.
         * @param httpContext HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for errors.
         * @param errors List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Setter for group.
         * @param group CustomerGroup value for group.
         * @return Builder
         */
        public Builder group(CustomerGroup group) {
            this.group = group;
            return this;
        }

        /**
         * Builds a new {@link CreateCustomerGroupResponse} object using the set fields.
         * @return {@link CreateCustomerGroupResponse}
         */
        public CreateCustomerGroupResponse build() {
            CreateCustomerGroupResponse model =
                    new CreateCustomerGroupResponse(errors,
                            group);
            model.httpContext = httpContext;
            return model;
        }
    }
}
