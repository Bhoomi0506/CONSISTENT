public class story {
    private Scene startScene;

    public Story() {
        // Define the scenes and their connections
        Scene scene1 = new Scene("You are in a forest. You see a path to the north and south.");
        Scene scene2 = new Scene("You encounter a river. You can swim across or go back.");
        Scene scene3 = new Scene("You find a cave. It's dark inside.");

        scene1.addOption("Go north", scene2);
        scene1.addOption("Go south", scene3);
        scene2.addOption("Swim across", null);  // Game ends if they swim
        scene2.addOption("Go back", scene1);
        scene3.addOption("Enter the cave", null);  // Game ends if they enter
        scene3.addOption("Go back", scene1);

        startScene = scene1;
    }

    public Scene getStartScene() {
        return startScene;
    }
}

    
}
