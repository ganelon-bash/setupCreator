package creator.util;

public class Math {
    public static long map(long val, long s1, long e1, long s2, long e2)
    {
        double b1 = e1 - s1;
        double b2 = e2 - s2;
        double c = val - s1;

        double res = ((c * (b2)) / b1) + s2;
        return (long) res;
    }
}
