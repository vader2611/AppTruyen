package vn.edu.poly.apptruyen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
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
    ProgressBar progressBar;
    TextView textView;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        progressBar =findViewById(R.id.progress_bar);
        textView= findViewById(R.id.text_view);

        progressBar.setMax(100);
        progressBar.setScaleY(3f);

        progressAnimation();


    }





    public  void progressAnimation(){
        ProgressBarAnimation amin= new ProgressBarAnimation(this,progressBar,textView,0f,100f);
        amin.setDuration(8000);
        progressBar.setAnimation(amin);
    }

}
