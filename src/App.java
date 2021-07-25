import java.util.Scanner;

public class App {

    public static final Encryption start = new Encryption();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(getHelp());
        System.out.println("********************************************");
        char response;
        do {
            response = Character.toLowerCase(scanner.nextLine().charAt(0));

            switch (response) {
                case 'n':
                    start.newKey();
                    break;
                case 'g':
                    start.getKey();
                    break;
                case 'e':
                    start.encrypt();
                    break;
                case 'd':
                    start.decrypt();
                    break;
                case 'q':
                    start.quit();
                    break;
                case 'h':
                    System.out.println(getHelp());
                    break;
                default:
                    System.out.println("No idea what you want :(");
            }
        } while (response != 'q');
    }

    public static String getHelp() {
        return new StringBuilder("This app helps you encrypt and decrypt messages using char-substitution. Type what you want to do next:")
                .append("\n\t (h)elp > displays help message")
                .append("\n\t (n)ewKey > generates new key")
                .append("\n\t (g)etKey > displays generated key")
                .append("\n\t (e)ncrypt > encrypts given message")
                .append("\n\t (d)ecrypt > decrypts given message")
                .append("\n\t (q)uit > exits the app").toString();
    }
}

