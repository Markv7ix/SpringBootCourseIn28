package com.modernjava.sealed;

public sealed class Car extends Vehicle implements SmartMediaPlayer permits FlyingCar {

	@Override
	public void drive() {
		// TODO Auto-generated method stub
		System.out.println("Car is driving");
	}

	@Override
	public void connectPhone() {
		// TODO Auto-generated method stub
		System.out.println("Phone is connected to the car");
	}
	
	

}
