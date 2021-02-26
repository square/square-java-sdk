
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for RetrieveObsMigrationProfileResponse type.
 */
public class RetrieveObsMigrationProfileResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean bannerEnabled;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String bannerText;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String bannerCtaText;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String bannerCtaUrl;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  bannerEnabled  Boolean value for bannerEnabled.
     * @param  bannerText  String value for bannerText.
     * @param  bannerCtaText  String value for bannerCtaText.
     * @param  bannerCtaUrl  String value for bannerCtaUrl.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public RetrieveObsMigrationProfileResponse(
            @JsonProperty("banner_enabled") Boolean bannerEnabled,
            @JsonProperty("banner_text") String bannerText,
            @JsonProperty("banner_cta_text") String bannerCtaText,
            @JsonProperty("banner_cta_url") String bannerCtaUrl,
            @JsonProperty("errors") List<Error> errors) {
        this.bannerEnabled = bannerEnabled;
        this.bannerText = bannerText;
        this.bannerCtaText = bannerCtaText;
        this.bannerCtaUrl = bannerCtaUrl;
        this.errors = errors;
    }

    /**
     * Getter for BannerEnabled.
     * Indicates whether the seller has enabled the COVID banner (`true`) or not (`false`).
     * @return Returns the Boolean
     */
    @JsonGetter("banner_enabled")
    public Boolean getBannerEnabled() {
        return bannerEnabled;
    }

    /**
     * Getter for BannerText.
     * The text appearing on the COVID banner.
     * @return Returns the String
     */
    @JsonGetter("banner_text")
    public String getBannerText() {
        return bannerText;
    }

    /**
     * Getter for BannerCtaText.
     * The text of the label of the CTA button beneath the banner.
     * @return Returns the String
     */
    @JsonGetter("banner_cta_text")
    public String getBannerCtaText() {
        return bannerCtaText;
    }

    /**
     * Getter for BannerCtaUrl.
     * The URL to link to when the CTA button is clicked.
     * @return Returns the String
     */
    @JsonGetter("banner_cta_url")
    public String getBannerCtaUrl() {
        return bannerCtaUrl;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bannerEnabled, bannerText, bannerCtaText, bannerCtaUrl, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveObsMigrationProfileResponse)) {
            return false;
        }
        RetrieveObsMigrationProfileResponse other = (RetrieveObsMigrationProfileResponse) obj;
        return Objects.equals(bannerEnabled, other.bannerEnabled)
            && Objects.equals(bannerText, other.bannerText)
            && Objects.equals(bannerCtaText, other.bannerCtaText)
            && Objects.equals(bannerCtaUrl, other.bannerCtaUrl)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this RetrieveObsMigrationProfileResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveObsMigrationProfileResponse [" + "bannerEnabled=" + bannerEnabled
                + ", bannerText=" + bannerText + ", bannerCtaText=" + bannerCtaText
                + ", bannerCtaUrl=" + bannerCtaUrl + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link RetrieveObsMigrationProfileResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveObsMigrationProfileResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .bannerEnabled(getBannerEnabled())
                .bannerText(getBannerText())
                .bannerCtaText(getBannerCtaText())
                .bannerCtaUrl(getBannerCtaUrl())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link RetrieveObsMigrationProfileResponse}.
     */
    public static class Builder {
        private Boolean bannerEnabled;
        private String bannerText;
        private String bannerCtaText;
        private String bannerCtaUrl;
        private List<Error> errors;



        /**
         * Setter for bannerEnabled.
         * @param  bannerEnabled  Boolean value for bannerEnabled.
         * @return Builder
         */
        public Builder bannerEnabled(Boolean bannerEnabled) {
            this.bannerEnabled = bannerEnabled;
            return this;
        }

        /**
         * Setter for bannerText.
         * @param  bannerText  String value for bannerText.
         * @return Builder
         */
        public Builder bannerText(String bannerText) {
            this.bannerText = bannerText;
            return this;
        }

        /**
         * Setter for bannerCtaText.
         * @param  bannerCtaText  String value for bannerCtaText.
         * @return Builder
         */
        public Builder bannerCtaText(String bannerCtaText) {
            this.bannerCtaText = bannerCtaText;
            return this;
        }

        /**
         * Setter for bannerCtaUrl.
         * @param  bannerCtaUrl  String value for bannerCtaUrl.
         * @return Builder
         */
        public Builder bannerCtaUrl(String bannerCtaUrl) {
            this.bannerCtaUrl = bannerCtaUrl;
            return this;
        }

        /**
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Builds a new {@link RetrieveObsMigrationProfileResponse} object using the set fields.
         * @return {@link RetrieveObsMigrationProfileResponse}
         */
        public RetrieveObsMigrationProfileResponse build() {
            return new RetrieveObsMigrationProfileResponse(bannerEnabled, bannerText, bannerCtaText,
                    bannerCtaUrl, errors);
        }
    }
}
