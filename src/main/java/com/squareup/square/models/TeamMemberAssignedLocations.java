package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for TeamMemberAssignedLocations type.
 */
public class TeamMemberAssignedLocations {

    /**
     * Initialization constructor.
     * @param assignmentType
     * @param locationIds
     */
    @JsonCreator
    public TeamMemberAssignedLocations(
            @JsonProperty("assignment_type") String assignmentType,
            @JsonProperty("location_ids") List<String> locationIds) {
        this.assignmentType = assignmentType;
        this.locationIds = locationIds;
    }

    private final String assignmentType;
    private final List<String> locationIds;
    /**
     * Getter for AssignmentType.
     * Enumerates the possible assignment types the team member can have
     */
    @JsonGetter("assignment_type")
    public String getAssignmentType() {
        return this.assignmentType;
    }

    /**
     * Getter for LocationIds.
     * The locations that the team member is assigned to.
     */
    @JsonGetter("location_ids")
    public List<String> getLocationIds() {
        return this.locationIds;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(assignmentType, locationIds);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof TeamMemberAssignedLocations)) {
            return false;
        }
        TeamMemberAssignedLocations teamMemberAssignedLocations = (TeamMemberAssignedLocations) obj;
        return Objects.equals(assignmentType, teamMemberAssignedLocations.assignmentType) &&
            Objects.equals(locationIds, teamMemberAssignedLocations.locationIds);
    }

    /**
     * Builds a new {@link TeamMemberAssignedLocations.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TeamMemberAssignedLocations.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .assignmentType(getAssignmentType())
            .locationIds(getLocationIds());
            return builder;
    }

    /**
     * Class to build instances of {@link TeamMemberAssignedLocations}
     */
    public static class Builder {
        private String assignmentType;
        private List<String> locationIds;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for assignmentType
         * @param assignmentType
         * @return Builder
         */
        public Builder assignmentType(String assignmentType) {
            this.assignmentType = assignmentType;
            return this;
        }
        /**
         * Setter for locationIds
         * @param locationIds
         * @return Builder
         */
        public Builder locationIds(List<String> locationIds) {
            this.locationIds = locationIds;
            return this;
        }

        /**
         * Builds a new {@link TeamMemberAssignedLocations} object using the set fields.
         * @return {@link TeamMemberAssignedLocations}
         */
        public TeamMemberAssignedLocations build() {
            return new TeamMemberAssignedLocations(assignmentType,
                locationIds);
        }
    }
}
