package LinkList.DoublyLinkedList;

public class SortedDoublyLinkedList<T extends Comparable<T>>extends CirDoublyLinkedList{
	public SortedDoublyLinkedList()
	{
		super();
	}
	public SortedDoublyLinkedList(T []element)
	{
		super();
		for(int i=0;i<element.length;i++)
			this.insert(element[i]);
	}
	public SortedDoublyLinkedList(SortedDoublyLinkedList<T> list)
	{
		super(list);
	}
	public void insert(T x)
	{
		if(x==null)
			return;
		if(this.head.prev!=head&&x.compareTo((T) this.head.prev.data)>0)
		{
			DLinkNode q=new DLinkNode(x,head.prev,head);
			head.prev.next=q;
			head.prev=q;
		}
		DLinkNode<T> p=this.head.next;
		while(p!=head&&p.data.compareTo(x)<0)
			p=p.next;
		DLinkNode<T> q=new DLinkNode(x,p.prev,p);
		p.prev.next=q;
		p.prev=q;
	}
	public void remove(T x)
	{
		if(x==null) return;
		DLinkNode<T> p=this.head.next;
		while(p!=head&&p.data.compareTo(x)<0)
			p=p.next;
		if(p!=head&&p.data.compareTo(x)==0)
		{
			p.prev.next=p.next;
			p.next.prev=p.prev;
		}
			
	}
}
