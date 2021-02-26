
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for UpdateItemTaxesResponse type.
 */
public class UpdateItemTaxesResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String updatedAt;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  updatedAt  String value for updatedAt.
     */
    @JsonCreator
    public UpdateItemTaxesResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("updated_at") String updatedAt) {
        this.errors = errors;
        this.updatedAt = updatedAt;
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
     * Getter for UpdatedAt.
     * The database [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * of this update in RFC 3339 format, e.g., `2016-09-04T23:59:33.123Z`.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, updatedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateItemTaxesResponse)) {
            return false;
        }
        UpdateItemTaxesResponse other = (UpdateItemTaxesResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(updatedAt, other.updatedAt);
    }

    /**
     * Converts this UpdateItemTaxesResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpdateItemTaxesResponse [" + "errors=" + errors + ", updatedAt=" + updatedAt + "]";
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
     * Class to build instances of {@link UpdateItemTaxesResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private String updatedAt;



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
         * Setter for updatedAt.
         * @param  updatedAt  String value for updatedAt.
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
            UpdateItemTaxesResponse model =
                    new UpdateItemTaxesResponse(errors, updatedAt);
            model.httpContext = httpContext;
            return model;
        }
    }
}
