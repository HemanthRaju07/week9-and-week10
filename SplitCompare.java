import java.util.Scanner;

public class SplitCompare {

    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
        }
        return count;
    }

    public static String[] splitText(String text) {
        int len = findLength(text);
        int wordCount = 1;

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        int[] spaceIndex = new int[wordCount - 1];
        int idx = 0;

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndex[idx++] = i;
            }
        }

        String[] words = new String[wordCount];
        int start = 0;

        for (int i = 0; i < wordCount; i++) {
            int end = (i < wordCount - 1) ? spaceIndex[i] : len;
            String temp = "";
            for (int j = start; j < end; j++) {
                temp += text.charAt(j);
            }
            words[i] = temp;
            start = end + 1;
        }

        return words;
    }

    public static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        String[] manual = splitText(text);
        String[] builtin = text.split(" ");

        boolean result = compareArrays(manual, builtin);

        System.out.println("Manual split:");
        for (String w : manual) {
            System.out.println(w);
        }

        System.out.println("Built-in split:");
        for (String w : builtin) {
            System.out.println(w);
        }

        System.out.println("Are both equal: " + result);

        sc.close();
    }
}