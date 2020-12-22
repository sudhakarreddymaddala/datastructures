package ueb;

/**
 * @author ITE104673
 */
public class Main {

    public static void main(String[] args) {

        final int START = -1;
        final int END = 2;
        final int KEY = 163;
        final int LEN = getMax(calcLength(START), calcLength(END));


        System.out.println("The numbers in the range " + START + " and " + END + " are examined.");
        boolean validKeyTest = isValidKey(KEY);
        if (validKeyTest) {
            System.out.println("key = " + getBinaryString(KEY) + " (" + KEY + ")");
        } else {
            System.out.println(
                    "WARNING: encryption not possible, invalid key = " + getBinaryString(KEY) + " (" + KEY + ")");
        }
        for (int i = START; i <= END; i++) {
            // TODO: Remove all usages of Integer.toString - done
            int sumOfTheDigits = calculateDigitSum(i);
            boolean harshadNumber = isHarshadNumber(i);
            int numOfSteps = 0;
            int collatz = Collatz(i, numOfSteps);
            // TODO: Remove String.format (use "%" format specifiers in System.out.print directly) - done
            // FIXME: "sum of digits = %d" is missing the length specifier (given as constant in the assignment description) - done
            System.out.printf("%" + LEN + "d: sum of digits = %2d", i, sumOfTheDigits);
            if (i > 0) {
                // FIXME: "Collatz steps = " is missing format and length specifier (given as constant in the assignment description) - done
                System.out.printf(", Collatz steps = %3d",collatz );
            }
            if (harshadNumber) {
                System.out.print(", Harshad number");
            }
            System.out.println();
            if (validKeyTest) {
                int encrytedNumber = encrytion(i, KEY);
                String encrytionBinary = getBinaryString(encrytedNumber);
                int newSpaces = LEN + 2;
                if (encrytedNumber > 0) {
                    System.out.printf("%" + newSpaces + "s" + "encryption = %32s" + " ( " + encrytedNumber + ")%n", "", encrytionBinary);
                } else {
                    System.out.printf("%" + newSpaces + "s" + "encryption = %32s" + " (" + encrytedNumber + ")%n", "", encrytionBinary);
                }

            }
        }
    }

    /**
     * This method will give the maximum width.
     *
     * @param start start length
     * @param end   end length
     * @return maximum width
     */
    public static int getMax(int start, int end) {
        return start > end ? start : end;
    }

    /**
     * This methods provides the length of the given number
     *
     * @param number given number
     * @return length of given number
     */
    public static int calcLength(int number) {
        int length = number == 0 ? 1 : 0;

        if (number < 0) {
            number = -(number);
            length++;
        }
        while (number > 0) {
            length++;
            number /= 10;
        }
        return length;
    }

    /**
     * This method validates the key
     *
     * @param k given key
     * @return true if it is a valid key less than 9 bits
     */
    public static boolean isValidKey(int k) {
        /*
         * boolean validKey = false; int count = 8; while (k != 0) { count--; k >>= 1; }
         * int index = 1 + (count >> 31) - (-count >> 31); if (index != 0) { validKey =
         * true; return validKey; }
         */
        return k >> 8 == 0;
    }

    /**
     * This method returns the binary string of a key
     *
     * @param n - Accepts integer
     * @return - returns binary number
     */
    public static String getBinaryString(int n) {
        String binary = "";
        for (int i = 0; i <= 31 && n != 0; i++) {
            binary = (n & 1) + binary;
            n >>= 1;
            // TODO: extract lowest bit instead of highest, n >>= 1 instead of n <<=1 (check for n == 0 and stop) – no more leading zeroes. - done
        }
        return binary;
    }

    /**
     * This method will accepts two parameters and returns encrypted value.
     *
     * @param n   - will accepts Integer value
     * @param key - will accepts key which has been declared
     * @return - It will return the encrypted value
     */
    public static int encrytion(int n, int key) {
        /*
         * int encrytion = 0; if (n < 0) { for (int i = 0; i < 4; i++) { encrytion >>=
         * 8; encrytion += ((key ^ n) & 0b1111_1111) << 8*3 ; //n >>>= 8; } return
         * encrytion; } else { int count = 0; for (int j = n; j > -1; j--) { n--;
         * count++; } for (int i = 0; i < 4; i++) { encrytion >>= 8; encrytion += ((key
         * ^ n) & 0b1111_1111) << 8 * 3; // n >>>= 8; }
         */
        int partOne = (n & 0b11111111) ^ key;
        int partTwo = ((n >> 8) & 0b11111111) ^ key;
        int partThree = ((n >> 16) & 0b11111111) ^ key;
        int partFour = ((n >> 24) & 0b11111111) ^ key;

        int encrypt = ((partOne) | (partTwo << 8) | (partThree << 16) | (partFour << 24));
        return encrypt;
        //	return -(encrytion + count);
    }

    /**
     * This Method will accepts the integer and returns the sum of digits for both
     * negative and positive numbers
     *
     * @param number - It will accepts integer value
     * @return - returns the sum of number
     */
    public static int calculateDigitSum(int number) {
        int sum = 0, b;
        if (number < 0) {
            number = -(number);
        }
        while (number > 0) {
            b = number % 10;
            sum = sum + b;
            number = number / 10;
        }
        return sum;
    }

    /**
     * This method will accepts integer and if number divided by sum is zero the
     * returns true else returns false.
     *
     * @param number - accepts integer
     * @return - returns boolean value
     */
    public static boolean isHarshadNumber(int number) {
        if (number <= 0) {
            return false;
        } else {
            /*
             * while (number > 0) { b = number % 10; sum = sum + b; number = number / 10; }
             */
            int sum = calculateDigitSum(number);
            return (number % sum == 0);
        }
    }

    /**
     * This method will accepts the integer and if number greater then zero then
     * global flag is set true. If number is one then it will return zero. If number
     * is even then divides by two and repeat the step. If the number is odd then
     * multiplies the number with 3 and adds 1 to it and repeats the step.
     *
     * @param number - This accepts the integer value
     * @return - This will returns number of steps
     */
    private static int Collatz(int number, int numOfSteps) {
        if (number > 1) {
            if (number % 2 == 0) {
                numOfSteps++;
                numOfSteps = Collatz(number / 2, numOfSteps);
            } else {
                numOfSteps++;
                numOfSteps = Collatz((3 * number) + 1, numOfSteps);
            }
        }
        return numOfSteps;
    }

    public static int Collatz(int number) {
        return Collatz(number, 0);
    }
}