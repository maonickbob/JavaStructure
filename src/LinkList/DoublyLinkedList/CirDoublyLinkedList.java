package LinkList.DoublyLinkedList;

import LinkList.LList;

public class CirDoublyLinkedList<T> implements LList<T>{
	public DLinkNode<T> head;
	public CirDoublyLinkedList()
	{
		this.head=new DLinkNode<T>();
		this.head.prev=head;
		this.head.next=head;
	}
	public CirDoublyLinkedList(CirDoublyLinkedList<T> list)
    {
		   this();
		   DLinkNode<T> p=list.head.next;
		   DLinkNode<T> q=this.head;
		   while(p.prev!=head)
		   {
			   q.next=new DLinkNode<T>(p.data,q,q.next);
			   q=q.next;
			   p=p.next;
		   }
	   }
	public boolean isEmpty()
	{
		return head.next==head;
	}
	public int length()
	{
		int i=0;
		DLinkNode<T> p=this.head.next;
		while(p!=head)
		{
			i++;
			p=p.next;
		}
		return i;
	}
	public String toString()
	{
		String str="(";
		DLinkNode<T> p=this.head.next;
		while(p!=head)
		{
			str+=p.data.toString();
			if(p.next!=head)
				str+=",";
			p=p.next;
		}		
		return str+=")";
	}
	public T get(int i)
	{
		if(i>=0)
		{
			DLinkNode<T> p=this.head.next;
			for(int j=0;p.next!=head&&j<i;j++)
			{
				p=p.next;
			}
				if(p!=null)
			{
				return p.data;	
			}
		}
				return null;		
	}
	public void set(int i,T x)
	{
		if(x==null)
		  return;
		if(i>=0)
		{
			DLinkNode<T> p=this.head.next;
			for(int j=0;p.next!=head&&j<i;j++)
			{
				p=p.next;
			}
			if(p!=null)
			{
				p.data=x;		
			}
		}
		else throw new IndexOutOfBoundsException(i+"");
	}
	
	
	
	public void insert(int i,T x)
	{
		if(x==null)
			return;
		DLinkNode<T> p=this.head;
		for(int j=0;p.next!=null&&j<i;j++)
		{
			p=p.next;
		}
		DLinkNode<T> q=new DLinkNode<T>(x,p,p.next);
		p.next.prev=q;
		p.next=q;
	}
	public void append(T x)
	{
		if(x==null)
			return;
		DLinkNode<T> q=new DLinkNode<T>(x,head.prev,head);
		head.prev.next=q;
		head.prev=q;
	}
	public T remove(int i)
	{
		if(i>=0)
		{
			DLinkNode<T> p=this.head.next;
			for(int j=0;p!=head&&j<i;j++)
			{
				p=p.next;
			}
			if(p!=head)
			{
				T old=p.data;
				p.prev.next=p.next;
				p.next.prev=p.prev;
				return old;
			}
		}
		return null;
	}
	public void removeAll()
	{
		this.head.prev=head;
		this.head.next=head;
	}
	 public T search(T key)
	   {
		 DLinkNode<T> p=this.head.next;
			if(key!=null)
			{
				while(p.next!=head)
				   {
					   if(p.data.equals(key))
					   {
						   return p.data;
					   }
					   p=p.next;
				   }
			}
			return null;
	   }
	 public boolean equals(Object obj)
	   {
		   if(obj==this)
			   return true;
		   if(!(obj instanceof CirDoublyLinkedList))
			   return false;
		   DLinkNode<T> p=this.head.next;
		   DLinkNode<T> q=((CirDoublyLinkedList<T>)obj).head.next;
		   while(p.next!=head&&q.next!=head&&p.data.equals(q.data))
		   {
			   p=p.next;
			   q=q.next;
		   }
		   return p==null&&q==null;
	   }
}
