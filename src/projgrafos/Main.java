package projgrafos;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		/** //Código de cálculo dos pesos
	   	Scanner sc = new Scanner(System.in);
		while(s!=1000){
    		int cf = sc.nextInt();
	    	int ca = sc.nextInt();
		    int d = sc.nextInt();
		    int s = (4 * cf + 2 * ca)/6 + d;
		    int r = (4 * cf + 2 * ca)%6;
		    if(r >= 3){
		        s++;
		    }
		    System.out.println("N: " + cf + ", " + ca + ", " + d + ": " + s);
	    }
	    sc.close();
	    */
		
		Scanner sc = new Scanner(System.in);
		Leitor leitor = new Leitor();
		LinkedList<Vertice> listaVertices = leitor.ler();
		Dijkstra algoritmo = new Dijkstra();
		String line = sc.nextLine();
		int p1 = 0, p2 = 0;
		boolean p1enc = false, p2enc = false;
		for(int i = 0; i < listaVertices.size(); i++) {
			if(listaVertices.get(i).nome.equals(line.substring(0, 3).toUpperCase()) && !p1enc) {
				p1 = i;
				p1enc = true;
			}
			if(listaVertices.get(i).nome.equals(line.substring(3, 6).toUpperCase()) && !p2enc) {
				p2 = i;
				p2enc = true;
			}
			if(p1enc && p2enc) {
				break;
			}
		}
		algoritmo.calcularMenoresDistancias(listaVertices, listaVertices.get(p1), listaVertices.get(p2));
		sc.close();
	}
}
