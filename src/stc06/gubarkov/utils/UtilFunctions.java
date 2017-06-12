package stc06.gubarkov.utils;

import java.util.Random;

public class UtilFunctions {
    public static Long generateId() {
        Random r = new Random();
        return System.currentTimeMillis() + r.nextInt();
    }

    public static int generateHashCode(Long id) {
        Random r = new Random();
        int firstArg = r.nextInt(101) / 2;
        firstArg = firstArg % 2 == 0 ? firstArg + 1: firstArg;
        int secondArg = r.nextInt(101) / 2;
        secondArg = secondArg % 2 == 0 ? secondArg + 1: secondArg;
        return (int)(firstArg + (id * secondArg));
    }
}
