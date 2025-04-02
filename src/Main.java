import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Creating an array for game starting prompt
        boolean gameRun = true;
        while (gameRun) {

            System.out.print("Input command: ");
            String[] gameStartPrompt = scanner.nextLine().split(" ");
            if (gameStartPrompt.length < 3 && gameStartPrompt[0].equals("exit")) {
                break;
            } else if (gameStartPrompt.length < 3) {
                System.out.println("Bad Parameters!");
            }
            else {
                String typeX = gameStartPrompt[1];
                String typeO = gameStartPrompt[2];
                if (!isValidType(typeX) || !isValidType(typeO)) {
                    System.out.println("Bad Parameters!");
                    continue;
                }
                TicTacToeGame game = new TicTacToeGame(typeX, typeO, scanner);
                game.play();
            }
        }
    }

    private static boolean isValidType(String type) {
        return type.equals("user") || type.equals("easy") || type.equals("medium");
    }
}