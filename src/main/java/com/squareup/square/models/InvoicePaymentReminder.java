package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for InvoicePaymentReminder type.
 */
public class InvoicePaymentReminder {

    /**
     * Initialization constructor.
     * @param uid
     * @param relativeScheduledDays
     * @param message
     * @param status
     * @param sentAt
     */
    @JsonCreator
    public InvoicePaymentReminder(
            @JsonProperty("uid") String uid,
            @JsonProperty("relative_scheduled_days") Integer relativeScheduledDays,
            @JsonProperty("message") String message,
            @JsonProperty("status") String status,
            @JsonProperty("sent_at") String sentAt) {
        this.uid = uid;
        this.relativeScheduledDays = relativeScheduledDays;
        this.message = message;
        this.status = status;
        this.sentAt = sentAt;
    }

    private final String uid;
    private final Integer relativeScheduledDays;
    private final String message;
    private final String status;
    private final String sentAt;
    /**
     * Getter for Uid.
     * A Square-assigned ID that uniquely identifies the reminder within the
     * `InvoicePaymentRequest`.
     */
    @JsonGetter("uid")
    public String getUid() {
        return this.uid;
    }

    /**
     * Getter for RelativeScheduledDays.
     * The number of days before (a negative number) or after (a positive number)
     * the payment request `due_date` when the reminder is sent. For example, -3 indicates that
     * the reminder should be sent 3 days before the payment request `due_date`.
     */
    @JsonGetter("relative_scheduled_days")
    public Integer getRelativeScheduledDays() {
        return this.relativeScheduledDays;
    }

    /**
     * Getter for Message.
     * The reminder message.
     */
    @JsonGetter("message")
    public String getMessage() {
        return this.message;
    }

    /**
     * Getter for Status.
     * The status of a payment request reminder.
     */
    @JsonGetter("status")
    public String getStatus() {
        return this.status;
    }

    /**
     * Getter for SentAt.
     * If sent, the timestamp when the reminder was sent, in RFC 3339 format.
     */
    @JsonGetter("sent_at")
    public String getSentAt() {
        return this.sentAt;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(uid, relativeScheduledDays, message, status, sentAt);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof InvoicePaymentReminder)) {
            return false;
        }
        InvoicePaymentReminder invoicePaymentReminder = (InvoicePaymentReminder) obj;
        return Objects.equals(uid, invoicePaymentReminder.uid) &&
            Objects.equals(relativeScheduledDays, invoicePaymentReminder.relativeScheduledDays) &&
            Objects.equals(message, invoicePaymentReminder.message) &&
            Objects.equals(status, invoicePaymentReminder.status) &&
            Objects.equals(sentAt, invoicePaymentReminder.sentAt);
    }

    /**
     * Builds a new {@link InvoicePaymentReminder.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link InvoicePaymentReminder.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .uid(getUid())
            .relativeScheduledDays(getRelativeScheduledDays())
            .message(getMessage())
            .status(getStatus())
            .sentAt(getSentAt());
            return builder;
    }

    /**
     * Class to build instances of {@link InvoicePaymentReminder}
     */
    public static class Builder {
        private String uid;
        private Integer relativeScheduledDays;
        private String message;
        private String status;
        private String sentAt;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for uid
         * @param uid
         * @return Builder
         */
        public Builder uid(String uid) {
            this.uid = uid;
            return this;
        }
        /**
         * Setter for relativeScheduledDays
         * @param relativeScheduledDays
         * @return Builder
         */
        public Builder relativeScheduledDays(Integer relativeScheduledDays) {
            this.relativeScheduledDays = relativeScheduledDays;
            return this;
        }
        /**
         * Setter for message
         * @param message
         * @return Builder
         */
        public Builder message(String message) {
            this.message = message;
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
         * Setter for sentAt
         * @param sentAt
         * @return Builder
         */
        public Builder sentAt(String sentAt) {
            this.sentAt = sentAt;
            return this;
        }

        /**
         * Builds a new {@link InvoicePaymentReminder} object using the set fields.
         * @return {@link InvoicePaymentReminder}
         */
        public InvoicePaymentReminder build() {
            return new InvoicePaymentReminder(uid,
                relativeScheduledDays,
                message,
                status,
                sentAt);
        }
    }
}
