import java.util.*;

public class DoubleStack {

    public static void main(String[] args) {
        String s = "0 2 - 6 7 ROT + +";
        System.out.println(interpret(s));
        String t = "2 5 9 ROT + SWAP -";
        System.out.println(interpret(t));
        String u = "2 5 SWAP 4 ROT + +";
        System.out.println(interpret(u));
    }

    public LinkedList<Double> getStack() {
        return stack;
    }

    private final LinkedList<Double> stack;

    DoubleStack() {
        this.stack = new LinkedList<>();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        DoubleStack doubleStack = new DoubleStack();

        for (int i = getStack().size() - 1; i >= 0; i--) {
            doubleStack.getStack().push(getStack().get(i));
        }
        return doubleStack;
    }

    public boolean stEmpty() {
        return getStack().isEmpty();
    }

    public void push(double a) {
        getStack().add(a);
    }

    public double pop() {
        if (stEmpty())
            throw new AlgorithmException(Errors.EMPTY_STACK);
        return getStack().removeLast();
    }

    public void op(String s) {
        if (getStack().size() < 2) {
            throw new AlgorithmException(Errors.MISSING_ELEMENTS);
        }

        double op1 = pop();
        double op2 = pop();


//        if (s.equals("+")) push(op1 + op2);
//        else if (s.equals("-")) push(op1-op2);
//        else if (s.equals("*")) push(op2*op1);
//        else if (s.equals("/")) push(op1/op2);
//        else if (s.equals("swap")){
//            push(op2);
//            push(op1);
//        }
//        else if (s.equals("rot")){
//            try{
//                double op3 = pop();
//                push(op1);
//                push(op2);
//                push(op3);
//            } catch (Exception e) {
//                throw new AlgorithmException(Errors.MISSING_ELEMENTS);
//            }
//        } else {
//            throw new AlgorithmException(Errors.BAD_SYMBOL);
//        }


        switch (s) {
            case "SWAP":
                push(op1);
                push(op2);
                break;
            case "ROT":
                if (getStack().size() < 1) {
                    throw new AlgorithmException(Errors.MISSING_ELEMENTS);
                }
                double op3 = pop();
                push(op2);
                push(op1);
                push(op3);
                break;
            case "+":
                push(op1 + op2);
                break;
            case "-":
                push(op2 - op1);
                break;
            case "*":
                push(op1 * op2);
                break;
            case "/":
                push(op2 / op1);
                break;
            default:
                throw new AlgorithmException(Errors.BAD_SYMBOL);
        }
    }

    public double tos() {
        if (stEmpty())
            throw new IndexOutOfBoundsException("Magasinis ei ole elemente");
        return getStack().getLast();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof DoubleStack) {
            if (((DoubleStack) o).getStack().isEmpty() && getStack().isEmpty()) {
                return true;
            }

            if (((DoubleStack) o).getStack().size() != getStack().size()) return false;

            for (int i = 0; i < getStack().size(); i++) {
                if (!(((DoubleStack) o).getStack().get(i).equals(getStack().get(i)))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        if (stEmpty()) return "Magasin on tühi";

        StringBuilder result = new StringBuilder();
        for (Double aStack : getStack()) result.append(aStack).append(" ");
        return result.toString();
    }

    public static double interpret(String pol) throws AlgorithmException {
        if (pol == null) throw new AlgorithmException(Errors.NO_EQUATION, pol, Optional.empty());

        pol = pol.trim().replaceAll(" +", " ");


        if (pol.equals(" ") || pol.equals(""))throw new AlgorithmException(Errors.NO_EQUATION, pol, Optional.empty());

        List<String> polList = new ArrayList<>(Arrays.asList(pol.split(" ")));
        DoubleStack doubleStack = new DoubleStack();

        for (String element : polList) {
            if (doubleStack.isDouble(element)) {
                doubleStack.push(Double.parseDouble(element));
            } else {
                try {
                    doubleStack.op(element);
                } catch (AlgorithmException e) {
                    throw new AlgorithmException(e.getError(), pol, Optional.of(element));
                }
            }
        }
        if (doubleStack.getStack().size() > 1) throw new AlgorithmException(Errors.TOO_MANY_SYMBOLS, pol, Optional.empty());
        return doubleStack.getStack().pop();
    }

    public boolean isDouble(String element) {
        try {
            Double.parseDouble(element);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

class AlgorithmException extends RuntimeException {

    public AlgorithmException(String s) {
        super(s);
    }

    public Errors getError() {
        return error;
    }

    private Errors error;

    public AlgorithmException(Errors error) throws AlgorithmException {
        setError(error);
        throw this;
    }

    public AlgorithmException(Errors error, String pol, Optional<String> element) throws AlgorithmException {
        switch (error) {
            case MISSING_ELEMENTS -> throw new AlgorithmException("Ei piisa arve tehte " + Optional.of(element) + " jaoks avaldises " + pol);
            case BAD_SYMBOL -> throw new AlgorithmException("Vigane sümbol " + Optional.of(element) + " avaldises " + pol);
            case EMPTY_STACK -> throw new AlgorithmException("Magasinis ei ole elemente");
            case NO_EQUATION -> throw new AlgorithmException("avaldis puudub");
            case TOO_MANY_SYMBOLS -> throw new AlgorithmException("Avaldises on liiga palju arve. Avaldis: " + pol);
        }
    }

    private void setError(Errors error) {
        this.error = error;
    }
}

enum Errors {

    MISSING_ELEMENTS,
    BAD_SYMBOL,
    EMPTY_STACK,
    NO_EQUATION,
    TOO_MANY_SYMBOLS
}
