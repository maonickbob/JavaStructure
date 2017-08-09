package LinkList.SinglyLinkedList;

public class SinglyLinkedList_reverse {
	public static <T> void reverse(SinglyLinkedList<T> list)
	{
		Node<T> p= list.head.next,succ=null,front=null;
		while(p!=null)
		{
			succ=p.next;
			p.next=front;
			front=p;
			p=succ;
		}
		list.head.next=front;
	}
	public static void main(String args[])
	{
		String values[]= {"A","B","C","D","E","F"};
		SinglyLinkedList<String> list=new SinglyLinkedList<String>(values);
		System.out.println("list:"+list.toString());
		reverse(list);
		System.out.println("逆转后"+list.toString());
	}
}
