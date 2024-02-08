import java.util.*;

public class Main {
    //==============================================================================
    //Write a program that accepts a keyboard input and displays the
    // keyboard input only if it is a number (0-9) or letter (X or Y).
    // When letter entered is x, it should print X, if letter is y,
    // it should print Y. If letter is X should print as is X, and Y as Y.
    public static void acceptKeyboard(char[] array){
        List<Character> list = new ArrayList<>(Arrays.asList('0','1','2','3','4','5','6','7','8','9','X','Y'));
        for (char c: array){
            if (c == 'x'){
                System.out.print("X ");
            } else if (c == 'y'){
                System.out.print("Y ");
            }
            if (list.contains(c)){
                System.out.print(c + " ");
            }
        }
        System.out.println();
    }
    private static char[] array = new char[9];
    private static boolean has_a_winner = false;
    public static boolean isStringNumber (String s){
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) < '0' || s.charAt(i) > '9'){
                return false;
            }
        }
        return true;
    }

    public static void acceptKeyboard2(String index, String string){
        if (isStringNumber(index)) {
            int number = Integer.parseInt(index);
            int length = array.length;
            char c = string.charAt(0);

            if (number >= 0 && number < 9) {
                System.out.println(index);
                if (string.equalsIgnoreCase("x")) {
                    System.out.println("X");
                    array[number] = Character.toUpperCase(c);
                } else if (string.equalsIgnoreCase("y")) {
                    System.out.println("Y");
                    array[number] = Character.toUpperCase(c);
                } else {
                    System.out.println("Invalid letter input. Please enter between X and Y only");
                }
            } else {
                System.out.println("Invalid Index number input");
                return;
            }
            for (int i = 0; i < length; i++) {
                System.out.print(array[i]);
                if ((i + 1) % 3 == 0) {
                    System.out.println();
                }
            }
            if (checkWinner()) {
                System.out.println("We have a winner!");
                has_a_winner = true;
            }
        } else {
            System.out.println("Error");
        }

    }
    public static boolean checkWinner() {
        // Check rows
        //EEE
        //EEE
        //EEE
        for (int i = 0; i < 9; i += 3) {
            if (array[i] != 'E' && array[i] == array[i + 1] && array[i + 1] == array[i + 2]) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (array[i] != 'E' && array[i] == array[i + 3] && array[i + 3] == array[i + 6]) {
                return true;
            }
        }

        // Check diagonals
        if (array[0] != 'E' && array[0] == array[4] && array[4] == array[8]) {
            return true;
        }
        if (array[2] != 'E' && array[2] == array[4] && array[4] == array[6]) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String input ="";
        String number ="";
        Arrays.fill(array,'E');
        for (int i = 0; i < 9; i++) {
            System.out.print("E");
            if ((i + 1) % 3 == 0){
                System.out.println();
            }
        }
        while (!input.equalsIgnoreCase("e") && !number.equalsIgnoreCase("e") && !has_a_winner) {

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a number between 0-8: ");
            number = sc.nextLine();
            System.out.print("Enter a letter between X and Y: ");
            input = sc.nextLine();
            acceptKeyboard2(number,input);
        }
    }
}