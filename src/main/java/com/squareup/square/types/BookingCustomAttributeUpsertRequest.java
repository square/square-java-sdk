/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.Nullable;
import com.squareup.square.core.NullableNonemptyFilter;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = BookingCustomAttributeUpsertRequest.Builder.class)
public final class BookingCustomAttributeUpsertRequest {
    private final String bookingId;

    private final CustomAttribute customAttribute;

    private final Optional<String> idempotencyKey;

    private final Map<String, Object> additionalProperties;

    private BookingCustomAttributeUpsertRequest(
            String bookingId,
            CustomAttribute customAttribute,
            Optional<String> idempotencyKey,
            Map<String, Object> additionalProperties) {
        this.bookingId = bookingId;
        this.customAttribute = customAttribute;
        this.idempotencyKey = idempotencyKey;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The ID of the target <a href="entity:Booking">booking</a>.
     */
    @JsonProperty("booking_id")
    public String getBookingId() {
        return bookingId;
    }

    /**
     * @return The custom attribute to create or update, with following fields:
     * <ul>
     * <li>
     * <p><code>key</code>. This key must match the <code>key</code> of a custom attribute definition in the Square seller
     * account. If the requesting application is not the definition owner, you must provide the qualified key.</p>
     * </li>
     * <li>
     * <p><code>value</code>. This value must conform to the <code>schema</code> specified by the definition.
     * For more information, see <a href="https://developer.squareup.com/docs/booking-custom-attributes-api/custom-attributes#value-data-types">Value data types</a>.</p>
     * </li>
     * <li>
     * <p><code>version</code>. To enable <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/optimistic-concurrency">optimistic concurrency</a>
     * control for update operations, include this optional field in the request and set the
     * value to the current version of the custom attribute.</p>
     * </li>
     * </ul>
     */
    @JsonProperty("custom_attribute")
    public CustomAttribute getCustomAttribute() {
        return customAttribute;
    }

    /**
     * @return A unique identifier for this individual upsert request, used to ensure idempotency.
     * For more information, see <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency">Idempotency</a>.
     */
    @JsonIgnore
    public Optional<String> getIdempotencyKey() {
        if (idempotencyKey == null) {
            return Optional.empty();
        }
        return idempotencyKey;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("idempotency_key")
    private Optional<String> _getIdempotencyKey() {
        return idempotencyKey;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof BookingCustomAttributeUpsertRequest
                && equalTo((BookingCustomAttributeUpsertRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(BookingCustomAttributeUpsertRequest other) {
        return bookingId.equals(other.bookingId)
                && customAttribute.equals(other.customAttribute)
                && idempotencyKey.equals(other.idempotencyKey);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.bookingId, this.customAttribute, this.idempotencyKey);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static BookingIdStage builder() {
        return new Builder();
    }

    public interface BookingIdStage {
        CustomAttributeStage bookingId(@NotNull String bookingId);

        Builder from(BookingCustomAttributeUpsertRequest other);
    }

    public interface CustomAttributeStage {
        _FinalStage customAttribute(@NotNull CustomAttribute customAttribute);
    }

    public interface _FinalStage {
        BookingCustomAttributeUpsertRequest build();

        _FinalStage idempotencyKey(Optional<String> idempotencyKey);

        _FinalStage idempotencyKey(String idempotencyKey);

        _FinalStage idempotencyKey(Nullable<String> idempotencyKey);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements BookingIdStage, CustomAttributeStage, _FinalStage {
        private String bookingId;

        private CustomAttribute customAttribute;

        private Optional<String> idempotencyKey = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(BookingCustomAttributeUpsertRequest other) {
            bookingId(other.getBookingId());
            customAttribute(other.getCustomAttribute());
            idempotencyKey(other.getIdempotencyKey());
            return this;
        }

        /**
         * <p>The ID of the target <a href="entity:Booking">booking</a>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("booking_id")
        public CustomAttributeStage bookingId(@NotNull String bookingId) {
            this.bookingId = Objects.requireNonNull(bookingId, "bookingId must not be null");
            return this;
        }

        /**
         * <p>The custom attribute to create or update, with following fields:</p>
         * <ul>
         * <li>
         * <p><code>key</code>. This key must match the <code>key</code> of a custom attribute definition in the Square seller
         * account. If the requesting application is not the definition owner, you must provide the qualified key.</p>
         * </li>
         * <li>
         * <p><code>value</code>. This value must conform to the <code>schema</code> specified by the definition.
         * For more information, see <a href="https://developer.squareup.com/docs/booking-custom-attributes-api/custom-attributes#value-data-types">Value data types</a>.</p>
         * </li>
         * <li>
         * <p><code>version</code>. To enable <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/optimistic-concurrency">optimistic concurrency</a>
         * control for update operations, include this optional field in the request and set the
         * value to the current version of the custom attribute.</p>
         * </li>
         * </ul>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("custom_attribute")
        public _FinalStage customAttribute(@NotNull CustomAttribute customAttribute) {
            this.customAttribute = Objects.requireNonNull(customAttribute, "customAttribute must not be null");
            return this;
        }

        /**
         * <p>A unique identifier for this individual upsert request, used to ensure idempotency.
         * For more information, see <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency">Idempotency</a>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage idempotencyKey(Nullable<String> idempotencyKey) {
            if (idempotencyKey.isNull()) {
                this.idempotencyKey = null;
            } else if (idempotencyKey.isEmpty()) {
                this.idempotencyKey = Optional.empty();
            } else {
                this.idempotencyKey = Optional.of(idempotencyKey.get());
            }
            return this;
        }

        /**
         * <p>A unique identifier for this individual upsert request, used to ensure idempotency.
         * For more information, see <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency">Idempotency</a>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = Optional.ofNullable(idempotencyKey);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "idempotency_key", nulls = Nulls.SKIP)
        public _FinalStage idempotencyKey(Optional<String> idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        @java.lang.Override
        public BookingCustomAttributeUpsertRequest build() {
            return new BookingCustomAttributeUpsertRequest(
                    bookingId, customAttribute, idempotencyKey, additionalProperties);
        }
    }
}
