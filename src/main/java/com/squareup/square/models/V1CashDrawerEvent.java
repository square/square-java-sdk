
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for V1CashDrawerEvent type.
 */
public class V1CashDrawerEvent {
    private final String id;
    private final String employeeId;
    private final String eventType;
    private final V1Money eventMoney;
    private final String createdAt;
    private final String description;

    /**
     * Initialization constructor.
     * @param id String value for id.
     * @param employeeId String value for employeeId.
     * @param eventType String value for eventType.
     * @param eventMoney V1Money value for eventMoney.
     * @param createdAt String value for createdAt.
     * @param description String value for description.
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

    /**
     * Getter for Id.
     * The event's unique ID.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for EmployeeId.
     * The ID of the employee that created the event.
     * @return Returns the String
     */
    @JsonGetter("employee_id")
    public String getEmployeeId() {
        return this.employeeId;
    }

    /**
     * Getter for EventType.
     * @return Returns the String
     */
    @JsonGetter("event_type")
    public String getEventType() {
        return this.eventType;
    }

    /**
     * Getter for EventMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("event_money")
    public V1Money getEventMoney() {
        return this.eventMoney;
    }

    /**
     * Getter for CreatedAt.
     * The time when the event occurred, in ISO 8601 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Getter for Description.
     * An optional description of the event, entered by the employee that created it.
     * @return Returns the String
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1CashDrawerEvent)) {
            return false;
        }
        V1CashDrawerEvent other = (V1CashDrawerEvent) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(employeeId, other.employeeId)
            && Objects.equals(eventType, other.eventType)
            && Objects.equals(eventMoney, other.eventMoney)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(description, other.description);
    }

    /**
     * Converts this V1CashDrawerEvent into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1CashDrawerEvent [" + "id=" + id + ", employeeId=" + employeeId + ", eventType="
                + eventType + ", eventMoney=" + eventMoney + ", createdAt=" + createdAt
                + ", description=" + description + "]";
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
     * Class to build instances of {@link V1CashDrawerEvent}.
     */
    public static class Builder {
        private String id;
        private String employeeId;
        private String eventType;
        private V1Money eventMoney;
        private String createdAt;
        private String description;



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
         * Setter for eventType.
         * @param eventType String value for eventType.
         * @return Builder
         */
        public Builder eventType(String eventType) {
            this.eventType = eventType;
            return this;
        }

        /**
         * Setter for eventMoney.
         * @param eventMoney V1Money value for eventMoney.
         * @return Builder
         */
        public Builder eventMoney(V1Money eventMoney) {
            this.eventMoney = eventMoney;
            return this;
        }

        /**
         * Setter for createdAt.
         * @param createdAt String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for description.
         * @param description String value for description.
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
            return new V1CashDrawerEvent(id, employeeId, eventType, eventMoney, createdAt,
                    description);
        }
    }
}
