package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for TeamMemberBookingProfile type.
 */
public class TeamMemberBookingProfile {
    private final String teamMemberId;
    private final String description;
    private final String displayName;
    private final OptionalNullable<Boolean> isBookable;
    private final String profileImageUrl;

    /**
     * Initialization constructor.
     * @param  teamMemberId  String value for teamMemberId.
     * @param  description  String value for description.
     * @param  displayName  String value for displayName.
     * @param  isBookable  Boolean value for isBookable.
     * @param  profileImageUrl  String value for profileImageUrl.
     */
    @JsonCreator
    public TeamMemberBookingProfile(
            @JsonProperty("team_member_id") String teamMemberId,
            @JsonProperty("description") String description,
            @JsonProperty("display_name") String displayName,
            @JsonProperty("is_bookable") Boolean isBookable,
            @JsonProperty("profile_image_url") String profileImageUrl) {
        this.teamMemberId = teamMemberId;
        this.description = description;
        this.displayName = displayName;
        this.isBookable = OptionalNullable.of(isBookable);
        this.profileImageUrl = profileImageUrl;
    }

    /**
     * Initialization constructor.
     * @param  teamMemberId  String value for teamMemberId.
     * @param  description  String value for description.
     * @param  displayName  String value for displayName.
     * @param  isBookable  Boolean value for isBookable.
     * @param  profileImageUrl  String value for profileImageUrl.
     */
    protected TeamMemberBookingProfile(
            String teamMemberId,
            String description,
            String displayName,
            OptionalNullable<Boolean> isBookable,
            String profileImageUrl) {
        this.teamMemberId = teamMemberId;
        this.description = description;
        this.displayName = displayName;
        this.isBookable = isBookable;
        this.profileImageUrl = profileImageUrl;
    }

    /**
     * Getter for TeamMemberId.
     * The ID of the [TeamMember](entity:TeamMember) object for the team member associated with the
     * booking profile.
     * @return Returns the String
     */
    @JsonGetter("team_member_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getTeamMemberId() {
        return teamMemberId;
    }

    /**
     * Getter for Description.
     * The description of the team member.
     * @return Returns the String
     */
    @JsonGetter("description")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDescription() {
        return description;
    }

    /**
     * Getter for DisplayName.
     * The display name of the team member.
     * @return Returns the String
     */
    @JsonGetter("display_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Internal Getter for IsBookable.
     * Indicates whether the team member can be booked through the Bookings API or the seller's
     * online booking channel or site (`true`) or not (`false`).
     * @return Returns the Internal Boolean
     */
    @JsonGetter("is_bookable")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetIsBookable() {
        return this.isBookable;
    }

    /**
     * Getter for IsBookable.
     * Indicates whether the team member can be booked through the Bookings API or the seller's
     * online booking channel or site (`true`) or not (`false`).
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getIsBookable() {
        return OptionalNullable.getFrom(isBookable);
    }

    /**
     * Getter for ProfileImageUrl.
     * The URL of the team member's image for the bookings profile.
     * @return Returns the String
     */
    @JsonGetter("profile_image_url")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamMemberId, description, displayName, isBookable, profileImageUrl);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TeamMemberBookingProfile)) {
            return false;
        }
        TeamMemberBookingProfile other = (TeamMemberBookingProfile) obj;
        return Objects.equals(teamMemberId, other.teamMemberId)
                && Objects.equals(description, other.description)
                && Objects.equals(displayName, other.displayName)
                && Objects.equals(isBookable, other.isBookable)
                && Objects.equals(profileImageUrl, other.profileImageUrl);
    }

    /**
     * Converts this TeamMemberBookingProfile into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "TeamMemberBookingProfile [" + "teamMemberId=" + teamMemberId + ", description="
                + description + ", displayName=" + displayName + ", isBookable=" + isBookable
                + ", profileImageUrl=" + profileImageUrl + "]";
    }

    /**
     * Builds a new {@link TeamMemberBookingProfile.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TeamMemberBookingProfile.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .teamMemberId(getTeamMemberId())
                .description(getDescription())
                .displayName(getDisplayName())
                .profileImageUrl(getProfileImageUrl());
        builder.isBookable = internalGetIsBookable();
        return builder;
    }

    /**
     * Class to build instances of {@link TeamMemberBookingProfile}.
     */
    public static class Builder {
        private String teamMemberId;
        private String description;
        private String displayName;
        private OptionalNullable<Boolean> isBookable;
        private String profileImageUrl;

        /**
         * Setter for teamMemberId.
         * @param  teamMemberId  String value for teamMemberId.
         * @return Builder
         */
        public Builder teamMemberId(String teamMemberId) {
            this.teamMemberId = teamMemberId;
            return this;
        }

        /**
         * Setter for description.
         * @param  description  String value for description.
         * @return Builder
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        /**
         * Setter for displayName.
         * @param  displayName  String value for displayName.
         * @return Builder
         */
        public Builder displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        /**
         * Setter for isBookable.
         * @param  isBookable  Boolean value for isBookable.
         * @return Builder
         */
        public Builder isBookable(Boolean isBookable) {
            this.isBookable = OptionalNullable.of(isBookable);
            return this;
        }

        /**
         * UnSetter for isBookable.
         * @return Builder
         */
        public Builder unsetIsBookable() {
            isBookable = null;
            return this;
        }

        /**
         * Setter for profileImageUrl.
         * @param  profileImageUrl  String value for profileImageUrl.
         * @return Builder
         */
        public Builder profileImageUrl(String profileImageUrl) {
            this.profileImageUrl = profileImageUrl;
            return this;
        }

        /**
         * Builds a new {@link TeamMemberBookingProfile} object using the set fields.
         * @return {@link TeamMemberBookingProfile}
         */
        public TeamMemberBookingProfile build() {
            return new TeamMemberBookingProfile(teamMemberId, description, displayName, isBookable, profileImageUrl);
        }
    }
}
