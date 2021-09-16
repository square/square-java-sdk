
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for WorkweekConfig type.
 */
public class WorkweekConfig {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String id;
    private final String startOfWeek;
    private final String startOfDayLocalTime;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer version;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String updatedAt;

    /**
     * Initialization constructor.
     * @param  startOfWeek  String value for startOfWeek.
     * @param  startOfDayLocalTime  String value for startOfDayLocalTime.
     * @param  id  String value for id.
     * @param  version  Integer value for version.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     */
    @JsonCreator
    public WorkweekConfig(
            @JsonProperty("start_of_week") String startOfWeek,
            @JsonProperty("start_of_day_local_time") String startOfDayLocalTime,
            @JsonProperty("id") String id,
            @JsonProperty("version") Integer version,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt) {
        this.id = id;
        this.startOfWeek = startOfWeek;
        this.startOfDayLocalTime = startOfDayLocalTime;
        this.version = version;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * Getter for Id.
     * The UUID for this object.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return id;
    }

    /**
     * Getter for StartOfWeek.
     * The days of the week.
     * @return Returns the String
     */
    @JsonGetter("start_of_week")
    public String getStartOfWeek() {
        return startOfWeek;
    }

    /**
     * Getter for StartOfDayLocalTime.
     * The local time at which a business week ends. Represented as a string in `HH:MM` format
     * (`HH:MM:SS` is also accepted, but seconds are truncated).
     * @return Returns the String
     */
    @JsonGetter("start_of_day_local_time")
    public String getStartOfDayLocalTime() {
        return startOfDayLocalTime;
    }

    /**
     * Getter for Version.
     * Used for resolving concurrency issues. The request fails if the version provided does not
     * match the server version at the time of the request. If not provided, Square executes a blind
     * write; potentially overwriting data from another write.
     * @return Returns the Integer
     */
    @JsonGetter("version")
    public Integer getVersion() {
        return version;
    }

    /**
     * Getter for CreatedAt.
     * A read-only timestamp in RFC 3339 format; presented in UTC.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * A read-only timestamp in RFC 3339 format; presented in UTC.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startOfWeek, startOfDayLocalTime, version, createdAt, updatedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WorkweekConfig)) {
            return false;
        }
        WorkweekConfig other = (WorkweekConfig) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(startOfWeek, other.startOfWeek)
            && Objects.equals(startOfDayLocalTime, other.startOfDayLocalTime)
            && Objects.equals(version, other.version)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(updatedAt, other.updatedAt);
    }

    /**
     * Converts this WorkweekConfig into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "WorkweekConfig [" + "startOfWeek=" + startOfWeek + ", startOfDayLocalTime="
                + startOfDayLocalTime + ", id=" + id + ", version=" + version + ", createdAt="
                + createdAt + ", updatedAt=" + updatedAt + "]";
    }

    /**
     * Builds a new {@link WorkweekConfig.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link WorkweekConfig.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(startOfWeek, startOfDayLocalTime)
                .id(getId())
                .version(getVersion())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt());
        return builder;
    }

    /**
     * Class to build instances of {@link WorkweekConfig}.
     */
    public static class Builder {
        private String startOfWeek;
        private String startOfDayLocalTime;
        private String id;
        private Integer version;
        private String createdAt;
        private String updatedAt;

        /**
         * Initialization constructor.
         * @param  startOfWeek  String value for startOfWeek.
         * @param  startOfDayLocalTime  String value for startOfDayLocalTime.
         */
        public Builder(String startOfWeek, String startOfDayLocalTime) {
            this.startOfWeek = startOfWeek;
            this.startOfDayLocalTime = startOfDayLocalTime;
        }

        /**
         * Setter for startOfWeek.
         * @param  startOfWeek  String value for startOfWeek.
         * @return Builder
         */
        public Builder startOfWeek(String startOfWeek) {
            this.startOfWeek = startOfWeek;
            return this;
        }

        /**
         * Setter for startOfDayLocalTime.
         * @param  startOfDayLocalTime  String value for startOfDayLocalTime.
         * @return Builder
         */
        public Builder startOfDayLocalTime(String startOfDayLocalTime) {
            this.startOfDayLocalTime = startOfDayLocalTime;
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
         * Setter for version.
         * @param  version  Integer value for version.
         * @return Builder
         */
        public Builder version(Integer version) {
            this.version = version;
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
         * Builds a new {@link WorkweekConfig} object using the set fields.
         * @return {@link WorkweekConfig}
         */
        public WorkweekConfig build() {
            return new WorkweekConfig(startOfWeek, startOfDayLocalTime, id, version, createdAt,
                    updatedAt);
        }
    }
}
