
package com.squareup.square.utilities;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.File;

/**
 * Class to wrap file and contentType to be sent as part of a HTTP request.
 */
public class FileWrapper {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private File file;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String contentType;

    /**
     * Initialization constructor.
     * @param file File object to be wrapped
     * @param contentType content type of file
     */
    public FileWrapper(File file, String contentType) {
        this.file = file;
        this.contentType = contentType;
    }

    /**
     * Initialization constructor.
     * @param file File object to be wrapped
     */
    public FileWrapper(File file) {
        this.file = file;
    }

    /**
     * Getter for file.
     * @return File instance
     */
    public File getFile() {
        return file;
    }

    /**
     * Getter for content type.
     * @return content type of the file
     */
    public String getContentType() {
        return contentType;
    }
}
