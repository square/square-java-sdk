package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for SearchTeamMembersFilter type.
 */
public class SearchTeamMembersFilter {
    private final OptionalNullable<List<String>> locationIds;
    private final String status;
    private final OptionalNullable<Boolean> isOwner;

    /**
     * Initialization constructor.
     * @param  locationIds  List of String value for locationIds.
     * @param  status  String value for status.
     * @param  isOwner  Boolean value for isOwner.
     */
    @JsonCreator
    public SearchTeamMembersFilter(
            @JsonProperty("location_ids") List<String> locationIds,
            @JsonProperty("status") String status,
            @JsonProperty("is_owner") Boolean isOwner) {
        this.locationIds = OptionalNullable.of(locationIds);
        this.status = status;
        this.isOwner = OptionalNullable.of(isOwner);
    }

    /**
     * Initialization constructor.
     * @param  locationIds  List of String value for locationIds.
     * @param  status  String value for status.
     * @param  isOwner  Boolean value for isOwner.
     */
    protected SearchTeamMembersFilter(
            OptionalNullable<List<String>> locationIds, String status, OptionalNullable<Boolean> isOwner) {
        this.locationIds = locationIds;
        this.status = status;
        this.isOwner = isOwner;
    }

    /**
     * Internal Getter for LocationIds.
     * When present, filters by team members assigned to the specified locations. When empty,
     * includes team members assigned to any location.
     * @return Returns the Internal List of String
     */
    @JsonGetter("location_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetLocationIds() {
        return this.locationIds;
    }

    /**
     * Getter for LocationIds.
     * When present, filters by team members assigned to the specified locations. When empty,
     * includes team members assigned to any location.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getLocationIds() {
        return OptionalNullable.getFrom(locationIds);
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
     * Internal Getter for IsOwner.
     * When present and set to true, returns the team member who is the owner of the Square account.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("is_owner")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetIsOwner() {
        return this.isOwner;
    }

    /**
     * Getter for IsOwner.
     * When present and set to true, returns the team member who is the owner of the Square account.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getIsOwner() {
        return OptionalNullable.getFrom(isOwner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationIds, status, isOwner);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchTeamMembersFilter)) {
            return false;
        }
        SearchTeamMembersFilter other = (SearchTeamMembersFilter) obj;
        return Objects.equals(locationIds, other.locationIds)
                && Objects.equals(status, other.status)
                && Objects.equals(isOwner, other.isOwner);
    }

    /**
     * Converts this SearchTeamMembersFilter into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchTeamMembersFilter [" + "locationIds=" + locationIds + ", status=" + status + ", isOwner="
                + isOwner + "]";
    }

    /**
     * Builds a new {@link SearchTeamMembersFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchTeamMembersFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().status(getStatus());
        builder.locationIds = internalGetLocationIds();
        builder.isOwner = internalGetIsOwner();
        return builder;
    }

    /**
     * Class to build instances of {@link SearchTeamMembersFilter}.
     */
    public static class Builder {
        private OptionalNullable<List<String>> locationIds;
        private String status;
        private OptionalNullable<Boolean> isOwner;

        /**
         * Setter for locationIds.
         * @param  locationIds  List of String value for locationIds.
         * @return Builder
         */
        public Builder locationIds(List<String> locationIds) {
            this.locationIds = OptionalNullable.of(locationIds);
            return this;
        }

        /**
         * UnSetter for locationIds.
         * @return Builder
         */
        public Builder unsetLocationIds() {
            locationIds = null;
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
         * Setter for isOwner.
         * @param  isOwner  Boolean value for isOwner.
         * @return Builder
         */
        public Builder isOwner(Boolean isOwner) {
            this.isOwner = OptionalNullable.of(isOwner);
            return this;
        }

        /**
         * UnSetter for isOwner.
         * @return Builder
         */
        public Builder unsetIsOwner() {
            isOwner = null;
            return this;
        }

        /**
         * Builds a new {@link SearchTeamMembersFilter} object using the set fields.
         * @return {@link SearchTeamMembersFilter}
         */
        public SearchTeamMembersFilter build() {
            return new SearchTeamMembersFilter(locationIds, status, isOwner);
        }
    }
}
