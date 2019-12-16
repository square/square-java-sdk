package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class OrderFulfillmentRecipient {

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

    @Override
    public int hashCode() {
        return Objects.hash(customerId, displayName, emailAddress, phoneNumber, address);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrderFulfillmentRecipient)) {
            return false;
        }
        OrderFulfillmentRecipient orderFulfillmentRecipient = (OrderFulfillmentRecipient) o;
        return Objects.equals(customerId, orderFulfillmentRecipient.customerId) &&
            Objects.equals(displayName, orderFulfillmentRecipient.displayName) &&
            Objects.equals(emailAddress, orderFulfillmentRecipient.emailAddress) &&
            Objects.equals(phoneNumber, orderFulfillmentRecipient.phoneNumber) &&
            Objects.equals(address, orderFulfillmentRecipient.address);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .customerId(getCustomerId())
            .displayName(getDisplayName())
            .emailAddress(getEmailAddress())
            .phoneNumber(getPhoneNumber())
            .address(getAddress());
            return builder;
    }

    public static class Builder {
        private String customerId;
        private String displayName;
        private String emailAddress;
        private String phoneNumber;
        private Address address;

        public Builder() { }

        public Builder customerId(String value) {
            customerId = value;
            return this;
        }
        public Builder displayName(String value) {
            displayName = value;
            return this;
        }
        public Builder emailAddress(String value) {
            emailAddress = value;
            return this;
        }
        public Builder phoneNumber(String value) {
            phoneNumber = value;
            return this;
        }
        public Builder address(Address value) {
            address = value;
            return this;
        }

        public OrderFulfillmentRecipient build() {
            return new OrderFulfillmentRecipient(customerId,
                displayName,
                emailAddress,
                phoneNumber,
                address);
        }
    }
}
