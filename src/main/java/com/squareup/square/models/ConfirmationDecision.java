
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for ConfirmationDecision type.
 */
public class ConfirmationDecision {
    private final Boolean hasAgreed;

    /**
     * Initialization constructor.
     * @param  hasAgreed  Boolean value for hasAgreed.
     */
    @JsonCreator
    public ConfirmationDecision(
            @JsonProperty("has_agreed") Boolean hasAgreed) {
        this.hasAgreed = hasAgreed;
    }

    /**
     * Getter for HasAgreed.
     * The buyer's decision to the displayed terms.
     * @return Returns the Boolean
     */
    @JsonGetter("has_agreed")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getHasAgreed() {
        return hasAgreed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hasAgreed);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConfirmationDecision)) {
            return false;
        }
        ConfirmationDecision other = (ConfirmationDecision) obj;
        return Objects.equals(hasAgreed, other.hasAgreed);
    }

    /**
     * Converts this ConfirmationDecision into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ConfirmationDecision [" + "hasAgreed=" + hasAgreed + "]";
    }

    /**
     * Builds a new {@link ConfirmationDecision.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ConfirmationDecision.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .hasAgreed(getHasAgreed());
        return builder;
    }

    /**
     * Class to build instances of {@link ConfirmationDecision}.
     */
    public static class Builder {
        private Boolean hasAgreed;



        /**
         * Setter for hasAgreed.
         * @param  hasAgreed  Boolean value for hasAgreed.
         * @return Builder
         */
        public Builder hasAgreed(Boolean hasAgreed) {
            this.hasAgreed = hasAgreed;
            return this;
        }

        /**
         * Builds a new {@link ConfirmationDecision} object using the set fields.
         * @return {@link ConfirmationDecision}
         */
        public ConfirmationDecision build() {
            return new ConfirmationDecision(hasAgreed);
        }
    }
}
