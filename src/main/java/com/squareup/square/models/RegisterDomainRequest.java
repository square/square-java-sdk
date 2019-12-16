package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class RegisterDomainRequest {

    @JsonCreator
    public RegisterDomainRequest(
            @JsonProperty("domain_name") String domainName) {
        this.domainName = domainName;
    }

    private final String domainName;

    @Override
    public int hashCode() {
        return Objects.hash(domainName);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RegisterDomainRequest)) {
            return false;
        }
        RegisterDomainRequest registerDomainRequest = (RegisterDomainRequest) o;
        return Objects.equals(domainName, registerDomainRequest.domainName);
    }

    /**
     * Getter for DomainName.
     * A domain name as described in RFC-1034 that will be registered with ApplePay
     */
    @JsonGetter("domain_name")
    public String getDomainName() { 
        return this.domainName;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(domainName);
            return builder;
    }

    public static class Builder {
        private String domainName;

        public Builder(String domainName) {
            this.domainName = domainName;
        }

        public Builder domainName(String value) {
            domainName = value;
            return this;
        }

        public RegisterDomainRequest build() {
            return new RegisterDomainRequest(domainName);
        }
    }
}
