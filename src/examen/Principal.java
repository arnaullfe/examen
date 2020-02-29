package examen;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;

import examen.classes.Admin;
import examen.classes.Lector;
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
                    System.out.println("Usuari autenticat amb èxit.");
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
                                    Post post = new Post(id);
                                    post.demanarDades(sc, userLogin, usuaris);
                                    posts.add(post);
                                    System.out.println("Post afegit correctament");
                                    id++;
                                    break;
                                case 2:
                                    Functions.mostraTotsPosts(posts, sc);
                                    break;
                                case 3:
                                    Functions.mostraPostsInfo(posts);
                                    int eliminar = sc.nextInt();
                                    if (Functions.postExisteix(posts, eliminar)) {
                                        posts.remove(Functions.elimina(posts, eliminar));
                                        System.out.println("Post eliminat....");
                                        Functions.mostraPostsInfo(posts);
                                    } else {
                                        System.out.println("El post no existeix!! Torna-ho a intentar");
                                    }
                                    break;
                                case 4:
                                    String usuariCanvi;
                                    do {
                                        Functions.llistar(rols[2], usuaris, userLogin);
                                        System.out.println("Escriu el nom d'usuari del lector:");
                                        usuariCanvi = sc.nextLine();
                                    } while (!Functions.usuariExisteix(usuaris, usuariCanvi));

                                    if (Functions.getUsuari(usuaris, usuariCanvi).getRol().equals(rols[2])) {
                                        usuaris.add(Functions.LectorToEditor(Functions.getUsuari(usuaris, usuariCanvi),
                                                rols[1]));
                                        usuaris.remove(Functions.posicioUsuari(usuaris, usuariCanvi));
                                    } else {
                                        System.out.println("Error, l'usuari no és lector");
                                    }
                                    break;
                                case 5:
                                    Functions.llistar(rols[1], usuaris, userLogin);
                                    System.out.println("-----------------------");
                                    System.out.println("Enter per continuar");
                                    sc.nextLine();
                                    break;
                                case 6:
                                    Functions.llistar(rols[2], usuaris, userLogin);
                                    System.out.println("-----------------------");
                                    System.out.println("Enter per continuar");
                                    sc.nextLine();
                                    break;
                                case 0:
                                    break logout;
                            }
                        } else if (Functions.getUsuari(usuaris, userLogin).getRol().equals(rols[1])) {
                            switch (opcioUsuari) {
                                case 1:
                                    Post post = new Post(id);
                                    post.demanarDades(sc, userLogin, usuaris);
                                    posts.add(post);
                                    id++;
                                    break;
                                case 2:
                                    Functions.llistar(rols[1], usuaris, userLogin);
                                    System.out.println("-----------------------");
                                    System.out.println("Escriu el nom de l'editor: ");
                                    String editor = sc.nextLine();
                                    if (Functions.usuariExisteix(usuaris, editor)) {
                                        if (Functions.getUsuari(usuaris, editor).getRol().equals(rols[1])) {
                                            usuaris.get(Functions.posicioUsuari(usuaris, userLogin))
                                                    .afegirArray(Functions.getUsuari(usuaris, editor));
                                            System.out.println("Estas seguint a l'editor " + editor);
                                        } else {
                                            System.out.println("L'usuari no és editor");
                                        }
                                    } else {
                                        System.out.println("Error, l'usuari no existeix");
                                    }
                                    break;
                                case 3:
                                    Functions.getUsuari(usuaris, userLogin).veureArray();
                                    break;
                                case 4:
                                    Functions.meuMur(posts, Functions.getUsuari(usuaris, userLogin));
                                    break;
                                case 0:
                                    break logout;
                            }
                        } else {
                            switch (opcioUsuari) {
                                case 1:
                                    Functions.llistar(rols[1], usuaris, userLogin);
                                    System.out.println("-----------------------");
                                    System.out.println("Escriu el nom de l'editor: ");
                                    String editor = sc.nextLine();
                                    if (Functions.usuariExisteix(usuaris, editor)) {
                                        if (Functions.getUsuari(usuaris, editor).getRol().equals(rols[1])) {
                                            usuaris.get(Functions.posicioUsuari(usuaris, userLogin))
                                                    .afegirArray(Functions.getUsuari(usuaris, editor));
                                            System.out.println("Estas seguint a l'editor " + editor);
                                        } else {
                                            System.out.println("L'usuari no és editor");
                                        }
                                    } else {
                                        System.out.println("Error, l'usuari no existeix");
                                    }
                                    break;
                                case 2:
                                    Functions.getUsuari(usuaris, userLogin).veureArray();
                                    break;
                                case 3:
                                    Functions.meuMur(posts,Functions.getUsuari(usuaris, userLogin));
                                    break;
                                case 0:
                                    break logout;
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("Digues el nom d'usuari únic: ");
                    Lector lector = new Lector(sc.nextLine(), rols[2]);
                    System.out.println("Introdueix el password");
                    lector.setPasswd(sc.nextLine());
                    System.out.println("Introdueix la data de naixament: (dd/MM/yyyy)");
                    lector.setMajor(Functions.major(sc.nextLine()));
                    usuaris.add(lector);
                    break;
                case 3:
                    System.out.println("Fins un altre!");
                    break outloop;
            }
        }

    }
}