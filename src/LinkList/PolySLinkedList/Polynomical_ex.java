package LinkList.PolySLinkedList;

public class Polynomical_ex {
    public static void main(String args[])
    {
        TermX aterms[]={new TermX(-7,9),new TermX(2,7),new TermX(-9,4),
        new TermX(1,2),new TermX(-1,1),new TermX(2,0)};
        Polynomical apoly=new Polynomical(aterms);
        System.out.println("A="+apoly.toString());
        Polynomical bpoly=new Polynomical("-1+x-x^2+10x^4-3x^8+5x^10+9x^11");
        System.out.println("B="+bpoly.toString());
        apoly.add(apoly);
        System.out.println("A+B="+apoly.toString());
    }
}
