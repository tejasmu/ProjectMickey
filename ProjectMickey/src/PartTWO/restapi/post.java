package PartTWO.restapi;
//import Node;

import java.util.*;

public class post
{ 
	
	String map_num;
	String seed_node;
	String followers_count;
	String friends_count;
	String number_of_posts;
	Integer actual_friends;
	Node next;
	public post(String mapping_number,String a,String b,String c,String d,Integer e) 
	{ 
		map_num=mapping_number;
		seed_node=a;
		followers_count=b;
		friends_count=c;
		number_of_posts=d;
		actual_friends=e;
		
	}
	@Override
	public boolean equals(Object object) 
	{
		boolean result=false;
		post item = (post) object;

		if((object == null) || (object.getClass() != this.getClass()))
		{
			result= false;
		}
		else if((this.seed_node.equals(item.seed_node)))
		{	
			result= true;
			//return result;
		}
		return result;
	}
	
}