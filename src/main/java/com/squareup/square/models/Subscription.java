
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for Subscription type.
 */
public class Subscription {
    private final String id;
    private final String locationId;
    private final String planId;
    private final String customerId;
    private final String startDate;
    private final String canceledDate;
    private final String chargedThroughDate;
    private final String status;
    private final String taxPercentage;
    private final List<String> invoiceIds;
    private final Money priceOverrideMoney;
    private final Long version;
    private final String createdAt;
    private final String cardId;
    private final String timezone;
    private final SubscriptionSource source;
    private final List<SubscriptionAction> actions;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  locationId  String value for locationId.
     * @param  planId  String value for planId.
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
     */
    @JsonCreator
    public Subscription(
            @JsonProperty("id") String id,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("plan_id") String planId,
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
            @JsonProperty("actions") List<SubscriptionAction> actions) {
        this.id = id;
        this.locationId = locationId;
        this.planId = planId;
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
     * Getter for PlanId.
     * The ID of the subscribed-to [subscription plan]($m/CatalogSubscriptionPlan).
     * @return Returns the String
     */
    @JsonGetter("plan_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPlanId() {
        return planId;
    }

    /**
     * Getter for CustomerId.
     * The ID of the subscribing [customer]($m/Customer) profile.
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
     * Getter for CanceledDate.
     * The `YYYY-MM-DD`-formatted date (for example, 2013-01-15) to cancel the subscription, when
     * the subscription status changes to `CANCELED` and the subscription billing stops. If this
     * field is not set, the subscription ends according its subscription plan. This field cannot be
     * updated, other than being cleared.
     * @return Returns the String
     */
    @JsonGetter("canceled_date")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCanceledDate() {
        return canceledDate;
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
     * Getter for TaxPercentage.
     * The tax amount applied when billing the subscription. The percentage is expressed in decimal
     * form, using a `'.'` as the decimal separator and without a `'%'` sign. For example, a value
     * of `7.5` corresponds to 7.5%.
     * @return Returns the String
     */
    @JsonGetter("tax_percentage")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getTaxPercentage() {
        return taxPercentage;
    }

    /**
     * Getter for InvoiceIds.
     * The IDs of the [invoices]($m/Invoice) created for the subscription, listed in order when the
     * invoices were created (newest invoices appear first).
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
     * Getter for CardId.
     * The ID of the [subscriber's]($m/Customer) [card]($m/Card) used to charge for the
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
     * Getter for Actions.
     * The list of scheduled actions on this subscription. It is set only in the response from
     * [RetrieveSubscription]($e/Subscriptions/RetrieveSubscription) with the query parameter of
     * `include=actions` or from [SearchSubscriptions]($e/Subscriptions/SearchSubscriptions) with
     * the input parameter of `include:["actions"]`.
     * @return Returns the List of SubscriptionAction
     */
    @JsonGetter("actions")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<SubscriptionAction> getActions() {
        return actions;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, locationId, planId, customerId, startDate, canceledDate,
                chargedThroughDate, status, taxPercentage, invoiceIds, priceOverrideMoney, version,
                createdAt, cardId, timezone, source, actions);
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
            && Objects.equals(planId, other.planId)
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
            && Objects.equals(actions, other.actions);
    }

    /**
     * Converts this Subscription into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Subscription [" + "id=" + id + ", locationId=" + locationId + ", planId=" + planId
                + ", customerId=" + customerId + ", startDate=" + startDate + ", canceledDate="
                + canceledDate + ", chargedThroughDate=" + chargedThroughDate + ", status=" + status
                + ", taxPercentage=" + taxPercentage + ", invoiceIds=" + invoiceIds
                + ", priceOverrideMoney=" + priceOverrideMoney + ", version=" + version
                + ", createdAt=" + createdAt + ", cardId=" + cardId + ", timezone=" + timezone
                + ", source=" + source + ", actions=" + actions + "]";
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
                .planId(getPlanId())
                .customerId(getCustomerId())
                .startDate(getStartDate())
                .canceledDate(getCanceledDate())
                .chargedThroughDate(getChargedThroughDate())
                .status(getStatus())
                .taxPercentage(getTaxPercentage())
                .invoiceIds(getInvoiceIds())
                .priceOverrideMoney(getPriceOverrideMoney())
                .version(getVersion())
                .createdAt(getCreatedAt())
                .cardId(getCardId())
                .timezone(getTimezone())
                .source(getSource())
                .actions(getActions());
        return builder;
    }

    /**
     * Class to build instances of {@link Subscription}.
     */
    public static class Builder {
        private String id;
        private String locationId;
        private String planId;
        private String customerId;
        private String startDate;
        private String canceledDate;
        private String chargedThroughDate;
        private String status;
        private String taxPercentage;
        private List<String> invoiceIds;
        private Money priceOverrideMoney;
        private Long version;
        private String createdAt;
        private String cardId;
        private String timezone;
        private SubscriptionSource source;
        private List<SubscriptionAction> actions;



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
         * Setter for planId.
         * @param  planId  String value for planId.
         * @return Builder
         */
        public Builder planId(String planId) {
            this.planId = planId;
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
            this.canceledDate = canceledDate;
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
            this.taxPercentage = taxPercentage;
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
         * Setter for actions.
         * @param  actions  List of SubscriptionAction value for actions.
         * @return Builder
         */
        public Builder actions(List<SubscriptionAction> actions) {
            this.actions = actions;
            return this;
        }

        /**
         * Builds a new {@link Subscription} object using the set fields.
         * @return {@link Subscription}
         */
        public Subscription build() {
            return new Subscription(id, locationId, planId, customerId, startDate, canceledDate,
                    chargedThroughDate, status, taxPercentage, invoiceIds, priceOverrideMoney,
                    version, createdAt, cardId, timezone, source, actions);
        }
    }
}
