package com.mv.javacert;

public class Stack2 {

	private int totalCapacity;
	private int [] content;
	private int position;
	
	public Stack2(int size) {
		this.totalCapacity = size;
		content = new int [size];
		position = 0;
	}
	
	public boolean isEmpty() {
		return position == 0;
	}
	
	public boolean isFull() {
		return position +1 == totalCapacity;
	}
	
	public void push(int n) {
		if(isFull()) {
			throw new RuntimeException("Stack is full");
		}
		
		content[position++] = n;
	}
	
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		
		return content[position--];
	}
	
	public void print() {
		System.out.print("[");
		for(int i = 0; i < position; i++) {
			System.out.print(content[i] + " ");
		}
		System.out.println("]");
	}
	
	private int getPosition() {
		// TODO Auto-generated method stub
		return position;
	}

	public static void main(String[] args) {
		
		Stack2 stack = new Stack2(10);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.print();
		
		stack.pop();
		stack.print();
		System.out.println("Position: " + stack.getPosition());
		
		stack.push(7);
		stack.print();
		System.out.println("Position: " + stack.getPosition());
		
		stack.pop();
		stack.pop();
		stack.pop();
		stack.print();
		System.out.println("Position: " + stack.getPosition());
		
		stack.pop();
	}

}
