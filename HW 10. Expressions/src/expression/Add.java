package expression;

import expression.Abstract;

public class Add extends Abstract {


    public Add(UniteExpression c, UniteExpression d) {
        super(c, d);
        sign = "+";
    }

    @Override
    public int operation(int n1, int n2) {
        return n1 + n2;
    }
}
