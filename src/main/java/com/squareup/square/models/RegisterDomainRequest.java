package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for RegisterDomainRequest type.
 */
public class RegisterDomainRequest {

    /**
     * Initialization constructor.
     * @param domainName
     */
    @JsonCreator
    public RegisterDomainRequest(
            @JsonProperty("domain_name") String domainName) {
        this.domainName = domainName;
    }

    private final String domainName;
    /**
     * Getter for DomainName.
     * A domain name as described in RFC-1034 that will be registered with ApplePay
     */
    @JsonGetter("domain_name")
    public String getDomainName() {
        return this.domainName;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(domainName);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof RegisterDomainRequest)) {
            return false;
        }
        RegisterDomainRequest registerDomainRequest = (RegisterDomainRequest) obj;
        return Objects.equals(domainName, registerDomainRequest.domainName);
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
     * Class to build instances of {@link RegisterDomainRequest}
     */
    public static class Builder {
        private String domainName;

        /**
         * Initialization constructor
         */
        public Builder(String domainName) {
            this.domainName = domainName;
        }

        /**
         * Setter for domainName
         * @param domainName
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
