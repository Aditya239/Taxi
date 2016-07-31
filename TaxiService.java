import java.io.*;
import java.util.*;
public class TaxiService
{/////////////////////////////////////////////////////////////////////////  
        MySet<taxi> taxis;
        graph map;
        public TaxiService()
        {
            taxis=new MySet<taxi>();
            map=new graph();
        }
    public int billgem(graph mapa,String word2, String word3)
    {
              Dijkstra engine = new Dijkstra(mapa);
              vertex a=null;vertex b=null;
              Node<vertex> lispi=mapa.vertices.myset_in_list.tail;
              while(lispi!=null)
              {
                  if(lispi.getter_data().id.equals(word2))
                  {a=lispi.getter_data();}
                  lispi=lispi.getter_link();
              }
              lispi=mapa.vertices.myset_in_list.tail;
              while(lispi!=null)
              {
                  if(lispi.getter_data().id.equals(word3))
                  {b=lispi.getter_data();}
                  lispi=lispi.getter_link();
              }
              engine.execute(a);
              int T=engine.getShortestDistance(b);
              if(engine.getPath(b)==null)
              System.out.println(b.id+". time taken is "+ T +" units.");
              else{
              Node<vertex> pathhead = engine.getPath(b).tail;
              if(pathhead!=null)
              {
               System.out.print(pathhead.getter_data().id);
               pathhead=pathhead.getter_link();
              }
              while(pathhead!=null)
              {
               System.out.print(","+pathhead.getter_data().id);
               pathhead=pathhead.getter_link();   
              }
              System.out.println(". time taken is "+ T +" units.");
            }
            return T;
      }
    ////////////////////////////////////////////////////////////////////////////////////////
    
    public taxi taxichoose(String destiny,MySet<taxi> set, graph mapster, int t)
    {
        Node<taxi> pluss=set.myset_in_list.tail;
        int mintime=99999999;taxi hero=null;
        while(pluss!=null)
        {
            if(pluss.getter_data().status<=t){
            pluss.getter_data().location=pluss.getter_data().imminent;
            System.out.print("Path of "+pluss.getter_data().name+": ");
            String faucet=pluss.getter_data().location.id;
            int k=billgem(mapster, faucet, destiny);
            if(k<mintime)
            {
                mintime=k;
                hero=pluss.getter_data();
            }
               }
            pluss=pluss.getter_link();
        }
        hero.status=t+mintime;
        //System.out.println("Given "+hero.name+" a bonus of "+mintime+" to get "+hero.status);
        return hero;
    }
    
    void performAction(String actionMessage) throws IOException
    {
        System.out.println("action to be performed: " + actionMessage);
        //System.out.println(">");
        /*Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine())
       {
        String st=sc.nextLine();*/
        Scanner p=new Scanner(actionMessage);
        String word1=p.next();
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if(word1.equals("customer"))
        {
            String word2=p.next();
            String word3=p.next();
            String word4=p.next();
            int t=Integer.parseInt(word4);
            System.out.println("Available taxis:");
            TaxiService ob=new TaxiService();
            taxi require=ob.taxichoose(word2, taxis, map, t);
            System.out.println("*** Chose "+require.name+" to service the customer request ***");
            vertex a=null;
            Node<vertex> pyret=map.vertices.myset_in_list.tail;
              while(pyret!=null)
              {
                  if(pyret.getter_data().id.equals(word3))
                  {a=pyret.getter_data();}
                  pyret=pyret.getter_link();
              }
            require.imminent=a;
            //require.status+=
            System.out.print("Path of customer: ");
            int illa=ob.billgem(map,word2,word3);
            require.status+=illa;
            //System.out.println("Given "+require.name+" another bonus of "+illa+" to get "+require.status);
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        else if(word1.equals("edge"))
            {
              String word2=p.next();
              String word3=p.next();
              String word4=p.next();
              map.add_edge(word2,word3,Integer.parseInt(word4));
              //map.display();
              //map.displayEdges();
            }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
           // else if(word1.equals("path"))
            
     ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
           else if(word1.equals("taxi"))
            {
                String word2=p.next();
                String word3=p.next();
                vertex c=null;
                Node<vertex> lobster=map.vertices.myset_in_list.tail;
                while(lobster!=null)
              {
                  if(lobster.getter_data().id.equals(word3))
                  {c=lobster.getter_data();}
                  lobster=lobster.getter_link();
              }
              if(c==null)
              {System.out.println("No such place found !");}
              else{
                taxi pixi=new taxi(word2,c);
                taxis.addElement(pixi);
                  }
            }
            else if(word1.equals("printTaxiPosition"))
            {
                String word2=p.next();
                int tima=Integer.parseInt(word2);
                Node<taxi> guacamole=taxis.myset_in_list.tail;
                while(guacamole!=null)
                {
                    if(guacamole.getter_data().status<=tima)
                    {   guacamole.getter_data().location=guacamole.getter_data().imminent;
                        System.out.println(guacamole.getter_data().name+":"+guacamole.getter_data().location.id);}
                    guacamole=guacamole.getter_link();
                }
            }
    }
}