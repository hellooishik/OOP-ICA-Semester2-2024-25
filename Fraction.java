package ood.fractions;

public class Fraction {
    private int numerator;
    private int denominator;

    // Constructor
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Accessors
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    // Addition of fractions
    public Fraction add(Fraction other) {
        int newNumerator = (this.numerator * other.denominator) + (other.numerator * this.denominator);
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Compare fractions
    public int compare(Fraction other) {
        int left = this.numerator * other.denominator;
        int right = other.numerator * this.denominator;
        return Integer.compare(left, right);
    }

    // Simplify fraction
    public int[] simplify() {
        int gcd = gcd(numerator, denominator);
        return new int[]{numerator / gcd, denominator / gcd};
    }

    // GCD function
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // toString method
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
