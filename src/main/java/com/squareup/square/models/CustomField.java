
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CustomField type.
 */
public class CustomField {
    private final String title;

    /**
     * Initialization constructor.
     * @param  title  String value for title.
     */
    @JsonCreator
    public CustomField(
            @JsonProperty("title") String title) {
        this.title = title;
    }

    /**
     * Getter for Title.
     * The title of the custom field.
     * @return Returns the String
     */
    @JsonGetter("title")
    public String getTitle() {
        return title;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CustomField)) {
            return false;
        }
        CustomField other = (CustomField) obj;
        return Objects.equals(title, other.title);
    }

    /**
     * Converts this CustomField into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CustomField [" + "title=" + title + "]";
    }

    /**
     * Builds a new {@link CustomField.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CustomField.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(title);
        return builder;
    }

    /**
     * Class to build instances of {@link CustomField}.
     */
    public static class Builder {
        private String title;

        /**
         * Initialization constructor.
         * @param  title  String value for title.
         */
        public Builder(String title) {
            this.title = title;
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
         * Builds a new {@link CustomField} object using the set fields.
         * @return {@link CustomField}
         */
        public CustomField build() {
            return new CustomField(title);
        }
    }
}
