
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for UpsertSnippetRequest type.
 */
public class UpsertSnippetRequest {
    private final Snippet snippet;

    /**
     * Initialization constructor.
     * @param  snippet  Snippet value for snippet.
     */
    @JsonCreator
    public UpsertSnippetRequest(
            @JsonProperty("snippet") Snippet snippet) {
        this.snippet = snippet;
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
        return Objects.hash(snippet);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpsertSnippetRequest)) {
            return false;
        }
        UpsertSnippetRequest other = (UpsertSnippetRequest) obj;
        return Objects.equals(snippet, other.snippet);
    }

    /**
     * Converts this UpsertSnippetRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpsertSnippetRequest [" + "snippet=" + snippet + "]";
    }

    /**
     * Builds a new {@link UpsertSnippetRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpsertSnippetRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(snippet);
        return builder;
    }

    /**
     * Class to build instances of {@link UpsertSnippetRequest}.
     */
    public static class Builder {
        private Snippet snippet;

        /**
         * Initialization constructor.
         * @param  snippet  Snippet value for snippet.
         */
        public Builder(Snippet snippet) {
            this.snippet = snippet;
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
         * Builds a new {@link UpsertSnippetRequest} object using the set fields.
         * @return {@link UpsertSnippetRequest}
         */
        public UpsertSnippetRequest build() {
            return new UpsertSnippetRequest(snippet);
        }
    }
}
