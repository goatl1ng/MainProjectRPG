import java.util.Scanner;

public class Game {
    private Hero hero;
    private Merchant merchant;
    private int battleCount; // Счетчик количества боев

    public Game() {
        this.merchant = new Merchant();
        this.battleCount = 0; // Начальное количество боев
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) { // Основной цикл игры
            createHero(scanner);  // Создание персонажа

            boolean playing = true;
            while (playing) {
                System.out.println("Куда вы хотите пойти?");
                System.out.println("1. К торговцу");
                System.out.println("2. В тёмный лес");
                System.out.println("3. На выход");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Вы пришли к торговцу.");
                        merchant.interact(hero);
                        break;
                    case 2:
                        System.out.println("Вы вошли в темный лес...");
                        System.out.println("Текущие характеристики:");
                        System.out.println("Ловкость: " + hero.getAgility());
                        System.out.println("Сила: " + hero.getStrength());
                        System.out.println("Здоровье: " + hero.getHealth());

                        // Определяем монстра, каждые 5 боев будет появляться особенный монстр
                        Monster monster;
                        if (battleCount > 0 && battleCount % 5 == 0) {
                            // С вероятностью 50% выбираем особенного монстра
                            monster = Math.random() < 0.5 ? new GoblinKing() : new SkeletonMage();
                        } else {
                            // Обычные монстры
                            monster = Math.random() < 0.5 ? new Goblin() : new Skeleton();
                        }

                        System.out.println("На вас напал " + monster.getName());
                        Battle battle = new Battle(hero, monster);
                        Thread battleThread = new Thread(battle);
                        battleThread.start();
                        try {
                            battleThread.join(); // Ждем завершения боя
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        // Увеличиваем счетчик боев, если герой выжил
                        if (hero.isAlive()) {
                            battleCount++;
                        } else {
                            playing = false; // Завершить текущий цикл, вернуться к созданию персонажа
                        }
                        break;
                    case 3:
                        playing = false; // Завершить игру
                        break;
                    default:
                        System.out.println("Неверный выбор.");
                        break;
                }
            }

            // Если герой был убит, возвращаемся к созданию нового персонажа
            if (!hero.isAlive()) {
                System.out.println("Возвращение к созданию нового героя...");
            } else {
                System.out.println("Игра окончена.");
                break; // Выход из игры при завершении по желанию игрока
            }
        }

        scanner.close();
    }

    private void createHero(Scanner scanner) {
        System.out.println("Введите имя вашего героя:");
        scanner.nextLine();  // Очистка буфера ввода после чтения числа
        String name = scanner.nextLine();
        hero = new Hero(name);
        System.out.println("Герой " + name + " создан.");
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
