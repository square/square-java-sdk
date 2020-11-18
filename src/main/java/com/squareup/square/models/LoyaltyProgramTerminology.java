
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for LoyaltyProgramTerminology type.
 */
public class LoyaltyProgramTerminology {
    private final String one;
    private final String other;

    /**
     * Initialization constructor.
     * @param one String value for one.
     * @param other String value for other.
     */
    @JsonCreator
    public LoyaltyProgramTerminology(
            @JsonProperty("one") String one,
            @JsonProperty("other") String other) {
        this.one = one;
        this.other = other;
    }

    /**
     * Getter for One.
     * A singular unit for a point (for example, 1 point is called 1 star).
     * @return Returns the String
     */
    @JsonGetter("one")
    public String getOne() {
        return this.one;
    }

    /**
     * Getter for Other.
     * A plural unit for point (for example, 10 points is called 10 stars).
     * @return Returns the String
     */
    @JsonGetter("other")
    public String getOther() {
        return this.other;
    }

    @Override
    public int hashCode() {
        return Objects.hash(one, other);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyProgramTerminology)) {
            return false;
        }
        LoyaltyProgramTerminology internalOther = (LoyaltyProgramTerminology) obj;
        return Objects.equals(one, internalOther.one)
            && Objects.equals(other, internalOther.other);
    }

    /**
     * Converts this LoyaltyProgramTerminology into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyProgramTerminology [" + "one=" + one + ", other=" + other + "]";
    }

    /**
     * Builds a new {@link LoyaltyProgramTerminology.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyProgramTerminology.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(one, other);
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyProgramTerminology}.
     */
    public static class Builder {
        private String one;
        private String other;

        /**
         * Initialization constructor.
         * @param one String value for one.
         * @param other String value for other.
         */
        public Builder(String one,
                String other) {
            this.one = one;
            this.other = other;
        }

        /**
         * Setter for one.
         * @param one String value for one.
         * @return Builder
         */
        public Builder one(String one) {
            this.one = one;
            return this;
        }

        /**
         * Setter for other.
         * @param other String value for other.
         * @return Builder
         */
        public Builder other(String other) {
            this.other = other;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyProgramTerminology} object using the set fields.
         * @return {@link LoyaltyProgramTerminology}
         */
        public LoyaltyProgramTerminology build() {
            return new LoyaltyProgramTerminology(one, other);
        }
    }
}
