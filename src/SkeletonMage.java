public class SkeletonMage extends Monster {
    public SkeletonMage() {
        super("Скелет-чародей", 25, 150, 50); // Пример значений ловкости, здоровья и силы
    }

    @Override
    public int attack() {
        System.out.println("Скелет-чародей использует магическую атаку!");
        return super.attack();
    }
}
