package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for V1Merchant type.
 */
public class V1Merchant {

    /**
     * Initialization constructor.
     * @param id
     * @param name
     * @param email
     * @param accountType
     * @param accountCapabilities
     * @param countryCode
     * @param languageCode
     * @param currencyCode
     * @param businessName
     * @param businessAddress
     * @param businessPhone
     * @param businessType
     * @param shippingAddress
     * @param locationDetails
     * @param marketUrl
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

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Id.
     * The merchant account's unique identifier.
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for Name.
     * The name associated with the merchant account.
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for Email.
     * The email address associated with the merchant account.
     */
    @JsonGetter("email")
    public String getEmail() {
        return this.email;
    }

    /**
     * Getter for AccountType.
     */
    @JsonGetter("account_type")
    public String getAccountType() {
        return this.accountType;
    }

    /**
     * Getter for AccountCapabilities.
     * Capabilities that are enabled for the merchant's Square account. Capabilities that are not listed in this array are not enabled for the account.
     */
    @JsonGetter("account_capabilities")
    public List<String> getAccountCapabilities() {
        return this.accountCapabilities;
    }

    /**
     * Getter for CountryCode.
     * The country associated with the merchant account, in ISO 3166-1-alpha-2 format.
     */
    @JsonGetter("country_code")
    public String getCountryCode() {
        return this.countryCode;
    }

    /**
     * Getter for LanguageCode.
     * The language associated with the merchant account, in BCP 47 format.
     */
    @JsonGetter("language_code")
    public String getLanguageCode() {
        return this.languageCode;
    }

    /**
     * Getter for CurrencyCode.
     * The currency associated with the merchant account, in ISO 4217 format. For example, the currency code for US dollars is USD.
     */
    @JsonGetter("currency_code")
    public String getCurrencyCode() {
        return this.currencyCode;
    }

    /**
     * Getter for BusinessName.
     * The name of the merchant's business.
     */
    @JsonGetter("business_name")
    public String getBusinessName() {
        return this.businessName;
    }

    /**
     * Getter for BusinessAddress.
     * Represents a physical address.
     */
    @JsonGetter("business_address")
    public Address getBusinessAddress() {
        return this.businessAddress;
    }

    /**
     * Getter for BusinessPhone.
     * Represents a phone number.
     */
    @JsonGetter("business_phone")
    public V1PhoneNumber getBusinessPhone() {
        return this.businessPhone;
    }

    /**
     * Getter for BusinessType.
     */
    @JsonGetter("business_type")
    public String getBusinessType() {
        return this.businessType;
    }

    /**
     * Getter for ShippingAddress.
     * Represents a physical address.
     */
    @JsonGetter("shipping_address")
    public Address getShippingAddress() {
        return this.shippingAddress;
    }

    /**
     * Getter for LocationDetails.
     * Additional information for a single-location account specified by its associated business account, if it has one.
     */
    @JsonGetter("location_details")
    public V1MerchantLocationDetails getLocationDetails() {
        return this.locationDetails;
    }

    /**
     * Getter for MarketUrl.
     * The URL of the merchant's online store.
     */
    @JsonGetter("market_url")
    public String getMarketUrl() {
        return this.marketUrl;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, accountType, accountCapabilities, countryCode,
            languageCode, currencyCode, businessName, businessAddress, businessPhone, businessType,
            shippingAddress, locationDetails, marketUrl);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1Merchant)) {
            return false;
        }
        V1Merchant v1Merchant = (V1Merchant) obj;
        return Objects.equals(id, v1Merchant.id) &&
            Objects.equals(name, v1Merchant.name) &&
            Objects.equals(email, v1Merchant.email) &&
            Objects.equals(accountType, v1Merchant.accountType) &&
            Objects.equals(accountCapabilities, v1Merchant.accountCapabilities) &&
            Objects.equals(countryCode, v1Merchant.countryCode) &&
            Objects.equals(languageCode, v1Merchant.languageCode) &&
            Objects.equals(currencyCode, v1Merchant.currencyCode) &&
            Objects.equals(businessName, v1Merchant.businessName) &&
            Objects.equals(businessAddress, v1Merchant.businessAddress) &&
            Objects.equals(businessPhone, v1Merchant.businessPhone) &&
            Objects.equals(businessType, v1Merchant.businessType) &&
            Objects.equals(shippingAddress, v1Merchant.shippingAddress) &&
            Objects.equals(locationDetails, v1Merchant.locationDetails) &&
            Objects.equals(marketUrl, v1Merchant.marketUrl);
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
     * Class to build instances of {@link V1Merchant}
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
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for httpContext
         * @param httpContext
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        /**
         * Setter for id
         * @param id
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }
        /**
         * Setter for name
         * @param name
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        /**
         * Setter for email
         * @param email
         * @return Builder
         */
        public Builder email(String email) {
            this.email = email;
            return this;
        }
        /**
         * Setter for accountType
         * @param accountType
         * @return Builder
         */
        public Builder accountType(String accountType) {
            this.accountType = accountType;
            return this;
        }
        /**
         * Setter for accountCapabilities
         * @param accountCapabilities
         * @return Builder
         */
        public Builder accountCapabilities(List<String> accountCapabilities) {
            this.accountCapabilities = accountCapabilities;
            return this;
        }
        /**
         * Setter for countryCode
         * @param countryCode
         * @return Builder
         */
        public Builder countryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }
        /**
         * Setter for languageCode
         * @param languageCode
         * @return Builder
         */
        public Builder languageCode(String languageCode) {
            this.languageCode = languageCode;
            return this;
        }
        /**
         * Setter for currencyCode
         * @param currencyCode
         * @return Builder
         */
        public Builder currencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
            return this;
        }
        /**
         * Setter for businessName
         * @param businessName
         * @return Builder
         */
        public Builder businessName(String businessName) {
            this.businessName = businessName;
            return this;
        }
        /**
         * Setter for businessAddress
         * @param businessAddress
         * @return Builder
         */
        public Builder businessAddress(Address businessAddress) {
            this.businessAddress = businessAddress;
            return this;
        }
        /**
         * Setter for businessPhone
         * @param businessPhone
         * @return Builder
         */
        public Builder businessPhone(V1PhoneNumber businessPhone) {
            this.businessPhone = businessPhone;
            return this;
        }
        /**
         * Setter for businessType
         * @param businessType
         * @return Builder
         */
        public Builder businessType(String businessType) {
            this.businessType = businessType;
            return this;
        }
        /**
         * Setter for shippingAddress
         * @param shippingAddress
         * @return Builder
         */
        public Builder shippingAddress(Address shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }
        /**
         * Setter for locationDetails
         * @param locationDetails
         * @return Builder
         */
        public Builder locationDetails(V1MerchantLocationDetails locationDetails) {
            this.locationDetails = locationDetails;
            return this;
        }
        /**
         * Setter for marketUrl
         * @param marketUrl
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
            V1Merchant model = new V1Merchant(id,
                name,
                email,
                accountType,
                accountCapabilities,
                countryCode,
                languageCode,
                currencyCode,
                businessName,
                businessAddress,
                businessPhone,
                businessType,
                shippingAddress,
                locationDetails,
                marketUrl);
            model.httpContext = httpContext;
            return model;
        }
    }
}
