
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for SearchTerminalActionsResponse type.
 */
public class SearchTerminalActionsResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<TerminalAction> action;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  action  List of TerminalAction value for action.
     * @param  cursor  String value for cursor.
     */
    @JsonCreator
    public SearchTerminalActionsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("action") List<TerminalAction> action,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.action = action;
        this.cursor = cursor;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information on errors encountered during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Action.
     * The requested search result of `TerminalAction`s.
     * @return Returns the List of TerminalAction
     */
    @JsonGetter("action")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<TerminalAction> getAction() {
        return action;
    }

    /**
     * Getter for Cursor.
     * The pagination cursor to be used in a subsequent request. If empty, this is the final
     * response. See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for
     * more information.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, action, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchTerminalActionsResponse)) {
            return false;
        }
        SearchTerminalActionsResponse other = (SearchTerminalActionsResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(action, other.action)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this SearchTerminalActionsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchTerminalActionsResponse [" + "errors=" + errors + ", action=" + action
                + ", cursor=" + cursor + "]";
    }

    /**
     * Builds a new {@link SearchTerminalActionsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchTerminalActionsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .action(getAction())
                .cursor(getCursor());
        return builder;
    }

    /**
     * Class to build instances of {@link SearchTerminalActionsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<TerminalAction> action;
        private String cursor;



        /**
         * Setter for httpContext.
         * @param  httpContext  HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Setter for action.
         * @param  action  List of TerminalAction value for action.
         * @return Builder
         */
        public Builder action(List<TerminalAction> action) {
            this.action = action;
            return this;
        }

        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Builds a new {@link SearchTerminalActionsResponse} object using the set fields.
         * @return {@link SearchTerminalActionsResponse}
         */
        public SearchTerminalActionsResponse build() {
            SearchTerminalActionsResponse model =
                    new SearchTerminalActionsResponse(errors, action, cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
