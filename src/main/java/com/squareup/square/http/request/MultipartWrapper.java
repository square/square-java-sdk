package com.squareup.square.http.request;

import com.squareup.square.http.Headers;

public class MultipartWrapper {

	private byte[] byteArray;
    private Headers headers;

    public MultipartWrapper(byte[] byteArray, Headers headers) {
		this.byteArray = byteArray;
		this.headers = headers;
	}
	
	public byte[] getByteArray() {
		return byteArray;
	}
	
	public Headers getHeaders() {
		return headers;
	}
}
