package inClass.treasure;

import java.util.ArrayList;

class Gold extends Treasure {
    private ArrayList<Eudemon> eudemons = new ArrayList<>();
    private String state = "黄金未被碰触。";
    @Override
    void addObserver(Eudemon eudemon) {
        eudemons.add(eudemon);
    }

    @Override
    void deleteObserver() {
        eudemons.clear();
    }

    @Override
    void notifyObserver() {
        for (Eudemon eudemon : eudemons) {
            eudemon.update();
        }
    }

    @Override
    int countObserver() {
        return eudemons.size();
    }
    @Override
    void setChanged() {
        super.setChanged();
        setState("黄金被碰触！");
    }

    void setState(String s){
        state = s;
        notifyObserver();
    }
    String getState(){
        return state;
    }
}
