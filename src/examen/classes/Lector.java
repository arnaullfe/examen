package examen.classes;

import java.util.ArrayList;

public class Lector extends Usuari {
    private ArrayList<Usuari> follows = new ArrayList<>();
    private boolean major;

    public Lector(String username,String rol) {
        super(username,rol);
    }

    public ArrayList<Usuari> getFollows() {
        return follows;
    }

    public void setFollows(ArrayList<Usuari> follows) {
        this.follows = follows;
    }

    public boolean isMajor() {
        return major;
    }

    public void setMajor(boolean major) {
        this.major = major;
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

    @Override
    public ArrayList<Usuari> follows() {
        return this.follows;
    }

    @Override
    public void afegirArray(Usuari usuari) {
        this.follows.add(usuari);
    }

    @Override
    public void veureArray() {
        System.out.println("Editors seguits per "+this.username);
        System.out.println("----------------------------------");
        for(Usuari a : this.follows){
            System.out.println(a.username);
        }
        System.out.println("----------------------------------");
    }

   
    
    
    
}