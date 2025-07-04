/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = UpdateScheduledShiftRequest.Builder.class)
public final class UpdateScheduledShiftRequest {
    private final String id;

    private final ScheduledShift scheduledShift;

    private final Map<String, Object> additionalProperties;

    private UpdateScheduledShiftRequest(
            String id, ScheduledShift scheduledShift, Map<String, Object> additionalProperties) {
        this.id = id;
        this.scheduledShift = scheduledShift;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The ID of the scheduled shift to update.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @return The scheduled shift with any updates in the <code>draft_shift_details</code> field.
     * If needed, call <a href="api-endpoint:Locations-ListLocations">ListLocations</a> to get location IDs,
     * <a href="api-endpoint:Team-ListJobs">ListJobs</a> to get job IDs, and <a href="api-endpoint:Team-SearchTeamMembers">SearchTeamMembers</a>
     * to get team member IDs and current job assignments. Updates made to <code>published_shift_details</code>
     * are ignored.
     * <p>If provided, the <code>start_at</code> and <code>end_at</code> timestamps must be in the time zone + offset of the
     * shift location specified in <code>location_id</code>. Example for Pacific Standard Time: 2024-10-31T12:30:00-08:00</p>
     * <p>To enable <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/optimistic-concurrency">optimistic concurrency</a>
     * control for the request, provide the current version of the shift in the <code>version</code> field.
     * If the provided version doesn't match the server version, the request fails. If <code>version</code> is
     * omitted, Square executes a blind write, potentially overwriting data from another publish request.</p>
     */
    @JsonProperty("scheduled_shift")
    public ScheduledShift getScheduledShift() {
        return scheduledShift;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpdateScheduledShiftRequest && equalTo((UpdateScheduledShiftRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(UpdateScheduledShiftRequest other) {
        return id.equals(other.id) && scheduledShift.equals(other.scheduledShift);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.id, this.scheduledShift);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        /**
         * <p>The ID of the scheduled shift to update.</p>
         */
        ScheduledShiftStage id(@NotNull String id);

        Builder from(UpdateScheduledShiftRequest other);
    }

    public interface ScheduledShiftStage {
        /**
         * <p>The scheduled shift with any updates in the <code>draft_shift_details</code> field.
         * If needed, call <a href="api-endpoint:Locations-ListLocations">ListLocations</a> to get location IDs,
         * <a href="api-endpoint:Team-ListJobs">ListJobs</a> to get job IDs, and <a href="api-endpoint:Team-SearchTeamMembers">SearchTeamMembers</a>
         * to get team member IDs and current job assignments. Updates made to <code>published_shift_details</code>
         * are ignored.</p>
         * <p>If provided, the <code>start_at</code> and <code>end_at</code> timestamps must be in the time zone + offset of the
         * shift location specified in <code>location_id</code>. Example for Pacific Standard Time: 2024-10-31T12:30:00-08:00</p>
         * <p>To enable <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/optimistic-concurrency">optimistic concurrency</a>
         * control for the request, provide the current version of the shift in the <code>version</code> field.
         * If the provided version doesn't match the server version, the request fails. If <code>version</code> is
         * omitted, Square executes a blind write, potentially overwriting data from another publish request.</p>
         */
        _FinalStage scheduledShift(@NotNull ScheduledShift scheduledShift);
    }

    public interface _FinalStage {
        UpdateScheduledShiftRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdStage, ScheduledShiftStage, _FinalStage {
        private String id;

        private ScheduledShift scheduledShift;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(UpdateScheduledShiftRequest other) {
            id(other.getId());
            scheduledShift(other.getScheduledShift());
            return this;
        }

        /**
         * <p>The ID of the scheduled shift to update.</p>
         * <p>The ID of the scheduled shift to update.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("id")
        public ScheduledShiftStage id(@NotNull String id) {
            this.id = Objects.requireNonNull(id, "id must not be null");
            return this;
        }

        /**
         * <p>The scheduled shift with any updates in the <code>draft_shift_details</code> field.
         * If needed, call <a href="api-endpoint:Locations-ListLocations">ListLocations</a> to get location IDs,
         * <a href="api-endpoint:Team-ListJobs">ListJobs</a> to get job IDs, and <a href="api-endpoint:Team-SearchTeamMembers">SearchTeamMembers</a>
         * to get team member IDs and current job assignments. Updates made to <code>published_shift_details</code>
         * are ignored.</p>
         * <p>If provided, the <code>start_at</code> and <code>end_at</code> timestamps must be in the time zone + offset of the
         * shift location specified in <code>location_id</code>. Example for Pacific Standard Time: 2024-10-31T12:30:00-08:00</p>
         * <p>To enable <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/optimistic-concurrency">optimistic concurrency</a>
         * control for the request, provide the current version of the shift in the <code>version</code> field.
         * If the provided version doesn't match the server version, the request fails. If <code>version</code> is
         * omitted, Square executes a blind write, potentially overwriting data from another publish request.</p>
         * <p>The scheduled shift with any updates in the <code>draft_shift_details</code> field.
         * If needed, call <a href="api-endpoint:Locations-ListLocations">ListLocations</a> to get location IDs,
         * <a href="api-endpoint:Team-ListJobs">ListJobs</a> to get job IDs, and <a href="api-endpoint:Team-SearchTeamMembers">SearchTeamMembers</a>
         * to get team member IDs and current job assignments. Updates made to <code>published_shift_details</code>
         * are ignored.</p>
         * <p>If provided, the <code>start_at</code> and <code>end_at</code> timestamps must be in the time zone + offset of the
         * shift location specified in <code>location_id</code>. Example for Pacific Standard Time: 2024-10-31T12:30:00-08:00</p>
         * <p>To enable <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/optimistic-concurrency">optimistic concurrency</a>
         * control for the request, provide the current version of the shift in the <code>version</code> field.
         * If the provided version doesn't match the server version, the request fails. If <code>version</code> is
         * omitted, Square executes a blind write, potentially overwriting data from another publish request.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("scheduled_shift")
        public _FinalStage scheduledShift(@NotNull ScheduledShift scheduledShift) {
            this.scheduledShift = Objects.requireNonNull(scheduledShift, "scheduledShift must not be null");
            return this;
        }

        @java.lang.Override
        public UpdateScheduledShiftRequest build() {
            return new UpdateScheduledShiftRequest(id, scheduledShift, additionalProperties);
        }
    }
}
