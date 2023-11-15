
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for FulfillmentRecipient type.
 */
public class FulfillmentRecipient {
    private final OptionalNullable<String> customerId;
    private final OptionalNullable<String> displayName;
    private final OptionalNullable<String> emailAddress;
    private final OptionalNullable<String> phoneNumber;
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
    public FulfillmentRecipient(
            @JsonProperty("customer_id") String customerId,
            @JsonProperty("display_name") String displayName,
            @JsonProperty("email_address") String emailAddress,
            @JsonProperty("phone_number") String phoneNumber,
            @JsonProperty("address") Address address) {
        this.customerId = OptionalNullable.of(customerId);
        this.displayName = OptionalNullable.of(displayName);
        this.emailAddress = OptionalNullable.of(emailAddress);
        this.phoneNumber = OptionalNullable.of(phoneNumber);
        this.address = address;
    }

    /**
     * Initialization constructor.
     * @param  customerId  String value for customerId.
     * @param  displayName  String value for displayName.
     * @param  emailAddress  String value for emailAddress.
     * @param  phoneNumber  String value for phoneNumber.
     * @param  address  Address value for address.
     */

    protected FulfillmentRecipient(OptionalNullable<String> customerId,
            OptionalNullable<String> displayName, OptionalNullable<String> emailAddress,
            OptionalNullable<String> phoneNumber, Address address) {
        this.customerId = customerId;
        this.displayName = displayName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    /**
     * Internal Getter for CustomerId.
     * The ID of the customer associated with the fulfillment. If `customer_id` is provided, the
     * fulfillment recipient's `display_name`, `email_address`, and `phone_number` are automatically
     * populated from the targeted customer profile. If these fields are set in the request, the
     * request values override the information from the customer profile. If the targeted customer
     * profile does not contain the necessary information and these fields are left unset, the
     * request results in an error.
     * @return Returns the Internal String
     */
    @JsonGetter("customer_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCustomerId() {
        return this.customerId;
    }

    /**
     * Getter for CustomerId.
     * The ID of the customer associated with the fulfillment. If `customer_id` is provided, the
     * fulfillment recipient's `display_name`, `email_address`, and `phone_number` are automatically
     * populated from the targeted customer profile. If these fields are set in the request, the
     * request values override the information from the customer profile. If the targeted customer
     * profile does not contain the necessary information and these fields are left unset, the
     * request results in an error.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCustomerId() {
        return OptionalNullable.getFrom(customerId);
    }

    /**
     * Internal Getter for DisplayName.
     * The display name of the fulfillment recipient. This field is required. If provided, the
     * display name overrides the corresponding customer profile value indicated by `customer_id`.
     * @return Returns the Internal String
     */
    @JsonGetter("display_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetDisplayName() {
        return this.displayName;
    }

    /**
     * Getter for DisplayName.
     * The display name of the fulfillment recipient. This field is required. If provided, the
     * display name overrides the corresponding customer profile value indicated by `customer_id`.
     * @return Returns the String
     */
    @JsonIgnore
    public String getDisplayName() {
        return OptionalNullable.getFrom(displayName);
    }

    /**
     * Internal Getter for EmailAddress.
     * The email address of the fulfillment recipient. If provided, the email address overrides the
     * corresponding customer profile value indicated by `customer_id`.
     * @return Returns the Internal String
     */
    @JsonGetter("email_address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetEmailAddress() {
        return this.emailAddress;
    }

    /**
     * Getter for EmailAddress.
     * The email address of the fulfillment recipient. If provided, the email address overrides the
     * corresponding customer profile value indicated by `customer_id`.
     * @return Returns the String
     */
    @JsonIgnore
    public String getEmailAddress() {
        return OptionalNullable.getFrom(emailAddress);
    }

    /**
     * Internal Getter for PhoneNumber.
     * The phone number of the fulfillment recipient. This field is required. If provided, the phone
     * number overrides the corresponding customer profile value indicated by `customer_id`.
     * @return Returns the Internal String
     */
    @JsonGetter("phone_number")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Getter for PhoneNumber.
     * The phone number of the fulfillment recipient. This field is required. If provided, the phone
     * number overrides the corresponding customer profile value indicated by `customer_id`.
     * @return Returns the String
     */
    @JsonIgnore
    public String getPhoneNumber() {
        return OptionalNullable.getFrom(phoneNumber);
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
        if (!(obj instanceof FulfillmentRecipient)) {
            return false;
        }
        FulfillmentRecipient other = (FulfillmentRecipient) obj;
        return Objects.equals(customerId, other.customerId)
            && Objects.equals(displayName, other.displayName)
            && Objects.equals(emailAddress, other.emailAddress)
            && Objects.equals(phoneNumber, other.phoneNumber)
            && Objects.equals(address, other.address);
    }

    /**
     * Converts this FulfillmentRecipient into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "FulfillmentRecipient [" + "customerId=" + customerId + ", displayName="
                + displayName + ", emailAddress=" + emailAddress + ", phoneNumber=" + phoneNumber
                + ", address=" + address + "]";
    }

    /**
     * Builds a new {@link FulfillmentRecipient.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link FulfillmentRecipient.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .address(getAddress());
        builder.customerId = internalGetCustomerId();
        builder.displayName = internalGetDisplayName();
        builder.emailAddress = internalGetEmailAddress();
        builder.phoneNumber = internalGetPhoneNumber();
        return builder;
    }

    /**
     * Class to build instances of {@link FulfillmentRecipient}.
     */
    public static class Builder {
        private OptionalNullable<String> customerId;
        private OptionalNullable<String> displayName;
        private OptionalNullable<String> emailAddress;
        private OptionalNullable<String> phoneNumber;
        private Address address;



        /**
         * Setter for customerId.
         * @param  customerId  String value for customerId.
         * @return Builder
         */
        public Builder customerId(String customerId) {
            this.customerId = OptionalNullable.of(customerId);
            return this;
        }

        /**
         * UnSetter for customerId.
         * @return Builder
         */
        public Builder unsetCustomerId() {
            customerId = null;
            return this;
        }

        /**
         * Setter for displayName.
         * @param  displayName  String value for displayName.
         * @return Builder
         */
        public Builder displayName(String displayName) {
            this.displayName = OptionalNullable.of(displayName);
            return this;
        }

        /**
         * UnSetter for displayName.
         * @return Builder
         */
        public Builder unsetDisplayName() {
            displayName = null;
            return this;
        }

        /**
         * Setter for emailAddress.
         * @param  emailAddress  String value for emailAddress.
         * @return Builder
         */
        public Builder emailAddress(String emailAddress) {
            this.emailAddress = OptionalNullable.of(emailAddress);
            return this;
        }

        /**
         * UnSetter for emailAddress.
         * @return Builder
         */
        public Builder unsetEmailAddress() {
            emailAddress = null;
            return this;
        }

        /**
         * Setter for phoneNumber.
         * @param  phoneNumber  String value for phoneNumber.
         * @return Builder
         */
        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = OptionalNullable.of(phoneNumber);
            return this;
        }

        /**
         * UnSetter for phoneNumber.
         * @return Builder
         */
        public Builder unsetPhoneNumber() {
            phoneNumber = null;
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
         * Builds a new {@link FulfillmentRecipient} object using the set fields.
         * @return {@link FulfillmentRecipient}
         */
        public FulfillmentRecipient build() {
            return new FulfillmentRecipient(customerId, displayName, emailAddress, phoneNumber,
                    address);
        }
    }
}
