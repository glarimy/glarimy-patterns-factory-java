package com.glarimy.factory;

import java.io.FileReader;
import java.util.Properties;

public class CommonFactory {
	public static Object get(String key) throws Exception {
		Properties props = new Properties();
		props.load(new FileReader("factory.properties"));
		String name = props.getProperty(key);
		return Class.forName(name).newInstance();
	}
}
