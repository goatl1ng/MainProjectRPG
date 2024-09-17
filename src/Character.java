public abstract class Character {
    protected String name;
    protected int agility;
    protected int health;
    protected int experience;
    protected int gold;
    protected int strength;

    public Character(String name, int agility, int health, int strength) {
        this.name = name;
        this.agility = agility;
        this.health = health;
        this.strength = strength;
        this.experience = 0;
        this.gold = 0;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }

    public int attack() {
        int chance = (int) (Math.random() * 100);
        if (agility * 3 > chance) { // Успешная атака
            boolean isCritical = Math.random() < 0.2; // 20% шанс критического удара
            int damage = isCritical ? strength * 2 : strength;
            System.out.println(isCritical ? "Критический удар!" : "Успешная атака.");
            return damage;
        }
        System.out.println("Промах.");
        return 0; // Промах
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
}
