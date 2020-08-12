package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for Subscription type.
 */
public class Subscription {

    /**
     * Initialization constructor.
     * @param id
     * @param locationId
     * @param planId
     * @param customerId
     * @param startDate
     * @param canceledDate
     * @param status
     * @param taxPercentage
     * @param invoiceIds
     * @param priceOverrideMoney
     * @param version
     * @param createdAt
     * @param cardId
     * @param paidUntilDate
     * @param timezone
     */
    @JsonCreator
    public Subscription(
            @JsonProperty("id") String id,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("plan_id") String planId,
            @JsonProperty("customer_id") String customerId,
            @JsonProperty("start_date") String startDate,
            @JsonProperty("canceled_date") String canceledDate,
            @JsonProperty("status") String status,
            @JsonProperty("tax_percentage") String taxPercentage,
            @JsonProperty("invoice_ids") List<String> invoiceIds,
            @JsonProperty("price_override_money") Money priceOverrideMoney,
            @JsonProperty("version") Long version,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("card_id") String cardId,
            @JsonProperty("paid_until_date") String paidUntilDate,
            @JsonProperty("timezone") String timezone) {
        this.id = id;
        this.locationId = locationId;
        this.planId = planId;
        this.customerId = customerId;
        this.startDate = startDate;
        this.canceledDate = canceledDate;
        this.status = status;
        this.taxPercentage = taxPercentage;
        this.invoiceIds = invoiceIds;
        this.priceOverrideMoney = priceOverrideMoney;
        this.version = version;
        this.createdAt = createdAt;
        this.cardId = cardId;
        this.paidUntilDate = paidUntilDate;
        this.timezone = timezone;
    }

    private final String id;
    private final String locationId;
    private final String planId;
    private final String customerId;
    private final String startDate;
    private final String canceledDate;
    private final String status;
    private final String taxPercentage;
    private final List<String> invoiceIds;
    private final Money priceOverrideMoney;
    private final Long version;
    private final String createdAt;
    private final String cardId;
    private final String paidUntilDate;
    private final String timezone;
    /**
     * Getter for Id.
     * The Square-assigned ID of the subscription.
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for LocationId.
     * The ID of the location associated with the subscription.
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

    /**
     * Getter for PlanId.
     * The ID of the associated [subscription plan](#type-catalogsubscriptionplan).
     */
    @JsonGetter("plan_id")
    public String getPlanId() {
        return this.planId;
    }

    /**
     * Getter for CustomerId.
     * The ID of the associated [customer](#type-customer) profile.
     */
    @JsonGetter("customer_id")
    public String getCustomerId() {
        return this.customerId;
    }

    /**
     * Getter for StartDate.
     * The start date of the subscription, in YYYY-MM-DD format (for example,
     * 2013-01-15).
     */
    @JsonGetter("start_date")
    public String getStartDate() {
        return this.startDate;
    }

    /**
     * Getter for CanceledDate.
     * The subscription cancellation date, in YYYY-MM-DD format (for
     * example, 2013-01-15). On this date, the subscription status changes 
     * to `CANCELED` and the subscription billing stops. 
     * If you don't set this field, the subscription plan dictates if and 
     * when subscription ends. 
     * You cannot update this field, you can only clear it.
     */
    @JsonGetter("canceled_date")
    public String getCanceledDate() {
        return this.canceledDate;
    }

    /**
     * Getter for Status.
     * Possible subscription status values.
     */
    @JsonGetter("status")
    public String getStatus() {
        return this.status;
    }

    /**
     * Getter for TaxPercentage.
     * The tax amount applied when billing the subscription. The
     * percentage is expressed in decimal form, using a `'.'` as the decimal
     * separator and without a `'%'` sign. For example, a value of `7.5`
     * corresponds to 7.5%.
     */
    @JsonGetter("tax_percentage")
    public String getTaxPercentage() {
        return this.taxPercentage;
    }

    /**
     * Getter for InvoiceIds.
     * The IDs of the [invoices](#type-invoice) created for the 
     * subscription, listed in order when the invoices were created 
     * (oldest invoices appear first).
     */
    @JsonGetter("invoice_ids")
    public List<String> getInvoiceIds() {
        return this.invoiceIds;
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
     * Getter for Version.
     * The version of the object. When updating an object, the version
     * supplied must match the version in the database, otherwise the write will
     * be rejected as conflicting.
     */
    @JsonGetter("version")
    public Long getVersion() {
        return this.version;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the subscription was created, in RFC 3339 format.
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Getter for CardId.
     * The ID of the [customer](#type-customer) [card](#type-card)
     * that is charged for the subscription.
     */
    @JsonGetter("card_id")
    public String getCardId() {
        return this.cardId;
    }

    /**
     * Getter for PaidUntilDate.
     * The date up to which the customer is invoiced for the
     * subscription, in YYYY-MM-DD format (for example, 2013-01-15).
     * After the invoice is paid for a given billing period,
     * this date will be the last day of the billing period.
     * For example,
     * suppose for the month of May a customer gets an invoice
     * (or charged the card) on May 1. For the monthly billing scenario,
     * this date is then set to May 31.
     */
    @JsonGetter("paid_until_date")
    public String getPaidUntilDate() {
        return this.paidUntilDate;
    }

    /**
     * Getter for Timezone.
     * Timezone that will be used in date calculations for the subscription.
     * Defaults to the timezone of the location based on `location_id`.
     * Format: the IANA Timezone Database identifier for the location timezone (for example, `America/Los_Angeles`).
     */
    @JsonGetter("timezone")
    public String getTimezone() {
        return this.timezone;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, locationId, planId, customerId, startDate, canceledDate, status,
            taxPercentage, invoiceIds, priceOverrideMoney, version, createdAt, cardId, paidUntilDate,
            timezone);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof Subscription)) {
            return false;
        }
        Subscription subscription = (Subscription) obj;
        return Objects.equals(id, subscription.id) &&
            Objects.equals(locationId, subscription.locationId) &&
            Objects.equals(planId, subscription.planId) &&
            Objects.equals(customerId, subscription.customerId) &&
            Objects.equals(startDate, subscription.startDate) &&
            Objects.equals(canceledDate, subscription.canceledDate) &&
            Objects.equals(status, subscription.status) &&
            Objects.equals(taxPercentage, subscription.taxPercentage) &&
            Objects.equals(invoiceIds, subscription.invoiceIds) &&
            Objects.equals(priceOverrideMoney, subscription.priceOverrideMoney) &&
            Objects.equals(version, subscription.version) &&
            Objects.equals(createdAt, subscription.createdAt) &&
            Objects.equals(cardId, subscription.cardId) &&
            Objects.equals(paidUntilDate, subscription.paidUntilDate) &&
            Objects.equals(timezone, subscription.timezone);
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
            .status(getStatus())
            .taxPercentage(getTaxPercentage())
            .invoiceIds(getInvoiceIds())
            .priceOverrideMoney(getPriceOverrideMoney())
            .version(getVersion())
            .createdAt(getCreatedAt())
            .cardId(getCardId())
            .paidUntilDate(getPaidUntilDate())
            .timezone(getTimezone());
            return builder;
    }

    /**
     * Class to build instances of {@link Subscription}
     */
    public static class Builder {
        private String id;
        private String locationId;
        private String planId;
        private String customerId;
        private String startDate;
        private String canceledDate;
        private String status;
        private String taxPercentage;
        private List<String> invoiceIds;
        private Money priceOverrideMoney;
        private Long version;
        private String createdAt;
        private String cardId;
        private String paidUntilDate;
        private String timezone;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for id
         * @param id
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
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
         * Setter for status
         * @param status
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
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
         * Setter for invoiceIds
         * @param invoiceIds
         * @return Builder
         */
        public Builder invoiceIds(List<String> invoiceIds) {
            this.invoiceIds = invoiceIds;
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
         * Setter for version
         * @param version
         * @return Builder
         */
        public Builder version(Long version) {
            this.version = version;
            return this;
        }
        /**
         * Setter for createdAt
         * @param createdAt
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
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
         * Setter for paidUntilDate
         * @param paidUntilDate
         * @return Builder
         */
        public Builder paidUntilDate(String paidUntilDate) {
            this.paidUntilDate = paidUntilDate;
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
         * Builds a new {@link Subscription} object using the set fields.
         * @return {@link Subscription}
         */
        public Subscription build() {
            return new Subscription(id,
                locationId,
                planId,
                customerId,
                startDate,
                canceledDate,
                status,
                taxPercentage,
                invoiceIds,
                priceOverrideMoney,
                version,
                createdAt,
                cardId,
                paidUntilDate,
                timezone);
        }
    }
}
