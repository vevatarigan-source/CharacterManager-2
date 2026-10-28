import javax.swing.SwingUtilities;
import java.util.ArrayList;
import java.util.List;

enum CharacterType {
    WARRIOR,
    MAGE,
    ARCHER
}

class Character {
    private final String name;
    private final CharacterType type;
    private final int level;

    Character(String name, CharacterType type, int level) {
        this.name = name;
        this.type = type;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public CharacterType getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }
}

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CharacterManager manager = new CharacterManager();

            manager.addCharacter(
                new Character("Aragorn", CharacterType.WARRIOR, 5));
            manager.addCharacter(
                new Character("Merlin", CharacterType.MAGE, 8));
            manager.addCharacter(
                new Character("Legolas", CharacterType.ARCHER, 6));
            manager.addCharacter(
                new Character("Gandalf", CharacterType.MAGE, 7));
            manager.addCharacter(
                new Character("Thorin", CharacterType.WARRIOR, 10));

            // Periksa apakah data sudah masuk
            System.out.println("Total karakter: "
                    + manager.getTotalCharacters());

            MainWindow window = new MainWindow(manager);
            window.setVisible(true);
        });
    }
}

class CharacterManager {
    private final List<Character> characters = new ArrayList<>();

    public void addCharacter(Character character) {
        characters.add(character);
    }

    public int getTotalCharacters() {
        return characters.size();
    }
}
