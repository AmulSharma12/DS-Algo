// Custom LinkedList Implementation 
// Linkedlist is a linear data structure dynamic in size and allows insertion and deletion from
// from both the end
// LinkedList has some set of property 
// node (val , next) , tail , head , size

public class P1_CustomLinkedList
{

	//------------------------------------Node class
	private class Node
	{
		int val;
		Node next;

		//creating node and initialise with value
		public Node(int value)
		{
			this.val = value;
		}


		public Node(int val, Node next)
		{
			this.val = val;
			this.next = next;
		}
	}


	private Node head;
	private Node tail;
	private int size;


	//constuctor LinkedList
	public P1_CustomLinkedList()
	{
		size = 0;
	}



	// ----------------------------------------------------Insert
	//insertFirst function 
	public void insertFirst(int val)
	{
		Node node = new Node(val);
		node.next = head;
		head = node;

		if(tail == null)
			tail = head;

		size++;

	}


	//insertLast function
	public void insertLast(int val)
	{
		if(tail == null)
		{
			insertFirst(val);
			return;
		}


		Node node = new Node(val);
		tail.next = node;
		tail = node;
		size++;
	}



	//inserting at particular index
	public void insert(int val, int index)
	{
		if(index == 0)
		{
			insertFirst(val);
			return;
		}


		if(index == size)
		{
			insertLast(val);
			return;
		}

		// when we have to insert into index
		Node temp = head;

		for(int i = 1; i<index; i++)
			temp = temp.next;

		Node node = new Node(val, temp.next);
		temp.next = node;
		size++;


	}


	// -----------------------------------------------Deletion
	public int deleteFirst()
	{
		int value = head.val;
		if(head == tail)
		{
			head = tail = null;
			size--;
			return value;
		}

		head = head.next;
		size--;
		return value;
	}


	//deleteLast will delete last node
	public int deleteLast()
	{
		int value = tail.val;
		if(head == tail)
		{
			tail = head = null;
			size--;
			return value;
		}

		Node temp = head;
		while(temp.next != tail)
			temp = temp.next;

		tail = temp;
		tail.next = null;
		size--;
		return value;
	}


	// delete node from specific index
	public int delete(int index)
	{
		if(index == 0)
			return deleteFirst();
		if(index == size-1)
			return deleteLast();

		Node temp =  head;
		for(int i = 1; i<index; i++)
		{
			temp = temp.next;
		}


		int value = temp.next.val;
		temp.next = temp.next.next;

		return value;
	}


	// ------------------------------------------------display
	//display function
	public void display()
	{
		Node temp = head;
		while(temp != null)
		{
			System.out.print(temp.val + " -> ");
			temp = temp.next;

		}

		System.out.print("null");
	} 


	//Main function
	public static void main(String[] args)
	{
		P1_CustomLinkedList ll = new P1_CustomLinkedList();
		ll.insertFirst(1);
		ll.insertFirst(2);
		ll.insertFirst(3);
		ll.insertFirst(4);
		ll.insertLast(5);

		//4 -> 3 -> 2 -> 1 -> null

		// ll.insert(90, 3);
		ll.display();
		System.out.println();
		// System.out.println(ll.size);

		ll.delete(3);
		ll.display();
		System.out.println();
		System.out.println(ll.size);

	}
}