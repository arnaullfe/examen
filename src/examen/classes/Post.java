package examen.classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
    private String titol,contingut;
    private Usuari creador;
    private boolean majors18;
    private LocalDateTime dia;
    private int id;
    public Post(String titol,int id) {
        this.titol = titol;
        this.id = id;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getContingut() {
        return contingut;
    }

    public void setContingut(String contingut) {
        this.contingut = contingut;
    }

    public Usuari getCreador() {
        return creador;
    }

    public void setCreador(Usuari creador) {
        this.creador = creador;
    }

    public boolean isMajors18() {
        return majors18;
    }

    public void setMajors18(boolean majors18) {
        this.majors18 = majors18;
    }

    public LocalDateTime getDia() {
        return dia;
    }

    public void setDia(LocalDateTime dia) {
        this.dia = dia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void mostraTot(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
        System.out.println("----------------------------------");
        System.out.println("Data: "+formatter.format(this.dia));
        System.out.println("Titol: "+this.titol);
        System.out.println("Contingut: "+this.contingut);
        System.out.println("És per majors? :"+this.majors18);
        System.out.println("Usuari creador: "+this.creador.username);
        System.out.println("----------------------------------");
    }
    
    public void mostraInfo(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
        System.out.println(this.id+" - Data: "+formatter.format(this.dia)+" - Autor: "+this.creador.username+" - Títol: "+this.titol);
    }

    
}