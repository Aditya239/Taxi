public class edge
{
    vertex v1;
    vertex v2;
    int weight;
    public edge(vertex a,vertex b, int w)
    {
        v1=a;
        v2=b;
        weight=w;
    }
    public boolean IsEndPoint(vertex a)
    {return(v1.id.equals(a.id)||v2.id.equals(a.id));}
}