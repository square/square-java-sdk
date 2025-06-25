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
 * This is a model class for Job type.
 */
public class Job {
    private final String id;
    private final OptionalNullable<String> title;
    private final OptionalNullable<Boolean> isTipEligible;
    private final String createdAt;
    private final String updatedAt;
    private final Integer version;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  title  String value for title.
     * @param  isTipEligible  Boolean value for isTipEligible.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  version  Integer value for version.
     */
    @JsonCreator
    public Job(
            @JsonProperty("id") String id,
            @JsonProperty("title") String title,
            @JsonProperty("is_tip_eligible") Boolean isTipEligible,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("version") Integer version) {
        this.id = id;
        this.title = OptionalNullable.of(title);
        this.isTipEligible = OptionalNullable.of(isTipEligible);
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.version = version;
    }

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  title  String value for title.
     * @param  isTipEligible  Boolean value for isTipEligible.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  version  Integer value for version.
     */
    protected Job(
            String id,
            OptionalNullable<String> title,
            OptionalNullable<Boolean> isTipEligible,
            String createdAt,
            String updatedAt,
            Integer version) {
        this.id = id;
        this.title = title;
        this.isTipEligible = isTipEligible;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.version = version;
    }

    /**
     * Getter for Id.
     * **Read only** The unique Square-assigned ID of the job. If you need a job ID for an API
     * request, call [ListJobs](api-endpoint:Team-ListJobs) or use the ID returned when you created
     * the job. You can also get job IDs from a team member's wage setting.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Internal Getter for Title.
     * The title of the job.
     * @return Returns the Internal String
     */
    @JsonGetter("title")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetTitle() {
        return this.title;
    }

    /**
     * Getter for Title.
     * The title of the job.
     * @return Returns the String
     */
    @JsonIgnore
    public String getTitle() {
        return OptionalNullable.getFrom(title);
    }

    /**
     * Internal Getter for IsTipEligible.
     * Indicates whether team members can earn tips for the job.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("is_tip_eligible")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetIsTipEligible() {
        return this.isTipEligible;
    }

    /**
     * Getter for IsTipEligible.
     * Indicates whether team members can earn tips for the job.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getIsTipEligible() {
        return OptionalNullable.getFrom(isTipEligible);
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the job was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp when the job was last updated, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Getter for Version.
     * **Read only** The current version of the job. Include this field in `UpdateJob` requests to
     * enable [optimistic
     * concurrency](https://developer.squareup.com/docs/working-with-apis/optimistic-concurrency)
     * control and avoid overwrites from concurrent requests. Requests fail if the provided version
     * doesn't match the server version at the time of the request.
     * @return Returns the Integer
     */
    @JsonGetter("version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getVersion() {
        return version;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, isTipEligible, createdAt, updatedAt, version);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Job)) {
            return false;
        }
        Job other = (Job) obj;
        return Objects.equals(id, other.id)
                && Objects.equals(title, other.title)
                && Objects.equals(isTipEligible, other.isTipEligible)
                && Objects.equals(createdAt, other.createdAt)
                && Objects.equals(updatedAt, other.updatedAt)
                && Objects.equals(version, other.version);
    }

    /**
     * Converts this Job into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Job [" + "id=" + id + ", title=" + title + ", isTipEligible=" + isTipEligible
                + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", version=" + version
                + "]";
    }

    /**
     * Builds a new {@link Job.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Job.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt())
                .version(getVersion());
        builder.title = internalGetTitle();
        builder.isTipEligible = internalGetIsTipEligible();
        return builder;
    }

    /**
     * Class to build instances of {@link Job}.
     */
    public static class Builder {
        private String id;
        private OptionalNullable<String> title;
        private OptionalNullable<Boolean> isTipEligible;
        private String createdAt;
        private String updatedAt;
        private Integer version;

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
         * Setter for title.
         * @param  title  String value for title.
         * @return Builder
         */
        public Builder title(String title) {
            this.title = OptionalNullable.of(title);
            return this;
        }

        /**
         * UnSetter for title.
         * @return Builder
         */
        public Builder unsetTitle() {
            title = null;
            return this;
        }

        /**
         * Setter for isTipEligible.
         * @param  isTipEligible  Boolean value for isTipEligible.
         * @return Builder
         */
        public Builder isTipEligible(Boolean isTipEligible) {
            this.isTipEligible = OptionalNullable.of(isTipEligible);
            return this;
        }

        /**
         * UnSetter for isTipEligible.
         * @return Builder
         */
        public Builder unsetIsTipEligible() {
            isTipEligible = null;
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
         * Setter for version.
         * @param  version  Integer value for version.
         * @return Builder
         */
        public Builder version(Integer version) {
            this.version = version;
            return this;
        }

        /**
         * Builds a new {@link Job} object using the set fields.
         * @return {@link Job}
         */
        public Job build() {
            return new Job(id, title, isTipEligible, createdAt, updatedAt, version);
        }
    }
}
