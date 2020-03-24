package inClass.treasure;

import java.util.ArrayList;

class Diamond extends Treasure {
    private ArrayList<Eudemon> eudemons = new ArrayList<>();
    private String state = "钻石未被碰触。";
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
        setState("钻石被碰触！");
    }

    void setState(String s){
        state = s;
        notifyObserver();
    }
    String getState(){
        return state;
    }
}
