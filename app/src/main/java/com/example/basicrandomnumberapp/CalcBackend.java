package com.example.basicrandomnumberapp;

public class CalcBackend {

    double num1; // first number, before the operator
    double num2; // second number, after the operator

    boolean numflag = false; // false for first number, true for second number

    //set these flags if that is the current operation
    boolean multflag = false;
    boolean divflag = false;
    boolean subflag = false;
    boolean addflag = false;

    CalcBackend() {

    }

    //negate the number that is shown
    public void negate() {
        if (!numflag) {
            num1 = -num1;
        } else
            num2 = -num2;
    }

    public void backspace(String newnum) {
        if (!numflag) {
            num1 = Double.parseDouble(newnum);
        } else
            num2 = Double.parseDouble(newnum);
    }

    public void answer() {
        if (multflag) {
            num1 = num1 * num2;
            multflag = false;
        } else if (divflag) {
            num1 = num1 / num2;
            divflag = false;
        } else if (subflag) {
            num1 = num1 - num2;
            subflag = false;
        } else if (addflag) {
            num1 = num1 + num2;
            addflag = false;
        }

        numflag = false;
    }

}
