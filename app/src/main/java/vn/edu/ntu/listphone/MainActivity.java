package vn.edu.ntu.listphone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvListInfor;
    InforAdapter adapter;
    List<Infor> listInfor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();
    }

    private void addView() {
        rvListInfor = findViewById(R.id.recycleView);
        rvListInfor.setLayoutManager(new LinearLayoutManager(this));
        IPhone phone = (IPhone) getApplication();
        listInfor = phone.getAProducts();
        adapter = new InforAdapter(listInfor);
        rvListInfor.setAdapter(adapter);
    }


    //---------------------------------------------------------------
    private class InforAdapter extends RecyclerView.Adapter<InforViewHolder> {
        List<Infor> listInfor;

        public InforAdapter(List<Infor> listInfor) {
            this.listInfor = listInfor;
        }

        @NonNull
        @Override
        public InforViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.contact_layout, parent, false);
            return new InforViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull InforViewHolder holder, final int position) {
            holder.bind((listInfor).get(position));
            holder.tv_img_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, edit_inForActivity.class);
                    intent.putExtra("possion", new Integer(position).toString());
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return listInfor.size();
        }
    }

    private class InforViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvname, tvbirth, tvphone;
        ImageView tv_img_phone, tv_img_mess, tv_img_edit;


        public InforViewHolder(@NonNull View itemView) {
            super(itemView);
            tvname = this.itemView.findViewById(R.id.tvName);
            tvbirth = this.itemView.findViewById(R.id.tvBirth);
            tvphone = this.itemView.findViewById(R.id.tvPhone);

            tv_img_phone = this.itemView.findViewById(R.id.tvImgPhone);
            tv_img_phone.setOnClickListener(this);

            tv_img_mess = this.itemView.findViewById(R.id.tvImgMess);


            tv_img_edit = this.itemView.findViewById(R.id.tvImgEdit);
            tv_img_edit.setOnClickListener(this);


        }

        public void bind(Infor p) {
            tvname.setText(p.getName());
            tvbirth.setText(p.getBirth());
            tvphone.setText(p.getPhoneNumber());
        }

        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id) {
                case R.id.tvImgEdit:
                    Intent intent = new Intent(MainActivity.this, edit_inForActivity.class);
                    startActivity(intent);
                    break;

                case R.id.tvImgPhone:
                    Intent intentcall = new Intent(Intent.ACTION_CALL);
                    String number = tvphone.getText().toString();
                    if (number.trim().isEmpty()) {

                        Toast.makeText(MainActivity.this, "nhap sdt: ", Toast.LENGTH_SHORT).show();
                    } else {
                        intentcall.setData(Uri.parse("sdt: " + number));
                    }
                    if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                        return;
                    }
                    startActivity(intentcall);
                    break;
            }


            }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mnu_phone,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.Close:
                finish();
            case R.id.itemADD:
                addPhone();
        }
        return super.onOptionsItemSelected(item);

    }

    private void addPhone() {
        Intent intent = new Intent(this,edit_inForActivity.class);
        startActivity(intent);
    }
}
