package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for ListTeamMemberWagesRequest type.
 */
public class ListTeamMemberWagesRequest {

    /**
     * Initialization constructor.
     * @param teamMemberId
     * @param limit
     * @param cursor
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

    private final String teamMemberId;
    private final Integer limit;
    private final String cursor;
    /**
     * Getter for TeamMemberId.
     * Filter wages returned to only those that are associated with the
     * specified team member.
     */
    @JsonGetter("team_member_id")
    public String getTeamMemberId() {
        return this.teamMemberId;
    }

    /**
     * Getter for Limit.
     * Maximum number of Team Member Wages to return per page. Can range between
     * 1 and 200. The default is the maximum at 200.
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return this.limit;
    }

    /**
     * Getter for Cursor.
     * Pointer to the next page of Employee Wage results to fetch.
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
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListTeamMemberWagesRequest)) {
            return false;
        }
        ListTeamMemberWagesRequest listTeamMemberWagesRequest = (ListTeamMemberWagesRequest) obj;
        return Objects.equals(teamMemberId, listTeamMemberWagesRequest.teamMemberId) &&
            Objects.equals(limit, listTeamMemberWagesRequest.limit) &&
            Objects.equals(cursor, listTeamMemberWagesRequest.cursor);
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
     * Class to build instances of {@link ListTeamMemberWagesRequest}
     */
    public static class Builder {
        private String teamMemberId;
        private Integer limit;
        private String cursor;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for teamMemberId
         * @param teamMemberId
         * @return Builder
         */
        public Builder teamMemberId(String teamMemberId) {
            this.teamMemberId = teamMemberId;
            return this;
        }
        /**
         * Setter for limit
         * @param limit
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
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
