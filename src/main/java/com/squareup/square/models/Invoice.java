
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for Invoice type.
 */
public class Invoice {
    private final String id;
    private final Integer version;
    private final String locationId;
    private final String orderId;
    private final InvoiceRecipient primaryRecipient;
    private final List<InvoicePaymentRequest> paymentRequests;
    private final String deliveryMethod;
    private final String invoiceNumber;
    private final String title;
    private final String description;
    private final String scheduledAt;
    private final String publicUrl;
    private final Money nextPaymentAmountMoney;
    private final String status;
    private final String timezone;
    private final String createdAt;
    private final String updatedAt;
    private final InvoiceAcceptedPaymentMethods acceptedPaymentMethods;
    private final List<InvoiceCustomField> customFields;
    private final String subscriptionId;
    private final String saleOrServiceDate;
    private final String paymentConditions;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  version  Integer value for version.
     * @param  locationId  String value for locationId.
     * @param  orderId  String value for orderId.
     * @param  primaryRecipient  InvoiceRecipient value for primaryRecipient.
     * @param  paymentRequests  List of InvoicePaymentRequest value for paymentRequests.
     * @param  deliveryMethod  String value for deliveryMethod.
     * @param  invoiceNumber  String value for invoiceNumber.
     * @param  title  String value for title.
     * @param  description  String value for description.
     * @param  scheduledAt  String value for scheduledAt.
     * @param  publicUrl  String value for publicUrl.
     * @param  nextPaymentAmountMoney  Money value for nextPaymentAmountMoney.
     * @param  status  String value for status.
     * @param  timezone  String value for timezone.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  acceptedPaymentMethods  InvoiceAcceptedPaymentMethods value for
     *         acceptedPaymentMethods.
     * @param  customFields  List of InvoiceCustomField value for customFields.
     * @param  subscriptionId  String value for subscriptionId.
     * @param  saleOrServiceDate  String value for saleOrServiceDate.
     * @param  paymentConditions  String value for paymentConditions.
     */
    @JsonCreator
    public Invoice(
            @JsonProperty("id") String id,
            @JsonProperty("version") Integer version,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("order_id") String orderId,
            @JsonProperty("primary_recipient") InvoiceRecipient primaryRecipient,
            @JsonProperty("payment_requests") List<InvoicePaymentRequest> paymentRequests,
            @JsonProperty("delivery_method") String deliveryMethod,
            @JsonProperty("invoice_number") String invoiceNumber,
            @JsonProperty("title") String title,
            @JsonProperty("description") String description,
            @JsonProperty("scheduled_at") String scheduledAt,
            @JsonProperty("public_url") String publicUrl,
            @JsonProperty("next_payment_amount_money") Money nextPaymentAmountMoney,
            @JsonProperty("status") String status,
            @JsonProperty("timezone") String timezone,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("accepted_payment_methods") InvoiceAcceptedPaymentMethods acceptedPaymentMethods,
            @JsonProperty("custom_fields") List<InvoiceCustomField> customFields,
            @JsonProperty("subscription_id") String subscriptionId,
            @JsonProperty("sale_or_service_date") String saleOrServiceDate,
            @JsonProperty("payment_conditions") String paymentConditions) {
        this.id = id;
        this.version = version;
        this.locationId = locationId;
        this.orderId = orderId;
        this.primaryRecipient = primaryRecipient;
        this.paymentRequests = paymentRequests;
        this.deliveryMethod = deliveryMethod;
        this.invoiceNumber = invoiceNumber;
        this.title = title;
        this.description = description;
        this.scheduledAt = scheduledAt;
        this.publicUrl = publicUrl;
        this.nextPaymentAmountMoney = nextPaymentAmountMoney;
        this.status = status;
        this.timezone = timezone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.acceptedPaymentMethods = acceptedPaymentMethods;
        this.customFields = customFields;
        this.subscriptionId = subscriptionId;
        this.saleOrServiceDate = saleOrServiceDate;
        this.paymentConditions = paymentConditions;
    }

    /**
     * Getter for Id.
     * The Square-assigned ID of the invoice.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Getter for Version.
     * The Square-assigned version number, which is incremented each time an update is committed to
     * the invoice.
     * @return Returns the Integer
     */
    @JsonGetter("version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getVersion() {
        return version;
    }

    /**
     * Getter for LocationId.
     * The ID of the location that this invoice is associated with. If specified in a
     * `CreateInvoice` request, the value must match the `location_id` of the associated order.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for OrderId.
     * The ID of the [order]($m/Order) for which the invoice is created. This field is required when
     * creating an invoice, and the order must be in the `OPEN` state. To view the line items and
     * other information for the associated order, call the [RetrieveOrder]($e/Orders/RetrieveOrder)
     * endpoint using the order ID.
     * @return Returns the String
     */
    @JsonGetter("order_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getOrderId() {
        return orderId;
    }

    /**
     * Getter for PrimaryRecipient.
     * Represents a snapshot of customer data. This object stores customer data that is displayed on
     * the invoice and that Square uses to deliver the invoice. When you provide a customer ID for a
     * draft invoice, Square retrieves the associated customer profile and populates the remaining
     * `InvoiceRecipient` fields. You cannot update these fields after the invoice is published.
     * Square updates the customer ID in response to a merge operation, but does not update other
     * fields.
     * @return Returns the InvoiceRecipient
     */
    @JsonGetter("primary_recipient")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public InvoiceRecipient getPrimaryRecipient() {
        return primaryRecipient;
    }

    /**
     * Getter for PaymentRequests.
     * The payment schedule for the invoice, represented by one or more payment requests that define
     * payment settings, such as amount due and due date. An invoice supports the following payment
     * request combinations: - One balance - One deposit with one balance - 2–12 installments - One
     * deposit with 2–12 installments This field is required when creating an invoice. It must
     * contain at least one payment request. All payment requests for the invoice must equal the
     * total order amount. For more information, see [Payment
     * requests](https://developer.squareup.com/docs/invoices-api/overview#payment-requests). Adding
     * `INSTALLMENT` payment requests to an invoice requires an [Invoices Plus
     * subscription](https://developer.squareup.com/docs/invoices-api/overview#invoices-plus-subscription).
     * @return Returns the List of InvoicePaymentRequest
     */
    @JsonGetter("payment_requests")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<InvoicePaymentRequest> getPaymentRequests() {
        return paymentRequests;
    }

    /**
     * Getter for DeliveryMethod.
     * Indicates how Square delivers the [invoice]($m/Invoice) to the customer.
     * @return Returns the String
     */
    @JsonGetter("delivery_method")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    /**
     * Getter for InvoiceNumber.
     * A user-friendly invoice number that is displayed on the invoice. The value is unique within a
     * location. If not provided when creating an invoice, Square assigns a value. It increments
     * from 1 and is padded with zeros making it 7 characters long (for example, 0000001 and
     * 0000002).
     * @return Returns the String
     */
    @JsonGetter("invoice_number")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * Getter for Title.
     * The title of the invoice, which is displayed on the invoice.
     * @return Returns the String
     */
    @JsonGetter("title")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getTitle() {
        return title;
    }

    /**
     * Getter for Description.
     * The description of the invoice, which is displayed on the invoice.
     * @return Returns the String
     */
    @JsonGetter("description")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDescription() {
        return description;
    }

    /**
     * Getter for ScheduledAt.
     * The timestamp when the invoice is scheduled for processing, in RFC 3339 format. After the
     * invoice is published, Square processes the invoice on the specified date, according to the
     * delivery method and payment request settings. If the field is not set, Square processes the
     * invoice immediately after it is published.
     * @return Returns the String
     */
    @JsonGetter("scheduled_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getScheduledAt() {
        return scheduledAt;
    }

    /**
     * Getter for PublicUrl.
     * The URL of the Square-hosted invoice page. After you publish the invoice using the
     * `PublishInvoice` endpoint, Square hosts the invoice page and returns the page URL in the
     * response.
     * @return Returns the String
     */
    @JsonGetter("public_url")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPublicUrl() {
        return publicUrl;
    }

    /**
     * Getter for NextPaymentAmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("next_payment_amount_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getNextPaymentAmountMoney() {
        return nextPaymentAmountMoney;
    }

    /**
     * Getter for Status.
     * Indicates the status of an invoice.
     * @return Returns the String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStatus() {
        return status;
    }

    /**
     * Getter for Timezone.
     * The time zone used to interpret calendar dates on the invoice, such as `due_date`. When an
     * invoice is created, this field is set to the `timezone` specified for the seller location.
     * The value cannot be changed. For example, a payment `due_date` of 2021-03-09 with a
     * `timezone` of America/Los\_Angeles becomes overdue at midnight on March 9 in
     * America/Los\_Angeles (which equals a UTC timestamp of 2021-03-10T08:00:00Z).
     * @return Returns the String
     */
    @JsonGetter("timezone")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getTimezone() {
        return timezone;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the invoice was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp when the invoice was last updated, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Getter for AcceptedPaymentMethods.
     * The payment methods that customers can use to pay an invoice on the Square-hosted invoice
     * page.
     * @return Returns the InvoiceAcceptedPaymentMethods
     */
    @JsonGetter("accepted_payment_methods")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public InvoiceAcceptedPaymentMethods getAcceptedPaymentMethods() {
        return acceptedPaymentMethods;
    }

    /**
     * Getter for CustomFields.
     * Additional seller-defined fields that are displayed on the invoice. For more information, see
     * [Custom fields](https://developer.squareup.com/docs/invoices-api/overview#custom-fields).
     * Adding custom fields to an invoice requires an [Invoices Plus
     * subscription](https://developer.squareup.com/docs/invoices-api/overview#invoices-plus-subscription).
     * Max: 2 custom fields
     * @return Returns the List of InvoiceCustomField
     */
    @JsonGetter("custom_fields")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<InvoiceCustomField> getCustomFields() {
        return customFields;
    }

    /**
     * Getter for SubscriptionId.
     * The ID of the [subscription]($m/Subscription) associated with the invoice. This field is
     * present only on subscription billing invoices.
     * @return Returns the String
     */
    @JsonGetter("subscription_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getSubscriptionId() {
        return subscriptionId;
    }

    /**
     * Getter for SaleOrServiceDate.
     * The date of the sale or the date that the service is rendered, in `YYYY-MM-DD` format. This
     * field can be used to specify a past or future date which is displayed on the invoice.
     * @return Returns the String
     */
    @JsonGetter("sale_or_service_date")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getSaleOrServiceDate() {
        return saleOrServiceDate;
    }

    /**
     * Getter for PaymentConditions.
     * **France only.** The payment terms and conditions that are displayed on the invoice. For more
     * information, see [Payment
     * conditions](https://developer.squareup.com/docs/invoices-api/overview#payment-conditions).
     * For countries other than France, Square returns an `INVALID_REQUEST_ERROR` with a
     * `BAD_REQUEST` code and "Payment conditions are not supported for this location's country"
     * detail if this field is included in `CreateInvoice` or `UpdateInvoice` requests.
     * @return Returns the String
     */
    @JsonGetter("payment_conditions")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPaymentConditions() {
        return paymentConditions;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, locationId, orderId, primaryRecipient, paymentRequests,
                deliveryMethod, invoiceNumber, title, description, scheduledAt, publicUrl,
                nextPaymentAmountMoney, status, timezone, createdAt, updatedAt,
                acceptedPaymentMethods, customFields, subscriptionId, saleOrServiceDate,
                paymentConditions);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(version, other.version)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(orderId, other.orderId)
            && Objects.equals(primaryRecipient, other.primaryRecipient)
            && Objects.equals(paymentRequests, other.paymentRequests)
            && Objects.equals(deliveryMethod, other.deliveryMethod)
            && Objects.equals(invoiceNumber, other.invoiceNumber)
            && Objects.equals(title, other.title)
            && Objects.equals(description, other.description)
            && Objects.equals(scheduledAt, other.scheduledAt)
            && Objects.equals(publicUrl, other.publicUrl)
            && Objects.equals(nextPaymentAmountMoney, other.nextPaymentAmountMoney)
            && Objects.equals(status, other.status)
            && Objects.equals(timezone, other.timezone)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(updatedAt, other.updatedAt)
            && Objects.equals(acceptedPaymentMethods, other.acceptedPaymentMethods)
            && Objects.equals(customFields, other.customFields)
            && Objects.equals(subscriptionId, other.subscriptionId)
            && Objects.equals(saleOrServiceDate, other.saleOrServiceDate)
            && Objects.equals(paymentConditions, other.paymentConditions);
    }

    /**
     * Converts this Invoice into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Invoice [" + "id=" + id + ", version=" + version + ", locationId=" + locationId
                + ", orderId=" + orderId + ", primaryRecipient=" + primaryRecipient
                + ", paymentRequests=" + paymentRequests + ", deliveryMethod=" + deliveryMethod
                + ", invoiceNumber=" + invoiceNumber + ", title=" + title + ", description="
                + description + ", scheduledAt=" + scheduledAt + ", publicUrl=" + publicUrl
                + ", nextPaymentAmountMoney=" + nextPaymentAmountMoney + ", status=" + status
                + ", timezone=" + timezone + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
                + ", acceptedPaymentMethods=" + acceptedPaymentMethods + ", customFields="
                + customFields + ", subscriptionId=" + subscriptionId + ", saleOrServiceDate="
                + saleOrServiceDate + ", paymentConditions=" + paymentConditions + "]";
    }

    /**
     * Builds a new {@link Invoice.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Invoice.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .version(getVersion())
                .locationId(getLocationId())
                .orderId(getOrderId())
                .primaryRecipient(getPrimaryRecipient())
                .paymentRequests(getPaymentRequests())
                .deliveryMethod(getDeliveryMethod())
                .invoiceNumber(getInvoiceNumber())
                .title(getTitle())
                .description(getDescription())
                .scheduledAt(getScheduledAt())
                .publicUrl(getPublicUrl())
                .nextPaymentAmountMoney(getNextPaymentAmountMoney())
                .status(getStatus())
                .timezone(getTimezone())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt())
                .acceptedPaymentMethods(getAcceptedPaymentMethods())
                .customFields(getCustomFields())
                .subscriptionId(getSubscriptionId())
                .saleOrServiceDate(getSaleOrServiceDate())
                .paymentConditions(getPaymentConditions());
        return builder;
    }

    /**
     * Class to build instances of {@link Invoice}.
     */
    public static class Builder {
        private String id;
        private Integer version;
        private String locationId;
        private String orderId;
        private InvoiceRecipient primaryRecipient;
        private List<InvoicePaymentRequest> paymentRequests;
        private String deliveryMethod;
        private String invoiceNumber;
        private String title;
        private String description;
        private String scheduledAt;
        private String publicUrl;
        private Money nextPaymentAmountMoney;
        private String status;
        private String timezone;
        private String createdAt;
        private String updatedAt;
        private InvoiceAcceptedPaymentMethods acceptedPaymentMethods;
        private List<InvoiceCustomField> customFields;
        private String subscriptionId;
        private String saleOrServiceDate;
        private String paymentConditions;



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
         * Setter for version.
         * @param  version  Integer value for version.
         * @return Builder
         */
        public Builder version(Integer version) {
            this.version = version;
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
         * Setter for orderId.
         * @param  orderId  String value for orderId.
         * @return Builder
         */
        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        /**
         * Setter for primaryRecipient.
         * @param  primaryRecipient  InvoiceRecipient value for primaryRecipient.
         * @return Builder
         */
        public Builder primaryRecipient(InvoiceRecipient primaryRecipient) {
            this.primaryRecipient = primaryRecipient;
            return this;
        }

        /**
         * Setter for paymentRequests.
         * @param  paymentRequests  List of InvoicePaymentRequest value for paymentRequests.
         * @return Builder
         */
        public Builder paymentRequests(List<InvoicePaymentRequest> paymentRequests) {
            this.paymentRequests = paymentRequests;
            return this;
        }

        /**
         * Setter for deliveryMethod.
         * @param  deliveryMethod  String value for deliveryMethod.
         * @return Builder
         */
        public Builder deliveryMethod(String deliveryMethod) {
            this.deliveryMethod = deliveryMethod;
            return this;
        }

        /**
         * Setter for invoiceNumber.
         * @param  invoiceNumber  String value for invoiceNumber.
         * @return Builder
         */
        public Builder invoiceNumber(String invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
            return this;
        }

        /**
         * Setter for title.
         * @param  title  String value for title.
         * @return Builder
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * Setter for description.
         * @param  description  String value for description.
         * @return Builder
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        /**
         * Setter for scheduledAt.
         * @param  scheduledAt  String value for scheduledAt.
         * @return Builder
         */
        public Builder scheduledAt(String scheduledAt) {
            this.scheduledAt = scheduledAt;
            return this;
        }

        /**
         * Setter for publicUrl.
         * @param  publicUrl  String value for publicUrl.
         * @return Builder
         */
        public Builder publicUrl(String publicUrl) {
            this.publicUrl = publicUrl;
            return this;
        }

        /**
         * Setter for nextPaymentAmountMoney.
         * @param  nextPaymentAmountMoney  Money value for nextPaymentAmountMoney.
         * @return Builder
         */
        public Builder nextPaymentAmountMoney(Money nextPaymentAmountMoney) {
            this.nextPaymentAmountMoney = nextPaymentAmountMoney;
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
         * Setter for timezone.
         * @param  timezone  String value for timezone.
         * @return Builder
         */
        public Builder timezone(String timezone) {
            this.timezone = timezone;
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
         * Setter for updatedAt.
         * @param  updatedAt  String value for updatedAt.
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * Setter for acceptedPaymentMethods.
         * @param  acceptedPaymentMethods  InvoiceAcceptedPaymentMethods value for
         *         acceptedPaymentMethods.
         * @return Builder
         */
        public Builder acceptedPaymentMethods(
                InvoiceAcceptedPaymentMethods acceptedPaymentMethods) {
            this.acceptedPaymentMethods = acceptedPaymentMethods;
            return this;
        }

        /**
         * Setter for customFields.
         * @param  customFields  List of InvoiceCustomField value for customFields.
         * @return Builder
         */
        public Builder customFields(List<InvoiceCustomField> customFields) {
            this.customFields = customFields;
            return this;
        }

        /**
         * Setter for subscriptionId.
         * @param  subscriptionId  String value for subscriptionId.
         * @return Builder
         */
        public Builder subscriptionId(String subscriptionId) {
            this.subscriptionId = subscriptionId;
            return this;
        }

        /**
         * Setter for saleOrServiceDate.
         * @param  saleOrServiceDate  String value for saleOrServiceDate.
         * @return Builder
         */
        public Builder saleOrServiceDate(String saleOrServiceDate) {
            this.saleOrServiceDate = saleOrServiceDate;
            return this;
        }

        /**
         * Setter for paymentConditions.
         * @param  paymentConditions  String value for paymentConditions.
         * @return Builder
         */
        public Builder paymentConditions(String paymentConditions) {
            this.paymentConditions = paymentConditions;
            return this;
        }

        /**
         * Builds a new {@link Invoice} object using the set fields.
         * @return {@link Invoice}
         */
        public Invoice build() {
            return new Invoice(id, version, locationId, orderId, primaryRecipient, paymentRequests,
                    deliveryMethod, invoiceNumber, title, description, scheduledAt, publicUrl,
                    nextPaymentAmountMoney, status, timezone, createdAt, updatedAt,
                    acceptedPaymentMethods, customFields, subscriptionId, saleOrServiceDate,
                    paymentConditions);
        }
    }
}
