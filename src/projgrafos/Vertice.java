package projgrafos;

import java.util.LinkedList;

public class Vertice {
	
	String nome;
	// int id manipulado pela lista de vertices no leitor
	LinkedList<Aresta> listaArestas;
	
	public Vertice(String nome) {
		this.nome = nome;
		listaArestas = new LinkedList<Aresta>();
	}
	
	public LinkedList<Vertice> getVizinhos() {
		LinkedList<Vertice> vizinhos = new LinkedList<Vertice>();
		for(int i = 0; i < listaArestas.size(); i++) {
			if(listaArestas.get(i).v1.equals(this)) {
				vizinhos.add(listaArestas.get(i).v2);
			} else {
				vizinhos.add(listaArestas.get(i).v1);
			}
		}
		return vizinhos;
	}
	
	@Override
	public String toString() {
		String saida = nome + ":\n";
		for(int i = 0; i < listaArestas.size(); i++) {
			saida += listaArestas.get(i).toString();
		}
		return saida;
	}
}
