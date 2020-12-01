package za.co.virginactive.android.view.ui.fragments;

import androidx.core.app.ActivityCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.ArrayMap;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import za.co.virginactive.android.R;
import za.co.virginactive.android.service.ServiceConstants;
import za.co.virginactive.android.service.model.ClubDetails;
import za.co.virginactive.android.service.model.ClubLists;
import za.co.virginactive.android.service.model.ClubOccupancy;
import za.co.virginactive.android.service.model.MemberDetail;
import za.co.virginactive.android.service.repository.ProjectRepository;
import za.co.virginactive.android.util.SharedPreference;
import za.co.virginactive.android.view.adapters.ClubListAdapter;
import za.co.virginactive.android.view.ui.bottomModalFragments.BottomSheetClubHoursDialog;
import za.co.virginactive.android.view.ui.bottomModalFragments.BottomSheetClubListDialog;

public class HomeFragment extends Fragment implements View.OnClickListener {
    TextView tvMon, tvTue, tvWed, tvThu, tvFri, tvSat, tvSun, tvCurrentWeek, tvHours, tvCall,
            tvCapacityLabel, tvClubName, tvName;
    ImageView ivMon, ivTue, ivWed, ivThu, ivFri, ivSat, ivSun;
    LinearLayout llMon, llTue, llWed, llThu, llFri, llSat, llSun;

    String TODAY = "Today";

    String today;

    Context context;

    ImageView imageView;

    private HomeViewModel mViewModel;

    ProjectRepository repository;

    ClubOccupancy occupancy;

    BarChart chart;

    SharedPreference sharedPreference;

    public static ArrayList<ClubDetails.OperatingTimes> hoursList = new ArrayList<>();
    public static ArrayList<ClubLists> clubList = new ArrayList<>();

    public static String clubName = "";

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment_2, container, false);

        initViews(view);


        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    private void initViews(View view) {
        tvCurrentWeek = view.findViewById(R.id.tvCurrentWeek);
        tvCurrentWeek.setText(getCurrentWeek(Calendar.getInstance()));

        tvName = view.findViewById(R.id.tvName);

        Date now = new Date();
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated
        //System.out.println(simpleDateformat.format(now));
        today = simpleDateformat.format(now);

        tvMon = view.findViewById(R.id.tvMon);
        tvTue = view.findViewById(R.id.tvTue);
        tvWed = view.findViewById(R.id.tvWed);
        tvThu = view.findViewById(R.id.tvThu);
        tvFri = view.findViewById(R.id.tvFri);
        tvSat = view.findViewById(R.id.tvSat);
        tvSun = view.findViewById(R.id.tvSun);

        ivMon = view.findViewById(R.id.ivMon);
        ivTue = view.findViewById(R.id.ivTue);
        ivWed = view.findViewById(R.id.ivWed);
        ivThu = view.findViewById(R.id.ivThu);
        ivFri = view.findViewById(R.id.ivFri);
        ivSat = view.findViewById(R.id.ivSat);
        ivSun = view.findViewById(R.id.ivSun);

        llMon = view.findViewById(R.id.llMon);
        llTue = view.findViewById(R.id.llTue);
        llWed = view.findViewById(R.id.llWed);
        llThu = view.findViewById(R.id.llThu);
        llFri = view.findViewById(R.id.llFri);
        llSat = view.findViewById(R.id.llSat);
        llSun = view.findViewById(R.id.llSun);


        tvCapacityLabel = view.findViewById(R.id.tvCapicityLabel);
        tvClubName = view.findViewById(R.id.tvClubName);
        chart = view.findViewById(R.id.graph);
        initializeChart();

        tvCall = view.findViewById(R.id.tvCall);
        tvCall.setOnClickListener(v -> {
            if (isPermissionGranted()) {
                callClub(tvCall.getText().toString());
            }
        });

        tvHours = view.findViewById(R.id.tvHours);
        tvHours.setOnClickListener(v -> {
            /*BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bottomSheet.show(view.getContext().getSupportFragmentManager(),
                    "ModalBottomSheet");*/
            //TODO assign hours list here
            View view1 = getLayoutInflater().inflate(R.layout.bottom_sheet_club_hours, null);

            /*BottomSheetDialog dialog = new BottomSheetDialog(context);
            dialog.setContentView(view1);
            dialog.show();*/

            BottomSheetClubHoursDialog bottomSheetFragment = new BottomSheetClubHoursDialog();
            bottomSheetFragment.show(getActivity().getSupportFragmentManager(), bottomSheetFragment.getTag());

        });

        imageView = view.findViewById(R.id.imageView);
        imageView.setOnClickListener(v -> {
            //TODO assign list data here
            View view1 = getLayoutInflater().inflate(R.layout.bottom_sheet_select_clubs, null);

           /* BottomSheetDialog dialog = new BottomSheetDialog(context);
            dialog.setContentView(view1);
            dialog.show();*/
            BottomSheetClubListDialog bottomSheetFragment = new BottomSheetClubListDialog();
            bottomSheetFragment.show(getActivity().getSupportFragmentManager(), bottomSheetFragment.getTag());
            //showDialog();
        });

        setCurrentDaySelected(today);
        setActivityWeekSelected(today);

        tvMon.setOnClickListener(this);
        tvTue.setOnClickListener(this);
        tvWed.setOnClickListener(this);
        tvThu.setOnClickListener(this);
        tvFri.setOnClickListener(this);
        tvSat.setOnClickListener(this);
        tvSun.setOnClickListener(this);

        ivMon.setOnClickListener(this);
        ivTue.setOnClickListener(this);
        ivWed.setOnClickListener(this);
        ivThu.setOnClickListener(this);
        ivFri.setOnClickListener(this);
        ivSat.setOnClickListener(this);
        ivSun.setOnClickListener(this);

        sharedPreference = new SharedPreference(getActivity());

    }

    private void initializeChart() {
        chart.getXAxis().setDrawGridLines(false);
        // scaling can now only be done on x- and y-axis separately
        chart.setPinchZoom(false);

        chart.setDrawBarShadow(false);
        chart.setDrawGridBackground(false);

        XAxis xAxis = chart.getXAxis();
        xAxis.setDrawGridLines(false);

        Description description = new Description();
        description.setEnabled(false);
        chart.setDescription(description);

        chart.getAxisLeft().setDrawGridLines(false);
        chart.getAxisRight().setDrawGridLines(false);
        chart.getAxisRight().setEnabled(false);
        chart.getAxisLeft().setEnabled(true);
        chart.getXAxis().setDrawGridLines(false);
        // add a nice and smooth animation
        //chart.animateY(1500);


        chart.getLegend().setEnabled(false);

        chart.getAxisRight().setDrawLabels(false);
        chart.getAxisLeft().setDrawLabels(false);
        chart.setTouchEnabled(false);
        chart.setDoubleTapToZoomEnabled(false);
        chart.getXAxis().setEnabled(true);
        chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
    }

    private void callClub(String clubNumber) {
        //String posted_by = context.getString(R.string.clubNumber);
        String posted_by = clubNumber;
        String uri = "tel:" + posted_by.trim();
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(uri));
        startActivity(intent);
    }

    private void setActivityWeekSelected(String today) {
        if (today.equalsIgnoreCase("Mon")) {
            llMon.setBackground(getContext().getResources().getDrawable(R.drawable.view_border_rounded));
        } else if (today.equalsIgnoreCase("Tue")) {
            llTue.setBackground(getContext().getResources().getDrawable(R.drawable.view_border_rounded));
        } else if (today.equalsIgnoreCase("Wed")) {
            llWed.setBackground(getContext().getResources().getDrawable(R.drawable.view_border_rounded));
        } else if (today.equalsIgnoreCase("Thu")) {
            llThu.setBackground(getContext().getResources().getDrawable(R.drawable.view_border_rounded));
        } else if (today.equalsIgnoreCase("Fri")) {
            llFri.setBackground(getContext().getResources().getDrawable(R.drawable.view_border_rounded));
        } else if (today.equalsIgnoreCase("Sat")) {
            llSat.setBackground(getContext().getResources().getDrawable(R.drawable.view_border_rounded));
        } else if (today.equalsIgnoreCase("Sun")) {
            llSun.setBackground(getContext().getResources().getDrawable(R.drawable.view_border_rounded));
        }
    }

    private void setCurrentDaySelected(String today) {
        if (today.equalsIgnoreCase("Mon")) {
            ivMon.setVisibility(View.GONE);
            tvMon.setVisibility(View.VISIBLE);
            tvMon.setText(TODAY);
        } else if (today.equalsIgnoreCase("Tue")) {
            ivTue.setVisibility(View.GONE);
            tvTue.setVisibility(View.VISIBLE);
            tvTue.setText(TODAY);
        } else if (today.equalsIgnoreCase("Wed")) {
            ivWed.setVisibility(View.GONE);
            tvWed.setVisibility(View.VISIBLE);
            tvWed.setText(TODAY);
        } else if (today.equalsIgnoreCase("Thu")) {
            ivThu.setVisibility(View.GONE);
            tvThu.setVisibility(View.VISIBLE);
            tvThu.setText(TODAY);
        } else if (today.equalsIgnoreCase("Fri")) {
            ivFri.setVisibility(View.GONE);
            tvFri.setVisibility(View.VISIBLE);
            tvFri.setText(TODAY);
        } else if (today.equalsIgnoreCase("Sat")) {
            ivSat.setVisibility(View.GONE);
            tvSat.setVisibility(View.VISIBLE);
            tvSat.setText(TODAY);
        } else if (today.equalsIgnoreCase("Sun")) {
            ivSun.setVisibility(View.GONE);
            tvSun.setVisibility(View.VISIBLE);
            tvSun.setText(TODAY);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //MemberDetail memberDetail = sharedPreference.getObject(SharedPreference.loginDetails);
        String memberId = sharedPreference.getData(SharedPreference.memberId);
        if (memberId == null || memberId.isEmpty()){
            memberId = ServiceConstants.memberId;
        }
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        // TODO: Use the ViewModel
        mViewModel.init(ServiceConstants.tokenGeneral, ServiceConstants.clubId, memberId);
        mViewModel.getListLiveData().observe(getActivity(), new Observer<List<ClubLists>>() {
            @Override
            public void onChanged(List<ClubLists> clubLists) {
                if (clubLists != null) {
                    //set data to adapter
                    clubList = (ArrayList<ClubLists>) clubLists;
                }
            }
        });

        mViewModel.getDetailLiveData().observe(getActivity(), new Observer<MemberDetail>() {
            @Override
            public void onChanged(MemberDetail memberDetail) {
                if (memberDetail != null) {
                    tvName.setText("Hey " + memberDetail.getFirstName());
                }
            }
        });

        mViewModel.getDetailsLiveData().observe(getActivity(), new Observer<ClubDetails>() {
            @Override
            public void onChanged(ClubDetails clubDetails) {
                if (clubDetails != null) {
                    //set data...
                    tvClubName.setText(clubDetails.getClubName());
                    tvCall.setText(clubDetails.getPhone());
                    clubName = clubDetails.getClubName();
                    hoursList= (ArrayList<ClubDetails.OperatingTimes>)clubDetails.getOperatingTimes();
                }
            }
        });

        mViewModel.getOccupancyLiveData().observe(getActivity(), new Observer<ClubOccupancy>() {
            @Override
            public void onChanged(ClubOccupancy clubOccupancy) {
                if (clubOccupancy != null) {
                    //set chart data here...
                    occupancy = clubOccupancy;
                    tvClubName.setText(clubOccupancy.getClubName());
                    tvCapacityLabel.setText("Currently " + clubOccupancy.getOccupancy() + " % full");
                    setChartDetails(clubOccupancy, today);
                }
            }
        });
    }

    private void setChartDetails(ClubOccupancy clubOccupancy, String day) {

        chart.animateX(2000);
        //chart.setBackgroundColor(getContext().getResources().getColor(R.color.btnRed));
        BarData data;
        ArrayList<String> periodSlot = new ArrayList<>();
        ArrayList<BarEntry> period = new ArrayList<>();
        ArrayList<Integer> capacity = new ArrayList<>();

        if (day.equalsIgnoreCase("Mon")) {
            for (ClubOccupancy.Mon monList:clubOccupancy.getOccupancyHistory().getMon()){
//                period.add(new BarEntry(monList.getCapacity().floatValue(), monList.getPeriodSlot()));
                period.add(new BarEntry(Float.parseFloat(monList.getCapacity().toString()), monList.getPeriodSlot()));
                periodSlot.add(monList.getPeriodSlot().toString());
                capacity.add(monList.getCapacity());
            }
        } else if (day.equalsIgnoreCase("Tue")) {
            for (ClubOccupancy.Tue tueList:clubOccupancy.getOccupancyHistory().getTue()){
                period.add(new BarEntry(tueList.getCapacity().floatValue(), tueList.getPeriodSlot()));
                periodSlot.add(tueList.getPeriodSlot().toString());
                capacity.add(tueList.getCapacity());
            }
        } else if (day.equalsIgnoreCase("Wed")) {
            for (ClubOccupancy.Wed wedList:clubOccupancy.getOccupancyHistory().getWed()){
                period.add(new BarEntry(wedList.getCapacity().floatValue(), wedList.getPeriodSlot()));
                periodSlot.add(wedList.getPeriodSlot().toString());
                capacity.add(wedList.getCapacity());
            }
        } else if (day.equalsIgnoreCase("Thu")) {
            for (ClubOccupancy.Thu thuList:clubOccupancy.getOccupancyHistory().getThu()){
                period.add(new BarEntry(thuList.getCapacity().floatValue(), thuList.getPeriodSlot()));
                periodSlot.add(thuList.getPeriodSlot().toString());
                capacity.add(thuList.getCapacity());
            }
        } else if (day.equalsIgnoreCase("Fri")) {
            for (ClubOccupancy.Fri friList:clubOccupancy.getOccupancyHistory().getFri()){
                period.add(new BarEntry(friList.getCapacity().floatValue(), friList.getPeriodSlot()));
                periodSlot.add(friList.getPeriodSlot().toString());
                capacity.add(friList.getCapacity());
            }
        } else if (day.equalsIgnoreCase("Sat")) {
            for (ClubOccupancy.Sat satList:clubOccupancy.getOccupancyHistory().getSat()){
                period.add(new BarEntry(satList.getCapacity().floatValue(), satList.getPeriodSlot()));
                periodSlot.add(satList.getPeriodSlot().toString());
                capacity.add(satList.getCapacity());
            }
        } else if (day.equalsIgnoreCase("Sun")) {
            for (ClubOccupancy.Sun sunList:clubOccupancy.getOccupancyHistory().getSun()){
                period.add(new BarEntry(sunList.getCapacity().floatValue(), sunList.getPeriodSlot()));
                periodSlot.add(sunList.getPeriodSlot().toString());
                capacity.add(sunList.getCapacity());
            }
        }

        BarDataSet set1;
        if(chart.getData() != null &&
                chart.getData().getDataSetCount() > 0){
            set1 = (BarDataSet) chart.getData().getDataSetByIndex(0);
            set1.setValues(period);
            set1.setValueTextSize(14f);
            chart.getData().notifyDataChanged();
            chart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(period, "");
            set1.setColor(getContext().getResources().getColor(R.color.btnRed));
            set1.setDrawValues(true);
            set1.setValueTextSize(14f);

            ArrayList<IBarDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1);

            BarData data1 = new BarData(dataSets);
            chart.setData(data1);
            //chart.setVisibleXRange(1,4);
            chart.setFitBars(true);
            /*YAxis y1 = chart.getAxisLeft();
            float percent = 10;
            y1.setSpaceTop(percent);
            y1.setSpaceBottom(percent);*/
            XAxis xAxis = chart.getXAxis();
            //xAxis.setGranularity(1f);
           // xAxis.setGranularityEnabled(true);
            xAxis.setValueFormatter(new IndexAxisValueFormatter(periodSlot));//setting String values in Xaxis
            for (IDataSet set : chart.getData().getDataSets())
                set.setDrawValues(!set.isDrawValuesEnabled());

            chart.invalidate();
        }

        /*BarData data1 = new BarData(periodSlot, period);
        chart.setData(data1);
        chart.setDescription("My Chart");
        chart.animateXY(2000, 2000);
        chart.invalidate();*/

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivMon:
                tvMon.setVisibility(View.VISIBLE);
                ivMon.setVisibility(View.GONE);

                tvTue.setVisibility(View.GONE);
                tvWed.setVisibility(View.GONE);
                tvThu.setVisibility(View.GONE);
                tvFri.setVisibility(View.GONE);
                tvSat.setVisibility(View.GONE);
                tvSun.setVisibility(View.GONE);

                ivSun.setVisibility(View.VISIBLE);
                ivTue.setVisibility(View.VISIBLE);
                ivWed.setVisibility(View.VISIBLE);
                ivThu.setVisibility(View.VISIBLE);
                ivFri.setVisibility(View.VISIBLE);
                ivSat.setVisibility(View.VISIBLE);
                if (occupancy != null){
                    setChartDetails(occupancy, "Mon");
                }
                break;
            case R.id.ivTue:
                tvTue.setVisibility(View.VISIBLE);
                ivTue.setVisibility(View.GONE);

                tvMon.setVisibility(View.GONE);
                tvWed.setVisibility(View.GONE);
                tvThu.setVisibility(View.GONE);
                tvFri.setVisibility(View.GONE);
                tvSat.setVisibility(View.GONE);
                tvSun.setVisibility(View.GONE);

                ivMon.setVisibility(View.VISIBLE);
                ivSun.setVisibility(View.VISIBLE);
                ivWed.setVisibility(View.VISIBLE);
                ivThu.setVisibility(View.VISIBLE);
                ivFri.setVisibility(View.VISIBLE);
                ivSat.setVisibility(View.VISIBLE);
                if (occupancy != null){
                    setChartDetails(occupancy, "Tue");
                }
                break;
            case R.id.ivWed:
                tvWed.setVisibility(View.VISIBLE);
                ivWed.setVisibility(View.GONE);

                tvTue.setVisibility(View.GONE);
                tvMon.setVisibility(View.GONE);
                tvThu.setVisibility(View.GONE);
                tvFri.setVisibility(View.GONE);
                tvSat.setVisibility(View.GONE);
                tvSun.setVisibility(View.GONE);

                ivMon.setVisibility(View.VISIBLE);
                ivTue.setVisibility(View.VISIBLE);
                ivSun.setVisibility(View.VISIBLE);
                ivThu.setVisibility(View.VISIBLE);
                ivFri.setVisibility(View.VISIBLE);
                ivSat.setVisibility(View.VISIBLE);
                if (occupancy != null){
                    setChartDetails(occupancy, "Wed");
                }
                break;
            case R.id.ivThu:
                tvThu.setVisibility(View.VISIBLE);
                ivThu.setVisibility(View.GONE);

                tvTue.setVisibility(View.GONE);
                tvWed.setVisibility(View.GONE);
                tvMon.setVisibility(View.GONE);
                tvFri.setVisibility(View.GONE);
                tvSat.setVisibility(View.GONE);
                tvSun.setVisibility(View.GONE);

                ivMon.setVisibility(View.VISIBLE);
                ivTue.setVisibility(View.VISIBLE);
                ivWed.setVisibility(View.VISIBLE);
                ivSun.setVisibility(View.VISIBLE);
                ivFri.setVisibility(View.VISIBLE);
                ivSat.setVisibility(View.VISIBLE);
                if (occupancy != null){
                    setChartDetails(occupancy, "Thu");
                }
                break;
            case R.id.ivFri:
                tvFri.setVisibility(View.VISIBLE);
                ivFri.setVisibility(View.GONE);

                tvTue.setVisibility(View.GONE);
                tvWed.setVisibility(View.GONE);
                tvThu.setVisibility(View.GONE);
                tvMon.setVisibility(View.GONE);
                tvSat.setVisibility(View.GONE);
                tvSun.setVisibility(View.GONE);

                ivMon.setVisibility(View.VISIBLE);
                ivTue.setVisibility(View.VISIBLE);
                ivWed.setVisibility(View.VISIBLE);
                ivThu.setVisibility(View.VISIBLE);
                ivSun.setVisibility(View.VISIBLE);
                ivSat.setVisibility(View.VISIBLE);
                if (occupancy != null){
                    setChartDetails(occupancy, "Fri");
                }
                break;
            case R.id.ivSat:
                tvSat.setVisibility(View.VISIBLE);
                ivSat.setVisibility(View.GONE);

                tvTue.setVisibility(View.GONE);
                tvWed.setVisibility(View.GONE);
                tvThu.setVisibility(View.GONE);
                tvFri.setVisibility(View.GONE);
                tvMon.setVisibility(View.GONE);
                tvSun.setVisibility(View.GONE);

                ivMon.setVisibility(View.VISIBLE);
                ivTue.setVisibility(View.VISIBLE);
                ivWed.setVisibility(View.VISIBLE);
                ivThu.setVisibility(View.VISIBLE);
                ivFri.setVisibility(View.VISIBLE);
                ivSun.setVisibility(View.VISIBLE);
                if (occupancy != null){
                    setChartDetails(occupancy, "Sat");
                }
                break;
            case R.id.ivSun:
                tvSun.setVisibility(View.VISIBLE);
                ivSun.setVisibility(View.GONE);

                tvTue.setVisibility(View.GONE);
                tvWed.setVisibility(View.GONE);
                tvThu.setVisibility(View.GONE);
                tvFri.setVisibility(View.GONE);
                tvSat.setVisibility(View.GONE);
                tvMon.setVisibility(View.GONE);

                ivMon.setVisibility(View.VISIBLE);
                ivTue.setVisibility(View.VISIBLE);
                ivWed.setVisibility(View.VISIBLE);
                ivThu.setVisibility(View.VISIBLE);
                ivFri.setVisibility(View.VISIBLE);
                ivSat.setVisibility(View.VISIBLE);
                if (occupancy != null){
                    setChartDetails(occupancy, "Sun");
                }
                break;


            case R.id.tvMon:
                tvMon.setVisibility(View.GONE);
                ivMon.setVisibility(View.VISIBLE);
                break;
            case R.id.tvTue:
                tvTue.setVisibility(View.GONE);
                ivTue.setVisibility(View.VISIBLE);
                break;
            case R.id.tvWed:
                tvWed.setVisibility(View.GONE);
                ivWed.setVisibility(View.VISIBLE);
                break;
            case R.id.tvThu:
                tvThu.setVisibility(View.GONE);
                ivThu.setVisibility(View.VISIBLE);
                break;
            case R.id.tvFri:
                tvFri.setVisibility(View.GONE);
                ivFri.setVisibility(View.VISIBLE);
                break;
            case R.id.tvSat:
                tvSat.setVisibility(View.GONE);
                ivSat.setVisibility(View.VISIBLE);
                break;
            case R.id.tvSun:
                tvSun.setVisibility(View.GONE);
                ivSun.setVisibility(View.VISIBLE);
                break;
        }
    }

    public static String getCurrentWeek(Calendar mCalendar) {
        Date date = new Date();
        mCalendar.setTime(date);

        // 1 = Sunday, 2 = Monday, etc.
        int day_of_week = mCalendar.get(Calendar.DAY_OF_WEEK);

        int monday_offset;
        if (day_of_week == 1) {
            monday_offset = -6;
        } else
            monday_offset = (2 - day_of_week); // need to minus back
        mCalendar.add(Calendar.DAY_OF_YEAR, monday_offset);

        Date mDateMonday = mCalendar.getTime();

        // return 6 the next days of current day (object cal save current day)
        mCalendar.add(Calendar.DAY_OF_YEAR, 6);
        Date mDateSunday = mCalendar.getTime();

        //Get format date
        String strDateFormat = "dd MMM";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);

        String MONDAY = sdf.format(mDateMonday);
        String SUNDAY = sdf.format(mDateSunday);

        // Sub String
        if ((MONDAY.substring(3, 6)).equals(SUNDAY.substring(3, 6))) {
            MONDAY = MONDAY.substring(0, 2);
        }

        return MONDAY + " - " + SUNDAY;
    }

    public boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG", "Permission is granted");
                return true;
            } else {

                Log.v("TAG", "Permission is revoked");
                requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.v("TAG", "Permission is granted");
            return true;
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {

            case 1: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(context, "Permission granted", Toast.LENGTH_SHORT).show();
                    callClub(tvCall.getText().toString());
                } else {
                    Toast.makeText(context, "Permission denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}