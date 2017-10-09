package com.glarimy.factory;

public interface Directory {
	public long find(String name) throws NameNotFoundException, DirectoryException;
}
