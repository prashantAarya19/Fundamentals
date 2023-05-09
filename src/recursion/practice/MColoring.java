package recursion.practice;

public class MColoring {
    public boolean graphColoring(boolean graph[][], int m, int n) {
        return func(graph, m, n, new int[n], 0);
    }

    private boolean func(boolean graph[][], int m, int n, int[] color, int ind) {
        if(ind == n)
            return true;

        for(int i = 1; i <= m; i++) {
            if(isPossible(graph[ind], i, color)) {
                color[ind] = i;
                if(func(graph, m, n, color, ind + 1))
                    return true;
                else
                    color[ind] = 0;
            }
        }

        return false;
    }

    private boolean isPossible(boolean[] edges, int currentColor, int[] color) {
        for(int i = 0; i < edges.length; i++) {
            if(edges[i] && color[i] == currentColor) {
                return false;
            }
        }
        return true;
    }
}
