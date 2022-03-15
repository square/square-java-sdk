
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
 * This is a model class for SearchVendorsResponse type.
 */
public class SearchVendorsResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<Vendor> vendors;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  vendors  List of Vendor value for vendors.
     * @param  cursor  String value for cursor.
     */
    @JsonCreator
    public SearchVendorsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("vendors") List<Vendor> vendors,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.vendors = vendors;
        this.cursor = cursor;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Errors encountered when the request fails.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Vendors.
     * The [Vendor]($m/Vendor) objects matching the specified search filter.
     * @return Returns the List of Vendor
     */
    @JsonGetter("vendors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Vendor> getVendors() {
        return vendors;
    }

    /**
     * Getter for Cursor.
     * The pagination cursor to be used in a subsequent request. If unset, this is the final
     * response. See the
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide for more
     * information.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, vendors, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchVendorsResponse)) {
            return false;
        }
        SearchVendorsResponse other = (SearchVendorsResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(vendors, other.vendors)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this SearchVendorsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchVendorsResponse [" + "errors=" + errors + ", vendors=" + vendors + ", cursor="
                + cursor + "]";
    }

    /**
     * Builds a new {@link SearchVendorsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchVendorsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .vendors(getVendors())
                .cursor(getCursor());
        return builder;
    }

    /**
     * Class to build instances of {@link SearchVendorsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<Vendor> vendors;
        private String cursor;



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
         * Setter for vendors.
         * @param  vendors  List of Vendor value for vendors.
         * @return Builder
         */
        public Builder vendors(List<Vendor> vendors) {
            this.vendors = vendors;
            return this;
        }

        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Builds a new {@link SearchVendorsResponse} object using the set fields.
         * @return {@link SearchVendorsResponse}
         */
        public SearchVendorsResponse build() {
            SearchVendorsResponse model =
                    new SearchVendorsResponse(errors, vendors, cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
