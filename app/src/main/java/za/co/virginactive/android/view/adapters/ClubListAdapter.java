package za.co.virginactive.android.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import za.co.virginactive.android.R;
import za.co.virginactive.android.service.model.ClubLists;

public class ClubListAdapter extends RecyclerView.Adapter<ClubListAdapter.MyViewHolder>{
    private List<ClubLists> clubList;
    RecyclerItemListener listener;

    public ClubListAdapter(ArrayList<ClubLists> clubList, RecyclerItemListener listener) {
        this.clubList = clubList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_clubs_list, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvSelectNearest.setText(clubList.get(position).getClubName());
        holder.tvSelectNearest.setOnClickListener(v -> {
            if (listener != null){
                listener.onClubClicked(clubList.get(position), v);
            }
        });
    }

    @Override
    public int getItemCount() {
        return clubList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvSelectNearest;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSelectNearest = itemView.findViewById(R.id.tvClubListItem);
        }
    }

    public interface RecyclerItemListener{
        void onClubClicked(ClubLists lists, View view);
    }
}
