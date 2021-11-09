package expression;

import expression.Abstract;

public class Subtract extends Abstract {

    public Subtract(UniteExpression c, UniteExpression d) {
        super(c, d);
        sign = "-";
    }

    @Override
    public int operation(int n1, int n2) {
        return n1 - n2;
    }
}
