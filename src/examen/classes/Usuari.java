package examen.classes;

import java.util.ArrayList;

public abstract class Usuari {
    protected String username,passwd,rol;

    public Usuari(String username,String rol) {
        this.username = username;
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public abstract String toString();
    public abstract void menuUsuari();
    public abstract ArrayList<Usuari> follows();
    public abstract void afegirArray(Usuari usuari);
    public abstract void veureArray();
}