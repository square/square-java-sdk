
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for TeamMemberWage type.
 */
public class TeamMemberWage {
    private final String id;
    private final String teamMemberId;
    private final String title;
    private final Money hourlyRate;

    /**
     * Initialization constructor.
     * @param id String value for id.
     * @param teamMemberId String value for teamMemberId.
     * @param title String value for title.
     * @param hourlyRate Money value for hourlyRate.
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

    /**
     * Getter for Id.
     * UUID for this object.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for TeamMemberId.
     * The `Team Member` that this wage is assigned to.
     * @return Returns the String
     */
    @JsonGetter("team_member_id")
    public String getTeamMemberId() {
        return this.teamMemberId;
    }

    /**
     * Getter for Title.
     * The job title that this wage relates to.
     * @return Returns the String
     */
    @JsonGetter("title")
    public String getTitle() {
        return this.title;
    }

    /**
     * Getter for HourlyRate.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TeamMemberWage)) {
            return false;
        }
        TeamMemberWage other = (TeamMemberWage) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(teamMemberId, other.teamMemberId)
            && Objects.equals(title, other.title)
            && Objects.equals(hourlyRate, other.hourlyRate);
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
     * Class to build instances of {@link TeamMemberWage}.
     */
    public static class Builder {
        private String id;
        private String teamMemberId;
        private String title;
        private Money hourlyRate;



        /**
         * Setter for id.
         * @param id String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

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
         * Setter for title.
         * @param title String value for title.
         * @return Builder
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * Setter for hourlyRate.
         * @param hourlyRate Money value for hourlyRate.
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
