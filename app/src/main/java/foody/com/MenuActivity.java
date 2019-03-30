package foody.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {
    List<menu> lstMenu ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        lstMenu = new ArrayList<>();
        lstMenu.add(new menu("Test menu 1","Categorie","Description menu","25000",R.drawable.img1));
        lstMenu.add(new menu("Test menu 2","Categorie","Description menu","20000",R.drawable.img2));
        lstMenu.add(new menu("Test menu 3","Categorie","Description menu","25000",R.drawable.img3));
        lstMenu.add(new menu("Test menu 4","Categorie","Description menu","25000",R.drawable.img4));
        lstMenu.add(new menu("Test menu 5","Categorie","Description menu","30000",R.drawable.img5));
        lstMenu.add(new menu("Test menu 6","Categorie","Description menu","30000",R.drawable.img6));
        lstMenu.add(new menu("Test menu 7","Categorie","Description menu","30000",R.drawable.img7));
        lstMenu.add(new menu("Test menu 8","Categorie","Description menu","20000",R.drawable.img1));
        lstMenu.add(new menu("Test menu 9","Categorie","Description menu","20000",R.drawable.img2));
        lstMenu.add(new menu("Test menu 10","Categorie","Description menu","25000",R.drawable.img3));
        lstMenu.add(new menu("Test menu 11","Categorie","Description menu","25000",R.drawable.img4));
        lstMenu.add(new menu("Test menu 12","Categorie","Description menu","22000",R.drawable.img5));
        lstMenu.add(new menu("Test menu 13","Categorie","Description menu","20000",R.drawable.img6));
        lstMenu.add(new menu("Test menu 14","Categorie","Description menu","25000",R.drawable.img7));


        RecyclerView myrv = findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstMenu);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);

    }

}
