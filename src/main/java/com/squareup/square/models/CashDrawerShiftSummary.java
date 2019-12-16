package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CashDrawerShiftSummary {

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
            @JsonProperty("closed_cash_money") Money closedCashMoney) {
        this.id = id;
        this.state = state;
        this.openedAt = openedAt;
        this.endedAt = endedAt;
        this.closedAt = closedAt;
        this.description = description;
        this.openedCashMoney = openedCashMoney;
        this.expectedCashMoney = expectedCashMoney;
        this.closedCashMoney = closedCashMoney;
    }

    private final String id;
    private final String state;
    private final String openedAt;
    private final String endedAt;
    private final String closedAt;
    private final String description;
    private final Money openedCashMoney;
    private final Money expectedCashMoney;
    private final Money closedCashMoney;

    @Override
    public int hashCode() {
        return Objects.hash(id, state, openedAt, endedAt, closedAt, description, openedCashMoney, expectedCashMoney, closedCashMoney);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CashDrawerShiftSummary)) {
            return false;
        }
        CashDrawerShiftSummary cashDrawerShiftSummary = (CashDrawerShiftSummary) o;
        return Objects.equals(id, cashDrawerShiftSummary.id) &&
            Objects.equals(state, cashDrawerShiftSummary.state) &&
            Objects.equals(openedAt, cashDrawerShiftSummary.openedAt) &&
            Objects.equals(endedAt, cashDrawerShiftSummary.endedAt) &&
            Objects.equals(closedAt, cashDrawerShiftSummary.closedAt) &&
            Objects.equals(description, cashDrawerShiftSummary.description) &&
            Objects.equals(openedCashMoney, cashDrawerShiftSummary.openedCashMoney) &&
            Objects.equals(expectedCashMoney, cashDrawerShiftSummary.expectedCashMoney) &&
            Objects.equals(closedCashMoney, cashDrawerShiftSummary.closedCashMoney);
    }
    
    /**
     * Getter for Id.
     * The shift unique ID.
     */
    @JsonGetter("id")
    public String getId() { 
        return this.id;
    }

    /**
     * Getter for State.
     * The current state of a cash drawer shift.
     */
    @JsonGetter("state")
    public String getState() { 
        return this.state;
    }

    /**
     * Getter for OpenedAt.
     * The shift start time in ISO 8601 format.
     */
    @JsonGetter("opened_at")
    public String getOpenedAt() { 
        return this.openedAt;
    }

    /**
     * Getter for EndedAt.
     * The shift end time in ISO 8601 format.
     */
    @JsonGetter("ended_at")
    public String getEndedAt() { 
        return this.endedAt;
    }

    /**
     * Getter for ClosedAt.
     * The shift close time in ISO 8601 format.
     */
    @JsonGetter("closed_at")
    public String getClosedAt() { 
        return this.closedAt;
    }

    /**
     * Getter for Description.
     * An employee free-text description of a cash drawer shift.
     */
    @JsonGetter("description")
    public String getDescription() { 
        return this.description;
    }

    /**
     * Getter for OpenedCashMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("opened_cash_money")
    public Money getOpenedCashMoney() { 
        return this.openedCashMoney;
    }

    /**
     * Getter for ExpectedCashMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("expected_cash_money")
    public Money getExpectedCashMoney() { 
        return this.expectedCashMoney;
    }

    /**
     * Getter for ClosedCashMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("closed_cash_money")
    public Money getClosedCashMoney() { 
        return this.closedCashMoney;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .id(getId())
            .state(getState())
            .openedAt(getOpenedAt())
            .endedAt(getEndedAt())
            .closedAt(getClosedAt())
            .description(getDescription())
            .openedCashMoney(getOpenedCashMoney())
            .expectedCashMoney(getExpectedCashMoney())
            .closedCashMoney(getClosedCashMoney());
            return builder;
    }

    public static class Builder {
        private String id;
        private String state;
        private String openedAt;
        private String endedAt;
        private String closedAt;
        private String description;
        private Money openedCashMoney;
        private Money expectedCashMoney;
        private Money closedCashMoney;

        public Builder() { }

        public Builder id(String value) {
            id = value;
            return this;
        }
        public Builder state(String value) {
            state = value;
            return this;
        }
        public Builder openedAt(String value) {
            openedAt = value;
            return this;
        }
        public Builder endedAt(String value) {
            endedAt = value;
            return this;
        }
        public Builder closedAt(String value) {
            closedAt = value;
            return this;
        }
        public Builder description(String value) {
            description = value;
            return this;
        }
        public Builder openedCashMoney(Money value) {
            openedCashMoney = value;
            return this;
        }
        public Builder expectedCashMoney(Money value) {
            expectedCashMoney = value;
            return this;
        }
        public Builder closedCashMoney(Money value) {
            closedCashMoney = value;
            return this;
        }

        public CashDrawerShiftSummary build() {
            return new CashDrawerShiftSummary(id,
                state,
                openedAt,
                endedAt,
                closedAt,
                description,
                openedCashMoney,
                expectedCashMoney,
                closedCashMoney);
        }
    }
}
