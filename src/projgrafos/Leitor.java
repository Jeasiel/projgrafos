package projgrafos;
import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class Leitor {
	
	/*
	 * 	Entrada	|	Saída
		3 2		|	A: D
		A		|	D: A E
		D		|	E: D
		E		|	Mudei a saída para ficar mais legível com os pesos
		AD		|	
		DE		|	
	 */
	
	public LinkedList<Vertice> ler() {
		int vertices = 0, arestas = 0;
		LinkedList<Vertice> listaVertice = new LinkedList<Vertice>();
		
		try {
			File arq = new File(System.getProperty("user.dir") + "\\src\\projgrafos\\grafo.txt");
			Scanner sc = new Scanner(arq);
			
			if(sc.hasNextLine()) {
				String header = sc.nextLine();
				vertices = Integer.parseInt("" + header.charAt(0));
				arestas = Integer.parseInt("" + header.charAt(2));
			}
			
			for(int i = 0; i < vertices; i++) {
				listaVertice.add(new Vertice(sc.nextLine()));
			}
			
			for(int i = 0; i < arestas; i++) {
				String line = sc.nextLine();
				for(int j = 0; j < vertices; j++) {
					if(listaVertice.get(j).nome.equals("" + line.charAt(0))) { //line.substring(0, 3)
						for(int k = 0; k < vertices; k++) {
							if(listaVertice.get(k).nome.equals("" + line.charAt(1))) {
								int corte = 2;
								if(line.substring(line.length() - 2).charAt(0) == ' ') {
									corte = 1;
								}
								listaVertice.get(j).listaArestas.add(new Aresta(listaVertice.get(j), listaVertice.get(k), Integer.parseInt(line.substring(line.length() - corte))));
								listaVertice.get(k).listaArestas.add(new Aresta(listaVertice.get(k), listaVertice.get(j), Integer.parseInt(line.substring(line.length() - corte))));
							}
						}
						break;
					}
				}
			}
			
			for(int i = 0; i < vertices; i++) {
				System.out.println(listaVertice.get(i).toString());
			}
			
			sc.close();
		    
		} catch (Exception e) {
		    System.out.println("Um erro aconteceu com a leitura do arquivo");
		      	e.printStackTrace();
		}
		return listaVertice;
	}
	
}
