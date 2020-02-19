package com.example.tour_guide_app.frags;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tour_guide_app.DetailsActivity;
import com.example.tour_guide_app.MainActivity;
import com.example.tour_guide_app.R;
import com.example.tour_guide_app.Subject;
import com.example.tour_guide_app.adapters.SubjectsAdapter;

import java.util.ArrayList;

public class HistoricalMonumentsFragment extends Fragment {

    private ArrayList<Subject> hismon = new ArrayList<>();
    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
            Intent intHolder = new Intent( getContext(), DetailsActivity.class);
            int position = viewHolder.getAdapterPosition();
            intHolder.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intHolder.putExtra("number",position);
            intHolder.putParcelableArrayListExtra("Subject", hismon);
            getContext().startActivity(intHolder);
        }
    };

    public HistoricalMonumentsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hismon.add(new Subject(getString(R.string.hisMon_ConstituionHill),getString(R.string.hisMon_ConstituionHillDesc),getString(R.string.hisMon_ConstituionHillDescMore),0,R.drawable.con_hill));
        hismon.add(new Subject(getString(R.string.hisMon_BotannicalGardens),getString(R.string.hisMon_BotannicalGardensDesc),getString(R.string.hisMon_BotannicalGardensDescMore),1,R.drawable.botannical));
        hismon.add(new Subject(getString(R.string.hisMon_LuthuliHouse),getString(R.string.hisMon_LuthuliHouseDesc),getString(R.string.hisMon_LuthuliHouseDescMore),2,R.drawable.luthuli));
        hismon.add(new Subject(getString(R.string.hisMon_ORTambo),getString(R.string.hisMon_ORTamboDesc),getString(R.string.hisMon_ORTamboDescMore),3,R.drawable.or_tambo));
        hismon.add(new Subject(getString(R.string.hisMon_Vilakazi),getString(R.string.hisMon_VilakaziDesc),getString(R.string.hisMon_VilakaziDescMore),4,R.drawable.vilakazi));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View RootView = inflater.inflate(R.layout.fragment_historical_monuments, container, false);
        SubjectsAdapter itemsAdapter = new SubjectsAdapter((MainActivity) getContext(),hismon);
        RecyclerView View = RootView.findViewById(R.id.historical_recycler_view);
        View.setAdapter(itemsAdapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity().getApplicationContext());
        View.setLayoutManager(llm);
        itemsAdapter.setmOnItemClickListener(onItemClickListener);

        return RootView;
    }
}
