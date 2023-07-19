
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CreateSubscriptionRequest type.
 */
public class CreateSubscriptionRequest {
    private final String idempotencyKey;
    private final String locationId;
    private final String planVariationId;
    private final String customerId;
    private final String startDate;
    private final String canceledDate;
    private final String taxPercentage;
    private final Money priceOverrideMoney;
    private final String cardId;
    private final String timezone;
    private final SubscriptionSource source;
    private final List<Phase> phases;

    /**
     * Initialization constructor.
     * @param  locationId  String value for locationId.
     * @param  customerId  String value for customerId.
     * @param  idempotencyKey  String value for idempotencyKey.
     * @param  planVariationId  String value for planVariationId.
     * @param  startDate  String value for startDate.
     * @param  canceledDate  String value for canceledDate.
     * @param  taxPercentage  String value for taxPercentage.
     * @param  priceOverrideMoney  Money value for priceOverrideMoney.
     * @param  cardId  String value for cardId.
     * @param  timezone  String value for timezone.
     * @param  source  SubscriptionSource value for source.
     * @param  phases  List of Phase value for phases.
     */
    @JsonCreator
    public CreateSubscriptionRequest(
            @JsonProperty("location_id") String locationId,
            @JsonProperty("customer_id") String customerId,
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("plan_variation_id") String planVariationId,
            @JsonProperty("start_date") String startDate,
            @JsonProperty("canceled_date") String canceledDate,
            @JsonProperty("tax_percentage") String taxPercentage,
            @JsonProperty("price_override_money") Money priceOverrideMoney,
            @JsonProperty("card_id") String cardId,
            @JsonProperty("timezone") String timezone,
            @JsonProperty("source") SubscriptionSource source,
            @JsonProperty("phases") List<Phase> phases) {
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
        this.phases = phases;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies this `CreateSubscription` request. If you do not provide a
     * unique string (or provide an empty string as the value), the endpoint treats each request as
     * independent. For more information, see [Idempotency
     * keys](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency).
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * Getter for LocationId.
     * The ID of the location the subscription is associated with.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for PlanVariationId.
     * The ID of the [subscription plan
     * variation](https://developer.squareup.com/docs/subscriptions-api/plans-and-variations#plan-variations)
     * created using the Catalog API.
     * @return Returns the String
     */
    @JsonGetter("plan_variation_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPlanVariationId() {
        return planVariationId;
    }

    /**
     * Getter for CustomerId.
     * The ID of the [customer](entity:Customer) subscribing to the subscription plan variation.
     * @return Returns the String
     */
    @JsonGetter("customer_id")
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Getter for StartDate.
     * The `YYYY-MM-DD`-formatted date to start the subscription. If it is unspecified, the
     * subscription starts immediately.
     * @return Returns the String
     */
    @JsonGetter("start_date")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStartDate() {
        return startDate;
    }

    /**
     * Getter for CanceledDate.
     * The `YYYY-MM-DD`-formatted date when the newly created subscription is scheduled for
     * cancellation. This date overrides the cancellation date set in the plan variation
     * configuration. If the cancellation date is earlier than the end date of a subscription cycle,
     * the subscription stops at the canceled date and the subscriber is sent a prorated invoice at
     * the beginning of the canceled cycle. When the subscription plan of the newly created
     * subscription has a fixed number of cycles and the `canceled_date` occurs before the
     * subscription plan expires, the specified `canceled_date` sets the date when the subscription
     * stops through the end of the last cycle.
     * @return Returns the String
     */
    @JsonGetter("canceled_date")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCanceledDate() {
        return canceledDate;
    }

    /**
     * Getter for TaxPercentage.
     * The tax to add when billing the subscription. The percentage is expressed in decimal form,
     * using a `'.'` as the decimal separator and without a `'%'` sign. For example, a value of 7.5
     * corresponds to 7.5%.
     * @return Returns the String
     */
    @JsonGetter("tax_percentage")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getTaxPercentage() {
        return taxPercentage;
    }

    /**
     * Getter for PriceOverrideMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("price_override_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getPriceOverrideMoney() {
        return priceOverrideMoney;
    }

    /**
     * Getter for CardId.
     * The ID of the [subscriber's](entity:Customer) [card](entity:Card) to charge. If it is not
     * specified, the subscriber receives an invoice via email with a link to pay for their
     * subscription.
     * @return Returns the String
     */
    @JsonGetter("card_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCardId() {
        return cardId;
    }

    /**
     * Getter for Timezone.
     * The timezone that is used in date calculations for the subscription. If unset, defaults to
     * the location timezone. If a timezone is not configured for the location, defaults to
     * "America/New_York". Format: the IANA Timezone Database identifier for the location timezone.
     * For a list of time zones, see [List of tz database time
     * zones](https://en.wikipedia.org/wiki/List_of_tz_database_time_zones).
     * @return Returns the String
     */
    @JsonGetter("timezone")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getTimezone() {
        return timezone;
    }

    /**
     * Getter for Source.
     * The origination details of the subscription.
     * @return Returns the SubscriptionSource
     */
    @JsonGetter("source")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public SubscriptionSource getSource() {
        return source;
    }

    /**
     * Getter for Phases.
     * array of phases for this subscription
     * @return Returns the List of Phase
     */
    @JsonGetter("phases")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Phase> getPhases() {
        return phases;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, locationId, planVariationId, customerId, startDate,
                canceledDate, taxPercentage, priceOverrideMoney, cardId, timezone, source,
                phases);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateSubscriptionRequest)) {
            return false;
        }
        CreateSubscriptionRequest other = (CreateSubscriptionRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(planVariationId, other.planVariationId)
            && Objects.equals(customerId, other.customerId)
            && Objects.equals(startDate, other.startDate)
            && Objects.equals(canceledDate, other.canceledDate)
            && Objects.equals(taxPercentage, other.taxPercentage)
            && Objects.equals(priceOverrideMoney, other.priceOverrideMoney)
            && Objects.equals(cardId, other.cardId)
            && Objects.equals(timezone, other.timezone)
            && Objects.equals(source, other.source)
            && Objects.equals(phases, other.phases);
    }

    /**
     * Converts this CreateSubscriptionRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateSubscriptionRequest [" + "locationId=" + locationId + ", customerId="
                + customerId + ", idempotencyKey=" + idempotencyKey + ", planVariationId="
                + planVariationId + ", startDate=" + startDate + ", canceledDate=" + canceledDate
                + ", taxPercentage=" + taxPercentage + ", priceOverrideMoney=" + priceOverrideMoney
                + ", cardId=" + cardId + ", timezone=" + timezone + ", source=" + source
                + ", phases=" + phases + "]";
    }

    /**
     * Builds a new {@link CreateSubscriptionRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateSubscriptionRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(locationId, customerId)
                .idempotencyKey(getIdempotencyKey())
                .planVariationId(getPlanVariationId())
                .startDate(getStartDate())
                .canceledDate(getCanceledDate())
                .taxPercentage(getTaxPercentage())
                .priceOverrideMoney(getPriceOverrideMoney())
                .cardId(getCardId())
                .timezone(getTimezone())
                .source(getSource())
                .phases(getPhases());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateSubscriptionRequest}.
     */
    public static class Builder {
        private String locationId;
        private String customerId;
        private String idempotencyKey;
        private String planVariationId;
        private String startDate;
        private String canceledDate;
        private String taxPercentage;
        private Money priceOverrideMoney;
        private String cardId;
        private String timezone;
        private SubscriptionSource source;
        private List<Phase> phases;

        /**
         * Initialization constructor.
         * @param  locationId  String value for locationId.
         * @param  customerId  String value for customerId.
         */
        public Builder(String locationId, String customerId) {
            this.locationId = locationId;
            this.customerId = customerId;
        }

        /**
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * Setter for customerId.
         * @param  customerId  String value for customerId.
         * @return Builder
         */
        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        /**
         * Setter for idempotencyKey.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        /**
         * Setter for planVariationId.
         * @param  planVariationId  String value for planVariationId.
         * @return Builder
         */
        public Builder planVariationId(String planVariationId) {
            this.planVariationId = planVariationId;
            return this;
        }

        /**
         * Setter for startDate.
         * @param  startDate  String value for startDate.
         * @return Builder
         */
        public Builder startDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        /**
         * Setter for canceledDate.
         * @param  canceledDate  String value for canceledDate.
         * @return Builder
         */
        public Builder canceledDate(String canceledDate) {
            this.canceledDate = canceledDate;
            return this;
        }

        /**
         * Setter for taxPercentage.
         * @param  taxPercentage  String value for taxPercentage.
         * @return Builder
         */
        public Builder taxPercentage(String taxPercentage) {
            this.taxPercentage = taxPercentage;
            return this;
        }

        /**
         * Setter for priceOverrideMoney.
         * @param  priceOverrideMoney  Money value for priceOverrideMoney.
         * @return Builder
         */
        public Builder priceOverrideMoney(Money priceOverrideMoney) {
            this.priceOverrideMoney = priceOverrideMoney;
            return this;
        }

        /**
         * Setter for cardId.
         * @param  cardId  String value for cardId.
         * @return Builder
         */
        public Builder cardId(String cardId) {
            this.cardId = cardId;
            return this;
        }

        /**
         * Setter for timezone.
         * @param  timezone  String value for timezone.
         * @return Builder
         */
        public Builder timezone(String timezone) {
            this.timezone = timezone;
            return this;
        }

        /**
         * Setter for source.
         * @param  source  SubscriptionSource value for source.
         * @return Builder
         */
        public Builder source(SubscriptionSource source) {
            this.source = source;
            return this;
        }

        /**
         * Setter for phases.
         * @param  phases  List of Phase value for phases.
         * @return Builder
         */
        public Builder phases(List<Phase> phases) {
            this.phases = phases;
            return this;
        }

        /**
         * Builds a new {@link CreateSubscriptionRequest} object using the set fields.
         * @return {@link CreateSubscriptionRequest}
         */
        public CreateSubscriptionRequest build() {
            return new CreateSubscriptionRequest(locationId, customerId, idempotencyKey,
                    planVariationId, startDate, canceledDate, taxPercentage, priceOverrideMoney,
                    cardId, timezone, source, phases);
        }
    }
}
