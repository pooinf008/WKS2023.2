package br.edu.inf011.model;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public abstract class GenericRequest {
	
	public Map<String, String> header;
	public byte[] content;
	
	
	public GenericRequest() {
		this.header = new HashMap<String, String>();
	}
	
	public void addHeader(String key, String value) {
		this.header.put(key, value);
	}
	
	public String readHeader(String key) {
		return this.header.get(key);
	}
	
	public byte[] getContent() {
		return this.content;
	}

	public void setMessage(String content) {
		this.content = content.getBytes();
	}
	
	public void setContent(byte[] content) {
		this.content = content;
	}
	
	public String getMessage() {
		return new String(this.getContent(), StandardCharsets.UTF_8);
	}
	
}
