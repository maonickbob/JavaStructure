package LinkList.SinglyLinkedList;

import LinkList.LList;

public class SinglyLinkedList<T> implements LList<T>{
	public Node<T> head;
	public SinglyLinkedList()
	{
		this.head=new Node<T>();
	}
	//浅拷贝
	//public SinglyLinkedList(SinglyLinkedList<T> list)
    //{
	//	this.head=list.head;
	//}
	//深拷贝
	public SinglyLinkedList(SinglyLinkedList<T> list)
    {
		   this();
		   Node<T> p=list.head.next;
		   Node<T> q=this.head;
		   while(p!=null)
		   {
			   q.next=new Node<T>(p.data,null);
			   q=q.next;
			   p=p.next;
		   }
	   }
	public SinglyLinkedList(T []element)
	{
		this();
		Node<T> rear=this.head;
		for(int i=0;i<element.length;i++)
		{
			rear.next=new Node<T>(element[i],null);
			rear=rear.next;
		}
	}
	
	public boolean isEmpty()
	{
		return this.head.next==null;
	}
	public int length()
	{
		int i=0;
		Node<T> p=this.head.next;
		while(p!=null)
		{
			i++;
			p=p.next;
		}
		return i;
	}
	public String toString()
	{
		String str="(";
		Node<T> p=this.head.next;
		while(p!=null)
		{
			str+=p.data.toString();
			if(p.next!=null)
				str+=",";
			p=p.next;
		}		
		return str+=")";
	}
	public T get(int i)
	{
		if(i>=0)
		{
			Node<T> p=this.head.next;
			for(int j=0;p!=null&&j<i;j++)
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
			Node<T> p=this.head.next;
			for(int j=0;p!=null&&j<i;j++)
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
	   Node<T> p=this.head.next;
	   for(int j=0;j<i&&p.next!=null;j++)
	   {
		   p=p.next;
	   }
	   p.next=new Node<T>(x,p.next);
   }
   public void append(T x)
   {
	   insert(Integer.MAX_VALUE,x);
   }
   public T remove(int i)
   {
	   if(i>=0)
	   {
		   Node<T> p=this.head;
		   for(int j=0;j<i&&p.next!=null;j++)
		   {
			   p=p.next;
		   }
		   if(p.next!=null)
		   {
			   T old=p.next.data;
			   p.next=p.next.next;
			   return old;
		   }
	   }
	   return null;
   }
   public void removeAll()
   {
	   this.head.next=null;
   }
   public T search(T key)
   {
	   Node<T> p=this.head.next;
		if(key!=null)
		{
			while(p.next!=null)
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
	   if(!(obj instanceof SinglyLinkedList))
		   return false;
	   Node<T> p=this.head.next;
	   Node<T> q=((SinglyLinkedList<T>)obj).head.next;
	   while(p!=null&&q!=null&&p.data.equals(q.data))
	   {
		   p=p.next;
		   q=q.next;
	   }
	   return p==null&&q==null;
   }

}
