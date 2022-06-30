package Programmers.level_1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto_min_max {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        List<Integer> list_lottos = Arrays.stream(lottos).boxed().collect(Collectors.toList());
        List<Integer> list_win_nums = Arrays.stream(win_nums).boxed().collect(Collectors.toList());

        int count = Collections.frequency(list_lottos, 0);

        list_lottos.retainAll(list_win_nums);

        int min = ranking(list_lottos.size());
        int max = ranking(list_lottos.size() + count);

        answer[0] = max;
        answer[1] = min;

        return answer;
    }

    public int ranking(int number){
        switch (number){
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }

    public static void main(String[] args) {

        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        Lotto_min_max solution = new Lotto_min_max();
        int [] result = solution.solution(lottos, win_nums);

        System.out.println(Arrays.toString(result));
    }
}
