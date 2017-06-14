package pl.marcinkokoszka.Lista8;

public class Main8_2_3 {

    public static void main(String[] args) {
        //Zadanie 2 - lista sąsiedztwa - skierowany
        System.out.println("Graf - lista sąsiedztwa - skierowany:");
        GraphAdjacencyListDirected gal = new GraphAdjacencyListDirected(8);
        gal.addEdge(5, 1);
        gal.addEdge(6, 1);
        gal.addEdge(7, 1);
        gal.addEdge(2, 5);
        gal.addEdge(3, 5);
        gal.addEdge(8, 6);
        gal.addEdge(5, 7);

        System.out.println(gal);

        System.out.println();

        //Zadanie 2 - lista sąsiedztwa - nieskierowany
        System.out.println("Graf - lista sąsiedztwa - nieskierowany:");
        GraphAdjacencyList gald = new GraphAdjacencyList(8);
        gald.addEdge(5, 1);
        gald.addEdge(6, 1);
        gald.addEdge(7, 1);
        gald.addEdge(2, 5);
        gald.addEdge(3, 5);
        gald.addEdge(8, 6);
        gald.addEdge(5, 7);

        System.out.println(gald);

        System.out.println();

        //Zadanie 2 - lista sąsiedztwa - nieskierowany
        System.out.println("Graf - lista incydencji - skierowany:");
        GraphIncidenceMatrixDirected gimd = new GraphIncidenceMatrixDirected(8);
        gimd.addEdge(4, 0);
        gimd.addEdge(5, 0);
        gimd.addEdge(6, 0);
        gimd.addEdge(1, 4);
        gimd.addEdge(2, 4);
        gimd.addEdge(7, 5);
        gimd.addEdge(4, 6);

        System.out.println(gimd);

        System.out.println();

        //Zadanie 2 - macierz sąsiedztwa - skierowany
        System.out.println("Graf - macierz sąsiedztwa - skierowany:");
        GraphAdjacencyMatrixDirected gamd = new GraphAdjacencyMatrixDirected(8);
        gamd.addEdge(4, 0);
        gamd.addEdge(5, 0);
        gamd.addEdge(6, 0);
        gamd.addEdge(1, 4);
        gamd.addEdge(2, 4);
        gamd.addEdge(7, 5);
        gamd.addEdge(4, 6);

        System.out.println(gamd);

        //Zadanie 2 - macierz sąsiedztwa - nieskierowany
        System.out.println("Graf - macierz sąsiedztwa - nieskierowany:");
        Node nA = new Node('1');
        Node nB = new Node('2');
        Node nC = new Node('3');
        Node nD = new Node('4');
        Node nE = new Node('5');
        Node nF = new Node('6');
        Node nG = new Node('7');
        Node nH = new Node('8');

        GraphAdjacencyMatrix gam = new GraphAdjacencyMatrix();
        gam.addNode(nA);
        gam.addNode(nB);
        gam.addNode(nC);
        gam.addNode(nD);
        gam.addNode(nE);
        gam.addNode(nF);
        gam.addNode(nG);
        gam.addNode(nH);
        gam.setRootNode(nA);

        gam.addEdge(nE, nA);
        gam.addEdge(nF, nA);
        gam.addEdge(nG, nA);
        gam.addEdge(nB, nE);
        gam.addEdge(nC, nE);
        gam.addEdge(nH, nF);
        gam.addEdge(nE, nG);

        System.out.println(gam);

        //Zadanie 3 - dla grafu z macierzą sąsiedztwa
        System.out.println("Przeszukiwanie wszerz:");
        gam.bfs();

        System.out.println("\nPrzeszukiwanie w głąb:");
        gam.dfs();

        System.out.println("\n");

        //Zadanie 2 - macierz sąsiedztwa - nieskierowany - krawędzie z wagą
        System.out.println("Graf - macierz sąsiedztwa - nieskierowany - krawędzie z wagą:");
        GraphAdjacencyMatrix gamw = new GraphAdjacencyMatrix();
        gamw.addNode(nA);
        gamw.addNode(nB);
        gamw.addNode(nC);
        gamw.addNode(nD);
        gamw.addNode(nE);
        gamw.addNode(nF);
        gamw.addNode(nG);
        gamw.addNode(nH);
        gamw.setRootNode(nA);

        gamw.addEdgeWeighted(nA, nB, 1);
        gamw.addEdgeWeighted(nA, nC, 2);
        gamw.addEdgeWeighted(nA, nD, 8);
        gamw.addEdgeWeighted(nB, nE, 6);
        gamw.addEdgeWeighted(nB, nF, 3);
        gamw.addEdgeWeighted(nB, nG, 5);
        gamw.addEdgeWeighted(nC, nD, 5);
        gamw.addEdgeWeighted(nC, nF, 1);
        gamw.addEdgeWeighted(nC, nB, 2);
        gamw.addEdgeWeighted(nD, nF, 8);
        gamw.addEdgeWeighted(nD, nE, 6);
        gamw.addEdgeWeighted(nE, nF, 3);
        gamw.addEdgeWeighted(nF, nG, 5);
        gamw.addEdgeWeighted(nG, nH, 5);

        System.out.println(gamw);

        //Zadanie 2 - macierz sąsiedztwa - nieskierowany - krawędzie z wagą - minimalne drzewo rozpinające
        System.out.println("Graf - macierz sąsiedztwa - nieskierowany - krawędzie z wagą - minimalne drzewo rozpinające:");
        GraphAdjacencyMatrix mst = gamw.getMinimumSpanningTree();
        System.out.println(mst);
    }

}
