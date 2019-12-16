package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1CashDrawerEvent {

    @JsonCreator
    public V1CashDrawerEvent(
            @JsonProperty("id") String id,
            @JsonProperty("employee_id") String employeeId,
            @JsonProperty("event_type") String eventType,
            @JsonProperty("event_money") V1Money eventMoney,
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
    private final V1Money eventMoney;
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
        if (!(o instanceof V1CashDrawerEvent)) {
            return false;
        }
        V1CashDrawerEvent v1CashDrawerEvent = (V1CashDrawerEvent) o;
        return Objects.equals(id, v1CashDrawerEvent.id) &&
            Objects.equals(employeeId, v1CashDrawerEvent.employeeId) &&
            Objects.equals(eventType, v1CashDrawerEvent.eventType) &&
            Objects.equals(eventMoney, v1CashDrawerEvent.eventMoney) &&
            Objects.equals(createdAt, v1CashDrawerEvent.createdAt) &&
            Objects.equals(description, v1CashDrawerEvent.description);
    }

    /**
     * Getter for Id.
     * The event's unique ID.
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
     */
    @JsonGetter("event_type")
    public String getEventType() { 
        return this.eventType;
    }

    /**
     * Getter for EventMoney.
     */
    @JsonGetter("event_money")
    public V1Money getEventMoney() { 
        return this.eventMoney;
    }

    /**
     * Getter for CreatedAt.
     * The time when the event occurred, in ISO 8601 format.
     */
    @JsonGetter("created_at")
    public String getCreatedAt() { 
        return this.createdAt;
    }

    /**
     * Getter for Description.
     * An optional description of the event, entered by the employee that created it.
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
        private V1Money eventMoney;
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
        public Builder eventMoney(V1Money value) {
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

        public V1CashDrawerEvent build() {
            return new V1CashDrawerEvent(id,
                employeeId,
                eventType,
                eventMoney,
                createdAt,
                description);
        }
    }
}
