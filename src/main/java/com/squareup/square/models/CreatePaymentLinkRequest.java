
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CreatePaymentLinkRequest type.
 */
public class CreatePaymentLinkRequest {
    private final String idempotencyKey;
    private final String description;
    private final QuickPay quickPay;
    private final Order order;
    private final CheckoutOptions checkoutOptions;
    private final PrePopulatedData prePopulatedData;
    private final String paymentNote;

    /**
     * Initialization constructor.
     * @param  idempotencyKey  String value for idempotencyKey.
     * @param  description  String value for description.
     * @param  quickPay  QuickPay value for quickPay.
     * @param  order  Order value for order.
     * @param  checkoutOptions  CheckoutOptions value for checkoutOptions.
     * @param  prePopulatedData  PrePopulatedData value for prePopulatedData.
     * @param  paymentNote  String value for paymentNote.
     */
    @JsonCreator
    public CreatePaymentLinkRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("description") String description,
            @JsonProperty("quick_pay") QuickPay quickPay,
            @JsonProperty("order") Order order,
            @JsonProperty("checkout_options") CheckoutOptions checkoutOptions,
            @JsonProperty("pre_populated_data") PrePopulatedData prePopulatedData,
            @JsonProperty("payment_note") String paymentNote) {
        this.idempotencyKey = idempotencyKey;
        this.description = description;
        this.quickPay = quickPay;
        this.order = order;
        this.checkoutOptions = checkoutOptions;
        this.prePopulatedData = prePopulatedData;
        this.paymentNote = paymentNote;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies this `CreatePaymentLinkRequest` request. If you do not
     * provide a unique string (or provide an empty string as the value), the endpoint treats each
     * request as independent. For more information, see
     * [Idempotency](https://developer.squareup.com/docs/working-with-apis/idempotency).
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * Getter for Description.
     * A description of the payment link. You provide this optional description that is useful in
     * your application context. It is not used anywhere.
     * @return Returns the String
     */
    @JsonGetter("description")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDescription() {
        return description;
    }

    /**
     * Getter for QuickPay.
     * Describes an ad hoc item and price to generate a quick pay checkout link. For more
     * information, see [Quick Pay
     * Checkout](https://developer.squareup.com/docs/checkout-api/quick-pay-checkout).
     * @return Returns the QuickPay
     */
    @JsonGetter("quick_pay")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public QuickPay getQuickPay() {
        return quickPay;
    }

    /**
     * Getter for Order.
     * Contains all information related to a single order to process with Square, including line
     * items that specify the products to purchase. `Order` objects also include information about
     * any associated tenders, refunds, and returns. All Connect V2 Transactions have all been
     * converted to Orders including all associated itemization data.
     * @return Returns the Order
     */
    @JsonGetter("order")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Order getOrder() {
        return order;
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
     * Getter for PaymentNote.
     * A note for the payment. After processing the payment, Square adds this note to the resulting
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
        return Objects.hash(idempotencyKey, description, quickPay, order, checkoutOptions,
                prePopulatedData, paymentNote);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreatePaymentLinkRequest)) {
            return false;
        }
        CreatePaymentLinkRequest other = (CreatePaymentLinkRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(description, other.description)
            && Objects.equals(quickPay, other.quickPay)
            && Objects.equals(order, other.order)
            && Objects.equals(checkoutOptions, other.checkoutOptions)
            && Objects.equals(prePopulatedData, other.prePopulatedData)
            && Objects.equals(paymentNote, other.paymentNote);
    }

    /**
     * Converts this CreatePaymentLinkRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreatePaymentLinkRequest [" + "idempotencyKey=" + idempotencyKey + ", description="
                + description + ", quickPay=" + quickPay + ", order=" + order + ", checkoutOptions="
                + checkoutOptions + ", prePopulatedData=" + prePopulatedData + ", paymentNote="
                + paymentNote + "]";
    }

    /**
     * Builds a new {@link CreatePaymentLinkRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreatePaymentLinkRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .idempotencyKey(getIdempotencyKey())
                .description(getDescription())
                .quickPay(getQuickPay())
                .order(getOrder())
                .checkoutOptions(getCheckoutOptions())
                .prePopulatedData(getPrePopulatedData())
                .paymentNote(getPaymentNote());
        return builder;
    }

    /**
     * Class to build instances of {@link CreatePaymentLinkRequest}.
     */
    public static class Builder {
        private String idempotencyKey;
        private String description;
        private QuickPay quickPay;
        private Order order;
        private CheckoutOptions checkoutOptions;
        private PrePopulatedData prePopulatedData;
        private String paymentNote;



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
         * Setter for description.
         * @param  description  String value for description.
         * @return Builder
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        /**
         * Setter for quickPay.
         * @param  quickPay  QuickPay value for quickPay.
         * @return Builder
         */
        public Builder quickPay(QuickPay quickPay) {
            this.quickPay = quickPay;
            return this;
        }

        /**
         * Setter for order.
         * @param  order  Order value for order.
         * @return Builder
         */
        public Builder order(Order order) {
            this.order = order;
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
         * Setter for paymentNote.
         * @param  paymentNote  String value for paymentNote.
         * @return Builder
         */
        public Builder paymentNote(String paymentNote) {
            this.paymentNote = paymentNote;
            return this;
        }

        /**
         * Builds a new {@link CreatePaymentLinkRequest} object using the set fields.
         * @return {@link CreatePaymentLinkRequest}
         */
        public CreatePaymentLinkRequest build() {
            return new CreatePaymentLinkRequest(idempotencyKey, description, quickPay, order,
                    checkoutOptions, prePopulatedData, paymentNote);
        }
    }
}
