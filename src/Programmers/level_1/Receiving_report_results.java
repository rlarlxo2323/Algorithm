package Programmers.level_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Receiving_report_results {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        String[] reports = Arrays.stream(report).distinct().toArray(String[]::new);

        HashMap<String, Integer> warning_count = new HashMap<String, Integer>();
        HashMap<String, ArrayList<String>> warning = new HashMap<String, ArrayList<String>>();
        HashMap<String, Integer> alert_count = new HashMap<String, Integer>();

        for (String str : reports) {
            String attacker = str.split(" ")[0];
            String victim = str.split(" ")[1];
            ArrayList<String> attackers = new ArrayList<>();

            warning_count.put(victim, warning_count.getOrDefault(victim, 0)+1);

            if (warning.get(victim) == null) {
                attackers.add(attacker);
                warning.put(victim, attackers);
            } else {
                attackers = warning.get(victim);
                attackers.add(attacker);
                warning.put(victim, attackers);
            }
        }

        for(String id:id_list){
            alert_count.putIfAbsent(id, 0);

            if (warning_count.get(id) != null && warning_count.get(id) >= k){
                for (String attacker_id:warning.get(id)){
                    alert_count.put(attacker_id, alert_count.getOrDefault(attacker_id, 0)+1);
                }
            }
        }

        for (int j = 0; j < id_list.length; j ++){
            answer[j] = alert_count.get(id_list[j]);
        }

        return answer;
    }




    public static void main(String[] args) {

	    String[] id_list = {"muzi", "frodo", "apeach", "neo"};
	    String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;


        Receiving_report_results solution = new Receiving_report_results();
        int[] result = solution.solution(id_list, report, k);

        System.out.println(Arrays.toString(result));
    }
}
