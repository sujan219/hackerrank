package nishant;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Test {
	public static void main(String[] args) throws Exception {
		call();
	}
	
	private static void call() throws Exception {
		String urlParameters  = "username=andy&password=1234";
		byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
		int    postDataLength = postData.length;
		String request        = "https://auth.staging.waldo.photos";
		URL    url            = new URL( request );
		HttpURLConnection conn= (HttpURLConnection) url.openConnection();           
		conn.setDoOutput( true );
		conn.setInstanceFollowRedirects( false );
		conn.setRequestMethod( "POST" );
		//conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded"); 
		conn.setRequestProperty( "charset", "utf-8");
		conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
		conn.setUseCaches( false );
		try( DataOutputStream wr = new DataOutputStream( conn.getOutputStream())) {
		   wr.write( postData );
		}
		
		Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        for (int c; (c = in.read()) >= 0;)
            System.out.print((char)c);
		
	}
	
	private static void simulate() throws Exception {
		Robot bot = new Robot();
		bot.setAutoDelay(14);

		int duration = 15000;
		long start = System.currentTimeMillis();
		while (System.currentTimeMillis() - start < duration) {
		    bot.keyPress(KeyEvent.VK_RIGHT);
		    bot.keyRelease(KeyEvent.VK_RIGHT);
		    bot.keyPress(KeyEvent.VK_LEFT);
		    bot.keyRelease(KeyEvent.VK_LEFT);
		}
	}
}
