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

public class CulturesFragment extends Fragment {

    private ArrayList<Subject> cultures = new ArrayList<>();
    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
            Intent intHolder = new Intent( getContext(), DetailsActivity.class);
            int position = viewHolder.getAdapterPosition();
            intHolder.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intHolder.putExtra("number",position);
            intHolder.putParcelableArrayListExtra("Subject", cultures);
            getContext().startActivity(intHolder);
        }
    };


    public CulturesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cultures.add(new Subject(getString(R.string.culturePedi),getString(R.string.culturePediDescDesc),getString(R.string.culturePediDescMore),0,R.drawable.sepedi));
        cultures.add(new Subject(getString(R.string.cultureNdebele),getString(R.string.cultureNdebeleDesc),getString(R.string.cultureNdebeleDescMore),1,R.drawable.ndebele));
        cultures.add(new Subject(getString(R.string.cultureZulu),getString(R.string.cultureZuluDesc),getString(R.string.cultureZuluDescMore),2,R.drawable.zulu));
        cultures.add(new Subject(getString(R.string.cultureVenda),getString(R.string.cultureVendaDesc),getString(R.string.cultureVendaDescMore),3,R.drawable.venda));
        cultures.add(new Subject(getString(R.string.cultureXhosa),getString(R.string.cultureXhosaDesc),getString(R.string.cultureXhosaDescMore),4,R.drawable.xhosa));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View RootView = inflater.inflate(R.layout.fragment_cultures, container, false);
        SubjectsAdapter itemsAdapter = new SubjectsAdapter((MainActivity) getContext(),cultures);
        RecyclerView View = RootView.findViewById(R.id.cultures_recycler_view);
        View.setAdapter(itemsAdapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity().getApplicationContext());
        View.setLayoutManager(llm);
        itemsAdapter.setmOnItemClickListener(onItemClickListener);

        return RootView;
    }
}
