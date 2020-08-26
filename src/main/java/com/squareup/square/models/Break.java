package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for Break type.
 */
public class Break {

    /**
     * Initialization constructor.
     * @param startAt
     * @param breakTypeId
     * @param name
     * @param expectedDuration
     * @param isPaid
     * @param id
     * @param endAt
     */
    @JsonCreator
    public Break(
            @JsonProperty("start_at") String startAt,
            @JsonProperty("break_type_id") String breakTypeId,
            @JsonProperty("name") String name,
            @JsonProperty("expected_duration") String expectedDuration,
            @JsonProperty("is_paid") boolean isPaid,
            @JsonProperty("id") String id,
            @JsonProperty("end_at") String endAt) {
        this.id = id;
        this.startAt = startAt;
        this.endAt = endAt;
        this.breakTypeId = breakTypeId;
        this.name = name;
        this.expectedDuration = expectedDuration;
        this.isPaid = isPaid;
    }

    private final String id;
    private final String startAt;
    private final String endAt;
    private final String breakTypeId;
    private final String name;
    private final String expectedDuration;
    private final boolean isPaid;
    /**
     * Getter for Id.
     * UUID for this object
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for StartAt.
     * RFC 3339; follows same timezone info as `Shift`. Precision up to
     * the minute is respected; seconds are truncated.
     */
    @JsonGetter("start_at")
    public String getStartAt() {
        return this.startAt;
    }

    /**
     * Getter for EndAt.
     * RFC 3339; follows same timezone info as `Shift`. Precision up to
     * the minute is respected; seconds are truncated.
     */
    @JsonGetter("end_at")
    public String getEndAt() {
        return this.endAt;
    }

    /**
     * Getter for BreakTypeId.
     * The `BreakType` this `Break` was templated on.
     */
    @JsonGetter("break_type_id")
    public String getBreakTypeId() {
        return this.breakTypeId;
    }

    /**
     * Getter for Name.
     * A human-readable name.
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for ExpectedDuration.
     * Format: RFC-3339 P[n]Y[n]M[n]DT[n]H[n]M[n]S. The expected length of
     * the break.
     */
    @JsonGetter("expected_duration")
    public String getExpectedDuration() {
        return this.expectedDuration;
    }

    /**
     * Getter for IsPaid.
     * Whether this break counts towards time worked for compensation
     * purposes.
     */
    @JsonGetter("is_paid")
    public boolean getIsPaid() {
        return this.isPaid;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, startAt, endAt, breakTypeId, name, expectedDuration, isPaid);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof Break)) {
            return false;
        }
        Break mBreak = (Break) obj;
        return Objects.equals(id, mBreak.id) &&
            Objects.equals(startAt, mBreak.startAt) &&
            Objects.equals(endAt, mBreak.endAt) &&
            Objects.equals(breakTypeId, mBreak.breakTypeId) &&
            Objects.equals(name, mBreak.name) &&
            Objects.equals(expectedDuration, mBreak.expectedDuration) &&
            Objects.equals(isPaid, mBreak.isPaid);
    }

    /**
     * Builds a new {@link Break.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Break.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(startAt,
            breakTypeId,
            name,
            expectedDuration,
            isPaid)
            .id(getId())
            .endAt(getEndAt());
            return builder;
    }

    /**
     * Class to build instances of {@link Break}
     */
    public static class Builder {
        private String startAt;
        private String breakTypeId;
        private String name;
        private String expectedDuration;
        private boolean isPaid;
        private String id;
        private String endAt;

        /**
         * Initialization constructor
         */
        public Builder(String startAt,
                String breakTypeId,
                String name,
                String expectedDuration,
                boolean isPaid) {
            this.startAt = startAt;
            this.breakTypeId = breakTypeId;
            this.name = name;
            this.expectedDuration = expectedDuration;
            this.isPaid = isPaid;
        }

        /**
         * Setter for startAt
         * @param startAt
         * @return Builder
         */
        public Builder startAt(String startAt) {
            this.startAt = startAt;
            return this;
        }
        /**
         * Setter for breakTypeId
         * @param breakTypeId
         * @return Builder
         */
        public Builder breakTypeId(String breakTypeId) {
            this.breakTypeId = breakTypeId;
            return this;
        }
        /**
         * Setter for name
         * @param name
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        /**
         * Setter for expectedDuration
         * @param expectedDuration
         * @return Builder
         */
        public Builder expectedDuration(String expectedDuration) {
            this.expectedDuration = expectedDuration;
            return this;
        }
        /**
         * Setter for isPaid
         * @param isPaid
         * @return Builder
         */
        public Builder isPaid(boolean isPaid) {
            this.isPaid = isPaid;
            return this;
        }
        /**
         * Setter for id
         * @param id
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }
        /**
         * Setter for endAt
         * @param endAt
         * @return Builder
         */
        public Builder endAt(String endAt) {
            this.endAt = endAt;
            return this;
        }

        /**
         * Builds a new {@link Break} object using the set fields.
         * @return {@link Break}
         */
        public Break build() {
            return new Break(startAt,
                breakTypeId,
                name,
                expectedDuration,
                isPaid,
                id,
                endAt);
        }
    }
}
