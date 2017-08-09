package LinkList.SinglyLinkedList;
public class SinglyLinkedList_average {
	public static Integer[] random(int n)
	{
		Integer[] element=new Integer[n];
		for(int i=0;i<n;i++)
			element[i]=new Integer((int)(Math.random()*100));
		return element;
	}
	public static double averageExceptMaxMin(SinglyLinkedList<Integer> list)
	{
		if(list.isEmpty())
			throw new IllegalArgumentException("不能对空单链表计算平均值。");
		int sum=0,i=0,max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
		Node<Integer> p=list.head.next;
		while(p!=null)
		{
			int value=p.data.intValue();
			sum+=value;
			if(value>max)
				max=value;
			if(min>value)
				min=value;
			p=p.next;
			i++;
		}
		if(i==1||i==2)
			return(double)sum/i;
		return (double)(sum-max-min)/(i-2);
	}
	public static void main(String args[])
	{
		SinglyLinkedList<Integer> list=new SinglyLinkedList<Integer>(random(10));
		System.out.println(list.toString());
		System.out.println("加权平均数是："+averageExceptMaxMin(list));;
	}
	
}
