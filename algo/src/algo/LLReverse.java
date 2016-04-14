package algo;

import java.util.Scanner;

public class LLReverse {

	Node node = null;
	
	public Node populate(){
		Scanner scan = new Scanner(System.in);
		Node head = null;
		boolean isHead = false;
		while(true){
		System.out.println("Enter next value of 123 to quit : ");
		int n = scan.nextInt();
		if(n == 123){
			node.setNext(null);
			break;
		}
		if(isHead == false){
			isHead = true;
			node = new Node(n);
			head = node;
			
			System.out.println("Node Data : "+ node.getData());
		}else{
			System.out.println("Node Data when node exists : "+ node.getData());
			node.setNext(new Node(n));
			node = node.getNext();
		}
		
	}
		return head;
	}
		
	public void display(Node node){
	
		while(node != null){
			System.out.println(node.getData());
			node = node.getNext();
		}	
	}
	
	public static void main(String[] args){
		LLReverse llr = new LLReverse();
		Node head = llr.populate();
		llr.display(head);
		Node rev = llr.reverse(head);
		llr.display(rev);
	}
	
	public Node reverse(Node node){
		Node current = node;
		Node prev = null;
		Node next = null;
		
		while(current != null){
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		
		return prev;
	}
}

class Node{
	Node next;
	int data;
	
	public Node(int data){
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}
