
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
 * This is a model class for TeamMember type.
 */
public class TeamMember {
    private final String id;
    private final OptionalNullable<String> referenceId;
    private final Boolean isOwner;
    private final String status;
    private final OptionalNullable<String> givenName;
    private final OptionalNullable<String> familyName;
    private final OptionalNullable<String> emailAddress;
    private final OptionalNullable<String> phoneNumber;
    private final String createdAt;
    private final String updatedAt;
    private final TeamMemberAssignedLocations assignedLocations;
    private final WageSetting wageSetting;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  referenceId  String value for referenceId.
     * @param  isOwner  Boolean value for isOwner.
     * @param  status  String value for status.
     * @param  givenName  String value for givenName.
     * @param  familyName  String value for familyName.
     * @param  emailAddress  String value for emailAddress.
     * @param  phoneNumber  String value for phoneNumber.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  assignedLocations  TeamMemberAssignedLocations value for assignedLocations.
     * @param  wageSetting  WageSetting value for wageSetting.
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
            @JsonProperty("assigned_locations") TeamMemberAssignedLocations assignedLocations,
            @JsonProperty("wage_setting") WageSetting wageSetting) {
        this.id = id;
        this.referenceId = OptionalNullable.of(referenceId);
        this.isOwner = isOwner;
        this.status = status;
        this.givenName = OptionalNullable.of(givenName);
        this.familyName = OptionalNullable.of(familyName);
        this.emailAddress = OptionalNullable.of(emailAddress);
        this.phoneNumber = OptionalNullable.of(phoneNumber);
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.assignedLocations = assignedLocations;
        this.wageSetting = wageSetting;
    }

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  referenceId  String value for referenceId.
     * @param  isOwner  Boolean value for isOwner.
     * @param  status  String value for status.
     * @param  givenName  String value for givenName.
     * @param  familyName  String value for familyName.
     * @param  emailAddress  String value for emailAddress.
     * @param  phoneNumber  String value for phoneNumber.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  assignedLocations  TeamMemberAssignedLocations value for assignedLocations.
     * @param  wageSetting  WageSetting value for wageSetting.
     */

    protected TeamMember(String id, OptionalNullable<String> referenceId, Boolean isOwner,
            String status, OptionalNullable<String> givenName, OptionalNullable<String> familyName,
            OptionalNullable<String> emailAddress, OptionalNullable<String> phoneNumber,
            String createdAt, String updatedAt, TeamMemberAssignedLocations assignedLocations,
            WageSetting wageSetting) {
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
        this.wageSetting = wageSetting;
    }

    /**
     * Getter for Id.
     * The unique ID for the team member.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Internal Getter for ReferenceId.
     * A second ID used to associate the team member with an entity in another system.
     * @return Returns the Internal String
     */
    @JsonGetter("reference_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetReferenceId() {
        return this.referenceId;
    }

    /**
     * Getter for ReferenceId.
     * A second ID used to associate the team member with an entity in another system.
     * @return Returns the String
     */
    @JsonIgnore
    public String getReferenceId() {
        return OptionalNullable.getFrom(referenceId);
    }

    /**
     * Getter for IsOwner.
     * Whether the team member is the owner of the Square account.
     * @return Returns the Boolean
     */
    @JsonGetter("is_owner")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getIsOwner() {
        return isOwner;
    }

    /**
     * Getter for Status.
     * Enumerates the possible statuses the team member can have within a business.
     * @return Returns the String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStatus() {
        return status;
    }

    /**
     * Internal Getter for GivenName.
     * The given name (that is, the first name) associated with the team member.
     * @return Returns the Internal String
     */
    @JsonGetter("given_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetGivenName() {
        return this.givenName;
    }

    /**
     * Getter for GivenName.
     * The given name (that is, the first name) associated with the team member.
     * @return Returns the String
     */
    @JsonIgnore
    public String getGivenName() {
        return OptionalNullable.getFrom(givenName);
    }

    /**
     * Internal Getter for FamilyName.
     * The family name (that is, the last name) associated with the team member.
     * @return Returns the Internal String
     */
    @JsonGetter("family_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetFamilyName() {
        return this.familyName;
    }

    /**
     * Getter for FamilyName.
     * The family name (that is, the last name) associated with the team member.
     * @return Returns the String
     */
    @JsonIgnore
    public String getFamilyName() {
        return OptionalNullable.getFrom(familyName);
    }

    /**
     * Internal Getter for EmailAddress.
     * The email address associated with the team member. After accepting the invitation from
     * Square, only the team member can change this value.
     * @return Returns the Internal String
     */
    @JsonGetter("email_address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetEmailAddress() {
        return this.emailAddress;
    }

    /**
     * Getter for EmailAddress.
     * The email address associated with the team member. After accepting the invitation from
     * Square, only the team member can change this value.
     * @return Returns the String
     */
    @JsonIgnore
    public String getEmailAddress() {
        return OptionalNullable.getFrom(emailAddress);
    }

    /**
     * Internal Getter for PhoneNumber.
     * The team member's phone number, in E.164 format. For example: +14155552671 - the country code
     * is 1 for US +551155256325 - the country code is 55 for BR
     * @return Returns the Internal String
     */
    @JsonGetter("phone_number")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Getter for PhoneNumber.
     * The team member's phone number, in E.164 format. For example: +14155552671 - the country code
     * is 1 for US +551155256325 - the country code is 55 for BR
     * @return Returns the String
     */
    @JsonIgnore
    public String getPhoneNumber() {
        return OptionalNullable.getFrom(phoneNumber);
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the team member was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp when the team member was last updated, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Getter for AssignedLocations.
     * An object that represents a team member's assignment to locations.
     * @return Returns the TeamMemberAssignedLocations
     */
    @JsonGetter("assigned_locations")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public TeamMemberAssignedLocations getAssignedLocations() {
        return assignedLocations;
    }

    /**
     * Getter for WageSetting.
     * Represents information about the overtime exemption status, job assignments, and compensation
     * for a [team member]($m/TeamMember).
     * @return Returns the WageSetting
     */
    @JsonGetter("wage_setting")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public WageSetting getWageSetting() {
        return wageSetting;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, referenceId, isOwner, status, givenName, familyName, emailAddress,
                phoneNumber, createdAt, updatedAt, assignedLocations, wageSetting);
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
            && Objects.equals(assignedLocations, other.assignedLocations)
            && Objects.equals(wageSetting, other.wageSetting);
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
                + assignedLocations + ", wageSetting=" + wageSetting + "]";
    }

    /**
     * Builds a new {@link TeamMember.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TeamMember.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .isOwner(getIsOwner())
                .status(getStatus())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt())
                .assignedLocations(getAssignedLocations())
                .wageSetting(getWageSetting());
        builder.referenceId = internalGetReferenceId();
        builder.givenName = internalGetGivenName();
        builder.familyName = internalGetFamilyName();
        builder.emailAddress = internalGetEmailAddress();
        builder.phoneNumber = internalGetPhoneNumber();
        return builder;
    }

    /**
     * Class to build instances of {@link TeamMember}.
     */
    public static class Builder {
        private String id;
        private OptionalNullable<String> referenceId;
        private Boolean isOwner;
        private String status;
        private OptionalNullable<String> givenName;
        private OptionalNullable<String> familyName;
        private OptionalNullable<String> emailAddress;
        private OptionalNullable<String> phoneNumber;
        private String createdAt;
        private String updatedAt;
        private TeamMemberAssignedLocations assignedLocations;
        private WageSetting wageSetting;



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
         * Setter for referenceId.
         * @param  referenceId  String value for referenceId.
         * @return Builder
         */
        public Builder referenceId(String referenceId) {
            this.referenceId = OptionalNullable.of(referenceId);
            return this;
        }

        /**
         * UnSetter for referenceId.
         * @return Builder
         */
        public Builder unsetReferenceId() {
            referenceId = null;
            return this;
        }

        /**
         * Setter for isOwner.
         * @param  isOwner  Boolean value for isOwner.
         * @return Builder
         */
        public Builder isOwner(Boolean isOwner) {
            this.isOwner = isOwner;
            return this;
        }

        /**
         * Setter for status.
         * @param  status  String value for status.
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Setter for givenName.
         * @param  givenName  String value for givenName.
         * @return Builder
         */
        public Builder givenName(String givenName) {
            this.givenName = OptionalNullable.of(givenName);
            return this;
        }

        /**
         * UnSetter for givenName.
         * @return Builder
         */
        public Builder unsetGivenName() {
            givenName = null;
            return this;
        }

        /**
         * Setter for familyName.
         * @param  familyName  String value for familyName.
         * @return Builder
         */
        public Builder familyName(String familyName) {
            this.familyName = OptionalNullable.of(familyName);
            return this;
        }

        /**
         * UnSetter for familyName.
         * @return Builder
         */
        public Builder unsetFamilyName() {
            familyName = null;
            return this;
        }

        /**
         * Setter for emailAddress.
         * @param  emailAddress  String value for emailAddress.
         * @return Builder
         */
        public Builder emailAddress(String emailAddress) {
            this.emailAddress = OptionalNullable.of(emailAddress);
            return this;
        }

        /**
         * UnSetter for emailAddress.
         * @return Builder
         */
        public Builder unsetEmailAddress() {
            emailAddress = null;
            return this;
        }

        /**
         * Setter for phoneNumber.
         * @param  phoneNumber  String value for phoneNumber.
         * @return Builder
         */
        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = OptionalNullable.of(phoneNumber);
            return this;
        }

        /**
         * UnSetter for phoneNumber.
         * @return Builder
         */
        public Builder unsetPhoneNumber() {
            phoneNumber = null;
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
         * Setter for assignedLocations.
         * @param  assignedLocations  TeamMemberAssignedLocations value for assignedLocations.
         * @return Builder
         */
        public Builder assignedLocations(TeamMemberAssignedLocations assignedLocations) {
            this.assignedLocations = assignedLocations;
            return this;
        }

        /**
         * Setter for wageSetting.
         * @param  wageSetting  WageSetting value for wageSetting.
         * @return Builder
         */
        public Builder wageSetting(WageSetting wageSetting) {
            this.wageSetting = wageSetting;
            return this;
        }

        /**
         * Builds a new {@link TeamMember} object using the set fields.
         * @return {@link TeamMember}
         */
        public TeamMember build() {
            return new TeamMember(id, referenceId, isOwner, status, givenName, familyName,
                    emailAddress, phoneNumber, createdAt, updatedAt, assignedLocations,
                    wageSetting);
        }
    }
}
