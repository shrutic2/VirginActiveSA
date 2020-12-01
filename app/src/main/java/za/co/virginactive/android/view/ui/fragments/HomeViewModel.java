package za.co.virginactive.android.view.ui.fragments;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import za.co.virginactive.android.service.model.ClubDetails;
import za.co.virginactive.android.service.model.ClubLists;
import za.co.virginactive.android.service.model.ClubOccupancy;
import za.co.virginactive.android.service.model.MemberDetail;
import za.co.virginactive.android.service.repository.ProjectRepository;

public class HomeViewModel extends AndroidViewModel {

    ProjectRepository repository;
    private MutableLiveData<List<ClubLists>> listLiveData = new MutableLiveData<>();
    private MutableLiveData<MemberDetail> memberDetailMutableLiveData = new MutableLiveData<>();
    private LiveData<ClubDetails> detailsLiveData;
    private LiveData<ClubOccupancy> occupancyLiveData;

    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public void init(String key, String clubId, String memberId){
        repository = ProjectRepository.getInstance();
        memberDetailMutableLiveData = repository.getMemberDetailLiveData(key, memberId);
        listLiveData = repository.getClubsList(key);
        detailsLiveData = repository.getClubById(key, clubId);
        occupancyLiveData = repository.getClubOccupancyById(key, clubId);
    }

    public LiveData<List<ClubLists>> getListLiveData(){
        return listLiveData;
    }

    public LiveData<ClubDetails> getDetailsLiveData(){
        return detailsLiveData;
    }

    public LiveData<ClubOccupancy> getOccupancyLiveData(){
        return occupancyLiveData;
    }

    public LiveData<MemberDetail> getDetailLiveData(){
        return memberDetailMutableLiveData;
    }
}