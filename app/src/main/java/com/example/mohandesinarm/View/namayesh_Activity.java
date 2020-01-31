package com.example.mohandesinarm.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;

import com.example.mohandesinarm.Model.ElanModel;
import com.example.mohandesinarm.R;
import com.example.mohandesinarm.ShowList;
import com.example.mohandesinarm.controller.MainController;

import java.util.List;

public class namayesh_Activity extends AppCompatActivity {

    List<ElanModel> elanModels;
    MainController controller=new MainController();
    RecyclerView recyclerView;
    Thread thread;
    Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_namayesh);
        recyclerView=findViewById(R.id.rv_namayesh);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL,false));


        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                elanModels = controller.getElans(getApplicationContext());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setAdapter(new ShowList(elanModels,namayesh_Activity.this));
                    }
                });
            }
        });

        thread.start();





    }
}
