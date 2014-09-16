package com.dema121;

import java.util.List;

/**
 * Created by dema121 on 15/09/14.
 */
public class Fraction {
    private int numerator, denominator;

    public Fraction(int numerator, int denominator) {
        setNumerator(numerator);
        setDenominator(denominator);
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    /**
     * Euclide algorithm to find the MCD of 2 numbers using the subtraction method
     * @param m the fist number
     * @param n the second number
     * @return MCD
     */

    private static int cMCD(int m, int n) {
        if (m > n) {
            return cMCD(m - n, n);
        } else if (m < n) {
            return cMCD(n, m);
        } else {
            return m;
        }
    }
    private static int calculateMCD(int m, int n) {
        if (m < 0)
            m *= -1;
        if (n < 0)
            n *= -1;
        return cMCD(m,n);
    }

    public void simplify() {
        int mcd = calculateMCD(getNumerator(), getDenominator());
        int newNumerator = getNumerator()/mcd;
        int newDenominator = getDenominator()/mcd;
        if (newNumerator < 0 && newDenominator < 0) {
            newNumerator *= -1;
            newDenominator *= -1;
        }
        setNumerator(newNumerator);
        setDenominator(newDenominator);
    }

    public void sum(Fraction fraction) {
        int newNumerator = getNumerator() * fraction.getDenominator() + fraction.getNumerator() * getDenominator();
        int newDenominator = getDenominator() * fraction.getDenominator();
        setNumerator(newNumerator);
        setDenominator(newDenominator);
        simplify();
    }

    public static Fraction sumFractions(Fraction... fractions) {
        for (int i = 1; i < fractions.length; i++) {
            fractions[i].sum(fractions[i - 1]);
        }
        return fractions[fractions.length - 1];
    }

    public static Fraction sumFractions(List<Fraction> fractions) {
        for (int i = 1; i < fractions.size(); i++) {
            fractions.get(i).sum(fractions.get(i - 1));
        }
        return fractions.get(fractions.size() - 1);
    }

    @Override
    public String toString() {
        return getNumerator() + "/" + getDenominator();
    }
}
