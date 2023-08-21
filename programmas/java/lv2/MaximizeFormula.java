package programmas.java.lv2;

import java.util.ArrayList;
import java.util.List;

public class MaximizeFormula {
    long answer = Long.MIN_VALUE;
    
    List<Long> numList = new ArrayList<>();
    List<Character> operationsList = new ArrayList<>();
    
    char[] operation = {'+', '-', '*'};
    char[] output = new char[operation.length];
    boolean[] visited = new boolean[operation.length];
    
    public long solution(String expression) {
        String n = "";
        for (int i=0; i<expression.length(); i++) {
            char exp = expression.charAt(i);
            if (exp == '+' || exp == '-' || exp == '*') {
                operationsList.add(exp);
                numList.add(Long.parseLong(n));
                n = "";
            } else {
                n += exp;
            }
        }
        // 마지막 남은 숫자있으면 추가
        numList.add(Long.parseLong(n));
        // 순열
        permutations(0, operation.length);
        
        return answer;
    }
    
    public void permutations(int depth, int r) {
        if (depth == r) {
            solve();
        }
        for (int i=0; i<operation.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = operation[i];
                permutations(depth + 1, r);
                visited[i] = false;
            }   
        }
    }
    
    public void solve() {
        List<Character> oper = new ArrayList<>();
        oper.addAll(operationsList);
        List<Long> num = new ArrayList<>();
        num.addAll(numList);
        
        for (int i=0; i<output.length; i++) {
            char curOper = output[i]; // 현재 우선순위 연산자
            for (int j=0; j<oper.size(); j++) {
                if (oper.get(j).equals(curOper)) {
                    long n1 = num.get(j);
                    long n2 = num.get(j+1);
                    long res = cal(n1, n2, curOper);
                    
                    num.remove(j+1);
                    num.remove(j);
                    oper.remove(j);
                    
                    num.add(j, res);
                    j--;
                }
            }
        }
        answer = Math.max(answer, Math.abs(num.get(0)));
    }
    
    public long cal(long n1, long n2, char operations) {
        long res = 0;
        switch (operations) {
            case '+':
                res = n1 + n2;
                break;
            case '-':
                res = n1 - n2;
                break;
            case '*':
                res = n1 * n2;
                break;
        }
        
        return res;
    }
}
