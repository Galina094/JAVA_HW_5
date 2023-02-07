import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.text.html.HTMLDocument.Iterator;

// Создать словарь HashMap. Обобщение <Integer, String>.
// Заполнить тремя ключами (индекс, цвет), добавить ключь, если не было!)
// Изменить значения дописав восклицательные знаки.
// *Создать TreeMap, заполнить аналогично.
// *Увеличить количество элементов до 1000 случайными ключами и общей строкой.
// **Сравнить время последовательного и случайного перебора тысячи элементов словарей.


public class Task5_1 {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        map.putIfAbsent(1, "Yellow");
        map.putIfAbsent(2, "Green");
        map.putIfAbsent(3, "Puple");        

        map.replaceAll((k,v) -> v+"!");

        TreeMap<Integer, String> tMap = new TreeMap<>();        

        tMap.putIfAbsent(1, "Yellow");
        tMap.putIfAbsent(2, "Green");
        tMap.putIfAbsent(3, "Puple");
        

        Random rnd = new Random();

        long beginTmap = System.currentTimeMillis();
        for (int i = 0; i < 100001; i++) {
            map.putIfAbsent(rnd.nextInt(1000000), "Yo-ho-ho!");           
        }
        long endTmap = System.currentTimeMillis();


        long beginTimetMap = System.currentTimeMillis();
        for (int i = 0; i < 100001; i++) {
            tMap.putIfAbsent(rnd.nextInt(1000000), "Yo-ho-ho!");            
        }
        long endTimetMap = System.currentTimeMillis();

        System.out.println(map.size());
        System.out.println(tMap.size());

        System.out.println("Operation time of the HashMap = " + (endTmap-beginTmap) + " (нс) ");
        System.out.println("Operation time of the TreeMap = " + (endTimetMap-beginTimetMap) + " (нс) ");

        long beginmapIter = System.currentTimeMillis();
        for (Map.Entry<Integer,String> entry: map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();            
        }
        long endmapIter = System.currentTimeMillis();

        long begintMapIter = System.currentTimeMillis();
        for (Map.Entry<Integer,String> entry: tMap.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();            
        }
        long endtMapIter = System.currentTimeMillis();
        System.out.println("Operation time of the HashMap (Iterator) = " + (endmapIter-beginmapIter) + " (нс) ");
        System.out.println("Operation time of the TreeMap (Iterator) = " + (endtMapIter-begintMapIter) + " (нс) ");
    }
}