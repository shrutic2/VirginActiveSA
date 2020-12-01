package za.co.virginactive.android.service.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.JsonObject;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import za.co.virginactive.android.service.model.ClubDetails;
import za.co.virginactive.android.service.model.LoginToken;

public class ProjectRepositoryAuth {

    private ApiInterface apiInterface;
    private static ProjectRepositoryAuth projectRepository;

    /*@Inject
    public ProjectRepository(ApiInterface apiInterface){
        this.apiInterface = apiInterface;
    }*/

    //Create retrofit instance
    private ProjectRepositoryAuth() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(3000, TimeUnit.MILLISECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.HTTPS_AUTH_BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        apiInterface = retrofit.create(ApiInterface.class);
    }

    public static ApiInterface getRetrofitClient(){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(3000, TimeUnit.MILLISECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.HTTPS_AUTH_BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit.create(ApiInterface.class);
    }

    //get class instance as singleton object
    public synchronized static ProjectRepositoryAuth getInstance() {
        if (projectRepository == null) {
            projectRepository = new ProjectRepositoryAuth();
        }
        return projectRepository;
    }

    public LiveData<LoginToken> getLoginToken(JsonObject object){
        final MutableLiveData<LoginToken> data = new MutableLiveData<>();
        apiInterface.getLoginToken(object.toString()).enqueue(new Callback<LoginToken>() {
            @Override
            public void onResponse(Call<LoginToken> call, Response<LoginToken> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<LoginToken> call, Throwable t) {
                Log.e("GETCLUBS", t.getMessage().toString());
            }
        });
        return data;
    }

}
