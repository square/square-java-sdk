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
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CreateBookingRequest.Builder.class)
public final class CreateBookingRequest {
    private final Optional<String> idempotencyKey;

    private final Booking booking;

    private final Map<String, Object> additionalProperties;

    private CreateBookingRequest(
            Optional<String> idempotencyKey, Booking booking, Map<String, Object> additionalProperties) {
        this.idempotencyKey = idempotencyKey;
        this.booking = booking;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return A unique key to make this request an idempotent operation.
     */
    @JsonProperty("idempotency_key")
    public Optional<String> getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * @return The details of the booking to be created.
     */
    @JsonProperty("booking")
    public Booking getBooking() {
        return booking;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateBookingRequest && equalTo((CreateBookingRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CreateBookingRequest other) {
        return idempotencyKey.equals(other.idempotencyKey) && booking.equals(other.booking);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.idempotencyKey, this.booking);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static BookingStage builder() {
        return new Builder();
    }

    public interface BookingStage {
        /**
         * <p>The details of the booking to be created.</p>
         */
        _FinalStage booking(@NotNull Booking booking);

        Builder from(CreateBookingRequest other);
    }

    public interface _FinalStage {
        CreateBookingRequest build();

        /**
         * <p>A unique key to make this request an idempotent operation.</p>
         */
        _FinalStage idempotencyKey(Optional<String> idempotencyKey);

        _FinalStage idempotencyKey(String idempotencyKey);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements BookingStage, _FinalStage {
        private Booking booking;

        private Optional<String> idempotencyKey = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(CreateBookingRequest other) {
            idempotencyKey(other.getIdempotencyKey());
            booking(other.getBooking());
            return this;
        }

        /**
         * <p>The details of the booking to be created.</p>
         * <p>The details of the booking to be created.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("booking")
        public _FinalStage booking(@NotNull Booking booking) {
            this.booking = Objects.requireNonNull(booking, "booking must not be null");
            return this;
        }

        /**
         * <p>A unique key to make this request an idempotent operation.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = Optional.ofNullable(idempotencyKey);
            return this;
        }

        /**
         * <p>A unique key to make this request an idempotent operation.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "idempotency_key", nulls = Nulls.SKIP)
        public _FinalStage idempotencyKey(Optional<String> idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        @java.lang.Override
        public CreateBookingRequest build() {
            return new CreateBookingRequest(idempotencyKey, booking, additionalProperties);
        }
    }
}
