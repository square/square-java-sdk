
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for Snippet type.
 */
public class Snippet {
    private final String id;
    private final String siteId;
    private final String content;
    private final String createdAt;
    private final String updatedAt;

    /**
     * Initialization constructor.
     * @param  content  String value for content.
     * @param  id  String value for id.
     * @param  siteId  String value for siteId.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     */
    @JsonCreator
    public Snippet(
            @JsonProperty("content") String content,
            @JsonProperty("id") String id,
            @JsonProperty("site_id") String siteId,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt) {
        this.id = id;
        this.siteId = siteId;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * Getter for Id.
     * The Square-assigned ID for the snippet.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Getter for SiteId.
     * The ID of the site that contains the snippet.
     * @return Returns the String
     */
    @JsonGetter("site_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getSiteId() {
        return siteId;
    }

    /**
     * Getter for Content.
     * The snippet code, which can contain valid HTML, JavaScript, or both.
     * @return Returns the String
     */
    @JsonGetter("content")
    public String getContent() {
        return content;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp of when the snippet was initially added to the site, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp of when the snippet was last updated on the site, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, siteId, content, createdAt, updatedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Snippet)) {
            return false;
        }
        Snippet other = (Snippet) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(siteId, other.siteId)
            && Objects.equals(content, other.content)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(updatedAt, other.updatedAt);
    }

    /**
     * Converts this Snippet into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Snippet [" + "content=" + content + ", id=" + id + ", siteId=" + siteId
                + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }

    /**
     * Builds a new {@link Snippet.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Snippet.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(content)
                .id(getId())
                .siteId(getSiteId())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt());
        return builder;
    }

    /**
     * Class to build instances of {@link Snippet}.
     */
    public static class Builder {
        private String content;
        private String id;
        private String siteId;
        private String createdAt;
        private String updatedAt;

        /**
         * Initialization constructor.
         * @param  content  String value for content.
         */
        public Builder(String content) {
            this.content = content;
        }

        /**
         * Setter for content.
         * @param  content  String value for content.
         * @return Builder
         */
        public Builder content(String content) {
            this.content = content;
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
         * Setter for siteId.
         * @param  siteId  String value for siteId.
         * @return Builder
         */
        public Builder siteId(String siteId) {
            this.siteId = siteId;
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
         * Builds a new {@link Snippet} object using the set fields.
         * @return {@link Snippet}
         */
        public Snippet build() {
            return new Snippet(content, id, siteId, createdAt, updatedAt);
        }
    }
}
