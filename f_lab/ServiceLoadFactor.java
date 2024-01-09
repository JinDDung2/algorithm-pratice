package f_lab;

import java.util.*;

public class ServiceLoadFactor {
    public static void main(String[] args) {
        String[] serviceArray = { "D=", "C=D", "B=C", "A=B,C" };
        String entryPoint = "A";
        ServiceLoadFactor serviceLoadFactor = new ServiceLoadFactor();

        serviceLoadFactor.getLoadFactors(serviceArray, entryPoint);
    }

    // 서비스*개수 포매팅
    // 서비스 리스트 파싱 후 맵에 {service: [dependencies]}
    public String[] getLoadFactors(String[] service_list, String entrypoint) {
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> loadMap = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();

        for (String service : service_list) {
            String[] data = service.split("=");
            String start = data[0];
            if (data.length == 1)
                continue;
            map.putIfAbsent(start, new HashSet<>());
            loadMap.put(start, 0);
        }
        return new String[] {};
    }

}
