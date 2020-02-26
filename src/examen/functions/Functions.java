package examen.functions;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import examen.classes.Post;
import examen.classes.Usuari;

public class Functions {
    public static void benvinguda(){
        System.out.println("*********************************");
        System.out.println("* Benvingut a CirvSocialNetwork *");
        System.out.println("*********************************");
    }

    public static boolean contrasenyaValida(String passwd, String passwdConfirm){
        boolean valid = true;
        if(!passwd.equals(passwdConfirm)){
            System.out.println("Les contrasenyes no són iguals!, torna-ho a intentar");
            valid=false;
        } 
        return valid;
    }

    public static void menu(){
        System.out.println("******************************");
        System.out.println("* 1 - Login                  *");
        System.out.println("* 2 - Registre com a Lector  *");
        System.out.println("* 3 - Sortir                 *");
        System.out.println("******************************");
    }

    public static boolean comprovarUsuariPasswd(ArrayList<Usuari> usuaris,String userLogin, String passwdLogin){
        boolean valid = false;
        for (Usuari a : usuaris){
            if(a.getUsername().equals(userLogin)){
                if(a.getPasswd().equals(passwdLogin)){
                    valid=true;
                    break;
                } else{
                    System.out.println("Contrasenya invàlida");
                    break;
                }
            }
        }
        return valid;
    }

    public static Usuari getUsuari(ArrayList<Usuari> usuaris,String userLogin){
        for(Usuari a : usuaris){
            if(a.getUsername().equals(userLogin)){
                return a;
            }
        }
        return null;
    }

    public static boolean usuariExisteix(ArrayList<Usuari> usuaris,String usuariLogin){
        boolean existeix = false;
        for (Usuari a: usuaris){
            if(usuariLogin.equals(a.getUsername())){
                existeix=true;
            }
        }
        if(!existeix){
            System.out.println("L'usuari indict no existeix!");
        }
        return existeix;
    }
    public static void mostraTotsPosts(ArrayList<Post> posts,Scanner sc){
        for( Post a: posts){
            a.mostraTot();
            System.out.println("Enter per continuar:");
            sc.nextLine();
        }
    }
    public static void mostraPostsInfo(ArrayList<Post> posts){
        for( Post a: posts){
            a.mostraInfo();
        }
    }
    public static void elimina(ArrayList<Post> posts)
}