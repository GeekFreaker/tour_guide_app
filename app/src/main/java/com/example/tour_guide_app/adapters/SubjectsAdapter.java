package com.example.tour_guide_app.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.example.tour_guide_app.DetailsActivity;
import com.example.tour_guide_app.MainActivity;
import com.example.tour_guide_app.R;
import com.example.tour_guide_app.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectsAdapter extends Adapter<SubjectsAdapter.SubjectViewHolder> {

    private Context mContext;
    private List<Subject> mSubject;
    private View.OnClickListener mOnItemClickListener;


    public void setmOnItemClickListener(View.OnClickListener itemClickListener) {
        this.mOnItemClickListener = itemClickListener;
    }

    public SubjectsAdapter(Context context, ArrayList<Subject> subject) {
        super();
        mContext = context;
        mSubject = subject;
    }

    public class SubjectViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView subjectName;
        TextView subjectDescription;
        ImageView cardPhoto;

        SubjectViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.card_view);
            subjectName = itemView.findViewById(R.id.subject_name);
            subjectDescription = itemView.findViewById(R.id.subject_description);
            cardPhoto = itemView.findViewById(R.id.subject_photo);
            itemView.setTag(this);
            itemView.setOnClickListener(mOnItemClickListener);
        }
    }

    @NonNull
    @Override
    public SubjectsAdapter.SubjectViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, viewGroup, false);
        return new SubjectViewHolder(v);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectsAdapter.SubjectViewHolder holder, final int position) {
        holder.subjectName.setText(mSubject.get(position).getSubjectName());
        switch(holder.getAdapterPosition()){
            case 0:
                holder.subjectName.setShadowLayer(2,1.5f,1.3f,mContext.getResources().getColor(R.color.col_flowers));
                break;

            case 1:
                holder.subjectName.setShadowLayer(2,1.5f,1.3f,mContext.getResources().getColor(R.color.col_cultures));
                break;

            case 2:
                holder.subjectName.setShadowLayer(2,1.5f,1.3f,mContext.getResources().getColor(R.color.col_historical));
                break;

            case 3:
                holder.subjectName.setShadowLayer(2,1.5f,1.3f,mContext.getResources().getColor(R.color.col_wildlife));
                break;

            case 4:
                holder.subjectName.setShadowLayer(2,1.5f,1.3f,mContext.getResources().getColor(R.color.col_poltiical));
                break;

            default:
                break;
        }
        holder.subjectDescription.setText(mSubject.get(position).getSubjectDescription());
        holder.cardPhoto.setImageResource(mSubject.get(position).getImageValue());
    }

    @Override
    public int getItemCount() {
        return mSubject.size();
    }

}

