
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String locationId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String planId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String customerId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String startDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String canceledDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String chargedThroughDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String taxPercentage;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> invoiceIds;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money priceOverrideMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Long version;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cardId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String timezone;

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
            @JsonProperty("timezone") String timezone) {
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
    }

    /**
     * Getter for Id.
     * The Square-assigned ID of the subscription.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return id;
    }

    /**
     * Getter for LocationId.
     * The ID of the location associated with the subscription.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for PlanId.
     * The ID of the associated [subscription plan]($m/CatalogSubscriptionPlan).
     * @return Returns the String
     */
    @JsonGetter("plan_id")
    public String getPlanId() {
        return planId;
    }

    /**
     * Getter for CustomerId.
     * The ID of the associated [customer]($m/Customer) profile.
     * @return Returns the String
     */
    @JsonGetter("customer_id")
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Getter for StartDate.
     * The start date of the subscription, in YYYY-MM-DD format (for example, 2013-01-15).
     * @return Returns the String
     */
    @JsonGetter("start_date")
    public String getStartDate() {
        return startDate;
    }

    /**
     * Getter for CanceledDate.
     * The subscription cancellation date, in YYYY-MM-DD format (for example, 2013-01-15). On this
     * date, the subscription status changes to `CANCELED` and the subscription billing stops. If
     * you don't set this field, the subscription plan dictates if and when subscription ends. You
     * cannot update this field, you can only clear it.
     * @return Returns the String
     */
    @JsonGetter("canceled_date")
    public String getCanceledDate() {
        return canceledDate;
    }

    /**
     * Getter for ChargedThroughDate.
     * The date up to which the customer is invoiced for the subscription, in YYYY-MM-DD format (for
     * example, 2013-01-15). After the invoice is sent for a given billing period, this date will be
     * the last day of the billing period. For example, suppose for the month of May a customer gets
     * an invoice (or charged the card) on May 1. For the monthly billing scenario, this date is
     * then set to May 31.
     * @return Returns the String
     */
    @JsonGetter("charged_through_date")
    public String getChargedThroughDate() {
        return chargedThroughDate;
    }

    /**
     * Getter for Status.
     * Possible subscription status values.
     * @return Returns the String
     */
    @JsonGetter("status")
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
    public String getTaxPercentage() {
        return taxPercentage;
    }

    /**
     * Getter for InvoiceIds.
     * The IDs of the [invoices]($m/Invoice) created for the subscription, listed in order when the
     * invoices were created (oldest invoices appear first).
     * @return Returns the List of String
     */
    @JsonGetter("invoice_ids")
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
    public Long getVersion() {
        return version;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the subscription was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for CardId.
     * The ID of the [customer]($m/Customer) [card]($m/Card) that is charged for the subscription.
     * @return Returns the String
     */
    @JsonGetter("card_id")
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
    public String getTimezone() {
        return timezone;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, locationId, planId, customerId, startDate, canceledDate,
                chargedThroughDate, status, taxPercentage, invoiceIds, priceOverrideMoney, version,
                createdAt, cardId, timezone);
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
            && Objects.equals(timezone, other.timezone);
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
                + "]";
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
                .timezone(getTimezone());
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
         * Builds a new {@link Subscription} object using the set fields.
         * @return {@link Subscription}
         */
        public Subscription build() {
            return new Subscription(id, locationId, planId, customerId, startDate, canceledDate,
                    chargedThroughDate, status, taxPercentage, invoiceIds, priceOverrideMoney,
                    version, createdAt, cardId, timezone);
        }
    }
}
