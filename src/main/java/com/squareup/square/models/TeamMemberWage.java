
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
 * This is a model class for TeamMemberWage type.
 */
public class TeamMemberWage {
    private final String id;
    private final OptionalNullable<String> teamMemberId;
    private final OptionalNullable<String> title;
    private final Money hourlyRate;
    private final OptionalNullable<String> jobId;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  teamMemberId  String value for teamMemberId.
     * @param  title  String value for title.
     * @param  hourlyRate  Money value for hourlyRate.
     * @param  jobId  String value for jobId.
     */
    @JsonCreator
    public TeamMemberWage(
            @JsonProperty("id") String id,
            @JsonProperty("team_member_id") String teamMemberId,
            @JsonProperty("title") String title,
            @JsonProperty("hourly_rate") Money hourlyRate,
            @JsonProperty("job_id") String jobId) {
        this.id = id;
        this.teamMemberId = OptionalNullable.of(teamMemberId);
        this.title = OptionalNullable.of(title);
        this.hourlyRate = hourlyRate;
        this.jobId = OptionalNullable.of(jobId);
    }

    /**
     * Internal initialization constructor.
     */
    protected TeamMemberWage(String id, OptionalNullable<String> teamMemberId,
            OptionalNullable<String> title, Money hourlyRate, OptionalNullable<String> jobId) {
        this.id = id;
        this.teamMemberId = teamMemberId;
        this.title = title;
        this.hourlyRate = hourlyRate;
        this.jobId = jobId;
    }

    /**
     * Getter for Id.
     * The UUID for this object.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Internal Getter for TeamMemberId.
     * The `TeamMember` that this wage is assigned to.
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
     * The `TeamMember` that this wage is assigned to.
     * @return Returns the String
     */
    @JsonIgnore
    public String getTeamMemberId() {
        return OptionalNullable.getFrom(teamMemberId);
    }

    /**
     * Internal Getter for Title.
     * The job title that this wage relates to.
     * @return Returns the Internal String
     */
    @JsonGetter("title")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetTitle() {
        return this.title;
    }

    /**
     * Getter for Title.
     * The job title that this wage relates to.
     * @return Returns the String
     */
    @JsonIgnore
    public String getTitle() {
        return OptionalNullable.getFrom(title);
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getHourlyRate() {
        return hourlyRate;
    }

    /**
     * Internal Getter for JobId.
     * An identifier for the job that this wage relates to. This cannot be used to retrieve the job.
     * @return Returns the Internal String
     */
    @JsonGetter("job_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetJobId() {
        return this.jobId;
    }

    /**
     * Getter for JobId.
     * An identifier for the job that this wage relates to. This cannot be used to retrieve the job.
     * @return Returns the String
     */
    @JsonIgnore
    public String getJobId() {
        return OptionalNullable.getFrom(jobId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teamMemberId, title, hourlyRate, jobId);
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
            && Objects.equals(hourlyRate, other.hourlyRate)
            && Objects.equals(jobId, other.jobId);
    }

    /**
     * Converts this TeamMemberWage into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "TeamMemberWage [" + "id=" + id + ", teamMemberId=" + teamMemberId + ", title="
                + title + ", hourlyRate=" + hourlyRate + ", jobId=" + jobId + "]";
    }

    /**
     * Builds a new {@link TeamMemberWage.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TeamMemberWage.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .hourlyRate(getHourlyRate());
        builder.teamMemberId = internalGetTeamMemberId();
        builder.title = internalGetTitle();
        builder.jobId = internalGetJobId();
        return builder;
    }

    /**
     * Class to build instances of {@link TeamMemberWage}.
     */
    public static class Builder {
        private String id;
        private OptionalNullable<String> teamMemberId;
        private OptionalNullable<String> title;
        private Money hourlyRate;
        private OptionalNullable<String> jobId;



        /**
         * Setter for id.
         * @param  id  String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

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
         * Setter for title.
         * @param  title  String value for title.
         * @return Builder
         */
        public Builder title(String title) {
            this.title = OptionalNullable.of(title);
            return this;
        }

        /**
         * UnSetter for title.
         * @return Builder
         */
        public Builder unsetTitle() {
            title = null;
            return this;
        }

        /**
         * Setter for hourlyRate.
         * @param  hourlyRate  Money value for hourlyRate.
         * @return Builder
         */
        public Builder hourlyRate(Money hourlyRate) {
            this.hourlyRate = hourlyRate;
            return this;
        }

        /**
         * Setter for jobId.
         * @param  jobId  String value for jobId.
         * @return Builder
         */
        public Builder jobId(String jobId) {
            this.jobId = OptionalNullable.of(jobId);
            return this;
        }

        /**
         * UnSetter for jobId.
         * @return Builder
         */
        public Builder unsetJobId() {
            jobId = null;
            return this;
        }

        /**
         * Builds a new {@link TeamMemberWage} object using the set fields.
         * @return {@link TeamMemberWage}
         */
        public TeamMemberWage build() {
            return new TeamMemberWage(id, teamMemberId, title, hourlyRate, jobId);
        }
    }
}
