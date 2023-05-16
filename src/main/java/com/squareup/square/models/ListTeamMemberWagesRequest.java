
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for ListTeamMemberWagesRequest type.
 */
public class ListTeamMemberWagesRequest {
    private final OptionalNullable<String> teamMemberId;
    private final OptionalNullable<Integer> limit;
    private final OptionalNullable<String> cursor;

    /**
     * Initialization constructor.
     * @param  teamMemberId  String value for teamMemberId.
     * @param  limit  Integer value for limit.
     * @param  cursor  String value for cursor.
     */
    @JsonCreator
    public ListTeamMemberWagesRequest(
            @JsonProperty("team_member_id") String teamMemberId,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("cursor") String cursor) {
        this.teamMemberId = OptionalNullable.of(teamMemberId);
        this.limit = OptionalNullable.of(limit);
        this.cursor = OptionalNullable.of(cursor);
    }

    /**
     * Internal initialization constructor.
     */
    protected ListTeamMemberWagesRequest(OptionalNullable<String> teamMemberId,
            OptionalNullable<Integer> limit, OptionalNullable<String> cursor) {
        this.teamMemberId = teamMemberId;
        this.limit = limit;
        this.cursor = cursor;
    }

    /**
     * Internal Getter for TeamMemberId.
     * Filter the returned wages to only those that are associated with the specified team member.
     * @return Returns the Internal String
     */
    @JsonGetter("team_member_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetTeamMemberId() {
        return this.teamMemberId;
    }

    /**
     * Getter for TeamMemberId.
     * Filter the returned wages to only those that are associated with the specified team member.
     * @return Returns the String
     */
    @JsonIgnore
    public String getTeamMemberId() {
        return OptionalNullable.getFrom(teamMemberId);
    }

    /**
     * Internal Getter for Limit.
     * The maximum number of `TeamMemberWage` results to return per page. The number can range
     * between 1 and 200. The default is 200.
     * @return Returns the Internal Integer
     */
    @JsonGetter("limit")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetLimit() {
        return this.limit;
    }

    /**
     * Getter for Limit.
     * The maximum number of `TeamMemberWage` results to return per page. The number can range
     * between 1 and 200. The default is 200.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getLimit() {
        return OptionalNullable.getFrom(limit);
    }

    /**
     * Internal Getter for Cursor.
     * A pointer to the next page of `EmployeeWage` results to fetch.
     * @return Returns the Internal String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCursor() {
        return this.cursor;
    }

    /**
     * Getter for Cursor.
     * A pointer to the next page of `EmployeeWage` results to fetch.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCursor() {
        return OptionalNullable.getFrom(cursor);
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
     * Converts this ListTeamMemberWagesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListTeamMemberWagesRequest [" + "teamMemberId=" + teamMemberId + ", limit=" + limit
                + ", cursor=" + cursor + "]";
    }

    /**
     * Builds a new {@link ListTeamMemberWagesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListTeamMemberWagesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.teamMemberId = internalGetTeamMemberId();
        builder.limit = internalGetLimit();
        builder.cursor = internalGetCursor();
        return builder;
    }

    /**
     * Class to build instances of {@link ListTeamMemberWagesRequest}.
     */
    public static class Builder {
        private OptionalNullable<String> teamMemberId;
        private OptionalNullable<Integer> limit;
        private OptionalNullable<String> cursor;



        /**
         * Setter for teamMemberId.
         * @param  teamMemberId  String value for teamMemberId.
         * @return Builder
         */
        public Builder teamMemberId(String teamMemberId) {
            this.teamMemberId = OptionalNullable.of(teamMemberId);
            return this;
        }

        /**
         * UnSetter for teamMemberId.
         * @return Builder
         */
        public Builder unsetTeamMemberId() {
            teamMemberId = null;
            return this;
        }

        /**
         * Setter for limit.
         * @param  limit  Integer value for limit.
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = OptionalNullable.of(limit);
            return this;
        }

        /**
         * UnSetter for limit.
         * @return Builder
         */
        public Builder unsetLimit() {
            limit = null;
            return this;
        }

        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = OptionalNullable.of(cursor);
            return this;
        }

        /**
         * UnSetter for cursor.
         * @return Builder
         */
        public Builder unsetCursor() {
            cursor = null;
            return this;
        }

        /**
         * Builds a new {@link ListTeamMemberWagesRequest} object using the set fields.
         * @return {@link ListTeamMemberWagesRequest}
         */
        public ListTeamMemberWagesRequest build() {
            return new ListTeamMemberWagesRequest(teamMemberId, limit, cursor);
        }
    }
}
