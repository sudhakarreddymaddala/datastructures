package ueb;

public class Main {

    public static int nearestSquare(int number) {
        int nearestSquareNumber = 0;
        int factor = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factor = i;
                if ((factor * factor) == number) {
                    nearestSquareNumber = number;
                }
            }
        }
        return nearestSquareNumber;
    }

    public static void main(String[] args) {
        int number = 17;
        if (number <= 0) {
            System.out.println("Nearest Square for " + number + " is : " + 0);
        } else {
            int counter = 0;
            while (true) {
                int num1 = number + counter;
                int num2 = number - counter;
                int result1 = nearestSquare(num1);
                int result2 = nearestSquare(num2);
                if (result1 == num1) {
                    System.out.println("Nearest Square for " + number + " is : " + nearestSquare(num1));
                    break;
                }
                if (result2 == num2) {
                    System.out.println("Nearest Square for " + number + " is : " + nearestSquare(num2));
                    break;
                }
                counter++;
            }

        }
    }
}