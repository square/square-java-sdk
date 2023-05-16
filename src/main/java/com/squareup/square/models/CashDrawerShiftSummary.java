
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
 * This is a model class for CashDrawerShiftSummary type.
 */
public class CashDrawerShiftSummary {
    private final String id;
    private final String state;
    private final OptionalNullable<String> openedAt;
    private final OptionalNullable<String> endedAt;
    private final OptionalNullable<String> closedAt;
    private final OptionalNullable<String> description;
    private final Money openedCashMoney;
    private final Money expectedCashMoney;
    private final Money closedCashMoney;
    private final String createdAt;
    private final String updatedAt;
    private final String locationId;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  state  String value for state.
     * @param  openedAt  String value for openedAt.
     * @param  endedAt  String value for endedAt.
     * @param  closedAt  String value for closedAt.
     * @param  description  String value for description.
     * @param  openedCashMoney  Money value for openedCashMoney.
     * @param  expectedCashMoney  Money value for expectedCashMoney.
     * @param  closedCashMoney  Money value for closedCashMoney.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  locationId  String value for locationId.
     */
    @JsonCreator
    public CashDrawerShiftSummary(
            @JsonProperty("id") String id,
            @JsonProperty("state") String state,
            @JsonProperty("opened_at") String openedAt,
            @JsonProperty("ended_at") String endedAt,
            @JsonProperty("closed_at") String closedAt,
            @JsonProperty("description") String description,
            @JsonProperty("opened_cash_money") Money openedCashMoney,
            @JsonProperty("expected_cash_money") Money expectedCashMoney,
            @JsonProperty("closed_cash_money") Money closedCashMoney,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("location_id") String locationId) {
        this.id = id;
        this.state = state;
        this.openedAt = OptionalNullable.of(openedAt);
        this.endedAt = OptionalNullable.of(endedAt);
        this.closedAt = OptionalNullable.of(closedAt);
        this.description = OptionalNullable.of(description);
        this.openedCashMoney = openedCashMoney;
        this.expectedCashMoney = expectedCashMoney;
        this.closedCashMoney = closedCashMoney;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.locationId = locationId;
    }

    /**
     * Internal initialization constructor.
     */
    protected CashDrawerShiftSummary(String id, String state, OptionalNullable<String> openedAt,
            OptionalNullable<String> endedAt, OptionalNullable<String> closedAt,
            OptionalNullable<String> description, Money openedCashMoney, Money expectedCashMoney,
            Money closedCashMoney, String createdAt, String updatedAt, String locationId) {
        this.id = id;
        this.state = state;
        this.openedAt = openedAt;
        this.endedAt = endedAt;
        this.closedAt = closedAt;
        this.description = description;
        this.openedCashMoney = openedCashMoney;
        this.expectedCashMoney = expectedCashMoney;
        this.closedCashMoney = closedCashMoney;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.locationId = locationId;
    }

    /**
     * Getter for Id.
     * The shift unique ID.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Getter for State.
     * The current state of a cash drawer shift.
     * @return Returns the String
     */
    @JsonGetter("state")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getState() {
        return state;
    }

    /**
     * Internal Getter for OpenedAt.
     * The shift start time in ISO 8601 format.
     * @return Returns the Internal String
     */
    @JsonGetter("opened_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetOpenedAt() {
        return this.openedAt;
    }

    /**
     * Getter for OpenedAt.
     * The shift start time in ISO 8601 format.
     * @return Returns the String
     */
    @JsonIgnore
    public String getOpenedAt() {
        return OptionalNullable.getFrom(openedAt);
    }

    /**
     * Internal Getter for EndedAt.
     * The shift end time in ISO 8601 format.
     * @return Returns the Internal String
     */
    @JsonGetter("ended_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetEndedAt() {
        return this.endedAt;
    }

    /**
     * Getter for EndedAt.
     * The shift end time in ISO 8601 format.
     * @return Returns the String
     */
    @JsonIgnore
    public String getEndedAt() {
        return OptionalNullable.getFrom(endedAt);
    }

    /**
     * Internal Getter for ClosedAt.
     * The shift close time in ISO 8601 format.
     * @return Returns the Internal String
     */
    @JsonGetter("closed_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetClosedAt() {
        return this.closedAt;
    }

    /**
     * Getter for ClosedAt.
     * The shift close time in ISO 8601 format.
     * @return Returns the String
     */
    @JsonIgnore
    public String getClosedAt() {
        return OptionalNullable.getFrom(closedAt);
    }

    /**
     * Internal Getter for Description.
     * An employee free-text description of a cash drawer shift.
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
     * An employee free-text description of a cash drawer shift.
     * @return Returns the String
     */
    @JsonIgnore
    public String getDescription() {
        return OptionalNullable.getFrom(description);
    }

    /**
     * Getter for OpenedCashMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("opened_cash_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getOpenedCashMoney() {
        return openedCashMoney;
    }

    /**
     * Getter for ExpectedCashMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("expected_cash_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getExpectedCashMoney() {
        return expectedCashMoney;
    }

    /**
     * Getter for ClosedCashMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("closed_cash_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getClosedCashMoney() {
        return closedCashMoney;
    }

    /**
     * Getter for CreatedAt.
     * The shift start time in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The shift updated at time in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Getter for LocationId.
     * The ID of the location the cash drawer shift belongs to.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getLocationId() {
        return locationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, state, openedAt, endedAt, closedAt, description, openedCashMoney,
                expectedCashMoney, closedCashMoney, createdAt, updatedAt, locationId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CashDrawerShiftSummary)) {
            return false;
        }
        CashDrawerShiftSummary other = (CashDrawerShiftSummary) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(state, other.state)
            && Objects.equals(openedAt, other.openedAt)
            && Objects.equals(endedAt, other.endedAt)
            && Objects.equals(closedAt, other.closedAt)
            && Objects.equals(description, other.description)
            && Objects.equals(openedCashMoney, other.openedCashMoney)
            && Objects.equals(expectedCashMoney, other.expectedCashMoney)
            && Objects.equals(closedCashMoney, other.closedCashMoney)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(updatedAt, other.updatedAt)
            && Objects.equals(locationId, other.locationId);
    }

    /**
     * Converts this CashDrawerShiftSummary into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CashDrawerShiftSummary [" + "id=" + id + ", state=" + state + ", openedAt="
                + openedAt + ", endedAt=" + endedAt + ", closedAt=" + closedAt + ", description="
                + description + ", openedCashMoney=" + openedCashMoney + ", expectedCashMoney="
                + expectedCashMoney + ", closedCashMoney=" + closedCashMoney + ", createdAt="
                + createdAt + ", updatedAt=" + updatedAt + ", locationId=" + locationId + "]";
    }

    /**
     * Builds a new {@link CashDrawerShiftSummary.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CashDrawerShiftSummary.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .state(getState())
                .openedCashMoney(getOpenedCashMoney())
                .expectedCashMoney(getExpectedCashMoney())
                .closedCashMoney(getClosedCashMoney())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt())
                .locationId(getLocationId());
        builder.openedAt = internalGetOpenedAt();
        builder.endedAt = internalGetEndedAt();
        builder.closedAt = internalGetClosedAt();
        builder.description = internalGetDescription();
        return builder;
    }

    /**
     * Class to build instances of {@link CashDrawerShiftSummary}.
     */
    public static class Builder {
        private String id;
        private String state;
        private OptionalNullable<String> openedAt;
        private OptionalNullable<String> endedAt;
        private OptionalNullable<String> closedAt;
        private OptionalNullable<String> description;
        private Money openedCashMoney;
        private Money expectedCashMoney;
        private Money closedCashMoney;
        private String createdAt;
        private String updatedAt;
        private String locationId;



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
         * Setter for state.
         * @param  state  String value for state.
         * @return Builder
         */
        public Builder state(String state) {
            this.state = state;
            return this;
        }

        /**
         * Setter for openedAt.
         * @param  openedAt  String value for openedAt.
         * @return Builder
         */
        public Builder openedAt(String openedAt) {
            this.openedAt = OptionalNullable.of(openedAt);
            return this;
        }

        /**
         * UnSetter for openedAt.
         * @return Builder
         */
        public Builder unsetOpenedAt() {
            openedAt = null;
            return this;
        }

        /**
         * Setter for endedAt.
         * @param  endedAt  String value for endedAt.
         * @return Builder
         */
        public Builder endedAt(String endedAt) {
            this.endedAt = OptionalNullable.of(endedAt);
            return this;
        }

        /**
         * UnSetter for endedAt.
         * @return Builder
         */
        public Builder unsetEndedAt() {
            endedAt = null;
            return this;
        }

        /**
         * Setter for closedAt.
         * @param  closedAt  String value for closedAt.
         * @return Builder
         */
        public Builder closedAt(String closedAt) {
            this.closedAt = OptionalNullable.of(closedAt);
            return this;
        }

        /**
         * UnSetter for closedAt.
         * @return Builder
         */
        public Builder unsetClosedAt() {
            closedAt = null;
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
         * Setter for openedCashMoney.
         * @param  openedCashMoney  Money value for openedCashMoney.
         * @return Builder
         */
        public Builder openedCashMoney(Money openedCashMoney) {
            this.openedCashMoney = openedCashMoney;
            return this;
        }

        /**
         * Setter for expectedCashMoney.
         * @param  expectedCashMoney  Money value for expectedCashMoney.
         * @return Builder
         */
        public Builder expectedCashMoney(Money expectedCashMoney) {
            this.expectedCashMoney = expectedCashMoney;
            return this;
        }

        /**
         * Setter for closedCashMoney.
         * @param  closedCashMoney  Money value for closedCashMoney.
         * @return Builder
         */
        public Builder closedCashMoney(Money closedCashMoney) {
            this.closedCashMoney = closedCashMoney;
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
         * Setter for updatedAt.
         * @param  updatedAt  String value for updatedAt.
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * Builds a new {@link CashDrawerShiftSummary} object using the set fields.
         * @return {@link CashDrawerShiftSummary}
         */
        public CashDrawerShiftSummary build() {
            return new CashDrawerShiftSummary(id, state, openedAt, endedAt, closedAt, description,
                    openedCashMoney, expectedCashMoney, closedCashMoney, createdAt, updatedAt,
                    locationId);
        }
    }
}
