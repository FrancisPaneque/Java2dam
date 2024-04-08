package base;

public class main {
	
	OkHttpClient client = new OkHttpClient();

	Request request = new Request.Builder()
	  .url("https://api.themoviedb.org/3/authentication")
	  .get()
	  .addHeader("accept", "application/json")
	  .addHeader("Authorization", "Bearer bef30369a404f9a1a923bc48ffbc00bc")
	  .build();

	Response response = client.newCall(request).execute();
}
