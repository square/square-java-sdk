
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for Address type.
 */
public class Address {
    private final String addressLine1;
    private final String addressLine2;
    private final String addressLine3;
    private final String locality;
    private final String sublocality;
    private final String administrativeDistrictLevel1;
    private final String postalCode;
    private final String country;

    /**
     * Initialization constructor.
     * @param  addressLine1  String value for addressLine1.
     * @param  addressLine2  String value for addressLine2.
     * @param  addressLine3  String value for addressLine3.
     * @param  locality  String value for locality.
     * @param  sublocality  String value for sublocality.
     * @param  administrativeDistrictLevel1  String value for administrativeDistrictLevel1.
     * @param  postalCode  String value for postalCode.
     * @param  country  String value for country.
     */
    @JsonCreator
    public Address(
            @JsonProperty("address_line_1") String addressLine1,
            @JsonProperty("address_line_2") String addressLine2,
            @JsonProperty("address_line_3") String addressLine3,
            @JsonProperty("locality") String locality,
            @JsonProperty("sublocality") String sublocality,
            @JsonProperty("administrative_district_level_1") String administrativeDistrictLevel1,
            @JsonProperty("postal_code") String postalCode,
            @JsonProperty("country") String country) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.locality = locality;
        this.sublocality = sublocality;
        this.administrativeDistrictLevel1 = administrativeDistrictLevel1;
        this.postalCode = postalCode;
        this.country = country;
    }

    /**
     * Getter for AddressLine1.
     * The first line of the address. Fields that start with `address_line` provide the address's
     * most specific details, like street number, street name, and building name. They do *not*
     * provide less specific details like city, state/province, or country (these details are
     * provided in other fields).
     * @return Returns the String
     */
    @JsonGetter("address_line_1")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * Getter for AddressLine2.
     * The second line of the address, if any.
     * @return Returns the String
     */
    @JsonGetter("address_line_2")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * Getter for AddressLine3.
     * The third line of the address, if any.
     * @return Returns the String
     */
    @JsonGetter("address_line_3")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getAddressLine3() {
        return addressLine3;
    }

    /**
     * Getter for Locality.
     * The city or town of the address. For a full list of field meanings by country, see [Working
     * with Addresses](https://developer.squareup.com/docs/build-basics/working-with-addresses).
     * @return Returns the String
     */
    @JsonGetter("locality")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getLocality() {
        return locality;
    }

    /**
     * Getter for Sublocality.
     * A civil region within the address's `locality`, if any.
     * @return Returns the String
     */
    @JsonGetter("sublocality")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getSublocality() {
        return sublocality;
    }

    /**
     * Getter for AdministrativeDistrictLevel1.
     * A civil entity within the address's country. In the US, this is the state. For a full list of
     * field meanings by country, see [Working with
     * Addresses](https://developer.squareup.com/docs/build-basics/working-with-addresses).
     * @return Returns the String
     */
    @JsonGetter("administrative_district_level_1")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getAdministrativeDistrictLevel1() {
        return administrativeDistrictLevel1;
    }

    /**
     * Getter for PostalCode.
     * The address's postal code. For a full list of field meanings by country, see [Working with
     * Addresses](https://developer.squareup.com/docs/build-basics/working-with-addresses).
     * @return Returns the String
     */
    @JsonGetter("postal_code")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPostalCode() {
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
        return Objects.hash(addressLine1, addressLine2, addressLine3, locality, sublocality,
                administrativeDistrictLevel1, postalCode, country);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Address)) {
            return false;
        }
        Address other = (Address) obj;
        return Objects.equals(addressLine1, other.addressLine1)
            && Objects.equals(addressLine2, other.addressLine2)
            && Objects.equals(addressLine3, other.addressLine3)
            && Objects.equals(locality, other.locality)
            && Objects.equals(sublocality, other.sublocality)
            && Objects.equals(administrativeDistrictLevel1, other.administrativeDistrictLevel1)
            && Objects.equals(postalCode, other.postalCode)
            && Objects.equals(country, other.country);
    }

    /**
     * Converts this Address into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Address [" + "addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
                + ", addressLine3=" + addressLine3 + ", locality=" + locality + ", sublocality="
                + sublocality + ", administrativeDistrictLevel1=" + administrativeDistrictLevel1
                + ", postalCode=" + postalCode + ", country=" + country + "]";
    }

    /**
     * Builds a new {@link Address.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Address.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .addressLine1(getAddressLine1())
                .addressLine2(getAddressLine2())
                .addressLine3(getAddressLine3())
                .locality(getLocality())
                .sublocality(getSublocality())
                .administrativeDistrictLevel1(getAdministrativeDistrictLevel1())
                .postalCode(getPostalCode())
                .country(getCountry());
        return builder;
    }

    /**
     * Class to build instances of {@link Address}.
     */
    public static class Builder {
        private String addressLine1;
        private String addressLine2;
        private String addressLine3;
        private String locality;
        private String sublocality;
        private String administrativeDistrictLevel1;
        private String postalCode;
        private String country;



        /**
         * Setter for addressLine1.
         * @param  addressLine1  String value for addressLine1.
         * @return Builder
         */
        public Builder addressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
            return this;
        }

        /**
         * Setter for addressLine2.
         * @param  addressLine2  String value for addressLine2.
         * @return Builder
         */
        public Builder addressLine2(String addressLine2) {
            this.addressLine2 = addressLine2;
            return this;
        }

        /**
         * Setter for addressLine3.
         * @param  addressLine3  String value for addressLine3.
         * @return Builder
         */
        public Builder addressLine3(String addressLine3) {
            this.addressLine3 = addressLine3;
            return this;
        }

        /**
         * Setter for locality.
         * @param  locality  String value for locality.
         * @return Builder
         */
        public Builder locality(String locality) {
            this.locality = locality;
            return this;
        }

        /**
         * Setter for sublocality.
         * @param  sublocality  String value for sublocality.
         * @return Builder
         */
        public Builder sublocality(String sublocality) {
            this.sublocality = sublocality;
            return this;
        }

        /**
         * Setter for administrativeDistrictLevel1.
         * @param  administrativeDistrictLevel1  String value for administrativeDistrictLevel1.
         * @return Builder
         */
        public Builder administrativeDistrictLevel1(String administrativeDistrictLevel1) {
            this.administrativeDistrictLevel1 = administrativeDistrictLevel1;
            return this;
        }

        /**
         * Setter for postalCode.
         * @param  postalCode  String value for postalCode.
         * @return Builder
         */
        public Builder postalCode(String postalCode) {
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
         * Builds a new {@link Address} object using the set fields.
         * @return {@link Address}
         */
        public Address build() {
            return new Address(addressLine1, addressLine2, addressLine3, locality, sublocality,
                    administrativeDistrictLevel1, postalCode, country);
        }
    }
}
