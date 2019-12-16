package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class Location {

    @JsonCreator
    public Location(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("address") Address address,
            @JsonProperty("timezone") String timezone,
            @JsonProperty("capabilities") List<String> capabilities,
            @JsonProperty("status") String status,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("merchant_id") String merchantId,
            @JsonProperty("country") String country,
            @JsonProperty("language_code") String languageCode,
            @JsonProperty("currency") String currency,
            @JsonProperty("phone_number") String phoneNumber,
            @JsonProperty("business_name") String businessName,
            @JsonProperty("type") String type,
            @JsonProperty("website_url") String websiteUrl,
            @JsonProperty("business_hours") BusinessHours businessHours,
            @JsonProperty("business_email") String businessEmail,
            @JsonProperty("description") String description,
            @JsonProperty("twitter_username") String twitterUsername,
            @JsonProperty("instagram_username") String instagramUsername,
            @JsonProperty("facebook_url") String facebookUrl,
            @JsonProperty("coordinates") Coordinates coordinates,
            @JsonProperty("logo_url") String logoUrl,
            @JsonProperty("pos_background_url") String posBackgroundUrl,
            @JsonProperty("mcc") String mcc) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.timezone = timezone;
        this.capabilities = capabilities;
        this.status = status;
        this.createdAt = createdAt;
        this.merchantId = merchantId;
        this.country = country;
        this.languageCode = languageCode;
        this.currency = currency;
        this.phoneNumber = phoneNumber;
        this.businessName = businessName;
        this.type = type;
        this.websiteUrl = websiteUrl;
        this.businessHours = businessHours;
        this.businessEmail = businessEmail;
        this.description = description;
        this.twitterUsername = twitterUsername;
        this.instagramUsername = instagramUsername;
        this.facebookUrl = facebookUrl;
        this.coordinates = coordinates;
        this.logoUrl = logoUrl;
        this.posBackgroundUrl = posBackgroundUrl;
        this.mcc = mcc;
    }

    private final String id;
    private final String name;
    private final Address address;
    private final String timezone;
    private final List<String> capabilities;
    private final String status;
    private final String createdAt;
    private final String merchantId;
    private final String country;
    private final String languageCode;
    private final String currency;
    private final String phoneNumber;
    private final String businessName;
    private final String type;
    private final String websiteUrl;
    private final BusinessHours businessHours;
    private final String businessEmail;
    private final String description;
    private final String twitterUsername;
    private final String instagramUsername;
    private final String facebookUrl;
    private final Coordinates coordinates;
    private final String logoUrl;
    private final String posBackgroundUrl;
    private final String mcc;

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, timezone, capabilities, status, createdAt, merchantId, country, languageCode, currency, phoneNumber, businessName, type, websiteUrl, businessHours, businessEmail, description, twitterUsername, instagramUsername, facebookUrl, coordinates, logoUrl, posBackgroundUrl, mcc);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Location)) {
            return false;
        }
        Location location = (Location) o;
        return Objects.equals(id, location.id) &&
            Objects.equals(name, location.name) &&
            Objects.equals(address, location.address) &&
            Objects.equals(timezone, location.timezone) &&
            Objects.equals(capabilities, location.capabilities) &&
            Objects.equals(status, location.status) &&
            Objects.equals(createdAt, location.createdAt) &&
            Objects.equals(merchantId, location.merchantId) &&
            Objects.equals(country, location.country) &&
            Objects.equals(languageCode, location.languageCode) &&
            Objects.equals(currency, location.currency) &&
            Objects.equals(phoneNumber, location.phoneNumber) &&
            Objects.equals(businessName, location.businessName) &&
            Objects.equals(type, location.type) &&
            Objects.equals(websiteUrl, location.websiteUrl) &&
            Objects.equals(businessHours, location.businessHours) &&
            Objects.equals(businessEmail, location.businessEmail) &&
            Objects.equals(description, location.description) &&
            Objects.equals(twitterUsername, location.twitterUsername) &&
            Objects.equals(instagramUsername, location.instagramUsername) &&
            Objects.equals(facebookUrl, location.facebookUrl) &&
            Objects.equals(coordinates, location.coordinates) &&
            Objects.equals(logoUrl, location.logoUrl) &&
            Objects.equals(posBackgroundUrl, location.posBackgroundUrl) &&
            Objects.equals(mcc, location.mcc);
    }

    /**
     * Getter for Id.
     * The Square-issued ID of the location.
     */
    @JsonGetter("id")
    public String getId() { 
        return this.id;
    }

    /**
     * Getter for Name.
     * The name of the location.
     * This information appears in the dashboard as the nickname.
     */
    @JsonGetter("name")
    public String getName() { 
        return this.name;
    }

    /**
     * Getter for Address.
     * Represents a physical address.
     */
    @JsonGetter("address")
    public Address getAddress() { 
        return this.address;
    }

    /**
     * Getter for Timezone.
     * The [IANA Timezone](https://www.iana.org/time-zones) identifier for
     * the timezone of the location.
     */
    @JsonGetter("timezone")
    public String getTimezone() { 
        return this.timezone;
    }

    /**
     * Getter for Capabilities.
     * The Square features that are enabled for the location.
     * See [LocationCapability](#type-locationcapability) for possible values.
     * See [LocationCapability](#type-locationcapability) for possible values
     */
    @JsonGetter("capabilities")
    public List<String> getCapabilities() { 
        return this.capabilities;
    }

    /**
     * Getter for Status.
     * The status of the location, whether a location is active or inactive.
     */
    @JsonGetter("status")
    public String getStatus() { 
        return this.status;
    }

    /**
     * Getter for CreatedAt.
     * The time when the location was created, in RFC 3339 format.
     */
    @JsonGetter("created_at")
    public String getCreatedAt() { 
        return this.createdAt;
    }

    /**
     * Getter for MerchantId.
     * The ID of the merchant that owns the location.
     */
    @JsonGetter("merchant_id")
    public String getMerchantId() { 
        return this.merchantId;
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
     * The language associated with the location, in
     * [BCP 47 format](https://tools.ietf.org/html/bcp47#appendix-A).
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
     * Getter for PhoneNumber.
     * The phone number of the location in human readable format.
     */
    @JsonGetter("phone_number")
    public String getPhoneNumber() { 
        return this.phoneNumber;
    }

    /**
     * Getter for BusinessName.
     * The business name of the location
     * This is the name visible to the customers of the location.
     * For example, this name appears on customer receipts.
     */
    @JsonGetter("business_name")
    public String getBusinessName() { 
        return this.businessName;
    }

    /**
     * Getter for Type.
     * A location's physical or mobile type.
     */
    @JsonGetter("type")
    public String getType() { 
        return this.type;
    }

    /**
     * Getter for WebsiteUrl.
     * The website URL of the location.
     */
    @JsonGetter("website_url")
    public String getWebsiteUrl() { 
        return this.websiteUrl;
    }

    /**
     * Getter for BusinessHours.
     * Represents the hours of operation for a business location.
     */
    @JsonGetter("business_hours")
    public BusinessHours getBusinessHours() { 
        return this.businessHours;
    }

    /**
     * Getter for BusinessEmail.
     * The email of the location.
     * This email is visible to the customers of the location.
     * For example, the email appears on customer receipts.
     */
    @JsonGetter("business_email")
    public String getBusinessEmail() { 
        return this.businessEmail;
    }

    /**
     * Getter for Description.
     * The description of the location.
     */
    @JsonGetter("description")
    public String getDescription() { 
        return this.description;
    }

    /**
     * Getter for TwitterUsername.
     * The Twitter username of the location without the '&#64;' symbol.
     */
    @JsonGetter("twitter_username")
    public String getTwitterUsername() { 
        return this.twitterUsername;
    }

    /**
     * Getter for InstagramUsername.
     * The Instagram username of the location without the '&#64;' symbol.
     */
    @JsonGetter("instagram_username")
    public String getInstagramUsername() { 
        return this.instagramUsername;
    }

    /**
     * Getter for FacebookUrl.
     * The Facebook profile URL of the location. The URL should begin with 'facebook.com/'.
     */
    @JsonGetter("facebook_url")
    public String getFacebookUrl() { 
        return this.facebookUrl;
    }

    /**
     * Getter for Coordinates.
     * Latitude and longitude coordinates.
     */
    @JsonGetter("coordinates")
    public Coordinates getCoordinates() { 
        return this.coordinates;
    }

    /**
     * Getter for LogoUrl.
     * The URL of the logo image for the location.
     */
    @JsonGetter("logo_url")
    public String getLogoUrl() { 
        return this.logoUrl;
    }

    /**
     * Getter for PosBackgroundUrl.
     * The URL of the Point of Sale background image for the location.
     */
    @JsonGetter("pos_background_url")
    public String getPosBackgroundUrl() { 
        return this.posBackgroundUrl;
    }

    /**
     * Getter for Mcc.
     * The merchant category code (MCC) of the location, as standardized by ISO 18245.
     * The MCC describes the kind of goods or services sold at the location.
     */
    @JsonGetter("mcc")
    public String getMcc() { 
        return this.mcc;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .id(getId())
            .name(getName())
            .address(getAddress())
            .timezone(getTimezone())
            .capabilities(getCapabilities())
            .status(getStatus())
            .createdAt(getCreatedAt())
            .merchantId(getMerchantId())
            .country(getCountry())
            .languageCode(getLanguageCode())
            .currency(getCurrency())
            .phoneNumber(getPhoneNumber())
            .businessName(getBusinessName())
            .type(getType())
            .websiteUrl(getWebsiteUrl())
            .businessHours(getBusinessHours())
            .businessEmail(getBusinessEmail())
            .description(getDescription())
            .twitterUsername(getTwitterUsername())
            .instagramUsername(getInstagramUsername())
            .facebookUrl(getFacebookUrl())
            .coordinates(getCoordinates())
            .logoUrl(getLogoUrl())
            .posBackgroundUrl(getPosBackgroundUrl())
            .mcc(getMcc());
            return builder;
    }

    public static class Builder {
        private String id;
        private String name;
        private Address address;
        private String timezone;
        private List<String> capabilities;
        private String status;
        private String createdAt;
        private String merchantId;
        private String country;
        private String languageCode;
        private String currency;
        private String phoneNumber;
        private String businessName;
        private String type;
        private String websiteUrl;
        private BusinessHours businessHours;
        private String businessEmail;
        private String description;
        private String twitterUsername;
        private String instagramUsername;
        private String facebookUrl;
        private Coordinates coordinates;
        private String logoUrl;
        private String posBackgroundUrl;
        private String mcc;

        public Builder() { }

        public Builder id(String value) {
            id = value;
            return this;
        }
        public Builder name(String value) {
            name = value;
            return this;
        }
        public Builder address(Address value) {
            address = value;
            return this;
        }
        public Builder timezone(String value) {
            timezone = value;
            return this;
        }
        public Builder capabilities(List<String> value) {
            capabilities = value;
            return this;
        }
        public Builder status(String value) {
            status = value;
            return this;
        }
        public Builder createdAt(String value) {
            createdAt = value;
            return this;
        }
        public Builder merchantId(String value) {
            merchantId = value;
            return this;
        }
        public Builder country(String value) {
            country = value;
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
        public Builder phoneNumber(String value) {
            phoneNumber = value;
            return this;
        }
        public Builder businessName(String value) {
            businessName = value;
            return this;
        }
        public Builder type(String value) {
            type = value;
            return this;
        }
        public Builder websiteUrl(String value) {
            websiteUrl = value;
            return this;
        }
        public Builder businessHours(BusinessHours value) {
            businessHours = value;
            return this;
        }
        public Builder businessEmail(String value) {
            businessEmail = value;
            return this;
        }
        public Builder description(String value) {
            description = value;
            return this;
        }
        public Builder twitterUsername(String value) {
            twitterUsername = value;
            return this;
        }
        public Builder instagramUsername(String value) {
            instagramUsername = value;
            return this;
        }
        public Builder facebookUrl(String value) {
            facebookUrl = value;
            return this;
        }
        public Builder coordinates(Coordinates value) {
            coordinates = value;
            return this;
        }
        public Builder logoUrl(String value) {
            logoUrl = value;
            return this;
        }
        public Builder posBackgroundUrl(String value) {
            posBackgroundUrl = value;
            return this;
        }
        public Builder mcc(String value) {
            mcc = value;
            return this;
        }

        public Location build() {
            return new Location(id,
                name,
                address,
                timezone,
                capabilities,
                status,
                createdAt,
                merchantId,
                country,
                languageCode,
                currency,
                phoneNumber,
                businessName,
                type,
                websiteUrl,
                businessHours,
                businessEmail,
                description,
                twitterUsername,
                instagramUsername,
                facebookUrl,
                coordinates,
                logoUrl,
                posBackgroundUrl,
                mcc);
        }
    }
}
