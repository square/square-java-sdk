
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
 * This is a model class for CashDrawerShiftEvent type.
 */
public class CashDrawerShiftEvent {
    private final String id;
    private final String eventType;
    private final Money eventMoney;
    private final String createdAt;
    private final OptionalNullable<String> description;
    private final String teamMemberId;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  eventType  String value for eventType.
     * @param  eventMoney  Money value for eventMoney.
     * @param  createdAt  String value for createdAt.
     * @param  description  String value for description.
     * @param  teamMemberId  String value for teamMemberId.
     */
    @JsonCreator
    public CashDrawerShiftEvent(
            @JsonProperty("id") String id,
            @JsonProperty("event_type") String eventType,
            @JsonProperty("event_money") Money eventMoney,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("description") String description,
            @JsonProperty("team_member_id") String teamMemberId) {
        this.id = id;
        this.eventType = eventType;
        this.eventMoney = eventMoney;
        this.createdAt = createdAt;
        this.description = OptionalNullable.of(description);
        this.teamMemberId = teamMemberId;
    }

    /**
     * Internal initialization constructor.
     */
    protected CashDrawerShiftEvent(String id, String eventType, Money eventMoney, String createdAt,
            OptionalNullable<String> description, String teamMemberId) {
        this.id = id;
        this.eventType = eventType;
        this.eventMoney = eventMoney;
        this.createdAt = createdAt;
        this.description = description;
        this.teamMemberId = teamMemberId;
    }

    /**
     * Getter for Id.
     * The unique ID of the event.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Getter for EventType.
     * The types of events on a CashDrawerShift. Each event type represents an employee action on
     * the actual cash drawer represented by a CashDrawerShift.
     * @return Returns the String
     */
    @JsonGetter("event_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getEventMoney() {
        return eventMoney;
    }

    /**
     * Getter for CreatedAt.
     * The event time in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Internal Getter for Description.
     * An optional description of the event, entered by the employee that created the event.
     * @return Returns the Internal String
     */
    @JsonGetter("description")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetDescription() {
        return this.description;
    }

    /**
     * Getter for Description.
     * An optional description of the event, entered by the employee that created the event.
     * @return Returns the String
     */
    @JsonIgnore
    public String getDescription() {
        return OptionalNullable.getFrom(description);
    }

    /**
     * Getter for TeamMemberId.
     * The ID of the team member that created the event.
     * @return Returns the String
     */
    @JsonGetter("team_member_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getTeamMemberId() {
        return teamMemberId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventType, eventMoney, createdAt, description, teamMemberId);
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
            && Objects.equals(eventType, other.eventType)
            && Objects.equals(eventMoney, other.eventMoney)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(description, other.description)
            && Objects.equals(teamMemberId, other.teamMemberId);
    }

    /**
     * Converts this CashDrawerShiftEvent into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CashDrawerShiftEvent [" + "id=" + id + ", eventType=" + eventType + ", eventMoney="
                + eventMoney + ", createdAt=" + createdAt + ", description=" + description
                + ", teamMemberId=" + teamMemberId + "]";
    }

    /**
     * Builds a new {@link CashDrawerShiftEvent.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CashDrawerShiftEvent.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .eventType(getEventType())
                .eventMoney(getEventMoney())
                .createdAt(getCreatedAt())
                .teamMemberId(getTeamMemberId());
        builder.description = internalGetDescription();
        return builder;
    }

    /**
     * Class to build instances of {@link CashDrawerShiftEvent}.
     */
    public static class Builder {
        private String id;
        private String eventType;
        private Money eventMoney;
        private String createdAt;
        private OptionalNullable<String> description;
        private String teamMemberId;



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
            this.description = OptionalNullable.of(description);
            return this;
        }

        /**
         * UnSetter for description.
         * @return Builder
         */
        public Builder unsetDescription() {
            description = null;
            return this;
        }

        /**
         * Setter for teamMemberId.
         * @param  teamMemberId  String value for teamMemberId.
         * @return Builder
         */
        public Builder teamMemberId(String teamMemberId) {
            this.teamMemberId = teamMemberId;
            return this;
        }

        /**
         * Builds a new {@link CashDrawerShiftEvent} object using the set fields.
         * @return {@link CashDrawerShiftEvent}
         */
        public CashDrawerShiftEvent build() {
            return new CashDrawerShiftEvent(id, eventType, eventMoney, createdAt, description,
                    teamMemberId);
        }
    }
}
