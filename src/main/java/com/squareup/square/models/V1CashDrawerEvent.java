package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1CashDrawerEvent type.
 */
public class V1CashDrawerEvent {

    /**
     * Initialization constructor.
     * @param id
     * @param employeeId
     * @param eventType
     * @param eventMoney
     * @param createdAt
     * @param description
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId, eventType, eventMoney, createdAt, description);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1CashDrawerEvent)) {
            return false;
        }
        V1CashDrawerEvent v1CashDrawerEvent = (V1CashDrawerEvent) obj;
        return Objects.equals(id, v1CashDrawerEvent.id) &&
            Objects.equals(employeeId, v1CashDrawerEvent.employeeId) &&
            Objects.equals(eventType, v1CashDrawerEvent.eventType) &&
            Objects.equals(eventMoney, v1CashDrawerEvent.eventMoney) &&
            Objects.equals(createdAt, v1CashDrawerEvent.createdAt) &&
            Objects.equals(description, v1CashDrawerEvent.description);
    }

    /**
     * Builds a new {@link V1CashDrawerEvent.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1CashDrawerEvent.Builder} object
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
     * Class to build instances of {@link V1CashDrawerEvent}
     */
    public static class Builder {
        private String id;
        private String employeeId;
        private String eventType;
        private V1Money eventMoney;
        private String createdAt;
        private String description;

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
         * Setter for eventType
         * @param eventType
         * @return Builder
         */
        public Builder eventType(String eventType) {
            this.eventType = eventType;
            return this;
        }
        /**
         * Setter for eventMoney
         * @param eventMoney
         * @return Builder
         */
        public Builder eventMoney(V1Money eventMoney) {
            this.eventMoney = eventMoney;
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
         * Setter for description
         * @param description
         * @return Builder
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        /**
         * Builds a new {@link V1CashDrawerEvent} object using the set fields.
         * @return {@link V1CashDrawerEvent}
         */
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
