package br.edu.inf011.model;


public interface Request {
	
	public void addHeader(String key, String value);
	public String readHeader(String key);
	public byte[] getContent();
	public void setContent(byte[] content);
	public String getMessage();
	public void setMessage(String message);
	
	
}
