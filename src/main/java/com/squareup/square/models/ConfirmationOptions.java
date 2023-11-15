
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for ConfirmationOptions type.
 */
public class ConfirmationOptions {
    private final String title;
    private final String body;
    private final String agreeButtonText;
    private final OptionalNullable<String> disagreeButtonText;
    private final ConfirmationDecision decision;

    /**
     * Initialization constructor.
     * @param  title  String value for title.
     * @param  body  String value for body.
     * @param  agreeButtonText  String value for agreeButtonText.
     * @param  disagreeButtonText  String value for disagreeButtonText.
     * @param  decision  ConfirmationDecision value for decision.
     */
    @JsonCreator
    public ConfirmationOptions(
            @JsonProperty("title") String title,
            @JsonProperty("body") String body,
            @JsonProperty("agree_button_text") String agreeButtonText,
            @JsonProperty("disagree_button_text") String disagreeButtonText,
            @JsonProperty("decision") ConfirmationDecision decision) {
        this.title = title;
        this.body = body;
        this.agreeButtonText = agreeButtonText;
        this.disagreeButtonText = OptionalNullable.of(disagreeButtonText);
        this.decision = decision;
    }

    /**
     * Initialization constructor.
     * @param  title  String value for title.
     * @param  body  String value for body.
     * @param  agreeButtonText  String value for agreeButtonText.
     * @param  disagreeButtonText  String value for disagreeButtonText.
     * @param  decision  ConfirmationDecision value for decision.
     */

    protected ConfirmationOptions(String title, String body, String agreeButtonText,
            OptionalNullable<String> disagreeButtonText, ConfirmationDecision decision) {
        this.title = title;
        this.body = body;
        this.agreeButtonText = agreeButtonText;
        this.disagreeButtonText = disagreeButtonText;
        this.decision = decision;
    }

    /**
     * Getter for Title.
     * The title text to display in the confirmation screen flow on the Terminal.
     * @return Returns the String
     */
    @JsonGetter("title")
    public String getTitle() {
        return title;
    }

    /**
     * Getter for Body.
     * The agreement details to display in the confirmation flow on the Terminal.
     * @return Returns the String
     */
    @JsonGetter("body")
    public String getBody() {
        return body;
    }

    /**
     * Getter for AgreeButtonText.
     * The button text to display indicating the customer agrees to the displayed terms.
     * @return Returns the String
     */
    @JsonGetter("agree_button_text")
    public String getAgreeButtonText() {
        return agreeButtonText;
    }

    /**
     * Internal Getter for DisagreeButtonText.
     * The button text to display indicating the customer does not agree to the displayed terms.
     * @return Returns the Internal String
     */
    @JsonGetter("disagree_button_text")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetDisagreeButtonText() {
        return this.disagreeButtonText;
    }

    /**
     * Getter for DisagreeButtonText.
     * The button text to display indicating the customer does not agree to the displayed terms.
     * @return Returns the String
     */
    @JsonIgnore
    public String getDisagreeButtonText() {
        return OptionalNullable.getFrom(disagreeButtonText);
    }

    /**
     * Getter for Decision.
     * @return Returns the ConfirmationDecision
     */
    @JsonGetter("decision")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ConfirmationDecision getDecision() {
        return decision;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, body, agreeButtonText, disagreeButtonText, decision);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConfirmationOptions)) {
            return false;
        }
        ConfirmationOptions other = (ConfirmationOptions) obj;
        return Objects.equals(title, other.title)
            && Objects.equals(body, other.body)
            && Objects.equals(agreeButtonText, other.agreeButtonText)
            && Objects.equals(disagreeButtonText, other.disagreeButtonText)
            && Objects.equals(decision, other.decision);
    }

    /**
     * Converts this ConfirmationOptions into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ConfirmationOptions [" + "title=" + title + ", body=" + body + ", agreeButtonText="
                + agreeButtonText + ", disagreeButtonText=" + disagreeButtonText + ", decision="
                + decision + "]";
    }

    /**
     * Builds a new {@link ConfirmationOptions.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ConfirmationOptions.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(title, body, agreeButtonText)
                .decision(getDecision());
        builder.disagreeButtonText = internalGetDisagreeButtonText();
        return builder;
    }

    /**
     * Class to build instances of {@link ConfirmationOptions}.
     */
    public static class Builder {
        private String title;
        private String body;
        private String agreeButtonText;
        private OptionalNullable<String> disagreeButtonText;
        private ConfirmationDecision decision;

        /**
         * Initialization constructor.
         * @param  title  String value for title.
         * @param  body  String value for body.
         * @param  agreeButtonText  String value for agreeButtonText.
         */
        public Builder(String title, String body, String agreeButtonText) {
            this.title = title;
            this.body = body;
            this.agreeButtonText = agreeButtonText;
        }

        /**
         * Setter for title.
         * @param  title  String value for title.
         * @return Builder
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * Setter for body.
         * @param  body  String value for body.
         * @return Builder
         */
        public Builder body(String body) {
            this.body = body;
            return this;
        }

        /**
         * Setter for agreeButtonText.
         * @param  agreeButtonText  String value for agreeButtonText.
         * @return Builder
         */
        public Builder agreeButtonText(String agreeButtonText) {
            this.agreeButtonText = agreeButtonText;
            return this;
        }

        /**
         * Setter for disagreeButtonText.
         * @param  disagreeButtonText  String value for disagreeButtonText.
         * @return Builder
         */
        public Builder disagreeButtonText(String disagreeButtonText) {
            this.disagreeButtonText = OptionalNullable.of(disagreeButtonText);
            return this;
        }

        /**
         * UnSetter for disagreeButtonText.
         * @return Builder
         */
        public Builder unsetDisagreeButtonText() {
            disagreeButtonText = null;
            return this;
        }

        /**
         * Setter for decision.
         * @param  decision  ConfirmationDecision value for decision.
         * @return Builder
         */
        public Builder decision(ConfirmationDecision decision) {
            this.decision = decision;
            return this;
        }

        /**
         * Builds a new {@link ConfirmationOptions} object using the set fields.
         * @return {@link ConfirmationOptions}
         */
        public ConfirmationOptions build() {
            return new ConfirmationOptions(title, body, agreeButtonText, disagreeButtonText,
                    decision);
        }
    }
}
