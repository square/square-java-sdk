
package com.squareup.square.http.request;

import com.squareup.square.http.Headers;
import com.squareup.square.utilities.FileWrapper;

/**
 * Class to wrap file and headers to be sent as part of a multipart request.
 */
public class MultipartFileWrapper {

    private FileWrapper fileWrapper;
    private Headers headers;

    /**
     * Initialization constructor.
     * @param fileWrapper FileWrapper instance
     * @param headers Headers for wrapping
     */
    public MultipartFileWrapper(FileWrapper fileWrapper, Headers headers) {
        this.fileWrapper = fileWrapper;
        this.headers = headers;
    }

    /**
     * Getter for file wrapper.
     * @return FileWrapper instance
     */
    public FileWrapper getFileWrapper() {
        return fileWrapper;
    }

    /**
     * Getter for headers.
     * @return Headers
     */
    public Headers getHeaders() {
        return headers;
    }
}
