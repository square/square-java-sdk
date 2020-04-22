package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for ListCustomerGroupsResponse type.
 */
public class ListCustomerGroupsResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param groups
     * @param cursor
     */
    @JsonCreator
    public ListCustomerGroupsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("groups") List<CustomerGroup> groups,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.groups = groups;
        this.cursor = cursor;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<CustomerGroup> groups;
    private final String cursor;

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
     * Getter for Groups.
     * A list of customer groups belonging to the current merchant.
     */
    @JsonGetter("groups")
    public List<CustomerGroup> getGroups() {
        return this.groups;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor to retrieve the next set of results for your
     * original query to the endpoint. This value is present only if the request
     * succeeded and additional results are available.
     * See the [Pagination guide](https://developer.squareup.com/docs/working-with-apis/pagination) for more information.
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, groups, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListCustomerGroupsResponse)) {
            return false;
        }
        ListCustomerGroupsResponse listCustomerGroupsResponse = (ListCustomerGroupsResponse) obj;
        return Objects.equals(errors, listCustomerGroupsResponse.errors) &&
            Objects.equals(groups, listCustomerGroupsResponse.groups) &&
            Objects.equals(cursor, listCustomerGroupsResponse.cursor);
    }

    /**
     * Builds a new {@link ListCustomerGroupsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListCustomerGroupsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .groups(getGroups())
            .cursor(getCursor());
            return builder;
    }

    /**
     * Class to build instances of {@link ListCustomerGroupsResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<CustomerGroup> groups;
        private String cursor;

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
         * Setter for groups
         * @param groups
         * @return Builder
         */
        public Builder groups(List<CustomerGroup> groups) {
            this.groups = groups;
            return this;
        }
        /**
         * Setter for cursor
         * @param cursor
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Builds a new {@link ListCustomerGroupsResponse} object using the set fields.
         * @return {@link ListCustomerGroupsResponse}
         */
        public ListCustomerGroupsResponse build() {
            ListCustomerGroupsResponse model = new ListCustomerGroupsResponse(errors,
                groups,
                cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
