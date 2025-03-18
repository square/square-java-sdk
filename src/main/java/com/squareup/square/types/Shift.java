/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.Nullable;
import com.squareup.square.core.NullableNonemptyFilter;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = Shift.Builder.class)
public final class Shift {
    private final Optional<String> id;

    private final Optional<String> employeeId;

    private final String locationId;

    private final Optional<String> timezone;

    private final String startAt;

    private final Optional<String> endAt;

    private final Optional<ShiftWage> wage;

    private final Optional<List<Break>> breaks;

    private final Optional<ShiftStatus> status;

    private final Optional<Integer> version;

    private final Optional<String> createdAt;

    private final Optional<String> updatedAt;

    private final Optional<String> teamMemberId;

    private final Optional<Money> declaredCashTipMoney;

    private final Map<String, Object> additionalProperties;

    private Shift(
            Optional<String> id,
            Optional<String> employeeId,
            String locationId,
            Optional<String> timezone,
            String startAt,
            Optional<String> endAt,
            Optional<ShiftWage> wage,
            Optional<List<Break>> breaks,
            Optional<ShiftStatus> status,
            Optional<Integer> version,
            Optional<String> createdAt,
            Optional<String> updatedAt,
            Optional<String> teamMemberId,
            Optional<Money> declaredCashTipMoney,
            Map<String, Object> additionalProperties) {
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
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The UUID for this object.
     */
    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    /**
     * @return The ID of the employee this shift belongs to. DEPRECATED at version 2020-08-26. Use <code>team_member_id</code> instead.
     */
    @JsonIgnore
    public Optional<String> getEmployeeId() {
        if (employeeId == null) {
            return Optional.empty();
        }
        return employeeId;
    }

    /**
     * @return The ID of the location this shift occurred at. The location should be based on
     * where the employee clocked in.
     */
    @JsonProperty("location_id")
    public String getLocationId() {
        return locationId;
    }

    /**
     * @return The read-only convenience value that is calculated from the location based
     * on the <code>location_id</code>. Format: the IANA timezone database identifier for the
     * location timezone.
     */
    @JsonIgnore
    public Optional<String> getTimezone() {
        if (timezone == null) {
            return Optional.empty();
        }
        return timezone;
    }

    /**
     * @return RFC 3339; shifted to the location timezone + offset. Precision up to the
     * minute is respected; seconds are truncated.
     */
    @JsonProperty("start_at")
    public String getStartAt() {
        return startAt;
    }

    /**
     * @return RFC 3339; shifted to the timezone + offset. Precision up to the minute is
     * respected; seconds are truncated.
     */
    @JsonIgnore
    public Optional<String> getEndAt() {
        if (endAt == null) {
            return Optional.empty();
        }
        return endAt;
    }

    /**
     * @return Job and pay related information. If the wage is not set on create, it defaults to a wage
     * of zero. If the title is not set on create, it defaults to the name of the role the employee
     * is assigned to, if any.
     */
    @JsonProperty("wage")
    public Optional<ShiftWage> getWage() {
        return wage;
    }

    /**
     * @return A list of all the paid or unpaid breaks that were taken during this shift.
     */
    @JsonIgnore
    public Optional<List<Break>> getBreaks() {
        if (breaks == null) {
            return Optional.empty();
        }
        return breaks;
    }

    /**
     * @return Describes the working state of the current <code>Shift</code>.
     * See <a href="#type-shiftstatus">ShiftStatus</a> for possible values
     */
    @JsonProperty("status")
    public Optional<ShiftStatus> getStatus() {
        return status;
    }

    /**
     * @return Used for resolving concurrency issues. The request fails if the version
     * provided does not match the server version at the time of the request. If not provided,
     * Square executes a blind write; potentially overwriting data from another
     * write.
     */
    @JsonProperty("version")
    public Optional<Integer> getVersion() {
        return version;
    }

    /**
     * @return A read-only timestamp in RFC 3339 format; presented in UTC.
     */
    @JsonProperty("created_at")
    public Optional<String> getCreatedAt() {
        return createdAt;
    }

    /**
     * @return A read-only timestamp in RFC 3339 format; presented in UTC.
     */
    @JsonProperty("updated_at")
    public Optional<String> getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @return The ID of the team member this shift belongs to. Replaced <code>employee_id</code> at version &quot;2020-08-26&quot;.
     */
    @JsonIgnore
    public Optional<String> getTeamMemberId() {
        if (teamMemberId == null) {
            return Optional.empty();
        }
        return teamMemberId;
    }

    /**
     * @return The tips declared by the team member for the shift.
     */
    @JsonProperty("declared_cash_tip_money")
    public Optional<Money> getDeclaredCashTipMoney() {
        return declaredCashTipMoney;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("employee_id")
    private Optional<String> _getEmployeeId() {
        return employeeId;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("timezone")
    private Optional<String> _getTimezone() {
        return timezone;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("end_at")
    private Optional<String> _getEndAt() {
        return endAt;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("breaks")
    private Optional<List<Break>> _getBreaks() {
        return breaks;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("team_member_id")
    private Optional<String> _getTeamMemberId() {
        return teamMemberId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Shift && equalTo((Shift) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(Shift other) {
        return id.equals(other.id)
                && employeeId.equals(other.employeeId)
                && locationId.equals(other.locationId)
                && timezone.equals(other.timezone)
                && startAt.equals(other.startAt)
                && endAt.equals(other.endAt)
                && wage.equals(other.wage)
                && breaks.equals(other.breaks)
                && status.equals(other.status)
                && version.equals(other.version)
                && createdAt.equals(other.createdAt)
                && updatedAt.equals(other.updatedAt)
                && teamMemberId.equals(other.teamMemberId)
                && declaredCashTipMoney.equals(other.declaredCashTipMoney);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.employeeId,
                this.locationId,
                this.timezone,
                this.startAt,
                this.endAt,
                this.wage,
                this.breaks,
                this.status,
                this.version,
                this.createdAt,
                this.updatedAt,
                this.teamMemberId,
                this.declaredCashTipMoney);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static LocationIdStage builder() {
        return new Builder();
    }

    public interface LocationIdStage {
        StartAtStage locationId(@NotNull String locationId);

        Builder from(Shift other);
    }

    public interface StartAtStage {
        _FinalStage startAt(@NotNull String startAt);
    }

    public interface _FinalStage {
        Shift build();

        _FinalStage id(Optional<String> id);

        _FinalStage id(String id);

        _FinalStage employeeId(Optional<String> employeeId);

        _FinalStage employeeId(String employeeId);

        _FinalStage employeeId(Nullable<String> employeeId);

        _FinalStage timezone(Optional<String> timezone);

        _FinalStage timezone(String timezone);

        _FinalStage timezone(Nullable<String> timezone);

        _FinalStage endAt(Optional<String> endAt);

        _FinalStage endAt(String endAt);

        _FinalStage endAt(Nullable<String> endAt);

        _FinalStage wage(Optional<ShiftWage> wage);

        _FinalStage wage(ShiftWage wage);

        _FinalStage breaks(Optional<List<Break>> breaks);

        _FinalStage breaks(List<Break> breaks);

        _FinalStage breaks(Nullable<List<Break>> breaks);

        _FinalStage status(Optional<ShiftStatus> status);

        _FinalStage status(ShiftStatus status);

        _FinalStage version(Optional<Integer> version);

        _FinalStage version(Integer version);

        _FinalStage createdAt(Optional<String> createdAt);

        _FinalStage createdAt(String createdAt);

        _FinalStage updatedAt(Optional<String> updatedAt);

        _FinalStage updatedAt(String updatedAt);

        _FinalStage teamMemberId(Optional<String> teamMemberId);

        _FinalStage teamMemberId(String teamMemberId);

        _FinalStage teamMemberId(Nullable<String> teamMemberId);

        _FinalStage declaredCashTipMoney(Optional<Money> declaredCashTipMoney);

        _FinalStage declaredCashTipMoney(Money declaredCashTipMoney);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements LocationIdStage, StartAtStage, _FinalStage {
        private String locationId;

        private String startAt;

        private Optional<Money> declaredCashTipMoney = Optional.empty();

        private Optional<String> teamMemberId = Optional.empty();

        private Optional<String> updatedAt = Optional.empty();

        private Optional<String> createdAt = Optional.empty();

        private Optional<Integer> version = Optional.empty();

        private Optional<ShiftStatus> status = Optional.empty();

        private Optional<List<Break>> breaks = Optional.empty();

        private Optional<ShiftWage> wage = Optional.empty();

        private Optional<String> endAt = Optional.empty();

        private Optional<String> timezone = Optional.empty();

        private Optional<String> employeeId = Optional.empty();

        private Optional<String> id = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(Shift other) {
            id(other.getId());
            employeeId(other.getEmployeeId());
            locationId(other.getLocationId());
            timezone(other.getTimezone());
            startAt(other.getStartAt());
            endAt(other.getEndAt());
            wage(other.getWage());
            breaks(other.getBreaks());
            status(other.getStatus());
            version(other.getVersion());
            createdAt(other.getCreatedAt());
            updatedAt(other.getUpdatedAt());
            teamMemberId(other.getTeamMemberId());
            declaredCashTipMoney(other.getDeclaredCashTipMoney());
            return this;
        }

        /**
         * <p>The ID of the location this shift occurred at. The location should be based on
         * where the employee clocked in.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("location_id")
        public StartAtStage locationId(@NotNull String locationId) {
            this.locationId = Objects.requireNonNull(locationId, "locationId must not be null");
            return this;
        }

        /**
         * <p>RFC 3339; shifted to the location timezone + offset. Precision up to the
         * minute is respected; seconds are truncated.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("start_at")
        public _FinalStage startAt(@NotNull String startAt) {
            this.startAt = Objects.requireNonNull(startAt, "startAt must not be null");
            return this;
        }

        /**
         * <p>The tips declared by the team member for the shift.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage declaredCashTipMoney(Money declaredCashTipMoney) {
            this.declaredCashTipMoney = Optional.ofNullable(declaredCashTipMoney);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "declared_cash_tip_money", nulls = Nulls.SKIP)
        public _FinalStage declaredCashTipMoney(Optional<Money> declaredCashTipMoney) {
            this.declaredCashTipMoney = declaredCashTipMoney;
            return this;
        }

        /**
         * <p>The ID of the team member this shift belongs to. Replaced <code>employee_id</code> at version &quot;2020-08-26&quot;.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage teamMemberId(Nullable<String> teamMemberId) {
            if (teamMemberId.isNull()) {
                this.teamMemberId = null;
            } else if (teamMemberId.isEmpty()) {
                this.teamMemberId = Optional.empty();
            } else {
                this.teamMemberId = Optional.of(teamMemberId.get());
            }
            return this;
        }

        /**
         * <p>The ID of the team member this shift belongs to. Replaced <code>employee_id</code> at version &quot;2020-08-26&quot;.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage teamMemberId(String teamMemberId) {
            this.teamMemberId = Optional.ofNullable(teamMemberId);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "team_member_id", nulls = Nulls.SKIP)
        public _FinalStage teamMemberId(Optional<String> teamMemberId) {
            this.teamMemberId = teamMemberId;
            return this;
        }

        /**
         * <p>A read-only timestamp in RFC 3339 format; presented in UTC.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage updatedAt(String updatedAt) {
            this.updatedAt = Optional.ofNullable(updatedAt);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "updated_at", nulls = Nulls.SKIP)
        public _FinalStage updatedAt(Optional<String> updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * <p>A read-only timestamp in RFC 3339 format; presented in UTC.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage createdAt(String createdAt) {
            this.createdAt = Optional.ofNullable(createdAt);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "created_at", nulls = Nulls.SKIP)
        public _FinalStage createdAt(Optional<String> createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * <p>Used for resolving concurrency issues. The request fails if the version
         * provided does not match the server version at the time of the request. If not provided,
         * Square executes a blind write; potentially overwriting data from another
         * write.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage version(Integer version) {
            this.version = Optional.ofNullable(version);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "version", nulls = Nulls.SKIP)
        public _FinalStage version(Optional<Integer> version) {
            this.version = version;
            return this;
        }

        /**
         * <p>Describes the working state of the current <code>Shift</code>.
         * See <a href="#type-shiftstatus">ShiftStatus</a> for possible values</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage status(ShiftStatus status) {
            this.status = Optional.ofNullable(status);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public _FinalStage status(Optional<ShiftStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * <p>A list of all the paid or unpaid breaks that were taken during this shift.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage breaks(Nullable<List<Break>> breaks) {
            if (breaks.isNull()) {
                this.breaks = null;
            } else if (breaks.isEmpty()) {
                this.breaks = Optional.empty();
            } else {
                this.breaks = Optional.of(breaks.get());
            }
            return this;
        }

        /**
         * <p>A list of all the paid or unpaid breaks that were taken during this shift.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage breaks(List<Break> breaks) {
            this.breaks = Optional.ofNullable(breaks);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "breaks", nulls = Nulls.SKIP)
        public _FinalStage breaks(Optional<List<Break>> breaks) {
            this.breaks = breaks;
            return this;
        }

        /**
         * <p>Job and pay related information. If the wage is not set on create, it defaults to a wage
         * of zero. If the title is not set on create, it defaults to the name of the role the employee
         * is assigned to, if any.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage wage(ShiftWage wage) {
            this.wage = Optional.ofNullable(wage);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "wage", nulls = Nulls.SKIP)
        public _FinalStage wage(Optional<ShiftWage> wage) {
            this.wage = wage;
            return this;
        }

        /**
         * <p>RFC 3339; shifted to the timezone + offset. Precision up to the minute is
         * respected; seconds are truncated.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage endAt(Nullable<String> endAt) {
            if (endAt.isNull()) {
                this.endAt = null;
            } else if (endAt.isEmpty()) {
                this.endAt = Optional.empty();
            } else {
                this.endAt = Optional.of(endAt.get());
            }
            return this;
        }

        /**
         * <p>RFC 3339; shifted to the timezone + offset. Precision up to the minute is
         * respected; seconds are truncated.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage endAt(String endAt) {
            this.endAt = Optional.ofNullable(endAt);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "end_at", nulls = Nulls.SKIP)
        public _FinalStage endAt(Optional<String> endAt) {
            this.endAt = endAt;
            return this;
        }

        /**
         * <p>The read-only convenience value that is calculated from the location based
         * on the <code>location_id</code>. Format: the IANA timezone database identifier for the
         * location timezone.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage timezone(Nullable<String> timezone) {
            if (timezone.isNull()) {
                this.timezone = null;
            } else if (timezone.isEmpty()) {
                this.timezone = Optional.empty();
            } else {
                this.timezone = Optional.of(timezone.get());
            }
            return this;
        }

        /**
         * <p>The read-only convenience value that is calculated from the location based
         * on the <code>location_id</code>. Format: the IANA timezone database identifier for the
         * location timezone.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage timezone(String timezone) {
            this.timezone = Optional.ofNullable(timezone);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "timezone", nulls = Nulls.SKIP)
        public _FinalStage timezone(Optional<String> timezone) {
            this.timezone = timezone;
            return this;
        }

        /**
         * <p>The ID of the employee this shift belongs to. DEPRECATED at version 2020-08-26. Use <code>team_member_id</code> instead.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage employeeId(Nullable<String> employeeId) {
            if (employeeId.isNull()) {
                this.employeeId = null;
            } else if (employeeId.isEmpty()) {
                this.employeeId = Optional.empty();
            } else {
                this.employeeId = Optional.of(employeeId.get());
            }
            return this;
        }

        /**
         * <p>The ID of the employee this shift belongs to. DEPRECATED at version 2020-08-26. Use <code>team_member_id</code> instead.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage employeeId(String employeeId) {
            this.employeeId = Optional.ofNullable(employeeId);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "employee_id", nulls = Nulls.SKIP)
        public _FinalStage employeeId(Optional<String> employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        /**
         * <p>The UUID for this object.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage id(String id) {
            this.id = Optional.ofNullable(id);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public _FinalStage id(Optional<String> id) {
            this.id = id;
            return this;
        }

        @java.lang.Override
        public Shift build() {
            return new Shift(
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
                    declaredCashTipMoney,
                    additionalProperties);
        }
    }
}
