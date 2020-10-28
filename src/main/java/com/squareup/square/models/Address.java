
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
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
    private final String sublocality2;
    private final String sublocality3;
    private final String administrativeDistrictLevel1;
    private final String administrativeDistrictLevel2;
    private final String administrativeDistrictLevel3;
    private final String postalCode;
    private final String country;
    private final String firstName;
    private final String lastName;
    private final String organization;

    /**
     * Initialization constructor.
     * @param addressLine1 String value for addressLine1.
     * @param addressLine2 String value for addressLine2.
     * @param addressLine3 String value for addressLine3.
     * @param locality String value for locality.
     * @param sublocality String value for sublocality.
     * @param sublocality2 String value for sublocality2.
     * @param sublocality3 String value for sublocality3.
     * @param administrativeDistrictLevel1 String value for administrativeDistrictLevel1.
     * @param administrativeDistrictLevel2 String value for administrativeDistrictLevel2.
     * @param administrativeDistrictLevel3 String value for administrativeDistrictLevel3.
     * @param postalCode String value for postalCode.
     * @param country String value for country.
     * @param firstName String value for firstName.
     * @param lastName String value for lastName.
     * @param organization String value for organization.
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
            @JsonProperty("last_name") String lastName,
            @JsonProperty("organization") String organization) {
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
        this.organization = organization;
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
    public String getAddressLine1() {
        return this.addressLine1;
    }

    /**
     * Getter for AddressLine2.
     * The second line of the address, if any.
     * @return Returns the String
     */
    @JsonGetter("address_line_2")
    public String getAddressLine2() {
        return this.addressLine2;
    }

    /**
     * Getter for AddressLine3.
     * The third line of the address, if any.
     * @return Returns the String
     */
    @JsonGetter("address_line_3")
    public String getAddressLine3() {
        return this.addressLine3;
    }

    /**
     * Getter for Locality.
     * The city or town of the address.
     * @return Returns the String
     */
    @JsonGetter("locality")
    public String getLocality() {
        return this.locality;
    }

    /**
     * Getter for Sublocality.
     * A civil region within the address's `locality`, if any.
     * @return Returns the String
     */
    @JsonGetter("sublocality")
    public String getSublocality() {
        return this.sublocality;
    }

    /**
     * Getter for Sublocality2.
     * A civil region within the address's `sublocality`, if any.
     * @return Returns the String
     */
    @JsonGetter("sublocality_2")
    public String getSublocality2() {
        return this.sublocality2;
    }

    /**
     * Getter for Sublocality3.
     * A civil region within the address's `sublocality_2`, if any.
     * @return Returns the String
     */
    @JsonGetter("sublocality_3")
    public String getSublocality3() {
        return this.sublocality3;
    }

    /**
     * Getter for AdministrativeDistrictLevel1.
     * A civil entity within the address's country. In the US, this is the state.
     * @return Returns the String
     */
    @JsonGetter("administrative_district_level_1")
    public String getAdministrativeDistrictLevel1() {
        return this.administrativeDistrictLevel1;
    }

    /**
     * Getter for AdministrativeDistrictLevel2.
     * A civil entity within the address's `administrative_district_level_1`. In the US, this is the
     * county.
     * @return Returns the String
     */
    @JsonGetter("administrative_district_level_2")
    public String getAdministrativeDistrictLevel2() {
        return this.administrativeDistrictLevel2;
    }

    /**
     * Getter for AdministrativeDistrictLevel3.
     * A civil entity within the address's `administrative_district_level_2`, if any.
     * @return Returns the String
     */
    @JsonGetter("administrative_district_level_3")
    public String getAdministrativeDistrictLevel3() {
        return this.administrativeDistrictLevel3;
    }

    /**
     * Getter for PostalCode.
     * The address's postal code.
     * @return Returns the String
     */
    @JsonGetter("postal_code")
    public String getPostalCode() {
        return this.postalCode;
    }

    /**
     * Getter for Country.
     * Indicates the country associated with another entity, such as a business. Values are in [ISO
     * 3166-1-alpha-2 format](http://www.iso.org/iso/home/standards/country_codes.htm).
     * @return Returns the String
     */
    @JsonGetter("country")
    public String getCountry() {
        return this.country;
    }

    /**
     * Getter for FirstName.
     * Optional first name when it's representing recipient.
     * @return Returns the String
     */
    @JsonGetter("first_name")
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Getter for LastName.
     * Optional last name when it's representing recipient.
     * @return Returns the String
     */
    @JsonGetter("last_name")
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Getter for Organization.
     * Optional organization name when it's representing recipient.
     * @return Returns the String
     */
    @JsonGetter("organization")
    public String getOrganization() {
        return this.organization;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(addressLine1, addressLine2, addressLine3, locality, sublocality,
                sublocality2, sublocality3, administrativeDistrictLevel1,
                administrativeDistrictLevel2, administrativeDistrictLevel3, postalCode, country,
                firstName, lastName, organization);
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
            && Objects.equals(lastName, other.lastName)
            && Objects.equals(organization, other.organization);
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
            .sublocality2(getSublocality2())
            .sublocality3(getSublocality3())
            .administrativeDistrictLevel1(getAdministrativeDistrictLevel1())
            .administrativeDistrictLevel2(getAdministrativeDistrictLevel2())
            .administrativeDistrictLevel3(getAdministrativeDistrictLevel3())
            .postalCode(getPostalCode())
            .country(getCountry())
            .firstName(getFirstName())
            .lastName(getLastName())
            .organization(getOrganization());
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
        private String sublocality2;
        private String sublocality3;
        private String administrativeDistrictLevel1;
        private String administrativeDistrictLevel2;
        private String administrativeDistrictLevel3;
        private String postalCode;
        private String country;
        private String firstName;
        private String lastName;
        private String organization;



        /**
         * Setter for addressLine1.
         * @param addressLine1 String value for addressLine1.
         * @return Builder
         */
        public Builder addressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
            return this;
        }

        /**
         * Setter for addressLine2.
         * @param addressLine2 String value for addressLine2.
         * @return Builder
         */
        public Builder addressLine2(String addressLine2) {
            this.addressLine2 = addressLine2;
            return this;
        }

        /**
         * Setter for addressLine3.
         * @param addressLine3 String value for addressLine3.
         * @return Builder
         */
        public Builder addressLine3(String addressLine3) {
            this.addressLine3 = addressLine3;
            return this;
        }

        /**
         * Setter for locality.
         * @param locality String value for locality.
         * @return Builder
         */
        public Builder locality(String locality) {
            this.locality = locality;
            return this;
        }

        /**
         * Setter for sublocality.
         * @param sublocality String value for sublocality.
         * @return Builder
         */
        public Builder sublocality(String sublocality) {
            this.sublocality = sublocality;
            return this;
        }

        /**
         * Setter for sublocality2.
         * @param sublocality2 String value for sublocality2.
         * @return Builder
         */
        public Builder sublocality2(String sublocality2) {
            this.sublocality2 = sublocality2;
            return this;
        }

        /**
         * Setter for sublocality3.
         * @param sublocality3 String value for sublocality3.
         * @return Builder
         */
        public Builder sublocality3(String sublocality3) {
            this.sublocality3 = sublocality3;
            return this;
        }

        /**
         * Setter for administrativeDistrictLevel1.
         * @param administrativeDistrictLevel1 String value for administrativeDistrictLevel1.
         * @return Builder
         */
        public Builder administrativeDistrictLevel1(String administrativeDistrictLevel1) {
            this.administrativeDistrictLevel1 = administrativeDistrictLevel1;
            return this;
        }

        /**
         * Setter for administrativeDistrictLevel2.
         * @param administrativeDistrictLevel2 String value for administrativeDistrictLevel2.
         * @return Builder
         */
        public Builder administrativeDistrictLevel2(String administrativeDistrictLevel2) {
            this.administrativeDistrictLevel2 = administrativeDistrictLevel2;
            return this;
        }

        /**
         * Setter for administrativeDistrictLevel3.
         * @param administrativeDistrictLevel3 String value for administrativeDistrictLevel3.
         * @return Builder
         */
        public Builder administrativeDistrictLevel3(String administrativeDistrictLevel3) {
            this.administrativeDistrictLevel3 = administrativeDistrictLevel3;
            return this;
        }

        /**
         * Setter for postalCode.
         * @param postalCode String value for postalCode.
         * @return Builder
         */
        public Builder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        /**
         * Setter for country.
         * @param country String value for country.
         * @return Builder
         */
        public Builder country(String country) {
            this.country = country;
            return this;
        }

        /**
         * Setter for firstName.
         * @param firstName String value for firstName.
         * @return Builder
         */
        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        /**
         * Setter for lastName.
         * @param lastName String value for lastName.
         * @return Builder
         */
        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        /**
         * Setter for organization.
         * @param organization String value for organization.
         * @return Builder
         */
        public Builder organization(String organization) {
            this.organization = organization;
            return this;
        }

        /**
         * Builds a new {@link Address} object using the set fields.
         * @return {@link Address}
         */
        public Address build() {
            return new Address(addressLine1,
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
                lastName,
                organization);
        }
    }
}
