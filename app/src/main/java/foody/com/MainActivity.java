package foody.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText txtadd;
    private Button btnadd;
    private MySQLConnect mySQLConnect;
    private ListView ListQuan;
    private List<String> items;
    private ArrayAdapter<String> adt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        update();

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySQLConnect.sentData(txtadd.getText().toString());
                items.add(txtadd.getText().toString());
                adt.notifyDataSetChanged();
                txtadd.setText("");
            }
        });
    }

    public void update(){
        items = mySQLConnect.getData();
        //ListQuan.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));
        adt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        ListQuan.setAdapter(adt);
    }

    public void init(){
        txtadd = findViewById(R.id.txtadd);
        btnadd = findViewById(R.id.btnadd);
        ListQuan = findViewById(R.id.ListQuan);
        mySQLConnect = new MySQLConnect(MainActivity.this);
    }
}
