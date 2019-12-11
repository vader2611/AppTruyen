package vn.edu.poly.apptruyen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.apptruyen.R;
import vn.edu.poly.apptruyen.object.TruyenTranh;

public class TruyenTranhAdapter extends ArrayAdapter<TruyenTranh> {
    private Context ct;
    private ArrayList<TruyenTranh> arr;

    public TruyenTranhAdapter(Context context, int resource, List<TruyenTranh> objects) {
        super(context, resource, objects);
        this.ct = context;
        this.arr = new ArrayList<>(objects);
    }

public  void sortTruyen(String s){
        s= s.toUpperCase();
        int k=0;
        for (int i=0;i<arr.size() ;i++){
            TruyenTranh t = arr.get(i);
            String ten= t.getTenTruyen().toUpperCase();
            if (ten.indexOf(s)>=0){
                arr.set(i,arr.get(k));//đổi vị trí truyện
                arr.set(k,t);
                k++;
            }
        }
        notifyDataSetChanged();
}
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_truyen, null);
        }
        if (arr.size() > 0) {
            TruyenTranh truyenTranh = this.arr.get(position);
            TextView tenTenTruyen = convertView.findViewById(R.id.txvTenTruyen);
            TextView tenTenChap = convertView.findViewById(R.id.txvTenChap);
            ImageView imgAnhtruyen= convertView.findViewById(R.id.imgAnhTruyen);

            tenTenTruyen.setText(truyenTranh.getTenTruyen());
            tenTenChap.setText(truyenTranh.getTenChap());
            Glide.with(this.ct).load(truyenTranh.getLinkAnh()).into(imgAnhtruyen);
        }
return convertView;
    }
}

