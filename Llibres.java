/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llibres;

import java.util.Scanner;

/**
 *
 * @author CUTU
 */
public class Llibres {

    /**
     * @param args the command line arguments
     */
    private static int inicialitzarLlibres(Llibre[] llibres) {
        llibres[0] = new Llibre();
        llibres[0].isbn = "2";
        llibres[0].titol = "a";
        llibres[0].autor = "x";
        llibres[0].editorial = "1a";

        llibres[1] = new Llibre();
        llibres[1].isbn = "1";
        llibres[1].titol = "b";
        llibres[1].autor = "x";
        llibres[1].editorial = "2a";

        llibres[2] = new Llibre();
        llibres[2].isbn = "4";
        llibres[2].titol = "d";
        llibres[2].autor = "y";
        llibres[2].editorial = "1b";

        llibres[3] = new Llibre();
        llibres[3].isbn = "3";
        llibres[3].titol = "c";
        llibres[3].autor = "w";
        llibres[3].editorial = "2a";
        return 4;
    }

    private static class Llibre {

        private String isbn;
        private String titol;
        private String autor;
        private String editorial;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Llibre[] llibres = new Llibre[10];
        int totalLlibres = inicialitzarLlibres(llibres);
        boolean sortir = false;
        do {
            int opcio = menu(entrada);
            switch (opcio) {
                case 1:
                    ordenarPerISBN(llibres, totalLlibres);
                    break;
                case 2:
                    llistarLlibres(llibres, totalLlibres);
                    break;
                case 3:
                    System.out.print("Nom autor: ");
                    entrada.nextLine();
                    String autor = entrada.nextLine();
                    llistarLlibresAutor(llibres, totalLlibres, autor);
                    break;
                case 4:
                    System.out.print("ISBN llibre: ");
                    String isbn = entrada.next();
                    Llibre llibre = buscarLlibre(llibres, totalLlibres, isbn);
                    if (llibre != null) {
                        System.out.println("ISBN: " + llibre.isbn);
                        System.out.println("Títol: " + llibre.titol);
                        System.out.println("Autor: " + llibre.autor);
                        System.out.println("Editorial: " + llibre.editorial);
                        System.out.println();
                    } else {
                        System.out.println("No existeix cap llibre amb ISBN " + isbn);
                    }
                    break;
                case 5:
                    sortir = true;
                    break;
            }
        } while (!sortir);

    }

    private static int menu(Scanner entrada) {
        System.out.println("Llibres");
        System.out.println("­­­­­­­­­­­­­­­­­");
        System.out.println("1.- Ordenar per isbn");
        System.out.println("2.- Llistar llibres");
        System.out.println("3.- Llistar llibres d'un autor");
        System.out.println("4.- Buscar per isbn (llibres ordenats)");
        System.out.println("5.- Sortir");
        System.out.print("Opció:");
        int opcio = entrada.nextInt();
        System.out.println();
        return opcio;
    }

    private static void ordenarPerISBN(Llibre[] llibres, int totalLlibres) {
        for (int i = 1; i < totalLlibres; i++) {
            for (int j = i; j > 0; j--) {
                if (llibres[j].isbn.compareTo(llibres[j - 1].isbn) < 0) {
                    swap(llibres, j, j - 1);
                }
            }
        }
    }

    private static void swap(Llibre[] v, int i1, int i2) {
        Llibre tmp = v[i1];
        v[i1] = v[i2];
        v[i2] = tmp;
    }

    private static void llistarLlibres(Llibre[] llibres, int totalLlibres) {
        System.out.println("Llistat llibres");
        System.out.println("---------------");
        System.out.println();
        for (int i = 0; i < totalLlibres; i++) {
            System.out.println("ISBN: " + llibres[i].isbn);
            System.out.println("Títol: " + llibres[i].titol);
            System.out.println("Autor: " + llibres[i].autor);
            System.out.println("Editorial: " + llibres[i].editorial);
            System.out.println();
        }
    }

    private static void llistarLlibresAutor(Llibre[] llibres, int totalLlibres, String autor) {
        System.out.println("Llistat llibres de l'autor: " + autor);
        System.out.println("--------------------------");
        System.out.println();
        for (int i = 0; i < totalLlibres; i++) {
            if (autor.equals(llibres[i].autor)) {
                System.out.println("ISBN: " + llibres[i].isbn);
                System.out.println("Títol: " + llibres[i].titol);
                System.out.println("Autor: " + llibres[i].autor);
                System.out.println("Editorial: " + llibres[i].editorial);
                System.out.println();
            }
        }
    }

    private static Llibre buscarLlibre(Llibre[] llibres, int totalLlibres, String isbn) {
        Llibre llibre = null;
        boolean esta = false;
        int i = 0;
        int f = totalLlibres - 1;
        while (!esta && i <= f) {
            int m = (i + f) / 2;
            if (isbn.compareTo(llibres[m].isbn) == 0) {
                esta = true;
                llibre = llibres[m];
            } else if (isbn.compareTo(llibres[m].isbn) < 0) {
                f = m - 1;
            } else { //isbn.compareTo(llibres[m].isbn > 0
                i = m + 1;
            }
        }
        return llibre;
    }
}
