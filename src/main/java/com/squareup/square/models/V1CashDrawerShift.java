
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for V1CashDrawerShift type.
 */
public class V1CashDrawerShift {
    private HttpContext httpContext;
    private final String id;
    private final String eventType;
    private final String openedAt;
    private final String endedAt;
    private final String closedAt;
    private final List<String> employeeIds;
    private final String openingEmployeeId;
    private final String endingEmployeeId;
    private final String closingEmployeeId;
    private final String description;
    private final V1Money startingCashMoney;
    private final V1Money cashPaymentMoney;
    private final V1Money cashRefundsMoney;
    private final V1Money cashPaidInMoney;
    private final V1Money cashPaidOutMoney;
    private final V1Money expectedCashMoney;
    private final V1Money closedCashMoney;
    private final Device device;
    private final List<V1CashDrawerEvent> events;

    /**
     * Initialization constructor.
     * @param id String value for id.
     * @param eventType String value for eventType.
     * @param openedAt String value for openedAt.
     * @param endedAt String value for endedAt.
     * @param closedAt String value for closedAt.
     * @param employeeIds List of String value for employeeIds.
     * @param openingEmployeeId String value for openingEmployeeId.
     * @param endingEmployeeId String value for endingEmployeeId.
     * @param closingEmployeeId String value for closingEmployeeId.
     * @param description String value for description.
     * @param startingCashMoney V1Money value for startingCashMoney.
     * @param cashPaymentMoney V1Money value for cashPaymentMoney.
     * @param cashRefundsMoney V1Money value for cashRefundsMoney.
     * @param cashPaidInMoney V1Money value for cashPaidInMoney.
     * @param cashPaidOutMoney V1Money value for cashPaidOutMoney.
     * @param expectedCashMoney V1Money value for expectedCashMoney.
     * @param closedCashMoney V1Money value for closedCashMoney.
     * @param device Device value for device.
     * @param events List of V1CashDrawerEvent value for events.
     */
    @JsonCreator
    public V1CashDrawerShift(
            @JsonProperty("id") String id,
            @JsonProperty("event_type") String eventType,
            @JsonProperty("opened_at") String openedAt,
            @JsonProperty("ended_at") String endedAt,
            @JsonProperty("closed_at") String closedAt,
            @JsonProperty("employee_ids") List<String> employeeIds,
            @JsonProperty("opening_employee_id") String openingEmployeeId,
            @JsonProperty("ending_employee_id") String endingEmployeeId,
            @JsonProperty("closing_employee_id") String closingEmployeeId,
            @JsonProperty("description") String description,
            @JsonProperty("starting_cash_money") V1Money startingCashMoney,
            @JsonProperty("cash_payment_money") V1Money cashPaymentMoney,
            @JsonProperty("cash_refunds_money") V1Money cashRefundsMoney,
            @JsonProperty("cash_paid_in_money") V1Money cashPaidInMoney,
            @JsonProperty("cash_paid_out_money") V1Money cashPaidOutMoney,
            @JsonProperty("expected_cash_money") V1Money expectedCashMoney,
            @JsonProperty("closed_cash_money") V1Money closedCashMoney,
            @JsonProperty("device") Device device,
            @JsonProperty("events") List<V1CashDrawerEvent> events) {
        this.id = id;
        this.eventType = eventType;
        this.openedAt = openedAt;
        this.endedAt = endedAt;
        this.closedAt = closedAt;
        this.employeeIds = employeeIds;
        this.openingEmployeeId = openingEmployeeId;
        this.endingEmployeeId = endingEmployeeId;
        this.closingEmployeeId = closingEmployeeId;
        this.description = description;
        this.startingCashMoney = startingCashMoney;
        this.cashPaymentMoney = cashPaymentMoney;
        this.cashRefundsMoney = cashRefundsMoney;
        this.cashPaidInMoney = cashPaidInMoney;
        this.cashPaidOutMoney = cashPaidOutMoney;
        this.expectedCashMoney = expectedCashMoney;
        this.closedCashMoney = closedCashMoney;
        this.device = device;
        this.events = events;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Id.
     * The shift's unique ID.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
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
     * Getter for OpenedAt.
     * The time when the shift began, in ISO 8601 format.
     * @return Returns the String
     */
    @JsonGetter("opened_at")
    public String getOpenedAt() {
        return this.openedAt;
    }

    /**
     * Getter for EndedAt.
     * The time when the shift ended, in ISO 8601 format.
     * @return Returns the String
     */
    @JsonGetter("ended_at")
    public String getEndedAt() {
        return this.endedAt;
    }

    /**
     * Getter for ClosedAt.
     * The time when the shift was closed, in ISO 8601 format.
     * @return Returns the String
     */
    @JsonGetter("closed_at")
    public String getClosedAt() {
        return this.closedAt;
    }

    /**
     * Getter for EmployeeIds.
     * The IDs of all employees that were logged into Square Register at some point during the cash
     * drawer shift.
     * @return Returns the List of String
     */
    @JsonGetter("employee_ids")
    public List<String> getEmployeeIds() {
        return this.employeeIds;
    }

    /**
     * Getter for OpeningEmployeeId.
     * The ID of the employee that started the cash drawer shift.
     * @return Returns the String
     */
    @JsonGetter("opening_employee_id")
    public String getOpeningEmployeeId() {
        return this.openingEmployeeId;
    }

    /**
     * Getter for EndingEmployeeId.
     * The ID of the employee that ended the cash drawer shift.
     * @return Returns the String
     */
    @JsonGetter("ending_employee_id")
    public String getEndingEmployeeId() {
        return this.endingEmployeeId;
    }

    /**
     * Getter for ClosingEmployeeId.
     * The ID of the employee that closed the cash drawer shift by auditing the cash drawer's
     * contents.
     * @return Returns the String
     */
    @JsonGetter("closing_employee_id")
    public String getClosingEmployeeId() {
        return this.closingEmployeeId;
    }

    /**
     * Getter for Description.
     * A description of the cash drawer shift.
     * @return Returns the String
     */
    @JsonGetter("description")
    public String getDescription() {
        return this.description;
    }

    /**
     * Getter for StartingCashMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("starting_cash_money")
    public V1Money getStartingCashMoney() {
        return this.startingCashMoney;
    }

    /**
     * Getter for CashPaymentMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("cash_payment_money")
    public V1Money getCashPaymentMoney() {
        return this.cashPaymentMoney;
    }

    /**
     * Getter for CashRefundsMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("cash_refunds_money")
    public V1Money getCashRefundsMoney() {
        return this.cashRefundsMoney;
    }

    /**
     * Getter for CashPaidInMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("cash_paid_in_money")
    public V1Money getCashPaidInMoney() {
        return this.cashPaidInMoney;
    }

    /**
     * Getter for CashPaidOutMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("cash_paid_out_money")
    public V1Money getCashPaidOutMoney() {
        return this.cashPaidOutMoney;
    }

    /**
     * Getter for ExpectedCashMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("expected_cash_money")
    public V1Money getExpectedCashMoney() {
        return this.expectedCashMoney;
    }

    /**
     * Getter for ClosedCashMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("closed_cash_money")
    public V1Money getClosedCashMoney() {
        return this.closedCashMoney;
    }

    /**
     * Getter for Device.
     * @return Returns the Device
     */
    @JsonGetter("device")
    public Device getDevice() {
        return this.device;
    }

    /**
     * Getter for Events.
     * All of the events (payments, refunds, and so on) that involved the cash drawer during the
     * shift.
     * @return Returns the List of V1CashDrawerEvent
     */
    @JsonGetter("events")
    public List<V1CashDrawerEvent> getEvents() {
        return this.events;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventType, openedAt, endedAt, closedAt, employeeIds,
                openingEmployeeId, endingEmployeeId, closingEmployeeId, description,
                startingCashMoney, cashPaymentMoney, cashRefundsMoney, cashPaidInMoney,
                cashPaidOutMoney, expectedCashMoney, closedCashMoney, device, events);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1CashDrawerShift)) {
            return false;
        }
        V1CashDrawerShift other = (V1CashDrawerShift) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(eventType, other.eventType)
            && Objects.equals(openedAt, other.openedAt)
            && Objects.equals(endedAt, other.endedAt)
            && Objects.equals(closedAt, other.closedAt)
            && Objects.equals(employeeIds, other.employeeIds)
            && Objects.equals(openingEmployeeId, other.openingEmployeeId)
            && Objects.equals(endingEmployeeId, other.endingEmployeeId)
            && Objects.equals(closingEmployeeId, other.closingEmployeeId)
            && Objects.equals(description, other.description)
            && Objects.equals(startingCashMoney, other.startingCashMoney)
            && Objects.equals(cashPaymentMoney, other.cashPaymentMoney)
            && Objects.equals(cashRefundsMoney, other.cashRefundsMoney)
            && Objects.equals(cashPaidInMoney, other.cashPaidInMoney)
            && Objects.equals(cashPaidOutMoney, other.cashPaidOutMoney)
            && Objects.equals(expectedCashMoney, other.expectedCashMoney)
            && Objects.equals(closedCashMoney, other.closedCashMoney)
            && Objects.equals(device, other.device)
            && Objects.equals(events, other.events);
    }

    /**
     * Converts this V1CashDrawerShift into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1CashDrawerShift [" + "id=" + id + ", eventType=" + eventType + ", openedAt="
                + openedAt + ", endedAt=" + endedAt + ", closedAt=" + closedAt + ", employeeIds="
                + employeeIds + ", openingEmployeeId=" + openingEmployeeId + ", endingEmployeeId="
                + endingEmployeeId + ", closingEmployeeId=" + closingEmployeeId + ", description="
                + description + ", startingCashMoney=" + startingCashMoney + ", cashPaymentMoney="
                + cashPaymentMoney + ", cashRefundsMoney=" + cashRefundsMoney + ", cashPaidInMoney="
                + cashPaidInMoney + ", cashPaidOutMoney=" + cashPaidOutMoney
                + ", expectedCashMoney=" + expectedCashMoney + ", closedCashMoney="
                + closedCashMoney + ", device=" + device + ", events=" + events + "]";
    }

    /**
     * Builds a new {@link V1CashDrawerShift.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1CashDrawerShift.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .eventType(getEventType())
                .openedAt(getOpenedAt())
                .endedAt(getEndedAt())
                .closedAt(getClosedAt())
                .employeeIds(getEmployeeIds())
                .openingEmployeeId(getOpeningEmployeeId())
                .endingEmployeeId(getEndingEmployeeId())
                .closingEmployeeId(getClosingEmployeeId())
                .description(getDescription())
                .startingCashMoney(getStartingCashMoney())
                .cashPaymentMoney(getCashPaymentMoney())
                .cashRefundsMoney(getCashRefundsMoney())
                .cashPaidInMoney(getCashPaidInMoney())
                .cashPaidOutMoney(getCashPaidOutMoney())
                .expectedCashMoney(getExpectedCashMoney())
                .closedCashMoney(getClosedCashMoney())
                .device(getDevice())
                .events(getEvents());
        return builder;
    }

    /**
     * Class to build instances of {@link V1CashDrawerShift}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private String id;
        private String eventType;
        private String openedAt;
        private String endedAt;
        private String closedAt;
        private List<String> employeeIds;
        private String openingEmployeeId;
        private String endingEmployeeId;
        private String closingEmployeeId;
        private String description;
        private V1Money startingCashMoney;
        private V1Money cashPaymentMoney;
        private V1Money cashRefundsMoney;
        private V1Money cashPaidInMoney;
        private V1Money cashPaidOutMoney;
        private V1Money expectedCashMoney;
        private V1Money closedCashMoney;
        private Device device;
        private List<V1CashDrawerEvent> events;



        /**
         * Setter for httpContext.
         * @param httpContext HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

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
         * Setter for eventType.
         * @param eventType String value for eventType.
         * @return Builder
         */
        public Builder eventType(String eventType) {
            this.eventType = eventType;
            return this;
        }

        /**
         * Setter for openedAt.
         * @param openedAt String value for openedAt.
         * @return Builder
         */
        public Builder openedAt(String openedAt) {
            this.openedAt = openedAt;
            return this;
        }

        /**
         * Setter for endedAt.
         * @param endedAt String value for endedAt.
         * @return Builder
         */
        public Builder endedAt(String endedAt) {
            this.endedAt = endedAt;
            return this;
        }

        /**
         * Setter for closedAt.
         * @param closedAt String value for closedAt.
         * @return Builder
         */
        public Builder closedAt(String closedAt) {
            this.closedAt = closedAt;
            return this;
        }

        /**
         * Setter for employeeIds.
         * @param employeeIds List of String value for employeeIds.
         * @return Builder
         */
        public Builder employeeIds(List<String> employeeIds) {
            this.employeeIds = employeeIds;
            return this;
        }

        /**
         * Setter for openingEmployeeId.
         * @param openingEmployeeId String value for openingEmployeeId.
         * @return Builder
         */
        public Builder openingEmployeeId(String openingEmployeeId) {
            this.openingEmployeeId = openingEmployeeId;
            return this;
        }

        /**
         * Setter for endingEmployeeId.
         * @param endingEmployeeId String value for endingEmployeeId.
         * @return Builder
         */
        public Builder endingEmployeeId(String endingEmployeeId) {
            this.endingEmployeeId = endingEmployeeId;
            return this;
        }

        /**
         * Setter for closingEmployeeId.
         * @param closingEmployeeId String value for closingEmployeeId.
         * @return Builder
         */
        public Builder closingEmployeeId(String closingEmployeeId) {
            this.closingEmployeeId = closingEmployeeId;
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
         * Setter for startingCashMoney.
         * @param startingCashMoney V1Money value for startingCashMoney.
         * @return Builder
         */
        public Builder startingCashMoney(V1Money startingCashMoney) {
            this.startingCashMoney = startingCashMoney;
            return this;
        }

        /**
         * Setter for cashPaymentMoney.
         * @param cashPaymentMoney V1Money value for cashPaymentMoney.
         * @return Builder
         */
        public Builder cashPaymentMoney(V1Money cashPaymentMoney) {
            this.cashPaymentMoney = cashPaymentMoney;
            return this;
        }

        /**
         * Setter for cashRefundsMoney.
         * @param cashRefundsMoney V1Money value for cashRefundsMoney.
         * @return Builder
         */
        public Builder cashRefundsMoney(V1Money cashRefundsMoney) {
            this.cashRefundsMoney = cashRefundsMoney;
            return this;
        }

        /**
         * Setter for cashPaidInMoney.
         * @param cashPaidInMoney V1Money value for cashPaidInMoney.
         * @return Builder
         */
        public Builder cashPaidInMoney(V1Money cashPaidInMoney) {
            this.cashPaidInMoney = cashPaidInMoney;
            return this;
        }

        /**
         * Setter for cashPaidOutMoney.
         * @param cashPaidOutMoney V1Money value for cashPaidOutMoney.
         * @return Builder
         */
        public Builder cashPaidOutMoney(V1Money cashPaidOutMoney) {
            this.cashPaidOutMoney = cashPaidOutMoney;
            return this;
        }

        /**
         * Setter for expectedCashMoney.
         * @param expectedCashMoney V1Money value for expectedCashMoney.
         * @return Builder
         */
        public Builder expectedCashMoney(V1Money expectedCashMoney) {
            this.expectedCashMoney = expectedCashMoney;
            return this;
        }

        /**
         * Setter for closedCashMoney.
         * @param closedCashMoney V1Money value for closedCashMoney.
         * @return Builder
         */
        public Builder closedCashMoney(V1Money closedCashMoney) {
            this.closedCashMoney = closedCashMoney;
            return this;
        }

        /**
         * Setter for device.
         * @param device Device value for device.
         * @return Builder
         */
        public Builder device(Device device) {
            this.device = device;
            return this;
        }

        /**
         * Setter for events.
         * @param events List of V1CashDrawerEvent value for events.
         * @return Builder
         */
        public Builder events(List<V1CashDrawerEvent> events) {
            this.events = events;
            return this;
        }

        /**
         * Builds a new {@link V1CashDrawerShift} object using the set fields.
         * @return {@link V1CashDrawerShift}
         */
        public V1CashDrawerShift build() {
            V1CashDrawerShift model =
                    new V1CashDrawerShift(id, eventType, openedAt, endedAt, closedAt, employeeIds,
                            openingEmployeeId, endingEmployeeId, closingEmployeeId, description,
                            startingCashMoney, cashPaymentMoney, cashRefundsMoney, cashPaidInMoney,
                            cashPaidOutMoney, expectedCashMoney, closedCashMoney, device, events);
            model.httpContext = httpContext;
            return model;
        }
    }
}
