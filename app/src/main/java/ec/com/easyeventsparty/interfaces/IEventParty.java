package ec.com.easyeventsparty.interfaces;

import java.util.List;

import ec.com.easyeventsparty.entity.ResponseEntity;
import ec.com.easyeventsparty.entity.ServicioEntity;
import ec.com.easyeventsparty.entity.ServicioRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IEventParty {

    @POST("servicios.php")
    Call<List<ServicioEntity>> getServicios(@Body ServicioRequest request);

    @POST("servicios.php")
    Call<ResponseEntity> guardarServicios(@Body ServicioRequest request);
}
