package com.glarimy.factory;

import java.io.FileReader;
import java.util.Properties;

public class DirectoryFactory {
	public static Directory getDirectory() throws Exception{
		Properties props = new Properties();
		props.load(new FileReader("directory.properties"));
		String name = props.getProperty("directory");
		return (Directory) Class.forName(name).newInstance();
	}
}
