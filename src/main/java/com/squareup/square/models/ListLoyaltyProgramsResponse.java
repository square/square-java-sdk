
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for ListLoyaltyProgramsResponse type.
 */
public class ListLoyaltyProgramsResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<LoyaltyProgram> programs;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  programs  List of LoyaltyProgram value for programs.
     */
    @JsonCreator
    public ListLoyaltyProgramsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("programs") List<LoyaltyProgram> programs) {
        this.errors = errors;
        this.programs = programs;
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
     * Getter for Programs.
     * A list of `LoyaltyProgram` for the merchant.
     * @return Returns the List of LoyaltyProgram
     */
    @JsonGetter("programs")
    public List<LoyaltyProgram> getPrograms() {
        return programs;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, programs);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListLoyaltyProgramsResponse)) {
            return false;
        }
        ListLoyaltyProgramsResponse other = (ListLoyaltyProgramsResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(programs, other.programs);
    }

    /**
     * Converts this ListLoyaltyProgramsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListLoyaltyProgramsResponse [" + "errors=" + errors + ", programs=" + programs
                + "]";
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
     * Class to build instances of {@link ListLoyaltyProgramsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<LoyaltyProgram> programs;



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
         * Setter for programs.
         * @param  programs  List of LoyaltyProgram value for programs.
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
            ListLoyaltyProgramsResponse model =
                    new ListLoyaltyProgramsResponse(errors, programs);
            model.httpContext = httpContext;
            return model;
        }
    }
}
