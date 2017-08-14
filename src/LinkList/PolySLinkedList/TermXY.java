package LinkList.PolySLinkedList;

public class TermXY extends TermX implements Comparable<TermX>{
    protected int exp_y;
    public TermXY(int coef,int exp_y,int exp)
    {
        super(coef, exp);
        this.exp_y=exp_y;
    }

    @Override
    public String toString() {
        String str=super.toString();
        if(this.exp_y>0)
            str+="y";
        if(this.exp_y>1)
            str+="^"+this.exp_y;
        return str;
    }

    public int compareTo(TermXY term)
    {
        if(this.exp==term.exp&&this.exp_y==term.exp_y)
            return 0;
        return(this.exp<term.exp||this.exp==term.exp&&this.exp_y<term.exp_y)?-1:1;
    }
    public boolean equals(Object obj)
    {
        return this==obj||obj instanceof TermXY&&super.equals(obj)&&this.exp_y==((TermXY)obj).exp_y;
    }
    public void add(TermXY term)
    {
        if(this.compareTo(term)==0)
            this.coef+=term.coef;
        else
            throw new IllegalArgumentException("两项的指数不同，不能相加。");
    }
}
