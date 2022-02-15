
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for BookingCreatorDetails type.
 */
public class BookingCreatorDetails {
    private final String creatorType;
    private final String teamMemberId;
    private final String customerId;

    /**
     * Initialization constructor.
     * @param  creatorType  String value for creatorType.
     * @param  teamMemberId  String value for teamMemberId.
     * @param  customerId  String value for customerId.
     */
    @JsonCreator
    public BookingCreatorDetails(
            @JsonProperty("creator_type") String creatorType,
            @JsonProperty("team_member_id") String teamMemberId,
            @JsonProperty("customer_id") String customerId) {
        this.creatorType = creatorType;
        this.teamMemberId = teamMemberId;
        this.customerId = customerId;
    }

    /**
     * Getter for CreatorType.
     * Supported types of a booking creator.
     * @return Returns the String
     */
    @JsonGetter("creator_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatorType() {
        return creatorType;
    }

    /**
     * Getter for TeamMemberId.
     * The ID of the team member who created the booking, when the booking creator is of the
     * `TEAM_MEMBER` type. Access to this field requires seller-level permissions.
     * @return Returns the String
     */
    @JsonGetter("team_member_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getTeamMemberId() {
        return teamMemberId;
    }

    /**
     * Getter for CustomerId.
     * The ID of the customer who created the booking, when the booking creator is of the `CUSTOMER`
     * type. Access to this field requires seller-level permissions.
     * @return Returns the String
     */
    @JsonGetter("customer_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCustomerId() {
        return customerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(creatorType, teamMemberId, customerId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BookingCreatorDetails)) {
            return false;
        }
        BookingCreatorDetails other = (BookingCreatorDetails) obj;
        return Objects.equals(creatorType, other.creatorType)
            && Objects.equals(teamMemberId, other.teamMemberId)
            && Objects.equals(customerId, other.customerId);
    }

    /**
     * Converts this BookingCreatorDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BookingCreatorDetails [" + "creatorType=" + creatorType + ", teamMemberId="
                + teamMemberId + ", customerId=" + customerId + "]";
    }

    /**
     * Builds a new {@link BookingCreatorDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BookingCreatorDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .creatorType(getCreatorType())
                .teamMemberId(getTeamMemberId())
                .customerId(getCustomerId());
        return builder;
    }

    /**
     * Class to build instances of {@link BookingCreatorDetails}.
     */
    public static class Builder {
        private String creatorType;
        private String teamMemberId;
        private String customerId;



        /**
         * Setter for creatorType.
         * @param  creatorType  String value for creatorType.
         * @return Builder
         */
        public Builder creatorType(String creatorType) {
            this.creatorType = creatorType;
            return this;
        }

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
         * Setter for customerId.
         * @param  customerId  String value for customerId.
         * @return Builder
         */
        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        /**
         * Builds a new {@link BookingCreatorDetails} object using the set fields.
         * @return {@link BookingCreatorDetails}
         */
        public BookingCreatorDetails build() {
            return new BookingCreatorDetails(creatorType, teamMemberId, customerId);
        }
    }
}
