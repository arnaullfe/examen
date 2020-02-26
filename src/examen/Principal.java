package examen;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;

import examen.classes.Admin;
import examen.classes.Post;
import examen.classes.Usuari;
import examen.functions.Functions;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Usuari> usuaris = new ArrayList<>();
        ArrayList<Post> posts = new ArrayList<>();
        String[] rols = { "admin", "editor", "lector" };
        int id = 1;
        Functions.benvinguda();
        System.out.println("Introdueix el nom de l'usuari que tindrà el rol d'administració: ");
        usuaris.add(new Admin(sc.nextLine(), rols[0]));
        String passwd;
        String passwdConfirm;
        do {
            System.out.println("Digues la contrasenya: ");
            passwd = sc.nextLine();
            System.out.println("Repeteix la contrsenya: ");
            passwdConfirm = sc.nextLine();
        } while (!Functions.contrasenyaValida(passwd, passwdConfirm));
        System.out.println("Usuari administrador creat, ja pots començar a utilitzar l'aplicació..");
        usuaris.get(0).setPasswd(passwd);
        outloop: while (true) {
            System.out.println("Que vols fer?");
            Functions.menu();
            int opcio = sc.nextInt();
            sc.nextLine();
            switch (opcio) {
            case 1:
                String userLogin;
                do {
                    System.out.println("Introdueix el teu username: ");
                    userLogin = sc.nextLine();
                } while (!Functions.usuariExisteix(usuaris, userLogin));
                String passwdLogin;
                do {
                    System.out.println("Intodueix la contrasenya: ");
                    passwdLogin = sc.nextLine();
                } while (!Functions.comprovarUsuariPasswd(usuaris, userLogin, passwdLogin));

                System.out.println(
                        "EL rol assignat al teu usuari és: " + Functions.getUsuari(usuaris, userLogin).getRol());
                logout: while (true) {
                    Functions.getUsuari(usuaris, userLogin).menuUsuari();
                    System.out.println("Que vols fer?");
                    int opcioUsuari = sc.nextInt();
                    sc.nextLine();
                    if (Functions.getUsuari(usuaris, userLogin).getRol().equals(rols[0])) {
                        switch (opcioUsuari) {
                        case 1:
                            System.out.println("Introdueix el títol:");
                            Post post = new Post(sc.nextLine(),id);
                            System.out.println("Introdueix el contingut:");
                            post.setContingut(sc.nextLine());
                            System.out.println("El contingut és per majors de 18? (S/N)");
                            String major = sc.nextLine();
                            if (major.equalsIgnoreCase("S")) {
                                post.setMajors18(true);
                            } else {
                                post.setMajors18(false);
                            }
                            post.setCreador(Functions.getUsuari(usuaris, userLogin));
                            post.setDia(LocalDateTime.now());
                            posts.add(post);
                            id++;
                            break;
                        case 2:
                            Functions.mostraTotsPosts(posts,sc);
                            break;
                        case 3:
                            Functions.mostraPostsInfo(posts);
                            int eliminar = sc.nextInt();
                            break;
                        case 4:
                            // lector to editor
                            break;
                        case 5:
                            // llistar editors
                            break;
                        case 6:
                            // llistar lectors
                            break;
                        case 0:
                            break logout;
                        }
                    }

                }
                break;
            case 2:
                // registre lector
                break;
            case 3:
                System.out.println("Fins un altre!");
                break outloop;
            }
        }

    }
}