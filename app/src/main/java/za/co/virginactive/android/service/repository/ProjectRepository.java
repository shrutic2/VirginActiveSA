package za.co.virginactive.android.service.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import za.co.virginactive.android.service.model.ClubDetails;
import za.co.virginactive.android.service.model.ClubLists;
import za.co.virginactive.android.service.model.ClubOccupancy;
import za.co.virginactive.android.service.model.MemberDetail;

public class ProjectRepository {

    private ApiInterface apiInterface;
    private static ProjectRepository projectRepository;

    /*@Inject
    public ProjectRepository(ApiInterface apiInterface){
        this.apiInterface = apiInterface;
    }*/

     //Create retrofit instance
    private ProjectRepository() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(3000, TimeUnit.MILLISECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.HTTPS_API_BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        apiInterface = retrofit.create(ApiInterface.class);
    }

    //get class instance as singleton object
    public synchronized static ProjectRepository getInstance() {
        if (projectRepository == null) {
            projectRepository = new ProjectRepository();
        }
        return projectRepository;
    }

    //TODO methods and controllers will go here.
    final MutableLiveData<List<ClubLists>> data = new MutableLiveData<>();
    public MutableLiveData<List<ClubLists>> getClubsList(String key){

        apiInterface.getAllClubs(key).enqueue(new Callback<List<ClubLists>>() {
            @Override
            public void onResponse(Call<List<ClubLists>> call, Response<List<ClubLists>> response) {
                data.setValue(response.body());
                Log.e("GETCLUBS", "In Response....");
            }

            @Override
            public void onFailure(Call<List<ClubLists>> call, Throwable t) {
                Log.e("GETCLUBS", t.getMessage().toString());
            }
        });
        return data;
    }

    public LiveData<ClubDetails> getClubById(String key, String clubId){
        final MutableLiveData<ClubDetails> data = new MutableLiveData<>();
        apiInterface.getClubById(key, clubId).enqueue(new Callback<ClubDetails>() {
            @Override
            public void onResponse(Call<ClubDetails> call, Response<ClubDetails> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ClubDetails> call, Throwable t) {
                Log.e("GETCLUBS", t.getMessage().toString());
            }
        });
        return data;
    }

    public LiveData<ClubOccupancy> getClubOccupancyById(String key, String costCenter){
        final MutableLiveData<ClubOccupancy> data = new MutableLiveData<>();
        apiInterface.getClubOccupancyById(key, costCenter).enqueue(new Callback<ClubOccupancy>() {
            @Override
            public void onResponse(Call<ClubOccupancy> call, Response<ClubOccupancy> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ClubOccupancy> call, Throwable t) {
                Log.e("GETCLUBS", t.getMessage().toString());
            }
        });
        return data;
    }

    final MutableLiveData<MemberDetail> detailMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<MemberDetail> getMemberDetailLiveData(String key, String memberId){

        apiInterface.getMemberDetail(key, memberId).enqueue(new Callback<MemberDetail>() {
            @Override
            public void onResponse(Call<MemberDetail> call, Response<MemberDetail> response) {
                detailMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<MemberDetail> call, Throwable t) {
                Log.e("GETCLUBS", t.getMessage().toString());
            }
        });
        return detailMutableLiveData;
    }

}
