import java.util.*;
public class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    // Initialize rank and parent 
    public DisjointSet(int n){
        for(int i=0 ; i<=n ; i++){
            rank.add(0);
            parent.add(i);
        }
    }

    // Find parent of a node
    public int findUParent(int node){
        if(node == parent.get(node)){
            return node ;
        }
    int ulp = findUParent(parent.get(node));
    parent.set(node,ulp);
    return parent.get(node);
    }

    // Union by rank

    public void unionByRank(int u, int v){
        int ulp_u = findUParent(u) ;
        int ulp_v = findUParent(v) ;

        if(ulp_u == ulp_v)  return ;

        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v) ;
        }else if(rank.get(ulp_u) > rank.get(ulp_v)){
            parent.set(ulp_v,ulp_u);
        }else{
            parent.set(ulp_v,ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u,rankU+1);
        }
    }
}

class Main{
    public static void main(String args[]){
        DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        if(ds.findUParent(3)==ds.findUParent(7)){
            System.out.println("In a same set");
        }else{
            System.out.println("In different set");
        }
    }
}
