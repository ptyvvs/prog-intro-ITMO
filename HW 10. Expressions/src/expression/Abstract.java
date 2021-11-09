package expression;

import java.util.List;
import java.util.Objects;

public abstract class Abstract implements UniteExpression {
    protected String sign;
    protected UniteExpression c,d;



    public Abstract(UniteExpression c, UniteExpression d) {
        this.c = c;
        this.d = d;
    }


    public int evaluate(int x, int y, int z){
        return operation (c.evaluate(x, y, z), d.evaluate(x, y, z));
    }


    public int evaluate(int x) {
        return operation(c.evaluate(x), d.evaluate(x));
    }

    public abstract int operation(int x, int y);

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Abstract that = (Abstract) obj;
        return this.c.equals(that.c) && this.d.equals(that.d) && this.sign.equals(that.sign);
    }

    @Override
    public String toString(){
        return new StringBuilder().append("(").append(c.toString()).append(" ").append(sign).append(" ").append(d.toString()).append(")").toString();
    }

    @Override
    public int hashCode() {
        return c.hashCode() * 31 + d.hashCode() * 17 + sign.hashCode() * 11 + 19;
    }
}
