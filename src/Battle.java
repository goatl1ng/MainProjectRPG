public class Battle implements Runnable {
    private Hero hero;
    private Monster monster;

    public Battle(Hero hero, Monster monster) {
        this.hero = hero;
        this.monster = monster;
    }

    @Override
    public void run() {
        while (hero.isAlive() && monster.isAlive()) {
            System.out.println("Герой атакует...");
            monster.takeDamage(hero.attack());
            if (!monster.isAlive()) {
                System.out.println("Монстр " + monster.getName() + " побежден!");
                hero.gainExperience(10);
                hero.earnGold(20);
                System.out.println("Вы получили 10 опыта и 20 золота.");
                System.out.println("Общий опыт: " + hero.getTotalExperience() + ", Общее золото: " + hero.getTotalGold());
                return;
            }

            System.out.println("Монстр атакует...");
            hero.takeDamage(monster.attack());
            if (!hero.isAlive()) {
                System.out.println("Вас убили. Конец игры.");
                return;
            }
        }
    }
}
