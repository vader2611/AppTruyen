package vn.edu.poly.apptruyen.object;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import vn.edu.poly.apptruyen.R;
import vn.edu.poly.apptruyen.api.ApiLayAnh;
import vn.edu.poly.apptruyen.interfaces.LayAnhVe;

public class DocTruyenActivity extends AppCompatActivity implements LayAnhVe {
    ImageView imgAnh;
    ArrayList<String> arrUrlAnh;
    int soTrang,soTrangDangDoc;
    TextView txvSoTrang;
    String idChap;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_truyen);
        init();
        anhXa();
        setUp();
        setClick();
        new ApiLayAnh(this, idChap).execute();

    }
    private void init(){
        Bundle b = getIntent().getBundleExtra("data");
        idChap= b.getString("idChap");
       /*
        arrUrlAnh= new ArrayList<>();
        arrUrlAnh.add("http://1.bp.blogspot.com/--nCB1SUIoV0/W5JWvVtMASI/AAAAAAAAX_I/fjZmqVVL98U5svhRIFmn84YYXlhdB1UQgCHMYCw/2.jpg?imgmax=0");
        arrUrlAnh.add("http://1.bp.blogspot.com/-WoJQqtbxB-8/W5JWxdiC3ZI/AAAAAAAAX_Q/9-1ajQlEm8kdmf7bQ9WND4xk0MgpkzgcACHMYCw/3.jpg?imgmax=0");
        arrUrlAnh.add("http://1.bp.blogspot.com/-QOiD2oHgH4g/W5JWziz3kyI/AAAAAAAAX_U/qdCbMkqqMzQhy1ZvsNj7m7P7uw6Z2zwxwCHMYCw/4.jpg?imgmax=0");
        arrUrlAnh.add("http://1.bp.blogspot.com/-Kj829WOEv60/W5JW2P-jrcI/AAAAAAAAX_c/Amg1DZC33yg-rqeLMEQMeJfMKMB5kAN1wCHMYCw/5.jpg?imgmax=0");
        arrUrlAnh.add("http://1.bp.blogspot.com/-rsFR-IqqNg8/W5JW4DD6VAI/AAAAAAAAX_g/wsQpksiCnag8_-caz1_CKYgK64TQQU8-QCHMYCw/6.jpg?imgmax=0");
        arrUrlAnh.add("http://1.bp.blogspot.com/-t8ixtpAW0SE/W5JW57-h4JI/AAAAAAAAX_k/WKTY3r4msgIXTTyHgDkxOs1IfX4bhcjIgCHMYCw/7.jpg?imgmax=0");
        arrUrlAnh.add("http://1.bp.blogspot.com/-DiAbVEPig0c/W5JW7alJqUI/AAAAAAAAX_s/RoXRypbB5ykiak0jnFK4rGaFYxaAOEuFACHMYCw/8.jpg?imgmax=0");
        arrUrlAnh.add("http://1.bp.blogspot.com/-75IzWTn91mw/W5JW-g1bA7I/AAAAAAAAX_w/d90GKMylYS0qkJaONnlg9FysyU70R9fVwCHMYCw/9.jpg?imgmax=0");
        arrUrlAnh.add("http://1.bp.blogspot.com/-e8-74qQJ5QY/W5JXAxYpg6I/AAAAAAAAX_4/uU7uFF0HD9g-mVObZdVmMs8DlZv7WptOQCHMYCw/10.jpg?imgmax=0");
        arrUrlAnh.add("http://1.bp.blogspot.com/-vYNMyQlrMdg/W5JXCUOAThI/AAAAAAAAX_8/-or-4p4j4LQoXPMhv56pMrdRLGMtaDecQCHMYCw/11.jpg?imgmax=0");
        arrUrlAnh.add("http://1.bp.blogspot.com/-F19-_OF2qSA/W5JXEEfVhrI/AAAAAAAAYAE/wxKqhj-eRjYzvIfmmW5dC8_cBi_bGTVmwCHMYCw/12.jpg?imgmax=0");
        arrUrlAnh.add("http://1.bp.blogspot.com/-__oM1B76dBU/W5JXGXQZFXI/AAAAAAAAYAI/qOZqrvzkaPYqXqJIWuT4CUhOv5OsbXQ4QCHMYCw/13.jpg?imgmax=0");
        soTrangDangDoc= 1;
        soTrang=arrUrlAnh.size();

        */
    }
    private void anhXa(){
        txvSoTrang= findViewById(R.id.txvSoTrang);
        imgAnh= findViewById(R.id.imgAnh);
    }
    private void setUp(){
        //docTheoTrang(0);

    }
    private void setClick(){

    }
    public void right(View view){
        docTheoTrang(1);

    }
    public void left(View view){
        docTheoTrang(-1);
    }
    private void docTheoTrang(int i){
        soTrangDangDoc= soTrangDangDoc+i;
        if(soTrangDangDoc==0){
            soTrangDangDoc=1;
        }
        if (soTrangDangDoc>soTrang){
            soTrangDangDoc=soTrang;
        }
        txvSoTrang.setText(soTrangDangDoc+" / "+soTrang);
        Glide.with(this).load(arrUrlAnh.get(soTrangDangDoc-1)).into(imgAnh);


    }
    @Override
    public void batDau(){

    }

    @Override
    public void ketThuc(String data) {
        try {
            arrUrlAnh = new ArrayList<>();
            JSONArray array = new JSONArray(data);
            for(int i=0;i<array.length();i++){
                arrUrlAnh.add(array.getString(i));
            }
            soTrangDangDoc = 1;
            soTrang=arrUrlAnh.size();
            docTheoTrang(0);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void biLoi() {

    }
}
