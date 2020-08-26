package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for GetTeamMemberWageResponse type.
 */
public class GetTeamMemberWageResponse {

    /**
     * Initialization constructor.
     * @param teamMemberWage
     * @param errors
     */
    @JsonCreator
    public GetTeamMemberWageResponse(
            @JsonProperty("team_member_wage") TeamMemberWage teamMemberWage,
            @JsonProperty("errors") List<Error> errors) {
        this.teamMemberWage = teamMemberWage;
        this.errors = errors;
    }

    private HttpContext httpContext;
    private final TeamMemberWage teamMemberWage;
    private final List<Error> errors;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for TeamMemberWage.
     * The hourly wage rate that a team member will earn on a `Shift` for doing the job
     * specified by the `title` property of this object.
     */
    @JsonGetter("team_member_wage")
    public TeamMemberWage getTeamMemberWage() {
        return this.teamMemberWage;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(teamMemberWage, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof GetTeamMemberWageResponse)) {
            return false;
        }
        GetTeamMemberWageResponse getTeamMemberWageResponse = (GetTeamMemberWageResponse) obj;
        return Objects.equals(teamMemberWage, getTeamMemberWageResponse.teamMemberWage) &&
            Objects.equals(errors, getTeamMemberWageResponse.errors);
    }

    /**
     * Builds a new {@link GetTeamMemberWageResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link GetTeamMemberWageResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .teamMemberWage(getTeamMemberWage())
            .errors(getErrors());
            return builder;
    }

    /**
     * Class to build instances of {@link GetTeamMemberWageResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private TeamMemberWage teamMemberWage;
        private List<Error> errors;

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
         * Setter for teamMemberWage
         * @param teamMemberWage
         * @return Builder
         */
        public Builder teamMemberWage(TeamMemberWage teamMemberWage) {
            this.teamMemberWage = teamMemberWage;
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
         * Builds a new {@link GetTeamMemberWageResponse} object using the set fields.
         * @return {@link GetTeamMemberWageResponse}
         */
        public GetTeamMemberWageResponse build() {
            GetTeamMemberWageResponse model = new GetTeamMemberWageResponse(teamMemberWage,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
