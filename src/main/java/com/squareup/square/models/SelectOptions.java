
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for SelectOptions type.
 */
public class SelectOptions {
    private final String title;
    private final String body;
    private final List<SelectOption> options;
    private final SelectOption selectedOption;

    /**
     * Initialization constructor.
     * @param  title  String value for title.
     * @param  body  String value for body.
     * @param  options  List of SelectOption value for options.
     * @param  selectedOption  SelectOption value for selectedOption.
     */
    @JsonCreator
    public SelectOptions(
            @JsonProperty("title") String title,
            @JsonProperty("body") String body,
            @JsonProperty("options") List<SelectOption> options,
            @JsonProperty("selected_option") SelectOption selectedOption) {
        this.title = title;
        this.body = body;
        this.options = options;
        this.selectedOption = selectedOption;
    }

    /**
     * Getter for Title.
     * The title text to display in the select flow on the Terminal.
     * @return Returns the String
     */
    @JsonGetter("title")
    public String getTitle() {
        return title;
    }

    /**
     * Getter for Body.
     * The body text to display in the select flow on the Terminal.
     * @return Returns the String
     */
    @JsonGetter("body")
    public String getBody() {
        return body;
    }

    /**
     * Getter for Options.
     * Represents the buttons/options that should be displayed in the select flow on the Terminal.
     * @return Returns the List of SelectOption
     */
    @JsonGetter("options")
    public List<SelectOption> getOptions() {
        return options;
    }

    /**
     * Getter for SelectedOption.
     * @return Returns the SelectOption
     */
    @JsonGetter("selected_option")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public SelectOption getSelectedOption() {
        return selectedOption;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, body, options, selectedOption);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SelectOptions)) {
            return false;
        }
        SelectOptions other = (SelectOptions) obj;
        return Objects.equals(title, other.title)
            && Objects.equals(body, other.body)
            && Objects.equals(options, other.options)
            && Objects.equals(selectedOption, other.selectedOption);
    }

    /**
     * Converts this SelectOptions into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SelectOptions [" + "title=" + title + ", body=" + body + ", options=" + options
                + ", selectedOption=" + selectedOption + "]";
    }

    /**
     * Builds a new {@link SelectOptions.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SelectOptions.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(title, body, options)
                .selectedOption(getSelectedOption());
        return builder;
    }

    /**
     * Class to build instances of {@link SelectOptions}.
     */
    public static class Builder {
        private String title;
        private String body;
        private List<SelectOption> options;
        private SelectOption selectedOption;

        /**
         * Initialization constructor.
         * @param  title  String value for title.
         * @param  body  String value for body.
         * @param  options  List of SelectOption value for options.
         */
        public Builder(String title, String body, List<SelectOption> options) {
            this.title = title;
            this.body = body;
            this.options = options;
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
         * Setter for options.
         * @param  options  List of SelectOption value for options.
         * @return Builder
         */
        public Builder options(List<SelectOption> options) {
            this.options = options;
            return this;
        }

        /**
         * Setter for selectedOption.
         * @param  selectedOption  SelectOption value for selectedOption.
         * @return Builder
         */
        public Builder selectedOption(SelectOption selectedOption) {
            this.selectedOption = selectedOption;
            return this;
        }

        /**
         * Builds a new {@link SelectOptions} object using the set fields.
         * @return {@link SelectOptions}
         */
        public SelectOptions build() {
            return new SelectOptions(title, body, options, selectedOption);
        }
    }
}
