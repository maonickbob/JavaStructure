package LinkList.DoublyLinkedList;

public class DLinkNode<T>{
	public T data;
	public DLinkNode<T> prev,next;
	public DLinkNode(T data,DLinkNode<T> prev,DLinkNode<T> next)
	{
		this.data=data;
		this.prev=prev;
		this.next=next;
	}
	public DLinkNode()
	{
		this(null,null,null);
	}
} 
