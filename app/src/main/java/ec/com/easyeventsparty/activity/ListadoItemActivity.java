package ec.com.easyeventsparty.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import ec.com.easyeventsparty.EasyEventPartyApplication;
import ec.com.easyeventsparty.R;
import ec.com.easyeventsparty.adapter.ItemAdapter;
import ec.com.easyeventsparty.entity.ServicioEntity;
import ec.com.easyeventsparty.entity.ServicioRequest;
import ec.com.easyeventsparty.interfaces.IEventParty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListadoItemActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView rvItem;
    Call<List<ServicioEntity>> callLstServicios;
    Button btnCrearServicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_item);
        rvItem = findViewById(R.id.rv_Item);
        btnCrearServicio = findViewById(R.id.btn_crear_servicio);
        btnCrearServicio.setOnClickListener(this);
        llamarAlWs();
    }

    private void llamarAlWs() {
        IEventParty iEventParty = EasyEventPartyApplication.getmInstance().getRestAdapter().create(IEventParty.class);
        ServicioRequest request = new ServicioRequest();
        request.setOp("obtenerServicios");
        callLstServicios = iEventParty.getServicios(request);

        callLstServicios.enqueue(new Callback<List<ServicioEntity>>() {
            @Override
            public void onResponse(Call<List<ServicioEntity>> call, Response<List<ServicioEntity>> response) {
                if (response.isSuccessful()){
                    List<ServicioEntity> lstServicio = response.body();
                    llenarListado(lstServicio);
                }
            }

            @Override
            public void onFailure(Call<List<ServicioEntity>> call, Throwable t) {
                Log.e(" >>>>>>> ", t.getMessage());
            }
        });
    }

    private void llenarListado(List<ServicioEntity> lstServicio) {
        ItemAdapter itemAdapter = new ItemAdapter(lstServicio, this);
        rvItem.setHasFixedSize(true);
        rvItem.setAdapter(itemAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_crear_servicio:
                Intent intent = new Intent(this, CrearServicioActivity.class);
                startActivity(intent);
                break;
        }
    }
}