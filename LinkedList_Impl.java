package linked_list;

import java.util.LinkedList;

public class LinkedList_Impl {
	
	Node head  ;
	
	public class Node {
		int data ;
		Node next ;
		
		// constructor created 
		Node(int data) {
			this.data =  data ;
			this.next = null ;
		}
	}
	
	public void insertFirst(int data) {
		Node newNode = new Node(data) ;
		head = newNode ;	
	}
	
	
	public void insertLast(int data) {
		Node newNode  = new Node(data);
		
		if(head == null) {
			newNode.next = head ;
			head = newNode  ;
			return;
		}
		
		Node currNode = head;
		
		while(currNode.next != null) {
			currNode = currNode.next ;
		}
		
		currNode.next  = newNode;
		newNode.next  = null ;
	}
	
	
	
	// insert in middle of the node 
	
	public void insertMiddle(int data , int position) {
		if (position == 0) {
			insertFirst(data);
			return;
		}
		
		Node newNode = new Node(data);
		Node currNode = head;
		
		for (int i = 0; i < position - 1; i++) {
			if (currNode != null) {
				currNode = currNode.next;
			} else {
				System.out.println("Position out of bounds");
				return;
			}
		}
		
		if (currNode != null) {
			newNode.next = currNode.next;
			currNode.next = newNode;
		} else {
			System.out.println("Position out of bounds");
		}
	}
	
	
	// remove element from linked list 
	
	public void removeElement(int val) {
		
		// Agar list khali ho tb 
		if(head == null) {
			System.out.println("List is empty.");
			return ;
		}
		
//		agar list ke head ko delete karna ho tb 
		if(head.data == val ) {
			head = head.next ;
			return ;
		}
		
//		agar list mai bich ya last ka data remove karna ho tb 
		
		Node currNode  = head.next ;
		Node prevNode = head ;
		
		while(currNode != null) {
			if(currNode.data == val) {
				prevNode.next = currNode.next ;
				return ;
			}
			
			currNode = currNode.next;
			prevNode = prevNode.next ;
		}
		
	}
	
	// Linked list ki size find karne ke liye 
	
	public  int  sizeOfLL() {
		int i = 0 ;
		Node newNode = head ;
		
		while(newNode != null) {
			i++;
			newNode = newNode.next ;
		}
		
		return i ;
	}
	
	
	// Printing function linked list 
	public void printList() {
		Node currNode = head ;	
		while(currNode != null ) {
			System.out.print(currNode.data+" -> ");
			currNode = currNode.next ;
		}
		
		System.out.println("null");
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> list = new LinkedList<>() ;
		
		list.add(5);
		list.add(10);
		list.add(80);
		list.add(20);
		
		System.out.println("Present element in linked list : "+list) ;
		
		
		// Object creation of customList new 
		LinkedList_Impl list2 = new LinkedList_Impl();   
		
		// insert first in LL
        list2.insertFirst(10);
        System.out.print("Element present in programmer LL is : ");
        list2.printList();
        
        // insert in last of the LL
        
        list2.insertLast(20);
        System.out.print("Element present in programmer LL is : ");
        list2.printList();
        
        
        // insert in the middle of the LL
        list2.insertMiddle(35, 1);
        System.out.print("Element present in programmer LL is : ");
        list2.printList();
        list2.insertMiddle(45, 2);
        list2.insertMiddle(48, 3);
        list2.insertMiddle(55, 4);
        list2.insertMiddle(60, 5);
        list2.printList();
        
        // Size of the linked list ;
        
        int size = list2.sizeOfLL() ;
        System.out.println("Size of LL : "+size) ;
   
        
        // Remove element from linked list
        list2.removeElement(35);
        size = list2.sizeOfLL() ;
        System.out.println("Size of LL : "+size) ;
        System.out.print("After removing element from LL : ");
        list2.printList();

        list2.removeElement(10);
         size = list2.sizeOfLL() ;
        System.out.println("Size of LL : "+size) ;
        System.out.print("After removing element from LL : ");
        list2.printList();

        list2.removeElement(100); // Element not present in the list
	}

}
