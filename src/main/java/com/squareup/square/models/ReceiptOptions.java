
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for ReceiptOptions type.
 */
public class ReceiptOptions {
    private final String paymentId;
    private final OptionalNullable<Boolean> printOnly;
    private final OptionalNullable<Boolean> isDuplicate;

    /**
     * Initialization constructor.
     * @param  paymentId  String value for paymentId.
     * @param  printOnly  Boolean value for printOnly.
     * @param  isDuplicate  Boolean value for isDuplicate.
     */
    @JsonCreator
    public ReceiptOptions(
            @JsonProperty("payment_id") String paymentId,
            @JsonProperty("print_only") Boolean printOnly,
            @JsonProperty("is_duplicate") Boolean isDuplicate) {
        this.paymentId = paymentId;
        this.printOnly = OptionalNullable.of(printOnly);
        this.isDuplicate = OptionalNullable.of(isDuplicate);
    }

    /**
     * Internal initialization constructor.
     */
    protected ReceiptOptions(String paymentId, OptionalNullable<Boolean> printOnly,
            OptionalNullable<Boolean> isDuplicate) {
        this.paymentId = paymentId;
        this.printOnly = printOnly;
        this.isDuplicate = isDuplicate;
    }

    /**
     * Getter for PaymentId.
     * The reference to the Square payment ID for the receipt.
     * @return Returns the String
     */
    @JsonGetter("payment_id")
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * Internal Getter for PrintOnly.
     * Instructs the device to print the receipt without displaying the receipt selection screen.
     * Requires `printer_enabled` set to true. Defaults to false.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("print_only")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetPrintOnly() {
        return this.printOnly;
    }

    /**
     * Getter for PrintOnly.
     * Instructs the device to print the receipt without displaying the receipt selection screen.
     * Requires `printer_enabled` set to true. Defaults to false.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getPrintOnly() {
        return OptionalNullable.getFrom(printOnly);
    }

    /**
     * Internal Getter for IsDuplicate.
     * Identify the receipt as a reprint rather than an original receipt. Defaults to false.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("is_duplicate")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetIsDuplicate() {
        return this.isDuplicate;
    }

    /**
     * Getter for IsDuplicate.
     * Identify the receipt as a reprint rather than an original receipt. Defaults to false.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getIsDuplicate() {
        return OptionalNullable.getFrom(isDuplicate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, printOnly, isDuplicate);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReceiptOptions)) {
            return false;
        }
        ReceiptOptions other = (ReceiptOptions) obj;
        return Objects.equals(paymentId, other.paymentId)
            && Objects.equals(printOnly, other.printOnly)
            && Objects.equals(isDuplicate, other.isDuplicate);
    }

    /**
     * Converts this ReceiptOptions into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ReceiptOptions [" + "paymentId=" + paymentId + ", printOnly=" + printOnly
                + ", isDuplicate=" + isDuplicate + "]";
    }

    /**
     * Builds a new {@link ReceiptOptions.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ReceiptOptions.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(paymentId);
        builder.printOnly = internalGetPrintOnly();
        builder.isDuplicate = internalGetIsDuplicate();
        return builder;
    }

    /**
     * Class to build instances of {@link ReceiptOptions}.
     */
    public static class Builder {
        private String paymentId;
        private OptionalNullable<Boolean> printOnly;
        private OptionalNullable<Boolean> isDuplicate;

        /**
         * Initialization constructor.
         * @param  paymentId  String value for paymentId.
         */
        public Builder(String paymentId) {
            this.paymentId = paymentId;
        }

        /**
         * Setter for paymentId.
         * @param  paymentId  String value for paymentId.
         * @return Builder
         */
        public Builder paymentId(String paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        /**
         * Setter for printOnly.
         * @param  printOnly  Boolean value for printOnly.
         * @return Builder
         */
        public Builder printOnly(Boolean printOnly) {
            this.printOnly = OptionalNullable.of(printOnly);
            return this;
        }

        /**
         * UnSetter for printOnly.
         * @return Builder
         */
        public Builder unsetPrintOnly() {
            printOnly = null;
            return this;
        }

        /**
         * Setter for isDuplicate.
         * @param  isDuplicate  Boolean value for isDuplicate.
         * @return Builder
         */
        public Builder isDuplicate(Boolean isDuplicate) {
            this.isDuplicate = OptionalNullable.of(isDuplicate);
            return this;
        }

        /**
         * UnSetter for isDuplicate.
         * @return Builder
         */
        public Builder unsetIsDuplicate() {
            isDuplicate = null;
            return this;
        }

        /**
         * Builds a new {@link ReceiptOptions} object using the set fields.
         * @return {@link ReceiptOptions}
         */
        public ReceiptOptions build() {
            return new ReceiptOptions(paymentId, printOnly, isDuplicate);
        }
    }
}
