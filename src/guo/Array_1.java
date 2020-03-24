package guo;

public class Array_1 {
    public static void main(String[] args) {
        int[] firstArray = {10,20,30,40,50,60};
        int[] secondArray;
        int[] thirdArray = new int[6];
        System.out.println("firstArray:");
        print(firstArray);

        secondArray = firstArray;
        System.arraycopy(firstArray,0,thirdArray,0,6);
        firstArray[0] = 20;

        System.out.println("\nchangedFirstArray:");
        print(firstArray);
        System.out.println("\nsecondArray:");
        print(secondArray);
        System.out.println("\nthirdArray:");
        print(thirdArray);
    }
    private static void print(int[] array){
        for (int value : array) {
            System.out.print(value+" ");
        }
    }
}
