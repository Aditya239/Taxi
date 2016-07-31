public class MySet<X>
{
	MyLinkedList<X> myset_in_list;
	int total;
	public MySet()
	{
		total=0;
		myset_in_list=new MyLinkedList<X>();
	}
	public boolean IsEmpty()
	{
		return(total==0);
	}													
 	public boolean IsMember(X o)
 	{
 		return(myset_in_list.Is_present_in_list(o));
 	}													
 	public void addElement(X o)
 	{
 		myset_in_list.Insert_node_in_list(o);
 		total++;
 	}												
 	public void Delete(X o)
 	{
 		if(this.IsMember(o))
 		{
 		myset_in_list.Delete_node_from_list(o);
 		total--;
 		}
 		else
 		{//throw an exception
 		 }
 	}
 	public MySet<X> Union(MySet<X> a)
 	{
 		MySet<X> set_obj_native=new MySet<X>();
 		Node<X> tail_1=a.myset_in_list.tail;
 		Node<X> tail_2=this.myset_in_list.tail;
 		while(tail_1!=null)
 		{
 			set_obj_native.addElement(tail_1.getter_data());
 			tail_1=tail_1.getter_link();
 		}
 		while(tail_2!=null)
 		{
 			if(!set_obj_native.IsMember(tail_2.getter_data()))
 			{set_obj_native.addElement(tail_2.getter_data());}
 			tail_2=tail_2.getter_link();
 		}
 		return set_obj_native;
 	}
 	public MySet<X> Intersection(MySet<X> a)
	{
		  MySet<X> set_obj_native = new MySet<X>();
		  Node<X> tail_only=this.myset_in_list.tail;
		  while(tail_only.getter_link()!=null)
 		{
 			if(a.IsMember(tail_only.getter_data()))
 			{set_obj_native.addElement(tail_only.getter_data());}
 			tail_only=tail_only.getter_link();
 		}
 		return set_obj_native;
	}													//: Returns a set which is the union of the current set with the set a
}