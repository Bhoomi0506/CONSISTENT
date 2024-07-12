import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Story story = new Story();
        Scene currentScene = story.getStartScene();

        while (currentScene != null) {
            currentScene.display();
            System.out.println("Choose an option:");
            int choice = scanner.nextInt();
            currentScene = currentScene.chooseOption(choice);
        }

        System.out.println("The End");
    }
}
