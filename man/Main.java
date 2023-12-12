import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner in = new Scanner (System.in);
        Man SomeMan = null;
        String user_command; // команда пользователя
        // бесконечный цикл
        boolean flag_exit = true;
        byte flag_alive = 0;
        while (flag_exit) {
            System.out.println("Для помощи введите команду help.");
            System.out.print("Пожалуйста, введите команду: ");
            user_command = in.next(); // получение команды
            System.out.println();
            switch (user_command) {
                case "exit" -> flag_exit = false;
                case "help" -> {
                    System.out.println("Список команд:");
                    System.out.println("---");
                    System.out.println("create_man: создать человека");
                    System.out.println("kill_man: убить человека");
                    System.out.println("isalive_man: жив ли данный человек");
                    System.out.println("talk: поговорить с человеком");
                    System.out.println("go: отправиться куда-то");
                    System.out.println("---");
                    System.out.println("---");
                    System.out.println();
                }
                case "create_man" -> {
                    if (SomeMan != null) {
                        SomeMan.Kill();
                        flag_alive = 0;
                    }
                    System.out.print("Введите имя создаваемого человека: ");
                    user_command = in.next();
                    SomeMan = new Man(user_command);
                    System.out.println("Человек успешно создан");
                    System.out.println();
                }
                case "kill_man" -> {
                    if (SomeMan != null && flag_alive == 0) {
                        SomeMan.Kill();
                        flag_alive++;
                        System.out.println("Вы убили " + SomeMan.Name);
                        System.out.println();
                    }
                    else if (flag_alive != 0) {
                        System.out.println("Вы уже убили " + SomeMan.Name);
                        System.out.println("Создайте нового");
                        System.out.println();
                    }
                    else {
                        System.out.println("Людей не осталось. Создайте нового человека!");
                        System.out.println();
                    }
                }
                case "isalive_man" -> {
                    if (SomeMan != null)
                        if (SomeMan.isAlive()) {
                            System.out.println("Человек " + SomeMan.Name + " ещё жив");
                            System.out.println();
                        }
                        else {
                            System.out.println("Ой, " + SomeMan.Name + " мёртв(");
                            System.out.println();
                        }
                    else {
                        System.out.println("Данного человека не существует. Создайте его");
                        System.out.println();
                    }
                }
                case "talk" -> {
                    if (SomeMan != null) {
                        SomeMan.Talk();
                        System.out.println();
                    }
                    else {
                        System.out.println("Сначала создайте данного человека!");
                        System.out.println();
                    }
                }
                case "go" -> {
                    if (SomeMan != null) {
                        SomeMan.Go();
                        System.out.println();
                    }
                    else {
                        System.out.println("Сначала создайте данного человека!");
                        System.out.println();
                    }
                }
                default -> {
                    System.out.println("Ваша команда не определена. Пожалуйста, введите снова.");
                    System.out.println("Для вывода списка команд введите help");
                    System.out.println("Для выхода из программы введите exit");
                    System.out.println();
                }
            }
        }
    }
}
