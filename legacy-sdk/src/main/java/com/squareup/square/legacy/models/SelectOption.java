package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for SelectOption type.
 */
public class SelectOption {
    private final String referenceId;
    private final String title;

    /**
     * Initialization constructor.
     * @param  referenceId  String value for referenceId.
     * @param  title  String value for title.
     */
    @JsonCreator
    public SelectOption(@JsonProperty("reference_id") String referenceId, @JsonProperty("title") String title) {
        this.referenceId = referenceId;
        this.title = title;
    }

    /**
     * Getter for ReferenceId.
     * The reference id for the option.
     * @return Returns the String
     */
    @JsonGetter("reference_id")
    public String getReferenceId() {
        return referenceId;
    }

    /**
     * Getter for Title.
     * The title text that displays in the select option button.
     * @return Returns the String
     */
    @JsonGetter("title")
    public String getTitle() {
        return title;
    }

    @Override
    public int hashCode() {
        return Objects.hash(referenceId, title);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SelectOption)) {
            return false;
        }
        SelectOption other = (SelectOption) obj;
        return Objects.equals(referenceId, other.referenceId) && Objects.equals(title, other.title);
    }

    /**
     * Converts this SelectOption into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SelectOption [" + "referenceId=" + referenceId + ", title=" + title + "]";
    }

    /**
     * Builds a new {@link SelectOption.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SelectOption.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(referenceId, title);
        return builder;
    }

    /**
     * Class to build instances of {@link SelectOption}.
     */
    public static class Builder {
        private String referenceId;
        private String title;

        /**
         * Initialization constructor.
         * @param  referenceId  String value for referenceId.
         * @param  title  String value for title.
         */
        public Builder(String referenceId, String title) {
            this.referenceId = referenceId;
            this.title = title;
        }

        /**
         * Setter for referenceId.
         * @param  referenceId  String value for referenceId.
         * @return Builder
         */
        public Builder referenceId(String referenceId) {
            this.referenceId = referenceId;
            return this;
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
         * Builds a new {@link SelectOption} object using the set fields.
         * @return {@link SelectOption}
         */
        public SelectOption build() {
            return new SelectOption(referenceId, title);
        }
    }
}
