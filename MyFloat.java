package com.company;

public class MyFloat {
    private long mant;
    private long exp;
    private long myInt;
    private long myFract;
    private long maximum;
    private long minimum;
    public MyFloat(long mantissa, long exponent) {
        this.exp = exponent;
        this.mant = mantissa;
        this.myInt = (long)(this.mant / Math.pow(10, this.exp));
        this.myFract = (long)(this.mant % Math.pow(10, this.exp));
    }
    public void amount(MyFloat b) {
        long resultFraction = 0;
        long resultInteger = 0;
        int k = 0;
        if (this.exp <= b.exp) {
            maximum = b.exp;
            minimum = this.exp;
            myFract *= (long)(Math.pow(10, maximum - minimum));
        }
        else {
            maximum = this.exp;
            minimum = b.exp;
            b.myFract *= (long)(Math.pow(10, maximum - minimum));
        }
        resultFraction += myFract + b.myFract;
        for (long i = resultFraction; i < (long)(Math.pow(10, maximum - 1)) ; i *= 10) {
            k += 1;
        }
        if (resultFraction >= Math.pow(10, maximum)) {
            resultInteger += 1;
        }
        resultInteger += myInt + b.myInt;
        System.out.print(resultInteger + ".");
        for (int i = 0; i < k; i++) {
            System.out.print("0");
        }
        System.out.println(resultFraction);
    }
    public void difference(MyFloat b) {
        long resultFraction = 0;
        long resultInteger = 0;
        int c = 0;
        if (this.exp <= b.exp) {
            maximum = b.exp;
            minimum = this.exp;
            myFract *= (long)(Math.pow(10, maximum - minimum));
        }
        else {
            maximum = this.exp;
            minimum = b.exp;
            b.myFract *= (long)(Math.pow(10, maximum - minimum));
        }
        if (myInt >= b.myInt) {
            if (myFract >= b.myFract) {
                resultFraction += (myFract - b.myFract);
            }
            else {
                myFract += (long)(Math.pow(10, maximum));
                myInt -= 1;
                resultFraction += myFract - b.myFract;
            }
            resultInteger += myInt - b.myInt;
        }
        if (myInt < b.myInt) {
            if (myFract >= b.myFract) {
                resultFraction += (long)(Math.pow(10, maximum)) - (myFract - b.myFract);
                resultInteger += myInt - b.myInt + 1;
            }
            else {
                resultFraction += b.myFract - myFract;
                resultInteger += myInt - b.myInt;
            }
        }
        if (resultFraction != 0) {
            for (long i = resultFraction; i < (long)(Math.pow(10, maximum - 1)) ; i *= 10) {
                c += 1;
            }
            System.out.print(resultInteger + ".");
            for (int i = 0; i < c; i++) {
                System.out.print("0");
            }
            System.out.println(resultFraction);
        }
        else {
            System.out.print(resultInteger + "." + resultFraction);
        }
    }
}
