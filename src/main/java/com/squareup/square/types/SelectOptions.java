/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.ObjectMappers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = SelectOptions.Builder.class)
public final class SelectOptions {
    private final String title;

    private final String body;

    private final List<SelectOption> options;

    private final Optional<SelectOption> selectedOption;

    private final Map<String, Object> additionalProperties;

    private SelectOptions(
            String title,
            String body,
            List<SelectOption> options,
            Optional<SelectOption> selectedOption,
            Map<String, Object> additionalProperties) {
        this.title = title;
        this.body = body;
        this.options = options;
        this.selectedOption = selectedOption;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The title text to display in the select flow on the Terminal.
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * @return The body text to display in the select flow on the Terminal.
     */
    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    /**
     * @return Represents the buttons/options that should be displayed in the select flow on the Terminal.
     */
    @JsonProperty("options")
    public List<SelectOption> getOptions() {
        return options;
    }

    /**
     * @return The buyer’s selected option.
     */
    @JsonProperty("selected_option")
    public Optional<SelectOption> getSelectedOption() {
        return selectedOption;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SelectOptions && equalTo((SelectOptions) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(SelectOptions other) {
        return title.equals(other.title)
                && body.equals(other.body)
                && options.equals(other.options)
                && selectedOption.equals(other.selectedOption);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.title, this.body, this.options, this.selectedOption);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TitleStage builder() {
        return new Builder();
    }

    public interface TitleStage {
        /**
         * <p>The title text to display in the select flow on the Terminal.</p>
         */
        BodyStage title(@NotNull String title);

        Builder from(SelectOptions other);
    }

    public interface BodyStage {
        /**
         * <p>The body text to display in the select flow on the Terminal.</p>
         */
        _FinalStage body(@NotNull String body);
    }

    public interface _FinalStage {
        SelectOptions build();

        /**
         * <p>Represents the buttons/options that should be displayed in the select flow on the Terminal.</p>
         */
        _FinalStage options(List<SelectOption> options);

        _FinalStage addOptions(SelectOption options);

        _FinalStage addAllOptions(List<SelectOption> options);

        /**
         * <p>The buyer’s selected option.</p>
         */
        _FinalStage selectedOption(Optional<SelectOption> selectedOption);

        _FinalStage selectedOption(SelectOption selectedOption);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TitleStage, BodyStage, _FinalStage {
        private String title;

        private String body;

        private Optional<SelectOption> selectedOption = Optional.empty();

        private List<SelectOption> options = new ArrayList<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(SelectOptions other) {
            title(other.getTitle());
            body(other.getBody());
            options(other.getOptions());
            selectedOption(other.getSelectedOption());
            return this;
        }

        /**
         * <p>The title text to display in the select flow on the Terminal.</p>
         * <p>The title text to display in the select flow on the Terminal.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("title")
        public BodyStage title(@NotNull String title) {
            this.title = Objects.requireNonNull(title, "title must not be null");
            return this;
        }

        /**
         * <p>The body text to display in the select flow on the Terminal.</p>
         * <p>The body text to display in the select flow on the Terminal.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("body")
        public _FinalStage body(@NotNull String body) {
            this.body = Objects.requireNonNull(body, "body must not be null");
            return this;
        }

        /**
         * <p>The buyer’s selected option.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage selectedOption(SelectOption selectedOption) {
            this.selectedOption = Optional.ofNullable(selectedOption);
            return this;
        }

        /**
         * <p>The buyer’s selected option.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "selected_option", nulls = Nulls.SKIP)
        public _FinalStage selectedOption(Optional<SelectOption> selectedOption) {
            this.selectedOption = selectedOption;
            return this;
        }

        /**
         * <p>Represents the buttons/options that should be displayed in the select flow on the Terminal.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addAllOptions(List<SelectOption> options) {
            this.options.addAll(options);
            return this;
        }

        /**
         * <p>Represents the buttons/options that should be displayed in the select flow on the Terminal.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addOptions(SelectOption options) {
            this.options.add(options);
            return this;
        }

        /**
         * <p>Represents the buttons/options that should be displayed in the select flow on the Terminal.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "options", nulls = Nulls.SKIP)
        public _FinalStage options(List<SelectOption> options) {
            this.options.clear();
            this.options.addAll(options);
            return this;
        }

        @java.lang.Override
        public SelectOptions build() {
            return new SelectOptions(title, body, options, selectedOption, additionalProperties);
        }
    }
}
