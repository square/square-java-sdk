
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CustomerCustomAttributeFilterValue type.
 */
public class CustomerCustomAttributeFilterValue {
    private final CustomerTextFilter email;
    private final CustomerTextFilter phone;
    private final CustomerTextFilter text;
    private final FilterValue selection;
    private final TimeRange date;
    private final FloatNumberRange number;
    private final Boolean mBoolean;
    private final CustomerAddressFilter address;

    /**
     * Initialization constructor.
     * @param  email  CustomerTextFilter value for email.
     * @param  phone  CustomerTextFilter value for phone.
     * @param  text  CustomerTextFilter value for text.
     * @param  selection  FilterValue value for selection.
     * @param  date  TimeRange value for date.
     * @param  number  FloatNumberRange value for number.
     * @param  mBoolean  Boolean value for mBoolean.
     * @param  address  CustomerAddressFilter value for address.
     */
    @JsonCreator
    public CustomerCustomAttributeFilterValue(
            @JsonProperty("email") CustomerTextFilter email,
            @JsonProperty("phone") CustomerTextFilter phone,
            @JsonProperty("text") CustomerTextFilter text,
            @JsonProperty("selection") FilterValue selection,
            @JsonProperty("date") TimeRange date,
            @JsonProperty("number") FloatNumberRange number,
            @JsonProperty("boolean") Boolean mBoolean,
            @JsonProperty("address") CustomerAddressFilter address) {
        this.email = email;
        this.phone = phone;
        this.text = text;
        this.selection = selection;
        this.date = date;
        this.number = number;
        this.mBoolean = mBoolean;
        this.address = address;
    }

    /**
     * Getter for Email.
     * A filter to select customers based on exact or fuzzy matching of customer attributes against
     * a specified query. Depending on the customer attributes, the filter can be case-sensitive.
     * This filter can be exact or fuzzy, but it cannot be both.
     * @return Returns the CustomerTextFilter
     */
    @JsonGetter("email")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CustomerTextFilter getEmail() {
        return email;
    }

    /**
     * Getter for Phone.
     * A filter to select customers based on exact or fuzzy matching of customer attributes against
     * a specified query. Depending on the customer attributes, the filter can be case-sensitive.
     * This filter can be exact or fuzzy, but it cannot be both.
     * @return Returns the CustomerTextFilter
     */
    @JsonGetter("phone")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CustomerTextFilter getPhone() {
        return phone;
    }

    /**
     * Getter for Text.
     * A filter to select customers based on exact or fuzzy matching of customer attributes against
     * a specified query. Depending on the customer attributes, the filter can be case-sensitive.
     * This filter can be exact or fuzzy, but it cannot be both.
     * @return Returns the CustomerTextFilter
     */
    @JsonGetter("text")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CustomerTextFilter getText() {
        return text;
    }

    /**
     * Getter for Selection.
     * A filter to select resources based on an exact field value. For any given value, the value
     * can only be in one property. Depending on the field, either all properties can be set or only
     * a subset will be available. Refer to the documentation of the field.
     * @return Returns the FilterValue
     */
    @JsonGetter("selection")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public FilterValue getSelection() {
        return selection;
    }

    /**
     * Getter for Date.
     * Represents a generic time range. The start and end values are represented in RFC 3339 format.
     * Time ranges are customized to be inclusive or exclusive based on the needs of a particular
     * endpoint. Refer to the relevant endpoint-specific documentation to determine how time ranges
     * are handled.
     * @return Returns the TimeRange
     */
    @JsonGetter("date")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public TimeRange getDate() {
        return date;
    }

    /**
     * Getter for Number.
     * Specifies a decimal number range.
     * @return Returns the FloatNumberRange
     */
    @JsonGetter("number")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public FloatNumberRange getNumber() {
        return number;
    }

    /**
     * Getter for MBoolean.
     * A filter for a query based on the value of a `Boolean`-type custom attribute.
     * @return Returns the Boolean
     */
    @JsonGetter("boolean")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getMBoolean() {
        return mBoolean;
    }

    /**
     * Getter for Address.
     * The customer address filter. This filter is used in a
     * [CustomerCustomAttributeFilterValue]($m/CustomerCustomAttributeFilterValue) filter when
     * searching by an `Address`-type custom attribute.
     * @return Returns the CustomerAddressFilter
     */
    @JsonGetter("address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CustomerAddressFilter getAddress() {
        return address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, phone, text, selection, date, number, mBoolean, address);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CustomerCustomAttributeFilterValue)) {
            return false;
        }
        CustomerCustomAttributeFilterValue other = (CustomerCustomAttributeFilterValue) obj;
        return Objects.equals(email, other.email)
            && Objects.equals(phone, other.phone)
            && Objects.equals(text, other.text)
            && Objects.equals(selection, other.selection)
            && Objects.equals(date, other.date)
            && Objects.equals(number, other.number)
            && Objects.equals(mBoolean, other.mBoolean)
            && Objects.equals(address, other.address);
    }

    /**
     * Converts this CustomerCustomAttributeFilterValue into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CustomerCustomAttributeFilterValue [" + "email=" + email + ", phone=" + phone
                + ", text=" + text + ", selection=" + selection + ", date=" + date + ", number="
                + number + ", mBoolean=" + mBoolean + ", address=" + address + "]";
    }

    /**
     * Builds a new {@link CustomerCustomAttributeFilterValue.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CustomerCustomAttributeFilterValue.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .email(getEmail())
                .phone(getPhone())
                .text(getText())
                .selection(getSelection())
                .date(getDate())
                .number(getNumber())
                .mBoolean(getMBoolean())
                .address(getAddress());
        return builder;
    }

    /**
     * Class to build instances of {@link CustomerCustomAttributeFilterValue}.
     */
    public static class Builder {
        private CustomerTextFilter email;
        private CustomerTextFilter phone;
        private CustomerTextFilter text;
        private FilterValue selection;
        private TimeRange date;
        private FloatNumberRange number;
        private Boolean mBoolean;
        private CustomerAddressFilter address;



        /**
         * Setter for email.
         * @param  email  CustomerTextFilter value for email.
         * @return Builder
         */
        public Builder email(CustomerTextFilter email) {
            this.email = email;
            return this;
        }

        /**
         * Setter for phone.
         * @param  phone  CustomerTextFilter value for phone.
         * @return Builder
         */
        public Builder phone(CustomerTextFilter phone) {
            this.phone = phone;
            return this;
        }

        /**
         * Setter for text.
         * @param  text  CustomerTextFilter value for text.
         * @return Builder
         */
        public Builder text(CustomerTextFilter text) {
            this.text = text;
            return this;
        }

        /**
         * Setter for selection.
         * @param  selection  FilterValue value for selection.
         * @return Builder
         */
        public Builder selection(FilterValue selection) {
            this.selection = selection;
            return this;
        }

        /**
         * Setter for date.
         * @param  date  TimeRange value for date.
         * @return Builder
         */
        public Builder date(TimeRange date) {
            this.date = date;
            return this;
        }

        /**
         * Setter for number.
         * @param  number  FloatNumberRange value for number.
         * @return Builder
         */
        public Builder number(FloatNumberRange number) {
            this.number = number;
            return this;
        }

        /**
         * Setter for mBoolean.
         * @param  mBoolean  Boolean value for mBoolean.
         * @return Builder
         */
        public Builder mBoolean(Boolean mBoolean) {
            this.mBoolean = mBoolean;
            return this;
        }

        /**
         * Setter for address.
         * @param  address  CustomerAddressFilter value for address.
         * @return Builder
         */
        public Builder address(CustomerAddressFilter address) {
            this.address = address;
            return this;
        }

        /**
         * Builds a new {@link CustomerCustomAttributeFilterValue} object using the set fields.
         * @return {@link CustomerCustomAttributeFilterValue}
         */
        public CustomerCustomAttributeFilterValue build() {
            return new CustomerCustomAttributeFilterValue(email, phone, text, selection, date,
                    number, mBoolean, address);
        }
    }
}
