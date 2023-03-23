package interviews;

import java.util.HashMap;
import java.util.Map;

public class JustEatTakeaway {
    public static void main(String[] args) {

    }

    public static int solution(String S) {

        int counter = 0;
        Map<String, Integer> bananaMap = new HashMap<>();
        bananaMap.put("B", 0);
        bananaMap.put("A", 0);
        bananaMap.put("N", 0);

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'B') {
                bananaMap.put("B", bananaMap.get("B") + 1);
            } else if (S.charAt(i) == 'A') {
                bananaMap.put("A", bananaMap.get("A") + 1);
            } else if (S.charAt(i) == 'N') {
                bananaMap.put("N", bananaMap.get("N") + 1);
            }
        }

        int BCounter = bananaMap.get("B");
        int ACounter = bananaMap.get("A");
        int NCounter = bananaMap.get("N");

        while (BCounter >= 1 && ACounter >= 2 && NCounter >= 2) {
            counter++;
            BCounter--;
            ACounter = ACounter - 2;
            NCounter = NCounter - 2;
        }

        return counter;
    }

}
