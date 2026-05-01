import java.util.Scanner;

public class CharArrayCompare {

    public static char[] getChars(String str) {
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        return arr;
    }

    public static boolean compareArrays(char[] a, char[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.next();

        char[] manual = getChars(text);
        char[] builtin = text.toCharArray();

        boolean result = compareArrays(manual, builtin);

        System.out.print("Manual: ");
        for (char c : manual) {
            System.out.print(c + " ");
        }
        System.out.println();

        System.out.print("Built-in: ");
        for (char c : builtin) {
            System.out.print(c + " ");
        }
        System.out.println();

        System.out.println("Are both arrays equal: " + result);

        sc.close();
    }
}