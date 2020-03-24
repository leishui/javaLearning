package inClass.treasure;

import java.util.ArrayList;

public class Gold extends Treasure {
    private ArrayList<Eudemon> eudemons = new ArrayList<>();
    private String state = "黄金未被碰触。";
    @Override
    public void addObserver(Eudemon eudemon) {
        eudemons.add(eudemon);
    }

    @Override
    public void deleteObserver() {
        eudemons.clear();
    }

    @Override
    public void notifyObserver() {
        for (Eudemon eudemon : eudemons) {
            eudemon.update();
        }
    }

    @Override
    public int countObserver() {
        return eudemons.size();
    }
    @Override
    public void setChanged(boolean bool) {
        super.setChanged(bool);
        if (bool) setState("黄金被碰触！");
    }

    private void setState(String s){
        state = s;
        notifyObserver();
    }
    String getState(){
        return state;
    }
}
