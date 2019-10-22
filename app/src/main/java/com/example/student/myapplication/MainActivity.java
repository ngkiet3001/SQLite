package com.example.student.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataSql db=new DataSql(this,"sinhvien.sqlite",null,1);
        db.Add(new SinhVien(1,"Kiet"));
        db.Add(new SinhVien(2,"Vinh"));
        db.Add(new SinhVien(3,"Huy"));

        //db.Update(new SinhVien(1,"Kiet123"));
        //db.Detele(new SinhVien(1,"Kiet"));
        Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();

    }
}
