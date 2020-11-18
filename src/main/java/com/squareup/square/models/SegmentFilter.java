
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for SegmentFilter type.
 */
public class SegmentFilter {
    private final String serviceVariationId;
    private final FilterValue teamMemberIdFilter;

    /**
     * Initialization constructor.
     * @param serviceVariationId String value for serviceVariationId.
     * @param teamMemberIdFilter FilterValue value for teamMemberIdFilter.
     */
    @JsonCreator
    public SegmentFilter(
            @JsonProperty("service_variation_id") String serviceVariationId,
            @JsonProperty("team_member_id_filter") FilterValue teamMemberIdFilter) {
        this.serviceVariationId = serviceVariationId;
        this.teamMemberIdFilter = teamMemberIdFilter;
    }

    /**
     * Getter for ServiceVariationId.
     * The ID of the [CatalogItemVariation](#type-CatalogItemVariation) representing the service
     * booked in this segment.
     * @return Returns the String
     */
    @JsonGetter("service_variation_id")
    public String getServiceVariationId() {
        return this.serviceVariationId;
    }

    /**
     * Getter for TeamMemberIdFilter.
     * A filter to select resources based on an exact field value. For any given value, the value
     * can only be in one property. Depending on the field, either all properties can be set or only
     * a subset will be available. Refer to the documentation of the field.
     * @return Returns the FilterValue
     */
    @JsonGetter("team_member_id_filter")
    public FilterValue getTeamMemberIdFilter() {
        return this.teamMemberIdFilter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceVariationId, teamMemberIdFilter);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SegmentFilter)) {
            return false;
        }
        SegmentFilter other = (SegmentFilter) obj;
        return Objects.equals(serviceVariationId, other.serviceVariationId)
            && Objects.equals(teamMemberIdFilter, other.teamMemberIdFilter);
    }

    /**
     * Converts this SegmentFilter into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SegmentFilter [" + "serviceVariationId=" + serviceVariationId
                + ", teamMemberIdFilter=" + teamMemberIdFilter + "]";
    }

    /**
     * Builds a new {@link SegmentFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SegmentFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(serviceVariationId)
                .teamMemberIdFilter(getTeamMemberIdFilter());
        return builder;
    }

    /**
     * Class to build instances of {@link SegmentFilter}.
     */
    public static class Builder {
        private String serviceVariationId;
        private FilterValue teamMemberIdFilter;

        /**
         * Initialization constructor.
         * @param serviceVariationId String value for serviceVariationId.
         */
        public Builder(String serviceVariationId) {
            this.serviceVariationId = serviceVariationId;
        }

        /**
         * Setter for serviceVariationId.
         * @param serviceVariationId String value for serviceVariationId.
         * @return Builder
         */
        public Builder serviceVariationId(String serviceVariationId) {
            this.serviceVariationId = serviceVariationId;
            return this;
        }

        /**
         * Setter for teamMemberIdFilter.
         * @param teamMemberIdFilter FilterValue value for teamMemberIdFilter.
         * @return Builder
         */
        public Builder teamMemberIdFilter(FilterValue teamMemberIdFilter) {
            this.teamMemberIdFilter = teamMemberIdFilter;
            return this;
        }

        /**
         * Builds a new {@link SegmentFilter} object using the set fields.
         * @return {@link SegmentFilter}
         */
        public SegmentFilter build() {
            return new SegmentFilter(serviceVariationId, teamMemberIdFilter);
        }
    }
}
