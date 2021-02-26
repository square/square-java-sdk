
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer version;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String locationId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String orderId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final InvoiceRecipient primaryRecipient;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<InvoicePaymentRequest> paymentRequests;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String deliveryMethod;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String invoiceNumber;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String title;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String description;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String scheduledAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String publicUrl;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money nextPaymentAmountMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String timezone;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String updatedAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<InvoiceCustomField> customFields;

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
     * @param  customFields  List of InvoiceCustomField value for customFields.
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
            @JsonProperty("custom_fields") List<InvoiceCustomField> customFields) {
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
        this.customFields = customFields;
    }

    /**
     * Getter for Id.
     * The Square-assigned ID of the invoice.
     * @return Returns the String
     */
    @JsonGetter("id")
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
    public Integer getVersion() {
        return version;
    }

    /**
     * Getter for LocationId.
     * The ID of the location that this invoice is associated with. This field is required when
     * creating an invoice.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for OrderId.
     * The ID of the [order](#type-order) for which the invoice is created. This order must be in
     * the `OPEN` state and must belong to the `location_id` specified for this invoice. This field
     * is required when creating an invoice.
     * @return Returns the String
     */
    @JsonGetter("order_id")
    public String getOrderId() {
        return orderId;
    }

    /**
     * Getter for PrimaryRecipient.
     * Provides customer data that Square uses to deliver an invoice.
     * @return Returns the InvoiceRecipient
     */
    @JsonGetter("primary_recipient")
    public InvoiceRecipient getPrimaryRecipient() {
        return primaryRecipient;
    }

    /**
     * Getter for PaymentRequests.
     * The payment schedule for the invoice, represented by one or more payment requests that define
     * payment settings, such as amount due and due date. You can specify a maximum of 13 payment
     * requests, with up to 12 `INSTALLMENT` request types. For more information, see [Payment
     * requests](https://developer.squareup.com/docs/invoices-api/overview#payment-requests). This
     * field is required when creating an invoice. It must contain at least one payment request.
     * @return Returns the List of InvoicePaymentRequest
     */
    @JsonGetter("payment_requests")
    public List<InvoicePaymentRequest> getPaymentRequests() {
        return paymentRequests;
    }

    /**
     * Getter for DeliveryMethod.
     * Indicates how Square delivers the [invoice](#type-Invoice) to the customer.
     * @return Returns the String
     */
    @JsonGetter("delivery_method")
    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    /**
     * Getter for InvoiceNumber.
     * A user-friendly invoice number. The value is unique within a location. If not provided when
     * creating an invoice, Square assigns a value. It increments from 1 and padded with zeros
     * making it 7 characters long for example, 0000001, 0000002.
     * @return Returns the String
     */
    @JsonGetter("invoice_number")
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * Getter for Title.
     * The title of the invoice.
     * @return Returns the String
     */
    @JsonGetter("title")
    public String getTitle() {
        return title;
    }

    /**
     * Getter for Description.
     * The description of the invoice. This is visible to the customer receiving the invoice.
     * @return Returns the String
     */
    @JsonGetter("description")
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
    public Money getNextPaymentAmountMoney() {
        return nextPaymentAmountMoney;
    }

    /**
     * Getter for Status.
     * Indicates the status of an invoice.
     * @return Returns the String
     */
    @JsonGetter("status")
    public String getStatus() {
        return status;
    }

    /**
     * Getter for Timezone.
     * The time zone of the date values (for example, `due_date`) specified in the invoice.
     * @return Returns the String
     */
    @JsonGetter("timezone")
    public String getTimezone() {
        return timezone;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the invoice was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp when the invoice was last updated, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Getter for CustomFields.
     * Additional seller-defined fields to render on the invoice. These fields are visible to
     * sellers and buyers on the Square-hosted invoice page and in emailed or PDF copies of
     * invoices. For more information, see [Custom
     * fields](https://developer.squareup.com/docs/invoices-api/overview#custom-fields). Max: 2
     * custom fields
     * @return Returns the List of InvoiceCustomField
     */
    @JsonGetter("custom_fields")
    public List<InvoiceCustomField> getCustomFields() {
        return customFields;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, locationId, orderId, primaryRecipient, paymentRequests,
                deliveryMethod, invoiceNumber, title, description, scheduledAt, publicUrl,
                nextPaymentAmountMoney, status, timezone, createdAt, updatedAt, customFields);
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
            && Objects.equals(customFields, other.customFields);
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
                + ", customFields=" + customFields + "]";
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
                .customFields(getCustomFields());
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
        private List<InvoiceCustomField> customFields;



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
         * Setter for customFields.
         * @param  customFields  List of InvoiceCustomField value for customFields.
         * @return Builder
         */
        public Builder customFields(List<InvoiceCustomField> customFields) {
            this.customFields = customFields;
            return this;
        }

        /**
         * Builds a new {@link Invoice} object using the set fields.
         * @return {@link Invoice}
         */
        public Invoice build() {
            return new Invoice(id, version, locationId, orderId, primaryRecipient, paymentRequests,
                    deliveryMethod, invoiceNumber, title, description, scheduledAt, publicUrl,
                    nextPaymentAmountMoney, status, timezone, createdAt, updatedAt, customFields);
        }
    }
}
