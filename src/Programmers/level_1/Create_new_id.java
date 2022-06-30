package Programmers.level_1;


public class Create_new_id {
    public String solution(String new_id) {
        String answer = "";

        String match = "[^0-9a-z-_.]";
        String pass_1 = new_id.toLowerCase();
        String pass_2 = pass_1.replaceAll(match,"");
        String pass_3 = pass_2.replaceAll("\\.{2,}", ".");
        String pass_4 = pass_3.replaceAll("^\\.", "");
        String pass_5 = pass_4.replaceAll("\\.$", "");

        answer = pass_5;

        return answer;
    }



    public static void main(String[] args) {

        String new_id = "...!@BaT#*..y.abcdefghijklm.";

        Create_new_id solution = new Create_new_id();
        String result = solution.solution(new_id);

        System.out.println(result);
    }
}
