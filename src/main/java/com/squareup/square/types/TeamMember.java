/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.Nullable;
import com.squareup.square.core.NullableNonemptyFilter;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = TeamMember.Builder.class)
public final class TeamMember {
    private final Optional<String> id;

    private final Optional<String> referenceId;

    private final Optional<Boolean> isOwner;

    private final Optional<TeamMemberStatus> status;

    private final Optional<String> givenName;

    private final Optional<String> familyName;

    private final Optional<String> emailAddress;

    private final Optional<String> phoneNumber;

    private final Optional<String> createdAt;

    private final Optional<String> updatedAt;

    private final Optional<TeamMemberAssignedLocations> assignedLocations;

    private final Optional<WageSetting> wageSetting;

    private final Map<String, Object> additionalProperties;

    private TeamMember(
            Optional<String> id,
            Optional<String> referenceId,
            Optional<Boolean> isOwner,
            Optional<TeamMemberStatus> status,
            Optional<String> givenName,
            Optional<String> familyName,
            Optional<String> emailAddress,
            Optional<String> phoneNumber,
            Optional<String> createdAt,
            Optional<String> updatedAt,
            Optional<TeamMemberAssignedLocations> assignedLocations,
            Optional<WageSetting> wageSetting,
            Map<String, Object> additionalProperties) {
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
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The unique ID for the team member.
     */
    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    /**
     * @return A second ID used to associate the team member with an entity in another system.
     */
    @JsonIgnore
    public Optional<String> getReferenceId() {
        if (referenceId == null) {
            return Optional.empty();
        }
        return referenceId;
    }

    /**
     * @return Whether the team member is the owner of the Square account.
     */
    @JsonProperty("is_owner")
    public Optional<Boolean> getIsOwner() {
        return isOwner;
    }

    /**
     * @return Describes the status of the team member.
     * See <a href="#type-teammemberstatus">TeamMemberStatus</a> for possible values
     */
    @JsonProperty("status")
    public Optional<TeamMemberStatus> getStatus() {
        return status;
    }

    /**
     * @return The given name (that is, the first name) associated with the team member.
     */
    @JsonIgnore
    public Optional<String> getGivenName() {
        if (givenName == null) {
            return Optional.empty();
        }
        return givenName;
    }

    /**
     * @return The family name (that is, the last name) associated with the team member.
     */
    @JsonIgnore
    public Optional<String> getFamilyName() {
        if (familyName == null) {
            return Optional.empty();
        }
        return familyName;
    }

    /**
     * @return The email address associated with the team member. After accepting the invitation
     * from Square, only the team member can change this value.
     */
    @JsonIgnore
    public Optional<String> getEmailAddress() {
        if (emailAddress == null) {
            return Optional.empty();
        }
        return emailAddress;
    }

    /**
     * @return The team member's phone number, in E.164 format. For example:
     * +14155552671 - the country code is 1 for US
     * +551155256325 - the country code is 55 for BR
     */
    @JsonIgnore
    public Optional<String> getPhoneNumber() {
        if (phoneNumber == null) {
            return Optional.empty();
        }
        return phoneNumber;
    }

    /**
     * @return The timestamp when the team member was created, in RFC 3339 format.
     */
    @JsonProperty("created_at")
    public Optional<String> getCreatedAt() {
        return createdAt;
    }

    /**
     * @return The timestamp when the team member was last updated, in RFC 3339 format.
     */
    @JsonProperty("updated_at")
    public Optional<String> getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @return Describes the team member's assigned locations.
     */
    @JsonProperty("assigned_locations")
    public Optional<TeamMemberAssignedLocations> getAssignedLocations() {
        return assignedLocations;
    }

    /**
     * @return Information about the team member's overtime exemption status, job assignments, and compensation.
     */
    @JsonProperty("wage_setting")
    public Optional<WageSetting> getWageSetting() {
        return wageSetting;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("reference_id")
    private Optional<String> _getReferenceId() {
        return referenceId;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("given_name")
    private Optional<String> _getGivenName() {
        return givenName;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("family_name")
    private Optional<String> _getFamilyName() {
        return familyName;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("email_address")
    private Optional<String> _getEmailAddress() {
        return emailAddress;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("phone_number")
    private Optional<String> _getPhoneNumber() {
        return phoneNumber;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TeamMember && equalTo((TeamMember) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(TeamMember other) {
        return id.equals(other.id)
                && referenceId.equals(other.referenceId)
                && isOwner.equals(other.isOwner)
                && status.equals(other.status)
                && givenName.equals(other.givenName)
                && familyName.equals(other.familyName)
                && emailAddress.equals(other.emailAddress)
                && phoneNumber.equals(other.phoneNumber)
                && createdAt.equals(other.createdAt)
                && updatedAt.equals(other.updatedAt)
                && assignedLocations.equals(other.assignedLocations)
                && wageSetting.equals(other.wageSetting);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.referenceId,
                this.isOwner,
                this.status,
                this.givenName,
                this.familyName,
                this.emailAddress,
                this.phoneNumber,
                this.createdAt,
                this.updatedAt,
                this.assignedLocations,
                this.wageSetting);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> id = Optional.empty();

        private Optional<String> referenceId = Optional.empty();

        private Optional<Boolean> isOwner = Optional.empty();

        private Optional<TeamMemberStatus> status = Optional.empty();

        private Optional<String> givenName = Optional.empty();

        private Optional<String> familyName = Optional.empty();

        private Optional<String> emailAddress = Optional.empty();

        private Optional<String> phoneNumber = Optional.empty();

        private Optional<String> createdAt = Optional.empty();

        private Optional<String> updatedAt = Optional.empty();

        private Optional<TeamMemberAssignedLocations> assignedLocations = Optional.empty();

        private Optional<WageSetting> wageSetting = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(TeamMember other) {
            id(other.getId());
            referenceId(other.getReferenceId());
            isOwner(other.getIsOwner());
            status(other.getStatus());
            givenName(other.getGivenName());
            familyName(other.getFamilyName());
            emailAddress(other.getEmailAddress());
            phoneNumber(other.getPhoneNumber());
            createdAt(other.getCreatedAt());
            updatedAt(other.getUpdatedAt());
            assignedLocations(other.getAssignedLocations());
            wageSetting(other.getWageSetting());
            return this;
        }

        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.ofNullable(id);
            return this;
        }

        @JsonSetter(value = "reference_id", nulls = Nulls.SKIP)
        public Builder referenceId(Optional<String> referenceId) {
            this.referenceId = referenceId;
            return this;
        }

        public Builder referenceId(String referenceId) {
            this.referenceId = Optional.ofNullable(referenceId);
            return this;
        }

        public Builder referenceId(Nullable<String> referenceId) {
            if (referenceId.isNull()) {
                this.referenceId = null;
            } else if (referenceId.isEmpty()) {
                this.referenceId = Optional.empty();
            } else {
                this.referenceId = Optional.of(referenceId.get());
            }
            return this;
        }

        @JsonSetter(value = "is_owner", nulls = Nulls.SKIP)
        public Builder isOwner(Optional<Boolean> isOwner) {
            this.isOwner = isOwner;
            return this;
        }

        public Builder isOwner(Boolean isOwner) {
            this.isOwner = Optional.ofNullable(isOwner);
            return this;
        }

        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public Builder status(Optional<TeamMemberStatus> status) {
            this.status = status;
            return this;
        }

        public Builder status(TeamMemberStatus status) {
            this.status = Optional.ofNullable(status);
            return this;
        }

        @JsonSetter(value = "given_name", nulls = Nulls.SKIP)
        public Builder givenName(Optional<String> givenName) {
            this.givenName = givenName;
            return this;
        }

        public Builder givenName(String givenName) {
            this.givenName = Optional.ofNullable(givenName);
            return this;
        }

        public Builder givenName(Nullable<String> givenName) {
            if (givenName.isNull()) {
                this.givenName = null;
            } else if (givenName.isEmpty()) {
                this.givenName = Optional.empty();
            } else {
                this.givenName = Optional.of(givenName.get());
            }
            return this;
        }

        @JsonSetter(value = "family_name", nulls = Nulls.SKIP)
        public Builder familyName(Optional<String> familyName) {
            this.familyName = familyName;
            return this;
        }

        public Builder familyName(String familyName) {
            this.familyName = Optional.ofNullable(familyName);
            return this;
        }

        public Builder familyName(Nullable<String> familyName) {
            if (familyName.isNull()) {
                this.familyName = null;
            } else if (familyName.isEmpty()) {
                this.familyName = Optional.empty();
            } else {
                this.familyName = Optional.of(familyName.get());
            }
            return this;
        }

        @JsonSetter(value = "email_address", nulls = Nulls.SKIP)
        public Builder emailAddress(Optional<String> emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder emailAddress(String emailAddress) {
            this.emailAddress = Optional.ofNullable(emailAddress);
            return this;
        }

        public Builder emailAddress(Nullable<String> emailAddress) {
            if (emailAddress.isNull()) {
                this.emailAddress = null;
            } else if (emailAddress.isEmpty()) {
                this.emailAddress = Optional.empty();
            } else {
                this.emailAddress = Optional.of(emailAddress.get());
            }
            return this;
        }

        @JsonSetter(value = "phone_number", nulls = Nulls.SKIP)
        public Builder phoneNumber(Optional<String> phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = Optional.ofNullable(phoneNumber);
            return this;
        }

        public Builder phoneNumber(Nullable<String> phoneNumber) {
            if (phoneNumber.isNull()) {
                this.phoneNumber = null;
            } else if (phoneNumber.isEmpty()) {
                this.phoneNumber = Optional.empty();
            } else {
                this.phoneNumber = Optional.of(phoneNumber.get());
            }
            return this;
        }

        @JsonSetter(value = "created_at", nulls = Nulls.SKIP)
        public Builder createdAt(Optional<String> createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder createdAt(String createdAt) {
            this.createdAt = Optional.ofNullable(createdAt);
            return this;
        }

        @JsonSetter(value = "updated_at", nulls = Nulls.SKIP)
        public Builder updatedAt(Optional<String> updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder updatedAt(String updatedAt) {
            this.updatedAt = Optional.ofNullable(updatedAt);
            return this;
        }

        @JsonSetter(value = "assigned_locations", nulls = Nulls.SKIP)
        public Builder assignedLocations(Optional<TeamMemberAssignedLocations> assignedLocations) {
            this.assignedLocations = assignedLocations;
            return this;
        }

        public Builder assignedLocations(TeamMemberAssignedLocations assignedLocations) {
            this.assignedLocations = Optional.ofNullable(assignedLocations);
            return this;
        }

        @JsonSetter(value = "wage_setting", nulls = Nulls.SKIP)
        public Builder wageSetting(Optional<WageSetting> wageSetting) {
            this.wageSetting = wageSetting;
            return this;
        }

        public Builder wageSetting(WageSetting wageSetting) {
            this.wageSetting = Optional.ofNullable(wageSetting);
            return this;
        }

        public TeamMember build() {
            return new TeamMember(
                    id,
                    referenceId,
                    isOwner,
                    status,
                    givenName,
                    familyName,
                    emailAddress,
                    phoneNumber,
                    createdAt,
                    updatedAt,
                    assignedLocations,
                    wageSetting,
                    additionalProperties);
        }
    }
}
