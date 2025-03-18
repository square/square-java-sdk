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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CreateSubscriptionRequest.Builder.class)
public final class CreateSubscriptionRequest {
    private final Optional<String> idempotencyKey;

    private final String locationId;

    private final Optional<String> planVariationId;

    private final String customerId;

    private final Optional<String> startDate;

    private final Optional<String> canceledDate;

    private final Optional<String> taxPercentage;

    private final Optional<Money> priceOverrideMoney;

    private final Optional<String> cardId;

    private final Optional<String> timezone;

    private final Optional<SubscriptionSource> source;

    private final Optional<Integer> monthlyBillingAnchorDate;

    private final Optional<List<Phase>> phases;

    private final Map<String, Object> additionalProperties;

    private CreateSubscriptionRequest(
            Optional<String> idempotencyKey,
            String locationId,
            Optional<String> planVariationId,
            String customerId,
            Optional<String> startDate,
            Optional<String> canceledDate,
            Optional<String> taxPercentage,
            Optional<Money> priceOverrideMoney,
            Optional<String> cardId,
            Optional<String> timezone,
            Optional<SubscriptionSource> source,
            Optional<Integer> monthlyBillingAnchorDate,
            Optional<List<Phase>> phases,
            Map<String, Object> additionalProperties) {
        this.idempotencyKey = idempotencyKey;
        this.locationId = locationId;
        this.planVariationId = planVariationId;
        this.customerId = customerId;
        this.startDate = startDate;
        this.canceledDate = canceledDate;
        this.taxPercentage = taxPercentage;
        this.priceOverrideMoney = priceOverrideMoney;
        this.cardId = cardId;
        this.timezone = timezone;
        this.source = source;
        this.monthlyBillingAnchorDate = monthlyBillingAnchorDate;
        this.phases = phases;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return A unique string that identifies this <code>CreateSubscription</code> request.
     * If you do not provide a unique string (or provide an empty string as the value),
     * the endpoint treats each request as independent.
     * <p>For more information, see <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency">Idempotency keys</a>.</p>
     */
    @JsonProperty("idempotency_key")
    public Optional<String> getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * @return The ID of the location the subscription is associated with.
     */
    @JsonProperty("location_id")
    public String getLocationId() {
        return locationId;
    }

    /**
     * @return The ID of the <a href="https://developer.squareup.com/docs/subscriptions-api/plans-and-variations#plan-variations">subscription plan variation</a> created using the Catalog API.
     */
    @JsonProperty("plan_variation_id")
    public Optional<String> getPlanVariationId() {
        return planVariationId;
    }

    /**
     * @return The ID of the <a href="entity:Customer">customer</a> subscribing to the subscription plan variation.
     */
    @JsonProperty("customer_id")
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @return The <code>YYYY-MM-DD</code>-formatted date to start the subscription.
     * If it is unspecified, the subscription starts immediately.
     */
    @JsonProperty("start_date")
    public Optional<String> getStartDate() {
        return startDate;
    }

    /**
     * @return The <code>YYYY-MM-DD</code>-formatted date when the newly created subscription is scheduled for cancellation.
     * <p>This date overrides the cancellation date set in the plan variation configuration.
     * If the cancellation date is earlier than the end date of a subscription cycle, the subscription stops
     * at the canceled date and the subscriber is sent a prorated invoice at the beginning of the canceled cycle.</p>
     * <p>When the subscription plan of the newly created subscription has a fixed number of cycles and the <code>canceled_date</code>
     * occurs before the subscription plan expires, the specified <code>canceled_date</code> sets the date when the subscription
     * stops through the end of the last cycle.</p>
     */
    @JsonProperty("canceled_date")
    public Optional<String> getCanceledDate() {
        return canceledDate;
    }

    /**
     * @return The tax to add when billing the subscription.
     * The percentage is expressed in decimal form, using a <code>'.'</code> as the decimal
     * separator and without a <code>'%'</code> sign. For example, a value of 7.5
     * corresponds to 7.5%.
     */
    @JsonProperty("tax_percentage")
    public Optional<String> getTaxPercentage() {
        return taxPercentage;
    }

    /**
     * @return A custom price which overrides the cost of a subscription plan variation with <code>STATIC</code> pricing.
     * This field does not affect itemized subscriptions with <code>RELATIVE</code> pricing. Instead,
     * you should edit the Subscription's <a href="https://developer.squareup.com/docs/subscriptions-api/manage-subscriptions#phases-and-order-templates">order template</a>.
     */
    @JsonProperty("price_override_money")
    public Optional<Money> getPriceOverrideMoney() {
        return priceOverrideMoney;
    }

    /**
     * @return The ID of the <a href="entity:Customer">subscriber's</a> <a href="entity:Card">card</a> to charge.
     * If it is not specified, the subscriber receives an invoice via email with a link to pay for their subscription.
     */
    @JsonProperty("card_id")
    public Optional<String> getCardId() {
        return cardId;
    }

    /**
     * @return The timezone that is used in date calculations for the subscription. If unset, defaults to
     * the location timezone. If a timezone is not configured for the location, defaults to &quot;America/New_York&quot;.
     * Format: the IANA Timezone Database identifier for the location timezone. For
     * a list of time zones, see <a href="https://en.wikipedia.org/wiki/List_of_tz_database_time_zones">List of tz database time zones</a>.
     */
    @JsonProperty("timezone")
    public Optional<String> getTimezone() {
        return timezone;
    }

    /**
     * @return The origination details of the subscription.
     */
    @JsonProperty("source")
    public Optional<SubscriptionSource> getSource() {
        return source;
    }

    /**
     * @return The day-of-the-month to change the billing date to.
     */
    @JsonProperty("monthly_billing_anchor_date")
    public Optional<Integer> getMonthlyBillingAnchorDate() {
        return monthlyBillingAnchorDate;
    }

    /**
     * @return array of phases for this subscription
     */
    @JsonProperty("phases")
    public Optional<List<Phase>> getPhases() {
        return phases;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateSubscriptionRequest && equalTo((CreateSubscriptionRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CreateSubscriptionRequest other) {
        return idempotencyKey.equals(other.idempotencyKey)
                && locationId.equals(other.locationId)
                && planVariationId.equals(other.planVariationId)
                && customerId.equals(other.customerId)
                && startDate.equals(other.startDate)
                && canceledDate.equals(other.canceledDate)
                && taxPercentage.equals(other.taxPercentage)
                && priceOverrideMoney.equals(other.priceOverrideMoney)
                && cardId.equals(other.cardId)
                && timezone.equals(other.timezone)
                && source.equals(other.source)
                && monthlyBillingAnchorDate.equals(other.monthlyBillingAnchorDate)
                && phases.equals(other.phases);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.idempotencyKey,
                this.locationId,
                this.planVariationId,
                this.customerId,
                this.startDate,
                this.canceledDate,
                this.taxPercentage,
                this.priceOverrideMoney,
                this.cardId,
                this.timezone,
                this.source,
                this.monthlyBillingAnchorDate,
                this.phases);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static LocationIdStage builder() {
        return new Builder();
    }

    public interface LocationIdStage {
        CustomerIdStage locationId(@NotNull String locationId);

        Builder from(CreateSubscriptionRequest other);
    }

    public interface CustomerIdStage {
        _FinalStage customerId(@NotNull String customerId);
    }

    public interface _FinalStage {
        CreateSubscriptionRequest build();

        _FinalStage idempotencyKey(Optional<String> idempotencyKey);

        _FinalStage idempotencyKey(String idempotencyKey);

        _FinalStage planVariationId(Optional<String> planVariationId);

        _FinalStage planVariationId(String planVariationId);

        _FinalStage startDate(Optional<String> startDate);

        _FinalStage startDate(String startDate);

        _FinalStage canceledDate(Optional<String> canceledDate);

        _FinalStage canceledDate(String canceledDate);

        _FinalStage taxPercentage(Optional<String> taxPercentage);

        _FinalStage taxPercentage(String taxPercentage);

        _FinalStage priceOverrideMoney(Optional<Money> priceOverrideMoney);

        _FinalStage priceOverrideMoney(Money priceOverrideMoney);

        _FinalStage cardId(Optional<String> cardId);

        _FinalStage cardId(String cardId);

        _FinalStage timezone(Optional<String> timezone);

        _FinalStage timezone(String timezone);

        _FinalStage source(Optional<SubscriptionSource> source);

        _FinalStage source(SubscriptionSource source);

        _FinalStage monthlyBillingAnchorDate(Optional<Integer> monthlyBillingAnchorDate);

        _FinalStage monthlyBillingAnchorDate(Integer monthlyBillingAnchorDate);

        _FinalStage phases(Optional<List<Phase>> phases);

        _FinalStage phases(List<Phase> phases);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements LocationIdStage, CustomerIdStage, _FinalStage {
        private String locationId;

        private String customerId;

        private Optional<List<Phase>> phases = Optional.empty();

        private Optional<Integer> monthlyBillingAnchorDate = Optional.empty();

        private Optional<SubscriptionSource> source = Optional.empty();

        private Optional<String> timezone = Optional.empty();

        private Optional<String> cardId = Optional.empty();

        private Optional<Money> priceOverrideMoney = Optional.empty();

        private Optional<String> taxPercentage = Optional.empty();

        private Optional<String> canceledDate = Optional.empty();

        private Optional<String> startDate = Optional.empty();

        private Optional<String> planVariationId = Optional.empty();

        private Optional<String> idempotencyKey = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(CreateSubscriptionRequest other) {
            idempotencyKey(other.getIdempotencyKey());
            locationId(other.getLocationId());
            planVariationId(other.getPlanVariationId());
            customerId(other.getCustomerId());
            startDate(other.getStartDate());
            canceledDate(other.getCanceledDate());
            taxPercentage(other.getTaxPercentage());
            priceOverrideMoney(other.getPriceOverrideMoney());
            cardId(other.getCardId());
            timezone(other.getTimezone());
            source(other.getSource());
            monthlyBillingAnchorDate(other.getMonthlyBillingAnchorDate());
            phases(other.getPhases());
            return this;
        }

        /**
         * <p>The ID of the location the subscription is associated with.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("location_id")
        public CustomerIdStage locationId(@NotNull String locationId) {
            this.locationId = Objects.requireNonNull(locationId, "locationId must not be null");
            return this;
        }

        /**
         * <p>The ID of the <a href="entity:Customer">customer</a> subscribing to the subscription plan variation.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("customer_id")
        public _FinalStage customerId(@NotNull String customerId) {
            this.customerId = Objects.requireNonNull(customerId, "customerId must not be null");
            return this;
        }

        /**
         * <p>array of phases for this subscription</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage phases(List<Phase> phases) {
            this.phases = Optional.ofNullable(phases);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "phases", nulls = Nulls.SKIP)
        public _FinalStage phases(Optional<List<Phase>> phases) {
            this.phases = phases;
            return this;
        }

        /**
         * <p>The day-of-the-month to change the billing date to.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage monthlyBillingAnchorDate(Integer monthlyBillingAnchorDate) {
            this.monthlyBillingAnchorDate = Optional.ofNullable(monthlyBillingAnchorDate);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "monthly_billing_anchor_date", nulls = Nulls.SKIP)
        public _FinalStage monthlyBillingAnchorDate(Optional<Integer> monthlyBillingAnchorDate) {
            this.monthlyBillingAnchorDate = monthlyBillingAnchorDate;
            return this;
        }

        /**
         * <p>The origination details of the subscription.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage source(SubscriptionSource source) {
            this.source = Optional.ofNullable(source);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "source", nulls = Nulls.SKIP)
        public _FinalStage source(Optional<SubscriptionSource> source) {
            this.source = source;
            return this;
        }

        /**
         * <p>The timezone that is used in date calculations for the subscription. If unset, defaults to
         * the location timezone. If a timezone is not configured for the location, defaults to &quot;America/New_York&quot;.
         * Format: the IANA Timezone Database identifier for the location timezone. For
         * a list of time zones, see <a href="https://en.wikipedia.org/wiki/List_of_tz_database_time_zones">List of tz database time zones</a>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage timezone(String timezone) {
            this.timezone = Optional.ofNullable(timezone);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "timezone", nulls = Nulls.SKIP)
        public _FinalStage timezone(Optional<String> timezone) {
            this.timezone = timezone;
            return this;
        }

        /**
         * <p>The ID of the <a href="entity:Customer">subscriber's</a> <a href="entity:Card">card</a> to charge.
         * If it is not specified, the subscriber receives an invoice via email with a link to pay for their subscription.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage cardId(String cardId) {
            this.cardId = Optional.ofNullable(cardId);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "card_id", nulls = Nulls.SKIP)
        public _FinalStage cardId(Optional<String> cardId) {
            this.cardId = cardId;
            return this;
        }

        /**
         * <p>A custom price which overrides the cost of a subscription plan variation with <code>STATIC</code> pricing.
         * This field does not affect itemized subscriptions with <code>RELATIVE</code> pricing. Instead,
         * you should edit the Subscription's <a href="https://developer.squareup.com/docs/subscriptions-api/manage-subscriptions#phases-and-order-templates">order template</a>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage priceOverrideMoney(Money priceOverrideMoney) {
            this.priceOverrideMoney = Optional.ofNullable(priceOverrideMoney);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "price_override_money", nulls = Nulls.SKIP)
        public _FinalStage priceOverrideMoney(Optional<Money> priceOverrideMoney) {
            this.priceOverrideMoney = priceOverrideMoney;
            return this;
        }

        /**
         * <p>The tax to add when billing the subscription.
         * The percentage is expressed in decimal form, using a <code>'.'</code> as the decimal
         * separator and without a <code>'%'</code> sign. For example, a value of 7.5
         * corresponds to 7.5%.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage taxPercentage(String taxPercentage) {
            this.taxPercentage = Optional.ofNullable(taxPercentage);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "tax_percentage", nulls = Nulls.SKIP)
        public _FinalStage taxPercentage(Optional<String> taxPercentage) {
            this.taxPercentage = taxPercentage;
            return this;
        }

        /**
         * <p>The <code>YYYY-MM-DD</code>-formatted date when the newly created subscription is scheduled for cancellation.</p>
         * <p>This date overrides the cancellation date set in the plan variation configuration.
         * If the cancellation date is earlier than the end date of a subscription cycle, the subscription stops
         * at the canceled date and the subscriber is sent a prorated invoice at the beginning of the canceled cycle.</p>
         * <p>When the subscription plan of the newly created subscription has a fixed number of cycles and the <code>canceled_date</code>
         * occurs before the subscription plan expires, the specified <code>canceled_date</code> sets the date when the subscription
         * stops through the end of the last cycle.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage canceledDate(String canceledDate) {
            this.canceledDate = Optional.ofNullable(canceledDate);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "canceled_date", nulls = Nulls.SKIP)
        public _FinalStage canceledDate(Optional<String> canceledDate) {
            this.canceledDate = canceledDate;
            return this;
        }

        /**
         * <p>The <code>YYYY-MM-DD</code>-formatted date to start the subscription.
         * If it is unspecified, the subscription starts immediately.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage startDate(String startDate) {
            this.startDate = Optional.ofNullable(startDate);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "start_date", nulls = Nulls.SKIP)
        public _FinalStage startDate(Optional<String> startDate) {
            this.startDate = startDate;
            return this;
        }

        /**
         * <p>The ID of the <a href="https://developer.squareup.com/docs/subscriptions-api/plans-and-variations#plan-variations">subscription plan variation</a> created using the Catalog API.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage planVariationId(String planVariationId) {
            this.planVariationId = Optional.ofNullable(planVariationId);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "plan_variation_id", nulls = Nulls.SKIP)
        public _FinalStage planVariationId(Optional<String> planVariationId) {
            this.planVariationId = planVariationId;
            return this;
        }

        /**
         * <p>A unique string that identifies this <code>CreateSubscription</code> request.
         * If you do not provide a unique string (or provide an empty string as the value),
         * the endpoint treats each request as independent.</p>
         * <p>For more information, see <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency">Idempotency keys</a>.</p>
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
        public CreateSubscriptionRequest build() {
            return new CreateSubscriptionRequest(
                    idempotencyKey,
                    locationId,
                    planVariationId,
                    customerId,
                    startDate,
                    canceledDate,
                    taxPercentage,
                    priceOverrideMoney,
                    cardId,
                    timezone,
                    source,
                    monthlyBillingAnchorDate,
                    phases,
                    additionalProperties);
        }
    }
}
