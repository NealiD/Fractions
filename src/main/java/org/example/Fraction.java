package org.example;

public class Fraction extends Number {
    private long n;
    private long d;

    public Fraction(long n, long d)
    {
        long gcd = Utils.gcd(n, d);
        this.d = d / gcd;
        this.n = n / gcd;
    }
    public Fraction add(Fraction other){
        return new Fraction(
                n*other.d + other.n*d,
                d*other.d);
    }
    public static Fraction parse(String s)
    {
        s = s.replace(" ","");
        String[] split = s.split("\\+");// "\\" se používá protože split neumí +, jde také použít Pattern.quote("+")
        Fraction sum = new Fraction(0,1);
        for (String part : split){
            Fraction partFraction;
            if (part.contains("%")){
                partFraction = new Fraction(
                        Long.parseLong(part.replace("%","")),
                        100);
            }
            else {
                String[] split2 = part.split("/");
                partFraction = new Fraction(
                        Long.parseLong(split2[0]),
                        Long.parseLong(split2[1]));
            }
            sum = sum.add(partFraction);
        }
        return sum;
    }
    @Override
    public String toString() {
        return n+"/"+d;
    }

    @Override
    public int intValue() {
        return (int)n / (int)d;
    }

    @Override
    public long longValue() {
        return n / d;
    }

    @Override
    public float floatValue() {
        return (float)n / (float)d;
    }

    @Override
    public double doubleValue() {
        return (double)n / (double)d;
    }
}
