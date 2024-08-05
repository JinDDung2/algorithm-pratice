package programmas;

class 입국심사 {

    // 파라메트릭 서치

    public long solution(int n, int[] times) {
        
        long l = Long.MAX_VALUE, r = 0;
        
        for (int time : times) {
            l = Math.min(l, time);
            r = Math.max(r, time);
        }
        
        r *= n;
        
        while (l < r) {
            long m = l + (r - l) / 2;
            long temp = 0;
            
            for (int time : times) {
                temp += m / time;
            }
            
            if (temp >= n) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
}
