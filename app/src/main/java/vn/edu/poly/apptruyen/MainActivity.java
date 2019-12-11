package vn.edu.poly.apptruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import vn.edu.poly.apptruyen.adapter.TruyenTranhAdapter;
import vn.edu.poly.apptruyen.api.ApiLayTruyen;
import vn.edu.poly.apptruyen.interfaces.LayTruyenVe;
import vn.edu.poly.apptruyen.object.TruyenTranh;

public class MainActivity extends AppCompatActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread bamgio=new Thread(){
            public void run()
            {
                try {
                    sleep(1500);
                    Intent intent = new Intent(MainActivity.this, ManHinhChuActivity.class);
                    startActivity(intent);
                } catch (Exception e) {

                }

            }
        };
        bamgio.start();
    }

    public void mo(View view) {
        Intent intent = new Intent(this,ManHinhChuActivity.class);
        startActivity(intent);
    }

}
