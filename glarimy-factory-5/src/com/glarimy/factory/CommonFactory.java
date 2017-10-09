package com.glarimy.factory;

import java.io.FileReader;
import java.util.Properties;

public class CommonFactory {
	@SuppressWarnings("unchecked")
	public static Object get(String key) throws Exception {
		Properties props = new Properties();
		props.load(new FileReader("factory.properties"));
		String name = props.getProperty(key);
		@SuppressWarnings("rawtypes")
		Class claz = Class.forName(name);

		try {
			return claz.newInstance();
		} catch (Exception e) {
			return claz.getMethod("getInstance").invoke(claz);
		}
	}

}
