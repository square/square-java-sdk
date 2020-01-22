package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for Merchant type.
 */
public class Merchant {

    /**
     * Initialization constructor.
     * @param country
     * @param id
     * @param businessName
     * @param languageCode
     * @param currency
     * @param status
     */
    @JsonCreator
    public Merchant(
            @JsonProperty("country") String country,
            @JsonProperty("id") String id,
            @JsonProperty("business_name") String businessName,
            @JsonProperty("language_code") String languageCode,
            @JsonProperty("currency") String currency,
            @JsonProperty("status") String status) {
        this.id = id;
        this.businessName = businessName;
        this.country = country;
        this.languageCode = languageCode;
        this.currency = currency;
        this.status = status;
    }

    private final String id;
    private final String businessName;
    private final String country;
    private final String languageCode;
    private final String currency;
    private final String status;
    /**
     * Getter for Id.
     * The Square-issued ID of the merchant.
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for BusinessName.
     * The business name of the merchant.
     */
    @JsonGetter("business_name")
    public String getBusinessName() {
        return this.businessName;
    }

    /**
     * Getter for Country.
     * Indicates the country associated with another entity, such as a business.
     * Values are in [ISO 3166-1-alpha-2 format](http://www.iso.org/iso/home/standards/country_codes.htm).
     */
    @JsonGetter("country")
    public String getCountry() {
        return this.country;
    }

    /**
     * Getter for LanguageCode.
     * The language code associated with the merchant account, in BCP 47 format.
     */
    @JsonGetter("language_code")
    public String getLanguageCode() {
        return this.languageCode;
    }

    /**
     * Getter for Currency.
     * Indicates the associated currency for an amount of money. Values correspond
     * to [ISO 4217](https://wikipedia.org/wiki/ISO_4217).
     */
    @JsonGetter("currency")
    public String getCurrency() {
        return this.currency;
    }

    /**
     * Getter for Status.
     */
    @JsonGetter("status")
    public String getStatus() {
        return this.status;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, businessName, country, languageCode, currency, status);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof Merchant)) {
            return false;
        }
        Merchant merchant = (Merchant) obj;
        return Objects.equals(id, merchant.id) &&
            Objects.equals(businessName, merchant.businessName) &&
            Objects.equals(country, merchant.country) &&
            Objects.equals(languageCode, merchant.languageCode) &&
            Objects.equals(currency, merchant.currency) &&
            Objects.equals(status, merchant.status);
    }

    /**
     * Builds a new {@link Merchant.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Merchant.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(country)
            .id(getId())
            .businessName(getBusinessName())
            .languageCode(getLanguageCode())
            .currency(getCurrency())
            .status(getStatus());
            return builder;
    }

    /**
     * Class to build instances of {@link Merchant}
     */
    public static class Builder {
        private String country;
        private String id;
        private String businessName;
        private String languageCode;
        private String currency;
        private String status;

        /**
         * Initialization constructor
         */
        public Builder(String country) {
            this.country = country;
        }

        /**
         * Setter for country
         * @param country
         * @return Builder
         */
        public Builder country(String country) {
            this.country = country;
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
         * Setter for businessName
         * @param businessName
         * @return Builder
         */
        public Builder businessName(String businessName) {
            this.businessName = businessName;
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
         * Setter for currency
         * @param currency
         * @return Builder
         */
        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }
        /**
         * Setter for status
         * @param status
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Builds a new {@link Merchant} object using the set fields.
         * @return {@link Merchant}
         */
        public Merchant build() {
            return new Merchant(country,
                id,
                businessName,
                languageCode,
                currency,
                status);
        }
    }
}
