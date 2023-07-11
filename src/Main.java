import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(7,9,3,4,2,9,1,4,5,3,2,7);
        //--------------------------
        int digitCounter = 0;
        for(Integer i: list) {
            if(i%2 == 0) digitCounter++;
        }
        System.out.println(digitCounter);
        //--------------------------

        long count = list.parallelStream().filter(i -> i%2==0).count();
        System.out.println(count);


        List<String> strings = Arrays.asList("abfsd", "abdfazz", "dsfdfasd", "abdfsazz");

        Set<String> res = strings.stream().filter(s->s.startsWith("ab")).filter(s->s.endsWith("zz")).collect(Collectors.toSet());
        System.out.println(res);

        Integer[] arr = list.stream().sorted().distinct().limit(3).toArray(Integer[]::new);
        System.out.println(Arrays.toString(arr));

        List<Integer> arrSet = list.stream().sorted(((o1, o2) -> (-1)*o1.compareTo(o2))).distinct().limit(3).collect(Collectors.toSet()).stream().sorted((o1, o2) -> (-1)*o1.compareTo(o2)).collect(Collectors.toList());
        System.out.println(arrSet);

        list.stream().map(price -> price * 2).filter(price -> price >= 10).forEach(System.out::println);

        list.stream().mapToDouble(price -> price * 1.2).filter(price -> price > 10.0).forEach(System.out::println);



    }
}