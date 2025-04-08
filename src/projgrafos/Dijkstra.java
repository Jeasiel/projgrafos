package projgrafos;

import java.util.LinkedList;

public class Dijkstra {

    public void calcularMenoresDistancias(LinkedList<Vertice> vertices, Vertice origem, Vertice destino) {
        int n = vertices.size();
        int[] distancias = new int[n];
        boolean[] visitados = new boolean[n];
        Vertice[] predecessores = new Vertice[n];

        for (int i = 0; i < n; i++) {
            distancias[i] = Integer.MAX_VALUE;
        }

        int origemIndex = vertices.indexOf(origem);
        distancias[origemIndex] = 0;

        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!visitados[j] && (u == -1 || distancias[j] < distancias[u])) {
                    u = j;
                }
            }

            if (distancias[u] == Integer.MAX_VALUE) {
            	break;
            }

            visitados[u] = true;
            Vertice atual = vertices.get(u);

            for (Aresta aresta : atual.listaArestas) {
                Vertice vizinho = (aresta.v1 == atual) ? aresta.v2 : aresta.v1;
                int v = vertices.indexOf(vizinho);
                if (visitados[v]) continue;

                int novaDist = distancias[u] + aresta.peso;
                if (novaDist < distancias[v]) {
                    distancias[v] = novaDist;
                    predecessores[v] = atual;
                }
            }
        }

        mostrarCaminho(vertices, origem, destino, predecessores, distancias);
        /** System.out.println("Distâncias a partir do vértice " + origem.nome + ":");
        for (int i = 0; i < n; i++) {
            System.out.print(vertices.get(i).nome + ": ");
            if (distancias[i] == Integer.MAX_VALUE) {
                System.out.println("Infinito");
            } else {
                System.out.println(distancias[i]);
            }
        }
        */
    }
    public void mostrarCaminho(LinkedList<Vertice> vertices, Vertice origem, Vertice destino, Vertice[] predecessores, int[] distancias) {
        LinkedList<Vertice> caminho = new LinkedList<Vertice>();
        Vertice atual = destino;
        int pesoTotal = 0;

        while (atual != null && !atual.equals(origem)) {
            caminho.addFirst(atual);
            Vertice predecessor = predecessores[vertices.indexOf(atual)];
            
            for (Aresta aresta : predecessor.listaArestas) {
                if ((aresta.v1.equals(predecessor) && aresta.v2.equals(atual)) || 
                    (aresta.v2.equals(predecessor) && aresta.v1.equals(atual))) {
                    pesoTotal += aresta.peso;
                    break;
                }
            }
            atual = predecessor;
        }

        if (atual == null) {
            System.out.println("Não existe caminho de " + origem.nome + " até " + destino.nome);
        } else {
            caminho.addFirst(origem);
            System.out.print("Caminho de " + origem.nome + " até " + destino.nome + ": ");
            for (int i = 0; i < caminho.size(); i++) {
                System.out.print(caminho.get(i).nome);
                if (i < caminho.size() - 1) System.out.print(" -> ");
            }
            System.out.println("\nPeso total do caminho: " + pesoTotal);
        }
    }
}