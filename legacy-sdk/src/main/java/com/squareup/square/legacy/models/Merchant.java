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
 * This is a model class for Merchant type.
 */
public class Merchant {
    private final String id;
    private final OptionalNullable<String> businessName;
    private final String country;
    private final OptionalNullable<String> languageCode;
    private final String currency;
    private final String status;
    private final OptionalNullable<String> mainLocationId;
    private final String createdAt;

    /**
     * Initialization constructor.
     * @param  country  String value for country.
     * @param  id  String value for id.
     * @param  businessName  String value for businessName.
     * @param  languageCode  String value for languageCode.
     * @param  currency  String value for currency.
     * @param  status  String value for status.
     * @param  mainLocationId  String value for mainLocationId.
     * @param  createdAt  String value for createdAt.
     */
    @JsonCreator
    public Merchant(
            @JsonProperty("country") String country,
            @JsonProperty("id") String id,
            @JsonProperty("business_name") String businessName,
            @JsonProperty("language_code") String languageCode,
            @JsonProperty("currency") String currency,
            @JsonProperty("status") String status,
            @JsonProperty("main_location_id") String mainLocationId,
            @JsonProperty("created_at") String createdAt) {
        this.id = id;
        this.businessName = OptionalNullable.of(businessName);
        this.country = country;
        this.languageCode = OptionalNullable.of(languageCode);
        this.currency = currency;
        this.status = status;
        this.mainLocationId = OptionalNullable.of(mainLocationId);
        this.createdAt = createdAt;
    }

    /**
     * Initialization constructor.
     * @param  country  String value for country.
     * @param  id  String value for id.
     * @param  businessName  String value for businessName.
     * @param  languageCode  String value for languageCode.
     * @param  currency  String value for currency.
     * @param  status  String value for status.
     * @param  mainLocationId  String value for mainLocationId.
     * @param  createdAt  String value for createdAt.
     */
    protected Merchant(
            String country,
            String id,
            OptionalNullable<String> businessName,
            OptionalNullable<String> languageCode,
            String currency,
            String status,
            OptionalNullable<String> mainLocationId,
            String createdAt) {
        this.id = id;
        this.businessName = businessName;
        this.country = country;
        this.languageCode = languageCode;
        this.currency = currency;
        this.status = status;
        this.mainLocationId = mainLocationId;
        this.createdAt = createdAt;
    }

    /**
     * Getter for Id.
     * The Square-issued ID of the merchant.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Internal Getter for BusinessName.
     * The name of the merchant's overall business.
     * @return Returns the Internal String
     */
    @JsonGetter("business_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetBusinessName() {
        return this.businessName;
    }

    /**
     * Getter for BusinessName.
     * The name of the merchant's overall business.
     * @return Returns the String
     */
    @JsonIgnore
    public String getBusinessName() {
        return OptionalNullable.getFrom(businessName);
    }

    /**
     * Getter for Country.
     * Indicates the country associated with another entity, such as a business. Values are in [ISO
     * 3166-1-alpha-2 format](http://www.iso.org/iso/home/standards/country_codes.htm).
     * @return Returns the String
     */
    @JsonGetter("country")
    public String getCountry() {
        return country;
    }

    /**
     * Internal Getter for LanguageCode.
     * The code indicating the [language
     * preferences](https://developer.squareup.com/docs/build-basics/general-considerations/language-preferences)
     * of the merchant, in [BCP 47 format](https://tools.ietf.org/html/bcp47#appendix-A). For
     * example, `en-US` or `fr-CA`.
     * @return Returns the Internal String
     */
    @JsonGetter("language_code")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetLanguageCode() {
        return this.languageCode;
    }

    /**
     * Getter for LanguageCode.
     * The code indicating the [language
     * preferences](https://developer.squareup.com/docs/build-basics/general-considerations/language-preferences)
     * of the merchant, in [BCP 47 format](https://tools.ietf.org/html/bcp47#appendix-A). For
     * example, `en-US` or `fr-CA`.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLanguageCode() {
        return OptionalNullable.getFrom(languageCode);
    }

    /**
     * Getter for Currency.
     * Indicates the associated currency for an amount of money. Values correspond to [ISO
     * 4217](https://wikipedia.org/wiki/ISO_4217).
     * @return Returns the String
     */
    @JsonGetter("currency")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCurrency() {
        return currency;
    }

    /**
     * Getter for Status.
     * @return Returns the String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStatus() {
        return status;
    }

    /**
     * Internal Getter for MainLocationId.
     * The ID of the [main
     * `Location`](https://developer.squareup.com/docs/locations-api#about-the-main-location) for
     * this merchant.
     * @return Returns the Internal String
     */
    @JsonGetter("main_location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetMainLocationId() {
        return this.mainLocationId;
    }

    /**
     * Getter for MainLocationId.
     * The ID of the [main
     * `Location`](https://developer.squareup.com/docs/locations-api#about-the-main-location) for
     * this merchant.
     * @return Returns the String
     */
    @JsonIgnore
    public String getMainLocationId() {
        return OptionalNullable.getFrom(mainLocationId);
    }

    /**
     * Getter for CreatedAt.
     * The time when the merchant was created, in RFC 3339 format. For more information, see
     * [Working with Dates](https://developer.squareup.com/docs/build-basics/working-with-dates).
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, businessName, country, languageCode, currency, status, mainLocationId, createdAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Merchant)) {
            return false;
        }
        Merchant other = (Merchant) obj;
        return Objects.equals(id, other.id)
                && Objects.equals(businessName, other.businessName)
                && Objects.equals(country, other.country)
                && Objects.equals(languageCode, other.languageCode)
                && Objects.equals(currency, other.currency)
                && Objects.equals(status, other.status)
                && Objects.equals(mainLocationId, other.mainLocationId)
                && Objects.equals(createdAt, other.createdAt);
    }

    /**
     * Converts this Merchant into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Merchant [" + "country=" + country + ", id=" + id + ", businessName=" + businessName
                + ", languageCode=" + languageCode + ", currency=" + currency + ", status=" + status
                + ", mainLocationId=" + mainLocationId + ", createdAt=" + createdAt + "]";
    }

    /**
     * Builds a new {@link Merchant.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Merchant.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(country)
                .id(getId())
                .currency(getCurrency())
                .status(getStatus())
                .createdAt(getCreatedAt());
        builder.businessName = internalGetBusinessName();
        builder.languageCode = internalGetLanguageCode();
        builder.mainLocationId = internalGetMainLocationId();
        return builder;
    }

    /**
     * Class to build instances of {@link Merchant}.
     */
    public static class Builder {
        private String country;
        private String id;
        private OptionalNullable<String> businessName;
        private OptionalNullable<String> languageCode;
        private String currency;
        private String status;
        private OptionalNullable<String> mainLocationId;
        private String createdAt;

        /**
         * Initialization constructor.
         * @param  country  String value for country.
         */
        public Builder(String country) {
            this.country = country;
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
         * Setter for id.
         * @param  id  String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for businessName.
         * @param  businessName  String value for businessName.
         * @return Builder
         */
        public Builder businessName(String businessName) {
            this.businessName = OptionalNullable.of(businessName);
            return this;
        }

        /**
         * UnSetter for businessName.
         * @return Builder
         */
        public Builder unsetBusinessName() {
            businessName = null;
            return this;
        }

        /**
         * Setter for languageCode.
         * @param  languageCode  String value for languageCode.
         * @return Builder
         */
        public Builder languageCode(String languageCode) {
            this.languageCode = OptionalNullable.of(languageCode);
            return this;
        }

        /**
         * UnSetter for languageCode.
         * @return Builder
         */
        public Builder unsetLanguageCode() {
            languageCode = null;
            return this;
        }

        /**
         * Setter for currency.
         * @param  currency  String value for currency.
         * @return Builder
         */
        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        /**
         * Setter for status.
         * @param  status  String value for status.
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Setter for mainLocationId.
         * @param  mainLocationId  String value for mainLocationId.
         * @return Builder
         */
        public Builder mainLocationId(String mainLocationId) {
            this.mainLocationId = OptionalNullable.of(mainLocationId);
            return this;
        }

        /**
         * UnSetter for mainLocationId.
         * @return Builder
         */
        public Builder unsetMainLocationId() {
            mainLocationId = null;
            return this;
        }

        /**
         * Setter for createdAt.
         * @param  createdAt  String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Builds a new {@link Merchant} object using the set fields.
         * @return {@link Merchant}
         */
        public Merchant build() {
            return new Merchant(country, id, businessName, languageCode, currency, status, mainLocationId, createdAt);
        }
    }
}
