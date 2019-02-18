import java.util.*;
class graph{
    private int[][] adj;
    private int V;
    graph(int v){
    V=v;
    adj=new int[V][V];
    }
    public void addedge(int i,int j){
    adj[i][j]=1;
    adj[j][i]=1;
}
    public void delete(int i,int j){
    adj[i][j]=0;
    adj[j][i]=0;
}
    public void print(){
    for(int i=0;i<V;i++){
        for(int j=0;j<V;j++){
            System.out.print(adj[i][j] +" ");
        }
        System.out.println();
    }
}   
    public void dfsutil(int x,boolean visited[]){
     visited[x]=true;
     System.out.print(x);
     for(int i=0;i<V;i++){
         if(!visited[i] && adj[x][i]==1){
             dfsutil(i,visited);
         }
     }
    }
    public void dfs(int x){
     boolean[] visited=new boolean[V];
     dfsutil(x,visited);
    }
    public void bfsutil(int x,boolean visited[]){
        Queue<Integer> q = new LinkedList<Integer>();
        visited[x]=true;
        q.add(x);
        while(q.size()!=0){
            int a=q.peek();
            System.out.print(a);
            q.poll();
            for(int i=0;i<V;i++){
                if(!visited[i] && adj[a][i]==1){
                    visited[i]=true;
                    q.add(i);
                }
            }
        }
    }
    public void bfs(int x){
        boolean visited[]=new boolean[V];
        bfsutil(x,visited);
    }
}
class Graphmat{
    public static void main(String args[]){
    graph a=new graph(6);
    a.addedge(1,2);
    a.addedge(1,4);
    a.addedge(2,3);
    a.addedge(2,4);
    a.addedge(3,5);
    a.addedge(4,5);
    //a.print();
    //a.dfs(2);
    a.bfs(2);
}
}

