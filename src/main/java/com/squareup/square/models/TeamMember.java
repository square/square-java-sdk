
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for TeamMember type.
 */
public class TeamMember {
    private final String id;
    private final String referenceId;
    private final Boolean isOwner;
    private final String status;
    private final String givenName;
    private final String familyName;
    private final String emailAddress;
    private final String phoneNumber;
    private final String createdAt;
    private final String updatedAt;
    private final TeamMemberAssignedLocations assignedLocations;

    /**
     * Initialization constructor.
     * @param id String value for id.
     * @param referenceId String value for referenceId.
     * @param isOwner Boolean value for isOwner.
     * @param status String value for status.
     * @param givenName String value for givenName.
     * @param familyName String value for familyName.
     * @param emailAddress String value for emailAddress.
     * @param phoneNumber String value for phoneNumber.
     * @param createdAt String value for createdAt.
     * @param updatedAt String value for updatedAt.
     * @param assignedLocations TeamMemberAssignedLocations value for assignedLocations.
     */
    @JsonCreator
    public TeamMember(
            @JsonProperty("id") String id,
            @JsonProperty("reference_id") String referenceId,
            @JsonProperty("is_owner") Boolean isOwner,
            @JsonProperty("status") String status,
            @JsonProperty("given_name") String givenName,
            @JsonProperty("family_name") String familyName,
            @JsonProperty("email_address") String emailAddress,
            @JsonProperty("phone_number") String phoneNumber,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("assigned_locations") TeamMemberAssignedLocations assignedLocations) {
        this.id = id;
        this.referenceId = referenceId;
        this.isOwner = isOwner;
        this.status = status;
        this.givenName = givenName;
        this.familyName = familyName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.assignedLocations = assignedLocations;
    }

    /**
     * Getter for Id.
     * The unique ID for the team member.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for ReferenceId.
     * A second ID used to associate the team member with an entity in another system.
     * @return Returns the String
     */
    @JsonGetter("reference_id")
    public String getReferenceId() {
        return this.referenceId;
    }

    /**
     * Getter for IsOwner.
     * Whether the team member is the owner of the Square account.
     * @return Returns the Boolean
     */
    @JsonGetter("is_owner")
    public Boolean getIsOwner() {
        return this.isOwner;
    }

    /**
     * Getter for Status.
     * Enumerates the possible statuses the team member can have within a business.
     * @return Returns the String
     */
    @JsonGetter("status")
    public String getStatus() {
        return this.status;
    }

    /**
     * Getter for GivenName.
     * The given (i.e., first) name associated with the team member.
     * @return Returns the String
     */
    @JsonGetter("given_name")
    public String getGivenName() {
        return this.givenName;
    }

    /**
     * Getter for FamilyName.
     * The family (i.e., last) name associated with the team member.
     * @return Returns the String
     */
    @JsonGetter("family_name")
    public String getFamilyName() {
        return this.familyName;
    }

    /**
     * Getter for EmailAddress.
     * The email address associated with the team member.
     * @return Returns the String
     */
    @JsonGetter("email_address")
    public String getEmailAddress() {
        return this.emailAddress;
    }

    /**
     * Getter for PhoneNumber.
     * The team member's phone number in E.164 format. Examples: +14155552671 - the country code is
     * 1 for US +551155256325 - the country code is 55 for BR
     * @return Returns the String
     */
    @JsonGetter("phone_number")
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp in RFC 3339 format describing when the team member was created. Ex:
     * "2018-10-04T04:00:00-07:00" or "2019-02-05T12:00:00Z"
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp in RFC 3339 format describing when the team member was last updated. Ex:
     * "2018-10-04T04:00:00-07:00" or "2019-02-05T12:00:00Z"
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * Getter for AssignedLocations.
     * An object that represents a team member's assignment to locations.
     * @return Returns the TeamMemberAssignedLocations
     */
    @JsonGetter("assigned_locations")
    public TeamMemberAssignedLocations getAssignedLocations() {
        return this.assignedLocations;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, referenceId, isOwner, status, givenName, familyName, emailAddress,
                phoneNumber, createdAt, updatedAt, assignedLocations);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TeamMember)) {
            return false;
        }
        TeamMember other = (TeamMember) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(referenceId, other.referenceId)
            && Objects.equals(isOwner, other.isOwner)
            && Objects.equals(status, other.status)
            && Objects.equals(givenName, other.givenName)
            && Objects.equals(familyName, other.familyName)
            && Objects.equals(emailAddress, other.emailAddress)
            && Objects.equals(phoneNumber, other.phoneNumber)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(updatedAt, other.updatedAt)
            && Objects.equals(assignedLocations, other.assignedLocations);
    }

    /**
     * Converts this TeamMember into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "TeamMember [" + "id=" + id + ", referenceId=" + referenceId + ", isOwner=" + isOwner
                + ", status=" + status + ", givenName=" + givenName + ", familyName=" + familyName
                + ", emailAddress=" + emailAddress + ", phoneNumber=" + phoneNumber + ", createdAt="
                + createdAt + ", updatedAt=" + updatedAt + ", assignedLocations="
                + assignedLocations + "]";
    }

    /**
     * Builds a new {@link TeamMember.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TeamMember.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .referenceId(getReferenceId())
                .isOwner(getIsOwner())
                .status(getStatus())
                .givenName(getGivenName())
                .familyName(getFamilyName())
                .emailAddress(getEmailAddress())
                .phoneNumber(getPhoneNumber())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt())
                .assignedLocations(getAssignedLocations());
        return builder;
    }

    /**
     * Class to build instances of {@link TeamMember}.
     */
    public static class Builder {
        private String id;
        private String referenceId;
        private Boolean isOwner;
        private String status;
        private String givenName;
        private String familyName;
        private String emailAddress;
        private String phoneNumber;
        private String createdAt;
        private String updatedAt;
        private TeamMemberAssignedLocations assignedLocations;



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
         * Setter for referenceId.
         * @param referenceId String value for referenceId.
         * @return Builder
         */
        public Builder referenceId(String referenceId) {
            this.referenceId = referenceId;
            return this;
        }

        /**
         * Setter for isOwner.
         * @param isOwner Boolean value for isOwner.
         * @return Builder
         */
        public Builder isOwner(Boolean isOwner) {
            this.isOwner = isOwner;
            return this;
        }

        /**
         * Setter for status.
         * @param status String value for status.
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Setter for givenName.
         * @param givenName String value for givenName.
         * @return Builder
         */
        public Builder givenName(String givenName) {
            this.givenName = givenName;
            return this;
        }

        /**
         * Setter for familyName.
         * @param familyName String value for familyName.
         * @return Builder
         */
        public Builder familyName(String familyName) {
            this.familyName = familyName;
            return this;
        }

        /**
         * Setter for emailAddress.
         * @param emailAddress String value for emailAddress.
         * @return Builder
         */
        public Builder emailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        /**
         * Setter for phoneNumber.
         * @param phoneNumber String value for phoneNumber.
         * @return Builder
         */
        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
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
         * Setter for assignedLocations.
         * @param assignedLocations TeamMemberAssignedLocations value for assignedLocations.
         * @return Builder
         */
        public Builder assignedLocations(TeamMemberAssignedLocations assignedLocations) {
            this.assignedLocations = assignedLocations;
            return this;
        }

        /**
         * Builds a new {@link TeamMember} object using the set fields.
         * @return {@link TeamMember}
         */
        public TeamMember build() {
            return new TeamMember(id, referenceId, isOwner, status, givenName, familyName,
                    emailAddress, phoneNumber, createdAt, updatedAt, assignedLocations);
        }
    }
}
