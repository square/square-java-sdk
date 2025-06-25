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
 * This is a model class for CatalogEcomSeoData type.
 */
public class CatalogEcomSeoData {
    private final OptionalNullable<String> pageTitle;
    private final OptionalNullable<String> pageDescription;
    private final OptionalNullable<String> permalink;

    /**
     * Initialization constructor.
     * @param  pageTitle  String value for pageTitle.
     * @param  pageDescription  String value for pageDescription.
     * @param  permalink  String value for permalink.
     */
    @JsonCreator
    public CatalogEcomSeoData(
            @JsonProperty("page_title") String pageTitle,
            @JsonProperty("page_description") String pageDescription,
            @JsonProperty("permalink") String permalink) {
        this.pageTitle = OptionalNullable.of(pageTitle);
        this.pageDescription = OptionalNullable.of(pageDescription);
        this.permalink = OptionalNullable.of(permalink);
    }

    /**
     * Initialization constructor.
     * @param  pageTitle  String value for pageTitle.
     * @param  pageDescription  String value for pageDescription.
     * @param  permalink  String value for permalink.
     */
    protected CatalogEcomSeoData(
            OptionalNullable<String> pageTitle,
            OptionalNullable<String> pageDescription,
            OptionalNullable<String> permalink) {
        this.pageTitle = pageTitle;
        this.pageDescription = pageDescription;
        this.permalink = permalink;
    }

    /**
     * Internal Getter for PageTitle.
     * The SEO title used for the Square Online store.
     * @return Returns the Internal String
     */
    @JsonGetter("page_title")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetPageTitle() {
        return this.pageTitle;
    }

    /**
     * Getter for PageTitle.
     * The SEO title used for the Square Online store.
     * @return Returns the String
     */
    @JsonIgnore
    public String getPageTitle() {
        return OptionalNullable.getFrom(pageTitle);
    }

    /**
     * Internal Getter for PageDescription.
     * The SEO description used for the Square Online store.
     * @return Returns the Internal String
     */
    @JsonGetter("page_description")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetPageDescription() {
        return this.pageDescription;
    }

    /**
     * Getter for PageDescription.
     * The SEO description used for the Square Online store.
     * @return Returns the String
     */
    @JsonIgnore
    public String getPageDescription() {
        return OptionalNullable.getFrom(pageDescription);
    }

    /**
     * Internal Getter for Permalink.
     * The SEO permalink used for the Square Online store.
     * @return Returns the Internal String
     */
    @JsonGetter("permalink")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetPermalink() {
        return this.permalink;
    }

    /**
     * Getter for Permalink.
     * The SEO permalink used for the Square Online store.
     * @return Returns the String
     */
    @JsonIgnore
    public String getPermalink() {
        return OptionalNullable.getFrom(permalink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageTitle, pageDescription, permalink);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogEcomSeoData)) {
            return false;
        }
        CatalogEcomSeoData other = (CatalogEcomSeoData) obj;
        return Objects.equals(pageTitle, other.pageTitle)
                && Objects.equals(pageDescription, other.pageDescription)
                && Objects.equals(permalink, other.permalink);
    }

    /**
     * Converts this CatalogEcomSeoData into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogEcomSeoData [" + "pageTitle=" + pageTitle + ", pageDescription=" + pageDescription
                + ", permalink=" + permalink + "]";
    }

    /**
     * Builds a new {@link CatalogEcomSeoData.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogEcomSeoData.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.pageTitle = internalGetPageTitle();
        builder.pageDescription = internalGetPageDescription();
        builder.permalink = internalGetPermalink();
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogEcomSeoData}.
     */
    public static class Builder {
        private OptionalNullable<String> pageTitle;
        private OptionalNullable<String> pageDescription;
        private OptionalNullable<String> permalink;

        /**
         * Setter for pageTitle.
         * @param  pageTitle  String value for pageTitle.
         * @return Builder
         */
        public Builder pageTitle(String pageTitle) {
            this.pageTitle = OptionalNullable.of(pageTitle);
            return this;
        }

        /**
         * UnSetter for pageTitle.
         * @return Builder
         */
        public Builder unsetPageTitle() {
            pageTitle = null;
            return this;
        }

        /**
         * Setter for pageDescription.
         * @param  pageDescription  String value for pageDescription.
         * @return Builder
         */
        public Builder pageDescription(String pageDescription) {
            this.pageDescription = OptionalNullable.of(pageDescription);
            return this;
        }

        /**
         * UnSetter for pageDescription.
         * @return Builder
         */
        public Builder unsetPageDescription() {
            pageDescription = null;
            return this;
        }

        /**
         * Setter for permalink.
         * @param  permalink  String value for permalink.
         * @return Builder
         */
        public Builder permalink(String permalink) {
            this.permalink = OptionalNullable.of(permalink);
            return this;
        }

        /**
         * UnSetter for permalink.
         * @return Builder
         */
        public Builder unsetPermalink() {
            permalink = null;
            return this;
        }

        /**
         * Builds a new {@link CatalogEcomSeoData} object using the set fields.
         * @return {@link CatalogEcomSeoData}
         */
        public CatalogEcomSeoData build() {
            return new CatalogEcomSeoData(pageTitle, pageDescription, permalink);
        }
    }
}
