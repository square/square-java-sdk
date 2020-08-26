package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for EmployeeWage type.
 */
public class EmployeeWage {

    /**
     * Initialization constructor.
     * @param id
     * @param employeeId
     * @param title
     * @param hourlyRate
     */
    @JsonCreator
    public EmployeeWage(
            @JsonProperty("id") String id,
            @JsonProperty("employee_id") String employeeId,
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

 
    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId, title, hourlyRate);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof EmployeeWage)) {
            return false;
        }
        EmployeeWage employeeWage = (EmployeeWage) obj;
        return Objects.equals(id, employeeWage.id) &&
            Objects.equals(employeeId, employeeWage.employeeId) &&
            Objects.equals(title, employeeWage.title) &&
            Objects.equals(hourlyRate, employeeWage.hourlyRate);
    }

    /**
     * Builds a new {@link EmployeeWage.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link EmployeeWage.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .id(getId())
            .employeeId(getEmployeeId())
            .title(getTitle())
            .hourlyRate(getHourlyRate());
            return builder;
    }

    /**
     * Class to build instances of {@link EmployeeWage}
     */
    public static class Builder {
        private String id;
        private String employeeId;
        private String title;
        private Money hourlyRate;

        /**
         * Initialization constructor
         */
        public Builder() {
           
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
         * Setter for employeeId
         * @param employeeId
         * @return Builder
         */
        public Builder employeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }
        /**
         * Setter for title
         * @param title
         * @return Builder
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }
        /**
         * Setter for hourlyRate
         * @param hourlyRate
         * @return Builder
         */
        public Builder hourlyRate(Money hourlyRate) {
            this.hourlyRate = hourlyRate;
            return this;
        }

        /**
         * Builds a new {@link EmployeeWage} object using the set fields.
         * @return {@link EmployeeWage}
         */
        public EmployeeWage build() {
            return new EmployeeWage(id,
                employeeId,
                title,
                hourlyRate);
        }
    }
}
