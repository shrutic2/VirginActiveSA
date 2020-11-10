package com.example.myapplication1.service.repository;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProjectRepository {

    private ApiInterface apiInterface;
    private static ProjectRepository projectRepository;

    //Create retrofit instance
    private ProjectRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.HTTPS_API_BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(ApiInterface.class);
    }

    //get class instance as singleton object
    public synchronized static ProjectRepository getInstance() {
        if (projectRepository == null) {
            if (projectRepository == null) {
                projectRepository = new ProjectRepository();
            }
        }
        return projectRepository;
    }

    //TODO methods and controllers will go here.
}
