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
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = TeamMemberWageSettingUpdatedEventData.Builder.class)
public final class TeamMemberWageSettingUpdatedEventData {
    private final Optional<String> type;

    private final Optional<String> id;

    private final Optional<TeamMemberWageSettingUpdatedEventObject> object;

    private final Map<String, Object> additionalProperties;

    private TeamMemberWageSettingUpdatedEventData(
            Optional<String> type,
            Optional<String> id,
            Optional<TeamMemberWageSettingUpdatedEventObject> object,
            Map<String, Object> additionalProperties) {
        this.type = type;
        this.id = id;
        this.object = object;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Name of the affected object’s type, <code>&quot;wage_setting&quot;</code>.
     */
    @JsonIgnore
    public Optional<String> getType() {
        if (type == null) {
            return Optional.empty();
        }
        return type;
    }

    /**
     * @return ID of the updated team member wage setting.
     */
    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    /**
     * @return An object containing the updated team member wage setting.
     */
    @JsonProperty("object")
    public Optional<TeamMemberWageSettingUpdatedEventObject> getObject() {
        return object;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("type")
    private Optional<String> _getType() {
        return type;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TeamMemberWageSettingUpdatedEventData
                && equalTo((TeamMemberWageSettingUpdatedEventData) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(TeamMemberWageSettingUpdatedEventData other) {
        return type.equals(other.type) && id.equals(other.id) && object.equals(other.object);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.type, this.id, this.object);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> type = Optional.empty();

        private Optional<String> id = Optional.empty();

        private Optional<TeamMemberWageSettingUpdatedEventObject> object = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(TeamMemberWageSettingUpdatedEventData other) {
            type(other.getType());
            id(other.getId());
            object(other.getObject());
            return this;
        }

        /**
         * <p>Name of the affected object’s type, <code>&quot;wage_setting&quot;</code>.</p>
         */
        @JsonSetter(value = "type", nulls = Nulls.SKIP)
        public Builder type(Optional<String> type) {
            this.type = type;
            return this;
        }

        public Builder type(String type) {
            this.type = Optional.ofNullable(type);
            return this;
        }

        public Builder type(Nullable<String> type) {
            if (type.isNull()) {
                this.type = null;
            } else if (type.isEmpty()) {
                this.type = Optional.empty();
            } else {
                this.type = Optional.of(type.get());
            }
            return this;
        }

        /**
         * <p>ID of the updated team member wage setting.</p>
         */
        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.ofNullable(id);
            return this;
        }

        /**
         * <p>An object containing the updated team member wage setting.</p>
         */
        @JsonSetter(value = "object", nulls = Nulls.SKIP)
        public Builder object(Optional<TeamMemberWageSettingUpdatedEventObject> object) {
            this.object = object;
            return this;
        }

        public Builder object(TeamMemberWageSettingUpdatedEventObject object) {
            this.object = Optional.ofNullable(object);
            return this;
        }

        public TeamMemberWageSettingUpdatedEventData build() {
            return new TeamMemberWageSettingUpdatedEventData(type, id, object, additionalProperties);
        }
    }
}
