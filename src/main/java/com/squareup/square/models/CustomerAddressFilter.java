
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CustomerAddressFilter type.
 */
public class CustomerAddressFilter {
    private final CustomerTextFilter postalCode;
    private final String country;

    /**
     * Initialization constructor.
     * @param  postalCode  CustomerTextFilter value for postalCode.
     * @param  country  String value for country.
     */
    @JsonCreator
    public CustomerAddressFilter(
            @JsonProperty("postal_code") CustomerTextFilter postalCode,
            @JsonProperty("country") String country) {
        this.postalCode = postalCode;
        this.country = country;
    }

    /**
     * Getter for PostalCode.
     * A filter to select customers based on exact or fuzzy matching of customer attributes against
     * a specified query. Depending on the customer attributes, the filter can be case-sensitive.
     * This filter can be exact or fuzzy, but it cannot be both.
     * @return Returns the CustomerTextFilter
     */
    @JsonGetter("postal_code")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CustomerTextFilter getPostalCode() {
        return postalCode;
    }

    /**
     * Getter for Country.
     * Indicates the country associated with another entity, such as a business. Values are in [ISO
     * 3166-1-alpha-2 format](http://www.iso.org/iso/home/standards/country_codes.htm).
     * @return Returns the String
     */
    @JsonGetter("country")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCountry() {
        return country;
    }

    @Override
    public int hashCode() {
        return Objects.hash(postalCode, country);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CustomerAddressFilter)) {
            return false;
        }
        CustomerAddressFilter other = (CustomerAddressFilter) obj;
        return Objects.equals(postalCode, other.postalCode)
            && Objects.equals(country, other.country);
    }

    /**
     * Converts this CustomerAddressFilter into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CustomerAddressFilter [" + "postalCode=" + postalCode + ", country=" + country
                + "]";
    }

    /**
     * Builds a new {@link CustomerAddressFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CustomerAddressFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .postalCode(getPostalCode())
                .country(getCountry());
        return builder;
    }

    /**
     * Class to build instances of {@link CustomerAddressFilter}.
     */
    public static class Builder {
        private CustomerTextFilter postalCode;
        private String country;



        /**
         * Setter for postalCode.
         * @param  postalCode  CustomerTextFilter value for postalCode.
         * @return Builder
         */
        public Builder postalCode(CustomerTextFilter postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        /**
         * Setter for country.
         * @param  country  String value for country.
         * @return Builder
         */
        public Builder country(String country) {
            this.country = country;
            return this;
        }

        /**
         * Builds a new {@link CustomerAddressFilter} object using the set fields.
         * @return {@link CustomerAddressFilter}
         */
        public CustomerAddressFilter build() {
            return new CustomerAddressFilter(postalCode, country);
        }
    }
}
