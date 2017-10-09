package com.glarimy.factory;

public class ConcreteProvider implements AbstractProvider {
	@Override
	public void service() {
		System.out.println("ConcreteProvider:service");
	}
}
