import java.util.Scanner;

public class Merchant {
    public void interact(Hero hero) {
        Scanner scanner = new Scanner(System.in);
        boolean shopping = true;

        while (shopping) {
            System.out.println("Добро пожаловать к торговцу! Что вы хотите купить?");
            System.out.println("1. Зелье здоровья - 10 золота");
            System.out.println("2. Зелье ловкости - 60 золота");
            System.out.println("3. Зелье здоровья - 30 золота");
            System.out.println("4. Зелье силы - 30 золота");
            System.out.println("0. Уйти");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (hero.getGold() >= 10) {
                        hero.earnGold(-10);
                        hero.heal(20); // Например, зелье здоровья восстанавливает 20 единиц здоровья
                        System.out.println("Вы купили зелье здоровья. Здоровье восстановлено на 20 единиц.");
                    } else {
                        System.out.println("Недостаточно золота для покупки.");
                    }
                    break;
                case 2:
                    if (hero.getGold() >= 60) {
                        hero.earnGold(-60);
                        hero.increaseAgility(5); // Например, зелье ловкости увеличивает ловкость на 5
                        System.out.println("Вы купили зелье ловкости. Ловкость увеличена на 5.");
                    } else {
                        System.out.println("Недостаточно золота для покупки.");
                    }
                    break;
                case 3:
                    if (hero.getGold() >= 30) {
                        hero.earnGold(-30);
                        hero.heal(50); // Например, второе зелье здоровья восстанавливает 50 единиц здоровья
                        System.out.println("Вы купили зелье здоровья. Здоровье восстановлено на 50 единиц.");
                    } else {
                        System.out.println("Недостаточно золота для покупки.");
                    }
                    break;
                case 4:
                    if (hero.getGold() >= 30) {
                        hero.earnGold(-30);
                        hero.increaseStrength(10); // Например, зелье силы увеличивает силу на 10
                        System.out.println("Вы купили зелье силы. Сила увеличена на 10.");
                    } else {
                        System.out.println("Недостаточно золота для покупки.");
                    }
                    break;
                case 0:
                    shopping = false;
                    System.out.println("Вы ушли от торговца.");
                    System.out.println("Оставшееся золото: " + hero.getGold());
                    break;
                default:
                    System.out.println("Неверный выбор.");
                    break;
            }
        }
    }
}
