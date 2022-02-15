
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CashDrawerShift type.
 */
public class CashDrawerShift {
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

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  state  String value for state.
     * @param  openedAt  String value for openedAt.
     * @param  endedAt  String value for endedAt.
     * @param  closedAt  String value for closedAt.
     * @param  employeeIds  List of String value for employeeIds.
     * @param  openingEmployeeId  String value for openingEmployeeId.
     * @param  endingEmployeeId  String value for endingEmployeeId.
     * @param  closingEmployeeId  String value for closingEmployeeId.
     * @param  description  String value for description.
     * @param  openedCashMoney  Money value for openedCashMoney.
     * @param  cashPaymentMoney  Money value for cashPaymentMoney.
     * @param  cashRefundsMoney  Money value for cashRefundsMoney.
     * @param  cashPaidInMoney  Money value for cashPaidInMoney.
     * @param  cashPaidOutMoney  Money value for cashPaidOutMoney.
     * @param  expectedCashMoney  Money value for expectedCashMoney.
     * @param  closedCashMoney  Money value for closedCashMoney.
     * @param  device  CashDrawerDevice value for device.
     */
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
     * Getter for OpenedAt.
     * The time when the shift began, in ISO 8601 format.
     * @return Returns the String
     */
    @JsonGetter("opened_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getOpenedAt() {
        return openedAt;
    }

    /**
     * Getter for EndedAt.
     * The time when the shift ended, in ISO 8601 format.
     * @return Returns the String
     */
    @JsonGetter("ended_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getEndedAt() {
        return endedAt;
    }

    /**
     * Getter for ClosedAt.
     * The time when the shift was closed, in ISO 8601 format.
     * @return Returns the String
     */
    @JsonGetter("closed_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getClosedAt() {
        return closedAt;
    }

    /**
     * Getter for EmployeeIds.
     * The IDs of all employees that were logged into Square Point of Sale at any point while the
     * cash drawer shift was open.
     * @return Returns the List of String
     */
    @JsonGetter("employee_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<String> getEmployeeIds() {
        return employeeIds;
    }

    /**
     * Getter for OpeningEmployeeId.
     * The ID of the employee that started the cash drawer shift.
     * @return Returns the String
     */
    @JsonGetter("opening_employee_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getOpeningEmployeeId() {
        return openingEmployeeId;
    }

    /**
     * Getter for EndingEmployeeId.
     * The ID of the employee that ended the cash drawer shift.
     * @return Returns the String
     */
    @JsonGetter("ending_employee_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getEndingEmployeeId() {
        return endingEmployeeId;
    }

    /**
     * Getter for ClosingEmployeeId.
     * The ID of the employee that closed the cash drawer shift by auditing the cash drawer
     * contents.
     * @return Returns the String
     */
    @JsonGetter("closing_employee_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getClosingEmployeeId() {
        return closingEmployeeId;
    }

    /**
     * Getter for Description.
     * The free-form text description of a cash drawer by an employee.
     * @return Returns the String
     */
    @JsonGetter("description")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDescription() {
        return description;
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
     * Getter for CashPaymentMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("cash_payment_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getCashPaymentMoney() {
        return cashPaymentMoney;
    }

    /**
     * Getter for CashRefundsMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("cash_refunds_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getCashRefundsMoney() {
        return cashRefundsMoney;
    }

    /**
     * Getter for CashPaidInMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("cash_paid_in_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getCashPaidInMoney() {
        return cashPaidInMoney;
    }

    /**
     * Getter for CashPaidOutMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("cash_paid_out_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getCashPaidOutMoney() {
        return cashPaidOutMoney;
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
     * Getter for Device.
     * @return Returns the CashDrawerDevice
     */
    @JsonGetter("device")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CashDrawerDevice getDevice() {
        return device;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, state, openedAt, endedAt, closedAt, employeeIds, openingEmployeeId,
                endingEmployeeId, closingEmployeeId, description, openedCashMoney, cashPaymentMoney,
                cashRefundsMoney, cashPaidInMoney, cashPaidOutMoney, expectedCashMoney,
                closedCashMoney, device);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CashDrawerShift)) {
            return false;
        }
        CashDrawerShift other = (CashDrawerShift) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(state, other.state)
            && Objects.equals(openedAt, other.openedAt)
            && Objects.equals(endedAt, other.endedAt)
            && Objects.equals(closedAt, other.closedAt)
            && Objects.equals(employeeIds, other.employeeIds)
            && Objects.equals(openingEmployeeId, other.openingEmployeeId)
            && Objects.equals(endingEmployeeId, other.endingEmployeeId)
            && Objects.equals(closingEmployeeId, other.closingEmployeeId)
            && Objects.equals(description, other.description)
            && Objects.equals(openedCashMoney, other.openedCashMoney)
            && Objects.equals(cashPaymentMoney, other.cashPaymentMoney)
            && Objects.equals(cashRefundsMoney, other.cashRefundsMoney)
            && Objects.equals(cashPaidInMoney, other.cashPaidInMoney)
            && Objects.equals(cashPaidOutMoney, other.cashPaidOutMoney)
            && Objects.equals(expectedCashMoney, other.expectedCashMoney)
            && Objects.equals(closedCashMoney, other.closedCashMoney)
            && Objects.equals(device, other.device);
    }

    /**
     * Converts this CashDrawerShift into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CashDrawerShift [" + "id=" + id + ", state=" + state + ", openedAt=" + openedAt
                + ", endedAt=" + endedAt + ", closedAt=" + closedAt + ", employeeIds=" + employeeIds
                + ", openingEmployeeId=" + openingEmployeeId + ", endingEmployeeId="
                + endingEmployeeId + ", closingEmployeeId=" + closingEmployeeId + ", description="
                + description + ", openedCashMoney=" + openedCashMoney + ", cashPaymentMoney="
                + cashPaymentMoney + ", cashRefundsMoney=" + cashRefundsMoney + ", cashPaidInMoney="
                + cashPaidInMoney + ", cashPaidOutMoney=" + cashPaidOutMoney
                + ", expectedCashMoney=" + expectedCashMoney + ", closedCashMoney="
                + closedCashMoney + ", device=" + device + "]";
    }

    /**
     * Builds a new {@link CashDrawerShift.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CashDrawerShift.Builder} object
     */
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

    /**
     * Class to build instances of {@link CashDrawerShift}.
     */
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
            this.openedAt = openedAt;
            return this;
        }

        /**
         * Setter for endedAt.
         * @param  endedAt  String value for endedAt.
         * @return Builder
         */
        public Builder endedAt(String endedAt) {
            this.endedAt = endedAt;
            return this;
        }

        /**
         * Setter for closedAt.
         * @param  closedAt  String value for closedAt.
         * @return Builder
         */
        public Builder closedAt(String closedAt) {
            this.closedAt = closedAt;
            return this;
        }

        /**
         * Setter for employeeIds.
         * @param  employeeIds  List of String value for employeeIds.
         * @return Builder
         */
        public Builder employeeIds(List<String> employeeIds) {
            this.employeeIds = employeeIds;
            return this;
        }

        /**
         * Setter for openingEmployeeId.
         * @param  openingEmployeeId  String value for openingEmployeeId.
         * @return Builder
         */
        public Builder openingEmployeeId(String openingEmployeeId) {
            this.openingEmployeeId = openingEmployeeId;
            return this;
        }

        /**
         * Setter for endingEmployeeId.
         * @param  endingEmployeeId  String value for endingEmployeeId.
         * @return Builder
         */
        public Builder endingEmployeeId(String endingEmployeeId) {
            this.endingEmployeeId = endingEmployeeId;
            return this;
        }

        /**
         * Setter for closingEmployeeId.
         * @param  closingEmployeeId  String value for closingEmployeeId.
         * @return Builder
         */
        public Builder closingEmployeeId(String closingEmployeeId) {
            this.closingEmployeeId = closingEmployeeId;
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
         * Setter for openedCashMoney.
         * @param  openedCashMoney  Money value for openedCashMoney.
         * @return Builder
         */
        public Builder openedCashMoney(Money openedCashMoney) {
            this.openedCashMoney = openedCashMoney;
            return this;
        }

        /**
         * Setter for cashPaymentMoney.
         * @param  cashPaymentMoney  Money value for cashPaymentMoney.
         * @return Builder
         */
        public Builder cashPaymentMoney(Money cashPaymentMoney) {
            this.cashPaymentMoney = cashPaymentMoney;
            return this;
        }

        /**
         * Setter for cashRefundsMoney.
         * @param  cashRefundsMoney  Money value for cashRefundsMoney.
         * @return Builder
         */
        public Builder cashRefundsMoney(Money cashRefundsMoney) {
            this.cashRefundsMoney = cashRefundsMoney;
            return this;
        }

        /**
         * Setter for cashPaidInMoney.
         * @param  cashPaidInMoney  Money value for cashPaidInMoney.
         * @return Builder
         */
        public Builder cashPaidInMoney(Money cashPaidInMoney) {
            this.cashPaidInMoney = cashPaidInMoney;
            return this;
        }

        /**
         * Setter for cashPaidOutMoney.
         * @param  cashPaidOutMoney  Money value for cashPaidOutMoney.
         * @return Builder
         */
        public Builder cashPaidOutMoney(Money cashPaidOutMoney) {
            this.cashPaidOutMoney = cashPaidOutMoney;
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
         * Setter for device.
         * @param  device  CashDrawerDevice value for device.
         * @return Builder
         */
        public Builder device(CashDrawerDevice device) {
            this.device = device;
            return this;
        }

        /**
         * Builds a new {@link CashDrawerShift} object using the set fields.
         * @return {@link CashDrawerShift}
         */
        public CashDrawerShift build() {
            return new CashDrawerShift(id, state, openedAt, endedAt, closedAt, employeeIds,
                    openingEmployeeId, endingEmployeeId, closingEmployeeId, description,
                    openedCashMoney, cashPaymentMoney, cashRefundsMoney, cashPaidInMoney,
                    cashPaidOutMoney, expectedCashMoney, closedCashMoney, device);
        }
    }
}
