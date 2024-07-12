import java.util.ArrayList;
import java.util.List;

public class Scene {
    private String text;
    private List<String> options;
    private List<Scene> nextScenes;

    public Scene(String text) {
        this.text = text;
        this.options = new ArrayList<>();
        this.nextScenes = new ArrayList<>();
    }

    public void addOption(String option, Scene nextScene) {
        options.add(option);
        nextScenes.add(nextScene);
    }

    public void display() {
        System.out.println(text);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ": " + options.get(i));
        }
    }

    public Scene chooseOption(int choice) {
        if (choice < 1 || choice > options.size()) {
            System.out.println("Invalid choice. Try again.");
            return this;
        }
        return nextScenes.get(choice - 1);
    }
}


