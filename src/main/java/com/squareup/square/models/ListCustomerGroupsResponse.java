
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for ListCustomerGroupsResponse type.
 */
public class ListCustomerGroupsResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<CustomerGroup> groups;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param errors List of Error value for errors.
     * @param groups List of CustomerGroup value for groups.
     * @param cursor String value for cursor.
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
     * Getter for Groups.
     * A list of customer groups belonging to the current merchant.
     * @return Returns the List of CustomerGroup
     */
    @JsonGetter("groups")
    public List<CustomerGroup> getGroups() {
        return this.groups;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor to retrieve the next set of results for your original query to the
     * endpoint. This value is present only if the request succeeded and additional results are
     * available. See the [Pagination
     * guide](https://developer.squareup.com/docs/working-with-apis/pagination) for more
     * information.
     * @return Returns the String
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListCustomerGroupsResponse)) {
            return false;
        }
        ListCustomerGroupsResponse other = (ListCustomerGroupsResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(groups, other.groups)
            && Objects.equals(cursor, other.cursor);
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
     * Class to build instances of {@link ListCustomerGroupsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<CustomerGroup> groups;
        private String cursor;



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
         * Setter for groups.
         * @param groups List of CustomerGroup value for groups.
         * @return Builder
         */
        public Builder groups(List<CustomerGroup> groups) {
            this.groups = groups;
            return this;
        }

        /**
         * Setter for cursor.
         * @param cursor String value for cursor.
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
            ListCustomerGroupsResponse model =
                    new ListCustomerGroupsResponse(errors,
                            groups,
                            cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
