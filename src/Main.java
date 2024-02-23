/*ДЗ
Подумать над структурой класса Ноутбук для магазина техники - выделить поля и
методы. Реализовать в java.
Создать множество ноутбуков.
        Написать метод, который будет запрашивать у пользователя критерий (или критерии)
фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно
хранить в Map. Например:
        “Введите цифру, соответствующую необходимому критерию:
        1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить
параметры фильтрации можно также в Map.
Отфильтровать ноутбуки их первоначального множества и вывести проходящие по
условиям.*/


import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Notebook N1 = new Notebook("N1", 4,128,"windows","черный");
        Notebook N2 = new Notebook("N2", 8,256,"linux","серебристый");
        Notebook N3 = new Notebook("N3", 12,512,"dos","синий");
        Notebook N4 = new Notebook("N4", 16,1000,"windows","черный");
        Notebook N5 = new Notebook("N5", 12,256,"windows","белый");

        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(N1);
        notebooks.add(N2);
        notebooks.add(N3);
        notebooks.add(N4);
        notebooks.add(N5);


        Map<String,String> filter =  Finder.UI();
       if(Finder.finderNB(filter,notebooks).isEmpty()){
           System.out.println("Критериям поиска не подошел ни один ноутбук");
       }else {
           System.out.println("Критериям поиска подошли ноутбук(и): ");
           System.out.println(Finder.finderNB(filter,notebooks));
       }


    }
}