package experiment.experiment_1;

import java.util.Scanner;

public class T1_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int experiment.experiment_2 = scanner.nextInt();
//        int b = scanner.nextInt();
//        int c = scanner.nextInt();
//        ArrayList<Integer> num = new ArrayList<>();
//        num.add(scanner.nextInt());
//        num.add(scanner.nextInt());
//        num.add(scanner.nextInt());
//        num.sort(Comparator.naturalOrder());
//        num.forEach(System.out::println);
        int[] num = {
                scanner.nextInt(),
                scanner.nextInt(),
                scanner.nextInt()
        };
        if (num[0] > num[1]) {
            int temp = num[0];
            num[0] = num[1];
            num[1] = temp;
        }
        if (num[1] > num[2]) {
            int temp = num[1];
            num[1] = num[2];
            num[2] = temp;
        }
        if (num[0] > num[1]) {
            int temp = num[0];
            num[0] = num[1];
            num[1] = temp;
        }
        for (int value : num) {
            System.out.println(value);
        }
    }
}