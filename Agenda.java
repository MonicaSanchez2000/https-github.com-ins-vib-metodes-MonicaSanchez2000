/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.Scanner;

/**
 *
 * @author CUTU
 */
public class Agenda {

    private String cognom;
    private String nom;
    private String telefon;
    private int Persona;

    private Persona cercaPersona(Persona[] agenda, int nPersones, String cognoms) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int crearPersona(Persona[] agenda, char opcioTriada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @param args the command line arguments
     */
    
     private static class Persona {

        private String nom;
        private String cognoms;
        private String telefon;
    }
     
    public static void main(String[] args) {
       Agenda programa = new Agenda();
       programa.inici();
       char opcioTriada = programa.menu();
       Persona[] agenda = null;
       programa.llistaAgenda(agenda, opcioTriada);
       int personaCreada = programa.crearPersona(agenda, opcioTriada);
       int personaTrobada = programa.cercaPersona(agenda, personaCreada);
       char resposta = programa.menu();
    }

    void inici() {
        Persona[] agenda = new Persona[10];
        int nPersones = 0;
    }
    
    char menu(){
        Scanner entrada = new Scanner(System.in);
        char resposta = entrada.next().charAt(0);
        System.out.println("---Menú---");
        System.out.println("1. Crear persona");
        System.out.println("2. Cercar persona");
        System.out.println("Llista agenda");
        System.out.println();
        return resposta;
    }
    
    int crearPersona (Persona[] agenda, int nPersones, String cognoms){
        boolean creada = false;
        if (nPersones < 10) {
            Persona p;
            p = cercaPersona (agenda, nPersones, cognoms);
            
            if (p == null) {
                p = new Persona();
                p.nom = nom;
                p.cognoms = cognom;
                
                agenda[nPersones] = p;
                creada = true;
                
            }
        }
         return Persona;


        
    }
    
    int cercaPersona (Persona[] agenda, int nPersones){
        boolean trobat = false;
        for (int x = 0; x < agenda.length; x++) {
            if (!trobat) {
                
            }
        }
        return 0;
    }
    
    void llistaAgenda(Persona[] agenda, int nPersones){
        
        System.out.println("Llista de persones de l'agenda: " + agenda.toString() + " \n" + " i el nombre de perones és: " + nPersones);

    }
}
