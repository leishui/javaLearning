package experiment.experiment_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class T2_5 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        while (num!=0){
            arrayList.add(num);
            num = scanner.nextInt();
        }
        int size = arrayList.size();
        if (size!=0){
            arrayList.sort(Comparator.naturalOrder());
            int sum=0;
            for (int a:arrayList){
                sum+=a;
            }
            System.out.println("最大值为："+arrayList.get(size-1)+
                    "最小值为："+arrayList.get(0)+"平均值为："+ (float) sum/size);
        }else
            System.out.println("未输入有效数");
    }
}
