package inClass.treasure;

abstract public class Treasure {
    private boolean isChanged =false;
    abstract public void addObserver(Eudemon eudemon);
    abstract public void deleteObserver();
    abstract public void notifyObserver();
    abstract public int countObserver();
    public boolean hasChanged(){return isChanged;}
    public void setChanged(boolean bool){isChanged = bool;}
    public void clearChanged(){isChanged = false;}
}
