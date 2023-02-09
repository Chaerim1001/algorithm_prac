import java.util.*;

class Solution {
    
    public String[] solution(String[] orders, int[] course) {
        Map<String, Integer> orderMap = new HashMap<>();
        
        for(String order: orders){
            char[] charArr = order.toCharArray();
            Arrays.sort(charArr);
            Map<String, Integer> tmp = dfs(new String(charArr));
            tmp.forEach((key, value) -> orderMap.merge(key, value, (v1, v2) -> v1 + v2));
        }
        
        Set<String> result = new TreeSet<>();
        for(int count : course){
            int maxCount = 2;
            Set<String> courseSet = new TreeSet<>();
            for(String key : orderMap.keySet()){
                if(key.length() == count){
                    if(orderMap.get(key) > maxCount){
                        courseSet.clear();
                        courseSet.add(key);
                        maxCount = orderMap.get(key);
                    } else if (orderMap.get(key) == maxCount){
                        courseSet.add(key);
                    }
                }
            }
            result.addAll(courseSet);
        }
        
        String[] answer = result.toArray(new String[result.size()]);
        return answer;
    }
    
    public Map<String, Integer> dfs(String order){
        Map<String, Integer> orderMap;
        
        if(order.length() <= 1) {
            orderMap = new HashMap<>();
            orderMap.put("", 1);
            orderMap.put(order, 1);
        } else {
            orderMap = dfs(order.substring(1));
            Map<String, Integer> tmpOrderMap = new HashMap<>();
            for(String key : orderMap.keySet())
                tmpOrderMap.put(order.substring(0, 1) + key, 1);
            orderMap.putAll(tmpOrderMap);
        }
        
        return orderMap;
    }
}