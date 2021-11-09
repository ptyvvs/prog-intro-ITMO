package expression;

import expression.Abstract;

public class Variable implements UniteExpression{
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        switch (this.name) {
            case ("x"): return x;
            case ("y"): return y;
            case ("z"): return z;
        }
        return 0;
    }

    @Override
    public int evaluate(int x) {
        return x;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Variable that = (Variable) obj;
        return this.name.equals(that.name);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode() * 73;
    }
}
