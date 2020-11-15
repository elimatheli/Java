package utils;

/**
 * Provides methods to manipulate numbers
 *
 * @author Eliot Viseux, Thomas Vanderplancke
 */
public class Numbers {

    /**
     * Verify if a given int is a power of 2
     * @param n     The int we want to verify
     * @return      True if n is a power of 2, False if not
     */
    public static boolean isPowerOf2(int n) {
        if (n == 1) return true;

        else if (n % 2 != 0 || n == 0) return false;

        return isPowerOf2(n / 2);
    }
}
