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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CreateGiftCardActivityResponse.Builder.class)
public final class CreateGiftCardActivityResponse {
    private final Optional<List<Error>> errors;

    private final Optional<GiftCardActivity> giftCardActivity;

    private final Map<String, Object> additionalProperties;

    private CreateGiftCardActivityResponse(
            Optional<List<Error>> errors,
            Optional<GiftCardActivity> giftCardActivity,
            Map<String, Object> additionalProperties) {
        this.errors = errors;
        this.giftCardActivity = giftCardActivity;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Any errors that occurred during the request.
     */
    @JsonProperty("errors")
    public Optional<List<Error>> getErrors() {
        return errors;
    }

    /**
     * @return The gift card activity that was created.
     */
    @JsonProperty("gift_card_activity")
    public Optional<GiftCardActivity> getGiftCardActivity() {
        return giftCardActivity;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateGiftCardActivityResponse && equalTo((CreateGiftCardActivityResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CreateGiftCardActivityResponse other) {
        return errors.equals(other.errors) && giftCardActivity.equals(other.giftCardActivity);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.errors, this.giftCardActivity);
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
        private Optional<List<Error>> errors = Optional.empty();

        private Optional<GiftCardActivity> giftCardActivity = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CreateGiftCardActivityResponse other) {
            errors(other.getErrors());
            giftCardActivity(other.getGiftCardActivity());
            return this;
        }

        @JsonSetter(value = "errors", nulls = Nulls.SKIP)
        public Builder errors(Optional<List<Error>> errors) {
            this.errors = errors;
            return this;
        }

        public Builder errors(List<Error> errors) {
            this.errors = Optional.ofNullable(errors);
            return this;
        }

        @JsonSetter(value = "gift_card_activity", nulls = Nulls.SKIP)
        public Builder giftCardActivity(Optional<GiftCardActivity> giftCardActivity) {
            this.giftCardActivity = giftCardActivity;
            return this;
        }

        public Builder giftCardActivity(GiftCardActivity giftCardActivity) {
            this.giftCardActivity = Optional.ofNullable(giftCardActivity);
            return this;
        }

        public CreateGiftCardActivityResponse build() {
            return new CreateGiftCardActivityResponse(errors, giftCardActivity, additionalProperties);
        }
    }
}
