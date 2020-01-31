package com.example.mohandesinarm.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mohandesinarm.Model.Client;
import com.example.mohandesinarm.Model.ElanDataBase;
import com.example.mohandesinarm.Model.ElanModel;
import com.example.mohandesinarm.R;
import com.example.mohandesinarm.controller.MainController;

public class elan_adi extends AppCompatActivity {


    TextView txtTitle, txtName, txtMatn, txtGroup, txtEmail, txtSms, txtOlaviat;
    String title, group;
    int sathElan = 0;
    CheckBox cbDaneshgah, cbDaneshkadeh, cbReshteh, cbBlutus, cbEmail, cbSms;
    Button btreset, btsave;
    Thread thread;
    Handler handler = new Handler();
    ElanModel elanModel;
    MainController controller = new MainController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabt_activity);

        title = getIntent().getExtras().getString("kind");
        setUpViews();
        onClicks();


    }

    private void onClicks() {
        cbEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbEmail.isChecked()) {
                    txtEmail.setVisibility(View.VISIBLE);
                } else {
                    txtEmail.setVisibility(View.GONE);
                }
            }
        });
        cbSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbSms.isChecked()) {
                    txtSms.setVisibility(View.VISIBLE);
                } else {
                    txtSms.setVisibility(View.GONE);
                }
            }
        });

        cbDaneshgah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cbDaneshkadeh.setChecked(false);
                cbReshteh.setChecked(false);
                cbDaneshgah.setChecked(true);
                sathElan = 3;
            }
        });
        cbDaneshkadeh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cbDaneshgah.setChecked(false);
                cbReshteh.setChecked(false);
                cbDaneshkadeh.setChecked(true);
                sathElan = 2;
            }
        });
        cbReshteh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cbDaneshkadeh.setChecked(false);
                cbDaneshgah.setChecked(false);
                cbReshteh.setChecked(true);
                sathElan = 1;
            }
        });
        btreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetView();

            }
        });


        btsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValid()) {
                    saveelan();
                }else{
                    Toast.makeText(getApplicationContext(),"لطفا موارد را وارد کنید.",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void resetView() {
        txtSms.setText("");
        txtEmail.setText("");
        txtMatn.setText("");
        txtName.setText("");
        txtOlaviat.setText("");
        cbDaneshkadeh.setChecked(false);
        cbDaneshgah.setChecked(false);
        cbReshteh.setChecked(false);
        cbSms.setChecked(false);
        cbBlutus.setChecked(false);
        cbEmail.setChecked(false);
        sathElan = 0;
        txtEmail.setVisibility(View.GONE);
        txtSms.setVisibility(View.GONE);
    }

    //check kardan olavait
    private boolean isValid() {
        boolean valid = true;
        if (txtName.getText().toString().isEmpty()) {
            valid = false;
        }
        if (txtMatn.getText().toString().isEmpty()) {
            valid = false;
        }
        if (txtEmail.getText().toString().isEmpty() && cbEmail.isChecked()) {
            valid = false;
        }
        if(sathElan==0){
            valid=false;
        }
        if (txtOlaviat.getText().toString().isEmpty()){
            valid=false;
        }
        if (txtSms.getText().toString().isEmpty() && cbSms.isChecked()){
            valid=false;
        }
        return valid;
    }

    private void saveelan() {

        elanModel = new ElanModel();
        elanModel.setEmail(txtEmail.getText().toString());
        elanModel.setGroup(txtGroup.getText().toString());
        elanModel.setMatn(txtMatn.getText().toString());
        elanModel.setName(txtName.getText().toString());
        elanModel.setOlaviat(txtOlaviat.getText().toString());
        elanModel.setPhone(txtEmail.getText().toString());
        elanModel.setSath(sathElan);


        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                if (controller.saveElan(elanModel, getApplicationContext())) {
                    //chon thread rooye view nmitoone kar kone, pas az handler estefade mikonim
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "اعلان ذخیره شد", Toast.LENGTH_LONG).show();
                            resetView();
                        }
                    });
                }

            }
        });
        thread.start();


        // Client.getClient(this).elanDao().insertElans(elanModel);
//        ElanDataBase elanDataBase = Room.databaseBuilder(getApplicationContext(),ElanDataBase.class,"elandatabase").build();
//        elanDataBase.elanDao().insertAll(elanModel);

    }

    private void setUpViews() {
        txtEmail = findViewById(R.id.email_txt);
        txtGroup = findViewById(R.id.txt_elan_group);
        txtMatn = findViewById(R.id.txt_matn_elan);
        txtName = findViewById(R.id.txt_elan_name);
        txtOlaviat = findViewById(R.id.olaviat_txt);
        txtSms = findViewById(R.id.phone_txt);
        txtTitle = findViewById(R.id.txt_elan_title);
        cbDaneshgah = findViewById(R.id.daneshgah_check);
        cbDaneshkadeh = findViewById(R.id.daneshkade_check);
        cbReshteh = findViewById(R.id.reshteh_check);
        cbSms = findViewById(R.id.sms_check);
        cbBlutus = findViewById(R.id.bloutus_check);
        cbEmail = findViewById(R.id.email_check);
        btreset = findViewById(R.id.reset_buttun);
        btsave = findViewById(R.id.save_buttun);
        txtTitle.setText(title);

        switch (title) {
            case "اعلان تجاری": {
                txtTitle.setTextColor(getResources().getColor(R.color.colortejari));
                group = "C";
                break;
            }
            case "اعلان فوری": {
                txtTitle.setTextColor(getResources().getColor(R.color.colorFori));
                group = "A";
                break;
            }
            case "اعلان عادی": {
                txtTitle.setTextColor(getResources().getColor(R.color.coloraddi));
                group = "B";
                break;
            }
            case "اعلان مناسبتی": {
                txtTitle.setTextColor(getResources().getColor(R.color.colormonasebati));
                group = "D";
                break;
            }
        }
        txtGroup.setText(group);
    }


}
