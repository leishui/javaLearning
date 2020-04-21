package experiment.experiment_1;

public class T1_3 {
    public static void main(String[] args) {
        String[][] table = new String[6][7];
        for (int i = 1; i < 7; i++) {
            table[0][i] = "   "+i+"   ";
        }
        table[0][0] = "       ";
        table[1][0] = "星期一";
        table[2][0] = "星期二";
        table[3][0] = "星期三";
        table[4][0] = "星期四";
        table[5][0] = "星期五";
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                String temp =  table[j][i];
                System.out.print((temp!=null?temp:"      ")+"|");
            }
            System.out.println();
        }
    }
}
