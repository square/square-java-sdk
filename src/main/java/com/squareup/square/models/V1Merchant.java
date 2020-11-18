
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for V1Merchant type.
 */
public class V1Merchant {
    private HttpContext httpContext;
    private final String id;
    private final String name;
    private final String email;
    private final String accountType;
    private final List<String> accountCapabilities;
    private final String countryCode;
    private final String languageCode;
    private final String currencyCode;
    private final String businessName;
    private final Address businessAddress;
    private final V1PhoneNumber businessPhone;
    private final String businessType;
    private final Address shippingAddress;
    private final V1MerchantLocationDetails locationDetails;
    private final String marketUrl;

    /**
     * Initialization constructor.
     * @param id String value for id.
     * @param name String value for name.
     * @param email String value for email.
     * @param accountType String value for accountType.
     * @param accountCapabilities List of String value for accountCapabilities.
     * @param countryCode String value for countryCode.
     * @param languageCode String value for languageCode.
     * @param currencyCode String value for currencyCode.
     * @param businessName String value for businessName.
     * @param businessAddress Address value for businessAddress.
     * @param businessPhone V1PhoneNumber value for businessPhone.
     * @param businessType String value for businessType.
     * @param shippingAddress Address value for shippingAddress.
     * @param locationDetails V1MerchantLocationDetails value for locationDetails.
     * @param marketUrl String value for marketUrl.
     */
    @JsonCreator
    public V1Merchant(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("email") String email,
            @JsonProperty("account_type") String accountType,
            @JsonProperty("account_capabilities") List<String> accountCapabilities,
            @JsonProperty("country_code") String countryCode,
            @JsonProperty("language_code") String languageCode,
            @JsonProperty("currency_code") String currencyCode,
            @JsonProperty("business_name") String businessName,
            @JsonProperty("business_address") Address businessAddress,
            @JsonProperty("business_phone") V1PhoneNumber businessPhone,
            @JsonProperty("business_type") String businessType,
            @JsonProperty("shipping_address") Address shippingAddress,
            @JsonProperty("location_details") V1MerchantLocationDetails locationDetails,
            @JsonProperty("market_url") String marketUrl) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.accountType = accountType;
        this.accountCapabilities = accountCapabilities;
        this.countryCode = countryCode;
        this.languageCode = languageCode;
        this.currencyCode = currencyCode;
        this.businessName = businessName;
        this.businessAddress = businessAddress;
        this.businessPhone = businessPhone;
        this.businessType = businessType;
        this.shippingAddress = shippingAddress;
        this.locationDetails = locationDetails;
        this.marketUrl = marketUrl;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Id.
     * The merchant account's unique identifier.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for Name.
     * The name associated with the merchant account.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for Email.
     * The email address associated with the merchant account.
     * @return Returns the String
     */
    @JsonGetter("email")
    public String getEmail() {
        return this.email;
    }

    /**
     * Getter for AccountType.
     * @return Returns the String
     */
    @JsonGetter("account_type")
    public String getAccountType() {
        return this.accountType;
    }

    /**
     * Getter for AccountCapabilities.
     * Capabilities that are enabled for the merchant's Square account. Capabilities that are not
     * listed in this array are not enabled for the account.
     * @return Returns the List of String
     */
    @JsonGetter("account_capabilities")
    public List<String> getAccountCapabilities() {
        return this.accountCapabilities;
    }

    /**
     * Getter for CountryCode.
     * The country associated with the merchant account, in ISO 3166-1-alpha-2 format.
     * @return Returns the String
     */
    @JsonGetter("country_code")
    public String getCountryCode() {
        return this.countryCode;
    }

    /**
     * Getter for LanguageCode.
     * The language associated with the merchant account, in BCP 47 format.
     * @return Returns the String
     */
    @JsonGetter("language_code")
    public String getLanguageCode() {
        return this.languageCode;
    }

    /**
     * Getter for CurrencyCode.
     * The currency associated with the merchant account, in ISO 4217 format. For example, the
     * currency code for US dollars is USD.
     * @return Returns the String
     */
    @JsonGetter("currency_code")
    public String getCurrencyCode() {
        return this.currencyCode;
    }

    /**
     * Getter for BusinessName.
     * The name of the merchant's business.
     * @return Returns the String
     */
    @JsonGetter("business_name")
    public String getBusinessName() {
        return this.businessName;
    }

    /**
     * Getter for BusinessAddress.
     * Represents a physical address.
     * @return Returns the Address
     */
    @JsonGetter("business_address")
    public Address getBusinessAddress() {
        return this.businessAddress;
    }

    /**
     * Getter for BusinessPhone.
     * Represents a phone number.
     * @return Returns the V1PhoneNumber
     */
    @JsonGetter("business_phone")
    public V1PhoneNumber getBusinessPhone() {
        return this.businessPhone;
    }

    /**
     * Getter for BusinessType.
     * @return Returns the String
     */
    @JsonGetter("business_type")
    public String getBusinessType() {
        return this.businessType;
    }

    /**
     * Getter for ShippingAddress.
     * Represents a physical address.
     * @return Returns the Address
     */
    @JsonGetter("shipping_address")
    public Address getShippingAddress() {
        return this.shippingAddress;
    }

    /**
     * Getter for LocationDetails.
     * Additional information for a single-location account specified by its associated business
     * account, if it has one.
     * @return Returns the V1MerchantLocationDetails
     */
    @JsonGetter("location_details")
    public V1MerchantLocationDetails getLocationDetails() {
        return this.locationDetails;
    }

    /**
     * Getter for MarketUrl.
     * The URL of the merchant's online store.
     * @return Returns the String
     */
    @JsonGetter("market_url")
    public String getMarketUrl() {
        return this.marketUrl;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, accountType, accountCapabilities, countryCode,
                languageCode, currencyCode, businessName, businessAddress, businessPhone,
                businessType, shippingAddress, locationDetails, marketUrl);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1Merchant)) {
            return false;
        }
        V1Merchant other = (V1Merchant) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(name, other.name)
            && Objects.equals(email, other.email)
            && Objects.equals(accountType, other.accountType)
            && Objects.equals(accountCapabilities, other.accountCapabilities)
            && Objects.equals(countryCode, other.countryCode)
            && Objects.equals(languageCode, other.languageCode)
            && Objects.equals(currencyCode, other.currencyCode)
            && Objects.equals(businessName, other.businessName)
            && Objects.equals(businessAddress, other.businessAddress)
            && Objects.equals(businessPhone, other.businessPhone)
            && Objects.equals(businessType, other.businessType)
            && Objects.equals(shippingAddress, other.shippingAddress)
            && Objects.equals(locationDetails, other.locationDetails)
            && Objects.equals(marketUrl, other.marketUrl);
    }

    /**
     * Converts this V1Merchant into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1Merchant [" + "id=" + id + ", name=" + name + ", email=" + email
                + ", accountType=" + accountType + ", accountCapabilities=" + accountCapabilities
                + ", countryCode=" + countryCode + ", languageCode=" + languageCode
                + ", currencyCode=" + currencyCode + ", businessName=" + businessName
                + ", businessAddress=" + businessAddress + ", businessPhone=" + businessPhone
                + ", businessType=" + businessType + ", shippingAddress=" + shippingAddress
                + ", locationDetails=" + locationDetails + ", marketUrl=" + marketUrl + "]";
    }

    /**
     * Builds a new {@link V1Merchant.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1Merchant.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .name(getName())
                .email(getEmail())
                .accountType(getAccountType())
                .accountCapabilities(getAccountCapabilities())
                .countryCode(getCountryCode())
                .languageCode(getLanguageCode())
                .currencyCode(getCurrencyCode())
                .businessName(getBusinessName())
                .businessAddress(getBusinessAddress())
                .businessPhone(getBusinessPhone())
                .businessType(getBusinessType())
                .shippingAddress(getShippingAddress())
                .locationDetails(getLocationDetails())
                .marketUrl(getMarketUrl());
        return builder;
    }

    /**
     * Class to build instances of {@link V1Merchant}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private String id;
        private String name;
        private String email;
        private String accountType;
        private List<String> accountCapabilities;
        private String countryCode;
        private String languageCode;
        private String currencyCode;
        private String businessName;
        private Address businessAddress;
        private V1PhoneNumber businessPhone;
        private String businessType;
        private Address shippingAddress;
        private V1MerchantLocationDetails locationDetails;
        private String marketUrl;



        /**
         * Setter for httpContext.
         * @param httpContext HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for id.
         * @param id String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for name.
         * @param name String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Setter for email.
         * @param email String value for email.
         * @return Builder
         */
        public Builder email(String email) {
            this.email = email;
            return this;
        }

        /**
         * Setter for accountType.
         * @param accountType String value for accountType.
         * @return Builder
         */
        public Builder accountType(String accountType) {
            this.accountType = accountType;
            return this;
        }

        /**
         * Setter for accountCapabilities.
         * @param accountCapabilities List of String value for accountCapabilities.
         * @return Builder
         */
        public Builder accountCapabilities(List<String> accountCapabilities) {
            this.accountCapabilities = accountCapabilities;
            return this;
        }

        /**
         * Setter for countryCode.
         * @param countryCode String value for countryCode.
         * @return Builder
         */
        public Builder countryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        /**
         * Setter for languageCode.
         * @param languageCode String value for languageCode.
         * @return Builder
         */
        public Builder languageCode(String languageCode) {
            this.languageCode = languageCode;
            return this;
        }

        /**
         * Setter for currencyCode.
         * @param currencyCode String value for currencyCode.
         * @return Builder
         */
        public Builder currencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
            return this;
        }

        /**
         * Setter for businessName.
         * @param businessName String value for businessName.
         * @return Builder
         */
        public Builder businessName(String businessName) {
            this.businessName = businessName;
            return this;
        }

        /**
         * Setter for businessAddress.
         * @param businessAddress Address value for businessAddress.
         * @return Builder
         */
        public Builder businessAddress(Address businessAddress) {
            this.businessAddress = businessAddress;
            return this;
        }

        /**
         * Setter for businessPhone.
         * @param businessPhone V1PhoneNumber value for businessPhone.
         * @return Builder
         */
        public Builder businessPhone(V1PhoneNumber businessPhone) {
            this.businessPhone = businessPhone;
            return this;
        }

        /**
         * Setter for businessType.
         * @param businessType String value for businessType.
         * @return Builder
         */
        public Builder businessType(String businessType) {
            this.businessType = businessType;
            return this;
        }

        /**
         * Setter for shippingAddress.
         * @param shippingAddress Address value for shippingAddress.
         * @return Builder
         */
        public Builder shippingAddress(Address shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }

        /**
         * Setter for locationDetails.
         * @param locationDetails V1MerchantLocationDetails value for locationDetails.
         * @return Builder
         */
        public Builder locationDetails(V1MerchantLocationDetails locationDetails) {
            this.locationDetails = locationDetails;
            return this;
        }

        /**
         * Setter for marketUrl.
         * @param marketUrl String value for marketUrl.
         * @return Builder
         */
        public Builder marketUrl(String marketUrl) {
            this.marketUrl = marketUrl;
            return this;
        }

        /**
         * Builds a new {@link V1Merchant} object using the set fields.
         * @return {@link V1Merchant}
         */
        public V1Merchant build() {
            V1Merchant model =
                    new V1Merchant(id, name, email, accountType, accountCapabilities, countryCode,
                            languageCode, currencyCode, businessName, businessAddress,
                            businessPhone, businessType, shippingAddress, locationDetails,
                            marketUrl);
            model.httpContext = httpContext;
            return model;
        }
    }
}
