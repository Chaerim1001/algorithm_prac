import java.util.HashMap;
import java.util.Map;

class Solution {
    final int USER_QUALIFICATION_DURATION = 10;

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> wantMap = new HashMap<String, Integer>();
        for (int i = 0; i < want.length; i++) {
            String s = want[i];
            int count = number[i];

            wantMap.put(s, count);
        }

        Map<String, Integer> discountMap = new HashMap<String, Integer>();
        for (int i = 0; i < USER_QUALIFICATION_DURATION; i++) {
            String addItem = discount[i];
            discountMap.put(addItem, discountMap.getOrDefault(addItem, 0) + 1);
        }

        if (isEqual(wantMap, discountMap)) answer++;
  

        for (int i = 1; i <= discount.length - USER_QUALIFICATION_DURATION; i++) {
            String deleteItem = discount[i - 1];
            discountMap.put(deleteItem, discountMap.get(deleteItem) - 1);

            String addItem = discount[i - 1 + USER_QUALIFICATION_DURATION];
            discountMap.put(addItem, discountMap.getOrDefault(addItem, 0) + 1);

            if (isEqual(wantMap, discountMap)) answer++;
        }

        return answer;
    }

    public boolean isEqual(Map<String, Integer> wantMap, Map<String, Integer> compareMap) {
        for (String key : wantMap.keySet()) {
            if (!compareMap.containsKey(key) || wantMap.get(key) != compareMap.get(key)) return false;
        }

        return true;
    }
}