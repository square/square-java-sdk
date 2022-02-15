
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for OrderFulfillmentRecipient type.
 */
public class OrderFulfillmentRecipient {
    private final String customerId;
    private final String displayName;
    private final String emailAddress;
    private final String phoneNumber;
    private final Address address;

    /**
     * Initialization constructor.
     * @param  customerId  String value for customerId.
     * @param  displayName  String value for displayName.
     * @param  emailAddress  String value for emailAddress.
     * @param  phoneNumber  String value for phoneNumber.
     * @param  address  Address value for address.
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

    /**
     * Getter for CustomerId.
     * The customer ID of the customer associated with the fulfillment. If `customer_id` is
     * provided, the fulfillment recipient's `display_name`, `email_address`, and `phone_number` are
     * automatically populated from the targeted customer profile. If these fields are set in the
     * request, the request values overrides the information from the customer profile. If the
     * targeted customer profile does not contain the necessary information and these fields are
     * left unset, the request results in an error.
     * @return Returns the String
     */
    @JsonGetter("customer_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Getter for DisplayName.
     * The display name of the fulfillment recipient. If provided, the display name overrides the
     * value pulled from the customer profile indicated by `customer_id`.
     * @return Returns the String
     */
    @JsonGetter("display_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Getter for EmailAddress.
     * The email address of the fulfillment recipient. If provided, the email address overrides the
     * value pulled from the customer profile indicated by `customer_id`.
     * @return Returns the String
     */
    @JsonGetter("email_address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Getter for PhoneNumber.
     * The phone number of the fulfillment recipient. If provided, the phone number overrides the
     * value pulled from the customer profile indicated by `customer_id`.
     * @return Returns the String
     */
    @JsonGetter("phone_number")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Getter for Address.
     * Represents a postal address in a country. For more information, see [Working with
     * Addresses](https://developer.squareup.com/docs/build-basics/working-with-addresses).
     * @return Returns the Address
     */
    @JsonGetter("address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Address getAddress() {
        return address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, displayName, emailAddress, phoneNumber, address);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderFulfillmentRecipient)) {
            return false;
        }
        OrderFulfillmentRecipient other = (OrderFulfillmentRecipient) obj;
        return Objects.equals(customerId, other.customerId)
            && Objects.equals(displayName, other.displayName)
            && Objects.equals(emailAddress, other.emailAddress)
            && Objects.equals(phoneNumber, other.phoneNumber)
            && Objects.equals(address, other.address);
    }

    /**
     * Converts this OrderFulfillmentRecipient into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderFulfillmentRecipient [" + "customerId=" + customerId + ", displayName="
                + displayName + ", emailAddress=" + emailAddress + ", phoneNumber=" + phoneNumber
                + ", address=" + address + "]";
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
     * Class to build instances of {@link OrderFulfillmentRecipient}.
     */
    public static class Builder {
        private String customerId;
        private String displayName;
        private String emailAddress;
        private String phoneNumber;
        private Address address;



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
         * Setter for displayName.
         * @param  displayName  String value for displayName.
         * @return Builder
         */
        public Builder displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        /**
         * Setter for emailAddress.
         * @param  emailAddress  String value for emailAddress.
         * @return Builder
         */
        public Builder emailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        /**
         * Setter for phoneNumber.
         * @param  phoneNumber  String value for phoneNumber.
         * @return Builder
         */
        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        /**
         * Setter for address.
         * @param  address  Address value for address.
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
            return new OrderFulfillmentRecipient(customerId, displayName, emailAddress, phoneNumber,
                    address);
        }
    }
}
