package com.squareup.square.legacy.http.request;

import io.apimatic.coreinterfaces.http.Method;

/**
 * HTTP methods enumeration.
 */
public enum HttpMethod implements Method {
    GET,
    POST,
    PUT,
    PATCH,
    DELETE,
    HEAD
}
