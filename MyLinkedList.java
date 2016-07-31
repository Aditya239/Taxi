public class MyLinkedList<X>
{
	Node<X> tail;
	public MyLinkedList()
	{tail=null;}                                                      //or a nulled node?
	public void Insert_node_in_list(X data_member_for_list)
	{
		Node<X> addendum=new Node<X>(data_member_for_list,tail);
		tail=addendum;
	}
	public void Delete_node_from_list(X data_member_off_list)
	{
		if(tail.getter_data().equals(data_member_off_list))
			{
				tail=tail.getter_link();
				return;
			}
		Node<X> temp_tail=tail;
		Node<X> companion=temp_tail;
		while (temp_tail!=null)
		{
			if(temp_tail.getter_data().equals(data_member_off_list))
			{
				companion.setter_link(temp_tail.getter_link());
			}
			companion=temp_tail;
			temp_tail = temp_tail.getter_link();
		}
	}
	public boolean Is_present_in_list(X data_member_to_find)
	{
		Node<X> temp_tail=tail;
		while (temp_tail!=null)
		{
			if(temp_tail.getter_data().equals(data_member_to_find))
			{return true;}
			temp_tail = temp_tail.getter_link();
		}
		return false;
	}
}