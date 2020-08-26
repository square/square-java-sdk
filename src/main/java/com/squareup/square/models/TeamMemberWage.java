package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for TeamMemberWage type.
 */
public class TeamMemberWage {

    /**
     * Initialization constructor.
     * @param id
     * @param teamMemberId
     * @param title
     * @param hourlyRate
     */
    @JsonCreator
    public TeamMemberWage(
            @JsonProperty("id") String id,
            @JsonProperty("team_member_id") String teamMemberId,
            @JsonProperty("title") String title,
            @JsonProperty("hourly_rate") Money hourlyRate) {
        this.id = id;
        this.teamMemberId = teamMemberId;
        this.title = title;
        this.hourlyRate = hourlyRate;
    }

    private final String id;
    private final String teamMemberId;
    private final String title;
    private final Money hourlyRate;
    /**
     * Getter for Id.
     * UUID for this object.
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for TeamMemberId.
     * The `Team Member` that this wage is assigned to.
     */
    @JsonGetter("team_member_id")
    public String getTeamMemberId() {
        return this.teamMemberId;
    }

    /**
     * Getter for Title.
     * The job title that this wage relates to.
     */
    @JsonGetter("title")
    public String getTitle() {
        return this.title;
    }

    /**
     * Getter for HourlyRate.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("hourly_rate")
    public Money getHourlyRate() {
        return this.hourlyRate;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, teamMemberId, title, hourlyRate);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof TeamMemberWage)) {
            return false;
        }
        TeamMemberWage teamMemberWage = (TeamMemberWage) obj;
        return Objects.equals(id, teamMemberWage.id) &&
            Objects.equals(teamMemberId, teamMemberWage.teamMemberId) &&
            Objects.equals(title, teamMemberWage.title) &&
            Objects.equals(hourlyRate, teamMemberWage.hourlyRate);
    }

    /**
     * Builds a new {@link TeamMemberWage.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TeamMemberWage.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .id(getId())
            .teamMemberId(getTeamMemberId())
            .title(getTitle())
            .hourlyRate(getHourlyRate());
            return builder;
    }

    /**
     * Class to build instances of {@link TeamMemberWage}
     */
    public static class Builder {
        private String id;
        private String teamMemberId;
        private String title;
        private Money hourlyRate;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for id
         * @param id
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
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
         * Setter for title
         * @param title
         * @return Builder
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }
        /**
         * Setter for hourlyRate
         * @param hourlyRate
         * @return Builder
         */
        public Builder hourlyRate(Money hourlyRate) {
            this.hourlyRate = hourlyRate;
            return this;
        }

        /**
         * Builds a new {@link TeamMemberWage} object using the set fields.
         * @return {@link TeamMemberWage}
         */
        public TeamMemberWage build() {
            return new TeamMemberWage(id,
                teamMemberId,
                title,
                hourlyRate);
        }
    }
}
