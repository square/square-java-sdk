package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class Break {

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

    @Override
    public int hashCode() {
        return Objects.hash(startAt, breakTypeId, name, expectedDuration, isPaid, id, endAt);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Break)) {
            return false;
        }
        Break breakObj = (Break) o;
        return Objects.equals(startAt, breakObj.startAt) &&
            Objects.equals(breakTypeId, breakObj.breakTypeId) &&
            Objects.equals(name, breakObj.name) &&
            Objects.equals(expectedDuration, breakObj.expectedDuration) &&
            Objects.equals(isPaid, breakObj.isPaid) &&
            Objects.equals(id, breakObj.id) &&
            Objects.equals(endAt, breakObj.endAt);
    }

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
     * the minute is respected; seconds are truncated. The `end_at` minute is not
     * counted when the break length is calculated. For example, a break from `00:00`
     * to `00:11`  is considered a 10 minute break (midnight to 10 minutes after midnight).
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

    public static class Builder {
        private String startAt;
        private String breakTypeId;
        private String name;
        private String expectedDuration;
        private boolean isPaid;
        private String id;
        private String endAt;

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

        public Builder startAt(String value) {
            startAt = value;
            return this;
        }
        public Builder breakTypeId(String value) {
            breakTypeId = value;
            return this;
        }
        public Builder name(String value) {
            name = value;
            return this;
        }
        public Builder expectedDuration(String value) {
            expectedDuration = value;
            return this;
        }
        public Builder isPaid(boolean value) {
            isPaid = value;
            return this;
        }
        public Builder id(String value) {
            id = value;
            return this;
        }
        public Builder endAt(String value) {
            endAt = value;
            return this;
        }

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
