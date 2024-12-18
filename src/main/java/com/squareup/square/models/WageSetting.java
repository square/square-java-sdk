
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for WageSetting type.
 */
public class WageSetting {
    private final OptionalNullable<String> teamMemberId;
    private final OptionalNullable<List<JobAssignment>> jobAssignments;
    private final OptionalNullable<Boolean> isOvertimeExempt;
    private final Integer version;
    private final String createdAt;
    private final String updatedAt;

    /**
     * Initialization constructor.
     * @param  teamMemberId  String value for teamMemberId.
     * @param  jobAssignments  List of JobAssignment value for jobAssignments.
     * @param  isOvertimeExempt  Boolean value for isOvertimeExempt.
     * @param  version  Integer value for version.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     */
    @JsonCreator
    public WageSetting(
            @JsonProperty("team_member_id") String teamMemberId,
            @JsonProperty("job_assignments") List<JobAssignment> jobAssignments,
            @JsonProperty("is_overtime_exempt") Boolean isOvertimeExempt,
            @JsonProperty("version") Integer version,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt) {
        this.teamMemberId = OptionalNullable.of(teamMemberId);
        this.jobAssignments = OptionalNullable.of(jobAssignments);
        this.isOvertimeExempt = OptionalNullable.of(isOvertimeExempt);
        this.version = version;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * Initialization constructor.
     * @param  teamMemberId  String value for teamMemberId.
     * @param  jobAssignments  List of JobAssignment value for jobAssignments.
     * @param  isOvertimeExempt  Boolean value for isOvertimeExempt.
     * @param  version  Integer value for version.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     */

    protected WageSetting(OptionalNullable<String> teamMemberId,
            OptionalNullable<List<JobAssignment>> jobAssignments,
            OptionalNullable<Boolean> isOvertimeExempt, Integer version, String createdAt,
            String updatedAt) {
        this.teamMemberId = teamMemberId;
        this.jobAssignments = jobAssignments;
        this.isOvertimeExempt = isOvertimeExempt;
        this.version = version;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * Internal Getter for TeamMemberId.
     * The ID of the team member associated with the wage setting.
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
     * The ID of the team member associated with the wage setting.
     * @return Returns the String
     */
    @JsonIgnore
    public String getTeamMemberId() {
        return OptionalNullable.getFrom(teamMemberId);
    }

    /**
     * Internal Getter for JobAssignments.
     * **Required** The ordered list of jobs that the team member is assigned to. The first job
     * assignment is considered the team member's primary job.
     * @return Returns the Internal List of JobAssignment
     */
    @JsonGetter("job_assignments")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<JobAssignment>> internalGetJobAssignments() {
        return this.jobAssignments;
    }

    /**
     * Getter for JobAssignments.
     * **Required** The ordered list of jobs that the team member is assigned to. The first job
     * assignment is considered the team member's primary job.
     * @return Returns the List of JobAssignment
     */
    @JsonIgnore
    public List<JobAssignment> getJobAssignments() {
        return OptionalNullable.getFrom(jobAssignments);
    }

    /**
     * Internal Getter for IsOvertimeExempt.
     * Whether the team member is exempt from the overtime rules of the seller's country.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("is_overtime_exempt")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetIsOvertimeExempt() {
        return this.isOvertimeExempt;
    }

    /**
     * Getter for IsOvertimeExempt.
     * Whether the team member is exempt from the overtime rules of the seller's country.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getIsOvertimeExempt() {
        return OptionalNullable.getFrom(isOvertimeExempt);
    }

    /**
     * Getter for Version.
     * **Read only** Used for resolving concurrency issues. The request fails if the version
     * provided does not match the server version at the time of the request. If not provided,
     * Square executes a blind write, potentially overwriting data from another write. For more
     * information, see [optimistic
     * concurrency](https://developer.squareup.com/docs/working-with-apis/optimistic-concurrency).
     * @return Returns the Integer
     */
    @JsonGetter("version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getVersion() {
        return version;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the wage setting was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp when the wage setting was last updated, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamMemberId, jobAssignments, isOvertimeExempt, version, createdAt,
                updatedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WageSetting)) {
            return false;
        }
        WageSetting other = (WageSetting) obj;
        return Objects.equals(teamMemberId, other.teamMemberId)
            && Objects.equals(jobAssignments, other.jobAssignments)
            && Objects.equals(isOvertimeExempt, other.isOvertimeExempt)
            && Objects.equals(version, other.version)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(updatedAt, other.updatedAt);
    }

    /**
     * Converts this WageSetting into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "WageSetting [" + "teamMemberId=" + teamMemberId + ", jobAssignments="
                + jobAssignments + ", isOvertimeExempt=" + isOvertimeExempt + ", version=" + version
                + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }

    /**
     * Builds a new {@link WageSetting.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link WageSetting.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .version(getVersion())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt());
        builder.teamMemberId = internalGetTeamMemberId();
        builder.jobAssignments = internalGetJobAssignments();
        builder.isOvertimeExempt = internalGetIsOvertimeExempt();
        return builder;
    }

    /**
     * Class to build instances of {@link WageSetting}.
     */
    public static class Builder {
        private OptionalNullable<String> teamMemberId;
        private OptionalNullable<List<JobAssignment>> jobAssignments;
        private OptionalNullable<Boolean> isOvertimeExempt;
        private Integer version;
        private String createdAt;
        private String updatedAt;



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
         * Setter for jobAssignments.
         * @param  jobAssignments  List of JobAssignment value for jobAssignments.
         * @return Builder
         */
        public Builder jobAssignments(List<JobAssignment> jobAssignments) {
            this.jobAssignments = OptionalNullable.of(jobAssignments);
            return this;
        }

        /**
         * UnSetter for jobAssignments.
         * @return Builder
         */
        public Builder unsetJobAssignments() {
            jobAssignments = null;
            return this;
        }

        /**
         * Setter for isOvertimeExempt.
         * @param  isOvertimeExempt  Boolean value for isOvertimeExempt.
         * @return Builder
         */
        public Builder isOvertimeExempt(Boolean isOvertimeExempt) {
            this.isOvertimeExempt = OptionalNullable.of(isOvertimeExempt);
            return this;
        }

        /**
         * UnSetter for isOvertimeExempt.
         * @return Builder
         */
        public Builder unsetIsOvertimeExempt() {
            isOvertimeExempt = null;
            return this;
        }

        /**
         * Setter for version.
         * @param  version  Integer value for version.
         * @return Builder
         */
        public Builder version(Integer version) {
            this.version = version;
            return this;
        }

        /**
         * Setter for createdAt.
         * @param  createdAt  String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for updatedAt.
         * @param  updatedAt  String value for updatedAt.
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * Builds a new {@link WageSetting} object using the set fields.
         * @return {@link WageSetting}
         */
        public WageSetting build() {
            return new WageSetting(teamMemberId, jobAssignments, isOvertimeExempt, version,
                    createdAt, updatedAt);
        }
    }
}
