package graphql;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Main {
	
	private static final String LOGIN_URL = "https://auth.staging.waldo.photos";
	private static final String URL = "https://core-graphql.staging.waldo.photos/gql";//"http://graphql-swapi.parseapp.com/";
	private static final String QUERY = "{album(id: \"YWxidW06YTQwYzc5ODEtMzE1Zi00MWIyLTk5NjktMTI5NjIyZDAzNjA5\") { id name photos(slice: { limit: 50, offset: 50 }) {records {id urls {size_code url width height quality mime}}}}}";//"{allFilms{films{title}}}";
	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	
	public static void main(String[] args) throws Exception {
		//OkHttpClient client = new OkHttpClient();
		/*CookieManager cookieManager = new CookieManager();
		cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
		OkHttpClient client = new OkHttpClient.Builder()
			    .cookieJar(new JavaNetCookieJar(cookieManager))
			    .build();*/
		
		OkHttpClient client = new OkHttpClient.Builder()
                .cookieJar(new CookieJar() {
                    //private final HashMap<HttpUrl, List<Cookie>> cookieStore = new HashMap<>();
                    private List<Cookie> cookies = new ArrayList<Cookie>();

                    @Override
                    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                        if(url.toString().contains(LOGIN_URL)){
                            this.cookies = cookies;
                        }
                    }

                    @Override
                    public List<Cookie> loadForRequest(HttpUrl url) {
                        //url = HttpUrl.parse(LOGIN_URL);
                        //List<Cookie> cookies = cookieStore.get(url);
                        return cookies != null ? cookies : new ArrayList<Cookie>();
                    }
                })
                .build();
		
		login(client);
		getDataPost(client);
	}
	
	public static void login(OkHttpClient client) throws Exception {
		HttpUrl queryUrl = HttpUrl.parse(LOGIN_URL).newBuilder()
				.addQueryParameter("username", "andy")
				.addQueryParameter("password", "1234").build();
		RequestBody requestBody = RequestBody.create(JSON, "{\"username\":\"andy\", \"password\":\"1234\"}");
		Request req = new Request.Builder().url(queryUrl).post(requestBody).build();
		Response response = client.newCall(req).execute();
		/*List<Cookie> list = client.cookieJar().loadForRequest(queryUrl);
		for(Cookie c:list){
			System.out.println(c.toString());
		}*/
		System.out.println(new String(response.body().bytes()));
	}
	
	public static void getDataPost(OkHttpClient client) throws Exception {
		HttpUrl queryUrl = HttpUrl.parse(URL).newBuilder().addQueryParameter("query", QUERY).build();
		RequestBody requestBody = RequestBody.create(JSON, "{\"operationName\":\"\", \"variables\":{}, \"query\":\""+QUERY+"\"");
		Request req = new Request.Builder().url(queryUrl).post(requestBody).build();
		Response response = client.newCall(req).execute();
		System.out.println(new String(response.body().bytes()));
	}
	
	public static void getData(OkHttpClient client) throws Exception {
		HttpUrl queryUrl = HttpUrl.parse(URL).newBuilder().addQueryParameter("query", QUERY).build();
		Request req = new Request.Builder().url(queryUrl).get().build();
		Response response = client.newCall(req).execute();
		System.out.println(new String(response.body().bytes()));
	}
}