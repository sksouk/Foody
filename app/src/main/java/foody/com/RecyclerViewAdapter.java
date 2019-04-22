package foody.com;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context mContext ;
    private List<menu> mData ;
    private AdapterView.OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);

    }
    RequestQueue requestQueue;

    ProgressDialog progressDialog;

    // Storing server url into String variable.
    String HttpUrl = "http://hoctiengviet.net/food_order/Get_Order.php";

    public RecyclerViewAdapter(Context mContext, List<menu> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }
    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        mListener = listener;
    }
    public RecyclerViewAdapter(ArrayList<menu> exampleList) {
        mData = exampleList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_food,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,final int position) {
        holder.tv_menu_name.setText(mData.get(position).getMenu_name());
        holder.img_menu_thumbnail.setImageResource(mData.get(position).getThumbnail());
        holder.gia_menu.setText(mData.get(position).getGia());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_menu_name;
        ImageView img_menu_thumbnail;
        TextView gia_menu;
        Button btncong;
        Button btntru;
        TextView slmenu;
        Button addcart;


        public MyViewHolder(View itemView) {
            super(itemView);

            tv_menu_name = (TextView) itemView.findViewById(R.id.menu_name_id);
            img_menu_thumbnail = (ImageView) itemView.findViewById(R.id.menu_image_id);
            gia_menu = (TextView) itemView.findViewById(R.id.menu_gia_id);

            btncong = (Button) itemView.findViewById(R.id.btn_congmenu);
            btntru = (Button) itemView.findViewById(R.id.btn_trumenu);
            slmenu = (TextView) itemView.findViewById(R.id.txt_slmenu);
            addcart = (Button) itemView.findViewById(R.id.btn_addcart);

            btncong.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int intsoluong = Integer.parseInt(slmenu.getText().toString()) + 1;
                    String strsoluong = String.valueOf(intsoluong);
                    slmenu.setText(strsoluong);
                }
            });
            btntru.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int soluongmenu = Integer.parseInt(slmenu.getText().toString());
                    if (soluongmenu < 2) {
                        slmenu.setText("1");
                    }else {
                        int intsoluong = soluongmenu - 1;
                        String strsoluong = String.valueOf(intsoluong);
                        slmenu.setText(strsoluong);
                    }
                }
            });

            addcart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (addcart.getText() == "✓"){
                        addcart.setText("ADD");
                    }else{

                        addcart.setText(tv_menu_name.getText());

                    }
                }
            });
        }

    }
}
