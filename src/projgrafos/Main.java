package projgrafos;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		Leitor leitor = new Leitor();
		LinkedList<Vertice> listaVertices = leitor.ler();
		Dijkstra algoritmo = new Dijkstra();
		algoritmo.calcularMenoresDistancias(listaVertices, listaVertices.get(1), listaVertices.get(4));
		
	}
}
