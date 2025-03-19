package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.legacy.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for DismissTerminalActionResponse type.
 */
public class DismissTerminalActionResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final TerminalAction action;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  action  TerminalAction value for action.
     */
    @JsonCreator
    public DismissTerminalActionResponse(
            @JsonProperty("errors") List<Error> errors, @JsonProperty("action") TerminalAction action) {
        this.errors = errors;
        this.action = action;
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
     * Represents an action processed by the Square Terminal.
     * @return Returns the TerminalAction
     */
    @JsonGetter("action")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public TerminalAction getAction() {
        return action;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, action);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DismissTerminalActionResponse)) {
            return false;
        }
        DismissTerminalActionResponse other = (DismissTerminalActionResponse) obj;
        return Objects.equals(errors, other.errors) && Objects.equals(action, other.action);
    }

    /**
     * Converts this DismissTerminalActionResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DismissTerminalActionResponse [" + "errors=" + errors + ", action=" + action + "]";
    }

    /**
     * Builds a new {@link DismissTerminalActionResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DismissTerminalActionResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().errors(getErrors()).action(getAction());
        return builder;
    }

    /**
     * Class to build instances of {@link DismissTerminalActionResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private TerminalAction action;

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
         * @param  action  TerminalAction value for action.
         * @return Builder
         */
        public Builder action(TerminalAction action) {
            this.action = action;
            return this;
        }

        /**
         * Builds a new {@link DismissTerminalActionResponse} object using the set fields.
         * @return {@link DismissTerminalActionResponse}
         */
        public DismissTerminalActionResponse build() {
            DismissTerminalActionResponse model = new DismissTerminalActionResponse(errors, action);
            model.httpContext = httpContext;
            return model;
        }
    }
}
