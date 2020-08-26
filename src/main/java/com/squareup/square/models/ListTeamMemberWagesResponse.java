package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for ListTeamMemberWagesResponse type.
 */
public class ListTeamMemberWagesResponse {

    /**
     * Initialization constructor.
     * @param teamMemberWages
     * @param cursor
     * @param errors
     */
    @JsonCreator
    public ListTeamMemberWagesResponse(
            @JsonProperty("team_member_wages") List<TeamMemberWage> teamMemberWages,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("errors") List<Error> errors) {
        this.teamMemberWages = teamMemberWages;
        this.cursor = cursor;
        this.errors = errors;
    }

    private HttpContext httpContext;
    private final List<TeamMemberWage> teamMemberWages;
    private final String cursor;
    private final List<Error> errors;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for TeamMemberWages.
     * A page of Team Member Wage results.
     */
    @JsonGetter("team_member_wages")
    public List<TeamMemberWage> getTeamMemberWages() {
        return this.teamMemberWages;
    }

    /**
     * Getter for Cursor.
     * Value supplied in the subsequent request to fetch the next next page
     * of Team Member Wage results.
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
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
        return Objects.hash(teamMemberWages, cursor, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListTeamMemberWagesResponse)) {
            return false;
        }
        ListTeamMemberWagesResponse listTeamMemberWagesResponse = (ListTeamMemberWagesResponse) obj;
        return Objects.equals(teamMemberWages, listTeamMemberWagesResponse.teamMemberWages) &&
            Objects.equals(cursor, listTeamMemberWagesResponse.cursor) &&
            Objects.equals(errors, listTeamMemberWagesResponse.errors);
    }

    /**
     * Builds a new {@link ListTeamMemberWagesResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListTeamMemberWagesResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .teamMemberWages(getTeamMemberWages())
            .cursor(getCursor())
            .errors(getErrors());
            return builder;
    }

    /**
     * Class to build instances of {@link ListTeamMemberWagesResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<TeamMemberWage> teamMemberWages;
        private String cursor;
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
         * Setter for teamMemberWages
         * @param teamMemberWages
         * @return Builder
         */
        public Builder teamMemberWages(List<TeamMemberWage> teamMemberWages) {
            this.teamMemberWages = teamMemberWages;
            return this;
        }
        /**
         * Setter for cursor
         * @param cursor
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
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
         * Builds a new {@link ListTeamMemberWagesResponse} object using the set fields.
         * @return {@link ListTeamMemberWagesResponse}
         */
        public ListTeamMemberWagesResponse build() {
            ListTeamMemberWagesResponse model = new ListTeamMemberWagesResponse(teamMemberWages,
                cursor,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
