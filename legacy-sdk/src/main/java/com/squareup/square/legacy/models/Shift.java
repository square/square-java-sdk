package com.squareup.square.legacy.models;

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
 * This is a model class for Shift type.
 */
public class Shift {
    private final String id;
    private final OptionalNullable<String> employeeId;
    private final String locationId;
    private final OptionalNullable<String> timezone;
    private final String startAt;
    private final OptionalNullable<String> endAt;
    private final ShiftWage wage;
    private final OptionalNullable<List<Break>> breaks;
    private final String status;
    private final Integer version;
    private final String createdAt;
    private final String updatedAt;
    private final OptionalNullable<String> teamMemberId;
    private final Money declaredCashTipMoney;

    /**
     * Initialization constructor.
     * @param  locationId  String value for locationId.
     * @param  startAt  String value for startAt.
     * @param  id  String value for id.
     * @param  employeeId  String value for employeeId.
     * @param  timezone  String value for timezone.
     * @param  endAt  String value for endAt.
     * @param  wage  ShiftWage value for wage.
     * @param  breaks  List of Break value for breaks.
     * @param  status  String value for status.
     * @param  version  Integer value for version.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  teamMemberId  String value for teamMemberId.
     * @param  declaredCashTipMoney  Money value for declaredCashTipMoney.
     */
    @JsonCreator
    public Shift(
            @JsonProperty("location_id") String locationId,
            @JsonProperty("start_at") String startAt,
            @JsonProperty("id") String id,
            @JsonProperty("employee_id") String employeeId,
            @JsonProperty("timezone") String timezone,
            @JsonProperty("end_at") String endAt,
            @JsonProperty("wage") ShiftWage wage,
            @JsonProperty("breaks") List<Break> breaks,
            @JsonProperty("status") String status,
            @JsonProperty("version") Integer version,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("team_member_id") String teamMemberId,
            @JsonProperty("declared_cash_tip_money") Money declaredCashTipMoney) {
        this.id = id;
        this.employeeId = OptionalNullable.of(employeeId);
        this.locationId = locationId;
        this.timezone = OptionalNullable.of(timezone);
        this.startAt = startAt;
        this.endAt = OptionalNullable.of(endAt);
        this.wage = wage;
        this.breaks = OptionalNullable.of(breaks);
        this.status = status;
        this.version = version;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.teamMemberId = OptionalNullable.of(teamMemberId);
        this.declaredCashTipMoney = declaredCashTipMoney;
    }

    /**
     * Initialization constructor.
     * @param  locationId  String value for locationId.
     * @param  startAt  String value for startAt.
     * @param  id  String value for id.
     * @param  employeeId  String value for employeeId.
     * @param  timezone  String value for timezone.
     * @param  endAt  String value for endAt.
     * @param  wage  ShiftWage value for wage.
     * @param  breaks  List of Break value for breaks.
     * @param  status  String value for status.
     * @param  version  Integer value for version.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  teamMemberId  String value for teamMemberId.
     * @param  declaredCashTipMoney  Money value for declaredCashTipMoney.
     */
    protected Shift(
            String locationId,
            String startAt,
            String id,
            OptionalNullable<String> employeeId,
            OptionalNullable<String> timezone,
            OptionalNullable<String> endAt,
            ShiftWage wage,
            OptionalNullable<List<Break>> breaks,
            String status,
            Integer version,
            String createdAt,
            String updatedAt,
            OptionalNullable<String> teamMemberId,
            Money declaredCashTipMoney) {
        this.id = id;
        this.employeeId = employeeId;
        this.locationId = locationId;
        this.timezone = timezone;
        this.startAt = startAt;
        this.endAt = endAt;
        this.wage = wage;
        this.breaks = breaks;
        this.status = status;
        this.version = version;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.teamMemberId = teamMemberId;
        this.declaredCashTipMoney = declaredCashTipMoney;
    }

    /**
     * Getter for Id.
     * The UUID for this object.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Internal Getter for EmployeeId.
     * The ID of the employee this shift belongs to. DEPRECATED at version 2020-08-26. Use
     * `team_member_id` instead.
     * @return Returns the Internal String
     */
    @JsonGetter("employee_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetEmployeeId() {
        return this.employeeId;
    }

    /**
     * Getter for EmployeeId.
     * The ID of the employee this shift belongs to. DEPRECATED at version 2020-08-26. Use
     * `team_member_id` instead.
     * @return Returns the String
     */
    @JsonIgnore
    public String getEmployeeId() {
        return OptionalNullable.getFrom(employeeId);
    }

    /**
     * Getter for LocationId.
     * The ID of the location this shift occurred at. The location should be based on where the
     * employee clocked in.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return locationId;
    }

    /**
     * Internal Getter for Timezone.
     * The read-only convenience value that is calculated from the location based on the
     * `location_id`. Format: the IANA timezone database identifier for the location timezone.
     * @return Returns the Internal String
     */
    @JsonGetter("timezone")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetTimezone() {
        return this.timezone;
    }

    /**
     * Getter for Timezone.
     * The read-only convenience value that is calculated from the location based on the
     * `location_id`. Format: the IANA timezone database identifier for the location timezone.
     * @return Returns the String
     */
    @JsonIgnore
    public String getTimezone() {
        return OptionalNullable.getFrom(timezone);
    }

    /**
     * Getter for StartAt.
     * RFC 3339; shifted to the location timezone + offset. Precision up to the minute is respected;
     * seconds are truncated.
     * @return Returns the String
     */
    @JsonGetter("start_at")
    public String getStartAt() {
        return startAt;
    }

    /**
     * Internal Getter for EndAt.
     * RFC 3339; shifted to the timezone + offset. Precision up to the minute is respected; seconds
     * are truncated.
     * @return Returns the Internal String
     */
    @JsonGetter("end_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetEndAt() {
        return this.endAt;
    }

    /**
     * Getter for EndAt.
     * RFC 3339; shifted to the timezone + offset. Precision up to the minute is respected; seconds
     * are truncated.
     * @return Returns the String
     */
    @JsonIgnore
    public String getEndAt() {
        return OptionalNullable.getFrom(endAt);
    }

    /**
     * Getter for Wage.
     * The hourly wage rate used to compensate an employee for this shift.
     * @return Returns the ShiftWage
     */
    @JsonGetter("wage")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ShiftWage getWage() {
        return wage;
    }

    /**
     * Internal Getter for Breaks.
     * A list of all the paid or unpaid breaks that were taken during this shift.
     * @return Returns the Internal List of Break
     */
    @JsonGetter("breaks")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<Break>> internalGetBreaks() {
        return this.breaks;
    }

    /**
     * Getter for Breaks.
     * A list of all the paid or unpaid breaks that were taken during this shift.
     * @return Returns the List of Break
     */
    @JsonIgnore
    public List<Break> getBreaks() {
        return OptionalNullable.getFrom(breaks);
    }

    /**
     * Getter for Status.
     * Enumerates the possible status of a `Shift`.
     * @return Returns the String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStatus() {
        return status;
    }

    /**
     * Getter for Version.
     * Used for resolving concurrency issues. The request fails if the version provided does not
     * match the server version at the time of the request. If not provided, Square executes a blind
     * write; potentially overwriting data from another write.
     * @return Returns the Integer
     */
    @JsonGetter("version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getVersion() {
        return version;
    }

    /**
     * Getter for CreatedAt.
     * A read-only timestamp in RFC 3339 format; presented in UTC.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * A read-only timestamp in RFC 3339 format; presented in UTC.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Internal Getter for TeamMemberId.
     * The ID of the team member this shift belongs to. Replaced `employee_id` at version
     * "2020-08-26".
     * @return Returns the Internal String
     */
    @JsonGetter("team_member_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetTeamMemberId() {
        return this.teamMemberId;
    }

    /**
     * Getter for TeamMemberId.
     * The ID of the team member this shift belongs to. Replaced `employee_id` at version
     * "2020-08-26".
     * @return Returns the String
     */
    @JsonIgnore
    public String getTeamMemberId() {
        return OptionalNullable.getFrom(teamMemberId);
    }

    /**
     * Getter for DeclaredCashTipMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("declared_cash_tip_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getDeclaredCashTipMoney() {
        return declaredCashTipMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                employeeId,
                locationId,
                timezone,
                startAt,
                endAt,
                wage,
                breaks,
                status,
                version,
                createdAt,
                updatedAt,
                teamMemberId,
                declaredCashTipMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Shift)) {
            return false;
        }
        Shift other = (Shift) obj;
        return Objects.equals(id, other.id)
                && Objects.equals(employeeId, other.employeeId)
                && Objects.equals(locationId, other.locationId)
                && Objects.equals(timezone, other.timezone)
                && Objects.equals(startAt, other.startAt)
                && Objects.equals(endAt, other.endAt)
                && Objects.equals(wage, other.wage)
                && Objects.equals(breaks, other.breaks)
                && Objects.equals(status, other.status)
                && Objects.equals(version, other.version)
                && Objects.equals(createdAt, other.createdAt)
                && Objects.equals(updatedAt, other.updatedAt)
                && Objects.equals(teamMemberId, other.teamMemberId)
                && Objects.equals(declaredCashTipMoney, other.declaredCashTipMoney);
    }

    /**
     * Converts this Shift into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Shift [" + "locationId=" + locationId + ", startAt=" + startAt + ", id=" + id
                + ", employeeId=" + employeeId + ", timezone=" + timezone + ", endAt=" + endAt
                + ", wage=" + wage + ", breaks=" + breaks + ", status=" + status + ", version="
                + version + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
                + ", teamMemberId=" + teamMemberId + ", declaredCashTipMoney="
                + declaredCashTipMoney + "]";
    }

    /**
     * Builds a new {@link Shift.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Shift.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(locationId, startAt)
                .id(getId())
                .wage(getWage())
                .status(getStatus())
                .version(getVersion())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt())
                .declaredCashTipMoney(getDeclaredCashTipMoney());
        builder.employeeId = internalGetEmployeeId();
        builder.timezone = internalGetTimezone();
        builder.endAt = internalGetEndAt();
        builder.breaks = internalGetBreaks();
        builder.teamMemberId = internalGetTeamMemberId();
        return builder;
    }

    /**
     * Class to build instances of {@link Shift}.
     */
    public static class Builder {
        private String locationId;
        private String startAt;
        private String id;
        private OptionalNullable<String> employeeId;
        private OptionalNullable<String> timezone;
        private OptionalNullable<String> endAt;
        private ShiftWage wage;
        private OptionalNullable<List<Break>> breaks;
        private String status;
        private Integer version;
        private String createdAt;
        private String updatedAt;
        private OptionalNullable<String> teamMemberId;
        private Money declaredCashTipMoney;

        /**
         * Initialization constructor.
         * @param  locationId  String value for locationId.
         * @param  startAt  String value for startAt.
         */
        public Builder(String locationId, String startAt) {
            this.locationId = locationId;
            this.startAt = startAt;
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
         * Setter for startAt.
         * @param  startAt  String value for startAt.
         * @return Builder
         */
        public Builder startAt(String startAt) {
            this.startAt = startAt;
            return this;
        }

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
         * Setter for employeeId.
         * @param  employeeId  String value for employeeId.
         * @return Builder
         */
        public Builder employeeId(String employeeId) {
            this.employeeId = OptionalNullable.of(employeeId);
            return this;
        }

        /**
         * UnSetter for employeeId.
         * @return Builder
         */
        public Builder unsetEmployeeId() {
            employeeId = null;
            return this;
        }

        /**
         * Setter for timezone.
         * @param  timezone  String value for timezone.
         * @return Builder
         */
        public Builder timezone(String timezone) {
            this.timezone = OptionalNullable.of(timezone);
            return this;
        }

        /**
         * UnSetter for timezone.
         * @return Builder
         */
        public Builder unsetTimezone() {
            timezone = null;
            return this;
        }

        /**
         * Setter for endAt.
         * @param  endAt  String value for endAt.
         * @return Builder
         */
        public Builder endAt(String endAt) {
            this.endAt = OptionalNullable.of(endAt);
            return this;
        }

        /**
         * UnSetter for endAt.
         * @return Builder
         */
        public Builder unsetEndAt() {
            endAt = null;
            return this;
        }

        /**
         * Setter for wage.
         * @param  wage  ShiftWage value for wage.
         * @return Builder
         */
        public Builder wage(ShiftWage wage) {
            this.wage = wage;
            return this;
        }

        /**
         * Setter for breaks.
         * @param  breaks  List of Break value for breaks.
         * @return Builder
         */
        public Builder breaks(List<Break> breaks) {
            this.breaks = OptionalNullable.of(breaks);
            return this;
        }

        /**
         * UnSetter for breaks.
         * @return Builder
         */
        public Builder unsetBreaks() {
            breaks = null;
            return this;
        }

        /**
         * Setter for status.
         * @param  status  String value for status.
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Setter for version.
         * @param  version  Integer value for version.
         * @return Builder
         */
        public Builder version(Integer version) {
            this.version = version;
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
         * Setter for teamMemberId.
         * @param  teamMemberId  String value for teamMemberId.
         * @return Builder
         */
        public Builder teamMemberId(String teamMemberId) {
            this.teamMemberId = OptionalNullable.of(teamMemberId);
            return this;
        }

        /**
         * UnSetter for teamMemberId.
         * @return Builder
         */
        public Builder unsetTeamMemberId() {
            teamMemberId = null;
            return this;
        }

        /**
         * Setter for declaredCashTipMoney.
         * @param  declaredCashTipMoney  Money value for declaredCashTipMoney.
         * @return Builder
         */
        public Builder declaredCashTipMoney(Money declaredCashTipMoney) {
            this.declaredCashTipMoney = declaredCashTipMoney;
            return this;
        }

        /**
         * Builds a new {@link Shift} object using the set fields.
         * @return {@link Shift}
         */
        public Shift build() {
            return new Shift(
                    locationId,
                    startAt,
                    id,
                    employeeId,
                    timezone,
                    endAt,
                    wage,
                    breaks,
                    status,
                    version,
                    createdAt,
                    updatedAt,
                    teamMemberId,
                    declaredCashTipMoney);
        }
    }
}
