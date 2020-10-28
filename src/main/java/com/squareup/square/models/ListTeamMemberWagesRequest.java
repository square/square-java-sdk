
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for ListTeamMemberWagesRequest type.
 */
public class ListTeamMemberWagesRequest {
    private final String teamMemberId;
    private final Integer limit;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param teamMemberId String value for teamMemberId.
     * @param limit Integer value for limit.
     * @param cursor String value for cursor.
     */
    @JsonCreator
    public ListTeamMemberWagesRequest(
            @JsonProperty("team_member_id") String teamMemberId,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("cursor") String cursor) {
        this.teamMemberId = teamMemberId;
        this.limit = limit;
        this.cursor = cursor;
    }

    /**
     * Getter for TeamMemberId.
     * Filter wages returned to only those that are associated with the specified team member.
     * @return Returns the String
     */
    @JsonGetter("team_member_id")
    public String getTeamMemberId() {
        return this.teamMemberId;
    }

    /**
     * Getter for Limit.
     * Maximum number of Team Member Wages to return per page. Can range between 1 and 200. The
     * default is the maximum at 200.
     * @return Returns the Integer
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return this.limit;
    }

    /**
     * Getter for Cursor.
     * Pointer to the next page of Employee Wage results to fetch.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(teamMemberId, limit, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListTeamMemberWagesRequest)) {
            return false;
        }
        ListTeamMemberWagesRequest other = (ListTeamMemberWagesRequest) obj;
        return Objects.equals(teamMemberId, other.teamMemberId)
            && Objects.equals(limit, other.limit)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Builds a new {@link ListTeamMemberWagesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListTeamMemberWagesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .teamMemberId(getTeamMemberId())
            .limit(getLimit())
            .cursor(getCursor());
        return builder;
    }

    /**
     * Class to build instances of {@link ListTeamMemberWagesRequest}.
     */
    public static class Builder {
        private String teamMemberId;
        private Integer limit;
        private String cursor;



        /**
         * Setter for teamMemberId.
         * @param teamMemberId String value for teamMemberId.
         * @return Builder
         */
        public Builder teamMemberId(String teamMemberId) {
            this.teamMemberId = teamMemberId;
            return this;
        }

        /**
         * Setter for limit.
         * @param limit Integer value for limit.
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Setter for cursor.
         * @param cursor String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Builds a new {@link ListTeamMemberWagesRequest} object using the set fields.
         * @return {@link ListTeamMemberWagesRequest}
         */
        public ListTeamMemberWagesRequest build() {
            return new ListTeamMemberWagesRequest(teamMemberId,
                limit,
                cursor);
        }
    }
}
