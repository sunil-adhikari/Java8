package com.java8.defaultmethod;

public class ExistingClass implements Interface1,Interface2{

	@Override
	public void newDefaultMethod() {
		Interface2.super.newDefaultMethod();
	}

	

}
