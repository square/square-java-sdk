
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CreateTerminalActionRequest type.
 */
public class CreateTerminalActionRequest {
    private final String idempotencyKey;
    private final TerminalAction action;

    /**
     * Initialization constructor.
     * @param  idempotencyKey  String value for idempotencyKey.
     * @param  action  TerminalAction value for action.
     */
    @JsonCreator
    public CreateTerminalActionRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("action") TerminalAction action) {
        this.idempotencyKey = idempotencyKey;
        this.action = action;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies this `CreateAction` request. Keys can be any valid string but
     * must be unique for every `CreateAction` request. See [Idempotency
     * keys](https://developer.squareup.com/docs/basics/api101/idempotency) for more information.
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * Getter for Action.
     * Represents an action processed by the Square Terminal.
     * @return Returns the TerminalAction
     */
    @JsonGetter("action")
    public TerminalAction getAction() {
        return action;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, action);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateTerminalActionRequest)) {
            return false;
        }
        CreateTerminalActionRequest other = (CreateTerminalActionRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(action, other.action);
    }

    /**
     * Converts this CreateTerminalActionRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateTerminalActionRequest [" + "idempotencyKey=" + idempotencyKey + ", action="
                + action + "]";
    }

    /**
     * Builds a new {@link CreateTerminalActionRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateTerminalActionRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey, action);
        return builder;
    }

    /**
     * Class to build instances of {@link CreateTerminalActionRequest}.
     */
    public static class Builder {
        private String idempotencyKey;
        private TerminalAction action;

        /**
         * Initialization constructor.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @param  action  TerminalAction value for action.
         */
        public Builder(String idempotencyKey, TerminalAction action) {
            this.idempotencyKey = idempotencyKey;
            this.action = action;
        }

        /**
         * Setter for idempotencyKey.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
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
         * Builds a new {@link CreateTerminalActionRequest} object using the set fields.
         * @return {@link CreateTerminalActionRequest}
         */
        public CreateTerminalActionRequest build() {
            return new CreateTerminalActionRequest(idempotencyKey, action);
        }
    }
}
