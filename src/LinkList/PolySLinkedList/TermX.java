package LinkList.PolySLinkedList;

public class TermX implements Comparable<TermX>,Addible<TermX> {
    protected  int coef,exp;
    public TermX(int coef,int exp)
    {
        this.coef=coef;
        this.exp=exp;
    }
    public TermX(String termstr)
    {
        if(termstr.charAt(0)=='+')
            termstr=termstr.substring(1);
        int i =termstr.indexOf('x');
        if(i==-1)
        {
            this.coef=Integer.parseInt(termstr);
            this.exp=0;
        }
        else
        {
            if(i==0)
                this.coef=1;
            else {
                String sub = termstr.substring(0, i);
                if (sub.equals('-'))
                    this.coef = -1;
                else
                    this.coef = Integer.parseInt(sub);
            }
            i= termstr.indexOf('^');
            if(i==-1)
                this.exp=1;
            else
                this.exp=Integer.parseInt(termstr.substring(i+1));
        }
    }
    public TermX(TermX term)
    {
        this(term.coef,term.exp);
    }
    public int compareTo(TermX term)
    {
        if(this.exp==term.exp)
            return 0;
        return this.exp<term.exp?-1:1;
    }

    public void add(TermX term)
    {
        if(this.compareTo(term)==0)
            this.coef+=term.coef;
        else
            throw new IllegalArgumentException("两项的指数不同，不能相加。");
    }
    //约定删除元素条件，不存储系数为0的项
    public boolean removable()
    {
        return this.coef==0;
    }
    public String toString()
    {
        String str=this.coef>0?"+":"-";
        if(this.exp==0||this.exp>0&&this.coef!=1&&this.coef!=-1)
            str+=Math.abs(this.coef);
        if(this.exp>0)
            str+="x";
        if(this.exp>1)
            str+="^"+this.exp;
        return str;
    }
    public boolean equals(Object obj)
    {
        if(this==obj)
            return true;
        if(!(obj instanceof TermX))
            return false;
        TermX term=(TermX)obj;
        return this.coef==term.coef&&this.exp==term.exp;
    }
}
