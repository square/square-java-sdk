/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.customers.types;

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
@JsonDeserialize(builder = GetSegmentsRequest.Builder.class)
public final class GetSegmentsRequest {
    private final String segmentId;

    private final Map<String, Object> additionalProperties;

    private GetSegmentsRequest(String segmentId, Map<String, Object> additionalProperties) {
        this.segmentId = segmentId;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The Square-issued ID of the customer segment.
     */
    @JsonProperty("segment_id")
    public String getSegmentId() {
        return segmentId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetSegmentsRequest && equalTo((GetSegmentsRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(GetSegmentsRequest other) {
        return segmentId.equals(other.segmentId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.segmentId);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static SegmentIdStage builder() {
        return new Builder();
    }

    public interface SegmentIdStage {
        /**
         * <p>The Square-issued ID of the customer segment.</p>
         */
        _FinalStage segmentId(@NotNull String segmentId);

        Builder from(GetSegmentsRequest other);
    }

    public interface _FinalStage {
        GetSegmentsRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements SegmentIdStage, _FinalStage {
        private String segmentId;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(GetSegmentsRequest other) {
            segmentId(other.getSegmentId());
            return this;
        }

        /**
         * <p>The Square-issued ID of the customer segment.</p>
         * <p>The Square-issued ID of the customer segment.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("segment_id")
        public _FinalStage segmentId(@NotNull String segmentId) {
            this.segmentId = Objects.requireNonNull(segmentId, "segmentId must not be null");
            return this;
        }

        @java.lang.Override
        public GetSegmentsRequest build() {
            return new GetSegmentsRequest(segmentId, additionalProperties);
        }
    }
}
