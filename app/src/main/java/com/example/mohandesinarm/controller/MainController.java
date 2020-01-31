package com.example.mohandesinarm.controller;

import android.content.Context;

import com.example.mohandesinarm.Model.Client;
import com.example.mohandesinarm.Model.ElanModel;
import com.example.mohandesinarm.Model.NamayeshModel;

import java.util.List;

public class MainController {


    NamayeshModel namayeshModel=new NamayeshModel();



    public boolean saveElan(ElanModel elanModel, Context context){
        Client.getClient(context).elanDao().insertAll(elanModel);
        return  true;
    }



    public List<ElanModel> getElans(Context context){
        List<ElanModel> elanModels = Client.getClient(context).elanDao().getAll();
        namayeshModel.sortElans(elanModels);
        return elanModels;
    }

}
