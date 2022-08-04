package ec.com.easyeventsparty.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import ec.com.easyeventsparty.EasyEventPartyApplication;
import ec.com.easyeventsparty.R;
import ec.com.easyeventsparty.entity.GuardarServicioEntity;
import ec.com.easyeventsparty.entity.ResponseEntity;
import ec.com.easyeventsparty.entity.ServicioEntity;
import ec.com.easyeventsparty.entity.ServicioRequest;
import ec.com.easyeventsparty.interfaces.IEventParty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//https://www.develou.com/textinputlayout-en-android-material-design/
public class CrearServicioActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCSGuardar, btnCSCancelar;
    EditText etNombre, etPrecio, etImagen;
    Call<ResponseEntity> callRespGuardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_servicio);
        btnCSGuardar = findViewById(R.id.btnCSGuardar);
        btnCSCancelar = findViewById(R.id.btnCSCancelar);
        btnCSGuardar.setOnClickListener(this);
        btnCSCancelar.setOnClickListener(this);
        etNombre = findViewById(R.id.et_nombre);
        etPrecio = findViewById(R.id.et_precio);
        etImagen = findViewById(R.id.et_imagen);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCSGuardar:
                guardarServicio();
                break;
            case R.id.btnCSCancelar:
                finish();
                break;
        }
    }

    private void guardarServicio() {
        GuardarServicioEntity guardarServicioEntity = new GuardarServicioEntity();
        guardarServicioEntity.setNombre(etNombre.getText().toString());
        guardarServicioEntity.setPrecio(etPrecio.getText().toString());
        guardarServicioEntity.setImagen(etImagen.getText().toString());
        ServicioRequest request = new ServicioRequest();
        request.setOp("guardarServicios");
        request.setData(guardarServicioEntity);
        IEventParty iEventParty = EasyEventPartyApplication.getmInstance().getRestAdapter().create(IEventParty.class);
        callRespGuardar = iEventParty.guardarServicios(request);
        
        callRespGuardar.enqueue(new Callback<ResponseEntity>() {
            @Override
            public void onResponse(Call<ResponseEntity> call, Response<ResponseEntity> response) {
                if (response.isSuccessful()){
                    ResponseEntity respuesta = response.body();
                    mostrarMensaje(respuesta);
                }
            }

            @Override
            public void onFailure(Call<ResponseEntity> call, Throwable t) {
                Log.e("*******", t.getMessage());
            }
        });
    }

    private void mostrarMensaje(ResponseEntity respuesta) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Atención");
        alertDialogBuilder.setMessage(respuesta.getMensaje());
        alertDialogBuilder.create().show();
    }
}