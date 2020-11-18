
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for EmployeeWage type.
 */
public class EmployeeWage {
    private final String id;
    private final String employeeId;
    private final String title;
    private final Money hourlyRate;

    /**
     * Initialization constructor.
     * @param id String value for id.
     * @param employeeId String value for employeeId.
     * @param title String value for title.
     * @param hourlyRate Money value for hourlyRate.
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

    /**
     * Getter for Id.
     * UUID for this object.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for EmployeeId.
     * The `Employee` that this wage is assigned to.
     * @return Returns the String
     */
    @JsonGetter("employee_id")
    public String getEmployeeId() {
        return this.employeeId;
    }

    /**
     * Getter for Title.
     * The job title that this wage relates to.
     * @return Returns the String
     */
    @JsonGetter("title")
    public String getTitle() {
        return this.title;
    }

    /**
     * Getter for HourlyRate.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EmployeeWage)) {
            return false;
        }
        EmployeeWage other = (EmployeeWage) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(employeeId, other.employeeId)
            && Objects.equals(title, other.title)
            && Objects.equals(hourlyRate, other.hourlyRate);
    }

    /**
     * Converts this EmployeeWage into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "EmployeeWage [" + "id=" + id + ", employeeId=" + employeeId + ", title=" + title
                + ", hourlyRate=" + hourlyRate + "]";
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
     * Class to build instances of {@link EmployeeWage}.
     */
    public static class Builder {
        private String id;
        private String employeeId;
        private String title;
        private Money hourlyRate;



        /**
         * Setter for id.
         * @param id String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for employeeId.
         * @param employeeId String value for employeeId.
         * @return Builder
         */
        public Builder employeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        /**
         * Setter for title.
         * @param title String value for title.
         * @return Builder
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * Setter for hourlyRate.
         * @param hourlyRate Money value for hourlyRate.
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
            return new EmployeeWage(id, employeeId, title, hourlyRate);
        }
    }
}
