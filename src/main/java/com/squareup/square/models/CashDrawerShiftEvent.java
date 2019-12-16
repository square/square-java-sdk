package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CashDrawerShiftEvent {

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

    private final String id;
    private final String employeeId;
    private final String eventType;
    private final Money eventMoney;
    private final String createdAt;
    private final String description;

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId, eventType, eventMoney, createdAt, description);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CashDrawerShiftEvent)) {
            return false;
        }
        CashDrawerShiftEvent cashDrawerShiftEvent = (CashDrawerShiftEvent) o;
        return Objects.equals(id, cashDrawerShiftEvent.id) &&
            Objects.equals(employeeId, cashDrawerShiftEvent.employeeId) &&
            Objects.equals(eventType, cashDrawerShiftEvent.eventType) &&
            Objects.equals(eventMoney, cashDrawerShiftEvent.eventMoney) &&
            Objects.equals(createdAt, cashDrawerShiftEvent.createdAt) &&
            Objects.equals(description, cashDrawerShiftEvent.description);
    }
    
    /**
     * Getter for Id.
     * The unique ID of the event.
     */
    @JsonGetter("id")
    public String getId() { 
        return this.id;
    }

    /**
     * Getter for EmployeeId.
     * The ID of the employee that created the event.
     */
    @JsonGetter("employee_id")
    public String getEmployeeId() { 
        return this.employeeId;
    }

    /**
     * Getter for EventType.
     * The types of events on a CashDrawerShift.
     * Each event type represents an employee action on the actual cash drawer
     * represented by a CashDrawerShift.
     */
    @JsonGetter("event_type")
    public String getEventType() { 
        return this.eventType;
    }

    /**
     * Getter for EventMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("event_money")
    public Money getEventMoney() { 
        return this.eventMoney;
    }

    /**
     * Getter for CreatedAt.
     * The event time in ISO 8601 format.
     */
    @JsonGetter("created_at")
    public String getCreatedAt() { 
        return this.createdAt;
    }

    /**
     * Getter for Description.
     * An optional description of the event, entered by the employee that
     * created the event.
     */
    @JsonGetter("description")
    public String getDescription() { 
        return this.description;
    }

 
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

    public static class Builder {
        private String id;
        private String employeeId;
        private String eventType;
        private Money eventMoney;
        private String createdAt;
        private String description;

        public Builder() { }

        public Builder id(String value) {
            id = value;
            return this;
        }
        public Builder employeeId(String value) {
            employeeId = value;
            return this;
        }
        public Builder eventType(String value) {
            eventType = value;
            return this;
        }
        public Builder eventMoney(Money value) {
            eventMoney = value;
            return this;
        }
        public Builder createdAt(String value) {
            createdAt = value;
            return this;
        }
        public Builder description(String value) {
            description = value;
            return this;
        }

        public CashDrawerShiftEvent build() {
            return new CashDrawerShiftEvent(id,
                employeeId,
                eventType,
                eventMoney,
                createdAt,
                description);
        }
    }
}
