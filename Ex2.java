import java.util.ArrayList;
import java.util.HashMap;

public class Ex2 {
    public static void main(String[] args) {
        String[] names = { "Петр", "Сергей", "Евгений", "Евстахий", "Евгений", "Евгений", "Петр", "Петр", "Сергей",
                "Петр", "Петр" };
        HashMap<String, Integer> map = new HashMap();
        for (String name : names) {
            if (map.containsKey(name)) {
                int buffer = map.get(name) + 1;
                map.put(name, buffer);
            } else {
                map.put(name, 1);
            }

        }
        System.out.println(map);
        ArrayList<Integer> list = new ArrayList<>();
        for (HashMap.Entry<String, Integer> item : map.entrySet()) {
            list.add(item.getValue());
        }
        list.sort(null);
        for (int index = list.size() - 1; index >= 0; index--) {
            for (HashMap.Entry<String, Integer> item : map.entrySet()) {
                if (item.getValue().equals(list.get(index))) {
                    System.out.format("%s встречается %d раз!\n", item.getKey(), item.getValue());
                }
            }
        }

    }
}
