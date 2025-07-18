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
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CatalogModifierOverride.Builder.class)
public final class CatalogModifierOverride {
    private final String modifierId;

    private final Optional<Boolean> onByDefault;

    private final Optional<Object> hiddenOnlineOverride;

    private final Optional<Object> onByDefaultOverride;

    private final Map<String, Object> additionalProperties;

    private CatalogModifierOverride(
            String modifierId,
            Optional<Boolean> onByDefault,
            Optional<Object> hiddenOnlineOverride,
            Optional<Object> onByDefaultOverride,
            Map<String, Object> additionalProperties) {
        this.modifierId = modifierId;
        this.onByDefault = onByDefault;
        this.hiddenOnlineOverride = hiddenOnlineOverride;
        this.onByDefaultOverride = onByDefaultOverride;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The ID of the <code>CatalogModifier</code> whose default behavior is being overridden.
     */
    @JsonProperty("modifier_id")
    public String getModifierId() {
        return modifierId;
    }

    /**
     * @return <strong>Deprecated</strong>: Use <code>on_by_default_override</code> instead.
     */
    @JsonIgnore
    public Optional<Boolean> getOnByDefault() {
        if (onByDefault == null) {
            return Optional.empty();
        }
        return onByDefault;
    }

    @JsonProperty("hidden_online_override")
    public Optional<Object> getHiddenOnlineOverride() {
        return hiddenOnlineOverride;
    }

    @JsonProperty("on_by_default_override")
    public Optional<Object> getOnByDefaultOverride() {
        return onByDefaultOverride;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("on_by_default")
    private Optional<Boolean> _getOnByDefault() {
        return onByDefault;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CatalogModifierOverride && equalTo((CatalogModifierOverride) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CatalogModifierOverride other) {
        return modifierId.equals(other.modifierId)
                && onByDefault.equals(other.onByDefault)
                && hiddenOnlineOverride.equals(other.hiddenOnlineOverride)
                && onByDefaultOverride.equals(other.onByDefaultOverride);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.modifierId, this.onByDefault, this.hiddenOnlineOverride, this.onByDefaultOverride);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ModifierIdStage builder() {
        return new Builder();
    }

    public interface ModifierIdStage {
        /**
         * <p>The ID of the <code>CatalogModifier</code> whose default behavior is being overridden.</p>
         */
        _FinalStage modifierId(@NotNull String modifierId);

        Builder from(CatalogModifierOverride other);
    }

    public interface _FinalStage {
        CatalogModifierOverride build();

        /**
         * <p><strong>Deprecated</strong>: Use <code>on_by_default_override</code> instead.</p>
         */
        _FinalStage onByDefault(Optional<Boolean> onByDefault);

        _FinalStage onByDefault(Boolean onByDefault);

        _FinalStage onByDefault(Nullable<Boolean> onByDefault);

        _FinalStage hiddenOnlineOverride(Optional<Object> hiddenOnlineOverride);

        _FinalStage hiddenOnlineOverride(Object hiddenOnlineOverride);

        _FinalStage onByDefaultOverride(Optional<Object> onByDefaultOverride);

        _FinalStage onByDefaultOverride(Object onByDefaultOverride);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ModifierIdStage, _FinalStage {
        private String modifierId;

        private Optional<Object> onByDefaultOverride = Optional.empty();

        private Optional<Object> hiddenOnlineOverride = Optional.empty();

        private Optional<Boolean> onByDefault = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(CatalogModifierOverride other) {
            modifierId(other.getModifierId());
            onByDefault(other.getOnByDefault());
            hiddenOnlineOverride(other.getHiddenOnlineOverride());
            onByDefaultOverride(other.getOnByDefaultOverride());
            return this;
        }

        /**
         * <p>The ID of the <code>CatalogModifier</code> whose default behavior is being overridden.</p>
         * <p>The ID of the <code>CatalogModifier</code> whose default behavior is being overridden.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("modifier_id")
        public _FinalStage modifierId(@NotNull String modifierId) {
            this.modifierId = Objects.requireNonNull(modifierId, "modifierId must not be null");
            return this;
        }

        @java.lang.Override
        public _FinalStage onByDefaultOverride(Object onByDefaultOverride) {
            this.onByDefaultOverride = Optional.ofNullable(onByDefaultOverride);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "on_by_default_override", nulls = Nulls.SKIP)
        public _FinalStage onByDefaultOverride(Optional<Object> onByDefaultOverride) {
            this.onByDefaultOverride = onByDefaultOverride;
            return this;
        }

        @java.lang.Override
        public _FinalStage hiddenOnlineOverride(Object hiddenOnlineOverride) {
            this.hiddenOnlineOverride = Optional.ofNullable(hiddenOnlineOverride);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "hidden_online_override", nulls = Nulls.SKIP)
        public _FinalStage hiddenOnlineOverride(Optional<Object> hiddenOnlineOverride) {
            this.hiddenOnlineOverride = hiddenOnlineOverride;
            return this;
        }

        /**
         * <p><strong>Deprecated</strong>: Use <code>on_by_default_override</code> instead.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage onByDefault(Nullable<Boolean> onByDefault) {
            if (onByDefault.isNull()) {
                this.onByDefault = null;
            } else if (onByDefault.isEmpty()) {
                this.onByDefault = Optional.empty();
            } else {
                this.onByDefault = Optional.of(onByDefault.get());
            }
            return this;
        }

        /**
         * <p><strong>Deprecated</strong>: Use <code>on_by_default_override</code> instead.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage onByDefault(Boolean onByDefault) {
            this.onByDefault = Optional.ofNullable(onByDefault);
            return this;
        }

        /**
         * <p><strong>Deprecated</strong>: Use <code>on_by_default_override</code> instead.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "on_by_default", nulls = Nulls.SKIP)
        public _FinalStage onByDefault(Optional<Boolean> onByDefault) {
            this.onByDefault = onByDefault;
            return this;
        }

        @java.lang.Override
        public CatalogModifierOverride build() {
            return new CatalogModifierOverride(
                    modifierId, onByDefault, hiddenOnlineOverride, onByDefaultOverride, additionalProperties);
        }
    }
}
