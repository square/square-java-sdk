
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CashDrawerShiftEvent type.
 */
public class CashDrawerShiftEvent {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String employeeId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String eventType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money eventMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String description;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  employeeId  String value for employeeId.
     * @param  eventType  String value for eventType.
     * @param  eventMoney  Money value for eventMoney.
     * @param  createdAt  String value for createdAt.
     * @param  description  String value for description.
     */
    @JsonCreator
    public CashDrawerShiftEvent(
            @JsonProperty("id") String id,
            @JsonProperty("employee_id") String employeeId,
            @JsonProperty("event_type") String eventType,
            @JsonProperty("event_money") Money eventMoney,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("description") String description) {
        this.id = id;
        this.employeeId = employeeId;
        this.eventType = eventType;
        this.eventMoney = eventMoney;
        this.createdAt = createdAt;
        this.description = description;
    }

    /**
     * Getter for Id.
     * The unique ID of the event.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return id;
    }

    /**
     * Getter for EmployeeId.
     * The ID of the employee that created the event.
     * @return Returns the String
     */
    @JsonGetter("employee_id")
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Getter for EventType.
     * The types of events on a CashDrawerShift. Each event type represents an employee action on
     * the actual cash drawer represented by a CashDrawerShift.
     * @return Returns the String
     */
    @JsonGetter("event_type")
    public String getEventType() {
        return eventType;
    }

    /**
     * Getter for EventMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("event_money")
    public Money getEventMoney() {
        return eventMoney;
    }

    /**
     * Getter for CreatedAt.
     * The event time in ISO 8601 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for Description.
     * An optional description of the event, entered by the employee that created the event.
     * @return Returns the String
     */
    @JsonGetter("description")
    public String getDescription() {
        return description;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId, eventType, eventMoney, createdAt, description);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CashDrawerShiftEvent)) {
            return false;
        }
        CashDrawerShiftEvent other = (CashDrawerShiftEvent) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(employeeId, other.employeeId)
            && Objects.equals(eventType, other.eventType)
            && Objects.equals(eventMoney, other.eventMoney)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(description, other.description);
    }

    /**
     * Converts this CashDrawerShiftEvent into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CashDrawerShiftEvent [" + "id=" + id + ", employeeId=" + employeeId + ", eventType="
                + eventType + ", eventMoney=" + eventMoney + ", createdAt=" + createdAt
                + ", description=" + description + "]";
    }

    /**
     * Builds a new {@link CashDrawerShiftEvent.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CashDrawerShiftEvent.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .employeeId(getEmployeeId())
                .eventType(getEventType())
                .eventMoney(getEventMoney())
                .createdAt(getCreatedAt())
                .description(getDescription());
        return builder;
    }

    /**
     * Class to build instances of {@link CashDrawerShiftEvent}.
     */
    public static class Builder {
        private String id;
        private String employeeId;
        private String eventType;
        private Money eventMoney;
        private String createdAt;
        private String description;



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
            this.employeeId = employeeId;
            return this;
        }

        /**
         * Setter for eventType.
         * @param  eventType  String value for eventType.
         * @return Builder
         */
        public Builder eventType(String eventType) {
            this.eventType = eventType;
            return this;
        }

        /**
         * Setter for eventMoney.
         * @param  eventMoney  Money value for eventMoney.
         * @return Builder
         */
        public Builder eventMoney(Money eventMoney) {
            this.eventMoney = eventMoney;
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
         * Setter for description.
         * @param  description  String value for description.
         * @return Builder
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        /**
         * Builds a new {@link CashDrawerShiftEvent} object using the set fields.
         * @return {@link CashDrawerShiftEvent}
         */
        public CashDrawerShiftEvent build() {
            return new CashDrawerShiftEvent(id, employeeId, eventType, eventMoney, createdAt,
                    description);
        }
    }
}
