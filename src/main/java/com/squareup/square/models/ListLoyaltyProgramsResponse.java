package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for ListLoyaltyProgramsResponse type.
 */
public class ListLoyaltyProgramsResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param programs
     */
    @JsonCreator
    public ListLoyaltyProgramsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("programs") List<LoyaltyProgram> programs) {
        this.errors = errors;
        this.programs = programs;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<LoyaltyProgram> programs;

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
     * Getter for Programs.
     * A list of `LoyaltyProgram` for the merchant.
     */
    @JsonGetter("programs")
    public List<LoyaltyProgram> getPrograms() {
        return this.programs;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, programs);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListLoyaltyProgramsResponse)) {
            return false;
        }
        ListLoyaltyProgramsResponse listLoyaltyProgramsResponse = (ListLoyaltyProgramsResponse) obj;
        return Objects.equals(errors, listLoyaltyProgramsResponse.errors) &&
            Objects.equals(programs, listLoyaltyProgramsResponse.programs);
    }

    /**
     * Builds a new {@link ListLoyaltyProgramsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListLoyaltyProgramsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .programs(getPrograms());
            return builder;
    }

    /**
     * Class to build instances of {@link ListLoyaltyProgramsResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<LoyaltyProgram> programs;

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
         * Setter for programs
         * @param programs
         * @return Builder
         */
        public Builder programs(List<LoyaltyProgram> programs) {
            this.programs = programs;
            return this;
        }

        /**
         * Builds a new {@link ListLoyaltyProgramsResponse} object using the set fields.
         * @return {@link ListLoyaltyProgramsResponse}
         */
        public ListLoyaltyProgramsResponse build() {
            ListLoyaltyProgramsResponse model = new ListLoyaltyProgramsResponse(errors,
                programs);
            model.httpContext = httpContext;
            return model;
        }
    }
}
