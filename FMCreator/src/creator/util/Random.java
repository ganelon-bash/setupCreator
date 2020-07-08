package creator.util;

import java.util.ArrayList;

public class Random {
    private static final java.util.Random r = new java.util.Random();

    public static int randomInt(int min, int max)
    {
        return r.nextInt(max - min) + min;
    }
    public static long randomLong(long min, long max)
    {
        int i1 = randomInt(0, Integer.MAX_VALUE);
        int i2 = randomInt(0, Integer.MAX_VALUE);
        int m = Integer.MAX_VALUE;
        long val = ((m) * (i1)) + (i2) % m;

        return Math.map(val, 0, Long.MAX_VALUE, min, max);
    }
    public static <T> T randomValue(ArrayList<T> list){
        return list.get(randomInt(0, list.size()));
    }
}
