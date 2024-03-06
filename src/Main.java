import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
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

        // Create an input file, check and confirm a password and store the hashed password inside of input file

        // Write all the required results in output file
        writeOutputFile(outputFileName,inputFileName,name,numbers);

    }

    public static String nameChecking() {
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
            Scanner nameScanner = new Scanner(System.in);
            name = nameScanner.nextLine();
            String regex = "^[a-zA-Z]{1,50}\\s[a-zA-Z]{1,50}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher nameMatch = pattern.matcher(name);
            boolean isNameMatch = nameMatch.matches();

            // If the pattern matches, prompt the message and store return the name
            if (isNameMatch) {
                isValidName = true;
                System.out.println("<" + name + ">" + " is a valid name.");
            } else {
                System.out.println("<" + name + ">" + " is NOT a valid first and last name, please try again.");
            }
        }
        return name;
    }


    public static int[] numChecking() {
        String num1 = "";
        String num2 = "";

        boolean isValidNum1 = false;
        boolean isValidNum2 = false;

        int numberOne = 0;
        int numberTwo = 0;

        String regex = "^(-?\\d{1,3}(,\\d{3})*){1,14}$";
        Pattern pattern = Pattern.compile(regex);

        // Keep prompting the dialogue until user enters a valid number
        while (!isValidNum1) {
            System.out.println("""
                    ===================================================================================================
                    Step 2: Please type in two int values step by step (range between -2,147,483,648 to 2,147,483,647):
                          - Please type your FIRST int value:
                    ---------------------------------------------------------------------------------------------------""");
            Scanner num1Scanner = new Scanner(System.in);
            num1 = num1Scanner.nextLine();
            Matcher num1Match = pattern.matcher(num1);
            boolean isNum1Match = num1Match.matches();
            if (isNum1Match) {
                try {
                    // Before parsing in the number into int type, get rid of "," between numbers
                    numberOne = Integer.parseInt(num1.replace(",", ""));
                    isValidNum1 = true;
                    System.out.println("Your FIRST number " + "<" + numberOne + ">" + " is valid.");
                } catch (NumberFormatException e) {
                    System.out.println("The FIRST number is out or bound, please try again.");
                }
            } else {
                System.out.println("The First number is NOT valid, please try again.");
            }

        }

        while (!isValidNum2) {
            System.out.println("""
                     ===========================================
                          - Please type your SECOND int value:
                    --------------------------------------------""");
            Scanner num2Scanner = new Scanner(System.in);
            num2 = num2Scanner.nextLine();
            Matcher num2Match = pattern.matcher(num2);
            boolean isNum2Match = num2Match.matches();

            if (isNum2Match) {
                try {
                    // Before parsing in the number into int type, get rid of "," between numbers
                    numberTwo = Integer.parseInt(num2.replace(",", ""));
                    isValidNum2 = true;
                    System.out.println("Your FIRST number " + "<" + numberTwo + ">" + " is valid.");
                } catch (NumberFormatException e) {
                    System.out.println("The FIRST number is out or bound, please try again.");
                }
            } else {
                System.out.println("The First number is NOT valid, please try again.");
            }
        }
        return new int[]{numberOne, numberTwo};
    }

    public static String inputFileName () {
        String inputFileName = "";
        boolean isValidInput = false;

        String regex = "^[^<>:\"/\\\\|?*!\\x00-\\x1F]{1,255}$";
        Pattern pattern = Pattern.compile(regex);

        while (!isValidInput) {
            System.out.println("""
                ============================================================================
                Step 3: Please input a valid name for your INPUT File:
                      - The file name can't include: <, >, :, ", /, \\, |, ?, *, !
                      - The file name must be shorter than 255 characters.
                ----------------------------------------------------------------------------""");
            Scanner inputScanner = new Scanner(System.in);
            inputFileName = inputScanner.nextLine();
            Matcher inputFileMatch = pattern.matcher(inputFileName);
            boolean isInputFileMatch = inputFileMatch.matches();

            if (isInputFileMatch) {
                isValidInput = true;
                System.out.println(inputFileName + " is a valid INPUT file name.");
            } else {
                System.out.println("This INPUT file name is NOT valid, please try again.");
            }
        }
        return inputFileName;
    }

    public static String outputFileName () {
        String outputFileName = "";
        boolean isValidOutput = false;

        String regex = "^[^<>:\"/\\\\|?*!\\x00-\\x1F]{1,255}$";
        Pattern pattern = Pattern.compile(regex);

        while (!isValidOutput) {
            System.out.println("""
                ======================================================================================
                Step 4: Please input a valid name for your OUTPUT File:
                      - The file name can't include: <, >, :, ", /, \\, |, ?, *, !
                      - The file name must be shorter than 255 characters.
                ----------------------------------------------------------------------------""");
            Scanner outputScanner = new Scanner(System.in);
            outputFileName = outputScanner.nextLine();
            Matcher inputFileMatch = pattern.matcher(outputFileName);
            boolean isOutputFileMatch = inputFileMatch.matches();
            if (isOutputFileMatch) {
                isValidOutput = true;
                System.out.println(outputFileName + " is a valid OUTPUT file name.");
            } else {
                System.out.println("This OUTPUT file name is NOT valid, please try again.");
            }
        }
        return outputFileName;
    }

    public static void passwordChecking() {
        String password = "";
        boolean isValidPS = false;

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,255}$";
        Pattern pattern = Pattern.compile(regex);

        while (!isValidPS) {
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
            password = passWordScanner.nextLine();
            Matcher passwordMatch = pattern.matcher(password);
            boolean isPasswordMatch = passwordMatch.matches();

            if (isPasswordMatch) {
                isValidPS = true;
                System.out.println("Your password is valid.");
            } else {
                System.out.println("Your Password format is invalid.");
            }
        }
    }

    public static void writeOutputFile(String outputFileName, String inputFileName, String name, int[] numbers) {

        try {
            FileWriter outputFile = new FileWriter(outputFileName + ".txt");
            String[] splitName = name.split(" ");
            String firstName = splitName[0];
            String lastName = splitName[1];
            outputFile.write("First Name: " + firstName + "\n");
            outputFile.write("Last Name: " + lastName + "\n");
            outputFile.write("First Integer: " + String.valueOf(numbers[0]) + "\n");
            outputFile.write("Second Integer: " + String.valueOf(numbers[1])+ "\n");
            // Sum, Product, Input File Name, Input file contents
            long sum = numbers[0] + numbers[1];
            outputFile.write("Sum of two integers: " + sum + "\n");
            long product = (long) numbers[0] * numbers[1];
            outputFile.write("Product of two integer: " + product + "\n");
            outputFile.write("Input file name: " + inputFileName + "\n");
            outputFile.write("Input file content:" + "\n");
            outputFile.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }

    }
}