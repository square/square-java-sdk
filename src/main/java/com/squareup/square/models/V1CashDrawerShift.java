package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for V1CashDrawerShift type.
 */
public class V1CashDrawerShift {

    /**
     * Initialization constructor.
     * @param id
     * @param eventType
     * @param openedAt
     * @param endedAt
     * @param closedAt
     * @param employeeIds
     * @param openingEmployeeId
     * @param endingEmployeeId
     * @param closingEmployeeId
     * @param description
     * @param startingCashMoney
     * @param cashPaymentMoney
     * @param cashRefundsMoney
     * @param cashPaidInMoney
     * @param cashPaidOutMoney
     * @param expectedCashMoney
     * @param closedCashMoney
     * @param device
     * @param events
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

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Id.
     * The shift's unique ID.
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for EventType.
     */
    @JsonGetter("event_type")
    public String getEventType() {
        return this.eventType;
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
     * The IDs of all employees that were logged into Square Register at some point during the cash drawer shift.
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
     * The ID of the employee that closed the cash drawer shift by auditing the cash drawer's contents.
     */
    @JsonGetter("closing_employee_id")
    public String getClosingEmployeeId() {
        return this.closingEmployeeId;
    }

    /**
     * Getter for Description.
     * A description of the cash drawer shift.
     */
    @JsonGetter("description")
    public String getDescription() {
        return this.description;
    }

    /**
     * Getter for StartingCashMoney.
     */
    @JsonGetter("starting_cash_money")
    public V1Money getStartingCashMoney() {
        return this.startingCashMoney;
    }

    /**
     * Getter for CashPaymentMoney.
     */
    @JsonGetter("cash_payment_money")
    public V1Money getCashPaymentMoney() {
        return this.cashPaymentMoney;
    }

    /**
     * Getter for CashRefundsMoney.
     */
    @JsonGetter("cash_refunds_money")
    public V1Money getCashRefundsMoney() {
        return this.cashRefundsMoney;
    }

    /**
     * Getter for CashPaidInMoney.
     */
    @JsonGetter("cash_paid_in_money")
    public V1Money getCashPaidInMoney() {
        return this.cashPaidInMoney;
    }

    /**
     * Getter for CashPaidOutMoney.
     */
    @JsonGetter("cash_paid_out_money")
    public V1Money getCashPaidOutMoney() {
        return this.cashPaidOutMoney;
    }

    /**
     * Getter for ExpectedCashMoney.
     */
    @JsonGetter("expected_cash_money")
    public V1Money getExpectedCashMoney() {
        return this.expectedCashMoney;
    }

    /**
     * Getter for ClosedCashMoney.
     */
    @JsonGetter("closed_cash_money")
    public V1Money getClosedCashMoney() {
        return this.closedCashMoney;
    }

    /**
     * Getter for Device.
     */
    @JsonGetter("device")
    public Device getDevice() {
        return this.device;
    }

    /**
     * Getter for Events.
     * All of the events (payments, refunds, and so on) that involved the cash drawer during the shift.
     */
    @JsonGetter("events")
    public List<V1CashDrawerEvent> getEvents() {
        return this.events;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, eventType, openedAt, endedAt, closedAt, employeeIds,
            openingEmployeeId, endingEmployeeId, closingEmployeeId, description, startingCashMoney,
            cashPaymentMoney, cashRefundsMoney, cashPaidInMoney, cashPaidOutMoney, expectedCashMoney,
            closedCashMoney, device, events);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1CashDrawerShift)) {
            return false;
        }
        V1CashDrawerShift v1CashDrawerShift = (V1CashDrawerShift) obj;
        return Objects.equals(id, v1CashDrawerShift.id) &&
            Objects.equals(eventType, v1CashDrawerShift.eventType) &&
            Objects.equals(openedAt, v1CashDrawerShift.openedAt) &&
            Objects.equals(endedAt, v1CashDrawerShift.endedAt) &&
            Objects.equals(closedAt, v1CashDrawerShift.closedAt) &&
            Objects.equals(employeeIds, v1CashDrawerShift.employeeIds) &&
            Objects.equals(openingEmployeeId, v1CashDrawerShift.openingEmployeeId) &&
            Objects.equals(endingEmployeeId, v1CashDrawerShift.endingEmployeeId) &&
            Objects.equals(closingEmployeeId, v1CashDrawerShift.closingEmployeeId) &&
            Objects.equals(description, v1CashDrawerShift.description) &&
            Objects.equals(startingCashMoney, v1CashDrawerShift.startingCashMoney) &&
            Objects.equals(cashPaymentMoney, v1CashDrawerShift.cashPaymentMoney) &&
            Objects.equals(cashRefundsMoney, v1CashDrawerShift.cashRefundsMoney) &&
            Objects.equals(cashPaidInMoney, v1CashDrawerShift.cashPaidInMoney) &&
            Objects.equals(cashPaidOutMoney, v1CashDrawerShift.cashPaidOutMoney) &&
            Objects.equals(expectedCashMoney, v1CashDrawerShift.expectedCashMoney) &&
            Objects.equals(closedCashMoney, v1CashDrawerShift.closedCashMoney) &&
            Objects.equals(device, v1CashDrawerShift.device) &&
            Objects.equals(events, v1CashDrawerShift.events);
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
     * Class to build instances of {@link V1CashDrawerShift}
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
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for httpContext
         * @param httpContext
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
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
         * Setter for eventType
         * @param eventType
         * @return Builder
         */
        public Builder eventType(String eventType) {
            this.eventType = eventType;
            return this;
        }
        /**
         * Setter for openedAt
         * @param openedAt
         * @return Builder
         */
        public Builder openedAt(String openedAt) {
            this.openedAt = openedAt;
            return this;
        }
        /**
         * Setter for endedAt
         * @param endedAt
         * @return Builder
         */
        public Builder endedAt(String endedAt) {
            this.endedAt = endedAt;
            return this;
        }
        /**
         * Setter for closedAt
         * @param closedAt
         * @return Builder
         */
        public Builder closedAt(String closedAt) {
            this.closedAt = closedAt;
            return this;
        }
        /**
         * Setter for employeeIds
         * @param employeeIds
         * @return Builder
         */
        public Builder employeeIds(List<String> employeeIds) {
            this.employeeIds = employeeIds;
            return this;
        }
        /**
         * Setter for openingEmployeeId
         * @param openingEmployeeId
         * @return Builder
         */
        public Builder openingEmployeeId(String openingEmployeeId) {
            this.openingEmployeeId = openingEmployeeId;
            return this;
        }
        /**
         * Setter for endingEmployeeId
         * @param endingEmployeeId
         * @return Builder
         */
        public Builder endingEmployeeId(String endingEmployeeId) {
            this.endingEmployeeId = endingEmployeeId;
            return this;
        }
        /**
         * Setter for closingEmployeeId
         * @param closingEmployeeId
         * @return Builder
         */
        public Builder closingEmployeeId(String closingEmployeeId) {
            this.closingEmployeeId = closingEmployeeId;
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
         * Setter for startingCashMoney
         * @param startingCashMoney
         * @return Builder
         */
        public Builder startingCashMoney(V1Money startingCashMoney) {
            this.startingCashMoney = startingCashMoney;
            return this;
        }
        /**
         * Setter for cashPaymentMoney
         * @param cashPaymentMoney
         * @return Builder
         */
        public Builder cashPaymentMoney(V1Money cashPaymentMoney) {
            this.cashPaymentMoney = cashPaymentMoney;
            return this;
        }
        /**
         * Setter for cashRefundsMoney
         * @param cashRefundsMoney
         * @return Builder
         */
        public Builder cashRefundsMoney(V1Money cashRefundsMoney) {
            this.cashRefundsMoney = cashRefundsMoney;
            return this;
        }
        /**
         * Setter for cashPaidInMoney
         * @param cashPaidInMoney
         * @return Builder
         */
        public Builder cashPaidInMoney(V1Money cashPaidInMoney) {
            this.cashPaidInMoney = cashPaidInMoney;
            return this;
        }
        /**
         * Setter for cashPaidOutMoney
         * @param cashPaidOutMoney
         * @return Builder
         */
        public Builder cashPaidOutMoney(V1Money cashPaidOutMoney) {
            this.cashPaidOutMoney = cashPaidOutMoney;
            return this;
        }
        /**
         * Setter for expectedCashMoney
         * @param expectedCashMoney
         * @return Builder
         */
        public Builder expectedCashMoney(V1Money expectedCashMoney) {
            this.expectedCashMoney = expectedCashMoney;
            return this;
        }
        /**
         * Setter for closedCashMoney
         * @param closedCashMoney
         * @return Builder
         */
        public Builder closedCashMoney(V1Money closedCashMoney) {
            this.closedCashMoney = closedCashMoney;
            return this;
        }
        /**
         * Setter for device
         * @param device
         * @return Builder
         */
        public Builder device(Device device) {
            this.device = device;
            return this;
        }
        /**
         * Setter for events
         * @param events
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
            V1CashDrawerShift model = new V1CashDrawerShift(id,
                eventType,
                openedAt,
                endedAt,
                closedAt,
                employeeIds,
                openingEmployeeId,
                endingEmployeeId,
                closingEmployeeId,
                description,
                startingCashMoney,
                cashPaymentMoney,
                cashRefundsMoney,
                cashPaidInMoney,
                cashPaidOutMoney,
                expectedCashMoney,
                closedCashMoney,
                device,
                events);
            model.httpContext = httpContext;
            return model;
        }
    }
}
