/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.Nullable;
import com.squareup.square.core.NullableNonemptyFilter;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = EmployeeWage.Builder.class)
public final class EmployeeWage {
    private final Optional<String> id;

    private final Optional<String> employeeId;

    private final Optional<String> title;

    private final Optional<Money> hourlyRate;

    private final Map<String, Object> additionalProperties;

    private EmployeeWage(
            Optional<String> id,
            Optional<String> employeeId,
            Optional<String> title,
            Optional<Money> hourlyRate,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.employeeId = employeeId;
        this.title = title;
        this.hourlyRate = hourlyRate;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The UUID for this object.
     */
    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    /**
     * @return The <code>Employee</code> that this wage is assigned to.
     */
    @JsonIgnore
    public Optional<String> getEmployeeId() {
        if (employeeId == null) {
            return Optional.empty();
        }
        return employeeId;
    }

    /**
     * @return The job title that this wage relates to.
     */
    @JsonIgnore
    public Optional<String> getTitle() {
        if (title == null) {
            return Optional.empty();
        }
        return title;
    }

    /**
     * @return Can be a custom-set hourly wage or the calculated effective hourly
     * wage based on the annual wage and hours worked per week.
     */
    @JsonProperty("hourly_rate")
    public Optional<Money> getHourlyRate() {
        return hourlyRate;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("employee_id")
    private Optional<String> _getEmployeeId() {
        return employeeId;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("title")
    private Optional<String> _getTitle() {
        return title;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof EmployeeWage && equalTo((EmployeeWage) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(EmployeeWage other) {
        return id.equals(other.id)
                && employeeId.equals(other.employeeId)
                && title.equals(other.title)
                && hourlyRate.equals(other.hourlyRate);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.id, this.employeeId, this.title, this.hourlyRate);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> id = Optional.empty();

        private Optional<String> employeeId = Optional.empty();

        private Optional<String> title = Optional.empty();

        private Optional<Money> hourlyRate = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(EmployeeWage other) {
            id(other.getId());
            employeeId(other.getEmployeeId());
            title(other.getTitle());
            hourlyRate(other.getHourlyRate());
            return this;
        }

        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.ofNullable(id);
            return this;
        }

        @JsonSetter(value = "employee_id", nulls = Nulls.SKIP)
        public Builder employeeId(Optional<String> employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder employeeId(String employeeId) {
            this.employeeId = Optional.ofNullable(employeeId);
            return this;
        }

        public Builder employeeId(Nullable<String> employeeId) {
            if (employeeId.isNull()) {
                this.employeeId = null;
            } else if (employeeId.isEmpty()) {
                this.employeeId = Optional.empty();
            } else {
                this.employeeId = Optional.of(employeeId.get());
            }
            return this;
        }

        @JsonSetter(value = "title", nulls = Nulls.SKIP)
        public Builder title(Optional<String> title) {
            this.title = title;
            return this;
        }

        public Builder title(String title) {
            this.title = Optional.ofNullable(title);
            return this;
        }

        public Builder title(Nullable<String> title) {
            if (title.isNull()) {
                this.title = null;
            } else if (title.isEmpty()) {
                this.title = Optional.empty();
            } else {
                this.title = Optional.of(title.get());
            }
            return this;
        }

        @JsonSetter(value = "hourly_rate", nulls = Nulls.SKIP)
        public Builder hourlyRate(Optional<Money> hourlyRate) {
            this.hourlyRate = hourlyRate;
            return this;
        }

        public Builder hourlyRate(Money hourlyRate) {
            this.hourlyRate = Optional.ofNullable(hourlyRate);
            return this;
        }

        public EmployeeWage build() {
            return new EmployeeWage(id, employeeId, title, hourlyRate, additionalProperties);
        }
    }
}
