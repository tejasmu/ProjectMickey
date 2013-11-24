package PartTWO.restapi;
import java.util.*;

public class Node
{ 
	String map_num;
	String seed_node;
	String mentioned_node;
	Integer count;
	Node next;

	public Node(String mapping_number, String user_id, String mentioned_user,int c)
	{
		// TODO Auto-generated constructor stub
		map_num=mapping_number;
		seed_node=user_id;
		mentioned_node=mentioned_user;
		count=c;
		
	}
	@Override
	public boolean equals(Object object) 
	{
		boolean result=false;
		Node item = (Node) object;

		if((object == null) || (object.getClass() != this.getClass()))
		{
			result= false;
		}
		else if((this.seed_node.equals(item.seed_node)) && (this.mentioned_node.equals(item.mentioned_node)))
		{	
			result= true;
			//return result;
		}
		return result;
	}
	
}