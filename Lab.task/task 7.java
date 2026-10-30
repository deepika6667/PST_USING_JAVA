import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        Map<String, Integer> frequency = new LinkedHashMap<>();

        String[] words = text.split("\\s+");

        for (String word : words) {
            if (word.startsWith("#") && word.length() > 1) {
                String hashtag = word.replaceAll("[^#a-zA-Z0-9_]", "");

                frequency.put(hashtag,
                        frequency.getOrDefault(hashtag, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        sc.close();
    }
}
OUTPUT:
Java is easy #Java #Coding. I love #Java and #Coding

#Java 3
#Coding 2
