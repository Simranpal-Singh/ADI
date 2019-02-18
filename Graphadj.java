import java.util.*;
class graph{
    private int V;
    private LinkedList<Integer> adj[];
    graph(int v){
        V=v;
        adj=new LinkedList[V];
        for(int i=0;i<V;i++){
        adj[i]=new LinkedList();
        }
    }
    public void addedge(int i,int j){
     adj[i].add(j);
     adj[j].add(i);
    }
    void dfsutil(int x,boolean[] visited){
        visited[x]=true;
        System.out.print(x);
        Iterator<Integer> itr=adj[x].iterator();
        while(itr.hasNext()){
            int a=itr.next();
            if(!visited[a]){
                dfsutil(a,visited);
            }
        }
    }
    void dfs(int x){
        boolean visited[]=new boolean[V];
        dfsutil(x,visited);
    }
    void bfsutil(int x,boolean visited[]){
        Queue<Integer> q=new LinkedList<>();
        visited[x]=true;
        q.add(x);
        while(q.size()!=0){
         int a1=q.peek();
         System.out.print(a1);
         q.poll();
         Iterator<Integer> itr=adj[a1].iterator();
         while(itr.hasNext()){
             int a2=itr.next();
             if(!visited[a2]){
                 q.add(a2);
                 visited[a2]=true;
             }
         }
        }
    }
    void bfs(int x){
        boolean visited[]=new boolean[V];
        bfsutil(x,visited);
    }
    boolean cycleutil(int x,boolean[] visited,int p){
        visited[x]=true;
        Iterator<Integer> itr=adj[x].iterator();
        while(itr.hasNext()){
            int ap=itr.next();
            if(visited[ap]){
               if(ap != p){
                   return true;
               }
            }
            else{
                if(cycleutil(ap,visited,x)){
                    return true;
                }
                else
                return false;
            }
        }
        return false;
    }
    void cycle(){
        boolean visited[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
        if(cycleutil(i,visited,-1)){
            System.out.print("cycle");
        }
            }
        }
    }
}
class Graphadj{
    public static void main(String args[]){
        //graph a=new graph(6);
        graph g = new graph(4); 
        g.addedge(0, 1); 
        g.addedge(0, 2); 
        g.addedge(1, 2); 
        g.addedge(2, 0); 
        g.addedge(2, 3); 
        g.addedge(3, 3); 
        g.dfs(2);
        g.bfs(2);
        g.cycle();
    }
}