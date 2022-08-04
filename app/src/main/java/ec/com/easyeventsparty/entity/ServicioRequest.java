package ec.com.easyeventsparty.entity;

public class ServicioRequest {
    private String op;
    private GuardarServicioEntity data;

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public GuardarServicioEntity getData() {
        return data;
    }

    public void setData(GuardarServicioEntity data) {
        this.data = data;
    }
}
