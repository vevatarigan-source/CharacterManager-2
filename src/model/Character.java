import java.util.Objects;

public class Character {
    private int id;
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;
    private int mana;

    public Character(String name, CharacterType type, int level) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong.");
        }

        this.name = name.trim();
        this.type = Objects.requireNonNull(type, "Tipe tidak boleh null.");
        this.mana = 0;
        setLevel(level);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong.");
        }
        this.name = name.trim();
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = Objects.requireNonNull(type);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException("Level minimal 1.");
        }

        this.level = level;
        this.hitPoints = 100 + level * 10;
        this.attackPower = 10 + level * 5;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException("Mana tidak boleh negatif.");
        }
        this.mana = mana;
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Character)) {
            return false;
        }

        Character other = (Character) obj;
        return name.equalsIgnoreCase(other.name);
    }

    @Override
    public int hashCode() {
        return name.toLowerCase(java.util.Locale.ROOT).hashCode();
    }

    @Override
    public String toString() {
        return "Nama: " + name
                + " | Tipe: " + type
                + " | Level: " + level
                + " | HP: " + hitPoints
                + " | Attack: " + attackPower
                + " | Mana: " + mana;
    }
}
