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


public class WildlifeFragment extends Fragment {

    private ArrayList<Subject> wildlife = new ArrayList<>();
    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
            Intent intHolder = new Intent( getContext(), DetailsActivity.class);
            int position = viewHolder.getAdapterPosition();
            intHolder.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intHolder.putExtra("number",position);
            intHolder.putParcelableArrayListExtra("Subject", wildlife);
            getContext().startActivity(intHolder);
        }
    };


    public WildlifeFragment() {
        // Required empty public constructor
        // Create all the political wildlife.
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wildlife.add(new Subject(getString(R.string.wildBuffalo),getString(R.string.wildBuffaloDesc),getString(R.string.wildBuffaloDescMore),0,R.drawable.buffalo));
        wildlife.add(new Subject(getString(R.string.wildRhino),getString(R.string.wildRhinoDesc),getString(R.string.wildRhinoDescMore),1,R.drawable.rhino));
        wildlife.add(new Subject(getString(R.string.wildHippo),getString(R.string.wildHippoDesc),getString(R.string.wildHippoDescMore),2,R.drawable.hippo));
        wildlife.add(new Subject(getString(R.string.wildLion),getString(R.string.wildLionDesc),getString(R.string.wildLionDescMore),3,R.drawable.lion));
        wildlife.add(new Subject(getString(R.string.wildKudu),getString(R.string.wildKuduDesc),getString(R.string.wildKuduDescMore),4,R.drawable.kudu));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View RootView = inflater.inflate(R.layout.fragment_wildlife, container, false);
        SubjectsAdapter itemsAdapter = new SubjectsAdapter((MainActivity) getContext(),wildlife);
        RecyclerView View = RootView.findViewById(R.id.wildlife_recycler_view);
        View.setAdapter(itemsAdapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity().getApplicationContext());
        View.setLayoutManager(llm);

        itemsAdapter.setmOnItemClickListener(onItemClickListener);
        return RootView;
    }

}
