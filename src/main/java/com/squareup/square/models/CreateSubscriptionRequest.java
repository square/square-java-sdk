package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CreateSubscriptionRequest type.
 */
public class CreateSubscriptionRequest {

    /**
     * Initialization constructor.
     * @param idempotencyKey
     * @param locationId
     * @param planId
     * @param customerId
     * @param startDate
     * @param canceledDate
     * @param taxPercentage
     * @param priceOverrideMoney
     * @param cardId
     * @param timezone
     */
    @JsonCreator
    public CreateSubscriptionRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("plan_id") String planId,
            @JsonProperty("customer_id") String customerId,
            @JsonProperty("start_date") String startDate,
            @JsonProperty("canceled_date") String canceledDate,
            @JsonProperty("tax_percentage") String taxPercentage,
            @JsonProperty("price_override_money") Money priceOverrideMoney,
            @JsonProperty("card_id") String cardId,
            @JsonProperty("timezone") String timezone) {
        this.idempotencyKey = idempotencyKey;
        this.locationId = locationId;
        this.planId = planId;
        this.customerId = customerId;
        this.startDate = startDate;
        this.canceledDate = canceledDate;
        this.taxPercentage = taxPercentage;
        this.priceOverrideMoney = priceOverrideMoney;
        this.cardId = cardId;
        this.timezone = timezone;
    }

    private final String idempotencyKey;
    private final String locationId;
    private final String planId;
    private final String customerId;
    private final String startDate;
    private final String canceledDate;
    private final String taxPercentage;
    private final Money priceOverrideMoney;
    private final String cardId;
    private final String timezone;
    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies this `CreateSubscription` request.
     * If you do not provide a unique string (or provide an empty string as the value),
     * the endpoint treats each request as independent.
     * For more information, see [Idempotency keys](https://developer.squareup.com/docs/docs/working-with-apis/idempotency).
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return this.idempotencyKey;
    }

    /**
     * Getter for LocationId.
     * The ID of the location the subscription is associated with.
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

    /**
     * Getter for PlanId.
     * The ID of the subscription plan. For more information, see 
     * [Subscription Plan Overview](https://developer.squareup.com/docs/docs/subscriptions/overview).
     */
    @JsonGetter("plan_id")
    public String getPlanId() {
        return this.planId;
    }

    /**
     * Getter for CustomerId.
     * The ID of the [customer](#type-customer) profile.
     */
    @JsonGetter("customer_id")
    public String getCustomerId() {
        return this.customerId;
    }

    /**
     * Getter for StartDate.
     * The start date of the subscription, in YYYY-MM-DD format. For example,
     * 2013-01-15. If the start date is left empty, the subscription begins 
     * immediately.
     */
    @JsonGetter("start_date")
    public String getStartDate() {
        return this.startDate;
    }

    /**
     * Getter for CanceledDate.
     * The date when the subscription should be canceled, in 
     * YYYY-MM-DD format (for example, 2025-02-29). This overrides the plan configuration 
     * if it comes before the date the subscription would otherwise end.
     */
    @JsonGetter("canceled_date")
    public String getCanceledDate() {
        return this.canceledDate;
    }

    /**
     * Getter for TaxPercentage.
     * The tax to add when billing the subscription.
     * The percentage is expressed in decimal form, using a `'.'` as the decimal
     * separator and without a `'%'` sign. For example, a value of 7.5
     * corresponds to 7.5%.
     */
    @JsonGetter("tax_percentage")
    public String getTaxPercentage() {
        return this.taxPercentage;
    }

    /**
     * Getter for PriceOverrideMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("price_override_money")
    public Money getPriceOverrideMoney() {
        return this.priceOverrideMoney;
    }

    /**
     * Getter for CardId.
     * The ID of the [customer](#type-customer) [card](#type-card) to charge.
     * If not specified, Square sends an invoice via email. For an example to
     * create a customer and add a card on file, see [Subscriptions Walkthrough](https://developer.squareup.com/docs/docs/subscriptions-api/walkthrough).
     */
    @JsonGetter("card_id")
    public String getCardId() {
        return this.cardId;
    }

    /**
     * Getter for Timezone.
     * The timezone that is used in date calculations for the subscription. If unset, defaults to
     * the location timezone. If a timezone is not configured for the location, defaults to "America/New_York".
     * Format: the IANA Timezone Database identifier for the location timezone. For
     * a list of time zones, see [List of tz database time zones](https://en.wikipedia.org/wiki/List_of_tz_database_time_zones).
     */
    @JsonGetter("timezone")
    public String getTimezone() {
        return this.timezone;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, locationId, planId, customerId, startDate, canceledDate,
            taxPercentage, priceOverrideMoney, cardId, timezone);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CreateSubscriptionRequest)) {
            return false;
        }
        CreateSubscriptionRequest createSubscriptionRequest = (CreateSubscriptionRequest) obj;
        return Objects.equals(idempotencyKey, createSubscriptionRequest.idempotencyKey) &&
            Objects.equals(locationId, createSubscriptionRequest.locationId) &&
            Objects.equals(planId, createSubscriptionRequest.planId) &&
            Objects.equals(customerId, createSubscriptionRequest.customerId) &&
            Objects.equals(startDate, createSubscriptionRequest.startDate) &&
            Objects.equals(canceledDate, createSubscriptionRequest.canceledDate) &&
            Objects.equals(taxPercentage, createSubscriptionRequest.taxPercentage) &&
            Objects.equals(priceOverrideMoney, createSubscriptionRequest.priceOverrideMoney) &&
            Objects.equals(cardId, createSubscriptionRequest.cardId) &&
            Objects.equals(timezone, createSubscriptionRequest.timezone);
    }

    /**
     * Builds a new {@link CreateSubscriptionRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateSubscriptionRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey,
            locationId,
            planId,
            customerId)
            .startDate(getStartDate())
            .canceledDate(getCanceledDate())
            .taxPercentage(getTaxPercentage())
            .priceOverrideMoney(getPriceOverrideMoney())
            .cardId(getCardId())
            .timezone(getTimezone());
            return builder;
    }

    /**
     * Class to build instances of {@link CreateSubscriptionRequest}
     */
    public static class Builder {
        private String idempotencyKey;
        private String locationId;
        private String planId;
        private String customerId;
        private String startDate;
        private String canceledDate;
        private String taxPercentage;
        private Money priceOverrideMoney;
        private String cardId;
        private String timezone;

        /**
         * Initialization constructor
         */
        public Builder(String idempotencyKey,
                String locationId,
                String planId,
                String customerId) {
            this.idempotencyKey = idempotencyKey;
            this.locationId = locationId;
            this.planId = planId;
            this.customerId = customerId;
        }

        /**
         * Setter for idempotencyKey
         * @param idempotencyKey
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }
        /**
         * Setter for locationId
         * @param locationId
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }
        /**
         * Setter for planId
         * @param planId
         * @return Builder
         */
        public Builder planId(String planId) {
            this.planId = planId;
            return this;
        }
        /**
         * Setter for customerId
         * @param customerId
         * @return Builder
         */
        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }
        /**
         * Setter for startDate
         * @param startDate
         * @return Builder
         */
        public Builder startDate(String startDate) {
            this.startDate = startDate;
            return this;
        }
        /**
         * Setter for canceledDate
         * @param canceledDate
         * @return Builder
         */
        public Builder canceledDate(String canceledDate) {
            this.canceledDate = canceledDate;
            return this;
        }
        /**
         * Setter for taxPercentage
         * @param taxPercentage
         * @return Builder
         */
        public Builder taxPercentage(String taxPercentage) {
            this.taxPercentage = taxPercentage;
            return this;
        }
        /**
         * Setter for priceOverrideMoney
         * @param priceOverrideMoney
         * @return Builder
         */
        public Builder priceOverrideMoney(Money priceOverrideMoney) {
            this.priceOverrideMoney = priceOverrideMoney;
            return this;
        }
        /**
         * Setter for cardId
         * @param cardId
         * @return Builder
         */
        public Builder cardId(String cardId) {
            this.cardId = cardId;
            return this;
        }
        /**
         * Setter for timezone
         * @param timezone
         * @return Builder
         */
        public Builder timezone(String timezone) {
            this.timezone = timezone;
            return this;
        }

        /**
         * Builds a new {@link CreateSubscriptionRequest} object using the set fields.
         * @return {@link CreateSubscriptionRequest}
         */
        public CreateSubscriptionRequest build() {
            return new CreateSubscriptionRequest(idempotencyKey,
                locationId,
                planId,
                customerId,
                startDate,
                canceledDate,
                taxPercentage,
                priceOverrideMoney,
                cardId,
                timezone);
        }
    }
}
