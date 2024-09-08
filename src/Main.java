import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        String expression = "2 + 3 ";
        String[] parts = expression.replaceAll("[=\\?]","").split(" ");
        Arrays.stream(parts)
                .forEach(System.out::println);
    }
}