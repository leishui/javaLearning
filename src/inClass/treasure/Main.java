package inClass.treasure;

public class Main {
    public static void main(String[] args) {
        Gold gold = new Gold();
        Diamond diamond = new Diamond();
        Cage cage = new Cage();
        System.out.println(gold.getState()+gold.countObserver()+"个守护者");
        System.out.println(diamond.getState()+diamond.countObserver()+"个守护者");
        gold.addObserver(() -> System.out.println("黄金守护者1启动"));
        gold.addObserver(() -> System.out.println("黄金守护者2启动"));
        gold.addObserver(() -> System.out.println("黄金守护者3启动"));
        diamond.addObserver(() -> System.out.println("钻石守护者1启动"));
        cage.touchTreasure(gold);
        cage.touchTreasure(diamond);
        System.out.println(gold.getState()+gold.countObserver()+"个守护者");
        System.out.println(diamond.getState()+diamond.countObserver()+"个守护者");
    }
}
