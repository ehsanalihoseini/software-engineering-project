package com.example.mohandesinarm.Model;

import java.util.List;

public class NamayeshModel {
    ElanModel elanModel_temp = new ElanModel();

    public void sortElans(List<ElanModel> elanModels) {

        for (int i = 0; i < elanModels.size(); i++) {
            for (int j = i + 1; j < elanModels.size(); j++) {
                int ol1, ol2;

                if (Integer.parseInt(elanModels.get(i).olaviat) < Integer.parseInt(elanModels.get(j).olaviat)) {
                    elanModel_temp = elanModels.get(i);
                    elanModels.set(i, elanModels.get(j));
                    elanModels.set(j, elanModel_temp);
                }

                if (elanModels.get(i).sath < elanModels.get(j).sath) {
                    elanModel_temp = elanModels.get(i);
                    elanModels.set(i, elanModels.get(j));
                    elanModels.set(j, elanModel_temp);
                }

                if (elanModels.get(i).group.compareTo(elanModels.get(j).group) > 0) {
                    elanModel_temp = elanModels.get(i);
                    elanModels.set(i, elanModels.get(j));
                    elanModels.set(j, elanModel_temp);
                }


            }
        }


    }


}
