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

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = PaymentLink.Builder.class)
public final class PaymentLink {
    private final Optional<String> id;

    private final int version;

    private final Optional<String> description;

    private final Optional<String> orderId;

    private final Optional<CheckoutOptions> checkoutOptions;

    private final Optional<PrePopulatedData> prePopulatedData;

    private final Optional<String> url;

    private final Optional<String> longUrl;

    private final Optional<String> createdAt;

    private final Optional<String> updatedAt;

    private final Optional<String> paymentNote;

    private final Map<String, Object> additionalProperties;

    private PaymentLink(
            Optional<String> id,
            int version,
            Optional<String> description,
            Optional<String> orderId,
            Optional<CheckoutOptions> checkoutOptions,
            Optional<PrePopulatedData> prePopulatedData,
            Optional<String> url,
            Optional<String> longUrl,
            Optional<String> createdAt,
            Optional<String> updatedAt,
            Optional<String> paymentNote,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.version = version;
        this.description = description;
        this.orderId = orderId;
        this.checkoutOptions = checkoutOptions;
        this.prePopulatedData = prePopulatedData;
        this.url = url;
        this.longUrl = longUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.paymentNote = paymentNote;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The Square-assigned ID of the payment link.
     */
    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    /**
     * @return The Square-assigned version number, which is incremented each time an update is committed to the payment link.
     */
    @JsonProperty("version")
    public int getVersion() {
        return version;
    }

    /**
     * @return The optional description of the <code>payment_link</code> object.
     * It is primarily for use by your application and is not used anywhere.
     */
    @JsonIgnore
    public Optional<String> getDescription() {
        if (description == null) {
            return Optional.empty();
        }
        return description;
    }

    /**
     * @return The ID of the order associated with the payment link.
     */
    @JsonProperty("order_id")
    public Optional<String> getOrderId() {
        return orderId;
    }

    /**
     * @return The checkout options configured for the payment link.
     * For more information, see <a href="https://developer.squareup.com/docs/checkout-api/optional-checkout-configurations">Optional Checkout Configurations</a>.
     */
    @JsonProperty("checkout_options")
    public Optional<CheckoutOptions> getCheckoutOptions() {
        return checkoutOptions;
    }

    /**
     * @return Describes buyer data to prepopulate
     * on the checkout page.
     */
    @JsonProperty("pre_populated_data")
    public Optional<PrePopulatedData> getPrePopulatedData() {
        return prePopulatedData;
    }

    /**
     * @return The shortened URL of the payment link.
     */
    @JsonProperty("url")
    public Optional<String> getUrl() {
        return url;
    }

    /**
     * @return The long URL of the payment link.
     */
    @JsonProperty("long_url")
    public Optional<String> getLongUrl() {
        return longUrl;
    }

    /**
     * @return The timestamp when the payment link was created, in RFC 3339 format.
     */
    @JsonProperty("created_at")
    public Optional<String> getCreatedAt() {
        return createdAt;
    }

    /**
     * @return The timestamp when the payment link was last updated, in RFC 3339 format.
     */
    @JsonProperty("updated_at")
    public Optional<String> getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @return An optional note. After Square processes the payment, this note is added to the
     * resulting <code>Payment</code>.
     */
    @JsonIgnore
    public Optional<String> getPaymentNote() {
        if (paymentNote == null) {
            return Optional.empty();
        }
        return paymentNote;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("description")
    private Optional<String> _getDescription() {
        return description;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("payment_note")
    private Optional<String> _getPaymentNote() {
        return paymentNote;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PaymentLink && equalTo((PaymentLink) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(PaymentLink other) {
        return id.equals(other.id)
                && version == other.version
                && description.equals(other.description)
                && orderId.equals(other.orderId)
                && checkoutOptions.equals(other.checkoutOptions)
                && prePopulatedData.equals(other.prePopulatedData)
                && url.equals(other.url)
                && longUrl.equals(other.longUrl)
                && createdAt.equals(other.createdAt)
                && updatedAt.equals(other.updatedAt)
                && paymentNote.equals(other.paymentNote);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.version,
                this.description,
                this.orderId,
                this.checkoutOptions,
                this.prePopulatedData,
                this.url,
                this.longUrl,
                this.createdAt,
                this.updatedAt,
                this.paymentNote);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static VersionStage builder() {
        return new Builder();
    }

    public interface VersionStage {
        /**
         * <p>The Square-assigned version number, which is incremented each time an update is committed to the payment link.</p>
         */
        _FinalStage version(int version);

        Builder from(PaymentLink other);
    }

    public interface _FinalStage {
        PaymentLink build();

        /**
         * <p>The Square-assigned ID of the payment link.</p>
         */
        _FinalStage id(Optional<String> id);

        _FinalStage id(String id);

        /**
         * <p>The optional description of the <code>payment_link</code> object.
         * It is primarily for use by your application and is not used anywhere.</p>
         */
        _FinalStage description(Optional<String> description);

        _FinalStage description(String description);

        _FinalStage description(Nullable<String> description);

        /**
         * <p>The ID of the order associated with the payment link.</p>
         */
        _FinalStage orderId(Optional<String> orderId);

        _FinalStage orderId(String orderId);

        /**
         * <p>The checkout options configured for the payment link.
         * For more information, see <a href="https://developer.squareup.com/docs/checkout-api/optional-checkout-configurations">Optional Checkout Configurations</a>.</p>
         */
        _FinalStage checkoutOptions(Optional<CheckoutOptions> checkoutOptions);

        _FinalStage checkoutOptions(CheckoutOptions checkoutOptions);

        /**
         * <p>Describes buyer data to prepopulate
         * on the checkout page.</p>
         */
        _FinalStage prePopulatedData(Optional<PrePopulatedData> prePopulatedData);

        _FinalStage prePopulatedData(PrePopulatedData prePopulatedData);

        /**
         * <p>The shortened URL of the payment link.</p>
         */
        _FinalStage url(Optional<String> url);

        _FinalStage url(String url);

        /**
         * <p>The long URL of the payment link.</p>
         */
        _FinalStage longUrl(Optional<String> longUrl);

        _FinalStage longUrl(String longUrl);

        /**
         * <p>The timestamp when the payment link was created, in RFC 3339 format.</p>
         */
        _FinalStage createdAt(Optional<String> createdAt);

        _FinalStage createdAt(String createdAt);

        /**
         * <p>The timestamp when the payment link was last updated, in RFC 3339 format.</p>
         */
        _FinalStage updatedAt(Optional<String> updatedAt);

        _FinalStage updatedAt(String updatedAt);

        /**
         * <p>An optional note. After Square processes the payment, this note is added to the
         * resulting <code>Payment</code>.</p>
         */
        _FinalStage paymentNote(Optional<String> paymentNote);

        _FinalStage paymentNote(String paymentNote);

        _FinalStage paymentNote(Nullable<String> paymentNote);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements VersionStage, _FinalStage {
        private int version;

        private Optional<String> paymentNote = Optional.empty();

        private Optional<String> updatedAt = Optional.empty();

        private Optional<String> createdAt = Optional.empty();

        private Optional<String> longUrl = Optional.empty();

        private Optional<String> url = Optional.empty();

        private Optional<PrePopulatedData> prePopulatedData = Optional.empty();

        private Optional<CheckoutOptions> checkoutOptions = Optional.empty();

        private Optional<String> orderId = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Optional<String> id = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(PaymentLink other) {
            id(other.getId());
            version(other.getVersion());
            description(other.getDescription());
            orderId(other.getOrderId());
            checkoutOptions(other.getCheckoutOptions());
            prePopulatedData(other.getPrePopulatedData());
            url(other.getUrl());
            longUrl(other.getLongUrl());
            createdAt(other.getCreatedAt());
            updatedAt(other.getUpdatedAt());
            paymentNote(other.getPaymentNote());
            return this;
        }

        /**
         * <p>The Square-assigned version number, which is incremented each time an update is committed to the payment link.</p>
         * <p>The Square-assigned version number, which is incremented each time an update is committed to the payment link.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("version")
        public _FinalStage version(int version) {
            this.version = version;
            return this;
        }

        /**
         * <p>An optional note. After Square processes the payment, this note is added to the
         * resulting <code>Payment</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage paymentNote(Nullable<String> paymentNote) {
            if (paymentNote.isNull()) {
                this.paymentNote = null;
            } else if (paymentNote.isEmpty()) {
                this.paymentNote = Optional.empty();
            } else {
                this.paymentNote = Optional.of(paymentNote.get());
            }
            return this;
        }

        /**
         * <p>An optional note. After Square processes the payment, this note is added to the
         * resulting <code>Payment</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage paymentNote(String paymentNote) {
            this.paymentNote = Optional.ofNullable(paymentNote);
            return this;
        }

        /**
         * <p>An optional note. After Square processes the payment, this note is added to the
         * resulting <code>Payment</code>.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "payment_note", nulls = Nulls.SKIP)
        public _FinalStage paymentNote(Optional<String> paymentNote) {
            this.paymentNote = paymentNote;
            return this;
        }

        /**
         * <p>The timestamp when the payment link was last updated, in RFC 3339 format.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage updatedAt(String updatedAt) {
            this.updatedAt = Optional.ofNullable(updatedAt);
            return this;
        }

        /**
         * <p>The timestamp when the payment link was last updated, in RFC 3339 format.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "updated_at", nulls = Nulls.SKIP)
        public _FinalStage updatedAt(Optional<String> updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * <p>The timestamp when the payment link was created, in RFC 3339 format.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage createdAt(String createdAt) {
            this.createdAt = Optional.ofNullable(createdAt);
            return this;
        }

        /**
         * <p>The timestamp when the payment link was created, in RFC 3339 format.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "created_at", nulls = Nulls.SKIP)
        public _FinalStage createdAt(Optional<String> createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * <p>The long URL of the payment link.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage longUrl(String longUrl) {
            this.longUrl = Optional.ofNullable(longUrl);
            return this;
        }

        /**
         * <p>The long URL of the payment link.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "long_url", nulls = Nulls.SKIP)
        public _FinalStage longUrl(Optional<String> longUrl) {
            this.longUrl = longUrl;
            return this;
        }

        /**
         * <p>The shortened URL of the payment link.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage url(String url) {
            this.url = Optional.ofNullable(url);
            return this;
        }

        /**
         * <p>The shortened URL of the payment link.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "url", nulls = Nulls.SKIP)
        public _FinalStage url(Optional<String> url) {
            this.url = url;
            return this;
        }

        /**
         * <p>Describes buyer data to prepopulate
         * on the checkout page.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage prePopulatedData(PrePopulatedData prePopulatedData) {
            this.prePopulatedData = Optional.ofNullable(prePopulatedData);
            return this;
        }

        /**
         * <p>Describes buyer data to prepopulate
         * on the checkout page.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "pre_populated_data", nulls = Nulls.SKIP)
        public _FinalStage prePopulatedData(Optional<PrePopulatedData> prePopulatedData) {
            this.prePopulatedData = prePopulatedData;
            return this;
        }

        /**
         * <p>The checkout options configured for the payment link.
         * For more information, see <a href="https://developer.squareup.com/docs/checkout-api/optional-checkout-configurations">Optional Checkout Configurations</a>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage checkoutOptions(CheckoutOptions checkoutOptions) {
            this.checkoutOptions = Optional.ofNullable(checkoutOptions);
            return this;
        }

        /**
         * <p>The checkout options configured for the payment link.
         * For more information, see <a href="https://developer.squareup.com/docs/checkout-api/optional-checkout-configurations">Optional Checkout Configurations</a>.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "checkout_options", nulls = Nulls.SKIP)
        public _FinalStage checkoutOptions(Optional<CheckoutOptions> checkoutOptions) {
            this.checkoutOptions = checkoutOptions;
            return this;
        }

        /**
         * <p>The ID of the order associated with the payment link.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage orderId(String orderId) {
            this.orderId = Optional.ofNullable(orderId);
            return this;
        }

        /**
         * <p>The ID of the order associated with the payment link.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "order_id", nulls = Nulls.SKIP)
        public _FinalStage orderId(Optional<String> orderId) {
            this.orderId = orderId;
            return this;
        }

        /**
         * <p>The optional description of the <code>payment_link</code> object.
         * It is primarily for use by your application and is not used anywhere.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage description(Nullable<String> description) {
            if (description.isNull()) {
                this.description = null;
            } else if (description.isEmpty()) {
                this.description = Optional.empty();
            } else {
                this.description = Optional.of(description.get());
            }
            return this;
        }

        /**
         * <p>The optional description of the <code>payment_link</code> object.
         * It is primarily for use by your application and is not used anywhere.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage description(String description) {
            this.description = Optional.ofNullable(description);
            return this;
        }

        /**
         * <p>The optional description of the <code>payment_link</code> object.
         * It is primarily for use by your application and is not used anywhere.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "description", nulls = Nulls.SKIP)
        public _FinalStage description(Optional<String> description) {
            this.description = description;
            return this;
        }

        /**
         * <p>The Square-assigned ID of the payment link.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage id(String id) {
            this.id = Optional.ofNullable(id);
            return this;
        }

        /**
         * <p>The Square-assigned ID of the payment link.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public _FinalStage id(Optional<String> id) {
            this.id = id;
            return this;
        }

        @java.lang.Override
        public PaymentLink build() {
            return new PaymentLink(
                    id,
                    version,
                    description,
                    orderId,
                    checkoutOptions,
                    prePopulatedData,
                    url,
                    longUrl,
                    createdAt,
                    updatedAt,
                    paymentNote,
                    additionalProperties);
        }
    }
}
