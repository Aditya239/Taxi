public class vertex
{
    String id;
    MySet<vertex> neighbours;
    public vertex(String identity)
    {
        id=identity;
        neighbours=new MySet<vertex>();
    }
    public void addneighbour(vertex vi)
    {
        neighbours.addElement(vi);
    }
    public MySet return_neighbours()
    {
        return neighbours;
    }
    public boolean IsNeighbour(vertex v)
    {
        return neighbours.IsMember(v);
    }
}