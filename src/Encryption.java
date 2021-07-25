import java.util.*;

public class Encryption {

    private Scanner scanner;
    private Random random;
    private ArrayList<Character> asciiList;
    private ArrayList<Character> shuffledList;
    private char firstChar;
    private char[] userInput;

    Encryption() {
        scanner = new Scanner(System.in);
        random = new Random();
        asciiList = new ArrayList();
        shuffledList = new ArrayList();
        // 'space' has ASCII code of 32 - this is where we'll start
        firstChar = ' ';
        newKey();
    }


    void newKey() {
        //setting first char back to space (in case this is not the 1st run)
        firstChar = ' ';
        asciiList.clear();
        shuffledList.clear();
        //goes through chars with ascii code from 32 (space) to 126 (~) and adds them to the list
        for (int i = 32; i < 127; i++) {
            asciiList.add(firstChar);
            firstChar++;
        }
        shuffledList = new ArrayList(asciiList);
        Collections.shuffle(shuffledList);
        System.out.println("*A new Key has been generated*\n");
    }

    void getKey() {
        // prints ascii chars from 32 to 126 and their corresponding chars from shuffled list
        System.out.println("Key : ");
        for (Character x : asciiList) {
            System.out.print(x);
        }
        System.out.println();
        for (Character x : shuffledList) {
            System.out.print(x);
        }
        System.out.println();
    }

    void encrypt() {
        System.out.println("Enter a message to be encrypted: ");
        String message = scanner.nextLine();
        userInput = message.toCharArray();

        // goes through each char from the user input
        for (int i = 0; i < userInput.length; i++) {
            // searches for these chars in the ascii list
            for (int j = 0; j < asciiList.size(); j++) {
                if (asciiList.get(j).equals(userInput[i])) {
                    // and replaces them with the corresponding letters from the shuffled list
                    userInput[i] = shuffledList.get(j);
                    break;
                }
            }
        }
        System.out.println("Encrypted: ");

        for (char x : userInput) {
            System.out.print(x);
        }
        System.out.println();
    }

    void decrypt() {
        System.out.println("Enter a message to be decrypted: ");
        String message = scanner.nextLine();
        userInput = message.toCharArray();

        for (int i = 0; i < userInput.length; i++) {

            for (int j = 0; j < shuffledList.size(); j++) {
                if (shuffledList.get(j).equals(userInput[i])) {
                    userInput[i] = asciiList.get(j);
                    break;
                }
            }
        }
        System.out.println("Decrypted: ");
        for (char x : userInput) {
            System.out.print(x);
        }
        System.out.println();
    }

    void quit() {
        System.out.println("Have a nice day bro!");
        System.exit(0);
    }

}