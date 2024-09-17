public class GoblinKing extends Monster {
    public GoblinKing() {
        super("Король гоблинов", 20, 200, 40); // Пример значений ловкости, здоровья и силы
    }

    @Override
    public int attack() {
        System.out.println("Король гоблинов совершает мощную атаку!");
        return super.attack();
    }
}
