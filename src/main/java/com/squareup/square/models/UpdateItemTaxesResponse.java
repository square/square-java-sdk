package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for UpdateItemTaxesResponse type.
 */
public class UpdateItemTaxesResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param updatedAt
     */
    @JsonCreator
    public UpdateItemTaxesResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("updated_at") String updatedAt) {
        this.errors = errors;
        this.updatedAt = updatedAt;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final String updatedAt;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information on any errors encountered.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for UpdatedAt.
     * The database [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates) of this update in RFC 3339 format, e.g., `2016-09-04T23:59:33.123Z`.
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() {
        return this.updatedAt;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, updatedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof UpdateItemTaxesResponse)) {
            return false;
        }
        UpdateItemTaxesResponse updateItemTaxesResponse = (UpdateItemTaxesResponse) obj;
        return Objects.equals(errors, updateItemTaxesResponse.errors) &&
            Objects.equals(updatedAt, updateItemTaxesResponse.updatedAt);
    }

    /**
     * Builds a new {@link UpdateItemTaxesResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateItemTaxesResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .updatedAt(getUpdatedAt());
            return builder;
    }

    /**
     * Class to build instances of {@link UpdateItemTaxesResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private String updatedAt;

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
         * Setter for updatedAt
         * @param updatedAt
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * Builds a new {@link UpdateItemTaxesResponse} object using the set fields.
         * @return {@link UpdateItemTaxesResponse}
         */
        public UpdateItemTaxesResponse build() {
            UpdateItemTaxesResponse model = new UpdateItemTaxesResponse(errors,
                updatedAt);
            model.httpContext = httpContext;
            return model;
        }
    }
}
