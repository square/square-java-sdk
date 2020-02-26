package com.squareup.square.http.request;

import com.squareup.square.utilities.FileWrapper;
import com.squareup.square.http.Headers;

/**
 * Class to wrap file and headers to be sent as part of a multipart request.
 */
public class MultipartFileWrapper {

    private FileWrapper fileWrapper;
    private Headers headers;

    /**
     * Initialization constructor
     * @param fileWrapper
     * @param headers
     */
    public MultipartFileWrapper(FileWrapper fileWrapper, Headers headers) {
        this.fileWrapper = fileWrapper;
        this.headers = headers;
    }

    /**
     * @return FileWrapper instance
     */
    public FileWrapper getFileWrapper() {
        return fileWrapper;
    }

    /**
     * @return Headers
     */
    public Headers getHeaders() {
        return headers;
    }
}
