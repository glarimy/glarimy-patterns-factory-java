package com.glarimy.factory;

import java.io.FileReader;
import java.lang.reflect.Method;
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
			if (claz.getAnnotation(Singleton.class) == null)
				throw new Exception();
			Method[] methods = claz.getDeclaredMethods();
			for (Method method : methods) {
				if (method.getAnnotation(FactoryMethod.class) != null)
					return method.invoke(claz);
			}
			throw new Exception();
		}
	}
}