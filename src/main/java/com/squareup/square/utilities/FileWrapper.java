package com.squareup.square.utilities;

import java.io.File;

/**
 * Class to wrap file and contentType to be sent as part of a HTTP request.
 */
public class FileWrapper {

    private File file;
    private String contentType;

    /**
     * Initialization constructor
     * @param file
     * @param contentType
     */
    public FileWrapper(File file, String contentType) {
        this.file = file;
        this.contentType = contentType;
    }

    /**
     * Initialization constructor
     * @param file
     */
    public FileWrapper(File file) {
        this.file = file;
    }

    /**
     * @return File instance
     */
    public File getFile() {
        return file;
    }

    /**
     * @return content type of the file
     */
    public String getContentType() {
        return contentType;
    }
}
