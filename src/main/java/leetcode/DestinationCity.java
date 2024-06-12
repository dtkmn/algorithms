package leetcode;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/destination-city/">...</a>
 *
 */

public class DestinationCity {

    public String destCity(List<List<String>> paths) {
        Map<String, String> cityMappings = new HashMap<>();
        for (List<String> path: paths) {
            for (int i = 0; i < path.size(); i++) {
                String from = path.get(0);
                String to = path.get(1);
                cityMappings.put(from, to);
            }
        }

        for (String city: cityMappings.values()) {
            if (!cityMappings.containsKey(city)) return city;
        }

        return null;
    }


    public static void main(String[] args) {
    }

}
