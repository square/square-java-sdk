package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for TeamMember type.
 */
public class TeamMember {

    /**
     * Initialization constructor.
     * @param id
     * @param referenceId
     * @param isOwner
     * @param status
     * @param givenName
     * @param familyName
     * @param emailAddress
     * @param phoneNumber
     * @param createdAt
     * @param updatedAt
     * @param assignedLocations
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
     * Getter for Id.
     * The unique ID for the team member.
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for ReferenceId.
     * A second ID used to associate the team member with an entity in another system.
     */
    @JsonGetter("reference_id")
    public String getReferenceId() {
        return this.referenceId;
    }

    /**
     * Getter for IsOwner.
     * Whether the team member is the owner of the Square account.
     */
    @JsonGetter("is_owner")
    public Boolean getIsOwner() {
        return this.isOwner;
    }

    /**
     * Getter for Status.
     * Enumerates the possible statuses the team member can have within a business.
     */
    @JsonGetter("status")
    public String getStatus() {
        return this.status;
    }

    /**
     * Getter for GivenName.
     * The given (i.e., first) name associated with the team member.
     */
    @JsonGetter("given_name")
    public String getGivenName() {
        return this.givenName;
    }

    /**
     * Getter for FamilyName.
     * The family (i.e., last) name associated with the team member.
     */
    @JsonGetter("family_name")
    public String getFamilyName() {
        return this.familyName;
    }

    /**
     * Getter for EmailAddress.
     * The email address associated with the team member.
     */
    @JsonGetter("email_address")
    public String getEmailAddress() {
        return this.emailAddress;
    }

    /**
     * Getter for PhoneNumber.
     * The team member's phone number in E.164 format. Examples:
     * +14155552671 - the country code is 1 for US
     * +551155256325 - the country code is 55 for BR
     */
    @JsonGetter("phone_number")
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp in RFC 3339 format describing when the team member was created.
     * Ex: "2018-10-04T04:00:00-07:00" or "2019-02-05T12:00:00Z"
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp in RFC 3339 format describing when the team member was last updated.
     * Ex: "2018-10-04T04:00:00-07:00" or "2019-02-05T12:00:00Z"
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * Getter for AssignedLocations.
     * An object that represents a team member's assignment to locations.
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
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof TeamMember)) {
            return false;
        }
        TeamMember teamMember = (TeamMember) obj;
        return Objects.equals(id, teamMember.id) &&
            Objects.equals(referenceId, teamMember.referenceId) &&
            Objects.equals(isOwner, teamMember.isOwner) &&
            Objects.equals(status, teamMember.status) &&
            Objects.equals(givenName, teamMember.givenName) &&
            Objects.equals(familyName, teamMember.familyName) &&
            Objects.equals(emailAddress, teamMember.emailAddress) &&
            Objects.equals(phoneNumber, teamMember.phoneNumber) &&
            Objects.equals(createdAt, teamMember.createdAt) &&
            Objects.equals(updatedAt, teamMember.updatedAt) &&
            Objects.equals(assignedLocations, teamMember.assignedLocations);
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
     * Class to build instances of {@link TeamMember}
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
         * Setter for referenceId
         * @param referenceId
         * @return Builder
         */
        public Builder referenceId(String referenceId) {
            this.referenceId = referenceId;
            return this;
        }
        /**
         * Setter for isOwner
         * @param isOwner
         * @return Builder
         */
        public Builder isOwner(Boolean isOwner) {
            this.isOwner = isOwner;
            return this;
        }
        /**
         * Setter for status
         * @param status
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }
        /**
         * Setter for givenName
         * @param givenName
         * @return Builder
         */
        public Builder givenName(String givenName) {
            this.givenName = givenName;
            return this;
        }
        /**
         * Setter for familyName
         * @param familyName
         * @return Builder
         */
        public Builder familyName(String familyName) {
            this.familyName = familyName;
            return this;
        }
        /**
         * Setter for emailAddress
         * @param emailAddress
         * @return Builder
         */
        public Builder emailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }
        /**
         * Setter for phoneNumber
         * @param phoneNumber
         * @return Builder
         */
        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
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
         * Setter for assignedLocations
         * @param assignedLocations
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
            return new TeamMember(id,
                referenceId,
                isOwner,
                status,
                givenName,
                familyName,
                emailAddress,
                phoneNumber,
                createdAt,
                updatedAt,
                assignedLocations);
        }
    }
}
