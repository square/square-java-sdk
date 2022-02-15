
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
 * This is a model class for RetrieveLoyaltyProgramResponse type.
 */
public class RetrieveLoyaltyProgramResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final LoyaltyProgram program;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  program  LoyaltyProgram value for program.
     */
    @JsonCreator
    public RetrieveLoyaltyProgramResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("program") LoyaltyProgram program) {
        this.errors = errors;
        this.program = program;
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Program.
     * Represents a Square loyalty program. Loyalty programs define how buyers can earn points and
     * redeem points for rewards. Square sellers can have only one loyalty program, which is created
     * and managed from the Seller Dashboard. For more information, see [Loyalty Program
     * Overview](https://developer.squareup.com/docs/loyalty/overview).
     * @return Returns the LoyaltyProgram
     */
    @JsonGetter("program")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LoyaltyProgram getProgram() {
        return program;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, program);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveLoyaltyProgramResponse)) {
            return false;
        }
        RetrieveLoyaltyProgramResponse other = (RetrieveLoyaltyProgramResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(program, other.program);
    }

    /**
     * Converts this RetrieveLoyaltyProgramResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveLoyaltyProgramResponse [" + "errors=" + errors + ", program=" + program
                + "]";
    }

    /**
     * Builds a new {@link RetrieveLoyaltyProgramResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveLoyaltyProgramResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .program(getProgram());
        return builder;
    }

    /**
     * Class to build instances of {@link RetrieveLoyaltyProgramResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private LoyaltyProgram program;



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
         * Setter for program.
         * @param  program  LoyaltyProgram value for program.
         * @return Builder
         */
        public Builder program(LoyaltyProgram program) {
            this.program = program;
            return this;
        }

        /**
         * Builds a new {@link RetrieveLoyaltyProgramResponse} object using the set fields.
         * @return {@link RetrieveLoyaltyProgramResponse}
         */
        public RetrieveLoyaltyProgramResponse build() {
            RetrieveLoyaltyProgramResponse model =
                    new RetrieveLoyaltyProgramResponse(errors, program);
            model.httpContext = httpContext;
            return model;
        }
    }
}
