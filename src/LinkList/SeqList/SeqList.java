package LinkList.SeqList;

import LinkList.LList;


public class SeqList<T> implements LList<T> {
	public Object[] element;
	private int len;
	public SeqList(int size)
	{
		this.element=new Object[size];
		this.len=0;
	}
//浅拷贝
//	public SeqList(SeqList<T> list)
//	{
//		this.element=list.element;
//		this.len=list.len;
//	}
	//深拷贝
	public SeqList(SeqList<T> list)
	{
		this.element=new Object[list.element.length];
		this.len=list.len;
		for(int i=0;i<list.len;i++)
		{
			this.element[i]=list.element[i];
		}
	}
	public SeqList() {
		this(64);
	}
	public SeqList(T[] element)
	{
		this.element=new Object[element.length*2];
		this.len=element.length;
		for(int i=0;i<element.length;i++)
		{
			this.element[i]=element[i];
		}
	}
	public boolean isEmpty() {
		return this.len==0;
	}
	public int length()
	{
		return this.len;
	}
	public T get(int i)
	{
		if(i>=0&&i<this.len)
		{
			return (T)this.element[i];
		}
		return null;
	}
	public void set(int i,T x)
	{
		if(x==null)
			return;
		if(i>=0&&i<this.len)
			this.element[i]=x;
		else
			throw new IndexOutOfBoundsException(i+"");
	}
	public String toString()
	{
		String str="(";
		if(this.len>0)
		{
			str+=this.element[0].toString();
		}
		for(int i=1;i<this.len;i++)
		{
			str+=","+this.element[i].toString();
		}
		return str+")";
	}
	public int indexOf(T key)
	{
		if(key!=null)
			for(int i=0;i<this.len;i++)
			{
				if(this.element[i].equals(key))
					return i;
			}
		return -1;
	}
	public T search(T key)
	{
		int find=this.indexOf(key);
		return find==-1?null:(T)this.element[find];
	}
	public T remove(int i)
	{
		if(this.len==0||i<0||i>this.len)
			return null;
		T old=(T)this.element[i];
		for(int j=i;j<this.len-1;j++)
		{
			this.element[j]=this.element[j+1];
		}
		this.element[this.len-1]=null;
		this.len--;
		return old;
	}
	public void removeAll()
	{
		this.len=0;
	}
	public void append(T x)
	{
		insert(this.len,x);
	}
	
	public void insert(int i,T x)
	{
		if(x==null)
			return;
		if(this.len==element.length)
		{
			Object[] temp=this.element;
			this.element=new Object[temp.length*2];
			for(int j=0;j<temp.length;j++)
			{
				this.element[j]=temp[j];
			}
		}
		if(i<0)
		{
			i=0;
		}
		if(i>this.len)
		{
			i=this.len;
		}
		for(int j=this.len-1;j>=i;j--)
		{
			this.element[j+1]=this.element[j];
		}
		this.element[i]=x;
		this.len++;
	}
	public boolean equals(Object obj)
	{
		if(this==obj)
			return true;
		if(obj instanceof SeqList)
		{
			SeqList<T>list = (SeqList<T>)obj;
			if(this.length()==list.length())
			{
				for(int i=0;i<this.length();i++)
				{
					if(!(this.get(i).equals(list.get(i))))
						return false;
					return true;
				}
			}
		}
		return false;
	}
}

