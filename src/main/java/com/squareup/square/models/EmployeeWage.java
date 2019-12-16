package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class EmployeeWage {

    @JsonCreator
    public EmployeeWage(
            @JsonProperty("employee_id") String employeeId,
            @JsonProperty("id") String id,
            @JsonProperty("title") String title,
            @JsonProperty("hourly_rate") Money hourlyRate) {
        this.id = id;
        this.employeeId = employeeId;
        this.title = title;
        this.hourlyRate = hourlyRate;
    }

    private final String id;
    private final String employeeId;
    private final String title;
    private final Money hourlyRate;

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, id, title, hourlyRate);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof EmployeeWage)) {
            return false;
        }
        EmployeeWage employeeWage = (EmployeeWage) o;
        return Objects.equals(employeeId, employeeWage.employeeId) &&
            Objects.equals(id, employeeWage.id) &&
            Objects.equals(title, employeeWage.title) &&
            Objects.equals(hourlyRate, employeeWage.hourlyRate);
    }

    /**
     * Getter for Id.
     * UUID for this object.
     */
    @JsonGetter("id")
    public String getId() { 
        return this.id;
    }

    /**
     * Getter for EmployeeId.
     * The `Employee` that this wage is assigned to.
     */
    @JsonGetter("employee_id")
    public String getEmployeeId() { 
        return this.employeeId;
    }

    /**
     * Getter for Title.
     * The job title that this wage relates to.
     */
    @JsonGetter("title")
    public String getTitle() { 
        return this.title;
    }

    /**
     * Getter for HourlyRate.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("hourly_rate")
    public Money getHourlyRate() { 
        return this.hourlyRate;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(employeeId)
            .id(getId())
            .title(getTitle())
            .hourlyRate(getHourlyRate());
            return builder;
    }

    public static class Builder {
        private String employeeId;
        private String id;
        private String title;
        private Money hourlyRate;

        public Builder(String employeeId) {
            this.employeeId = employeeId;
        }

        public Builder employeeId(String value) {
            employeeId = value;
            return this;
        }
        public Builder id(String value) {
            id = value;
            return this;
        }
        public Builder title(String value) {
            title = value;
            return this;
        }
        public Builder hourlyRate(Money value) {
            hourlyRate = value;
            return this;
        }

        public EmployeeWage build() {
            return new EmployeeWage(employeeId,
                id,
                title,
                hourlyRate);
        }
    }
}
