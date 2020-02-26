package examen.classes;

public class Admin extends Usuari{

    public Admin(String username,String rol) {
        super(username, rol);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public void menuUsuari(){
        System.out.println("-------------------------------");
        System.out.println("1 - Crear un post");
        System.out.println("2 - Llistar tots els post");
        System.out.println("3 - Eliminar un post");
        System.out.println("4 - Modificar un Lector a Editor");
        System.out.println("5 - Llistar Editors");
        System.out.println("6 - Llistar Lectors");
        System.out.println("0 - Log out");
        System.out.println("-------------------------------");
    }
    
}