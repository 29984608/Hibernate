import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.next();
            String[] strings = string.split("/");
            int[] time = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                time[i] = Integer.parseInt(strings[i]); }
            int year = time[0];
            int month = time[1];
            int day = time[2];
            int sum = 0;
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                int days[] = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30};
                for (int j = 0; j < month; j++) {
                    sum += days[j];
                }
                sum+=day;
            } else {
                int days[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
                for (int j = 0; j < month; j++) {
                    sum += days[j];
                }
                sum+=day;
            }
            System.out.print("您输入的是" + year + "年" + "今年的的第" + sum + "天");
            //System.out.println("今年是"+time[0]+"年"+time[1]+"月"+time[2]+"日");
        }
    }
}
