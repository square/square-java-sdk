
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for RegisterDomainRequest type.
 */
public class RegisterDomainRequest {
    private final String domainName;

    /**
     * Initialization constructor.
     * @param  domainName  String value for domainName.
     */
    @JsonCreator
    public RegisterDomainRequest(
            @JsonProperty("domain_name") String domainName) {
        this.domainName = domainName;
    }

    /**
     * Getter for DomainName.
     * A domain name as described in RFC-1034 that will be registered with ApplePay.
     * @return Returns the String
     */
    @JsonGetter("domain_name")
    public String getDomainName() {
        return domainName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(domainName);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RegisterDomainRequest)) {
            return false;
        }
        RegisterDomainRequest other = (RegisterDomainRequest) obj;
        return Objects.equals(domainName, other.domainName);
    }

    /**
     * Converts this RegisterDomainRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RegisterDomainRequest [" + "domainName=" + domainName + "]";
    }

    /**
     * Builds a new {@link RegisterDomainRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RegisterDomainRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(domainName);
        return builder;
    }

    /**
     * Class to build instances of {@link RegisterDomainRequest}.
     */
    public static class Builder {
        private String domainName;

        /**
         * Initialization constructor.
         * @param  domainName  String value for domainName.
         */
        public Builder(String domainName) {
            this.domainName = domainName;
        }

        /**
         * Setter for domainName.
         * @param  domainName  String value for domainName.
         * @return Builder
         */
        public Builder domainName(String domainName) {
            this.domainName = domainName;
            return this;
        }

        /**
         * Builds a new {@link RegisterDomainRequest} object using the set fields.
         * @return {@link RegisterDomainRequest}
         */
        public RegisterDomainRequest build() {
            return new RegisterDomainRequest(domainName);
        }
    }
}
