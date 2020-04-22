package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for UpdateCustomerGroupResponse type.
 */
public class UpdateCustomerGroupResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param group
     */
    @JsonCreator
    public UpdateCustomerGroupResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("group") CustomerGroup group) {
        this.errors = errors;
        this.group = group;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final CustomerGroup group;

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
     * Getter for Group.
     * Represents a group of customer profiles. 
     * Customer groups can be created, modified, and have their membership defined either via 
     * the Customers API or within Customer Directory in the Square Dashboard or Point of Sale.
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
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof UpdateCustomerGroupResponse)) {
            return false;
        }
        UpdateCustomerGroupResponse updateCustomerGroupResponse = (UpdateCustomerGroupResponse) obj;
        return Objects.equals(errors, updateCustomerGroupResponse.errors) &&
            Objects.equals(group, updateCustomerGroupResponse.group);
    }

    /**
     * Builds a new {@link UpdateCustomerGroupResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateCustomerGroupResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .group(getGroup());
            return builder;
    }

    /**
     * Class to build instances of {@link UpdateCustomerGroupResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private CustomerGroup group;

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
         * Setter for group
         * @param group
         * @return Builder
         */
        public Builder group(CustomerGroup group) {
            this.group = group;
            return this;
        }

        /**
         * Builds a new {@link UpdateCustomerGroupResponse} object using the set fields.
         * @return {@link UpdateCustomerGroupResponse}
         */
        public UpdateCustomerGroupResponse build() {
            UpdateCustomerGroupResponse model = new UpdateCustomerGroupResponse(errors,
                group);
            model.httpContext = httpContext;
            return model;
        }
    }
}
