
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for TeamMemberAssignedLocations type.
 */
public class TeamMemberAssignedLocations {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String assignmentType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> locationIds;

    /**
     * Initialization constructor.
     * @param  assignmentType  String value for assignmentType.
     * @param  locationIds  List of String value for locationIds.
     */
    @JsonCreator
    public TeamMemberAssignedLocations(
            @JsonProperty("assignment_type") String assignmentType,
            @JsonProperty("location_ids") List<String> locationIds) {
        this.assignmentType = assignmentType;
        this.locationIds = locationIds;
    }

    /**
     * Getter for AssignmentType.
     * Enumerates the possible assignment types that the team member can have.
     * @return Returns the String
     */
    @JsonGetter("assignment_type")
    public String getAssignmentType() {
        return assignmentType;
    }

    /**
     * Getter for LocationIds.
     * The locations that the team member is assigned to.
     * @return Returns the List of String
     */
    @JsonGetter("location_ids")
    public List<String> getLocationIds() {
        return locationIds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(assignmentType, locationIds);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TeamMemberAssignedLocations)) {
            return false;
        }
        TeamMemberAssignedLocations other = (TeamMemberAssignedLocations) obj;
        return Objects.equals(assignmentType, other.assignmentType)
            && Objects.equals(locationIds, other.locationIds);
    }

    /**
     * Converts this TeamMemberAssignedLocations into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "TeamMemberAssignedLocations [" + "assignmentType=" + assignmentType
                + ", locationIds=" + locationIds + "]";
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
     * Class to build instances of {@link TeamMemberAssignedLocations}.
     */
    public static class Builder {
        private String assignmentType;
        private List<String> locationIds;



        /**
         * Setter for assignmentType.
         * @param  assignmentType  String value for assignmentType.
         * @return Builder
         */
        public Builder assignmentType(String assignmentType) {
            this.assignmentType = assignmentType;
            return this;
        }

        /**
         * Setter for locationIds.
         * @param  locationIds  List of String value for locationIds.
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
            return new TeamMemberAssignedLocations(assignmentType, locationIds);
        }
    }
}
