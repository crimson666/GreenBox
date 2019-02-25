package com.example.stealth.einstore;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



@SuppressLint("ValidFragment")
public class frag_home extends Fragment implements View.OnClickListener{

    CardView bpm,it,sales,software,hr,finance,housekeeping,security,management;

    String a;

    @SuppressLint("ValidFragment")
    public frag_home(String a) {
        this.a=a;


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.fragment_frag_home, container, false);
        bpm=(CardView)view.findViewById(R.id.BPM);
        it=(CardView)view.findViewById(R.id.IT);
        sales=(CardView)view.findViewById(R.id.SALES);
        software=(CardView)view.findViewById(R.id.SOFTWARE);
        hr=(CardView)view.findViewById(R.id.HR);
        finance=(CardView)view.findViewById(R.id.FINANCE);
        security=(CardView)view.findViewById(R.id.SECURITY);
        housekeeping=(CardView)view.findViewById(R.id.HOUSEKEEPING);
        management=(CardView)view.findViewById(R.id.MANAGEMENT);

        Context context = view.getContext();
        bpm.setOnClickListener(this);
        it.setOnClickListener(this);
        sales.setOnClickListener(this);
        software.setOnClickListener(this);
        hr.setOnClickListener(this);
        finance.setOnClickListener(this);
        security.setOnClickListener(this);
        housekeeping.setOnClickListener(this);
        management.setOnClickListener(this);


        return view;


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.BPM: {
               /* Intent intent = new Intent(getContext(), rec_dept.class);
                intent.putExtra("KEY", "BPM");
                intent.putExtra("ID", a);
                getContext().startActivity(intent);*/
            }
            break;

            case R.id.IT:
            {
                /*Intent intent = new Intent(getContext(), rec_dept.class);
                intent.putExtra("KEY", "IT");
                intent.putExtra("ID", a);
                getContext().startActivity(intent);*/
            }
            break;

            case R.id.SALES:
            {
                /*Intent intent = new Intent(getContext(), rec_dept.class);
                intent.putExtra("KEY", "SALES");
                intent.putExtra("ID", a);
                getContext().startActivity(intent);*/
            }
            break;

            case R.id.SOFTWARE:
            {
                /*Intent intent = new Intent(getContext(), rec_dept.class);
                intent.putExtra("KEY", "SOFTWARE");
                intent.putExtra("ID", a);
                getContext().startActivity(intent);*/
            }
            break;

            case R.id.HR:
            {
                /*Intent intent = new Intent(getContext(), rec_dept.class);
                intent.putExtra("KEY", "HR");
                intent.putExtra("ID", a);
                getContext().startActivity(intent);*/
            }
            break;
            case R.id.SECURITY:
            {
                /*Intent intent = new Intent(getContext(), rec_dept.class);
                intent.putExtra("KEY", "SECURITY");
                intent.putExtra("ID", a);
                getContext().startActivity(intent);*/
            }
            break;
            case R.id.FINANCE:
            {
               /* Intent intent = new Intent(getContext(), rec_dept.class);
                intent.putExtra("KEY", "FINANCE");
                intent.putExtra("ID", a);
                getContext().startActivity(intent);*/
            }
            break;
            case R.id.HOUSEKEEPING:
            {
                /*Intent intent = new Intent(getContext(), rec_dept.class);
                intent.putExtra("KEY", "HOUSEKEEPING");
                intent.putExtra("ID", a);
                getContext().startActivity(intent);*/
            }
            break;
            case R.id.MANAGEMENT:
            {
                /*Intent intent = new Intent(getContext(), rec_dept.class);
                intent.putExtra("KEY", "MANAGEMENT");
                intent.putExtra("ID", a);
                getContext().startActivity(intent);*/
            }
            break;

            default:
                break;
        }


    }



}




