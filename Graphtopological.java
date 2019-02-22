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
    public void addEdge(int i,int j){
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
void topologicalutil(int x,boolean[] visited,Stack st){
    visited[x]=true;
    Iterator<Integer> itr=adj[x].iterator();
    while(itr.hasNext()){
        int ax=itr.next();
        if(!visited[ax])
        topologicalutil(ax,visited,st);
    }
    st.push(new Integer(x));
}
void topological(){
    boolean visited[]=new boolean[V];
    Stack<Integer> st=new Stack<>();
    for(int i=0;i<V;i++){
     if(!visited[i]){
         topologicalutil(i,visited,st);
     } 
   }
    while(st.size()!=0){
        System.out.println(st.peek());
        st.pop();
    }
}
}
class Graphtopological{
    public static void main(String args[]){
        //graph a=new graph(6);
        graph g = new graph(6); 
       //Graph g = new Graph(6); 
        g.addEdge(5, 2); 
        g.addEdge(5, 0); 
        g.addEdge(4, 0); 
        g.addEdge(4, 1); 
        g.addEdge(2, 3); 
        g.addEdge(3, 1); 
        //g.dfs(2);
        //g.bfs(2);
        g.cycle();
        g.topological();
    }
}