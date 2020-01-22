package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for OrderFulfillmentRecipient type.
 */
public class OrderFulfillmentRecipient {

    /**
     * Initialization constructor.
     * @param customerId
     * @param displayName
     * @param emailAddress
     * @param phoneNumber
     * @param address
     */
    @JsonCreator
    public OrderFulfillmentRecipient(
            @JsonProperty("customer_id") String customerId,
            @JsonProperty("display_name") String displayName,
            @JsonProperty("email_address") String emailAddress,
            @JsonProperty("phone_number") String phoneNumber,
            @JsonProperty("address") Address address) {
        this.customerId = customerId;
        this.displayName = displayName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    private final String customerId;
    private final String displayName;
    private final String emailAddress;
    private final String phoneNumber;
    private final Address address;
    /**
     * Getter for CustomerId.
     * The Customer ID of the customer associated with the fulfillment.
     * If `customer_id` is provided, the fulfillment recipient's `display_name`,
     * `email_address`, and `phone_number` are automatically populated from the
     * targeted customer profile. If these fields are set in the request, the request
     * values will override the information from the customer profile. If the
     * targeted customer profile does not contain the necessary information and
     * these fields are left unset, the request will result in an error.
     */
    @JsonGetter("customer_id")
    public String getCustomerId() {
        return this.customerId;
    }

    /**
     * Getter for DisplayName.
     * The display name of the fulfillment recipient.
     * If provided, overrides the value pulled from the customer profile indicated by `customer_id`.
     */
    @JsonGetter("display_name")
    public String getDisplayName() {
        return this.displayName;
    }

    /**
     * Getter for EmailAddress.
     * The email address of the fulfillment recipient.
     * If provided, overrides the value pulled from the customer profile indicated by `customer_id`.
     */
    @JsonGetter("email_address")
    public String getEmailAddress() {
        return this.emailAddress;
    }

    /**
     * Getter for PhoneNumber.
     * The phone number of the fulfillment recipient.
     * If provided, overrides the value pulled from the customer profile indicated by `customer_id`.
     */
    @JsonGetter("phone_number")
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Getter for Address.
     * Represents a physical address.
     */
    @JsonGetter("address")
    public Address getAddress() {
        return this.address;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(customerId, displayName, emailAddress, phoneNumber, address);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof OrderFulfillmentRecipient)) {
            return false;
        }
        OrderFulfillmentRecipient orderFulfillmentRecipient = (OrderFulfillmentRecipient) obj;
        return Objects.equals(customerId, orderFulfillmentRecipient.customerId) &&
            Objects.equals(displayName, orderFulfillmentRecipient.displayName) &&
            Objects.equals(emailAddress, orderFulfillmentRecipient.emailAddress) &&
            Objects.equals(phoneNumber, orderFulfillmentRecipient.phoneNumber) &&
            Objects.equals(address, orderFulfillmentRecipient.address);
    }

    /**
     * Builds a new {@link OrderFulfillmentRecipient.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderFulfillmentRecipient.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .customerId(getCustomerId())
            .displayName(getDisplayName())
            .emailAddress(getEmailAddress())
            .phoneNumber(getPhoneNumber())
            .address(getAddress());
            return builder;
    }

    /**
     * Class to build instances of {@link OrderFulfillmentRecipient}
     */
    public static class Builder {
        private String customerId;
        private String displayName;
        private String emailAddress;
        private String phoneNumber;
        private Address address;

        /**
         * Initialization constructor
         */
        public Builder() {
           
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
         * Setter for displayName
         * @param displayName
         * @return Builder
         */
        public Builder displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }
        /**
         * Setter for emailAddress
         * @param emailAddress
         * @return Builder
         */
        public Builder emailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }
        /**
         * Setter for phoneNumber
         * @param phoneNumber
         * @return Builder
         */
        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
        /**
         * Setter for address
         * @param address
         * @return Builder
         */
        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        /**
         * Builds a new {@link OrderFulfillmentRecipient} object using the set fields.
         * @return {@link OrderFulfillmentRecipient}
         */
        public OrderFulfillmentRecipient build() {
            return new OrderFulfillmentRecipient(customerId,
                displayName,
                emailAddress,
                phoneNumber,
                address);
        }
    }
}
