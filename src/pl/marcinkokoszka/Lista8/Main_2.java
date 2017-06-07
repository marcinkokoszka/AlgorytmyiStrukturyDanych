package pl.marcinkokoszka.Lista8;

public class Main_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
GraphAdjacencyList gal = new GraphAdjacencyList(8);
		

		//Zadanie 2 - macierz
		GraphAdjacencyMatrix G = new GraphAdjacencyMatrix(5, 6);
		System.out.println(G);
		
		//Zadanie 2 - lista
		gal.setEdge(5, 1);
		gal.setEdge(6, 1);
		gal.setEdge(7, 1);
		gal.setEdge(2, 5);
		gal.setEdge(3, 5);
		gal.setEdge(8, 6);
		gal.setEdge(5, 7);
		
		gal.printAdjacencyList();
		
		System.out.println();
		
		
		
		
		
		//Zadanie 3
		Node nA=new Node('A');
		Node nB=new Node('B');
		Node nC=new Node('C');
		Node nD=new Node('D');
		Node nE=new Node('E');
		Node nF=new Node('F');

		Graph g=new Graph();
		g.addNode(nA);
		g.addNode(nB);
		g.addNode(nC);
		g.addNode(nD);
		g.addNode(nE);
		g.addNode(nF);
		g.setRootNode(nA);
		
		g.connectNode(nA,nB);
		g.connectNode(nA,nC);
		g.connectNode(nA,nD);
		
		g.connectNode(nB,nE);
		g.connectNode(nB,nF);
		g.connectNode(nC,nF);
		
		System.out.println("\nPrzeszukiwanie wszerz:");
		g.bfs();
		
		System.out.println("Przeszukiwanie w g��b:");
		g.dfs();
		
		
		System.out.println();
		
		
	}

}
