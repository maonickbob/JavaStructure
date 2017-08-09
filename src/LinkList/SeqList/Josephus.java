package LinkList.SeqList;

public class Josephus {
     public Josephus(int number,int start,int distance)
     {
    	 SeqList<String>list = new SeqList<String>(number);
    	 for(int i=0;i<number;i++)
    	 {
    		 list.append((char)('A'+i)+"");
    	 }
    	 System.out.print("约瑟夫环("+number+","+start+","+distance+")");
    	 System.out.println(list.toString());
    	 int i=start;
    	 while(list.length()>1)
    	 {
    		 i=(i+distance-1)%list.length();
    		 System.out.print("删除"+list.remove(i).toString()+",");
    		 System.out.println(list.toString());
    	 }
    	 System.out.println("被赦免者是"+list.get(0).toString());
     }

     public static void main(String args[])
     {
    	 new Josephus(5,0,2);
    	 SeqList<String>list = new SeqList<String>(1);
    	 list.append("1");
    	 SeqList<String>list2 = new SeqList<String>(1);
    	 list2.append("1");
    	 System.out.println(list.equals(list2));;
     }
}
