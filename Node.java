public class Node<X>
{
	X data_member;
	Node<X> link;
	public Node(X data_actual, Node<X> end)
	{data_member=data_actual; link=end;}
	public X getter_data()
	{return data_member;}
	public Node<X> getter_link()
	{return link;}
	public void setter_link(Node new_link)
	{link=new_link;}
}