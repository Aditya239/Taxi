class graph
{
    MySet<vertex> vertices;
    MySet<edge> edges;
    public graph()
    {
        vertices=new MySet<vertex>();
        edges = new MySet<edge>();
    }
    public void add_edge(String x, String y, int mass)
    {
        Node<vertex> puck=vertices.myset_in_list.tail;
        if(puck==null)
        {
            vertex v1=new vertex(x);
            vertex v2=new vertex(y);
            edge k=new edge(v1,v2,mass);
            edges.addElement(k);
            vertices.addElement(v1);
            vertices.addElement(v2);
            v1.addneighbour(v2);
            v2.addneighbour(v1);
        }
        else
        {
            vertex v1=null,v2=null;
            Node<vertex> temptail=puck;
            while(temptail!=null)
            {
                if(temptail.getter_data().id.equals(x))
                {v1=temptail.getter_data();//System.out.println("Found the first: "+x);  
                }
                if(temptail.getter_data().id.equals(y))
                {v2=temptail.getter_data();//System.out.println("Found the second: "+y);
                }
                temptail=temptail.getter_link();
            }
            if(v1==null)
            {v1=new vertex(x);//System.out.println("Not found the first");            
                vertices.addElement(v1);}
            if(v2==null)
            {v2=new vertex(y);//System.out.println("Not found the second");            
                vertices.addElement(v2);}
            if(!v1.IsNeighbour(v2))
            {v1.addneighbour(v2);
            v2.addneighbour(v1);
            edge e=new edge(v1,v2,mass);
            edges.addElement(e);
            }
        }
    }
        public void display()
        {
            Node<vertex> nose=vertices.myset_in_list.tail;
            while(nose!=null)
            {
               // System.out.println("--------------------------------------------------");
               System.out.print("  "+nose.getter_data().id+" connected to:");
               Node<vertex> palsy=nose.getter_data().return_neighbours().myset_in_list.tail;
               while(palsy!=null)
               {System.out.print(palsy.getter_data().id+".");palsy=palsy.getter_link();}
               nose=nose.getter_link();
               //System.out.println();
            }
            System.out.println();
        }
        
        public void displayEdges()
        {
            //MySet<edge> sets=new MySet<edge>();
            Node<edge> pip=edges.myset_in_list.tail;
            while(pip!=null)
            {
                //System.out.println("-------------------------------");
                System.out.print(pip.getter_data().v1.id+"--"+pip.getter_data().weight+"--"+pip.getter_data().v2.id+" . ");
                pip=pip.getter_link();
            }
            System.out.println();
            //return sets;
        }
        public MySet<edge> edgesAroundVertex(vertex v)
        {
            MySet<edge> sets=new MySet<edge>();
            Node<edge> pip=edges.myset_in_list.tail;
            while(pip!=null)
            {
                if(pip.getter_data().IsEndPoint(v))
                sets.addElement(pip.getter_data());
                pip=pip.getter_link();
            }
            return sets;
        }
    }