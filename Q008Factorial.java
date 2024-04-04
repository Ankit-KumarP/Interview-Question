
package My_Interview_Ques;

public class Q008Factorial {

    public static void factorial(int n) {

        String result = "1";
        for (int i = 2; i <= n; i++) {
            result = muntiply(result, i);
        }
        System.out.println(result);
    }

    // muntiply
    public static String muntiply(String s1, int idx) {

        String rtn = "0";

        for (int i = 0; i < idx; i++) {
            rtn = addition(s1, rtn);
        }

        return rtn;
    }

    // addition
    public static String addition(String s1, String s2) {

        int ptr1 = s1.length() - 1, ptr2 = s2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (ptr1 >= 0 || ptr2 >= 0 || carry > 0) {
            int num1 = 0, num2 = 0;
            if (ptr1 >= 0) {
                num1 = s1.charAt(ptr1--) - '0';
            }
            if (ptr2 >= 0) {
                num2 = s2.charAt(ptr2--) - '0';
            }
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            sb.append(String.valueOf(sum % 10));
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        factorial(32);
        System.out.println("HlO");
    }
}
