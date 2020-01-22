package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for WorkweekConfig type.
 */
public class WorkweekConfig {

    /**
     * Initialization constructor.
     * @param startOfWeek
     * @param startOfDayLocalTime
     * @param id
     * @param version
     * @param createdAt
     * @param updatedAt
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

    private final String id;
    private final String startOfWeek;
    private final String startOfDayLocalTime;
    private final Integer version;
    private final String createdAt;
    private final String updatedAt;
    /**
     * Getter for Id.
     * UUID for this object
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for StartOfWeek.
     * The days of the week.
     */
    @JsonGetter("start_of_week")
    public String getStartOfWeek() {
        return this.startOfWeek;
    }

    /**
     * Getter for StartOfDayLocalTime.
     * The local time at which a business week cuts over. Represented as a
     * string in `HH:MM` format (`HH:MM:SS` is also accepted, but seconds are
     * truncated).
     */
    @JsonGetter("start_of_day_local_time")
    public String getStartOfDayLocalTime() {
        return this.startOfDayLocalTime;
    }

    /**
     * Getter for Version.
     * Used for resolving concurrency issues; request will fail if version
     * provided does not match server version at time of request. If not provided,
     * Square executes a blind write; potentially overwriting data from another
     * write.
     */
    @JsonGetter("version")
    public Integer getVersion() {
        return this.version;
    }

    /**
     * Getter for CreatedAt.
     * A read-only timestamp in RFC 3339 format; presented in UTC
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * A read-only timestamp in RFC 3339 format; presented in UTC
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() {
        return this.updatedAt;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, startOfWeek, startOfDayLocalTime, version, createdAt, updatedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof WorkweekConfig)) {
            return false;
        }
        WorkweekConfig workweekConfig = (WorkweekConfig) obj;
        return Objects.equals(id, workweekConfig.id) &&
            Objects.equals(startOfWeek, workweekConfig.startOfWeek) &&
            Objects.equals(startOfDayLocalTime, workweekConfig.startOfDayLocalTime) &&
            Objects.equals(version, workweekConfig.version) &&
            Objects.equals(createdAt, workweekConfig.createdAt) &&
            Objects.equals(updatedAt, workweekConfig.updatedAt);
    }

    /**
     * Builds a new {@link WorkweekConfig.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link WorkweekConfig.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(startOfWeek,
            startOfDayLocalTime)
            .id(getId())
            .version(getVersion())
            .createdAt(getCreatedAt())
            .updatedAt(getUpdatedAt());
            return builder;
    }

    /**
     * Class to build instances of {@link WorkweekConfig}
     */
    public static class Builder {
        private String startOfWeek;
        private String startOfDayLocalTime;
        private String id;
        private Integer version;
        private String createdAt;
        private String updatedAt;

        /**
         * Initialization constructor
         */
        public Builder(String startOfWeek,
                String startOfDayLocalTime) {
            this.startOfWeek = startOfWeek;
            this.startOfDayLocalTime = startOfDayLocalTime;
        }

        /**
         * Setter for startOfWeek
         * @param startOfWeek
         * @return Builder
         */
        public Builder startOfWeek(String startOfWeek) {
            this.startOfWeek = startOfWeek;
            return this;
        }
        /**
         * Setter for startOfDayLocalTime
         * @param startOfDayLocalTime
         * @return Builder
         */
        public Builder startOfDayLocalTime(String startOfDayLocalTime) {
            this.startOfDayLocalTime = startOfDayLocalTime;
            return this;
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
         * Setter for version
         * @param version
         * @return Builder
         */
        public Builder version(Integer version) {
            this.version = version;
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
         * Setter for updatedAt
         * @param updatedAt
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
            return new WorkweekConfig(startOfWeek,
                startOfDayLocalTime,
                id,
                version,
                createdAt,
                updatedAt);
        }
    }
}
