package heritage.ast;

/**
 * Fonction d'une variable.
 */
public abstract class Function
{
    /**
     * Retourne l'image de x.
     */
    public abstract double evaluate(double x);

    /**
     * Retourne la dérivée.
     */
    public abstract Function derivate();

    /**
     * Retourne la fonction simplifiée.
     */
    public abstract Function simplify();

    /**
     * Ssi la fonction ne contient pas de variable.
     */
    public abstract boolean isConstant();

    /**
     * Ssi la fonction est une feuille valant 0.
     */
    public abstract boolean isZero();

    /**
     * Ssi la fonction est une feuille valant 1.
     */
    public abstract boolean isOne();

    /**
     * Retourne l'integrale entre a et b (a < b), calculée avec la
     * méthode des trapèzes en effectuant nbSubdivisions
     * subdivisions de l'intervalle à intégrer.
     */
    public double integrate(double a, double b, int nbSubdivisions)
    {
        // TODO To test
        // Implemented from the formula from https://fr.wikipedia.org/wiki/Méthode_des_trapèzes
        assert(a < b);

        double step = (b - a) / nbSubdivisions;
        double quadError = -(Math.pow(b - a, 3) / (12 * Math.pow(nbSubdivisions, 2)));
        double e = (this.evaluate(a) + this.evaluate(b)) / 2;

        double sum = 0.0f;
        for (int i = 1; i < nbSubdivisions; i++) {
            sum += a + i * step;
        }

        return step * (e + sum) + quadError;
    }

    public static void main(String args[])
    {
        System.out.println("Hello world !");
    }
}

/**
 * f(x) = x.
 */

class Variable extends Function
{
    Variable()
    {
    }

    @Override
    public boolean isZero()
    {
        return false;
    }

    @Override
    public boolean isOne()
    {
        return false;
    }

    @Override
    public boolean isConstant()
    {
        return false;
    }

    @Override
    public Function derivate()
    {
        return new Constant(1);
    }

    @Override
    public double evaluate(double x)
    {
        return x;
    }

    @Override
    public Function simplify()
    {
        return this;
    }

    @Override
    public String toString()
    {
        return "x";
    }
}

/**
 * Fonction s'exprimant comme une opération binaire entre deux autres
 * fonctions.
 */

abstract class BinaryOperator extends Function
{
    protected Function leftSon;
    protected Function rightSon;

    BinaryOperator(Function leftSon, Function rightSon)
    {
    }

    /**
     * Retourne l'opérateur binaire sous forme de caractère ('+'
     * pour une addition '-' pour une soustraction, etc).
     */
    public abstract char toChar();

    @Override
    public String toString()
    {
        return "(" + leftSon + " " + toChar() + " " + rightSon + ")";
    }

    @Override
    public boolean isZero()
    {
        return false;
    }

    @Override
    public boolean isOne()
    {
        return false;
    }

    @Override
    public boolean isConstant()
    {
        return false;
    }

    /**
     * Remplace les sous-arbres par leurs versions simplifiées, retourne
     * une feuille si l'arbre est constant.
     */
    protected Function simplifySubTrees()
    {
        if (this.isConstant()) {
            return this;
        }
        leftSon = leftSon.simplify();
        rightSon = rightSon.simplify();
        return this;
    }

}

/**
 * f(x) = c, où c est une constante réelle.
 */

class Constant extends Function
{
    private double value;

    Constant(double value)
    {
        this.value = value;
    }

    @Override
    public boolean isZero()
    {
        return value == 0;
    }

    @Override
    public boolean isOne()
    {
        return value == 1;
    }

    @Override
    public boolean isConstant()
    {
        return true;
    }

    @Override
    public Function derivate()
    {
        return new Constant(0);
    }

    @Override
    public double evaluate(double x)
    {
        return value;
    }

    @Override
    public Function simplify()
    {
        return this;
    }

    @Override
    public String toString()
    {
        return String.valueOf(value);
    }
}

/**
 * f(x) = g(x) - h(x), où g et h sont les sous-arbres gauche et droit.
 */

class Minus extends BinaryOperator
{
    Minus(Function leftSon, Function rightSon)
    {
        super(leftSon, rightSon);
    }

    @Override
    public char toChar()
    {
        return '-';
    }

    @Override
    public double evaluate(double x)
    {
        return leftSon.evaluate(x) - rightSon.evaluate(x);
    }

    @Override
    public Function derivate()
    {
        return new Minus(leftSon.derivate(), rightSon.derivate()).simplify();
    }

    @Override
    public Function simplify()
    {
        if (leftSon.isZero()) {
            return new Times(new Constant(-1), rightSon);
        }
        if (rightSon.isZero()) {
            return leftSon;
        }
        // return new Minus(leftSon.simplify(), rightSon.simplify());
        return simplifySubTrees();
    }
}

/**
 * f(x) = g(x) + h(x), où g et h sont les sous-arbres gauche et droit.
 */

class Plus extends BinaryOperator
{
    Plus(Function leftSon, Function rightSon)
    {
        super(leftSon, rightSon);
    }

    @Override
    public char toChar()
    {
        return '+';
    }

    @Override
    public double evaluate(double x)
    {
        return leftSon.evaluate(x) + rightSon.evaluate(x);
    }

    @Override
    public Function derivate()
    {
        return new Plus(leftSon.derivate(), rightSon.derivate()).simplify();
    }

    @Override
    public Function simplify()
    {
        if (leftSon.isZero()) {
            return rightSon;
        }
        if (rightSon.isZero()) {
            return leftSon;
        }
        //return new Plus(leftSon.simplify(), rightSon.simplify());
        return simplifySubTrees();
    }
}

/**
 * f(x) = g(x) * h(x), où g et h sont les sous-arbres gauche et droit.
 */

class Times extends BinaryOperator
{
    Times(Function leftSon, Function rightSon)
    {
        super(leftSon, rightSon);
    }

    @Override
    public char toChar()
    {
        return '*';
    }

    @Override
    public double evaluate(double x)
    {
        return leftSon.evaluate(x) * rightSon.evaluate(x);
    }

    @Override
    public Function derivate()
    {
        return new Times(leftSon.derivate(), rightSon.derivate()).simplify();
    }

    @Override
    public Function simplify()
    {
        if (leftSon.isZero() || rightSon.isZero()) {
            return new Constant(0);
        }
        if (leftSon.isOne()) {
            return rightSon;
        }
        if (rightSon.isOne()) {
            return leftSon;
        }
        //return new Times(leftSon.simplify(), rightSon.simplify());
        return simplifySubTrees();
    }
}

/**
 * f(x) = g(x) / h(x), où g et h sont les sous-arbres gauche et droit.
 */

class Div extends BinaryOperator
{
    Div(Function leftSon, Function rightSon)
    {
        super(leftSon, rightSon);
    }

    @Override
    public char toChar()
    {
        return '/';
    }

    @Override
    public double evaluate(double x) throws ArithmeticException
    {
        if (rightSon.isZero()) {
            throw new ArithmeticException("Division by Zero");
        }
        return leftSon.evaluate(x) / rightSon.evaluate(x);
    }

    @Override
    public Function derivate()
    {
        return new Div(leftSon.derivate(), rightSon.derivate()).simplify();
    }

    @Override
    public Function simplify()
    {
        if (rightSon.isOne()) {
            return leftSon;
        }
        //return new Div(leftSon.simplify(), rightSon.simplify());
        return simplifySubTrees();
    }
}
