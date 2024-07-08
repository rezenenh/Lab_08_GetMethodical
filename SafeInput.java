import java.util.Scanner;
import java.util.regex.*;

public class SafeInput{

    public static String getNonEmptyString(Scanner scanner, String prompt) {
        String inputString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            inputString = scanner.nextLine().trim();
        } while (inputString.isEmpty());
        return inputString;
    }

    public static int getPositiveInt(Scanner scanner, String prompt) {
        int inputValue = 0;
        while (true) {
            try {
                System.out.print("\n" + prompt + ": ");
                inputValue = Integer.parseInt(scanner.nextLine());
                if (inputValue > 0) {
                    break;
                }
            } catch (NumberFormatException e) {
            }
        }
        return inputValue;
    }

    public static double getPositiveDouble(Scanner scanner, String prompt) {
        double inputValue = 0;
        while (true) {
            try {
                System.out.print("\n" + prompt + ": ");
                inputValue = Double.parseDouble(scanner.nextLine());
                if (inputValue > 0) {
                    break;
                }
            } catch (NumberFormatException e) {
            }
        }
        return inputValue;
    }

    public static int getIntWithinRange(Scanner scanner, String prompt, int low, int high) {
        int inputValue = 0;
        while (true) {
            inputValue = getPositiveInt(scanner, prompt);
            if (inputValue >= low && inputValue <= high) {
                break;
            }
        }
        return inputValue;
    }

    public static boolean getYesNoConfirmation(Scanner scanner, String prompt) {
        String inputString = "";
        while (true) {
            inputString = getNonEmptyString(scanner, prompt + " (y/n)").toLowerCase();
            if (inputString.equals("y") || inputString.equals("n")) {
                break;
            }
        }
        return inputString.equals("y");
    }

    public static String getRegexValidatedString(Scanner scanner, String prompt, String regex) {
        String inputString = "";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        do {
            inputString = getNonEmptyString(scanner, prompt);
            matcher = pattern.matcher(inputString);
        } while (!matcher.matches());
        return inputString;
    }
}