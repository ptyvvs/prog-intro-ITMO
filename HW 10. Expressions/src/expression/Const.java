package expression;

import expression.Abstract;

public class Const implements UniteExpression {
    private final int a;

    public Const(int a) {
        this.a = a;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return a;
    }

    @Override
    public int evaluate(int x) {
        return a;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Const that = (Const) obj;
        return this.a == that.a;
    }

    @Override
    public String toString() {
        return Integer.toString(a);
    }

    @Override
    public int hashCode() {
        return a * 251;
    }
}
