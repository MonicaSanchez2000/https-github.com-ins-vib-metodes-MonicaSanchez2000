/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package castellers;

/**
 *
 * @author CUTU
 */
public class Castellers {

    /**
     * @param args the command line arguments
     */
   private static void mostrarCastellsColla(int[] codis_castells_principals, int totalCastellsColla) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static class Castell {

        @SuppressWarnings("FieldMayBeFinal")
        private int codi;
        @SuppressWarnings("FieldMayBeFinal")
        private String descripcio;
        @SuppressWarnings("FieldMayBeFinal")
        private int punts_carregats;
        @SuppressWarnings("FieldMayBeFinal")
        private int punts_descarregats;

        public Castell(int codi, String descripcio, int punts_carregats, int punts_descarregats) {
            this.codi = codi;
            this.descripcio = descripcio;
            this.punts_carregats = punts_carregats;
            this.punts_descarregats = punts_descarregats;
        }

    }

    private static class Colla {

        private String nom;
        private String Localitat;
        private int[] codis_castells_principals;

        public Colla(String nom, String Localitat, int[] codis_castells_principals) {
            this.nom = nom;
            this.Localitat = Localitat;
            this.codis_castells_principals = codis_castells_principals;
        }

    }

    public static void main(String[] args) {
        Castell[] arrayCastell = {
            new Castell(1, "Quatre de set", 800, 980),
            new Castell(27, "Tres de deu amb folre i manilles", 12500, 13200),
            new Castell(3, "Quatre de set amb l'agulla", 1220, 1440),
            new Castell(22, "Quatre de nou amb folre i l'agulla", 9200, 9800),
            new Castell(2, "Tres de set", 1000, 1200),
            new Castell(21, "Cinc de nou amb folre", 8600, 9180),
            new Castell(20, "Pilar de vuit amb folre i manilles", 8020, 8580)};
        int[] codis = {21, 3, 20};
        int[] codis2 = {2, 1, 3};
        int[] codis3 = {22, 20, 21};
        int[] codis4 = {27, 22, 20};
        Colla[] arrayColla = {
            new Colla("Colla Vella dels Xiquets de Valls", "Valls", codis),
            new Colla("Xiquets del Serrallo", "Tarragona", codis2),
            new Colla("Minyons de Terrassa", "Terrassa", codis3),
            new Colla("Xiquets de Vilafranca", "Vilafranca", codis4)};
        Dades_colla(arrayColla, arrayColla.length, "Minyons de Terrassa", arrayCastell, arrayCastell.length);
        System.out.println();
        Colles_castell(arrayCastell, arrayCastell.length, "Pilar de vuit amb folre i manilles", arrayColla, arrayColla.length);
    }

   private static void Dades_colla(Colla[] arrayColla, int totalColles, String nom_colla, Castell[] arrayCastell, int totalCastells) {
        int indexColla = cercarColla(arrayColla, totalColles, nom_colla);
        if (indexColla != -1) {
            System.out.println("Colla: " + arrayColla[indexColla].nom);
            int totalCastellsColla = arrayColla[indexColla].codis_castells_principals.length;
            mostrarCastellsColla(arrayColla[indexColla].codis_castells_principals, totalCastellsColla, arrayCastell, totalCastells);
        }
    }

    private static int cercarColla(Colla[] arrayColla, int totalColles, String nomColla) {
        boolean esta = false;
        int i = 0;
        while (!esta && i < totalColles) {
//            if (arrayColla[i].nom.compareTo(nomColla) == 0) {
            if (arrayColla[i].nom.equals(nomColla)) {
                esta = true;
            } else {
                i = i + 1;
            }
        }
        if (!esta) {
            i = -1;
        }
        return i;
    }

    private static int cercarCastell(Castell[] arrayCastell, int totalCastells, int codiCastell) {
        boolean esta = false;
        int i = 0;
        while (!esta && i < totalCastells) {
            if (arrayCastell[i].codi == codiCastell) {
                esta = true;
            } else {
                i = i + 1;
            }
        }
        if (!esta) {
            i = -1;
        }
        return i;
    }

    private static void mostrarCastellsColla(int[] codis_castells_principals, int totalCastellsColla, Castell[] arrayCastell, int totalCastells) {
        for (int i = 0; i < totalCastellsColla; i++) {
            int indexCastell = cercarCastell(arrayCastell, totalCastells, codis_castells_principals[i]);
            if (indexCastell != -1) {
                System.out.println("Castell: " + arrayCastell[indexCastell].descripcio);
            }
        }
    }

    private static void Colles_castell(Castell[] arrayCastell, int totalCastells, String nom_castell, Colla[] arrayColla, int totalColles) {
        int indexCastell = cercarCastellPerNom(arrayCastell, totalCastells, nom_castell);
        if (indexCastell != -1) {
            System.out.println("Castell: " + nom_castell);
            for (int i = 0; i < totalColles; i++) {
                int[] arrayCodisCastellColla = arrayColla[i].codis_castells_principals;
                int index2 = cercarCodiCastell(arrayCodisCastellColla, arrayCodisCastellColla.length, arrayCastell[indexCastell].codi);
                if (index2 != -1) { //La colla fa aquest castell (index2 cpinicideix amb indexCastell)
                    System.out.println("Colla: " + arrayColla[i].nom);
                }
            }
        }
    }

    private static int cercarCastellPerNom(Castell[] arrayCastell, int totalCastells, String nom_castell) {
        boolean esta = false;
        int i = 0;
        while (!esta && i < totalCastells) {
            if (arrayCastell[i].descripcio.equals(nom_castell)) {
                esta = true;
            } else {
                i = i + 1;
            }
        }
        if (!esta) {
            i = -1;
        }
        return i;
    }

    private static int cercarCodiCastell(int[] arrayCodisCastell, int totalCodis, int codi) {
        boolean esta = false;
        int i = 0;
        while (!esta && i < totalCodis) {
            if (arrayCodisCastell[i] == codi) {
                esta = true;
            } else {
                i = i + 1;
            }
        }
        if (!esta) {
            i = -1;
        }
        return i;
    }

//Cercar un l'element valor a l'array v. Retotna Ã±a posiciÃ³ on estÃ¡ l'element si el troba i -1 si no el troba.
    private static int cercar(int[] v, int n, int valor) {
        boolean esta = false;
        int i = 0;
        while (!esta && i < n) {
//            if (v[i].equals(valor)) { //Si el vector Ã©s d'objectes (per exemple un array d'String)
//            if (v[i].compareTo(valor) == 0) { //Si el vector Ã©s d'objectes (per exemple un array d'String). Equivalent a la lÃ­nia de dalt
            if (v[i] == valor) {
                esta = true;
            } else {
                i = i + 1;
            }
        }
        if (!esta) {
            i = -1;
        }
        return i;
    }
    
    //Esquema de recorregut i tractament de tots els elements d'un vector
    //Exemples d'aplicaciÃ³:
    // - Carregar array
    // - Sumar tots els elements, cÃ lcul mitjana
    // - Mostrar array
    // - Trobar mÃ xim o mÃ­nim
    // - Comptar elements iguals a un donat (menor o majors)
    // - Comptar parells
    // - ...
    private static void tractamentTotsElementsVector(int[] v, int n) {
        for (int i = 0; i < n; i++) {
           //Tractar element vector (v[i]). Podem fer un tractament o altre en funciÃ³ d'una condiciÃ³.
            
        }
    }
}
    

