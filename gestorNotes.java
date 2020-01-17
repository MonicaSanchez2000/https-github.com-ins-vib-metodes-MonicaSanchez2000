/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestornotes;

import java.util.Scanner;

/**
 *
 * @author alumne
 */
public class GestorNotes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GestorNotes n = new GestorNotes();
        double[] notes = new double[40];
        int numNotes = 0;
        String opcio = n.mostrarMenu();
        while (!opcio.equalsIgnoreCase("FI")) {
            switch (opcio.toUpperCase()) {
                case "RT":
                    numNotes = n.registrarNotes(notes, numNotes);
                    break;
                case "MJ":
                    System.out.println("La nota mitjana és de " + n.mitjana(notes, numNotes));
                    break;
                case "HT":
                    n.histograma(notes, numNotes);
                    break;
                case "FI":
                //Sortir.
                default:
                    System.out.println("Aquesta opció no és vàlida");
            }
            System.out.println("");
            opcio = n.mostrarMenu();
        }

    }

    String mostrarMenu() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Benvinguts als gestor de Notes");
        System.out.println("------------------------------");
        System.out.println("[RT] Registrar notes.");
        System.out.println("[MJ] Consultar nota mitjana.");
        System.out.println("[HT] Histograma de notes.");
        System.out.println("[FI] Sortir.");
        System.out.print("Què vols fer?: ");
        System.out.println();
        return entrada.next();
    }

    int registrarNotes(double notes[], int numNotes) {
        Scanner entrada = new Scanner(System.in);
        boolean acabar = false;
        double nota = 0;
        int i = 0;
        for (int j = 0; j < notes.length && !acabar; j++) {
            System.out.println("Introdueix la nota. Indica -1 per a finalitzar. ");
            nota = entrada.nextDouble();

            if (nota == -1) {
                acabar = true;
            } else {
                notes[numNotes] = nota;
                numNotes++;
            }
        }

        return numNotes;
    }

    double mitjana(double[] notes, int numNotes) {
        double resultat = 0, cont = 0;
        for (int i = 0; i < notes.length; i++) {
            cont = cont + notes[i];
        }
        resultat = cont / numNotes;

        return resultat;
    }

    void histograma(double[] notes, int numNotes) {
        int[] histograma = new int[4];

        for (int i = 0; i < numNotes; i++) {
            if (notes[i] > 0 && notes[i] < 5) {
                histograma[0]++;
            }

            if (notes[i] >= 5 && notes[i] < 7) {
                histograma[1]++;

            }
            if (notes[i] >= 7 && notes[i] < 9) {
                histograma[2]++;

            }
            if (notes[i] >= 9 && notes[i] <= 10) {
                histograma[3]++;
            }

        }
        for (int i = 0; i < histograma.length; i++) {
            switch (i) {
                case 0:
                    System.out.println("Suspes");
                    break;
                case 1:
                    System.out.println("Aprobat");
                    break;
                case 2:
                    System.out.println("Notable");
                    break;
                case 3:
                    System.out.println("Exelent");
                    break;

            }
            for (int j = 0; j < histograma[i]; j++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }
}
