package LinkList.PolySLinkedList;

import LinkList.SinglyLinkedList.Node;
import LinkList.SortedSinglyLinkedList.SortedSinglyLinkedList;

public class PolySLinkedList<T extends Comparable<T> & Addible<T>> extends SortedSinglyLinkedList<T>{
    public PolySLinkedList()
    {
        super();
    }
    public PolySLinkedList(T []terms)
    {
        super(terms);
    }

    public PolySLinkedList(PolySLinkedList<T> polylist)
    {
        super(polylist);
    }
    public void add(PolySLinkedList<T> polylist) {
        Node<T> front = this.head, p = front.next;
        Node<T> q = polylist.head.next;
        while (p != null && q != null) {
            if (p.data.compareTo(q.data) == 0) {
                p.data.add(q.data);
                if (p.data.removable()) {
                    front.next = p.next;
                    p = front.next;
                } else {
                    front = p;
                    p = p.next;
                }
                q = q.next;
            }
            else if(p.data.compareTo(q.data)<0)
            {
                front=p;
                p=p.next;
            }
            else
            {
                front.next=new Node<T>(q.data,p);
                q=q.next;
            }
        }
        while(q!=null)
        {
            front.next=new Node<T>(q.data,null);
            front=front.next;
            q=q.next;
        }
    }
}
