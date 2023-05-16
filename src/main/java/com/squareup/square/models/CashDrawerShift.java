
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CashDrawerShift type.
 */
public class CashDrawerShift {
    private final String id;
    private final String state;
    private final OptionalNullable<String> openedAt;
    private final OptionalNullable<String> endedAt;
    private final OptionalNullable<String> closedAt;
    private final OptionalNullable<String> description;
    private final Money openedCashMoney;
    private final Money cashPaymentMoney;
    private final Money cashRefundsMoney;
    private final Money cashPaidInMoney;
    private final Money cashPaidOutMoney;
    private final Money expectedCashMoney;
    private final Money closedCashMoney;
    private final CashDrawerDevice device;
    private final String createdAt;
    private final String updatedAt;
    private final String locationId;
    private final List<String> teamMemberIds;
    private final String openingTeamMemberId;
    private final String endingTeamMemberId;
    private final String closingTeamMemberId;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  state  String value for state.
     * @param  openedAt  String value for openedAt.
     * @param  endedAt  String value for endedAt.
     * @param  closedAt  String value for closedAt.
     * @param  description  String value for description.
     * @param  openedCashMoney  Money value for openedCashMoney.
     * @param  cashPaymentMoney  Money value for cashPaymentMoney.
     * @param  cashRefundsMoney  Money value for cashRefundsMoney.
     * @param  cashPaidInMoney  Money value for cashPaidInMoney.
     * @param  cashPaidOutMoney  Money value for cashPaidOutMoney.
     * @param  expectedCashMoney  Money value for expectedCashMoney.
     * @param  closedCashMoney  Money value for closedCashMoney.
     * @param  device  CashDrawerDevice value for device.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  locationId  String value for locationId.
     * @param  teamMemberIds  List of String value for teamMemberIds.
     * @param  openingTeamMemberId  String value for openingTeamMemberId.
     * @param  endingTeamMemberId  String value for endingTeamMemberId.
     * @param  closingTeamMemberId  String value for closingTeamMemberId.
     */
    @JsonCreator
    public CashDrawerShift(
            @JsonProperty("id") String id,
            @JsonProperty("state") String state,
            @JsonProperty("opened_at") String openedAt,
            @JsonProperty("ended_at") String endedAt,
            @JsonProperty("closed_at") String closedAt,
            @JsonProperty("description") String description,
            @JsonProperty("opened_cash_money") Money openedCashMoney,
            @JsonProperty("cash_payment_money") Money cashPaymentMoney,
            @JsonProperty("cash_refunds_money") Money cashRefundsMoney,
            @JsonProperty("cash_paid_in_money") Money cashPaidInMoney,
            @JsonProperty("cash_paid_out_money") Money cashPaidOutMoney,
            @JsonProperty("expected_cash_money") Money expectedCashMoney,
            @JsonProperty("closed_cash_money") Money closedCashMoney,
            @JsonProperty("device") CashDrawerDevice device,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("team_member_ids") List<String> teamMemberIds,
            @JsonProperty("opening_team_member_id") String openingTeamMemberId,
            @JsonProperty("ending_team_member_id") String endingTeamMemberId,
            @JsonProperty("closing_team_member_id") String closingTeamMemberId) {
        this.id = id;
        this.state = state;
        this.openedAt = OptionalNullable.of(openedAt);
        this.endedAt = OptionalNullable.of(endedAt);
        this.closedAt = OptionalNullable.of(closedAt);
        this.description = OptionalNullable.of(description);
        this.openedCashMoney = openedCashMoney;
        this.cashPaymentMoney = cashPaymentMoney;
        this.cashRefundsMoney = cashRefundsMoney;
        this.cashPaidInMoney = cashPaidInMoney;
        this.cashPaidOutMoney = cashPaidOutMoney;
        this.expectedCashMoney = expectedCashMoney;
        this.closedCashMoney = closedCashMoney;
        this.device = device;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.locationId = locationId;
        this.teamMemberIds = teamMemberIds;
        this.openingTeamMemberId = openingTeamMemberId;
        this.endingTeamMemberId = endingTeamMemberId;
        this.closingTeamMemberId = closingTeamMemberId;
    }

    /**
     * Internal initialization constructor.
     */
    protected CashDrawerShift(String id, String state, OptionalNullable<String> openedAt,
            OptionalNullable<String> endedAt, OptionalNullable<String> closedAt,
            OptionalNullable<String> description, Money openedCashMoney, Money cashPaymentMoney,
            Money cashRefundsMoney, Money cashPaidInMoney, Money cashPaidOutMoney,
            Money expectedCashMoney, Money closedCashMoney, CashDrawerDevice device,
            String createdAt, String updatedAt, String locationId, List<String> teamMemberIds,
            String openingTeamMemberId, String endingTeamMemberId, String closingTeamMemberId) {
        this.id = id;
        this.state = state;
        this.openedAt = openedAt;
        this.endedAt = endedAt;
        this.closedAt = closedAt;
        this.description = description;
        this.openedCashMoney = openedCashMoney;
        this.cashPaymentMoney = cashPaymentMoney;
        this.cashRefundsMoney = cashRefundsMoney;
        this.cashPaidInMoney = cashPaidInMoney;
        this.cashPaidOutMoney = cashPaidOutMoney;
        this.expectedCashMoney = expectedCashMoney;
        this.closedCashMoney = closedCashMoney;
        this.device = device;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.locationId = locationId;
        this.teamMemberIds = teamMemberIds;
        this.openingTeamMemberId = openingTeamMemberId;
        this.endingTeamMemberId = endingTeamMemberId;
        this.closingTeamMemberId = closingTeamMemberId;
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
     * The time when the shift began, in ISO 8601 format.
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
     * The time when the shift began, in ISO 8601 format.
     * @return Returns the String
     */
    @JsonIgnore
    public String getOpenedAt() {
        return OptionalNullable.getFrom(openedAt);
    }

    /**
     * Internal Getter for EndedAt.
     * The time when the shift ended, in ISO 8601 format.
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
     * The time when the shift ended, in ISO 8601 format.
     * @return Returns the String
     */
    @JsonIgnore
    public String getEndedAt() {
        return OptionalNullable.getFrom(endedAt);
    }

    /**
     * Internal Getter for ClosedAt.
     * The time when the shift was closed, in ISO 8601 format.
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
     * The time when the shift was closed, in ISO 8601 format.
     * @return Returns the String
     */
    @JsonIgnore
    public String getClosedAt() {
        return OptionalNullable.getFrom(closedAt);
    }

    /**
     * Internal Getter for Description.
     * The free-form text description of a cash drawer by an employee.
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
     * The free-form text description of a cash drawer by an employee.
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

    /**
     * Getter for TeamMemberIds.
     * The IDs of all team members that were logged into Square Point of Sale at any point while the
     * cash drawer shift was open.
     * @return Returns the List of String
     */
    @JsonGetter("team_member_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<String> getTeamMemberIds() {
        return teamMemberIds;
    }

    /**
     * Getter for OpeningTeamMemberId.
     * The ID of the team member that started the cash drawer shift.
     * @return Returns the String
     */
    @JsonGetter("opening_team_member_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getOpeningTeamMemberId() {
        return openingTeamMemberId;
    }

    /**
     * Getter for EndingTeamMemberId.
     * The ID of the team member that ended the cash drawer shift.
     * @return Returns the String
     */
    @JsonGetter("ending_team_member_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getEndingTeamMemberId() {
        return endingTeamMemberId;
    }

    /**
     * Getter for ClosingTeamMemberId.
     * The ID of the team member that closed the cash drawer shift by auditing the cash drawer
     * contents.
     * @return Returns the String
     */
    @JsonGetter("closing_team_member_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getClosingTeamMemberId() {
        return closingTeamMemberId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, state, openedAt, endedAt, closedAt, description, openedCashMoney,
                cashPaymentMoney, cashRefundsMoney, cashPaidInMoney, cashPaidOutMoney,
                expectedCashMoney, closedCashMoney, device, createdAt, updatedAt, locationId,
                teamMemberIds, openingTeamMemberId, endingTeamMemberId, closingTeamMemberId);
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
            && Objects.equals(description, other.description)
            && Objects.equals(openedCashMoney, other.openedCashMoney)
            && Objects.equals(cashPaymentMoney, other.cashPaymentMoney)
            && Objects.equals(cashRefundsMoney, other.cashRefundsMoney)
            && Objects.equals(cashPaidInMoney, other.cashPaidInMoney)
            && Objects.equals(cashPaidOutMoney, other.cashPaidOutMoney)
            && Objects.equals(expectedCashMoney, other.expectedCashMoney)
            && Objects.equals(closedCashMoney, other.closedCashMoney)
            && Objects.equals(device, other.device)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(updatedAt, other.updatedAt)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(teamMemberIds, other.teamMemberIds)
            && Objects.equals(openingTeamMemberId, other.openingTeamMemberId)
            && Objects.equals(endingTeamMemberId, other.endingTeamMemberId)
            && Objects.equals(closingTeamMemberId, other.closingTeamMemberId);
    }

    /**
     * Converts this CashDrawerShift into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CashDrawerShift [" + "id=" + id + ", state=" + state + ", openedAt=" + openedAt
                + ", endedAt=" + endedAt + ", closedAt=" + closedAt + ", description=" + description
                + ", openedCashMoney=" + openedCashMoney + ", cashPaymentMoney=" + cashPaymentMoney
                + ", cashRefundsMoney=" + cashRefundsMoney + ", cashPaidInMoney=" + cashPaidInMoney
                + ", cashPaidOutMoney=" + cashPaidOutMoney + ", expectedCashMoney="
                + expectedCashMoney + ", closedCashMoney=" + closedCashMoney + ", device=" + device
                + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", locationId="
                + locationId + ", teamMemberIds=" + teamMemberIds + ", openingTeamMemberId="
                + openingTeamMemberId + ", endingTeamMemberId=" + endingTeamMemberId
                + ", closingTeamMemberId=" + closingTeamMemberId + "]";
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
                .openedCashMoney(getOpenedCashMoney())
                .cashPaymentMoney(getCashPaymentMoney())
                .cashRefundsMoney(getCashRefundsMoney())
                .cashPaidInMoney(getCashPaidInMoney())
                .cashPaidOutMoney(getCashPaidOutMoney())
                .expectedCashMoney(getExpectedCashMoney())
                .closedCashMoney(getClosedCashMoney())
                .device(getDevice())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt())
                .locationId(getLocationId())
                .teamMemberIds(getTeamMemberIds())
                .openingTeamMemberId(getOpeningTeamMemberId())
                .endingTeamMemberId(getEndingTeamMemberId())
                .closingTeamMemberId(getClosingTeamMemberId());
        builder.openedAt = internalGetOpenedAt();
        builder.endedAt = internalGetEndedAt();
        builder.closedAt = internalGetClosedAt();
        builder.description = internalGetDescription();
        return builder;
    }

    /**
     * Class to build instances of {@link CashDrawerShift}.
     */
    public static class Builder {
        private String id;
        private String state;
        private OptionalNullable<String> openedAt;
        private OptionalNullable<String> endedAt;
        private OptionalNullable<String> closedAt;
        private OptionalNullable<String> description;
        private Money openedCashMoney;
        private Money cashPaymentMoney;
        private Money cashRefundsMoney;
        private Money cashPaidInMoney;
        private Money cashPaidOutMoney;
        private Money expectedCashMoney;
        private Money closedCashMoney;
        private CashDrawerDevice device;
        private String createdAt;
        private String updatedAt;
        private String locationId;
        private List<String> teamMemberIds;
        private String openingTeamMemberId;
        private String endingTeamMemberId;
        private String closingTeamMemberId;



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
         * Setter for teamMemberIds.
         * @param  teamMemberIds  List of String value for teamMemberIds.
         * @return Builder
         */
        public Builder teamMemberIds(List<String> teamMemberIds) {
            this.teamMemberIds = teamMemberIds;
            return this;
        }

        /**
         * Setter for openingTeamMemberId.
         * @param  openingTeamMemberId  String value for openingTeamMemberId.
         * @return Builder
         */
        public Builder openingTeamMemberId(String openingTeamMemberId) {
            this.openingTeamMemberId = openingTeamMemberId;
            return this;
        }

        /**
         * Setter for endingTeamMemberId.
         * @param  endingTeamMemberId  String value for endingTeamMemberId.
         * @return Builder
         */
        public Builder endingTeamMemberId(String endingTeamMemberId) {
            this.endingTeamMemberId = endingTeamMemberId;
            return this;
        }

        /**
         * Setter for closingTeamMemberId.
         * @param  closingTeamMemberId  String value for closingTeamMemberId.
         * @return Builder
         */
        public Builder closingTeamMemberId(String closingTeamMemberId) {
            this.closingTeamMemberId = closingTeamMemberId;
            return this;
        }

        /**
         * Builds a new {@link CashDrawerShift} object using the set fields.
         * @return {@link CashDrawerShift}
         */
        public CashDrawerShift build() {
            return new CashDrawerShift(id, state, openedAt, endedAt, closedAt, description,
                    openedCashMoney, cashPaymentMoney, cashRefundsMoney, cashPaidInMoney,
                    cashPaidOutMoney, expectedCashMoney, closedCashMoney, device, createdAt,
                    updatedAt, locationId, teamMemberIds, openingTeamMemberId, endingTeamMemberId,
                    closingTeamMemberId);
        }
    }
}
