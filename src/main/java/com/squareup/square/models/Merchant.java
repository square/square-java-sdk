package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class Merchant {

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

    @Override
    public int hashCode() {
        return Objects.hash(country, id, businessName, languageCode, currency, status);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Merchant)) {
            return false;
        }
        Merchant merchant = (Merchant) o;
        return Objects.equals(country, merchant.country) &&
            Objects.equals(id, merchant.id) &&
            Objects.equals(businessName, merchant.businessName) &&
            Objects.equals(languageCode, merchant.languageCode) &&
            Objects.equals(currency, merchant.currency) &&
            Objects.equals(status, merchant.status);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder(country)
            .id(getId())
            .businessName(getBusinessName())
            .languageCode(getLanguageCode())
            .currency(getCurrency())
            .status(getStatus());
            return builder;
    }

    public static class Builder {
        private String country;
        private String id;
        private String businessName;
        private String languageCode;
        private String currency;
        private String status;

        public Builder(String country) {
            this.country = country;
        }

        public Builder country(String value) {
            country = value;
            return this;
        }
        public Builder id(String value) {
            id = value;
            return this;
        }
        public Builder businessName(String value) {
            businessName = value;
            return this;
        }
        public Builder languageCode(String value) {
            languageCode = value;
            return this;
        }
        public Builder currency(String value) {
            currency = value;
            return this;
        }
        public Builder status(String value) {
            status = value;
            return this;
        }

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
