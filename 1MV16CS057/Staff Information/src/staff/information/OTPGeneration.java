package staff.information;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class OTPGeneration {

    private static final String CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String SMALL = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMERIC = "0123456789";

    Random rand = new Random();

    public static void main(String[] args) {

        System.out.println(new OTPGeneration().randomAlphaNumeric(2));

    }

    public String randomAlphaNumeric(int count) {

        StringBuilder sbr = new StringBuilder();

        for (int i = 0; i < count; i++) {

            int n1 = Math.abs(rand.nextInt() + 1) % CAPS.length();
            int n2 = Math.abs(rand.nextInt() + 1) % SMALL.length();
            int n3 = Math.abs(rand.nextInt() + 1) % NUMERIC.length();

            sbr.append(CAPS.charAt(n1)).append(SMALL.charAt(n2)).append(NUMERIC.charAt(n3));

        }

        List<String> ll = Arrays.asList(sbr.toString().split(""));

        Collections.shuffle(ll);

        String str = "";

        for (String s : ll) {
            str += s;
        }

        return str;

    }

}
