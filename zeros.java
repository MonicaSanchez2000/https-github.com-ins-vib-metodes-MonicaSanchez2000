package ex5uf2zeros;

import java.util.Random;
import java.util.Scanner;

public class Ex5Uf2Zeros {
	public static void main(String[] args) {
	Ex5Uf2Zeros programa = new Ex5Uf2Zeros();
	Scanner entrada = new Scanner(System.in);

	int contador = 0;
	int encerts = 0;
	String[][] x1 = new String[5][5]; /*Creació de les 2 matrius, una per a tindre els 0 generats*/
	String[][] x2 = new String[5][5]; /*La segona será la que es mostra, sense 0 i si encerta els mostrará*/

	programa.inicialitzar(x1); /*Inicialitzar les 2 matrius*/
	programa.inicialitzar(x2);

	for (int i = 0; i < 5; i++) {/*A la primera li introduim els 0 aleatoris, 5 nombres*/
	programa.random(x1);
	}

	programa.imprimir(x1);
	System.out.println("");

	while(contador != 8){
		programa.imprimir(x2);
		System.out.print("Introdueix la fila <0-4>: ");
		int fila = entrada.nextInt();
		System.out.print("Introdueix la fila <0-4>: ");
		int columna = entrada.nextInt();

		boolean trobat = programa.comparar(x1,x2,fila,columna); //mirar si ha encertat
		if (trobat == true) { //incrementar encerts
			encerts++;
		}

		if (encerts == 5) { //acaba el programa si ha trobat tots els 0
			System.out.println("");
			System.out.println("¡Has trobat tots els 0!");
	break;
	}

		contador++; //incrementar els contador general
		System.out.println("");
	}
		
		System.out.println("Encerts: "+encerts);
}

	void inicialitzar(String matriu[][]){ //Introdueix les X a les matrius
	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			matriu[i][j] = "X";
		}
	}
}

	void random(String matriu[][]){ //genera les posicions random + comprova que no es repeteix, si es repeteix repetir random
	Random random = new Random();
	int f = random.nextInt(5);
	int c = random.nextInt(5);
	boolean trobat = comprovar(matriu, f, c);
	if (trobat == true) {
		random(matriu);
	} else {
		matriu[f][c] = "0";
}
}

	void imprimir(String matriu[][]){ //imprimeix la matriu
	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			System.out.print(matriu[i][j]);
		}
		System.out.println("");
	}
}

	boolean comparar(String matriu[][],String matriu2[][], int fila, int columna){ //mirar si ha encertat
	boolean trobat = false;
	if (matriu[fila][columna].equals("0")) {
		trobat = true;
		matriu2[fila][columna]="0"; //al encertar mostra el 0 a la posició
	}
	return trobat;
}

	boolean comprovar(String matriu[][], int fila, int columna){ //comprovar que el 0 generat no estigui repetit
	boolean trobat = false;
	if(matriu[fila][columna].equals("0")){
		trobat = true;
	}
	return trobat;
	}
}