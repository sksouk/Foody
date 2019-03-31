package foody.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Order extends AppCompatActivity {
    List<order_class> lstMenu ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        lstMenu = new ArrayList<>();
        lstMenu.add(new order_class("Test menu 1","Categorie","Description menu","25000",R.drawable.img1));
        lstMenu.add(new order_class("Test menu 2","Categorie","Description menu","20000",R.drawable.img2));
        lstMenu.add(new order_class("Test menu 3","Categorie","Description menu","25000",R.drawable.img3));
        lstMenu.add(new order_class("Test menu 4","Categorie","Description menu","25000",R.drawable.img4));

        RecyclerView myrv_order = findViewById(R.id.listOrder);
        RecyclerViewAdapterMenu myAdapter = new RecyclerViewAdapterMenu(this,lstMenu);
        myrv_order.setLayoutManager(new GridLayoutManager(this,1));
        myrv_order.setAdapter(myAdapter);

        ImageButton btnbye;
        final EditText phong;
        btnbye = findViewById(R.id.btn_dat);
        phong = findViewById(R.id.editphong);

        btnbye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(phong.getText() != null ){
                    Toast.makeText(Order.this,"Complete",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Order.this,"Please!! Nhập Phòng!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
