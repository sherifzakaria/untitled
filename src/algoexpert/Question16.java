package algoexpert;

import java.util.*;

public class Question16 {

    public static void main(String[] args) {

    }

    public int firstNonRepeatingCharacter1(String string) {
        // Write your code here.
        Map<Character, Integer> charactersMap = new LinkedHashMap<>();

        for (int i = 0; i < string.length(); i++) {
            Character key = string.charAt(i);
            if (!charactersMap.containsKey(key)) {
                charactersMap.put(key, 1);
            } else {
                charactersMap.put(key, 0);
            }
        }

        for (int i = 0; i < string.length(); i++) {
            Character key = string.charAt(i);
            if (charactersMap.get(key) == 1) {
                return i;
            }
        }

        return -1;
    }

    public int firstNonRepeatingCharacter(String string) {
        // Write your code here.
        List<Character> characters = new ArrayList<>();
        List<Character> repeatedCharacters = new ArrayList<>();

        for (int i = 0; i < string.length(); i++) {
            Character key = string.charAt(i);
            if (!characters.contains(key)) {
                characters.add(key);
            } else {
                repeatedCharacters.add(key);
            }
        }

        for (int i = 0; i < string.length(); i++) {
            if(!repeatedCharacters.contains(string.charAt(i))){
                return i;
            }
        }

        return -1;
    }
}
