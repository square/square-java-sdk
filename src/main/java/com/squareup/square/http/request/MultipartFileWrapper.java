package com.squareup.square.http.request;

import java.io.File;

import com.squareup.square.http.Headers;

/**
 * Class to wrap file and headers to be sent as part of a multipart request.
 */
public class MultipartFileWrapper {

    private File file;
    private Headers headers;

    /**
     * Initialization constructor
     * @param file
     * @param headers
     */
    public MultipartFileWrapper(File file, Headers headers) {
        this.file = file;
        this.headers = headers;
    }

    /**
     * @return File instance
     */
    public File getFile() {
        return file;
    }

    /**
     * @return Headers
     */
    public Headers getHeaders() {
        return headers;
    }
}
