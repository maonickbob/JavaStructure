package LinkList.SortedSinglyLinkedList;

import LinkList.SinglyLinkedList.Node;
import LinkList.SinglyLinkedList.SinglyLinkedList;

public class SortedSinglyLinkedList<T extends Comparable<T>> extends SinglyLinkedList<T>{
	public SortedSinglyLinkedList()
	{
		super();
	}
	public SortedSinglyLinkedList(T []element)
	{
		super();
		if(element!=null)
			for(int i=0;i<element.length;i++)
				this.insert(element[i]);
	}
	public SortedSinglyLinkedList(SortedSinglyLinkedList<T> list)
	{
		super(list);
	}
	public void insert(T x)
	{
		if(x==null)
			return;
		Node<T> front=this.head,p=front.next;
		while(p!=null&&p.data.compareTo(x)<0)
		{
			front=p;
			p=p.next;
		}
		front.next=new Node<T>(x,p);
	}
	public void remove(T x)
	{
		if(x==null)
			return;
		Node<T> front=this.head,p=front.next;
		while(p!=null&&p.data.compareTo(x)<0)
		{
			front=p;
			p=p.next;
		}
		if(p!=null&&p.data.compareTo(x)==0)
			front.next=p.next;
	}
}
