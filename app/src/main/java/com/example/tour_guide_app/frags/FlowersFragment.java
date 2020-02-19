package com.example.tour_guide_app.frags;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

public class FlowersFragment extends Fragment {

    private ArrayList<Subject> flowers = new ArrayList<>();
    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
            Intent intHolder = new Intent( getContext(), DetailsActivity.class);
            int position = viewHolder.getAdapterPosition();
            intHolder.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intHolder.putExtra("number",position);
            intHolder.putParcelableArrayListExtra("Subject", flowers);
            getContext().startActivity(intHolder);
        }
    };

    public FlowersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        flowers.add(new Subject(getString(R.string.flowerMaize),getString(R.string.flowerMaizeDesc),getString(R.string.flowerMaizeDescMore),0,R.drawable.maize));
        flowers.add(new Subject(getString(R.string.flowerCosmos),getString(R.string.flowerCosmosDesc),getString(R.string.flowerCosmosDescMore),1,R.drawable.cosmos));
        flowers.add(new Subject(getString(R.string.flowerProtea),getString(R.string.flowerProteaDesc),getString(R.string.flowerProteaDescMore),2,R.drawable.protea));
        flowers.add(new Subject(getString(R.string.flowerSugarCane),getString(R.string.flowerSugarCanDesc),getString(R.string.flowerSugarCaneDescMore),3,R.drawable.sugar_cane));
        flowers.add(new Subject(getString(R.string.flowerZinnia),getString(R.string.flowerZinniaDesc),getString(R.string.flowerZinniaDescMore),4,R.drawable.zinnias));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View RootView = inflater.inflate(R.layout.fragment_flowers, container, false);
        SubjectsAdapter itemsAdapter = new SubjectsAdapter((MainActivity) getContext(),flowers);
        RecyclerView View = RootView.findViewById(R.id.flowers_recycler_view);
        View.setAdapter(itemsAdapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity().getApplicationContext());
        View.setLayoutManager(llm);
        itemsAdapter.setmOnItemClickListener(onItemClickListener);

        return RootView;
    }

}
