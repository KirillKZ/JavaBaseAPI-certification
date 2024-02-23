import java.util.*;

public class Finder {
    private static Map<String, String> filter = new HashMap<>();
    private static String f;

    public static Map<String, String> UI() {

        while (true) {
            if (!filter.isEmpty()) {
                System.out.println("Критерии для поиска ноутбука: ");
                for (Map.Entry<String, String> entry : filter.entrySet()) {
                    // get key
                    String key = entry.getKey();
                    // get value
                    String value = entry.getValue();
                    System.out.println(key + " - " + value + ";");
                }
                System.out.println();
                System.out.println("Для начала поиска введите - F");
                System.out.println("или добавьте критерий поиска");
                System.out.println();

            }

            System.out.println("Введите цифру, соответствующую необходимому критерию:\n" +
                    "1 - ОЗУ\n" +
                    "2 - Объем ЖД\n" +
                    "3 - Операционная система\n" +
                    "4 - Цвет\n" +
                    "Для выхода из программы введите 'Q'");
            Scanner in = new Scanner(System.in);
            String str = in.next();
            if (str.equalsIgnoreCase("Q")) {
                System.exit(0);
            }
            if (str.equalsIgnoreCase("F")) {
                return filter;
            }
            switch (str) {
                case "1":
                    System.out.println("Напишите минимальный объем ОЗУ в гигабайтах: ");
                    f = in.next();
                    filter.put("ОЗУ от (Гб)", f);
                    break;
                case "2":
                    System.out.println("Напишите минимальный объем ЖД в гигабайтах: ");
                    f = in.next();
                    filter.put("Объем ЖД от (Гб)", f);
                    break;
                case "3":
                    System.out.println("Напишите название операционной системы: ");
                    f = in.next();
                    filter.put("Операционная система", f);
                    break;
                case "4":
                    System.out.println("Напишите цвет: ");
                    f = in.next();
                    filter.put("Цвет", f);
                    break;
                default:
                    System.out.println("Вы ввели неверный символ");
                    break;
            }

        }


    }

    public static Set<Notebook> finderNB(Map<String, String> find, Set<Notebook> notebooks) {
        if (find.isEmpty()) {
            System.out.println("Критерии для поиска не заданы");
            System.exit(0);
        }
        Set<Notebook> matchNB = new HashSet<>();
        matchNB.addAll(notebooks);
        Iterator<Notebook> nbIter = matchNB.iterator();

        if (find.containsKey("ОЗУ от (Гб)")) {
            int RAM = Integer.parseInt(find.get("ОЗУ от (Гб)"));
            while (nbIter.hasNext())  {
                Notebook NB = nbIter.next();
                if (!(NB.getRAM() >= RAM)) {
                    nbIter.remove();
                }
            }
        }
        nbIter = matchNB.iterator();
        if (find.containsKey("Объем ЖД от (Гб)")) {
            int ValueHD = Integer.parseInt(find.get("Объем ЖД от (Гб)"));
            while (nbIter.hasNext())  {
                Notebook NB = nbIter.next();
                if (!(NB.getValueHD() >= ValueHD)) {
                    nbIter.remove();
                }
            }
        }
        nbIter = matchNB.iterator();
        if (find.containsKey("Операционная система")) {
            String OS = find.get("Операционная система");
            while (nbIter.hasNext())  {
                Notebook NB = nbIter.next();
                if (!NB.getOS().equalsIgnoreCase(OS)) {
                    nbIter.remove();
                }
            }
        }
        nbIter = matchNB.iterator();
        if (find.containsKey("Цвет")) {
            String color = find.get("Цвет");
            while (nbIter.hasNext())  {
                Notebook NB = nbIter.next();
                if (!NB.getColor().equalsIgnoreCase(color)) {
                    nbIter.remove();
                }
            }
        }
        return matchNB;

    }
}
