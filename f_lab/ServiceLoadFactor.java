package f_lab;

import java.util.*;

public class ServiceLoadFactor {
    // 서비스*개수 포매팅
    // {start, {targets}}, {service, price}, {service, indegrees}
    public String[] getLoadFactors(String[] service_list, String entrypoint) {
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> loadMap = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();

        for (String service : service_list) {
            String[] arr = service.split("=");
            String from = arr[0];
            map.putIfAbsent(from, new HashSet<>());
            loadMap.put(from, 0);

            if (arr.length == 1)
                continue;
            String[] toArr = arr[1].split(",");

            for (String to : toArr) {
                map.get(from).add(to);
                loadMap.put(to, 0);
                indegree.put(to, indegree.getOrDefault(to, 0) + 1);
            }
        }

        loadMap.put(entrypoint, 1);
        Queue<String> que = new LinkedList<>();
        que.add(entrypoint);

        while (!que.isEmpty()) {
            String from = que.poll();

            if (map.containsKey(from)) {
                for (String to : map.get(from)) {
                    loadMap.put(to, loadMap.get(from) + loadMap.get(to));
                    indegree.put(to, indegree.get(to) - 1);
                    if (indegree.get(to) == 0) {
                        que.add(to);
                    }
                }
            }
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : loadMap.entrySet()) {
            if (!map.containsKey(entry.getKey()) || entry.getValue() == 0)
                continue;
            result.add(entry.getKey() + "*" + entry.getValue());
        }

        Collections.sort(result);

        return result.toArray(new String[result.size()]);
    }

}
