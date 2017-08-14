package LinkList.PolySLinkedList;

import LinkList.SinglyLinkedList.Node;

public class Polynomical {
    PolySLinkedList<TermX> list;
    PolySLinkedList<TermXY> list1;
    public Polynomical()
    {
        this.list=new PolySLinkedList<TermX>();
    }
    public Polynomical(TermX []terms)
    {this.list=new PolySLinkedList<TermX>(terms);}
    public Polynomical(String polystr)
    {
        this();
        if(polystr==null||polystr.length()==0)
            return;
        Node<TermX> rear=this.list.head;
        int start=0,end=0;
        while(start<polystr.length()&&end<polystr.length())
        {
            int i=polystr.indexOf('+',end+1);
            if(i==-1)
                i=polystr.length();
            int j=polystr.indexOf('-',end+1);
            if(j==-1)
                j=polystr.length();
            end=i<j?i:j;
            rear.next=new Node<TermX>(new TermX(polystr.substring(start,end)),null);
            rear=rear.next;
            start=end;
        }
    }
    public String toString()
    {
        String str="";
        Node<TermX> p=this.list.head.next;
        while(p!=null)
        {
            str+=p.data.toString();
            p=p.next;
        }
        return str;
    }
    public void add(Polynomical poly){this.list.add(poly.list);}

}
