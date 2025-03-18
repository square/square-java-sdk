package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for Address type.
 */
public class Address {
    private final OptionalNullable<String> addressLine1;
    private final OptionalNullable<String> addressLine2;
    private final OptionalNullable<String> addressLine3;
    private final OptionalNullable<String> locality;
    private final OptionalNullable<String> sublocality;
    private final OptionalNullable<String> sublocality2;
    private final OptionalNullable<String> sublocality3;
    private final OptionalNullable<String> administrativeDistrictLevel1;
    private final OptionalNullable<String> administrativeDistrictLevel2;
    private final OptionalNullable<String> administrativeDistrictLevel3;
    private final OptionalNullable<String> postalCode;
    private final String country;
    private final OptionalNullable<String> firstName;
    private final OptionalNullable<String> lastName;

    /**
     * Initialization constructor.
     * @param  addressLine1  String value for addressLine1.
     * @param  addressLine2  String value for addressLine2.
     * @param  addressLine3  String value for addressLine3.
     * @param  locality  String value for locality.
     * @param  sublocality  String value for sublocality.
     * @param  sublocality2  String value for sublocality2.
     * @param  sublocality3  String value for sublocality3.
     * @param  administrativeDistrictLevel1  String value for administrativeDistrictLevel1.
     * @param  administrativeDistrictLevel2  String value for administrativeDistrictLevel2.
     * @param  administrativeDistrictLevel3  String value for administrativeDistrictLevel3.
     * @param  postalCode  String value for postalCode.
     * @param  country  String value for country.
     * @param  firstName  String value for firstName.
     * @param  lastName  String value for lastName.
     */
    @JsonCreator
    public Address(
            @JsonProperty("address_line_1") String addressLine1,
            @JsonProperty("address_line_2") String addressLine2,
            @JsonProperty("address_line_3") String addressLine3,
            @JsonProperty("locality") String locality,
            @JsonProperty("sublocality") String sublocality,
            @JsonProperty("sublocality_2") String sublocality2,
            @JsonProperty("sublocality_3") String sublocality3,
            @JsonProperty("administrative_district_level_1") String administrativeDistrictLevel1,
            @JsonProperty("administrative_district_level_2") String administrativeDistrictLevel2,
            @JsonProperty("administrative_district_level_3") String administrativeDistrictLevel3,
            @JsonProperty("postal_code") String postalCode,
            @JsonProperty("country") String country,
            @JsonProperty("first_name") String firstName,
            @JsonProperty("last_name") String lastName) {
        this.addressLine1 = OptionalNullable.of(addressLine1);
        this.addressLine2 = OptionalNullable.of(addressLine2);
        this.addressLine3 = OptionalNullable.of(addressLine3);
        this.locality = OptionalNullable.of(locality);
        this.sublocality = OptionalNullable.of(sublocality);
        this.sublocality2 = OptionalNullable.of(sublocality2);
        this.sublocality3 = OptionalNullable.of(sublocality3);
        this.administrativeDistrictLevel1 = OptionalNullable.of(administrativeDistrictLevel1);
        this.administrativeDistrictLevel2 = OptionalNullable.of(administrativeDistrictLevel2);
        this.administrativeDistrictLevel3 = OptionalNullable.of(administrativeDistrictLevel3);
        this.postalCode = OptionalNullable.of(postalCode);
        this.country = country;
        this.firstName = OptionalNullable.of(firstName);
        this.lastName = OptionalNullable.of(lastName);
    }

    /**
     * Initialization constructor.
     * @param  addressLine1  String value for addressLine1.
     * @param  addressLine2  String value for addressLine2.
     * @param  addressLine3  String value for addressLine3.
     * @param  locality  String value for locality.
     * @param  sublocality  String value for sublocality.
     * @param  sublocality2  String value for sublocality2.
     * @param  sublocality3  String value for sublocality3.
     * @param  administrativeDistrictLevel1  String value for administrativeDistrictLevel1.
     * @param  administrativeDistrictLevel2  String value for administrativeDistrictLevel2.
     * @param  administrativeDistrictLevel3  String value for administrativeDistrictLevel3.
     * @param  postalCode  String value for postalCode.
     * @param  country  String value for country.
     * @param  firstName  String value for firstName.
     * @param  lastName  String value for lastName.
     */
    protected Address(
            OptionalNullable<String> addressLine1,
            OptionalNullable<String> addressLine2,
            OptionalNullable<String> addressLine3,
            OptionalNullable<String> locality,
            OptionalNullable<String> sublocality,
            OptionalNullable<String> sublocality2,
            OptionalNullable<String> sublocality3,
            OptionalNullable<String> administrativeDistrictLevel1,
            OptionalNullable<String> administrativeDistrictLevel2,
            OptionalNullable<String> administrativeDistrictLevel3,
            OptionalNullable<String> postalCode,
            String country,
            OptionalNullable<String> firstName,
            OptionalNullable<String> lastName) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.locality = locality;
        this.sublocality = sublocality;
        this.sublocality2 = sublocality2;
        this.sublocality3 = sublocality3;
        this.administrativeDistrictLevel1 = administrativeDistrictLevel1;
        this.administrativeDistrictLevel2 = administrativeDistrictLevel2;
        this.administrativeDistrictLevel3 = administrativeDistrictLevel3;
        this.postalCode = postalCode;
        this.country = country;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Internal Getter for AddressLine1.
     * The first line of the address. Fields that start with `address_line` provide the address's
     * most specific details, like street number, street name, and building name. They do *not*
     * provide less specific details like city, state/province, or country (these details are
     * provided in other fields).
     * @return Returns the Internal String
     */
    @JsonGetter("address_line_1")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetAddressLine1() {
        return this.addressLine1;
    }

    /**
     * Getter for AddressLine1.
     * The first line of the address. Fields that start with `address_line` provide the address's
     * most specific details, like street number, street name, and building name. They do *not*
     * provide less specific details like city, state/province, or country (these details are
     * provided in other fields).
     * @return Returns the String
     */
    @JsonIgnore
    public String getAddressLine1() {
        return OptionalNullable.getFrom(addressLine1);
    }

    /**
     * Internal Getter for AddressLine2.
     * The second line of the address, if any.
     * @return Returns the Internal String
     */
    @JsonGetter("address_line_2")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetAddressLine2() {
        return this.addressLine2;
    }

    /**
     * Getter for AddressLine2.
     * The second line of the address, if any.
     * @return Returns the String
     */
    @JsonIgnore
    public String getAddressLine2() {
        return OptionalNullable.getFrom(addressLine2);
    }

    /**
     * Internal Getter for AddressLine3.
     * The third line of the address, if any.
     * @return Returns the Internal String
     */
    @JsonGetter("address_line_3")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetAddressLine3() {
        return this.addressLine3;
    }

    /**
     * Getter for AddressLine3.
     * The third line of the address, if any.
     * @return Returns the String
     */
    @JsonIgnore
    public String getAddressLine3() {
        return OptionalNullable.getFrom(addressLine3);
    }

    /**
     * Internal Getter for Locality.
     * The city or town of the address. For a full list of field meanings by country, see [Working
     * with Addresses](https://developer.squareup.com/docs/build-basics/working-with-addresses).
     * @return Returns the Internal String
     */
    @JsonGetter("locality")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetLocality() {
        return this.locality;
    }

    /**
     * Getter for Locality.
     * The city or town of the address. For a full list of field meanings by country, see [Working
     * with Addresses](https://developer.squareup.com/docs/build-basics/working-with-addresses).
     * @return Returns the String
     */
    @JsonIgnore
    public String getLocality() {
        return OptionalNullable.getFrom(locality);
    }

    /**
     * Internal Getter for Sublocality.
     * A civil region within the address's `locality`, if any.
     * @return Returns the Internal String
     */
    @JsonGetter("sublocality")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetSublocality() {
        return this.sublocality;
    }

    /**
     * Getter for Sublocality.
     * A civil region within the address's `locality`, if any.
     * @return Returns the String
     */
    @JsonIgnore
    public String getSublocality() {
        return OptionalNullable.getFrom(sublocality);
    }

    /**
     * Internal Getter for Sublocality2.
     * A civil region within the address's `sublocality`, if any.
     * @return Returns the Internal String
     */
    @JsonGetter("sublocality_2")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetSublocality2() {
        return this.sublocality2;
    }

    /**
     * Getter for Sublocality2.
     * A civil region within the address's `sublocality`, if any.
     * @return Returns the String
     */
    @JsonIgnore
    public String getSublocality2() {
        return OptionalNullable.getFrom(sublocality2);
    }

    /**
     * Internal Getter for Sublocality3.
     * A civil region within the address's `sublocality_2`, if any.
     * @return Returns the Internal String
     */
    @JsonGetter("sublocality_3")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetSublocality3() {
        return this.sublocality3;
    }

    /**
     * Getter for Sublocality3.
     * A civil region within the address's `sublocality_2`, if any.
     * @return Returns the String
     */
    @JsonIgnore
    public String getSublocality3() {
        return OptionalNullable.getFrom(sublocality3);
    }

    /**
     * Internal Getter for AdministrativeDistrictLevel1.
     * A civil entity within the address's country. In the US, this is the state. For a full list of
     * field meanings by country, see [Working with
     * Addresses](https://developer.squareup.com/docs/build-basics/working-with-addresses).
     * @return Returns the Internal String
     */
    @JsonGetter("administrative_district_level_1")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetAdministrativeDistrictLevel1() {
        return this.administrativeDistrictLevel1;
    }

    /**
     * Getter for AdministrativeDistrictLevel1.
     * A civil entity within the address's country. In the US, this is the state. For a full list of
     * field meanings by country, see [Working with
     * Addresses](https://developer.squareup.com/docs/build-basics/working-with-addresses).
     * @return Returns the String
     */
    @JsonIgnore
    public String getAdministrativeDistrictLevel1() {
        return OptionalNullable.getFrom(administrativeDistrictLevel1);
    }

    /**
     * Internal Getter for AdministrativeDistrictLevel2.
     * A civil entity within the address's `administrative_district_level_1`. In the US, this is the
     * county.
     * @return Returns the Internal String
     */
    @JsonGetter("administrative_district_level_2")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetAdministrativeDistrictLevel2() {
        return this.administrativeDistrictLevel2;
    }

    /**
     * Getter for AdministrativeDistrictLevel2.
     * A civil entity within the address's `administrative_district_level_1`. In the US, this is the
     * county.
     * @return Returns the String
     */
    @JsonIgnore
    public String getAdministrativeDistrictLevel2() {
        return OptionalNullable.getFrom(administrativeDistrictLevel2);
    }

    /**
     * Internal Getter for AdministrativeDistrictLevel3.
     * A civil entity within the address's `administrative_district_level_2`, if any.
     * @return Returns the Internal String
     */
    @JsonGetter("administrative_district_level_3")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetAdministrativeDistrictLevel3() {
        return this.administrativeDistrictLevel3;
    }

    /**
     * Getter for AdministrativeDistrictLevel3.
     * A civil entity within the address's `administrative_district_level_2`, if any.
     * @return Returns the String
     */
    @JsonIgnore
    public String getAdministrativeDistrictLevel3() {
        return OptionalNullable.getFrom(administrativeDistrictLevel3);
    }

    /**
     * Internal Getter for PostalCode.
     * The address's postal code. For a full list of field meanings by country, see [Working with
     * Addresses](https://developer.squareup.com/docs/build-basics/working-with-addresses).
     * @return Returns the Internal String
     */
    @JsonGetter("postal_code")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetPostalCode() {
        return this.postalCode;
    }

    /**
     * Getter for PostalCode.
     * The address's postal code. For a full list of field meanings by country, see [Working with
     * Addresses](https://developer.squareup.com/docs/build-basics/working-with-addresses).
     * @return Returns the String
     */
    @JsonIgnore
    public String getPostalCode() {
        return OptionalNullable.getFrom(postalCode);
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

    /**
     * Internal Getter for FirstName.
     * Optional first name when it's representing recipient.
     * @return Returns the Internal String
     */
    @JsonGetter("first_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetFirstName() {
        return this.firstName;
    }

    /**
     * Getter for FirstName.
     * Optional first name when it's representing recipient.
     * @return Returns the String
     */
    @JsonIgnore
    public String getFirstName() {
        return OptionalNullable.getFrom(firstName);
    }

    /**
     * Internal Getter for LastName.
     * Optional last name when it's representing recipient.
     * @return Returns the Internal String
     */
    @JsonGetter("last_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetLastName() {
        return this.lastName;
    }

    /**
     * Getter for LastName.
     * Optional last name when it's representing recipient.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLastName() {
        return OptionalNullable.getFrom(lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                addressLine1,
                addressLine2,
                addressLine3,
                locality,
                sublocality,
                sublocality2,
                sublocality3,
                administrativeDistrictLevel1,
                administrativeDistrictLevel2,
                administrativeDistrictLevel3,
                postalCode,
                country,
                firstName,
                lastName);
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
                && Objects.equals(sublocality2, other.sublocality2)
                && Objects.equals(sublocality3, other.sublocality3)
                && Objects.equals(administrativeDistrictLevel1, other.administrativeDistrictLevel1)
                && Objects.equals(administrativeDistrictLevel2, other.administrativeDistrictLevel2)
                && Objects.equals(administrativeDistrictLevel3, other.administrativeDistrictLevel3)
                && Objects.equals(postalCode, other.postalCode)
                && Objects.equals(country, other.country)
                && Objects.equals(firstName, other.firstName)
                && Objects.equals(lastName, other.lastName);
    }

    /**
     * Converts this Address into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Address [" + "addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
                + ", addressLine3=" + addressLine3 + ", locality=" + locality + ", sublocality="
                + sublocality + ", sublocality2=" + sublocality2 + ", sublocality3=" + sublocality3
                + ", administrativeDistrictLevel1=" + administrativeDistrictLevel1
                + ", administrativeDistrictLevel2=" + administrativeDistrictLevel2
                + ", administrativeDistrictLevel3=" + administrativeDistrictLevel3 + ", postalCode="
                + postalCode + ", country=" + country + ", firstName=" + firstName + ", lastName="
                + lastName + "]";
    }

    /**
     * Builds a new {@link Address.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Address.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().country(getCountry());
        builder.addressLine1 = internalGetAddressLine1();
        builder.addressLine2 = internalGetAddressLine2();
        builder.addressLine3 = internalGetAddressLine3();
        builder.locality = internalGetLocality();
        builder.sublocality = internalGetSublocality();
        builder.sublocality2 = internalGetSublocality2();
        builder.sublocality3 = internalGetSublocality3();
        builder.administrativeDistrictLevel1 = internalGetAdministrativeDistrictLevel1();
        builder.administrativeDistrictLevel2 = internalGetAdministrativeDistrictLevel2();
        builder.administrativeDistrictLevel3 = internalGetAdministrativeDistrictLevel3();
        builder.postalCode = internalGetPostalCode();
        builder.firstName = internalGetFirstName();
        builder.lastName = internalGetLastName();
        return builder;
    }

    /**
     * Class to build instances of {@link Address}.
     */
    public static class Builder {
        private OptionalNullable<String> addressLine1;
        private OptionalNullable<String> addressLine2;
        private OptionalNullable<String> addressLine3;
        private OptionalNullable<String> locality;
        private OptionalNullable<String> sublocality;
        private OptionalNullable<String> sublocality2;
        private OptionalNullable<String> sublocality3;
        private OptionalNullable<String> administrativeDistrictLevel1;
        private OptionalNullable<String> administrativeDistrictLevel2;
        private OptionalNullable<String> administrativeDistrictLevel3;
        private OptionalNullable<String> postalCode;
        private String country;
        private OptionalNullable<String> firstName;
        private OptionalNullable<String> lastName;

        /**
         * Setter for addressLine1.
         * @param  addressLine1  String value for addressLine1.
         * @return Builder
         */
        public Builder addressLine1(String addressLine1) {
            this.addressLine1 = OptionalNullable.of(addressLine1);
            return this;
        }

        /**
         * UnSetter for addressLine1.
         * @return Builder
         */
        public Builder unsetAddressLine1() {
            addressLine1 = null;
            return this;
        }

        /**
         * Setter for addressLine2.
         * @param  addressLine2  String value for addressLine2.
         * @return Builder
         */
        public Builder addressLine2(String addressLine2) {
            this.addressLine2 = OptionalNullable.of(addressLine2);
            return this;
        }

        /**
         * UnSetter for addressLine2.
         * @return Builder
         */
        public Builder unsetAddressLine2() {
            addressLine2 = null;
            return this;
        }

        /**
         * Setter for addressLine3.
         * @param  addressLine3  String value for addressLine3.
         * @return Builder
         */
        public Builder addressLine3(String addressLine3) {
            this.addressLine3 = OptionalNullable.of(addressLine3);
            return this;
        }

        /**
         * UnSetter for addressLine3.
         * @return Builder
         */
        public Builder unsetAddressLine3() {
            addressLine3 = null;
            return this;
        }

        /**
         * Setter for locality.
         * @param  locality  String value for locality.
         * @return Builder
         */
        public Builder locality(String locality) {
            this.locality = OptionalNullable.of(locality);
            return this;
        }

        /**
         * UnSetter for locality.
         * @return Builder
         */
        public Builder unsetLocality() {
            locality = null;
            return this;
        }

        /**
         * Setter for sublocality.
         * @param  sublocality  String value for sublocality.
         * @return Builder
         */
        public Builder sublocality(String sublocality) {
            this.sublocality = OptionalNullable.of(sublocality);
            return this;
        }

        /**
         * UnSetter for sublocality.
         * @return Builder
         */
        public Builder unsetSublocality() {
            sublocality = null;
            return this;
        }

        /**
         * Setter for sublocality2.
         * @param  sublocality2  String value for sublocality2.
         * @return Builder
         */
        public Builder sublocality2(String sublocality2) {
            this.sublocality2 = OptionalNullable.of(sublocality2);
            return this;
        }

        /**
         * UnSetter for sublocality2.
         * @return Builder
         */
        public Builder unsetSublocality2() {
            sublocality2 = null;
            return this;
        }

        /**
         * Setter for sublocality3.
         * @param  sublocality3  String value for sublocality3.
         * @return Builder
         */
        public Builder sublocality3(String sublocality3) {
            this.sublocality3 = OptionalNullable.of(sublocality3);
            return this;
        }

        /**
         * UnSetter for sublocality3.
         * @return Builder
         */
        public Builder unsetSublocality3() {
            sublocality3 = null;
            return this;
        }

        /**
         * Setter for administrativeDistrictLevel1.
         * @param  administrativeDistrictLevel1  String value for administrativeDistrictLevel1.
         * @return Builder
         */
        public Builder administrativeDistrictLevel1(String administrativeDistrictLevel1) {
            this.administrativeDistrictLevel1 = OptionalNullable.of(administrativeDistrictLevel1);
            return this;
        }

        /**
         * UnSetter for administrativeDistrictLevel1.
         * @return Builder
         */
        public Builder unsetAdministrativeDistrictLevel1() {
            administrativeDistrictLevel1 = null;
            return this;
        }

        /**
         * Setter for administrativeDistrictLevel2.
         * @param  administrativeDistrictLevel2  String value for administrativeDistrictLevel2.
         * @return Builder
         */
        public Builder administrativeDistrictLevel2(String administrativeDistrictLevel2) {
            this.administrativeDistrictLevel2 = OptionalNullable.of(administrativeDistrictLevel2);
            return this;
        }

        /**
         * UnSetter for administrativeDistrictLevel2.
         * @return Builder
         */
        public Builder unsetAdministrativeDistrictLevel2() {
            administrativeDistrictLevel2 = null;
            return this;
        }

        /**
         * Setter for administrativeDistrictLevel3.
         * @param  administrativeDistrictLevel3  String value for administrativeDistrictLevel3.
         * @return Builder
         */
        public Builder administrativeDistrictLevel3(String administrativeDistrictLevel3) {
            this.administrativeDistrictLevel3 = OptionalNullable.of(administrativeDistrictLevel3);
            return this;
        }

        /**
         * UnSetter for administrativeDistrictLevel3.
         * @return Builder
         */
        public Builder unsetAdministrativeDistrictLevel3() {
            administrativeDistrictLevel3 = null;
            return this;
        }

        /**
         * Setter for postalCode.
         * @param  postalCode  String value for postalCode.
         * @return Builder
         */
        public Builder postalCode(String postalCode) {
            this.postalCode = OptionalNullable.of(postalCode);
            return this;
        }

        /**
         * UnSetter for postalCode.
         * @return Builder
         */
        public Builder unsetPostalCode() {
            postalCode = null;
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
         * Setter for firstName.
         * @param  firstName  String value for firstName.
         * @return Builder
         */
        public Builder firstName(String firstName) {
            this.firstName = OptionalNullable.of(firstName);
            return this;
        }

        /**
         * UnSetter for firstName.
         * @return Builder
         */
        public Builder unsetFirstName() {
            firstName = null;
            return this;
        }

        /**
         * Setter for lastName.
         * @param  lastName  String value for lastName.
         * @return Builder
         */
        public Builder lastName(String lastName) {
            this.lastName = OptionalNullable.of(lastName);
            return this;
        }

        /**
         * UnSetter for lastName.
         * @return Builder
         */
        public Builder unsetLastName() {
            lastName = null;
            return this;
        }

        /**
         * Builds a new {@link Address} object using the set fields.
         * @return {@link Address}
         */
        public Address build() {
            return new Address(
                    addressLine1,
                    addressLine2,
                    addressLine3,
                    locality,
                    sublocality,
                    sublocality2,
                    sublocality3,
                    administrativeDistrictLevel1,
                    administrativeDistrictLevel2,
                    administrativeDistrictLevel3,
                    postalCode,
                    country,
                    firstName,
                    lastName);
        }
    }
}
