package com.example.easylearn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class Category extends BottomSheetDialogFragment {
    ImageView bear,cat,horse,table;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.bottom_sheet_layout,
                container, false);



        Button stoolbutton = v.findViewById(R.id.Stool);
        Button tablebutton = v.findViewById(R.id.table);
        Button chairbutton = v.findViewById(R.id.Chair);
        Button Home = v.findViewById(R.id.Home);

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {


            }
        });

        tablebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
               /* Intent i;
                i = new Intent(getActivity(), ChairActivity.class);
                startActivity(i);*/

                ((MainActivity)getActivity()).tableactivity();

            }
        });


        stoolbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
               /* Intent i;
                i = new Intent(getActivity(), ChairActivity.class);
                startActivity(i);*/

                ((MainActivity)getActivity()).stoolactivity();

            }
        });


        chairbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
               /* Intent i;
                i = new Intent(getActivity(), ChairActivity.class);
                startActivity(i);*/

                ((MainActivity)getActivity()).chairactivity();

            }
        });




        return v;
    }
}