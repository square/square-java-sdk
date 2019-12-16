package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CashDrawerShift {

    @JsonCreator
    public CashDrawerShift(
            @JsonProperty("id") String id,
            @JsonProperty("state") String state,
            @JsonProperty("opened_at") String openedAt,
            @JsonProperty("ended_at") String endedAt,
            @JsonProperty("closed_at") String closedAt,
            @JsonProperty("employee_ids") List<String> employeeIds,
            @JsonProperty("opening_employee_id") String openingEmployeeId,
            @JsonProperty("ending_employee_id") String endingEmployeeId,
            @JsonProperty("closing_employee_id") String closingEmployeeId,
            @JsonProperty("description") String description,
            @JsonProperty("opened_cash_money") Money openedCashMoney,
            @JsonProperty("cash_payment_money") Money cashPaymentMoney,
            @JsonProperty("cash_refunds_money") Money cashRefundsMoney,
            @JsonProperty("cash_paid_in_money") Money cashPaidInMoney,
            @JsonProperty("cash_paid_out_money") Money cashPaidOutMoney,
            @JsonProperty("expected_cash_money") Money expectedCashMoney,
            @JsonProperty("closed_cash_money") Money closedCashMoney,
            @JsonProperty("device") CashDrawerDevice device) {
        this.id = id;
        this.state = state;
        this.openedAt = openedAt;
        this.endedAt = endedAt;
        this.closedAt = closedAt;
        this.employeeIds = employeeIds;
        this.openingEmployeeId = openingEmployeeId;
        this.endingEmployeeId = endingEmployeeId;
        this.closingEmployeeId = closingEmployeeId;
        this.description = description;
        this.openedCashMoney = openedCashMoney;
        this.cashPaymentMoney = cashPaymentMoney;
        this.cashRefundsMoney = cashRefundsMoney;
        this.cashPaidInMoney = cashPaidInMoney;
        this.cashPaidOutMoney = cashPaidOutMoney;
        this.expectedCashMoney = expectedCashMoney;
        this.closedCashMoney = closedCashMoney;
        this.device = device;
    }

    private final String id;
    private final String state;
    private final String openedAt;
    private final String endedAt;
    private final String closedAt;
    private final List<String> employeeIds;
    private final String openingEmployeeId;
    private final String endingEmployeeId;
    private final String closingEmployeeId;
    private final String description;
    private final Money openedCashMoney;
    private final Money cashPaymentMoney;
    private final Money cashRefundsMoney;
    private final Money cashPaidInMoney;
    private final Money cashPaidOutMoney;
    private final Money expectedCashMoney;
    private final Money closedCashMoney;
    private final CashDrawerDevice device;

    @Override
    public int hashCode() {
        return Objects.hash(id, state, openedAt, endedAt, closedAt, employeeIds, openingEmployeeId, endingEmployeeId, closingEmployeeId, description, openedCashMoney, cashPaymentMoney, cashRefundsMoney, cashPaidInMoney, cashPaidOutMoney, expectedCashMoney, closedCashMoney, device);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CashDrawerShift)) {
            return false;
        }
        CashDrawerShift cashDrawerShift = (CashDrawerShift) o;
        return Objects.equals(id, cashDrawerShift.id) &&
            Objects.equals(state, cashDrawerShift.state) &&
            Objects.equals(openedAt, cashDrawerShift.openedAt) &&
            Objects.equals(endedAt, cashDrawerShift.endedAt) &&
            Objects.equals(closedAt, cashDrawerShift.closedAt) &&
            Objects.equals(employeeIds, cashDrawerShift.employeeIds) &&
            Objects.equals(openingEmployeeId, cashDrawerShift.openingEmployeeId) &&
            Objects.equals(endingEmployeeId, cashDrawerShift.endingEmployeeId) &&
            Objects.equals(closingEmployeeId, cashDrawerShift.closingEmployeeId) &&
            Objects.equals(description, cashDrawerShift.description) &&
            Objects.equals(openedCashMoney, cashDrawerShift.openedCashMoney) &&
            Objects.equals(cashPaymentMoney, cashDrawerShift.cashPaymentMoney) &&
            Objects.equals(cashRefundsMoney, cashDrawerShift.cashRefundsMoney) &&
            Objects.equals(cashPaidInMoney, cashDrawerShift.cashPaidInMoney) &&
            Objects.equals(cashPaidOutMoney, cashDrawerShift.cashPaidOutMoney) &&
            Objects.equals(expectedCashMoney, cashDrawerShift.expectedCashMoney) &&
            Objects.equals(closedCashMoney, cashDrawerShift.closedCashMoney) &&
            Objects.equals(device, cashDrawerShift.device);
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
     * The time when the shift began, in ISO 8601 format.
     */
    @JsonGetter("opened_at")
    public String getOpenedAt() { 
        return this.openedAt;
    }

    /**
     * Getter for EndedAt.
     * The time when the shift ended, in ISO 8601 format.
     */
    @JsonGetter("ended_at")
    public String getEndedAt() { 
        return this.endedAt;
    }

    /**
     * Getter for ClosedAt.
     * The time when the shift was closed, in ISO 8601 format.
     */
    @JsonGetter("closed_at")
    public String getClosedAt() { 
        return this.closedAt;
    }

    /**
     * Getter for EmployeeIds.
     * The IDs of all employees that were logged into Square Point of Sale at any
     * point while the cash drawer shift was open.
     */
    @JsonGetter("employee_ids")
    public List<String> getEmployeeIds() { 
        return this.employeeIds;
    }

    /**
     * Getter for OpeningEmployeeId.
     * The ID of the employee that started the cash drawer shift.
     */
    @JsonGetter("opening_employee_id")
    public String getOpeningEmployeeId() { 
        return this.openingEmployeeId;
    }

    /**
     * Getter for EndingEmployeeId.
     * The ID of the employee that ended the cash drawer shift.
     */
    @JsonGetter("ending_employee_id")
    public String getEndingEmployeeId() { 
        return this.endingEmployeeId;
    }

    /**
     * Getter for ClosingEmployeeId.
     * The ID of the employee that closed the cash drawer shift by auditing
     * the cash drawer contents.
     */
    @JsonGetter("closing_employee_id")
    public String getClosingEmployeeId() { 
        return this.closingEmployeeId;
    }

    /**
     * Getter for Description.
     * The free-form text description of a cash drawer by an employee.
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
     * Getter for CashPaymentMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("cash_payment_money")
    public Money getCashPaymentMoney() { 
        return this.cashPaymentMoney;
    }

    /**
     * Getter for CashRefundsMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("cash_refunds_money")
    public Money getCashRefundsMoney() { 
        return this.cashRefundsMoney;
    }

    /**
     * Getter for CashPaidInMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("cash_paid_in_money")
    public Money getCashPaidInMoney() { 
        return this.cashPaidInMoney;
    }

    /**
     * Getter for CashPaidOutMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("cash_paid_out_money")
    public Money getCashPaidOutMoney() { 
        return this.cashPaidOutMoney;
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

    /**
     * Getter for Device.
     */
    @JsonGetter("device")
    public CashDrawerDevice getDevice() { 
        return this.device;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .id(getId())
            .state(getState())
            .openedAt(getOpenedAt())
            .endedAt(getEndedAt())
            .closedAt(getClosedAt())
            .employeeIds(getEmployeeIds())
            .openingEmployeeId(getOpeningEmployeeId())
            .endingEmployeeId(getEndingEmployeeId())
            .closingEmployeeId(getClosingEmployeeId())
            .description(getDescription())
            .openedCashMoney(getOpenedCashMoney())
            .cashPaymentMoney(getCashPaymentMoney())
            .cashRefundsMoney(getCashRefundsMoney())
            .cashPaidInMoney(getCashPaidInMoney())
            .cashPaidOutMoney(getCashPaidOutMoney())
            .expectedCashMoney(getExpectedCashMoney())
            .closedCashMoney(getClosedCashMoney())
            .device(getDevice());
            return builder;
    }

    public static class Builder {
        private String id;
        private String state;
        private String openedAt;
        private String endedAt;
        private String closedAt;
        private List<String> employeeIds;
        private String openingEmployeeId;
        private String endingEmployeeId;
        private String closingEmployeeId;
        private String description;
        private Money openedCashMoney;
        private Money cashPaymentMoney;
        private Money cashRefundsMoney;
        private Money cashPaidInMoney;
        private Money cashPaidOutMoney;
        private Money expectedCashMoney;
        private Money closedCashMoney;
        private CashDrawerDevice device;

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
        public Builder employeeIds(List<String> value) {
            employeeIds = value;
            return this;
        }
        public Builder openingEmployeeId(String value) {
            openingEmployeeId = value;
            return this;
        }
        public Builder endingEmployeeId(String value) {
            endingEmployeeId = value;
            return this;
        }
        public Builder closingEmployeeId(String value) {
            closingEmployeeId = value;
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
        public Builder cashPaymentMoney(Money value) {
            cashPaymentMoney = value;
            return this;
        }
        public Builder cashRefundsMoney(Money value) {
            cashRefundsMoney = value;
            return this;
        }
        public Builder cashPaidInMoney(Money value) {
            cashPaidInMoney = value;
            return this;
        }
        public Builder cashPaidOutMoney(Money value) {
            cashPaidOutMoney = value;
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
        public Builder device(CashDrawerDevice value) {
            device = value;
            return this;
        }

        public CashDrawerShift build() {
            return new CashDrawerShift(id,
                state,
                openedAt,
                endedAt,
                closedAt,
                employeeIds,
                openingEmployeeId,
                endingEmployeeId,
                closingEmployeeId,
                description,
                openedCashMoney,
                cashPaymentMoney,
                cashRefundsMoney,
                cashPaidInMoney,
                cashPaidOutMoney,
                expectedCashMoney,
                closedCashMoney,
                device);
        }
    }
}
