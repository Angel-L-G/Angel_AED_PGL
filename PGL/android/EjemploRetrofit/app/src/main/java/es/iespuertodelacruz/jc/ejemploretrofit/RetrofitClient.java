package es.iespuertodelacruz.jc.ejemploretrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private Retrofit retrofit = null;
    private static RetrofitClient instance = null;
    private RESTService restService;

    private RetrofitClient() {

        retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        restService = retrofit.create(RESTService.class);
    }
    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public RESTService getRestService() {
        return restService;
    }
}
