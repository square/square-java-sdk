
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for AppointmentSegment type.
 */
public class AppointmentSegment {
    private final int durationMinutes;
    private final String serviceVariationId;
    private final String teamMemberId;
    private final long serviceVariationVersion;

    /**
     * Initialization constructor.
     * @param  durationMinutes  int value for durationMinutes.
     * @param  serviceVariationId  String value for serviceVariationId.
     * @param  teamMemberId  String value for teamMemberId.
     * @param  serviceVariationVersion  long value for serviceVariationVersion.
     */
    @JsonCreator
    public AppointmentSegment(
            @JsonProperty("duration_minutes") int durationMinutes,
            @JsonProperty("service_variation_id") String serviceVariationId,
            @JsonProperty("team_member_id") String teamMemberId,
            @JsonProperty("service_variation_version") long serviceVariationVersion) {
        this.durationMinutes = durationMinutes;
        this.serviceVariationId = serviceVariationId;
        this.teamMemberId = teamMemberId;
        this.serviceVariationVersion = serviceVariationVersion;
    }

    /**
     * Getter for DurationMinutes.
     * The time span in minutes of an appointment segment.
     * @return Returns the int
     */
    @JsonGetter("duration_minutes")
    public int getDurationMinutes() {
        return durationMinutes;
    }

    /**
     * Getter for ServiceVariationId.
     * The ID of the [CatalogItemVariation](#type-CatalogItemVariation) object representing the
     * service booked in this segment.
     * @return Returns the String
     */
    @JsonGetter("service_variation_id")
    public String getServiceVariationId() {
        return serviceVariationId;
    }

    /**
     * Getter for TeamMemberId.
     * The ID of the [TeamMember](#type-TeamMember) object representing the team member booked in
     * this segment.
     * @return Returns the String
     */
    @JsonGetter("team_member_id")
    public String getTeamMemberId() {
        return teamMemberId;
    }

    /**
     * Getter for ServiceVariationVersion.
     * The current version of the item variation representing the service booked in this segment.
     * @return Returns the long
     */
    @JsonGetter("service_variation_version")
    public long getServiceVariationVersion() {
        return serviceVariationVersion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(durationMinutes, serviceVariationId, teamMemberId,
                serviceVariationVersion);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AppointmentSegment)) {
            return false;
        }
        AppointmentSegment other = (AppointmentSegment) obj;
        return Objects.equals(durationMinutes, other.durationMinutes)
            && Objects.equals(serviceVariationId, other.serviceVariationId)
            && Objects.equals(teamMemberId, other.teamMemberId)
            && Objects.equals(serviceVariationVersion, other.serviceVariationVersion);
    }

    /**
     * Converts this AppointmentSegment into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "AppointmentSegment [" + "durationMinutes=" + durationMinutes
                + ", serviceVariationId=" + serviceVariationId + ", teamMemberId=" + teamMemberId
                + ", serviceVariationVersion=" + serviceVariationVersion + "]";
    }

    /**
     * Builds a new {@link AppointmentSegment.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link AppointmentSegment.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(durationMinutes, serviceVariationId, teamMemberId,
                serviceVariationVersion);
        return builder;
    }

    /**
     * Class to build instances of {@link AppointmentSegment}.
     */
    public static class Builder {
        private int durationMinutes;
        private String serviceVariationId;
        private String teamMemberId;
        private long serviceVariationVersion;

        /**
         * Initialization constructor.
         * @param  durationMinutes  int value for durationMinutes.
         * @param  serviceVariationId  String value for serviceVariationId.
         * @param  teamMemberId  String value for teamMemberId.
         * @param  serviceVariationVersion  long value for serviceVariationVersion.
         */
        public Builder(int durationMinutes, String serviceVariationId, String teamMemberId,
                long serviceVariationVersion) {
            this.durationMinutes = durationMinutes;
            this.serviceVariationId = serviceVariationId;
            this.teamMemberId = teamMemberId;
            this.serviceVariationVersion = serviceVariationVersion;
        }

        /**
         * Setter for durationMinutes.
         * @param  durationMinutes  int value for durationMinutes.
         * @return Builder
         */
        public Builder durationMinutes(int durationMinutes) {
            this.durationMinutes = durationMinutes;
            return this;
        }

        /**
         * Setter for serviceVariationId.
         * @param  serviceVariationId  String value for serviceVariationId.
         * @return Builder
         */
        public Builder serviceVariationId(String serviceVariationId) {
            this.serviceVariationId = serviceVariationId;
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
         * Setter for serviceVariationVersion.
         * @param  serviceVariationVersion  long value for serviceVariationVersion.
         * @return Builder
         */
        public Builder serviceVariationVersion(long serviceVariationVersion) {
            this.serviceVariationVersion = serviceVariationVersion;
            return this;
        }

        /**
         * Builds a new {@link AppointmentSegment} object using the set fields.
         * @return {@link AppointmentSegment}
         */
        public AppointmentSegment build() {
            return new AppointmentSegment(durationMinutes, serviceVariationId, teamMemberId,
                    serviceVariationVersion);
        }
    }
}
