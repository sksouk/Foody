package foody.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText txtsearch;
    private Button btnsearch;
    private ListView dataView;
    private MySQLConnect mySQLConnect;
    private List<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        update();
    }
    public void update(){
        items = mySQLConnect.getData();
        dataView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));
    }

    public void init() {
        txtsearch = (EditText)findViewById(R.id.txtsearch);
        btnsearch = (Button)findViewById(R.id.btnsearch);
        dataView = (ListView)findViewById(R.id.listquan);
        mySQLConnect = new MySQLConnect(MainActivity.this);
    }
}
