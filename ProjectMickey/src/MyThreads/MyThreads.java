package MyThreads;
import java.io.PrintStream;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import PartTWO.openauthentication.*;
import PartTWO.restapi.RESTApiExample;
import PartTWO.support.OAuthTokenSecret;
import PartTWO.utils.OAuthUtils;

class NewThread extends Thread {
	int thread_count=0;
	String last_mapped;
	OAuthConsumer oc;
	OAuthTokenSecret ot;
	public static String last_mapped_num;
	NewThread(int thread_count, String last_mapped) {
		super("Demo Thread");
		this.thread_count=thread_count;
		this.last_mapped=last_mapped;
      
		System.out.println("Child thread: " + this);
		start();
   }

   public void run() {
	   Integer status=0;
	   status=rountine();
   } 
   
   public Integer rountine() {
	   Integer status=0;
	   //String last_mapped_num=null;
	   try{
			oc = findCredentials(this.thread_count);
			OAuthExample aue = new OAuthExample(oc);
		    ot = aue.GetUserAccessKeySecret();
		    if(ot.getAccessToken().equals(null)|| ot.getAccessSecret().equals(null) ) {
		    	System.out.println("Empty Tokens");
		    	status=1;
		    	return status;
		    }
		    RESTApiExample rae = new RESTApiExample(oc,ot);
		    NewThread.last_mapped_num=rae.fetchData(this.last_mapped);
		    System.out.println(ot.toString());
		} catch(Exception e) {
			   System.out.println("Error in OauthExample");
			   e.printStackTrace();
		}
		return status;
	}
   
   
   
   public OAuthConsumer findCredentials(Integer counter) {
		OAuthConsumer consumer = new CommonsHttpOAuthConsumer("","");
		switch (counter) {
			case 1:
		       	System.out.println("CONSUMER1");
		       	consumer = new CommonsHttpOAuthConsumer(OAuthUtils.CONSUMER_KEY1,OAuthUtils.CONSUMER_SECRET1);
		       	break;
			case 2:
		       	System.out.println("CONSUMER2");
		       	consumer = new CommonsHttpOAuthConsumer(OAuthUtils.CONSUMER_KEY2,OAuthUtils.CONSUMER_SECRET2);
		       	break;
			case 3:
				System.out.println("CONSUMER3");
		       	consumer = new CommonsHttpOAuthConsumer(OAuthUtils.CONSUMER_KEY3,OAuthUtils.CONSUMER_SECRET3);
		       	break;
			case 4:
				System.out.println("CONSUMER4");
		       	consumer = new CommonsHttpOAuthConsumer(OAuthUtils.CONSUMER_KEY4,OAuthUtils.CONSUMER_SECRET4);
		       	break;
			case 5:
				System.out.println("CONSUMER5");
		       	consumer = new CommonsHttpOAuthConsumer(OAuthUtils.CONSUMER_KEY5,OAuthUtils.CONSUMER_SECRET5);
		       	break;
	       	default:
	       		System.out.println("Something`s Wrong");
	       		
       }
		return consumer;
	}
}

public class MyThreads {
	public static void main(String args[]) {
		NewThread.last_mapped_num="0";
		PrintStream orgStream = System.out;
		try {
			for(int i=1;i<=5;i++) {
				final NewThread t = new NewThread(i,NewThread.last_mapped_num); // assume T1 is a Runnable
				System.out.println("Thread "+i);
				t.join();
				System.setOut(orgStream);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
      System.out.println("Main thread exiting.");
   }
}