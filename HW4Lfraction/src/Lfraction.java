import java.util.Objects;

import static java.lang.Double.compare;

/**
 * This class represents fractions of form n/d where n and d are long integer
 * numbers. Basic operations and arithmetics for fractions are provided.
 */
public class Lfraction implements Comparable<Lfraction> {

    /**
     * Main method. Different tests.
     */
    public static void main(String[] param) {
        System.out.println(valueOf("2/-4"));
        //System.out.println(valueOf("2/-4"));
    }

    private long numerator;
    private long denominator;

    /**
     * Constructor.
     *
     * @param a numerator
     * @param b denominator > 0
     */
    public Lfraction(long a, long b) {

        if (b == 0) throw new RuntimeException("murru nimetaja ei tohi olla 0");

        this.numerator = a;
        this.denominator = b;

        reduceFraction();
    }

    public void reduceFraction() {
        long a = numerator;
        long b = denominator;

        boolean inverted = false;

        if (b < 0 || a < 0) {
            if (b >= 0 || a >= 0) {
                inverted = true;
            }
            a = Math.abs(a);
            b = Math.abs(b);
        }

        numerator = a / findHighestCommonFactor(a, b);

        if (a == 0) denominator = 1;
        else if (b > 0) denominator = b / findHighestCommonFactor(a, b);

        if (inverted) numerator = numerator * -1;
    }


    public static long findHighestCommonFactor(long firstNumber, long secondNumber) {
        long smaller = Math.min(firstNumber, secondNumber);
        long highestCommonFactor = -1;

        for (long i = smaller; i > 0; --i) {
            if (firstNumber % i == 0 && secondNumber % i == 0) {
                highestCommonFactor = i;
                break;
            }
        }
        return highestCommonFactor;
    }

    /**
     * Public method to access the numerator field.
     *
     * @return numerator
     */
    public long getNumerator() {
        return numerator;
    }

    /**
     * Public method to access the denominator field.
     *
     * @return denominator
     */
    public long getDenominator() {
        return denominator;
    }

    /**
     * Conversion to string.
     *
     * @return string representation of the fraction
     */
    @Override
    public String toString() {
        return Long.toString(getNumerator()) + "/" + Long.toString(getDenominator());
    }

    /**
     * Equality test.
     *
     * @param m second fraction
     * @return true if fractions this and m are equal
     */
    @Override
    public boolean equals(Object m) {
//        if (m instanceof Lfraction) {
//            Lfraction n = (Lfraction) m;
//
//            return toString().equals(n.toString());
//        }
//        return false;

        if (m instanceof Lfraction) {
            Lfraction n = (Lfraction) m;
            return compareTo(n) == 0;
        }
        return false;
    }

    /**
     * Hashcode has to be equal for equal fractions.
     *
     * @return hashcode
     */
    @Override
    public int hashCode() {
//        long hash = 23;
//        hash = 31 * hash + getNumerator();
//        hash = 31 * hash + getDenominator();
//        return (int) hash;
        return Objects.hash(getNumerator(), getDenominator());
    }

    /**
     * Sum of fractions.
     *
     * @param m second addend
     * @return this+m
     */
    public Lfraction plus(Lfraction m) {
        long sumNum = getNumerator() * m.getDenominator() + getDenominator() * m.getNumerator();
        long sumDen = getDenominator() * m.getDenominator();

        return new Lfraction(sumNum, sumDen);
    }

    /**
     * Multiplication of fractions.
     *
     * @param m second factor
     * @return this*m
     */
    public Lfraction times(Lfraction m) {
        long mulNum = getNumerator() * m.getNumerator();
        long mulDen = getDenominator() * m.getDenominator();

        return new Lfraction(mulNum, mulDen);
    }

    /**
     * Inverse of the fraction. n/d becomes d/n.
     *
     * @return inverse of this fraction: 1/this
     */
    public Lfraction inverse() {
        if (getNumerator() == 0) throw new RuntimeException("Murru lugeja ei tohi olla 0");

        return new Lfraction(getDenominator(), getNumerator());
    }
    /**
     * Opposite of the fraction. n/d becomes -n/d.
     *
     * @return opposite of this fraction: -this
     */
    public Lfraction opposite() {
        return new Lfraction(getNumerator() * -1, getDenominator());
    }

    /**
     * Difference of fractions.
     *
     * @param m subtrahend
     * @return this-m
     */
    public Lfraction minus(Lfraction m) {
//        long subNum = getNumerator() * m.getDenominator() -  m.getNumerator() * getDenominator();
//        long subDen = getDenominator() * m.getDenominator();
//
//        return new Lfraction(subNum, subDen);

        return plus(m.opposite());
    }

    /**
     * Quotient of fractions.
     *
     * @param m divisor
     * @return this/m
     */
    public Lfraction divideBy(Lfraction m) {
//        if (m.getNumerator() != 0) {
//            long divNum = getNumerator() * m.getDenominator();
//            long divDen = getDenominator() * m.getNumerator();
//
//            return new Lfraction(divNum, divDen);
//        }
//        throw new RuntimeException("Jagaja " + m + " lugeja ei tohi olla 0");

        if (m.getNumerator() != 0) return times(m.inverse());
        throw new RuntimeException("Jagaja " + m + " lugeja ei tohi olla 0");
    }

    /**
     * Comparision of fractions.
     *
     * @param m second fraction
     * @return -1 if this < m; 0 if this==m; 1 if this > m
     */
    @Override
    public int compareTo(Lfraction m) {
        Lfraction lfraction = minus(m);

        if (lfraction.getNumerator() == 0) return 0;
        return lfraction.getNumerator() > 0 ? 1 : -1;
    }

    /**
     * Clone of the fraction.
     *
     * @return new fraction equal to this
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Lfraction(getNumerator(), getDenominator());
    }

    /**
     * Integer part of the (improper) fraction.
     *
     * @return integer part of this fraction
     */
    public long integerPart() {
        return (long) toDouble();
    }

    /**
     * Extract fraction part of the (improper) fraction
     * (a proper fraction without the integer part).
     *
     * @return fraction part of this fraction
     */
    public Lfraction fractionPart() {
        long x = getNumerator() % getDenominator();
        return new Lfraction(x, getDenominator());
    }

    /**
     * Approximate value of the fraction.
     *
     * @return numeric value of this fraction
     */
    public double toDouble() {
        return (double) getNumerator() / getDenominator();
    }

    /**
     * Double value f presented as a fraction with denominator d > 0.
     *
     * @param f real number
     * @param d positive denominator for the result
     * @return f as an approximate fraction of form n/d
     */
    public static Lfraction toLfraction(double f, long d) {
        return new Lfraction(Math.round(f * d), d);
    }

    /**
     * Conversion from string to the fraction. Accepts strings of form
     * that is defined by the toString method.
     *
     * @param s string form (as produced by toString) of the fraction
     * @return fraction represented by s
     */
    public static Lfraction valueOf(String s) {

        boolean count = countSlashes(s);

        if (count) throw new RuntimeException("Avaldis " + s + " on valel kujul");

        try {
            String[] arr = s.split("/");

            if (arr.length == 2) {
                long numerator = Long.parseLong(arr[0]);
                long denominator = Long.parseLong(arr[1]);
                return new Lfraction(numerator, denominator);
            } else {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            throw new RuntimeException("Avaldis " + s + " on valel kujul");
        }
    }

    private static boolean countSlashes(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '/') {
                count++;
            }
        }
        return count > 1;
    }
}