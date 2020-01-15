package ex4uf2parquing;

import java.util.Scanner;

public class Ex4Uf2Parquing {
	public static void main(String[] args) {
	Scanner entrada = new Scanner(System.in);
	Ex4Uf2Parquing programa = new Ex4Uf2Parquing();
	String[] places = new String[10];
	String opcio = "";
	int estat = 0;

	programa.inicialitzar(places);

	while(!opcio.equals("fi")){
		programa.mostrarMenu();
		opcio = programa.triaOpcio();

	if (opcio.equals("aparcar")) {
		if (estat == 10) {
			System.out.println("¡El parquing esta complert!");
			System.out.println(" ");
	} else {
		System.out.print("Introdueix la teva matrícula: ");
		String matricula = entrada.next();
		programa.aparcar(places,matricula);
		estat ++;
	}
}

if (opcio.equals("marxar")) {
System.out.print("Introdueix la teva matrícula: ");
String matricula = entrada.next();
if (programa.cercarMatricula(places, matricula) == false) {
System.out.println("¡El cotxe no está aparcat!");
System.out.println(" ");
} else{
programa.marxar(places, matricula);
estat--;
}
}
}

programa.mostrarParquing(places);

}

void inicialitzar(String places[]){
for (int i = 0; i < places.length; i++) {
places[i]="";
}
}

void mostrarMenu(){
System.out.println("-- Menú --");
System.out.println("1.Aparcar");
System.out.println("2.Marxar");
System.out.println("3.Fi");
System.out.println("----------");
}

String triaOpcio(){
Scanner entrada = new Scanner(System.in);
String opcio = " ";

while((!opcio.equals("marxar")) && (!opcio.equals("aparcar")) && (!opcio.equals("fi"))){
System.out.print("Introdueix la teva respota: ");
opcio = entrada.next();
}
System.out.println(" ");
return opcio;
}

void aparcar(String places[], String matricula){
for (int i = 0; i < places.length; i++) {
if (cercarMatricula(places, matricula) == true) {
System.out.println("¡El coche ja está aparcat!");
System.out.println(" ");
break;
}

if (places[i].equals("")) {
places[i] = matricula;
System.out.println("");
break;
}
}
}

boolean cercarMatricula(String vector[], String matricula){
boolean trobat = false;
for(int i = 0; i < vector.length; i++) {
if (vector[i].equals(matricula)){
trobat = true;
}
}
return trobat;
}

void marxar(String places[], String matricula){
for (int i = 0; i < places.length; i++) {
if (places[i].equals(matricula)) {
places[i] = "";
}
}


}

void mostrarParquing(String places[]){
int contador = 0;
for (int i = 0; i < places.length; i++) {
if (places[i].equals("")) {
contador++;
}
}

if (contador>0) {
System.out.println("Hi han "+contador+" places lliures.");
} else {
System.out.println("¡El pàrquing està complert!");
}
};

}
