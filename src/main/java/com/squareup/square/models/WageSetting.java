
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for WageSetting type.
 */
public class WageSetting {
    private final String teamMemberId;
    private final List<JobAssignment> jobAssignments;
    private final Boolean isOvertimeExempt;
    private final Integer version;
    private final String createdAt;
    private final String updatedAt;

    /**
     * Initialization constructor.
     * @param teamMemberId String value for teamMemberId.
     * @param jobAssignments List of JobAssignment value for jobAssignments.
     * @param isOvertimeExempt Boolean value for isOvertimeExempt.
     * @param version Integer value for version.
     * @param createdAt String value for createdAt.
     * @param updatedAt String value for updatedAt.
     */
    @JsonCreator
    public WageSetting(
            @JsonProperty("team_member_id") String teamMemberId,
            @JsonProperty("job_assignments") List<JobAssignment> jobAssignments,
            @JsonProperty("is_overtime_exempt") Boolean isOvertimeExempt,
            @JsonProperty("version") Integer version,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt) {
        this.teamMemberId = teamMemberId;
        this.jobAssignments = jobAssignments;
        this.isOvertimeExempt = isOvertimeExempt;
        this.version = version;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * Getter for TeamMemberId.
     * The unique ID of the `TeamMember` whom this wage setting describes.
     * @return Returns the String
     */
    @JsonGetter("team_member_id")
    public String getTeamMemberId() {
        return this.teamMemberId;
    }

    /**
     * Getter for JobAssignments.
     * <b>Required</b> The ordered list of jobs that the team member is assigned to. The first job
     * assignment is considered the team member's "Primary Job". <br> <b>Min Length 1 Max Length
     * 12</b>
     * @return Returns the List of JobAssignment
     */
    @JsonGetter("job_assignments")
    public List<JobAssignment> getJobAssignments() {
        return this.jobAssignments;
    }

    /**
     * Getter for IsOvertimeExempt.
     * Whether the team member is exempt from the overtime rules of the seller country.
     * @return Returns the Boolean
     */
    @JsonGetter("is_overtime_exempt")
    public Boolean getIsOvertimeExempt() {
        return this.isOvertimeExempt;
    }

    /**
     * Getter for Version.
     * Used for resolving concurrency issues; request will fail if version provided does not match
     * server version at time of request. If not provided, Square executes a blind write,
     * potentially overwriting data from another write. Read about [optimistic
     * concurrency](https://developer.squareup.com/docs/working-with-apis/optimistic-concurrency) in
     * Square APIs for more information.
     * @return Returns the Integer
     */
    @JsonGetter("version")
    public Integer getVersion() {
        return this.version;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp in RFC 3339 format describing when the wage setting object was created. Ex:
     * "2018-10-04T04:00:00-07:00" or "2019-02-05T12:00:00Z"
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp in RFC 3339 format describing when the wage setting object was last updated.
     * Ex: "2018-10-04T04:00:00-07:00" or "2019-02-05T12:00:00Z"
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() {
        return this.updatedAt;
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
                .teamMemberId(getTeamMemberId())
                .jobAssignments(getJobAssignments())
                .isOvertimeExempt(getIsOvertimeExempt())
                .version(getVersion())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt());
        return builder;
    }

    /**
     * Class to build instances of {@link WageSetting}.
     */
    public static class Builder {
        private String teamMemberId;
        private List<JobAssignment> jobAssignments;
        private Boolean isOvertimeExempt;
        private Integer version;
        private String createdAt;
        private String updatedAt;



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
         * Setter for jobAssignments.
         * @param jobAssignments List of JobAssignment value for jobAssignments.
         * @return Builder
         */
        public Builder jobAssignments(List<JobAssignment> jobAssignments) {
            this.jobAssignments = jobAssignments;
            return this;
        }

        /**
         * Setter for isOvertimeExempt.
         * @param isOvertimeExempt Boolean value for isOvertimeExempt.
         * @return Builder
         */
        public Builder isOvertimeExempt(Boolean isOvertimeExempt) {
            this.isOvertimeExempt = isOvertimeExempt;
            return this;
        }

        /**
         * Setter for version.
         * @param version Integer value for version.
         * @return Builder
         */
        public Builder version(Integer version) {
            this.version = version;
            return this;
        }

        /**
         * Setter for createdAt.
         * @param createdAt String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for updatedAt.
         * @param updatedAt String value for updatedAt.
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
