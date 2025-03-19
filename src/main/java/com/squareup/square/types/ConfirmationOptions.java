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
@JsonDeserialize(builder = ConfirmationOptions.Builder.class)
public final class ConfirmationOptions {
    private final String title;

    private final String body;

    private final String agreeButtonText;

    private final Optional<String> disagreeButtonText;

    private final Optional<ConfirmationDecision> decision;

    private final Map<String, Object> additionalProperties;

    private ConfirmationOptions(
            String title,
            String body,
            String agreeButtonText,
            Optional<String> disagreeButtonText,
            Optional<ConfirmationDecision> decision,
            Map<String, Object> additionalProperties) {
        this.title = title;
        this.body = body;
        this.agreeButtonText = agreeButtonText;
        this.disagreeButtonText = disagreeButtonText;
        this.decision = decision;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The title text to display in the confirmation screen flow on the Terminal.
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * @return The agreement details to display in the confirmation flow on the Terminal.
     */
    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    /**
     * @return The button text to display indicating the customer agrees to the displayed terms.
     */
    @JsonProperty("agree_button_text")
    public String getAgreeButtonText() {
        return agreeButtonText;
    }

    /**
     * @return The button text to display indicating the customer does not agree to the displayed terms.
     */
    @JsonIgnore
    public Optional<String> getDisagreeButtonText() {
        if (disagreeButtonText == null) {
            return Optional.empty();
        }
        return disagreeButtonText;
    }

    /**
     * @return The result of the buyer’s actions when presented with the confirmation screen.
     */
    @JsonProperty("decision")
    public Optional<ConfirmationDecision> getDecision() {
        return decision;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("disagree_button_text")
    private Optional<String> _getDisagreeButtonText() {
        return disagreeButtonText;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ConfirmationOptions && equalTo((ConfirmationOptions) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ConfirmationOptions other) {
        return title.equals(other.title)
                && body.equals(other.body)
                && agreeButtonText.equals(other.agreeButtonText)
                && disagreeButtonText.equals(other.disagreeButtonText)
                && decision.equals(other.decision);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.title, this.body, this.agreeButtonText, this.disagreeButtonText, this.decision);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TitleStage builder() {
        return new Builder();
    }

    public interface TitleStage {
        BodyStage title(@NotNull String title);

        Builder from(ConfirmationOptions other);
    }

    public interface BodyStage {
        AgreeButtonTextStage body(@NotNull String body);
    }

    public interface AgreeButtonTextStage {
        _FinalStage agreeButtonText(@NotNull String agreeButtonText);
    }

    public interface _FinalStage {
        ConfirmationOptions build();

        _FinalStage disagreeButtonText(Optional<String> disagreeButtonText);

        _FinalStage disagreeButtonText(String disagreeButtonText);

        _FinalStage disagreeButtonText(Nullable<String> disagreeButtonText);

        _FinalStage decision(Optional<ConfirmationDecision> decision);

        _FinalStage decision(ConfirmationDecision decision);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TitleStage, BodyStage, AgreeButtonTextStage, _FinalStage {
        private String title;

        private String body;

        private String agreeButtonText;

        private Optional<ConfirmationDecision> decision = Optional.empty();

        private Optional<String> disagreeButtonText = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(ConfirmationOptions other) {
            title(other.getTitle());
            body(other.getBody());
            agreeButtonText(other.getAgreeButtonText());
            disagreeButtonText(other.getDisagreeButtonText());
            decision(other.getDecision());
            return this;
        }

        /**
         * <p>The title text to display in the confirmation screen flow on the Terminal.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("title")
        public BodyStage title(@NotNull String title) {
            this.title = Objects.requireNonNull(title, "title must not be null");
            return this;
        }

        /**
         * <p>The agreement details to display in the confirmation flow on the Terminal.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("body")
        public AgreeButtonTextStage body(@NotNull String body) {
            this.body = Objects.requireNonNull(body, "body must not be null");
            return this;
        }

        /**
         * <p>The button text to display indicating the customer agrees to the displayed terms.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("agree_button_text")
        public _FinalStage agreeButtonText(@NotNull String agreeButtonText) {
            this.agreeButtonText = Objects.requireNonNull(agreeButtonText, "agreeButtonText must not be null");
            return this;
        }

        /**
         * <p>The result of the buyer’s actions when presented with the confirmation screen.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage decision(ConfirmationDecision decision) {
            this.decision = Optional.ofNullable(decision);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "decision", nulls = Nulls.SKIP)
        public _FinalStage decision(Optional<ConfirmationDecision> decision) {
            this.decision = decision;
            return this;
        }

        /**
         * <p>The button text to display indicating the customer does not agree to the displayed terms.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage disagreeButtonText(Nullable<String> disagreeButtonText) {
            if (disagreeButtonText.isNull()) {
                this.disagreeButtonText = null;
            } else if (disagreeButtonText.isEmpty()) {
                this.disagreeButtonText = Optional.empty();
            } else {
                this.disagreeButtonText = Optional.of(disagreeButtonText.get());
            }
            return this;
        }

        /**
         * <p>The button text to display indicating the customer does not agree to the displayed terms.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage disagreeButtonText(String disagreeButtonText) {
            this.disagreeButtonText = Optional.ofNullable(disagreeButtonText);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "disagree_button_text", nulls = Nulls.SKIP)
        public _FinalStage disagreeButtonText(Optional<String> disagreeButtonText) {
            this.disagreeButtonText = disagreeButtonText;
            return this;
        }

        @java.lang.Override
        public ConfirmationOptions build() {
            return new ConfirmationOptions(
                    title, body, agreeButtonText, disagreeButtonText, decision, additionalProperties);
        }
    }
}
