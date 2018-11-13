package io.ibicfly.service0.algorithms;

import java.util.*;

/**
 * @Author :cyh
 * @CreateDate: 2018/10/11 15:56
 * @Description: 作用描述
 */
public class ArrayListTest {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
        List<String> list=Arrays.asList("A B C D E F G H I J K L".split(" "));
        list=Collections.unmodifiableList(list);
        list.add("test");
        fillWithRandomNum(list);
        System.out.println(list);
        Collection<String> origin = list;
        Collection<String> subList = list.subList(1, 8);
        Collection<String> then = new ArrayList<String>(subList);
        try {
            origin.removeAll(then);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("removeAll");
        }
    }

    private static void fillWithRandomNum(Collection collection) {
        if (collection instanceof List)
            System.out.println("List ");
        else if (collection instanceof Map)
            System.out.println("Map");
        else if (collection instanceof Set)
            System.out.println("Set");
        else if (collection instanceof Queue)
            System.out.println("Queue");
        else
            System.out.println("Other");
        int size = collection.size() == 0 ? 15 : collection.size();
        for (int i = 0; i < size; i++)
            collection.add(new Random().nextInt());
    }
}
