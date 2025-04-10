package com.mv.javacert;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class MergeLists {

	public static NodeList mergeLists(NodeList listA, NodeList listB) {
		
		NodeList result = new NodeList();
		
		Integer valueA = listA.getNext();
		Integer valueB = listB.getNext();
		
		while(valueA != null || valueB!= null) {
			
			if(valueB == null || (valueA != null && valueA <= valueB)) {
				result.add(valueA);
				valueA = listA.getNext();
				continue;
			}
			
			if(valueA == null || (valueB != null && valueB <= valueA)) {
				result.add(valueB);
				valueB = listB.getNext();
				continue;
			}
			
		}
		
		
		return result;
	}
	
	public static void main(String[] args) {
		// Create list A
		NodeList listA = new NodeList();
		listA.add(1).add(3).add(5).add(7).add(13);

		NodeList listB = new NodeList();
		listB.add(1).add(3).add(5).add(7).add(13);
		
		Integer value = null;
		
		System.out.println("List A: " + listA.toString());
		System.out.println("List B: " + listB.toString());
//		System.out.println(((value = listA.getNext()) != null ? value : null)); 
//		System.out.println(((value = listA.getNext()) != null ? value : null)); 
//		System.out.println(((value = listA.getNext()) != null ? value : null)); 
//		System.out.println(((value = listA.getNext()) != null ? value : null)); 
//		System.out.println(((value = listA.getNext()) != null ? value : null)); 
//		System.out.println(((value = listA.getNext()) != null ? value : null)); 
//		System.out.println(((value = listA.getNext()) != null ? value : null)); 
//		System.out.println("List A: " + listA.toString());
//		System.out.println("List B: " + listB.toString());
		// Create list B
		
		System.out.println("Merged lists: " + mergeLists(listA, listB).toString());
	}
	
	
}

class NodeList {
	
	private Node head;
	private Node tail;
	private Node cursor;
	
	public Integer getNext() {
		if(this.cursor == null) {
			return null;
		}
		
		Node current = this.cursor;
		this.cursor = this.cursor.getNext();
		return current.getValue();
	}
	
	public NodeList add(Integer value) {
		Node newNode = new Node(value, null);
		if(this.head == null) {
			this.head = newNode;
			this.cursor = newNode;
		}
		if(this.tail == null) {
			this.tail = newNode;
		} else {
			this.tail.setNext(newNode);
			this.tail = newNode;			
		}
		return this;
	}
	
	public void reset() {
		this.cursor = this.head;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Integer value = null;
		while((value = getNext()) != null) {
			sb.append(value + " ");
		}
		
		sb.append("]");	
		reset();
		return sb.toString();
	}
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Node {
	private Integer value;
	private Node next;
}