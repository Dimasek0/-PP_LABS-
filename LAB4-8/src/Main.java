import com.Hnitetskyi.Utility.Menu;

import java.io.IOException;
import java.util.logging.LogManager;

public class Main {
    public static void main(String[] args) {
        try {
            LogManager.getLogManager().readConfiguration(
                    Menu.class.getResourceAsStream("/com/Hnitetskyi/Utility/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
        Menu menu = new Menu();
        menu.consoleMenu();
    }
}