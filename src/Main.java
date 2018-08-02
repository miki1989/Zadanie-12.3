import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("liczby.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        Scanner scanner = new Scanner(file);
        ArrayList<Integer>liczby = new ArrayList<>();
        //int value = 0;
        while (scanner.hasNextInt()){
            int value = scanner.nextInt();
            liczby.add(value);
        }
        System.out.println(liczby.size());
        System.out.println();
        Queue<Integer> numbers = new PriorityQueue<>(liczby);

        TreeMap<Integer, Integer> mapa = new TreeMap<>();
        Integer key, value;
        for (Integer number: numbers) {
            key = number;
            if (mapa.containsKey(key)) {
                value = mapa.get(key);
                mapa.put(key, value + 1);
            } else mapa.put(key, 1);
        }

        for(Integer dane : mapa.keySet()){
            System.out.println(dane + " liczba wystąpień " + mapa.get(dane));
        }
    }
}
