
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for Subscription type.
 */
public class Subscription {
    private final String id;
    private final String locationId;
    private final String planVariationId;
    private final String customerId;
    private final String startDate;
    private final OptionalNullable<String> canceledDate;
    private final String chargedThroughDate;
    private final String status;
    private final OptionalNullable<String> taxPercentage;
    private final List<String> invoiceIds;
    private final Money priceOverrideMoney;
    private final Long version;
    private final String createdAt;
    private final OptionalNullable<String> cardId;
    private final String timezone;
    private final SubscriptionSource source;
    private final OptionalNullable<List<SubscriptionAction>> actions;
    private final List<Phase> phases;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  locationId  String value for locationId.
     * @param  planVariationId  String value for planVariationId.
     * @param  customerId  String value for customerId.
     * @param  startDate  String value for startDate.
     * @param  canceledDate  String value for canceledDate.
     * @param  chargedThroughDate  String value for chargedThroughDate.
     * @param  status  String value for status.
     * @param  taxPercentage  String value for taxPercentage.
     * @param  invoiceIds  List of String value for invoiceIds.
     * @param  priceOverrideMoney  Money value for priceOverrideMoney.
     * @param  version  Long value for version.
     * @param  createdAt  String value for createdAt.
     * @param  cardId  String value for cardId.
     * @param  timezone  String value for timezone.
     * @param  source  SubscriptionSource value for source.
     * @param  actions  List of SubscriptionAction value for actions.
     * @param  phases  List of Phase value for phases.
     */
    @JsonCreator
    public Subscription(
            @JsonProperty("id") String id,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("plan_variation_id") String planVariationId,
            @JsonProperty("customer_id") String customerId,
            @JsonProperty("start_date") String startDate,
            @JsonProperty("canceled_date") String canceledDate,
            @JsonProperty("charged_through_date") String chargedThroughDate,
            @JsonProperty("status") String status,
            @JsonProperty("tax_percentage") String taxPercentage,
            @JsonProperty("invoice_ids") List<String> invoiceIds,
            @JsonProperty("price_override_money") Money priceOverrideMoney,
            @JsonProperty("version") Long version,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("card_id") String cardId,
            @JsonProperty("timezone") String timezone,
            @JsonProperty("source") SubscriptionSource source,
            @JsonProperty("actions") List<SubscriptionAction> actions,
            @JsonProperty("phases") List<Phase> phases) {
        this.id = id;
        this.locationId = locationId;
        this.planVariationId = planVariationId;
        this.customerId = customerId;
        this.startDate = startDate;
        this.canceledDate = OptionalNullable.of(canceledDate);
        this.chargedThroughDate = chargedThroughDate;
        this.status = status;
        this.taxPercentage = OptionalNullable.of(taxPercentage);
        this.invoiceIds = invoiceIds;
        this.priceOverrideMoney = priceOverrideMoney;
        this.version = version;
        this.createdAt = createdAt;
        this.cardId = OptionalNullable.of(cardId);
        this.timezone = timezone;
        this.source = source;
        this.actions = OptionalNullable.of(actions);
        this.phases = phases;
    }

    /**
     * Internal initialization constructor.
     */
    protected Subscription(String id, String locationId, String planVariationId, String customerId,
            String startDate, OptionalNullable<String> canceledDate, String chargedThroughDate,
            String status, OptionalNullable<String> taxPercentage, List<String> invoiceIds,
            Money priceOverrideMoney, Long version, String createdAt,
            OptionalNullable<String> cardId, String timezone, SubscriptionSource source,
            OptionalNullable<List<SubscriptionAction>> actions, List<Phase> phases) {
        this.id = id;
        this.locationId = locationId;
        this.planVariationId = planVariationId;
        this.customerId = customerId;
        this.startDate = startDate;
        this.canceledDate = canceledDate;
        this.chargedThroughDate = chargedThroughDate;
        this.status = status;
        this.taxPercentage = taxPercentage;
        this.invoiceIds = invoiceIds;
        this.priceOverrideMoney = priceOverrideMoney;
        this.version = version;
        this.createdAt = createdAt;
        this.cardId = cardId;
        this.timezone = timezone;
        this.source = source;
        this.actions = actions;
        this.phases = phases;
    }

    /**
     * Getter for Id.
     * The Square-assigned ID of the subscription.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Getter for LocationId.
     * The ID of the location associated with the subscription.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for PlanVariationId.
     * The ID of the subscribed-to [subscription plan
     * variation](entity:CatalogSubscriptionPlanVariation).
     * @return Returns the String
     */
    @JsonGetter("plan_variation_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPlanVariationId() {
        return planVariationId;
    }

    /**
     * Getter for CustomerId.
     * The ID of the subscribing [customer](entity:Customer) profile.
     * @return Returns the String
     */
    @JsonGetter("customer_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Getter for StartDate.
     * The `YYYY-MM-DD`-formatted date (for example, 2013-01-15) to start the subscription.
     * @return Returns the String
     */
    @JsonGetter("start_date")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStartDate() {
        return startDate;
    }

    /**
     * Internal Getter for CanceledDate.
     * The `YYYY-MM-DD`-formatted date (for example, 2013-01-15) to cancel the subscription, when
     * the subscription status changes to `CANCELED` and the subscription billing stops. If this
     * field is not set, the subscription ends according its subscription plan. This field cannot be
     * updated, other than being cleared.
     * @return Returns the Internal String
     */
    @JsonGetter("canceled_date")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCanceledDate() {
        return this.canceledDate;
    }

    /**
     * Getter for CanceledDate.
     * The `YYYY-MM-DD`-formatted date (for example, 2013-01-15) to cancel the subscription, when
     * the subscription status changes to `CANCELED` and the subscription billing stops. If this
     * field is not set, the subscription ends according its subscription plan. This field cannot be
     * updated, other than being cleared.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCanceledDate() {
        return OptionalNullable.getFrom(canceledDate);
    }

    /**
     * Getter for ChargedThroughDate.
     * The `YYYY-MM-DD`-formatted date up to when the subscriber is invoiced for the subscription.
     * After the invoice is sent for a given billing period, this date will be the last day of the
     * billing period. For example, suppose for the month of May a subscriber gets an invoice (or
     * charged the card) on May 1. For the monthly billing scenario, this date is then set to May
     * 31.
     * @return Returns the String
     */
    @JsonGetter("charged_through_date")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getChargedThroughDate() {
        return chargedThroughDate;
    }

    /**
     * Getter for Status.
     * Supported subscription statuses.
     * @return Returns the String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStatus() {
        return status;
    }

    /**
     * Internal Getter for TaxPercentage.
     * The tax amount applied when billing the subscription. The percentage is expressed in decimal
     * form, using a `'.'` as the decimal separator and without a `'%'` sign. For example, a value
     * of `7.5` corresponds to 7.5%.
     * @return Returns the Internal String
     */
    @JsonGetter("tax_percentage")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetTaxPercentage() {
        return this.taxPercentage;
    }

    /**
     * Getter for TaxPercentage.
     * The tax amount applied when billing the subscription. The percentage is expressed in decimal
     * form, using a `'.'` as the decimal separator and without a `'%'` sign. For example, a value
     * of `7.5` corresponds to 7.5%.
     * @return Returns the String
     */
    @JsonIgnore
    public String getTaxPercentage() {
        return OptionalNullable.getFrom(taxPercentage);
    }

    /**
     * Getter for InvoiceIds.
     * The IDs of the [invoices](entity:Invoice) created for the subscription, listed in order when
     * the invoices were created (newest invoices appear first).
     * @return Returns the List of String
     */
    @JsonGetter("invoice_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<String> getInvoiceIds() {
        return invoiceIds;
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
     * Getter for Version.
     * The version of the object. When updating an object, the version supplied must match the
     * version in the database, otherwise the write will be rejected as conflicting.
     * @return Returns the Long
     */
    @JsonGetter("version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Long getVersion() {
        return version;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the subscription was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Internal Getter for CardId.
     * The ID of the [subscriber's](entity:Customer) [card](entity:Card) used to charge for the
     * subscription.
     * @return Returns the Internal String
     */
    @JsonGetter("card_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCardId() {
        return this.cardId;
    }

    /**
     * Getter for CardId.
     * The ID of the [subscriber's](entity:Customer) [card](entity:Card) used to charge for the
     * subscription.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCardId() {
        return OptionalNullable.getFrom(cardId);
    }

    /**
     * Getter for Timezone.
     * Timezone that will be used in date calculations for the subscription. Defaults to the
     * timezone of the location based on `location_id`. Format: the IANA Timezone Database
     * identifier for the location timezone (for example, `America/Los_Angeles`).
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
     * Internal Getter for Actions.
     * The list of scheduled actions on this subscription. It is set only in the response from
     * [RetrieveSubscription]($e/Subscriptions/RetrieveSubscription) with the query parameter of
     * `include=actions` or from [SearchSubscriptions]($e/Subscriptions/SearchSubscriptions) with
     * the input parameter of `include:["actions"]`.
     * @return Returns the Internal List of SubscriptionAction
     */
    @JsonGetter("actions")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<SubscriptionAction>> internalGetActions() {
        return this.actions;
    }

    /**
     * Getter for Actions.
     * The list of scheduled actions on this subscription. It is set only in the response from
     * [RetrieveSubscription]($e/Subscriptions/RetrieveSubscription) with the query parameter of
     * `include=actions` or from [SearchSubscriptions]($e/Subscriptions/SearchSubscriptions) with
     * the input parameter of `include:["actions"]`.
     * @return Returns the List of SubscriptionAction
     */
    @JsonIgnore
    public List<SubscriptionAction> getActions() {
        return OptionalNullable.getFrom(actions);
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
        return Objects.hash(id, locationId, planVariationId, customerId, startDate, canceledDate,
                chargedThroughDate, status, taxPercentage, invoiceIds, priceOverrideMoney, version,
                createdAt, cardId, timezone, source, actions, phases);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Subscription)) {
            return false;
        }
        Subscription other = (Subscription) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(planVariationId, other.planVariationId)
            && Objects.equals(customerId, other.customerId)
            && Objects.equals(startDate, other.startDate)
            && Objects.equals(canceledDate, other.canceledDate)
            && Objects.equals(chargedThroughDate, other.chargedThroughDate)
            && Objects.equals(status, other.status)
            && Objects.equals(taxPercentage, other.taxPercentage)
            && Objects.equals(invoiceIds, other.invoiceIds)
            && Objects.equals(priceOverrideMoney, other.priceOverrideMoney)
            && Objects.equals(version, other.version)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(cardId, other.cardId)
            && Objects.equals(timezone, other.timezone)
            && Objects.equals(source, other.source)
            && Objects.equals(actions, other.actions)
            && Objects.equals(phases, other.phases);
    }

    /**
     * Converts this Subscription into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Subscription [" + "id=" + id + ", locationId=" + locationId + ", planVariationId="
                + planVariationId + ", customerId=" + customerId + ", startDate=" + startDate
                + ", canceledDate=" + canceledDate + ", chargedThroughDate=" + chargedThroughDate
                + ", status=" + status + ", taxPercentage=" + taxPercentage + ", invoiceIds="
                + invoiceIds + ", priceOverrideMoney=" + priceOverrideMoney + ", version=" + version
                + ", createdAt=" + createdAt + ", cardId=" + cardId + ", timezone=" + timezone
                + ", source=" + source + ", actions=" + actions + ", phases=" + phases + "]";
    }

    /**
     * Builds a new {@link Subscription.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Subscription.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .locationId(getLocationId())
                .planVariationId(getPlanVariationId())
                .customerId(getCustomerId())
                .startDate(getStartDate())
                .chargedThroughDate(getChargedThroughDate())
                .status(getStatus())
                .invoiceIds(getInvoiceIds())
                .priceOverrideMoney(getPriceOverrideMoney())
                .version(getVersion())
                .createdAt(getCreatedAt())
                .timezone(getTimezone())
                .source(getSource())
                .phases(getPhases());
        builder.canceledDate = internalGetCanceledDate();
        builder.taxPercentage = internalGetTaxPercentage();
        builder.cardId = internalGetCardId();
        builder.actions = internalGetActions();
        return builder;
    }

    /**
     * Class to build instances of {@link Subscription}.
     */
    public static class Builder {
        private String id;
        private String locationId;
        private String planVariationId;
        private String customerId;
        private String startDate;
        private OptionalNullable<String> canceledDate;
        private String chargedThroughDate;
        private String status;
        private OptionalNullable<String> taxPercentage;
        private List<String> invoiceIds;
        private Money priceOverrideMoney;
        private Long version;
        private String createdAt;
        private OptionalNullable<String> cardId;
        private String timezone;
        private SubscriptionSource source;
        private OptionalNullable<List<SubscriptionAction>> actions;
        private List<Phase> phases;



        /**
         * Setter for id.
         * @param  id  String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
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
         * Setter for planVariationId.
         * @param  planVariationId  String value for planVariationId.
         * @return Builder
         */
        public Builder planVariationId(String planVariationId) {
            this.planVariationId = planVariationId;
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
            this.canceledDate = OptionalNullable.of(canceledDate);
            return this;
        }

        /**
         * UnSetter for canceledDate.
         * @return Builder
         */
        public Builder unsetCanceledDate() {
            canceledDate = null;
            return this;
        }

        /**
         * Setter for chargedThroughDate.
         * @param  chargedThroughDate  String value for chargedThroughDate.
         * @return Builder
         */
        public Builder chargedThroughDate(String chargedThroughDate) {
            this.chargedThroughDate = chargedThroughDate;
            return this;
        }

        /**
         * Setter for status.
         * @param  status  String value for status.
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Setter for taxPercentage.
         * @param  taxPercentage  String value for taxPercentage.
         * @return Builder
         */
        public Builder taxPercentage(String taxPercentage) {
            this.taxPercentage = OptionalNullable.of(taxPercentage);
            return this;
        }

        /**
         * UnSetter for taxPercentage.
         * @return Builder
         */
        public Builder unsetTaxPercentage() {
            taxPercentage = null;
            return this;
        }

        /**
         * Setter for invoiceIds.
         * @param  invoiceIds  List of String value for invoiceIds.
         * @return Builder
         */
        public Builder invoiceIds(List<String> invoiceIds) {
            this.invoiceIds = invoiceIds;
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
         * Setter for version.
         * @param  version  Long value for version.
         * @return Builder
         */
        public Builder version(Long version) {
            this.version = version;
            return this;
        }

        /**
         * Setter for createdAt.
         * @param  createdAt  String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for cardId.
         * @param  cardId  String value for cardId.
         * @return Builder
         */
        public Builder cardId(String cardId) {
            this.cardId = OptionalNullable.of(cardId);
            return this;
        }

        /**
         * UnSetter for cardId.
         * @return Builder
         */
        public Builder unsetCardId() {
            cardId = null;
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
         * Setter for actions.
         * @param  actions  List of SubscriptionAction value for actions.
         * @return Builder
         */
        public Builder actions(List<SubscriptionAction> actions) {
            this.actions = OptionalNullable.of(actions);
            return this;
        }

        /**
         * UnSetter for actions.
         * @return Builder
         */
        public Builder unsetActions() {
            actions = null;
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
         * Builds a new {@link Subscription} object using the set fields.
         * @return {@link Subscription}
         */
        public Subscription build() {
            return new Subscription(id, locationId, planVariationId, customerId, startDate,
                    canceledDate, chargedThroughDate, status, taxPercentage, invoiceIds,
                    priceOverrideMoney, version, createdAt, cardId, timezone, source, actions,
                    phases);
        }
    }
}
