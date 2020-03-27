/**
 * Filename: TimeChecker.java
 * Author: Jack Yang
 * Date: March 25, 2020
 *
 * This interface sets up the convertion from milliseconds to a string
 * representation of the corresponding time.
 */
public interface TimeChecker {

    public static final int CONVERT_TO_SEC = 1000;
    public static final int CONVERT_TO_OTHERS = 60;

    public static final String MICROSECOND = " ms";
    public static final String SECOND = " s";
    public static final String MINUTE = " min";
    public static final String HOUR = " hour";

    /**
     * This method returns string representation of the cost time by the
     * given running time.
     *
     * @param time - the time between the game starts and ends
     *
     * @return String
     */
    public static String calculateTime(long time) {

        int ms = (int) time;
        int sec = ms / CONVERT_TO_SEC;
        int min = sec / CONVERT_TO_OTHERS;
        int hr = min / CONVERT_TO_OTHERS;

        if (hr == 0) {
            if (min == 0) {
                if (sec == 0) {
                    return ms + MICROSECOND;
                }
                else {
                    return sec + SECOND + ms % CONVERT_TO_SEC + MICROSECOND;
                }
            }
            else {
                return min + MINUTE + sec % CONVERT_TO_OTHERS + SECOND +
                    ms % CONVERT_TO_SEC + MICROSECOND;
            }
        }
        else {
            return hr + HOUR + min % CONVERT_TO_OTHERS + MINUTE +
                sec % CONVERT_TO_OTHERS + SECOND +
                    ms % CONVERT_TO_SEC + MICROSECOND;
        }
    }
}
