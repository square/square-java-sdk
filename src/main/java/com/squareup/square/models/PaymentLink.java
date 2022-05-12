
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for PaymentLink type.
 */
public class PaymentLink {
    private final String id;
    private final int version;
    private final String description;
    private final String orderId;
    private final CheckoutOptions checkoutOptions;
    private final PrePopulatedData prePopulatedData;
    private final String url;
    private final String createdAt;
    private final String updatedAt;
    private final String paymentNote;

    /**
     * Initialization constructor.
     * @param  version  int value for version.
     * @param  id  String value for id.
     * @param  description  String value for description.
     * @param  orderId  String value for orderId.
     * @param  checkoutOptions  CheckoutOptions value for checkoutOptions.
     * @param  prePopulatedData  PrePopulatedData value for prePopulatedData.
     * @param  url  String value for url.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  paymentNote  String value for paymentNote.
     */
    @JsonCreator
    public PaymentLink(
            @JsonProperty("version") int version,
            @JsonProperty("id") String id,
            @JsonProperty("description") String description,
            @JsonProperty("order_id") String orderId,
            @JsonProperty("checkout_options") CheckoutOptions checkoutOptions,
            @JsonProperty("pre_populated_data") PrePopulatedData prePopulatedData,
            @JsonProperty("url") String url,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("payment_note") String paymentNote) {
        this.id = id;
        this.version = version;
        this.description = description;
        this.orderId = orderId;
        this.checkoutOptions = checkoutOptions;
        this.prePopulatedData = prePopulatedData;
        this.url = url;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.paymentNote = paymentNote;
    }

    /**
     * Getter for Id.
     * The Square-assigned ID of the payment link.
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
     * the payment link.
     * @return Returns the int
     */
    @JsonGetter("version")
    public int getVersion() {
        return version;
    }

    /**
     * Getter for Description.
     * The optional description of the `payment_link` object. It is primarily for use by your
     * application and is not used anywhere.
     * @return Returns the String
     */
    @JsonGetter("description")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDescription() {
        return description;
    }

    /**
     * Getter for OrderId.
     * The ID of the order associated with the payment link.
     * @return Returns the String
     */
    @JsonGetter("order_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getOrderId() {
        return orderId;
    }

    /**
     * Getter for CheckoutOptions.
     * @return Returns the CheckoutOptions
     */
    @JsonGetter("checkout_options")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CheckoutOptions getCheckoutOptions() {
        return checkoutOptions;
    }

    /**
     * Getter for PrePopulatedData.
     * Describes buyer data to prepopulate in the payment form. For more information, see [Optional
     * Checkout
     * Configurations](https://developer.squareup.com/docs/checkout-api/optional-checkout-configurations).
     * @return Returns the PrePopulatedData
     */
    @JsonGetter("pre_populated_data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public PrePopulatedData getPrePopulatedData() {
        return prePopulatedData;
    }

    /**
     * Getter for Url.
     * The URL of the payment link.
     * @return Returns the String
     */
    @JsonGetter("url")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUrl() {
        return url;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the payment link was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp when the payment link was last updated, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Getter for PaymentNote.
     * An optional note. After Square processes the payment, this note is added to the resulting
     * `Payment`.
     * @return Returns the String
     */
    @JsonGetter("payment_note")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPaymentNote() {
        return paymentNote;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, description, orderId, checkoutOptions, prePopulatedData,
                url, createdAt, updatedAt, paymentNote);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaymentLink)) {
            return false;
        }
        PaymentLink other = (PaymentLink) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(version, other.version)
            && Objects.equals(description, other.description)
            && Objects.equals(orderId, other.orderId)
            && Objects.equals(checkoutOptions, other.checkoutOptions)
            && Objects.equals(prePopulatedData, other.prePopulatedData)
            && Objects.equals(url, other.url)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(updatedAt, other.updatedAt)
            && Objects.equals(paymentNote, other.paymentNote);
    }

    /**
     * Converts this PaymentLink into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "PaymentLink [" + "version=" + version + ", id=" + id + ", description="
                + description + ", orderId=" + orderId + ", checkoutOptions=" + checkoutOptions
                + ", prePopulatedData=" + prePopulatedData + ", url=" + url + ", createdAt="
                + createdAt + ", updatedAt=" + updatedAt + ", paymentNote=" + paymentNote + "]";
    }

    /**
     * Builds a new {@link PaymentLink.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link PaymentLink.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(version)
                .id(getId())
                .description(getDescription())
                .orderId(getOrderId())
                .checkoutOptions(getCheckoutOptions())
                .prePopulatedData(getPrePopulatedData())
                .url(getUrl())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt())
                .paymentNote(getPaymentNote());
        return builder;
    }

    /**
     * Class to build instances of {@link PaymentLink}.
     */
    public static class Builder {
        private int version;
        private String id;
        private String description;
        private String orderId;
        private CheckoutOptions checkoutOptions;
        private PrePopulatedData prePopulatedData;
        private String url;
        private String createdAt;
        private String updatedAt;
        private String paymentNote;

        /**
         * Initialization constructor.
         * @param  version  int value for version.
         */
        public Builder(int version) {
            this.version = version;
        }

        /**
         * Setter for version.
         * @param  version  int value for version.
         * @return Builder
         */
        public Builder version(int version) {
            this.version = version;
            return this;
        }

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
         * Setter for description.
         * @param  description  String value for description.
         * @return Builder
         */
        public Builder description(String description) {
            this.description = description;
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
         * Setter for checkoutOptions.
         * @param  checkoutOptions  CheckoutOptions value for checkoutOptions.
         * @return Builder
         */
        public Builder checkoutOptions(CheckoutOptions checkoutOptions) {
            this.checkoutOptions = checkoutOptions;
            return this;
        }

        /**
         * Setter for prePopulatedData.
         * @param  prePopulatedData  PrePopulatedData value for prePopulatedData.
         * @return Builder
         */
        public Builder prePopulatedData(PrePopulatedData prePopulatedData) {
            this.prePopulatedData = prePopulatedData;
            return this;
        }

        /**
         * Setter for url.
         * @param  url  String value for url.
         * @return Builder
         */
        public Builder url(String url) {
            this.url = url;
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
         * Setter for paymentNote.
         * @param  paymentNote  String value for paymentNote.
         * @return Builder
         */
        public Builder paymentNote(String paymentNote) {
            this.paymentNote = paymentNote;
            return this;
        }

        /**
         * Builds a new {@link PaymentLink} object using the set fields.
         * @return {@link PaymentLink}
         */
        public PaymentLink build() {
            return new PaymentLink(version, id, description, orderId, checkoutOptions,
                    prePopulatedData, url, createdAt, updatedAt, paymentNote);
        }
    }
}
