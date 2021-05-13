
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for Site type.
 */
public class Site {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String siteTitle;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String domain;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean isPublished;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String updatedAt;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  siteTitle  String value for siteTitle.
     * @param  domain  String value for domain.
     * @param  isPublished  Boolean value for isPublished.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     */
    @JsonCreator
    public Site(
            @JsonProperty("id") String id,
            @JsonProperty("site_title") String siteTitle,
            @JsonProperty("domain") String domain,
            @JsonProperty("is_published") Boolean isPublished,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt) {
        this.id = id;
        this.siteTitle = siteTitle;
        this.domain = domain;
        this.isPublished = isPublished;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * Getter for Id.
     * The Square-assigned ID of the site.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return id;
    }

    /**
     * Getter for SiteTitle.
     * The title of the site.
     * @return Returns the String
     */
    @JsonGetter("site_title")
    public String getSiteTitle() {
        return siteTitle;
    }

    /**
     * Getter for Domain.
     * The domain of the site (without the protocol). For example, `mysite1.square.site`.
     * @return Returns the String
     */
    @JsonGetter("domain")
    public String getDomain() {
        return domain;
    }

    /**
     * Getter for IsPublished.
     * Indicates whether the site is published.
     * @return Returns the Boolean
     */
    @JsonGetter("is_published")
    public Boolean getIsPublished() {
        return isPublished;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp of when the site was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp of when the site was last updated, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, siteTitle, domain, isPublished, createdAt, updatedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Site)) {
            return false;
        }
        Site other = (Site) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(siteTitle, other.siteTitle)
            && Objects.equals(domain, other.domain)
            && Objects.equals(isPublished, other.isPublished)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(updatedAt, other.updatedAt);
    }

    /**
     * Converts this Site into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Site [" + "id=" + id + ", siteTitle=" + siteTitle + ", domain=" + domain
                + ", isPublished=" + isPublished + ", createdAt=" + createdAt + ", updatedAt="
                + updatedAt + "]";
    }

    /**
     * Builds a new {@link Site.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Site.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .siteTitle(getSiteTitle())
                .domain(getDomain())
                .isPublished(getIsPublished())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt());
        return builder;
    }

    /**
     * Class to build instances of {@link Site}.
     */
    public static class Builder {
        private String id;
        private String siteTitle;
        private String domain;
        private Boolean isPublished;
        private String createdAt;
        private String updatedAt;



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
         * Setter for siteTitle.
         * @param  siteTitle  String value for siteTitle.
         * @return Builder
         */
        public Builder siteTitle(String siteTitle) {
            this.siteTitle = siteTitle;
            return this;
        }

        /**
         * Setter for domain.
         * @param  domain  String value for domain.
         * @return Builder
         */
        public Builder domain(String domain) {
            this.domain = domain;
            return this;
        }

        /**
         * Setter for isPublished.
         * @param  isPublished  Boolean value for isPublished.
         * @return Builder
         */
        public Builder isPublished(Boolean isPublished) {
            this.isPublished = isPublished;
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
         * Setter for updatedAt.
         * @param  updatedAt  String value for updatedAt.
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * Builds a new {@link Site} object using the set fields.
         * @return {@link Site}
         */
        public Site build() {
            return new Site(id, siteTitle, domain, isPublished, createdAt, updatedAt);
        }
    }
}
