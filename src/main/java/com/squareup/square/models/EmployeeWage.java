
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for EmployeeWage type.
 */
public class EmployeeWage {
    private final String id;
    private final OptionalNullable<String> employeeId;
    private final OptionalNullable<String> title;
    private final Money hourlyRate;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  employeeId  String value for employeeId.
     * @param  title  String value for title.
     * @param  hourlyRate  Money value for hourlyRate.
     */
    @JsonCreator
    public EmployeeWage(
            @JsonProperty("id") String id,
            @JsonProperty("employee_id") String employeeId,
            @JsonProperty("title") String title,
            @JsonProperty("hourly_rate") Money hourlyRate) {
        this.id = id;
        this.employeeId = OptionalNullable.of(employeeId);
        this.title = OptionalNullable.of(title);
        this.hourlyRate = hourlyRate;
    }

    /**
     * Internal initialization constructor.
     */
    protected EmployeeWage(String id, OptionalNullable<String> employeeId,
            OptionalNullable<String> title, Money hourlyRate) {
        this.id = id;
        this.employeeId = employeeId;
        this.title = title;
        this.hourlyRate = hourlyRate;
    }

    /**
     * Getter for Id.
     * The UUID for this object.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Internal Getter for EmployeeId.
     * The `Employee` that this wage is assigned to.
     * @return Returns the Internal String
     */
    @JsonGetter("employee_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetEmployeeId() {
        return this.employeeId;
    }

    /**
     * Getter for EmployeeId.
     * The `Employee` that this wage is assigned to.
     * @return Returns the String
     */
    @JsonIgnore
    public String getEmployeeId() {
        return OptionalNullable.getFrom(employeeId);
    }

    /**
     * Internal Getter for Title.
     * The job title that this wage relates to.
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
     * The job title that this wage relates to.
     * @return Returns the String
     */
    @JsonIgnore
    public String getTitle() {
        return OptionalNullable.getFrom(title);
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getHourlyRate() {
        return hourlyRate;
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
                .hourlyRate(getHourlyRate());
        builder.employeeId = internalGetEmployeeId();
        builder.title = internalGetTitle();
        return builder;
    }

    /**
     * Class to build instances of {@link EmployeeWage}.
     */
    public static class Builder {
        private String id;
        private OptionalNullable<String> employeeId;
        private OptionalNullable<String> title;
        private Money hourlyRate;



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
         * Setter for employeeId.
         * @param  employeeId  String value for employeeId.
         * @return Builder
         */
        public Builder employeeId(String employeeId) {
            this.employeeId = OptionalNullable.of(employeeId);
            return this;
        }

        /**
         * UnSetter for employeeId.
         * @return Builder
         */
        public Builder unsetEmployeeId() {
            employeeId = null;
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
         * Setter for hourlyRate.
         * @param  hourlyRate  Money value for hourlyRate.
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
