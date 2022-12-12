import java.util.HashMap;
import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) {
        HashMap<String, String[]> phonebook = new HashMap();
        String[] phones1 = { "442314", "923443", "56345" };
        phonebook.put("Иванов", phones1);
        String[] phones2 = { "4414", "55346345" };
        phonebook.put("Петров", phones2);
        String[] phones3 = { "111", "222", "333" };
        phonebook.put("Смирнов", phones3);
        while (true) {
            Scanner scanner = new Scanner(System.in, "cp866");
            System.out.println("Для поиска номеров по фамилии введите 1:");
            System.out.println("Для добавления нового абонента введите 2:");
            System.out.println("Для выхода из справочника введите 4:");
            String mode = scanner.nextLine();
            if (mode.equals("1")) {
                System.out.println("Ведите фамилию:");
                String name = scanner.nextLine();
                phoneSearch(phonebook, name);
            } else if (mode.equals("2")) {
                phonebook = createObject(phonebook);
            } else if (mode.equals("4")) {
                scanner.close();
                break;
            }
        }

    }

    public static void phoneSearch(HashMap<String, String[]> phonebook, String name) {
        if (phonebook.containsKey(name)) {
            String[] phones = phonebook.get(name);
            System.out.println("По запросу найдено следующее:");
            System.out.println(name);
            for (String phone : phones) {
                System.out.println(phone);
            }
        } else {
            System.out.println("По запросу ничего не найдено");
        }

    }

    public static HashMap<String, String[]> createObject(HashMap<String, String[]> phonebook) {
        Scanner scanner = new Scanner(System.in, "cp866");
        System.out.println("Введите фамилию абонента для создания нововй записи:");
        String name = scanner.nextLine();
        System.out.println("Введите все известные номера абонента через пробел");
        String[] phones = scanner.nextLine().split(" ");
        phonebook.put(name, phones);
        System.out.println("Запись добавлена");
        scanner.close();
        return phonebook;
    }
}