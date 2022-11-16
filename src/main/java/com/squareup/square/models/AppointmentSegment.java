
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for AppointmentSegment type.
 */
public class AppointmentSegment {
    private final OptionalNullable<Integer> durationMinutes;
    private final OptionalNullable<String> serviceVariationId;
    private final String teamMemberId;
    private final OptionalNullable<Long> serviceVariationVersion;
    private final Integer intermissionMinutes;
    private final Boolean anyTeamMember;
    private final List<String> resourceIds;

    /**
     * Initialization constructor.
     * @param  teamMemberId  String value for teamMemberId.
     * @param  durationMinutes  Integer value for durationMinutes.
     * @param  serviceVariationId  String value for serviceVariationId.
     * @param  serviceVariationVersion  Long value for serviceVariationVersion.
     * @param  intermissionMinutes  Integer value for intermissionMinutes.
     * @param  anyTeamMember  Boolean value for anyTeamMember.
     * @param  resourceIds  List of String value for resourceIds.
     */
    @JsonCreator
    public AppointmentSegment(
            @JsonProperty("team_member_id") String teamMemberId,
            @JsonProperty("duration_minutes") Integer durationMinutes,
            @JsonProperty("service_variation_id") String serviceVariationId,
            @JsonProperty("service_variation_version") Long serviceVariationVersion,
            @JsonProperty("intermission_minutes") Integer intermissionMinutes,
            @JsonProperty("any_team_member") Boolean anyTeamMember,
            @JsonProperty("resource_ids") List<String> resourceIds) {
        this.durationMinutes = OptionalNullable.of(durationMinutes);
        this.serviceVariationId = OptionalNullable.of(serviceVariationId);
        this.teamMemberId = teamMemberId;
        this.serviceVariationVersion = OptionalNullable.of(serviceVariationVersion);
        this.intermissionMinutes = intermissionMinutes;
        this.anyTeamMember = anyTeamMember;
        this.resourceIds = resourceIds;
    }

    /**
     * Internal initialization constructor.
     */
    protected AppointmentSegment(String teamMemberId, OptionalNullable<Integer> durationMinutes,
            OptionalNullable<String> serviceVariationId,
            OptionalNullable<Long> serviceVariationVersion, Integer intermissionMinutes,
            Boolean anyTeamMember, List<String> resourceIds) {
        this.durationMinutes = durationMinutes;
        this.serviceVariationId = serviceVariationId;
        this.teamMemberId = teamMemberId;
        this.serviceVariationVersion = serviceVariationVersion;
        this.intermissionMinutes = intermissionMinutes;
        this.anyTeamMember = anyTeamMember;
        this.resourceIds = resourceIds;
    }

    /**
     * Internal Getter for DurationMinutes.
     * The time span in minutes of an appointment segment.
     * @return Returns the Internal Integer
     */
    @JsonGetter("duration_minutes")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetDurationMinutes() {
        return this.durationMinutes;
    }

    /**
     * Getter for DurationMinutes.
     * The time span in minutes of an appointment segment.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getDurationMinutes() {
        return OptionalNullable.getFrom(durationMinutes);
    }

    /**
     * Internal Getter for ServiceVariationId.
     * The ID of the [CatalogItemVariation]($m/CatalogItemVariation) object representing the service
     * booked in this segment.
     * @return Returns the Internal String
     */
    @JsonGetter("service_variation_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetServiceVariationId() {
        return this.serviceVariationId;
    }

    /**
     * Getter for ServiceVariationId.
     * The ID of the [CatalogItemVariation]($m/CatalogItemVariation) object representing the service
     * booked in this segment.
     * @return Returns the String
     */
    @JsonIgnore
    public String getServiceVariationId() {
        return OptionalNullable.getFrom(serviceVariationId);
    }

    /**
     * Getter for TeamMemberId.
     * The ID of the [TeamMember]($m/TeamMember) object representing the team member booked in this
     * segment.
     * @return Returns the String
     */
    @JsonGetter("team_member_id")
    public String getTeamMemberId() {
        return teamMemberId;
    }

    /**
     * Internal Getter for ServiceVariationVersion.
     * The current version of the item variation representing the service booked in this segment.
     * @return Returns the Internal Long
     */
    @JsonGetter("service_variation_version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Long> internalGetServiceVariationVersion() {
        return this.serviceVariationVersion;
    }

    /**
     * Getter for ServiceVariationVersion.
     * The current version of the item variation representing the service booked in this segment.
     * @return Returns the Long
     */
    @JsonIgnore
    public Long getServiceVariationVersion() {
        return OptionalNullable.getFrom(serviceVariationVersion);
    }

    /**
     * Getter for IntermissionMinutes.
     * Time between the end of this segment and the beginning of the subsequent segment.
     * @return Returns the Integer
     */
    @JsonGetter("intermission_minutes")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getIntermissionMinutes() {
        return intermissionMinutes;
    }

    /**
     * Getter for AnyTeamMember.
     * Whether the customer accepts any team member, instead of a specific one, to serve this
     * segment.
     * @return Returns the Boolean
     */
    @JsonGetter("any_team_member")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getAnyTeamMember() {
        return anyTeamMember;
    }

    /**
     * Getter for ResourceIds.
     * The IDs of the seller-accessible resources used for this appointment segment.
     * @return Returns the List of String
     */
    @JsonGetter("resource_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<String> getResourceIds() {
        return resourceIds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(durationMinutes, serviceVariationId, teamMemberId,
                serviceVariationVersion, intermissionMinutes, anyTeamMember, resourceIds);
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
            && Objects.equals(serviceVariationVersion, other.serviceVariationVersion)
            && Objects.equals(intermissionMinutes, other.intermissionMinutes)
            && Objects.equals(anyTeamMember, other.anyTeamMember)
            && Objects.equals(resourceIds, other.resourceIds);
    }

    /**
     * Converts this AppointmentSegment into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "AppointmentSegment [" + "teamMemberId=" + teamMemberId + ", durationMinutes="
                + durationMinutes + ", serviceVariationId=" + serviceVariationId
                + ", serviceVariationVersion=" + serviceVariationVersion + ", intermissionMinutes="
                + intermissionMinutes + ", anyTeamMember=" + anyTeamMember + ", resourceIds="
                + resourceIds + "]";
    }

    /**
     * Builds a new {@link AppointmentSegment.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link AppointmentSegment.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(teamMemberId)
                .intermissionMinutes(getIntermissionMinutes())
                .anyTeamMember(getAnyTeamMember())
                .resourceIds(getResourceIds());
        builder.durationMinutes = internalGetDurationMinutes();
        builder.serviceVariationId = internalGetServiceVariationId();
        builder.serviceVariationVersion = internalGetServiceVariationVersion();
        return builder;
    }

    /**
     * Class to build instances of {@link AppointmentSegment}.
     */
    public static class Builder {
        private String teamMemberId;
        private OptionalNullable<Integer> durationMinutes;
        private OptionalNullable<String> serviceVariationId;
        private OptionalNullable<Long> serviceVariationVersion;
        private Integer intermissionMinutes;
        private Boolean anyTeamMember;
        private List<String> resourceIds;

        /**
         * Initialization constructor.
         * @param  teamMemberId  String value for teamMemberId.
         */
        public Builder(String teamMemberId) {
            this.teamMemberId = teamMemberId;
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
         * Setter for durationMinutes.
         * @param  durationMinutes  Integer value for durationMinutes.
         * @return Builder
         */
        public Builder durationMinutes(Integer durationMinutes) {
            this.durationMinutes = OptionalNullable.of(durationMinutes);
            return this;
        }

        /**
         * UnSetter for durationMinutes.
         * @return Builder
         */
        public Builder unsetDurationMinutes() {
            durationMinutes = null;
            return this;
        }

        /**
         * Setter for serviceVariationId.
         * @param  serviceVariationId  String value for serviceVariationId.
         * @return Builder
         */
        public Builder serviceVariationId(String serviceVariationId) {
            this.serviceVariationId = OptionalNullable.of(serviceVariationId);
            return this;
        }

        /**
         * UnSetter for serviceVariationId.
         * @return Builder
         */
        public Builder unsetServiceVariationId() {
            serviceVariationId = null;
            return this;
        }

        /**
         * Setter for serviceVariationVersion.
         * @param  serviceVariationVersion  Long value for serviceVariationVersion.
         * @return Builder
         */
        public Builder serviceVariationVersion(Long serviceVariationVersion) {
            this.serviceVariationVersion = OptionalNullable.of(serviceVariationVersion);
            return this;
        }

        /**
         * UnSetter for serviceVariationVersion.
         * @return Builder
         */
        public Builder unsetServiceVariationVersion() {
            serviceVariationVersion = null;
            return this;
        }

        /**
         * Setter for intermissionMinutes.
         * @param  intermissionMinutes  Integer value for intermissionMinutes.
         * @return Builder
         */
        public Builder intermissionMinutes(Integer intermissionMinutes) {
            this.intermissionMinutes = intermissionMinutes;
            return this;
        }

        /**
         * Setter for anyTeamMember.
         * @param  anyTeamMember  Boolean value for anyTeamMember.
         * @return Builder
         */
        public Builder anyTeamMember(Boolean anyTeamMember) {
            this.anyTeamMember = anyTeamMember;
            return this;
        }

        /**
         * Setter for resourceIds.
         * @param  resourceIds  List of String value for resourceIds.
         * @return Builder
         */
        public Builder resourceIds(List<String> resourceIds) {
            this.resourceIds = resourceIds;
            return this;
        }

        /**
         * Builds a new {@link AppointmentSegment} object using the set fields.
         * @return {@link AppointmentSegment}
         */
        public AppointmentSegment build() {
            return new AppointmentSegment(teamMemberId, durationMinutes, serviceVariationId,
                    serviceVariationVersion, intermissionMinutes, anyTeamMember, resourceIds);
        }
    }
}
