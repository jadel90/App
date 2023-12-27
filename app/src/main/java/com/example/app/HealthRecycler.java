package com.example.app;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class HealthRecycler extends RecyclerView.Adapter<HealthRecycler.ViewHolder>{

    Context context;
    ArrayList<HealthData> arrayList = new ArrayList<>();
    ArrayList<GPData> gpArrayList;
    FirebaseAuth mAuth;

    Button logoutBtn;


    public HealthRecycler(Context context, ArrayList<HealthData> arrayList, Button logoutBtn ) {
        this.context = context;
        this.arrayList = arrayList;
        this.logoutBtn = logoutBtn;

    }


    @NonNull
    @Override
    public HealthRecycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HealthRecycler.ViewHolder holder, int position) {
        holder.imageView.setImageResource(arrayList.get(position).getImage());
        holder.textView1.setText(arrayList.get(position).getName());


        Log.d("RecyclerViewClick", "Position clicked: " + position);


        // Set a click listener on the cardView
        // When click on recyclerview/cardView, it brings us to a new activity.
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Launch the corresponding activity based on item position
                Intent intent;
                switch (position) {

                    case 0:
                        intent = new Intent(view.getContext(), Insurance.class);
                        context.startActivity(intent);
                        break;

                    case 1:
                        intent = new Intent(view.getContext(), PatientDetails.class);
                        context.startActivity(intent);
                        break;

                    case 2:
                        intent = new Intent(view.getContext(), DisplayPatientDetails.class);
                        context.startActivity(intent);
                        break;

                    case 3:
                        intent = new Intent(view.getContext(), Rating.class);
                        context.startActivity(intent);
                        break;

                    case 4:
                        intent = new Intent(view.getContext(), Dial.class);
                        context.startActivity(intent);
                        break;

                    case 5:
                        intent = new Intent(view.getContext(), ContactInsurance.class);
                        context.startActivity(intent);
                        break;

                    case 6:
                        intent = new Intent(view.getContext(), ContactMedical.class);
                        context.startActivity(intent);
                        break;


                    case 7:
                        intent = new Intent(view.getContext(), gpDetails.class);
                        context.startActivity(intent);
                        break;

                    case 8:
                        intent = new Intent(view.getContext(), DiabetesQuestionnaire.class);
                        context.startActivity(intent);
                        break;

                    case 9:
                        intent = new Intent(view.getContext(), HeartDiseaseQuestionnaire.class);
                        context.startActivity(intent);
                        break;

                    case 10:
                        intent = new Intent(view.getContext(), LungCancerQuestionnaire.class);
                        context.startActivity(intent);
                        break;


            }
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView1 = itemView.findViewById(R.id.textView1);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }


}
