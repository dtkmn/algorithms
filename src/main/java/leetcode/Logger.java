package leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/logger-rate-limiter/
 */
public class Logger {

    private Map<String, Integer> map;

    public Logger() {
        map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer found = map.get(message);
        if (found == null) {
            map.put(message, timestamp);
            return true;
        } else {
            if (timestamp - found >= 10) {
                map.put(message, timestamp);
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Logger logger = new Logger();
        System.out.println(logger.shouldPrintMessage(1, "foo"));
        System.out.println(logger.shouldPrintMessage(2, "bar"));
        System.out.println(logger.shouldPrintMessage(3, "foo"));
        System.out.println(logger.shouldPrintMessage(8, "bar"));
        System.out.println(logger.shouldPrintMessage(10, "foo"));
        System.out.println(logger.shouldPrintMessage(11, "foo"));
    }

}
