public class Hero extends Character {
    private int totalExperience; // Общий опыт
    private int totalGold;       // Общее золото

    public Hero(String name) {
        super(name, 100, 1000, 200); // Пример значений ловкости, здоровья и силы
        this.totalExperience = 0;
        this.totalGold = 0;
    }

    public void gainExperience(int exp) {
        experience += exp;
        totalExperience += exp; // Увеличиваем общий опыт
        checkLevelUp(); // Проверяем, достиг ли герой уровня для повышения характеристик
    }

    private void checkLevelUp() {
        // Каждые 100 опыта увеличиваем характеристики
        while (experience >= 100) {
            experience -= 100; // Уменьшаем текущий опыт на 100
            increaseStats();
        }
    }

    private void increaseStats() {
        agility += 1;
        strength += 1;
        health += 10;
        System.out.println("Поздравляем! Ваш герой повысил уровень.");
        System.out.println("Ловкость увеличена на 1, сила увеличена на 1, здоровье увеличено на 10.");
        System.out.println("Текущие характеристики: Ловкость: " + agility + ", Сила: " + strength + ", Здоровье: " + health);
    }

    public void earnGold(int amount) {
        gold += amount;
        totalGold += amount; // Увеличиваем общее золото
    }

    public void heal(int amount) {
        health += amount;
    }

    public void increaseAgility(int amount) {
        agility += amount;
    }

    public void increaseStrength(int amount) {
        strength += amount;
    }

    public int getTotalExperience() {
        return totalExperience;
    }

    public int getTotalGold() {
        return totalGold;
    }

    public int getGold() {
        return gold;
    }

    public int getExperience() {
        return experience;
    }

    public int getAgility() {
        return agility;
    }

    public int getStrength() {
        return strength;
    }

    public int getHealth() {
        return health;
    }
}
