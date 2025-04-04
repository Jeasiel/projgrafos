package projgrafos;

public class Aresta {
	
	Vertice v1, v2;
	int peso;
	
	public Aresta(Vertice v1, Vertice v2, int peso) {
		this.v1 = v1;
		this.v2 = v2;
		this.peso = peso;
	}
	
	@Override
	public String toString() {
		return "Conexão: " + v1.nome + " - " + v2.nome + ". Peso: " + peso + ".\n";
	}
}
