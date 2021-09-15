
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
 * This is a model class for RetrieveSnippetResponse type.
 */
public class RetrieveSnippetResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Snippet snippet;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  snippet  Snippet value for snippet.
     */
    @JsonCreator
    public RetrieveSnippetResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("snippet") Snippet snippet) {
        this.errors = errors;
        this.snippet = snippet;
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
     * Getter for Snippet.
     * Represents the snippet that is added to a Square Online site. The snippet code is injected
     * into the `head` element of all pages on the site, except for checkout pages.
     * @return Returns the Snippet
     */
    @JsonGetter("snippet")
    public Snippet getSnippet() {
        return snippet;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, snippet);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveSnippetResponse)) {
            return false;
        }
        RetrieveSnippetResponse other = (RetrieveSnippetResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(snippet, other.snippet);
    }

    /**
     * Converts this RetrieveSnippetResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveSnippetResponse [" + "errors=" + errors + ", snippet=" + snippet + "]";
    }

    /**
     * Builds a new {@link RetrieveSnippetResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveSnippetResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .snippet(getSnippet());
        return builder;
    }

    /**
     * Class to build instances of {@link RetrieveSnippetResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Snippet snippet;



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
         * Setter for snippet.
         * @param  snippet  Snippet value for snippet.
         * @return Builder
         */
        public Builder snippet(Snippet snippet) {
            this.snippet = snippet;
            return this;
        }

        /**
         * Builds a new {@link RetrieveSnippetResponse} object using the set fields.
         * @return {@link RetrieveSnippetResponse}
         */
        public RetrieveSnippetResponse build() {
            RetrieveSnippetResponse model =
                    new RetrieveSnippetResponse(errors, snippet);
            model.httpContext = httpContext;
            return model;
        }
    }
}
