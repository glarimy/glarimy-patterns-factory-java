package com.glarimy.factory;

public class DirectoryFactory {
	public static Directory getDirectory() throws Exception {
		return new SimpleDirectory();
	}
}
