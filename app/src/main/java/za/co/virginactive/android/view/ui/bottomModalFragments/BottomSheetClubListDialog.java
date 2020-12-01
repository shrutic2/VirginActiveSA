package za.co.virginactive.android.view.ui.bottomModalFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.List;

import za.co.virginactive.android.R;
import za.co.virginactive.android.service.model.ClubLists;
import za.co.virginactive.android.view.adapters.ClubListAdapter;
import za.co.virginactive.android.view.ui.fragments.HomeFragment;

public class BottomSheetClubListDialog extends BottomSheetDialogFragment implements ClubListAdapter.RecyclerItemListener {
    TextView tvClubName;
    RecyclerView recyclerOtherClubs;
    List<String> clubList;
    ClubListAdapter adapter;

    public BottomSheetClubListDialog() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet_club_list,
                container, false);
        tvClubName = v.findViewById(R.id.tvClubNameLabel);
        tvClubName.setOnClickListener(v1 -> dismiss());

        recyclerOtherClubs = v.findViewById(R.id.recyclerOtherClubs);
        try {
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
            recyclerOtherClubs.setLayoutManager(layoutManager);
            adapter = new ClubListAdapter(HomeFragment.clubList, this);
            recyclerOtherClubs.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return v;
    }

    @Override
    public void onClubClicked(ClubLists lists, View view) {
        Toast.makeText(getActivity(), "" + lists.getClubName(), Toast.LENGTH_LONG).show();
        dismiss();
    }
}
