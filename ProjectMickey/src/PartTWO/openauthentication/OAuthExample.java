package PartTWO.openauthentication;

import PartTWO.support.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import oauth.signpost.OAuth;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.basic.DefaultOAuthProvider;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import PartTWO.utils.*;

public class OAuthExample
{       
	OAuthConsumer consumer;
	public OAuthExample(OAuthConsumer oc) {
		consumer = new CommonsHttpOAuthConsumer(oc.getConsumerKey(),oc.getConsumerSecret());
	}
    public OAuthTokenSecret GetUserAccessKeySecret()
    {
        try {
            if(consumer.getConsumerKey().isEmpty())
            {
                System.out.println("Register an application and copy the consumer key into the configuration file.");
                return null;
            }
            if(consumer.getConsumerSecret().isEmpty())
            {
                System.out.println("Register an application and copy the consumer secret into the configuration file.");
                return null;
            }
                        
            OAuthProvider provider = new DefaultOAuthProvider(OAuthUtils.REQUEST_TOKEN_URL, OAuthUtils.ACCESS_TOKEN_URL, OAuthUtils.AUTHORIZE_URL);
            String authUrl = provider.retrieveRequestToken(consumer, OAuth.OUT_OF_BAND);
            System.out.println("Now visit:\n" + authUrl + "\n and grant this app authorization");
            System.out.println("Enter the PIN code and hit ENTER when you're done:");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String pin = br.readLine();
            System.out.println("Fetching access token from Twitter");
            provider.retrieveAccessToken(consumer,pin);
            String accesstoken = consumer.getToken();
            String accesssecret  = consumer.getTokenSecret();
            OAuthTokenSecret tokensecret = new OAuthTokenSecret(accesstoken,accesssecret);
            System.out.println(tokensecret.toString());
            return tokensecret;
        } catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
