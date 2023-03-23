package algoexpert;

import java.util.HashMap;
import java.util.Map;

public class Question15 {
    public static void main(String[] args) {
        System.out.println(generateDocument("Bste!hetsi ogEAxpelrt x ", "AlgoExpert is the Best!"));
    }

    public static boolean generateDocument(String characters, String document) {
        // Write your code here.
        if (document.isEmpty()) {
            return true;
        }

        Map<Character, Integer> charactersMap = new HashMap<>();

        for (int i = 0; i < characters.length(); i++) {
            Character key = characters.charAt(i);
            if (!charactersMap.containsKey(key)) {
                charactersMap.put(key, 1);
            } else {
                charactersMap.put(key, charactersMap.get(key) + 1);
            }
        }

        for (int i = 0; i < document.length(); i++) {
            Character documentCharacter = document.charAt(i);

            if (charactersMap.containsKey(documentCharacter) && charactersMap.get(documentCharacter) > 0) {
                charactersMap.put(documentCharacter, charactersMap.get(documentCharacter) - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
