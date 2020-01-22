package com.squareup.square.http.request;

import com.squareup.square.http.Headers;

/**
 * Class to wrap byteArray and headers to be sent as part of a multipart request
 */
public class MultipartWrapper {

    private byte[] byteArray;
    private Headers headers;

    /**
     * Initialization constructor
     * @param byteArray
     * @param headers
     */
    public MultipartWrapper(byte[] byteArray, Headers headers) {
        this.byteArray = byteArray;
        this.headers = headers;
    }

    /**
     * @return Array of bytes.
     */
    public byte[] getByteArray() {
        return byteArray;
    }

    /**
     * @return headers
     */
    public Headers getHeaders() {
        return headers;
    }
}
