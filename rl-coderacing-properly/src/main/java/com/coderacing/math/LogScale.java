package com.coderacing.math;

public class LogScale {

    public static int index(double value, double minimal, double maximal, int count)
    {
        if (minimal < 0 || maximal < 0)
            throw new IllegalArgumentException("minimal maximal must be positive double");

        int sign = (int)Math.signum(value);

        if (Math.abs(value) < minimal)
            return 0;

        if (Math.abs(value) > maximal)
            return (count+1) * sign;

        double delta = ( Math.log(maximal) - Math.log(minimal))/count;

        return ((int) ( (Math.log(Math.abs(value)) - Math.log(minimal) )/delta) + 1) * sign;
    }

}
