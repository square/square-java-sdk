package com.squareup.square.http.request;

import java.io.File;

import com.squareup.square.http.Headers;

public class MultipartFileWrapper {

    private File file;
    private Headers headers;

    public MultipartFileWrapper(File file, Headers headers) {
		this.file = file;
		this.headers = headers;
	}
	
	public File getFile() {
		return file;
	}
	
	public Headers getHeaders() {
		return headers;
	}
}
