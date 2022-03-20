import java.util.Scanner;
import java.util.Arrays;

public class P2_CustomDoublyLinkedList
{
	//creating class node for doubly linkedlist
	private class Node
	{
		int val;
		Node prev;
		Node next;

		public Node(int val)
		{
			this.val = val;
		}


		public Node(int value, Node prev, Node next)
		{
			this.val =  value;
			this.prev = prev;
			this.next = next;
		}
	}


	//requirements for doubly linkedlist
	private Node head;

	//insertFirst function
	public void insertFirst(int value)
	{
		Node node = new Node(value);
		node.prev = null;

		if(head == null)
		{
			node.next = null;
			head = node;
			return;
		}

		node.next = head;
		head.prev = node;
		head = node;
	}


	// insertLast function
	public void insertLast(int value)
	{
		Node node = new Node(value);
		node.next = null;

		if(head == null)
		{
			node.prev = null;
			head = node;
			return;
		}


		Node temp = head;
		while(temp.next != null)
			temp = temp.next;

		node.prev = temp;
		temp.next = node;
	}


	// display function
	public void display()
	{
		Node temp = head;

		while(temp != null)
		{
			System.out.print(temp.val + " -> ");
			temp = temp.next;
		}

		System.out.println("END");

		// printing in reverse order
		Node last = head;
		while(last.next != null)
			last = last.next;

		while(last != null)
		{
			System.out.print(last.val + " -> ");
			last = last.prev;
		}

		System.out.println("START");
	}

	// Main Function 
	public static void main(String[] args)
	{
		P2_CustomDoublyLinkedList ll = new P2_CustomDoublyLinkedList();
		ll.insertFirst(1);
		ll.insertFirst(2);
		ll.insertFirst(3);
		ll.insertFirst(4);
		ll.insertLast(5);

		ll.display();
	}
}