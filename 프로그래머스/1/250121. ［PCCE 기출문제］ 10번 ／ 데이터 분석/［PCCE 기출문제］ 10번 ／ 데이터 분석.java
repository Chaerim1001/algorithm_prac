import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        PriorityQueue<Data> queue = new PriorityQueue<>();
        
        int idx = -1;
        switch (ext) {
            case "code" : {
                idx = 0; 
                break;
            }
            case "date" : {
                idx = 1;
                break;
            }
            case "maximum" : {
                idx = 2;
                break;
            }                
            case "remain" : {
                idx = 3;
                break;
            }   
        }
        
        int order_idx = -1;
        switch (sort_by) {
            case "code" : {
                order_idx = 0; 
                break;
            }
            case "date" : {
                order_idx = 1;
                break;
            }
            case "maximum" : {
                order_idx = 2;
                break;
            }                
            case "remain" : {
                order_idx = 3;
                break;
            }   
        }
            
        for(int i=0; i<data.length; i++) {
            if(data[i][idx] < val_ext) {
                queue.offer(new Data(i, data[i][idx], data[i][order_idx]));
            }
        }
        
        int[][] answer = new int[queue.size()][4];
        idx = 0;
        while(!queue.isEmpty()) {
            Data d = queue.poll();
            answer[idx] = data[d.index];
            idx++;
        }
        
        return answer;
    }
    
    static class Data implements Comparable<Data> {
        int index;
        int value;
        int order;
        
        public Data(int index, int value, int order) {
            this.index = index;
            this.value = value;
            this.order = order;
        }
        
        @Override
        public int compareTo(Data d) {
            return this.order - d.order;
        }
    }
}