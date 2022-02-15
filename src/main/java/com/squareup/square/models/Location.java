
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for Location type.
 */
public class Location {
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
    private final String fullFormatLogoUrl;
    private final TaxIds taxIds;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  name  String value for name.
     * @param  address  Address value for address.
     * @param  timezone  String value for timezone.
     * @param  capabilities  List of String value for capabilities.
     * @param  status  String value for status.
     * @param  createdAt  String value for createdAt.
     * @param  merchantId  String value for merchantId.
     * @param  country  String value for country.
     * @param  languageCode  String value for languageCode.
     * @param  currency  String value for currency.
     * @param  phoneNumber  String value for phoneNumber.
     * @param  businessName  String value for businessName.
     * @param  type  String value for type.
     * @param  websiteUrl  String value for websiteUrl.
     * @param  businessHours  BusinessHours value for businessHours.
     * @param  businessEmail  String value for businessEmail.
     * @param  description  String value for description.
     * @param  twitterUsername  String value for twitterUsername.
     * @param  instagramUsername  String value for instagramUsername.
     * @param  facebookUrl  String value for facebookUrl.
     * @param  coordinates  Coordinates value for coordinates.
     * @param  logoUrl  String value for logoUrl.
     * @param  posBackgroundUrl  String value for posBackgroundUrl.
     * @param  mcc  String value for mcc.
     * @param  fullFormatLogoUrl  String value for fullFormatLogoUrl.
     * @param  taxIds  TaxIds value for taxIds.
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
            @JsonProperty("mcc") String mcc,
            @JsonProperty("full_format_logo_url") String fullFormatLogoUrl,
            @JsonProperty("tax_ids") TaxIds taxIds) {
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
        this.fullFormatLogoUrl = fullFormatLogoUrl;
        this.taxIds = taxIds;
    }

    /**
     * Getter for Id.
     * A short, generated string of letters and numbers that uniquely identifies this location
     * instance.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Getter for Name.
     * The name of the location. This information appears in the dashboard as the nickname. A
     * location name must be unique within a seller account.
     * @return Returns the String
     */
    @JsonGetter("name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getName() {
        return name;
    }

    /**
     * Getter for Address.
     * Represents a postal address in a country. For more information, see [Working with
     * Addresses](https://developer.squareup.com/docs/build-basics/working-with-addresses).
     * @return Returns the Address
     */
    @JsonGetter("address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Address getAddress() {
        return address;
    }

    /**
     * Getter for Timezone.
     * The [IANA Timezone](https://www.iana.org/time-zones) identifier for the timezone of the
     * location. For example, `America/Los_Angeles`.
     * @return Returns the String
     */
    @JsonGetter("timezone")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getTimezone() {
        return timezone;
    }

    /**
     * Getter for Capabilities.
     * The Square features that are enabled for the location. See
     * [LocationCapability]($m/LocationCapability) for possible values. See
     * [LocationCapability](#type-locationcapability) for possible values
     * @return Returns the List of String
     */
    @JsonGetter("capabilities")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<String> getCapabilities() {
        return capabilities;
    }

    /**
     * Getter for Status.
     * A location's status.
     * @return Returns the String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStatus() {
        return status;
    }

    /**
     * Getter for CreatedAt.
     * The time when the location was created, in RFC 3339 format. For more information, see
     * [Working with Dates](https://developer.squareup.com/docs/build-basics/working-with-dates).
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for MerchantId.
     * The ID of the merchant that owns the location.
     * @return Returns the String
     */
    @JsonGetter("merchant_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getMerchantId() {
        return merchantId;
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
     * Getter for LanguageCode.
     * The language associated with the location, in [BCP 47
     * format](https://tools.ietf.org/html/bcp47#appendix-A). For more information, see [Location
     * language code](https://developer.squareup.com/docs/locations-api#location-language-code).
     * @return Returns the String
     */
    @JsonGetter("language_code")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getLanguageCode() {
        return languageCode;
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
     * Getter for PhoneNumber.
     * The phone number of the location. For example, `+1 855-700-6000`.
     * @return Returns the String
     */
    @JsonGetter("phone_number")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Getter for BusinessName.
     * The business name of the location.
     * @return Returns the String
     */
    @JsonGetter("business_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getBusinessName() {
        return businessName;
    }

    /**
     * Getter for Type.
     * A location's type.
     * @return Returns the String
     */
    @JsonGetter("type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getType() {
        return type;
    }

    /**
     * Getter for WebsiteUrl.
     * The website URL of the location. For example, `https://squareup.com`.
     * @return Returns the String
     */
    @JsonGetter("website_url")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getWebsiteUrl() {
        return websiteUrl;
    }

    /**
     * Getter for BusinessHours.
     * The hours of operation for a location.
     * @return Returns the BusinessHours
     */
    @JsonGetter("business_hours")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public BusinessHours getBusinessHours() {
        return businessHours;
    }

    /**
     * Getter for BusinessEmail.
     * The email address of the location. This can be unique to the location, and is not always the
     * email address for the business owner or admin.
     * @return Returns the String
     */
    @JsonGetter("business_email")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getBusinessEmail() {
        return businessEmail;
    }

    /**
     * Getter for Description.
     * The description of the location. For example, `Main Street location`.
     * @return Returns the String
     */
    @JsonGetter("description")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDescription() {
        return description;
    }

    /**
     * Getter for TwitterUsername.
     * The Twitter username of the location without the '@' symbol. For example, `Square`.
     * @return Returns the String
     */
    @JsonGetter("twitter_username")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getTwitterUsername() {
        return twitterUsername;
    }

    /**
     * Getter for InstagramUsername.
     * The Instagram username of the location without the '@' symbol. For example, `square`.
     * @return Returns the String
     */
    @JsonGetter("instagram_username")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getInstagramUsername() {
        return instagramUsername;
    }

    /**
     * Getter for FacebookUrl.
     * The Facebook profile URL of the location. The URL should begin with 'facebook.com/'. For
     * example, `https://www.facebook.com/square`.
     * @return Returns the String
     */
    @JsonGetter("facebook_url")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getFacebookUrl() {
        return facebookUrl;
    }

    /**
     * Getter for Coordinates.
     * Latitude and longitude coordinates.
     * @return Returns the Coordinates
     */
    @JsonGetter("coordinates")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Getter for LogoUrl.
     * The URL of the logo image for the location. When configured in the Seller dashboard (Receipts
     * section), the logo appears on transactions (such as receipts and invoices) that Square
     * generates on behalf of the Seller. This image should have a roughly square (1:1) aspect ratio
     * and is recommended to be at least 200x200 pixels.
     * @return Returns the String
     */
    @JsonGetter("logo_url")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getLogoUrl() {
        return logoUrl;
    }

    /**
     * Getter for PosBackgroundUrl.
     * The URL of the Point of Sale background image for the location.
     * @return Returns the String
     */
    @JsonGetter("pos_background_url")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPosBackgroundUrl() {
        return posBackgroundUrl;
    }

    /**
     * Getter for Mcc.
     * A four-digit number that describes the kind of goods or services sold at the location. The
     * [merchant category code
     * (MCC)](https://developer.squareup.com/docs/locations-api#initialize-a-merchant-category-code)
     * of the location as standardized by ISO 18245. For example, `5045`, for a location that sells
     * computer goods and software.
     * @return Returns the String
     */
    @JsonGetter("mcc")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getMcc() {
        return mcc;
    }

    /**
     * Getter for FullFormatLogoUrl.
     * The URL of a full-format logo image for the location. When configured in the Seller dashboard
     * (Receipts section), the logo appears on transactions (such as receipts and invoices) that
     * Square generates on behalf of the Seller. This image can be wider than it is tall, and is
     * recommended to be at least 1280x648 pixels.
     * @return Returns the String
     */
    @JsonGetter("full_format_logo_url")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getFullFormatLogoUrl() {
        return fullFormatLogoUrl;
    }

    /**
     * Getter for TaxIds.
     * Identifiers for the location used by various governments for tax purposes.
     * @return Returns the TaxIds
     */
    @JsonGetter("tax_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public TaxIds getTaxIds() {
        return taxIds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, timezone, capabilities, status, createdAt,
                merchantId, country, languageCode, currency, phoneNumber, businessName, type,
                websiteUrl, businessHours, businessEmail, description, twitterUsername,
                instagramUsername, facebookUrl, coordinates, logoUrl, posBackgroundUrl, mcc,
                fullFormatLogoUrl, taxIds);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Location)) {
            return false;
        }
        Location other = (Location) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(name, other.name)
            && Objects.equals(address, other.address)
            && Objects.equals(timezone, other.timezone)
            && Objects.equals(capabilities, other.capabilities)
            && Objects.equals(status, other.status)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(merchantId, other.merchantId)
            && Objects.equals(country, other.country)
            && Objects.equals(languageCode, other.languageCode)
            && Objects.equals(currency, other.currency)
            && Objects.equals(phoneNumber, other.phoneNumber)
            && Objects.equals(businessName, other.businessName)
            && Objects.equals(type, other.type)
            && Objects.equals(websiteUrl, other.websiteUrl)
            && Objects.equals(businessHours, other.businessHours)
            && Objects.equals(businessEmail, other.businessEmail)
            && Objects.equals(description, other.description)
            && Objects.equals(twitterUsername, other.twitterUsername)
            && Objects.equals(instagramUsername, other.instagramUsername)
            && Objects.equals(facebookUrl, other.facebookUrl)
            && Objects.equals(coordinates, other.coordinates)
            && Objects.equals(logoUrl, other.logoUrl)
            && Objects.equals(posBackgroundUrl, other.posBackgroundUrl)
            && Objects.equals(mcc, other.mcc)
            && Objects.equals(fullFormatLogoUrl, other.fullFormatLogoUrl)
            && Objects.equals(taxIds, other.taxIds);
    }

    /**
     * Converts this Location into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Location [" + "id=" + id + ", name=" + name + ", address=" + address + ", timezone="
                + timezone + ", capabilities=" + capabilities + ", status=" + status
                + ", createdAt=" + createdAt + ", merchantId=" + merchantId + ", country=" + country
                + ", languageCode=" + languageCode + ", currency=" + currency + ", phoneNumber="
                + phoneNumber + ", businessName=" + businessName + ", type=" + type
                + ", websiteUrl=" + websiteUrl + ", businessHours=" + businessHours
                + ", businessEmail=" + businessEmail + ", description=" + description
                + ", twitterUsername=" + twitterUsername + ", instagramUsername="
                + instagramUsername + ", facebookUrl=" + facebookUrl + ", coordinates="
                + coordinates + ", logoUrl=" + logoUrl + ", posBackgroundUrl=" + posBackgroundUrl
                + ", mcc=" + mcc + ", fullFormatLogoUrl=" + fullFormatLogoUrl + ", taxIds=" + taxIds
                + "]";
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
                .mcc(getMcc())
                .fullFormatLogoUrl(getFullFormatLogoUrl())
                .taxIds(getTaxIds());
        return builder;
    }

    /**
     * Class to build instances of {@link Location}.
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
        private String fullFormatLogoUrl;
        private TaxIds taxIds;



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
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Setter for address.
         * @param  address  Address value for address.
         * @return Builder
         */
        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        /**
         * Setter for timezone.
         * @param  timezone  String value for timezone.
         * @return Builder
         */
        public Builder timezone(String timezone) {
            this.timezone = timezone;
            return this;
        }

        /**
         * Setter for capabilities.
         * @param  capabilities  List of String value for capabilities.
         * @return Builder
         */
        public Builder capabilities(List<String> capabilities) {
            this.capabilities = capabilities;
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
         * Setter for createdAt.
         * @param  createdAt  String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for merchantId.
         * @param  merchantId  String value for merchantId.
         * @return Builder
         */
        public Builder merchantId(String merchantId) {
            this.merchantId = merchantId;
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
         * Setter for languageCode.
         * @param  languageCode  String value for languageCode.
         * @return Builder
         */
        public Builder languageCode(String languageCode) {
            this.languageCode = languageCode;
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
         * Setter for phoneNumber.
         * @param  phoneNumber  String value for phoneNumber.
         * @return Builder
         */
        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        /**
         * Setter for businessName.
         * @param  businessName  String value for businessName.
         * @return Builder
         */
        public Builder businessName(String businessName) {
            this.businessName = businessName;
            return this;
        }

        /**
         * Setter for type.
         * @param  type  String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Setter for websiteUrl.
         * @param  websiteUrl  String value for websiteUrl.
         * @return Builder
         */
        public Builder websiteUrl(String websiteUrl) {
            this.websiteUrl = websiteUrl;
            return this;
        }

        /**
         * Setter for businessHours.
         * @param  businessHours  BusinessHours value for businessHours.
         * @return Builder
         */
        public Builder businessHours(BusinessHours businessHours) {
            this.businessHours = businessHours;
            return this;
        }

        /**
         * Setter for businessEmail.
         * @param  businessEmail  String value for businessEmail.
         * @return Builder
         */
        public Builder businessEmail(String businessEmail) {
            this.businessEmail = businessEmail;
            return this;
        }

        /**
         * Setter for description.
         * @param  description  String value for description.
         * @return Builder
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        /**
         * Setter for twitterUsername.
         * @param  twitterUsername  String value for twitterUsername.
         * @return Builder
         */
        public Builder twitterUsername(String twitterUsername) {
            this.twitterUsername = twitterUsername;
            return this;
        }

        /**
         * Setter for instagramUsername.
         * @param  instagramUsername  String value for instagramUsername.
         * @return Builder
         */
        public Builder instagramUsername(String instagramUsername) {
            this.instagramUsername = instagramUsername;
            return this;
        }

        /**
         * Setter for facebookUrl.
         * @param  facebookUrl  String value for facebookUrl.
         * @return Builder
         */
        public Builder facebookUrl(String facebookUrl) {
            this.facebookUrl = facebookUrl;
            return this;
        }

        /**
         * Setter for coordinates.
         * @param  coordinates  Coordinates value for coordinates.
         * @return Builder
         */
        public Builder coordinates(Coordinates coordinates) {
            this.coordinates = coordinates;
            return this;
        }

        /**
         * Setter for logoUrl.
         * @param  logoUrl  String value for logoUrl.
         * @return Builder
         */
        public Builder logoUrl(String logoUrl) {
            this.logoUrl = logoUrl;
            return this;
        }

        /**
         * Setter for posBackgroundUrl.
         * @param  posBackgroundUrl  String value for posBackgroundUrl.
         * @return Builder
         */
        public Builder posBackgroundUrl(String posBackgroundUrl) {
            this.posBackgroundUrl = posBackgroundUrl;
            return this;
        }

        /**
         * Setter for mcc.
         * @param  mcc  String value for mcc.
         * @return Builder
         */
        public Builder mcc(String mcc) {
            this.mcc = mcc;
            return this;
        }

        /**
         * Setter for fullFormatLogoUrl.
         * @param  fullFormatLogoUrl  String value for fullFormatLogoUrl.
         * @return Builder
         */
        public Builder fullFormatLogoUrl(String fullFormatLogoUrl) {
            this.fullFormatLogoUrl = fullFormatLogoUrl;
            return this;
        }

        /**
         * Setter for taxIds.
         * @param  taxIds  TaxIds value for taxIds.
         * @return Builder
         */
        public Builder taxIds(TaxIds taxIds) {
            this.taxIds = taxIds;
            return this;
        }

        /**
         * Builds a new {@link Location} object using the set fields.
         * @return {@link Location}
         */
        public Location build() {
            return new Location(id, name, address, timezone, capabilities, status, createdAt,
                    merchantId, country, languageCode, currency, phoneNumber, businessName, type,
                    websiteUrl, businessHours, businessEmail, description, twitterUsername,
                    instagramUsername, facebookUrl, coordinates, logoUrl, posBackgroundUrl, mcc,
                    fullFormatLogoUrl, taxIds);
        }
    }
}
