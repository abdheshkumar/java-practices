package java8examples;

import java7examples.Developer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by abdhesh on 22/07/17.
 */
public class TestStream {
    public static void main(String[] args) {

        List<String> lines = Arrays.asList("spring", "node", "mkyong");
        List<String> result = getFilterOutput(lines, "mkyong");
        for (String temp : result) {
            System.out.println(temp);
        }

        List<String> resultFilter = lines.stream()
                .filter(line -> !"mkyong".equals(line))
                .collect(Collectors.toList());

        List<Developer> developers = Arrays.asList(
                new Developer("mkyong", new BigDecimal("200"), 30),
                new Developer("jack", new BigDecimal("200"), 20),
                new Developer("lawrence", new BigDecimal("200"), 40)
        );

        Developer developer = developers.stream()
                .filter(x -> x.equals("jack"))
                .findAny()
                .orElse(null);

        String name = developers.stream()
                .filter(x -> "jack".equals(x.getName()))
                .map(Developer::getName)
                .findAny()
                .orElse("");

        List<String> collect = developers.stream()
                .map(Developer::getName)
                .collect(Collectors.toList());

    }

    private static List<String> getFilterOutput(List<String> lines, String filter) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (!filter.equals(line)) {
                result.add(line);
            }
        }
        return result;
    }
}
