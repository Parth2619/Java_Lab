import java.util.ArrayList;
public class ArraylistEx {
public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(10);
    list.add(20);

    int originalSize = list.size();
    for (int i = 0; i < originalSize; i++) {
        list.add(i);
    }
    for (Integer e : list) {
        System.out.println(e);
    }
    list.forEach(e -> System.out.println(e));
    System.out.println("Size: " + list.size());
    System.out.println("Index of 20: " + list.indexOf(20));
    list.add(1);
    System.out.println("Index of 1: " + list.indexOf(1));
    System.out.println("Last index of 1: " + list.lastIndexOf(1));

    list.addAll(list);
    System.out.println("Size after addAll: " + list.size());



    ArrayList<String> strList = new ArrayList<>();
    strList.add("Cow");
    strList.add("Dog");
    strList.add("Cat");
    strList.add("Horse");
    strList.add("Sheep");
    System.out.println("All:");
    strList.forEach(System.out::println);

    System.out.println("Starts with C:");
    strList.forEach(w -> {if (w.startsWith("C")) System.out.println(w);});

    strList.removeIf(w -> w.startsWith("C"));
    System.out.println("After removeIf:");
    strList.forEach(System.out::println);

}
}