
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for ListSitesResponse type.
 */
public class ListSitesResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Site> sites;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  sites  List of Site value for sites.
     */
    @JsonCreator
    public ListSitesResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("sites") List<Site> sites) {
        this.errors = errors;
        this.sites = sites;
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
     * Getter for Sites.
     * The sites that belong to the seller.
     * @return Returns the List of Site
     */
    @JsonGetter("sites")
    public List<Site> getSites() {
        return sites;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, sites);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListSitesResponse)) {
            return false;
        }
        ListSitesResponse other = (ListSitesResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(sites, other.sites);
    }

    /**
     * Converts this ListSitesResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListSitesResponse [" + "errors=" + errors + ", sites=" + sites + "]";
    }

    /**
     * Builds a new {@link ListSitesResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListSitesResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .sites(getSites());
        return builder;
    }

    /**
     * Class to build instances of {@link ListSitesResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<Site> sites;



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
         * Setter for sites.
         * @param  sites  List of Site value for sites.
         * @return Builder
         */
        public Builder sites(List<Site> sites) {
            this.sites = sites;
            return this;
        }

        /**
         * Builds a new {@link ListSitesResponse} object using the set fields.
         * @return {@link ListSitesResponse}
         */
        public ListSitesResponse build() {
            ListSitesResponse model =
                    new ListSitesResponse(errors, sites);
            model.httpContext = httpContext;
            return model;
        }
    }
}
