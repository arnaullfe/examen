package examen.functions;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import examen.classes.Editor;
import examen.classes.Lector;
import examen.classes.Post;
import examen.classes.Usuari;

public class Functions {
    public static void benvinguda() {
        System.out.println("*********************************");
        System.out.println("* Benvingut a CirvSocialNetwork *");
        System.out.println("*********************************");
    }

    public static boolean contrasenyaValida(String passwd, String passwdConfirm) {
        boolean valid = true;
        if (!passwd.equals(passwdConfirm)) {
            System.out.println("Les contrasenyes no són iguals!, torna-ho a intentar");
            valid = false;
        }
        return valid;
    }

    public static void menu() {
        System.out.println("******************************");
        System.out.println("* 1 - Login                  *");
        System.out.println("* 2 - Registre com a Lector  *");
        System.out.println("* 3 - Sortir                 *");
        System.out.println("******************************");
    }

    public static boolean comprovarUsuariPasswd(ArrayList<Usuari> usuaris, String userLogin, String passwdLogin) {
        boolean valid = false;
        for (Usuari a : usuaris) {
            if (a.getUsername().equals(userLogin)) {
                if (a.getPasswd().equals(passwdLogin)) {
                    valid = true;
                    break;
                } else {
                    System.out.println("Contrasenya invàlida");
                    break;
                }
            }
        }
        return valid;
    }

    public static Usuari getUsuari(ArrayList<Usuari> usuaris, String userLogin) {
        for (Usuari a : usuaris) {
            if (a.getUsername().equals(userLogin)) {
                return a;
            }
        }
        return null;
    }

    public static boolean usuariExisteix(ArrayList<Usuari> usuaris, String usuariLogin) {
        boolean existeix = false;
        for (Usuari a : usuaris) {
            if (usuariLogin.equals(a.getUsername())) {
                existeix = true;
            }
        }
        if (!existeix) {
            System.out.println("L'usuari indicat no existeix!");
        }
        return existeix;
    }

    public static void mostraTotsPosts(ArrayList<Post> posts, Scanner sc) {
        for (Post a : posts) {
            a.mostraTot();
            System.out.println("Enter per continuar:");
            sc.nextLine();
        }
    }

    public static void mostraPostsInfo(ArrayList<Post> posts) {
        for (Post a : posts) {
            a.mostraInfo();
        }
    }

    public static int elimina(ArrayList<Post> posts, int id) {
        for (Post a : posts) {
            if (id == a.getId()) {
                return posts.indexOf(a);
            }
        }
        return -1;
    }

    public static void llistar(String rol, ArrayList<Usuari> usuaris, String user) {
        System.out.println("Llistat de usuaris amb rol de " + rol);
        System.out.println("--------------------------------------");
        for (Usuari a : usuaris) {
            if (rol.equals(a.getRol()) && !user.equals(a.getUsername())) {
                System.out.println(a.getUsername());
            }
        }
    }

    public static boolean major(String data) {
        boolean major;
        String[] array = data.split("/");
        LocalDate ld = LocalDate.parse(array[2] + "-" + array[1] + "-" + array[0]);
        Period period = Period.between(ld, LocalDate.now());
        int anys = period.getYears();
        if (anys >= 18) {
            major = true;
        } else {
            major = false;
        }
        System.out.println("Anys: " + anys);
        return major;
    }

    public static Usuari LectorToEditor(Usuari lector, String rol) {
        Editor editor = new Editor(lector.getUsername(), rol);
        editor.setPasswd(lector.getPasswd());
        editor.setFollows(lector.follows());
        return editor;
    }

    public static int posicioUsuari(ArrayList<Usuari> usuaris, String username) {
        for (Usuari a : usuaris) {
            if (username.equals(a.getUsername())) {
                return usuaris.indexOf(a);
            }
        }
        return -1;
    }

    public static boolean postExisteix(ArrayList<Post> posts, int post) {
        for (Post a : posts) {
            if (post == a.getId()) {
                return true;
            }
        }
        return false;
    }

    public static void meuMur(ArrayList<Post> posts, Usuari usuari) {
        for (Post b : posts) {
            if (b.getCreador().getRol().equals("admin") || usuari.getUsername().equals(b.getCreador().getUsername())) {
                if ((b.isMajors18()) && (!usuari.major())) {
                    System.out.println("Contingut restringit. Usuari Menor d'edat.");
                } else {
                    b.mostraTot();
                }
                System.out.println("Enter per continuar: ");
                System.console().readLine();
            }
            for (Usuari a : usuari.follows()) {
                if (a.getUsername().equals(b.getCreador().getUsername())) {
                    if ((b.isMajors18()) && (!usuari.major())) {
                        System.out.println("----------------------------------");
                        System.out.println("Contingut restringit. Usuari Menor d'edat.");
                        System.out.println("----------------------------------");
                    } else {
                        b.mostraTot();
                    }
                    System.out.println("Enter per continuar: ");
                    System.console().readLine();
                }
            }
        }
    }

    public static void llistarEditorsNoSguits(String rol, ArrayList<Usuari> usuaris, String user, ArrayList<Usuari> follows) {
        System.out.println("Llistat de usuaris amb rol de " + rol);
        System.out.println("--------------------------------------");
        for (Usuari a : usuaris) {
            if (rol.equals(a.getRol()) && !a.getUsername().equals(user)) {
                boolean seguit = false;
                for (Usuari b : follows) {
                    if (a.getUsername().equals(b.getUsername())) {
                        seguit = true;
                    }
                }
                if (!seguit) {
                    System.out.println(a.getUsername());
                }
            }
        }
    }
}