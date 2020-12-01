package za.co.virginactive.android.view.ui.bottomModalFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import za.co.virginactive.android.R;
import za.co.virginactive.android.view.ui.fragments.HomeFragment;

public class BottomSheetClubHoursDialog extends BottomSheetDialogFragment {
    TextView tvClubName, tvDayOneName, tvDayOneTime, tvDayTwoName, tvDayTwoTime,
            tvDayThreeName, tvDayThreeTime, tvDayFourName, tvDayFourTime, tvDayFiveName, tvDayFiveTime,
            tvDaySixName, tvDaySixTime, tvDaySevenName, tvDaySevenTime;

    public BottomSheetClubHoursDialog() {
    }

    //public static BottomSheetClubHoursDialog newInstance(){}

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet_club_hours,
                container, false);
        tvClubName = v.findViewById(R.id.tvClubNameLabel);
        tvClubName.setText(HomeFragment.clubName);
        tvClubName.setOnClickListener(v1 -> dismiss());

        tvDayOneName = v.findViewById(R.id.tvDayOneName);
        tvDayOneTime = v.findViewById(R.id.tvDayOneTime);
        tvDayTwoName = v.findViewById(R.id.tvDayTwoName);
        tvDayTwoTime = v.findViewById(R.id.tvDayTwoTime);
        tvDayThreeName = v.findViewById(R.id.tvDayThreeName);
        tvDayThreeTime = v.findViewById(R.id.tvDayThreeTime);
        tvDayFourName = v.findViewById(R.id.tvDayFourName);
        tvDayFourTime = v.findViewById(R.id.tvDayFourTime);
        tvDayFiveName = v.findViewById(R.id.tvDayFiveName);
        tvDayFiveTime = v.findViewById(R.id.tvDayFiveTime);
        tvDaySixName = v.findViewById(R.id.tvDaySixName);
        tvDaySixTime = v.findViewById(R.id.tvDaySixTime);
        tvDaySevenName = v.findViewById(R.id.tvDaySevenName);
        tvDaySevenTime = v.findViewById(R.id.tvDaySevenTime);

        tvDayOneName.setText(HomeFragment.hoursList.get(0).getDay());
        tvDayOneTime.setText(HomeFragment.hoursList.get(0).getOpeningTime() + " - "+ HomeFragment.hoursList.get(0).getClosingTime());
        tvDayTwoName.setText(HomeFragment.hoursList.get(1).getDay());
        tvDayTwoTime.setText(HomeFragment.hoursList.get(1).getOpeningTime() + " - "+ HomeFragment.hoursList.get(1).getClosingTime());
        tvDayThreeName.setText(HomeFragment.hoursList.get(2).getDay());
        tvDayThreeTime.setText(HomeFragment.hoursList.get(2).getOpeningTime() + " - "+ HomeFragment.hoursList.get(2).getClosingTime());
        tvDayFourName.setText(HomeFragment.hoursList.get(3).getDay());
        tvDayFourTime.setText(HomeFragment.hoursList.get(3).getOpeningTime() + " - "+ HomeFragment.hoursList.get(3).getClosingTime());
        tvDayFiveName.setText(HomeFragment.hoursList.get(4).getDay());
        tvDayFiveTime.setText(HomeFragment.hoursList.get(4).getOpeningTime() + " - "+ HomeFragment.hoursList.get(4).getClosingTime());
        tvDaySixName.setText(HomeFragment.hoursList.get(5).getDay());
        tvDaySixTime.setText(HomeFragment.hoursList.get(5).getOpeningTime() + " - "+ HomeFragment.hoursList.get(5).getClosingTime());
        tvDaySevenName.setText(HomeFragment.hoursList.get(6).getDay());
        tvDaySevenTime.setText(HomeFragment.hoursList.get(6).getOpeningTime() + " - "+ HomeFragment.hoursList.get(6).getClosingTime());


        return v;
    }

}
