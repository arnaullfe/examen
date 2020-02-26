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
        System.out.println("-------------------------------");
        System.out.println("1 - Crear un post");
        System.out.println("2 - Seguir a un editor nou");
        System.out.println("3 - Veure editors que segueixo");
        System.out.println("4 - Mirar el meu mur");
        System.out.println("0 - Log out");
        System.out.println("-------------------------------");

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