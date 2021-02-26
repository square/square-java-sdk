
package com.squareup.square.http.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.squareup.square.http.Headers;

/**
 * Class to wrap byteArray and headers to be sent as part of a multipart request.
 */
public class MultipartWrapper {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private byte[] byteArray;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Headers headers;

    /**
     * Initialization constructor.
     * @param byteArray Array of bytes
     * @param headers Headers for wrapping
     */
    public MultipartWrapper(byte[] byteArray, Headers headers) {
        this.byteArray = byteArray;
        this.headers = headers;
    }

    /**
     * Getter for bytes.
     * @return Array of bytes.
     */
    public byte[] getByteArray() {
        return byteArray;
    }

    /**
     * Getter for headers.
     * @return headers
     */
    public Headers getHeaders() {
        return headers;
    }
}
