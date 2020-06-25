package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for WageSetting type.
 */
public class WageSetting {

    /**
     * Initialization constructor.
     * @param teamMemberId
     * @param jobAssignments
     * @param isOvertimeExempt
     * @param version
     * @param createdAt
     * @param updatedAt
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

    private final String teamMemberId;
    private final List<JobAssignment> jobAssignments;
    private final Boolean isOvertimeExempt;
    private final Integer version;
    private final String createdAt;
    private final String updatedAt;
    /**
     * Getter for TeamMemberId.
     * The unique ID of the `TeamMember` whom this wage setting describes.
     */
    @JsonGetter("team_member_id")
    public String getTeamMemberId() {
        return this.teamMemberId;
    }

    /**
     * Getter for JobAssignments.
     * <b>Required</b> The ordered list of jobs that the team member is assigned to.
     * The first job assignment is considered the team member's "Primary Job".
     * <br>
     * <b>Min Length 1    Max Length 12</b>
     */
    @JsonGetter("job_assignments")
    public List<JobAssignment> getJobAssignments() {
        return this.jobAssignments;
    }

    /**
     * Getter for IsOvertimeExempt.
     * Whether the team member is exempt from the overtime rules of the seller country.
     */
    @JsonGetter("is_overtime_exempt")
    public Boolean getIsOvertimeExempt() {
        return this.isOvertimeExempt;
    }

    /**
     * Getter for Version.
     * Used for resolving concurrency issues; request will fail if version
     * provided does not match server version at time of request. If not provided,
     * Square executes a blind write, potentially overwriting data from another write. Read
     * about [optimistic concurrency](https://developer.squareup.com/docs/docs/working-with-apis/optimistic-concurrency)
     * in Square APIs for more information.
     */
    @JsonGetter("version")
    public Integer getVersion() {
        return this.version;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp in RFC 3339 format describing when the wage setting object was created.
     * Ex: "2018-10-04T04:00:00-07:00" or "2019-02-05T12:00:00Z"
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp in RFC 3339 format describing when the wage setting object was last updated.
     * Ex: "2018-10-04T04:00:00-07:00" or "2019-02-05T12:00:00Z"
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
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof WageSetting)) {
            return false;
        }
        WageSetting wageSetting = (WageSetting) obj;
        return Objects.equals(teamMemberId, wageSetting.teamMemberId) &&
            Objects.equals(jobAssignments, wageSetting.jobAssignments) &&
            Objects.equals(isOvertimeExempt, wageSetting.isOvertimeExempt) &&
            Objects.equals(version, wageSetting.version) &&
            Objects.equals(createdAt, wageSetting.createdAt) &&
            Objects.equals(updatedAt, wageSetting.updatedAt);
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
     * Class to build instances of {@link WageSetting}
     */
    public static class Builder {
        private String teamMemberId;
        private List<JobAssignment> jobAssignments;
        private Boolean isOvertimeExempt;
        private Integer version;
        private String createdAt;
        private String updatedAt;

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
         * Setter for jobAssignments
         * @param jobAssignments
         * @return Builder
         */
        public Builder jobAssignments(List<JobAssignment> jobAssignments) {
            this.jobAssignments = jobAssignments;
            return this;
        }
        /**
         * Setter for isOvertimeExempt
         * @param isOvertimeExempt
         * @return Builder
         */
        public Builder isOvertimeExempt(Boolean isOvertimeExempt) {
            this.isOvertimeExempt = isOvertimeExempt;
            return this;
        }
        /**
         * Setter for version
         * @param version
         * @return Builder
         */
        public Builder version(Integer version) {
            this.version = version;
            return this;
        }
        /**
         * Setter for createdAt
         * @param createdAt
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }
        /**
         * Setter for updatedAt
         * @param updatedAt
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
            return new WageSetting(teamMemberId,
                jobAssignments,
                isOvertimeExempt,
                version,
                createdAt,
                updatedAt);
        }
    }
}
