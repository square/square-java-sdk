package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for Location type.
 */
public class Location {

    /**
     * Initialization constructor.
     * @param id
     * @param name
     * @param address
     * @param timezone
     * @param capabilities
     * @param status
     * @param createdAt
     * @param merchantId
     * @param country
     * @param languageCode
     * @param currency
     * @param phoneNumber
     * @param businessName
     * @param type
     * @param websiteUrl
     * @param businessHours
     * @param businessEmail
     * @param description
     * @param twitterUsername
     * @param instagramUsername
     * @param facebookUrl
     * @param coordinates
     * @param logoUrl
     * @param posBackgroundUrl
     * @param mcc
     */
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
     * The Twitter username of the location without the '@' symbol.
     */
    @JsonGetter("twitter_username")
    public String getTwitterUsername() {
        return this.twitterUsername;
    }

    /**
     * Getter for InstagramUsername.
     * The Instagram username of the location without the '@' symbol.
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

 
    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, timezone, capabilities, status, createdAt, merchantId,
            country, languageCode, currency, phoneNumber, businessName, type, websiteUrl,
            businessHours, businessEmail, description, twitterUsername, instagramUsername,
            facebookUrl, coordinates, logoUrl, posBackgroundUrl, mcc);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof Location)) {
            return false;
        }
        Location location = (Location) obj;
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
     * Builds a new {@link Location.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Location.Builder} object
     */
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

    /**
     * Class to build instances of {@link Location}
     */
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

        /**
         * Initialization constructor
         */
        public Builder() {
           
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
         * Setter for address
         * @param address
         * @return Builder
         */
        public Builder address(Address address) {
            this.address = address;
            return this;
        }
        /**
         * Setter for timezone
         * @param timezone
         * @return Builder
         */
        public Builder timezone(String timezone) {
            this.timezone = timezone;
            return this;
        }
        /**
         * Setter for capabilities
         * @param capabilities
         * @return Builder
         */
        public Builder capabilities(List<String> capabilities) {
            this.capabilities = capabilities;
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
         * Setter for createdAt
         * @param createdAt
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }
        /**
         * Setter for merchantId
         * @param merchantId
         * @return Builder
         */
        public Builder merchantId(String merchantId) {
            this.merchantId = merchantId;
            return this;
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
         * Setter for phoneNumber
         * @param phoneNumber
         * @return Builder
         */
        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
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
         * Setter for type
         * @param type
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }
        /**
         * Setter for websiteUrl
         * @param websiteUrl
         * @return Builder
         */
        public Builder websiteUrl(String websiteUrl) {
            this.websiteUrl = websiteUrl;
            return this;
        }
        /**
         * Setter for businessHours
         * @param businessHours
         * @return Builder
         */
        public Builder businessHours(BusinessHours businessHours) {
            this.businessHours = businessHours;
            return this;
        }
        /**
         * Setter for businessEmail
         * @param businessEmail
         * @return Builder
         */
        public Builder businessEmail(String businessEmail) {
            this.businessEmail = businessEmail;
            return this;
        }
        /**
         * Setter for description
         * @param description
         * @return Builder
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }
        /**
         * Setter for twitterUsername
         * @param twitterUsername
         * @return Builder
         */
        public Builder twitterUsername(String twitterUsername) {
            this.twitterUsername = twitterUsername;
            return this;
        }
        /**
         * Setter for instagramUsername
         * @param instagramUsername
         * @return Builder
         */
        public Builder instagramUsername(String instagramUsername) {
            this.instagramUsername = instagramUsername;
            return this;
        }
        /**
         * Setter for facebookUrl
         * @param facebookUrl
         * @return Builder
         */
        public Builder facebookUrl(String facebookUrl) {
            this.facebookUrl = facebookUrl;
            return this;
        }
        /**
         * Setter for coordinates
         * @param coordinates
         * @return Builder
         */
        public Builder coordinates(Coordinates coordinates) {
            this.coordinates = coordinates;
            return this;
        }
        /**
         * Setter for logoUrl
         * @param logoUrl
         * @return Builder
         */
        public Builder logoUrl(String logoUrl) {
            this.logoUrl = logoUrl;
            return this;
        }
        /**
         * Setter for posBackgroundUrl
         * @param posBackgroundUrl
         * @return Builder
         */
        public Builder posBackgroundUrl(String posBackgroundUrl) {
            this.posBackgroundUrl = posBackgroundUrl;
            return this;
        }
        /**
         * Setter for mcc
         * @param mcc
         * @return Builder
         */
        public Builder mcc(String mcc) {
            this.mcc = mcc;
            return this;
        }

        /**
         * Builds a new {@link Location} object using the set fields.
         * @return {@link Location}
         */
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
