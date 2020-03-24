package inClass.treasure;

abstract class Treasure {
    private boolean isChanged =false;
    abstract void addObserver(Eudemon eudemon);
    abstract void deleteObserver();
    abstract void notifyObserver();
    abstract int countObserver();
    boolean hasChanged(){return isChanged;}
    void setChanged(){isChanged = true;}
    void clearChanged(){isChanged = false;}
}
