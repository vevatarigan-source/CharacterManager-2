import java.util.ArrayList;
import java.util.List;

public class CharacterManager {
    private final ArrayList<Character> characters = new ArrayList<>();

    public boolean addCharacter(Character character) {
        if (character == null || findByName(character.getName()) != null) {
            return false;
        }

        characters.add(character);
        return true;
    }

    public Character findByName(String name) {
        if (name == null) {
            return null;
        }

        for (Character character : characters) {
            if (character.getName().equalsIgnoreCase(name.trim())) {
                return character;
            }
        }

        return null;
    }

    public boolean removeCharacter(String name) {
        Character character = findByName(name);

        if (character == null) {
            return false;
        }

        characters.remove(character);
        return true;
    }

    public int getTotalCharacters() {
        return characters.size();
    }

    /** Mengembalikan salinan daftar agar daftar asli tetap terlindungi. */
    public List<Character> getAllCharacters() {
        return new ArrayList<>(characters);
    }

    /** Menghitung rata-rata level semua karakter; 0 jika daftar kosong. */
    public double getAverageLevel() {
        if (characters.isEmpty()) {
            return 0.0;
        }

        int totalLevel = 0;

        for (Character character : characters) {
            totalLevel += character.getLevel();
        }

        return (double) totalLevel / characters.size();
    }

    public ArrayList<Character> findByType(CharacterType type) {
        ArrayList<Character> result = new ArrayList<>();

        for (Character character : characters) {
            if (character.getType() == type) {
                result.add(character);
            }
        }

        return result;
    }

    public Character findStrongest() {
        Character strongest = null;

        for (Character character : characters) {
            if (strongest == null
                    || character.getLevel() > strongest.getLevel()) {
                strongest = character;
            }
        }

        return strongest;
    }

    public int countByType(CharacterType type) {
        int count = 0;

        for (Character character : characters) {
            if (character.getType() == type) {
                count++;
            }
        }

        return count;
    }
}
