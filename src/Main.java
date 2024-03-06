import java.security.SecureRandom;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // Store the name that is checked
        String name = nameChecking();

        // Store the numbers that are checked
        int[] numbers = numChecking();

        // Store input file name
        String inputFileName = inputFileName();

        // Store output file name
        String outputFileName = outputFileName();

        // Store Password and Write in file
        // Open the output file and write in
    }

    public static String nameChecking() {
        Scanner nameScanner = new Scanner(System.in);
        String name = "";
        boolean isValidName = false;

        // Keep prompting the dialogue until user enters the right name
        while (!isValidName) {
            System.out.println("""
                    ================================================================================
                    Step 1: Please type your name includes your first name and last name:
                          - Your first and last name has to in a range between 1 and 50 characters;
                          - Your names can not include any numbers or special characters;
                          - Use space to separate your first and last name.
                     -------------------------------------------------------------------------------""");

            name = nameScanner.nextLine();
            String regex = "^[a-zA-Z]{1,50}\\s[a-zA-Z]{1,50}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher nameMatch = pattern.matcher(name);

            // If the pattern matches, prompt the message and store return the name
            if (nameMatch.matches()) {
                isValidName = true;
                System.out.println("<" + name + ">" + " is a valid name.");
            } else {
                System.out.println("<" + name + ">" + " is NOT a valid first and last name, please try again.");
            }
        }
        return name;
    }


    public static int[] numChecking() {
        // The regular expression for checking the int numbers
        String regex = "^-?\\d{1,3}(,\\d{3})*$";
        Pattern pattern = Pattern.compile(regex);

        int numberOne = 0;
        int numberTwo = 0;

        boolean isValidNum1 = false;
        boolean isValidNum2 = false;

        // Keep prompting the dialogue until user enters a valid number
        while (!isValidNum1) {
            System.out.println("""
                    ===================================================================================================
                    Step 2: Please type in two int values step by step (range between -2,147,483,648 to 2,147,483,647):
                          - Please type your FIRST int value:
                    ---------------------------------------------------------------------------------------------------""");
            Scanner num1Scanner = new Scanner(System.in);
            String num1 = num1Scanner.nextLine();

            if (num1.isEmpty()) {
                System.out.println("You entered nothing.");
            } else {
                Matcher num1Match = pattern.matcher(num1);
                boolean isNum1Match = num1Match.matches();
                if (isNum1Match) {
                    try {
                        // Before parsing in the number into int type, get rid of "," between numbers
                        String replaceComma = num1.replace(",","");
                        numberOne = Integer.parseInt(replaceComma);
                        isValidNum1 = true;
                        System.out.println("Your FIRST number " + "<" + numberOne + ">" + " is valid.");
                        // If it failed the parsing, catch the error and prompt the message
                    } catch (NumberFormatException e) {
                        System.out.println("The FIRST number is out or bound.");
                    }
                } else {
                    System.out.println("The First number your entered is an invalid number, please try again.");
                }
            }
        }

        while (!isValidNum2) {
            System.out.println("""
                     ===========================================
                          - Please type your SECOND int value:
                    --------------------------------------------""");
            Scanner num2Scanner = new Scanner(System.in);
            String num2 = num2Scanner.nextLine();

            if (num2.isEmpty()) {
                System.out.println("You entered nothing.");
            } else {
                Matcher num2Match = pattern.matcher(num2);
                boolean isNum2Match = num2Match.matches();
                if (isNum2Match) {
                    try {
                        String replaceComma = num2.replace(",","");
                        numberTwo = Integer.parseInt(replaceComma);
                        isValidNum2 = true;
                        System.out.println("Your SECOND number" + "<" + numberTwo + ">" + " is valid.");
                    } catch (NumberFormatException e) {
                        System.out.println("The SECOND number is out or bound.");
                    }
                } else {
                    System.out.println("The SECOND number your entered is an invalid number, please try again.");
                }
            }
        }
        return new int[]{numberOne, numberTwo};
    }

    public static String inputFileName () {

        boolean isValidInput = false;
        String inputFileName = "";

        while (!isValidInput) {
            System.out.println("""
                ======================================================================================
                Step 3: Please input a valid name for your INPUT File:
                      - The file name can't include: <, >, :, ", /, \\, |, ?, *
                ----------------------------------------------------------------------------""");
            Scanner inputScanner = new Scanner(System.in);
            inputFileName = inputScanner.nextLine();

            if (inputFileName.isEmpty()) {
                System.out.println("You entered am empty INPUT file name.");
            } else {
                String regex = "^[^<>:,\"/\\\\|?*\\x00-\\x1F]+\\w{1,255}$";//？
                Pattern pattern = Pattern.compile(regex);
                Matcher inputNameMatch = pattern.matcher(inputFileName);
                boolean isInputNameMatch = inputNameMatch.matches();
                if (isInputNameMatch) {
                    isValidInput = true;
                    System.out.println("You entered a valid INPUT file name.");
                } else {
                    System.out.println("The INPUT file name you entered is not valid, please try again.");
                }
            }
        }
        return inputFileName;
    }

    public static String outputFileName () {
        boolean isValidOutput = false;
        String outputFileName = "";

        while (!isValidOutput) {
            System.out.println("""
                ======================================================================================
                Step 4: Please input a valid name for your OUTPUT File:
                      - The file name can't include: <, >, :, ", /, \\, |, ?, *
                ----------------------------------------------------------------------------""");
            Scanner outputScanner = new Scanner(System.in);
            outputFileName = outputScanner.nextLine();

            if (outputFileName.isEmpty()) {
                System.out.println("You entered am empty OUTPUT file name.");
            } else {
                String regex = "^[^<>:,\"/\\\\|?*\\x00-\\x1F]+\\w{1,255}$";//？
                Pattern pattern = Pattern.compile(regex);
                Matcher outputNameMatch = pattern.matcher(outputFileName);
                boolean isOutputNameMatch = outputNameMatch.matches();
                if (isOutputNameMatch) {
                    isValidOutput = true;
                    System.out.println("You entered a valid OUTPUT file name.");
                } else {
                    System.out.println("The OUTPUT file name you entered is not valid, please try again.");
                }
            }
        }
        return outputFileName;
    }

    public static void handlePassword () {

        System.out.println("""
                ================================================================
                Step 5: Create a password that follow the rules below:
                      - Your password has to in between 8 to 255 characters
                      - At least 1 upper case letter
                      - At least 1 lower case letter
                      - At least 1 number
                      - At least 1 special letter
                ---------------------------------------------------------------""");

        Scanner passWordScanner = new Scanner(System.in);
        String password = passWordScanner.nextLine();
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$\n";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        boolean isValidPS = matcher.matches();

        if (password.isEmpty()) {
            System.out.println("You entered an empty password, try again");
        }



        SecureRandom secureRandom = SecureRandom()


    }



}