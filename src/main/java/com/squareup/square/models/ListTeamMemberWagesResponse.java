
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for ListTeamMemberWagesResponse type.
 */
public class ListTeamMemberWagesResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<TeamMemberWage> teamMemberWages;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cursor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  teamMemberWages  List of TeamMemberWage value for teamMemberWages.
     * @param  cursor  String value for cursor.
     * @param  errors  List of Error value for errors.
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

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for TeamMemberWages.
     * A page of `TeamMemberWage` results.
     * @return Returns the List of TeamMemberWage
     */
    @JsonGetter("team_member_wages")
    public List<TeamMemberWage> getTeamMemberWages() {
        return teamMemberWages;
    }

    /**
     * Getter for Cursor.
     * The value supplied in the subsequent request to fetch the next page of `TeamMemberWage`
     * results.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return cursor;
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

    @Override
    public int hashCode() {
        return Objects.hash(teamMemberWages, cursor, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListTeamMemberWagesResponse)) {
            return false;
        }
        ListTeamMemberWagesResponse other = (ListTeamMemberWagesResponse) obj;
        return Objects.equals(teamMemberWages, other.teamMemberWages)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this ListTeamMemberWagesResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListTeamMemberWagesResponse [" + "teamMemberWages=" + teamMemberWages + ", cursor="
                + cursor + ", errors=" + errors + "]";
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
     * Class to build instances of {@link ListTeamMemberWagesResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<TeamMemberWage> teamMemberWages;
        private String cursor;
        private List<Error> errors;



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
         * Setter for teamMemberWages.
         * @param  teamMemberWages  List of TeamMemberWage value for teamMemberWages.
         * @return Builder
         */
        public Builder teamMemberWages(List<TeamMemberWage> teamMemberWages) {
            this.teamMemberWages = teamMemberWages;
            return this;
        }

        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
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
         * Builds a new {@link ListTeamMemberWagesResponse} object using the set fields.
         * @return {@link ListTeamMemberWagesResponse}
         */
        public ListTeamMemberWagesResponse build() {
            ListTeamMemberWagesResponse model =
                    new ListTeamMemberWagesResponse(teamMemberWages, cursor, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
