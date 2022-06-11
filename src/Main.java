import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        MyHashMap arr = new MyHashMap();


//        arr.put("ukr", "kiev");
        arr.put("ukr", "Kiev");

//        arr.put("ukrrr", "kharkiv");
        arr.put("ukrrr", "Kharkiv");
//        arr.put("ukrrrr", "odessa");
        arr.put("ukrrrr", "Odessa");

        arr.put("spain", "Madrid");
//        arr.put("czechia", "Prague");
//        arr.put("austria", "Vienna");
//        arr.put("germany", "Berlin");
//        arr.remove("ukr");
//        arr.remove("ukrrr");
//        arr.remove("ukrrrr");
//        arr.remove("spain");

        System.out.println(arr.get("ukr"));
//        System.out.println("next " + arr.get("ukrrr").next);
//        System.out.println("next.next " + arr.get("ukr").next.next);

        System.out.println(arr.get("ukrrr"));
        System.out.println(arr.get("ukrrrr"));
        System.out.println(arr.get("spain"));
//        System.out.println(arr.get("czechia"));
//        System.out.println(arr.get("austria"));
//        System.out.println(arr.get("germany"));
//        System.out.println(arr.counterInHashArray(Objects.hash("key")));

        System.out.println(arr.size());
    };
}
