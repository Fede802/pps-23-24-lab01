import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test {
    private static final List<Integer> circularList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(circularList.iterator().next());
    }
}
