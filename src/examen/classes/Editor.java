package examen.classes;

import java.util.ArrayList;

public class Editor extends Usuari {
    private ArrayList<Usuari> follows = new ArrayList<>();

    public Editor(String username,String rol) {
        super(username,rol);
    }

    public ArrayList<Usuari> getFollows() {
        return follows;
    }

    public void setFollows(ArrayList<Usuari> follows) {
        this.follows = follows;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void menuUsuari() {
        // TODO Auto-generated method stub

    }
    
    
    
}