package com.example.tour_guide_app.frags;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.tour_guide_app.DetailsActivity;
import com.example.tour_guide_app.MainActivity;
import com.example.tour_guide_app.R;
import com.example.tour_guide_app.Subject;
import com.example.tour_guide_app.adapters.SubjectsAdapter;

import java.util.ArrayList;

public class PoliticalPartiesFragment extends Fragment {

    private ArrayList<Subject> parties = new ArrayList<>();
    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
            Intent intHolder = new Intent( getContext(), DetailsActivity.class);
            int position = viewHolder.getAdapterPosition();
            intHolder.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intHolder.putExtra("number",position);
            intHolder.putParcelableArrayListExtra("Subject", parties);
            getContext().startActivity(intHolder);
        }
    };

    public PoliticalPartiesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create all the political parties.
        parties.add(new Subject(getString(R.string.partyDA),getString(R.string.partyDADesc),getString(R.string.partyDADescMore),0,R.drawable.da));
        parties.add(new Subject(getString(R.string.partyANC),getString(R.string.partyANCDesc),getString(R.string.partyANCDescMore),1,R.drawable.anc));
        parties.add(new Subject(getString(R.string.partyAZAPO),getString(R.string.partyAZAPODesc),getString(R.string.partyAZAPODescMore),2,R.drawable.azapo));
        parties.add(new Subject(getString(R.string.partyEFF),getString(R.string.partyEFFDesc),getString(R.string.partyEFFDescMore),3,R.drawable.eff));
        parties.add(new Subject(getString(R.string.partyUDM),getString(R.string.partyUDMDesc),getString(R.string.partyUDMDescMore),4,R.drawable.udm));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View RootView = inflater.inflate(R.layout.fragment_political_parties, container, false);
        SubjectsAdapter itemsAdapter = new SubjectsAdapter(getContext(),parties);
        RecyclerView View = RootView.findViewById(R.id.political_recycler_view);
        View.setAdapter(itemsAdapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity().getApplicationContext());
        View.setLayoutManager(llm);
        itemsAdapter.setmOnItemClickListener(onItemClickListener);

        return RootView;
    }
}
