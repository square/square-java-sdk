
package com.squareup.square.http.request.configuration;

/**
 * Retry options enumeration for HTTP request.
 */
public enum RetryOption {

    /**
     * To retry request, ignoring httpMethods whitelist.
     */
    ENABLE_FOR_HTTP_METHOD("ENABLE_FOR_HTTP_METHOD"),

    /**
     * To disable retries for the request.
     */
    DISABLE("DISABLE"),

    /**
     * To use global httpMethods whitelist to determine if request needs retrying.
     */
    DEFAULT("DEFAULT");

    private final String value;

    RetryOption(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    /**
     * Determines whether retrying for the request is allowed or not.
     * @param isWhitelistedRequestMethod flag if the global list of HTTP method contains the request
     *        method.
     * @return True if retrying for the request is allowed.
     */
    public boolean isRetryAllowed(boolean isWhitelistedRequestMethod) {
        RetryOption retryOption = valueOf(value);
        switch (retryOption) {
            case ENABLE_FOR_HTTP_METHOD:
                return true;
            case DISABLE:
                return false;
            case DEFAULT:
                return isWhitelistedRequestMethod;
        }
        return isWhitelistedRequestMethod;
    }

}
