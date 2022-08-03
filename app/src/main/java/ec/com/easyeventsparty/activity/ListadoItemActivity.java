package ec.com.easyeventsparty.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import ec.com.easyeventsparty.R;
import ec.com.easyeventsparty.adapter.ItemAdapter;

public class ListadoItemActivity extends AppCompatActivity {

    RecyclerView rvItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_item);
        rvItem = findViewById(R.id.rv_Item);
        llenarListado();
    }

    private void llenarListado() {
        List<String> pepito = new ArrayList<String>();
        pepito.add("Mouse1");
        pepito.add("Mouse1");
        pepito.add("Mouse1");
        pepito.add("Mouse1");
        pepito.add("Mouse1");
        pepito.add("Mouse1");
        pepito.add("Mouse1");
        pepito.add("Mouse1");
        pepito.add("Mouse1");
        pepito.add("Mouse1");
        pepito.add("Mouse1");
        ItemAdapter itemAdapter = new ItemAdapter(pepito, this);
        rvItem.setHasFixedSize(true);
        rvItem.setAdapter(itemAdapter);
    }
}