/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.Nullable;
import com.squareup.square.core.NullableNonemptyFilter;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CustomerCustomAttributeFilterValue.Builder.class)
public final class CustomerCustomAttributeFilterValue {
    private final Optional<CustomerTextFilter> email;

    private final Optional<CustomerTextFilter> phone;

    private final Optional<CustomerTextFilter> text;

    private final Optional<FilterValue> selection;

    private final Optional<TimeRange> date;

    private final Optional<FloatNumberRange> number;

    private final Optional<Boolean> boolean_;

    private final Optional<CustomerAddressFilter> address;

    private final Map<String, Object> additionalProperties;

    private CustomerCustomAttributeFilterValue(
            Optional<CustomerTextFilter> email,
            Optional<CustomerTextFilter> phone,
            Optional<CustomerTextFilter> text,
            Optional<FilterValue> selection,
            Optional<TimeRange> date,
            Optional<FloatNumberRange> number,
            Optional<Boolean> boolean_,
            Optional<CustomerAddressFilter> address,
            Map<String, Object> additionalProperties) {
        this.email = email;
        this.phone = phone;
        this.text = text;
        this.selection = selection;
        this.date = date;
        this.number = number;
        this.boolean_ = boolean_;
        this.address = address;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return A filter for a query based on the value of an <code>Email</code>-type custom attribute. This filter is case-insensitive and can
     * include <code>exact</code> or <code>fuzzy</code>, but not both.
     * <p>For an <code>exact</code> match, provide the complete email address.</p>
     * <p>For a <code>fuzzy</code> match, provide a query expression containing one or more query tokens to match against the email address. Square removes
     * any punctuation (including periods (.), underscores (_), and the @ symbol) and tokenizes the email addresses on spaces. A match is found
     * if a tokenized email address contains all the tokens in the search query, irrespective of the token order. For example, <code>Steven gmail</code>
     * matches steven.jones@gmail.com and mygmail@stevensbakery.com.</p>
     */
    @JsonProperty("email")
    public Optional<CustomerTextFilter> getEmail() {
        return email;
    }

    /**
     * @return A filter for a query based on the value of a <code>PhoneNumber</code>-type custom attribute. This filter is case-insensitive and
     * can include <code>exact</code> or <code>fuzzy</code>, but not both.
     * <p>For an <code>exact</code> match, provide the complete phone number. This is always an E.164-compliant phone number that starts
     * with the + sign followed by the country code and subscriber number. For example, the format for a US phone number is +12061112222.</p>
     * <p>For a <code>fuzzy</code> match, provide a query expression containing one or more query tokens to match against the phone number.
     * Square removes any punctuation and tokenizes the expression on spaces. A match is found if a tokenized phone number contains
     * all the tokens in the search query, irrespective of the token order. For example, <code>415 123 45</code> is tokenized to <code>415</code>, <code>123</code>, and <code>45</code>,
     * which matches +14151234567 and +12345674158, but does not match +1234156780. Similarly, the expression <code>415</code> matches
     * +14151234567, +12345674158, and +1234156780.</p>
     */
    @JsonProperty("phone")
    public Optional<CustomerTextFilter> getPhone() {
        return phone;
    }

    /**
     * @return A filter for a query based on the value of a <code>String</code>-type custom attribute. This filter is case-insensitive and
     * can include <code>exact</code> or <code>fuzzy</code>, but not both.
     * <p>For an <code>exact</code> match, provide the complete string.</p>
     * <p>For a <code>fuzzy</code> match, provide a query expression containing one or more query tokens in any order that contain complete words
     * to match against the string. Square tokenizes the expression using a grammar-based tokenizer. For example, the expressions <code>quick brown</code>,
     * <code>brown quick</code>, and <code>quick fox</code> match &quot;The quick brown fox jumps over the lazy dog&quot;. However, <code>quick foxes</code> and <code>qui</code> do not match.</p>
     */
    @JsonProperty("text")
    public Optional<CustomerTextFilter> getText() {
        return text;
    }

    /**
     * @return A filter for a query based on the display name for a <code>Selection</code>-type custom attribute value. This filter is case-sensitive
     * and can contain <code>any</code>, <code>all</code>, or both. The <code>none</code> condition is not supported.
     * <p>Provide the display name of each item that you want to search for. To find the display names for the selection, use the
     * <a href="api:CustomerCustomAttributes">Customer Custom Attributes API</a> to retrieve the corresponding custom attribute definition
     * and then check the <code>schema.items.names</code> field. For more information, see
     * <a href="https://developer.squareup.com/docs/customers-api/use-the-api/search-customers#custom-attribute-value-filter-selection">Search based on selection</a>.</p>
     * <p>Note that when a <code>Selection</code>-type custom attribute is assigned to a customer profile, the custom attribute value is a list of one
     * or more UUIDs (sourced from the <code>schema.items.enum</code> field) that map to the item names. These UUIDs are unique per seller.</p>
     */
    @JsonProperty("selection")
    public Optional<FilterValue> getSelection() {
        return selection;
    }

    /**
     * @return A filter for a query based on the value of a <code>Date</code>-type custom attribute.
     * <p>Provide a date range for this filter using <code>start_at</code>, <code>end_at</code>, or both. Range boundaries are inclusive. Dates can be specified
     * in <code>YYYY-MM-DD</code> format or as RFC 3339 timestamps.</p>
     */
    @JsonProperty("date")
    public Optional<TimeRange> getDate() {
        return date;
    }

    /**
     * @return A filter for a query based on the value of a <code>Number</code>-type custom attribute, which can be an integer or a decimal with up to
     * 5 digits of precision.
     * <p>Provide a numerical range for this filter using <code>start_at</code>, <code>end_at</code>, or both. Range boundaries are inclusive. Numbers are specified
     * as decimals or integers. The absolute value of range boundaries must not exceed <code>(2^63-1)/10^5</code>, or 92233720368547.</p>
     */
    @JsonProperty("number")
    public Optional<FloatNumberRange> getNumber() {
        return number;
    }

    /**
     * @return A filter for a query based on the value of a <code>Boolean</code>-type custom attribute.
     */
    @JsonIgnore
    public Optional<Boolean> getBoolean() {
        if (boolean_ == null) {
            return Optional.empty();
        }
        return boolean_;
    }

    /**
     * @return A filter for a query based on the value of an <code>Address</code>-type custom attribute. The filter can include <code>postal_code</code>, <code>country</code>, or both.
     */
    @JsonProperty("address")
    public Optional<CustomerAddressFilter> getAddress() {
        return address;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("boolean")
    private Optional<Boolean> _getBoolean() {
        return boolean_;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CustomerCustomAttributeFilterValue
                && equalTo((CustomerCustomAttributeFilterValue) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CustomerCustomAttributeFilterValue other) {
        return email.equals(other.email)
                && phone.equals(other.phone)
                && text.equals(other.text)
                && selection.equals(other.selection)
                && date.equals(other.date)
                && number.equals(other.number)
                && boolean_.equals(other.boolean_)
                && address.equals(other.address);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.email, this.phone, this.text, this.selection, this.date, this.number, this.boolean_, this.address);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<CustomerTextFilter> email = Optional.empty();

        private Optional<CustomerTextFilter> phone = Optional.empty();

        private Optional<CustomerTextFilter> text = Optional.empty();

        private Optional<FilterValue> selection = Optional.empty();

        private Optional<TimeRange> date = Optional.empty();

        private Optional<FloatNumberRange> number = Optional.empty();

        private Optional<Boolean> boolean_ = Optional.empty();

        private Optional<CustomerAddressFilter> address = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CustomerCustomAttributeFilterValue other) {
            email(other.getEmail());
            phone(other.getPhone());
            text(other.getText());
            selection(other.getSelection());
            date(other.getDate());
            number(other.getNumber());
            boolean_(other.getBoolean());
            address(other.getAddress());
            return this;
        }

        /**
         * <p>A filter for a query based on the value of an <code>Email</code>-type custom attribute. This filter is case-insensitive and can
         * include <code>exact</code> or <code>fuzzy</code>, but not both.</p>
         * <p>For an <code>exact</code> match, provide the complete email address.</p>
         * <p>For a <code>fuzzy</code> match, provide a query expression containing one or more query tokens to match against the email address. Square removes
         * any punctuation (including periods (.), underscores (_), and the @ symbol) and tokenizes the email addresses on spaces. A match is found
         * if a tokenized email address contains all the tokens in the search query, irrespective of the token order. For example, <code>Steven gmail</code>
         * matches steven.jones@gmail.com and mygmail@stevensbakery.com.</p>
         */
        @JsonSetter(value = "email", nulls = Nulls.SKIP)
        public Builder email(Optional<CustomerTextFilter> email) {
            this.email = email;
            return this;
        }

        public Builder email(CustomerTextFilter email) {
            this.email = Optional.ofNullable(email);
            return this;
        }

        /**
         * <p>A filter for a query based on the value of a <code>PhoneNumber</code>-type custom attribute. This filter is case-insensitive and
         * can include <code>exact</code> or <code>fuzzy</code>, but not both.</p>
         * <p>For an <code>exact</code> match, provide the complete phone number. This is always an E.164-compliant phone number that starts
         * with the + sign followed by the country code and subscriber number. For example, the format for a US phone number is +12061112222.</p>
         * <p>For a <code>fuzzy</code> match, provide a query expression containing one or more query tokens to match against the phone number.
         * Square removes any punctuation and tokenizes the expression on spaces. A match is found if a tokenized phone number contains
         * all the tokens in the search query, irrespective of the token order. For example, <code>415 123 45</code> is tokenized to <code>415</code>, <code>123</code>, and <code>45</code>,
         * which matches +14151234567 and +12345674158, but does not match +1234156780. Similarly, the expression <code>415</code> matches
         * +14151234567, +12345674158, and +1234156780.</p>
         */
        @JsonSetter(value = "phone", nulls = Nulls.SKIP)
        public Builder phone(Optional<CustomerTextFilter> phone) {
            this.phone = phone;
            return this;
        }

        public Builder phone(CustomerTextFilter phone) {
            this.phone = Optional.ofNullable(phone);
            return this;
        }

        /**
         * <p>A filter for a query based on the value of a <code>String</code>-type custom attribute. This filter is case-insensitive and
         * can include <code>exact</code> or <code>fuzzy</code>, but not both.</p>
         * <p>For an <code>exact</code> match, provide the complete string.</p>
         * <p>For a <code>fuzzy</code> match, provide a query expression containing one or more query tokens in any order that contain complete words
         * to match against the string. Square tokenizes the expression using a grammar-based tokenizer. For example, the expressions <code>quick brown</code>,
         * <code>brown quick</code>, and <code>quick fox</code> match &quot;The quick brown fox jumps over the lazy dog&quot;. However, <code>quick foxes</code> and <code>qui</code> do not match.</p>
         */
        @JsonSetter(value = "text", nulls = Nulls.SKIP)
        public Builder text(Optional<CustomerTextFilter> text) {
            this.text = text;
            return this;
        }

        public Builder text(CustomerTextFilter text) {
            this.text = Optional.ofNullable(text);
            return this;
        }

        /**
         * <p>A filter for a query based on the display name for a <code>Selection</code>-type custom attribute value. This filter is case-sensitive
         * and can contain <code>any</code>, <code>all</code>, or both. The <code>none</code> condition is not supported.</p>
         * <p>Provide the display name of each item that you want to search for. To find the display names for the selection, use the
         * <a href="api:CustomerCustomAttributes">Customer Custom Attributes API</a> to retrieve the corresponding custom attribute definition
         * and then check the <code>schema.items.names</code> field. For more information, see
         * <a href="https://developer.squareup.com/docs/customers-api/use-the-api/search-customers#custom-attribute-value-filter-selection">Search based on selection</a>.</p>
         * <p>Note that when a <code>Selection</code>-type custom attribute is assigned to a customer profile, the custom attribute value is a list of one
         * or more UUIDs (sourced from the <code>schema.items.enum</code> field) that map to the item names. These UUIDs are unique per seller.</p>
         */
        @JsonSetter(value = "selection", nulls = Nulls.SKIP)
        public Builder selection(Optional<FilterValue> selection) {
            this.selection = selection;
            return this;
        }

        public Builder selection(FilterValue selection) {
            this.selection = Optional.ofNullable(selection);
            return this;
        }

        /**
         * <p>A filter for a query based on the value of a <code>Date</code>-type custom attribute.</p>
         * <p>Provide a date range for this filter using <code>start_at</code>, <code>end_at</code>, or both. Range boundaries are inclusive. Dates can be specified
         * in <code>YYYY-MM-DD</code> format or as RFC 3339 timestamps.</p>
         */
        @JsonSetter(value = "date", nulls = Nulls.SKIP)
        public Builder date(Optional<TimeRange> date) {
            this.date = date;
            return this;
        }

        public Builder date(TimeRange date) {
            this.date = Optional.ofNullable(date);
            return this;
        }

        /**
         * <p>A filter for a query based on the value of a <code>Number</code>-type custom attribute, which can be an integer or a decimal with up to
         * 5 digits of precision.</p>
         * <p>Provide a numerical range for this filter using <code>start_at</code>, <code>end_at</code>, or both. Range boundaries are inclusive. Numbers are specified
         * as decimals or integers. The absolute value of range boundaries must not exceed <code>(2^63-1)/10^5</code>, or 92233720368547.</p>
         */
        @JsonSetter(value = "number", nulls = Nulls.SKIP)
        public Builder number(Optional<FloatNumberRange> number) {
            this.number = number;
            return this;
        }

        public Builder number(FloatNumberRange number) {
            this.number = Optional.ofNullable(number);
            return this;
        }

        /**
         * <p>A filter for a query based on the value of a <code>Boolean</code>-type custom attribute.</p>
         */
        @JsonSetter(value = "boolean", nulls = Nulls.SKIP)
        public Builder boolean_(Optional<Boolean> boolean_) {
            this.boolean_ = boolean_;
            return this;
        }

        public Builder boolean_(Boolean boolean_) {
            this.boolean_ = Optional.ofNullable(boolean_);
            return this;
        }

        public Builder boolean_(Nullable<Boolean> boolean_) {
            if (boolean_.isNull()) {
                this.boolean_ = null;
            } else if (boolean_.isEmpty()) {
                this.boolean_ = Optional.empty();
            } else {
                this.boolean_ = Optional.of(boolean_.get());
            }
            return this;
        }

        /**
         * <p>A filter for a query based on the value of an <code>Address</code>-type custom attribute. The filter can include <code>postal_code</code>, <code>country</code>, or both.</p>
         */
        @JsonSetter(value = "address", nulls = Nulls.SKIP)
        public Builder address(Optional<CustomerAddressFilter> address) {
            this.address = address;
            return this;
        }

        public Builder address(CustomerAddressFilter address) {
            this.address = Optional.ofNullable(address);
            return this;
        }

        public CustomerCustomAttributeFilterValue build() {
            return new CustomerCustomAttributeFilterValue(
                    email, phone, text, selection, date, number, boolean_, address, additionalProperties);
        }
    }
}
