package inClass.treasure;

public class Main {
    public static void main(String[] args) {
        Gold gold = new Gold();
        Diamond diamond = new Diamond();
        //定义守护者
        Eudemon goldEudemon1 = () -> {
            if (Math.random()%2==0)
            System.out.println("黄金守护者1启动");
        };
        Eudemon goldEudemon2 = () -> System.out.println("黄金守护者2启动");
        Eudemon diamondEudemon1 = () -> System.out.println("钻石守护者1启动");
        Cage cage = new Cage();
        //初始状态
        currentStateOfGold(gold);
        currentStateOfDiamond(diamond);
        //添加守护神
        gold.addObserver(goldEudemon1);
        gold.addObserver(goldEudemon2);
        diamond.addObserver(diamondEudemon1);
        //添加后状态
        currentStateOfGold(gold);
        currentStateOfDiamond(diamond);
        //碰触黄金钻石
        cage.touchTreasure(gold);
        cage.touchTreasure(diamond);
        //最终状态
        currentStateOfGold(gold);
        currentStateOfDiamond(diamond);
    }

    private static void currentStateOfGold(Gold gold) {
        System.out.print("黄金状态" + (gold.hasChanged() ? "被改动。" : "未改动。"));
        System.out.println(gold.getState() + gold.countObserver() + "个守护者");
    }

    private static void currentStateOfDiamond(Diamond diamond) {
        System.out.print("钻石状态" + (diamond.hasChanged() ? "被改动。" : "未改动。"));
        System.out.println(diamond.getState() + diamond.countObserver() + "个守护者");
    }
}
