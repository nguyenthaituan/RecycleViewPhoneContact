package vn.edu.ntu.listphone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class edit_inForActivity extends AppCompatActivity {
        TextView tvEditName, tvEditBirth, tvEditPhone, tvEditID,tvEditAddress;
        Button btnAdmit, btnCancel;
        IPhone controller;
        List<Infor> listInfor = new ArrayList<>();
        int postion = -1;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_edit_in_for);

            tvEditName = findViewById(R.id.tv_editName);
            tvEditBirth = findViewById(R.id.tv_editBirth);
            tvEditPhone = findViewById(R.id.tv_editPhone);
            tvEditID = findViewById(R.id.tv_editID);
            tvEditAddress = findViewById(R.id.tv_editAddress);

            btnAdmit = findViewById(R.id.btn_edit);
            btnCancel = findViewById(R.id.btn_editCancel);

            controller = (IPhone) getApplication();
            listInfor = controller.getAProducts();
            Intent intent = getIntent();

            if (intent.getStringExtra("possion") != null)
            {
                postion = Integer.parseInt(intent.getStringExtra("possion"));
                tvEditID.setText(new Integer(postion).toString());
                tvEditName.setText(listInfor.get(postion).getName());
                tvEditBirth.setText(listInfor.get(postion).getBirth());
                tvEditPhone.setText(listInfor.get(postion).getPhoneNumber());
                tvEditAddress.setText(listInfor.get(postion).getAddress());

            }
            else {
                tvEditID.setText(new Integer(listInfor.size()).toString());
            }

            btnAdmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(edit_inForActivity.this, MainActivity.class);

                    if (postion == -1)
                    {
                        Infor infor = new Infor();
                        infor.setName(tvEditName.getText().toString());
                        infor.setBirth(tvEditBirth.getText().toString());
                        infor.setPhoneNumber(tvEditPhone.getText().toString());
                        infor.setAddress(tvEditAddress.getText().toString());
                        listInfor.add(infor);
                        startActivity(intent);
                    }
                    else
                    {
                        Infor infor = new Infor();
                        infor.setName(tvEditName.getText().toString());
                        infor.setBirth(tvEditBirth.getText().toString());
                        infor.setPhoneNumber(tvEditPhone.getText().toString());
                        infor.setAddress(tvEditAddress.getText().toString());
                        listInfor.set(postion,infor);
                        startActivity(intent);
                    }

                }
            });

            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

    }

}
