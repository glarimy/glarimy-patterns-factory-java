package com.glarimy.factory;

public class Factory {
	public static AbstractProvider get() {
		return new ConcreteProvider();
	}
}
