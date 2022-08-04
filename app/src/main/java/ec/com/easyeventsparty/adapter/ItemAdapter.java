package ec.com.easyeventsparty.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ec.com.easyeventsparty.R;
import ec.com.easyeventsparty.entity.ServicioEntity;
import ec.com.easyeventsparty.utils.Utils;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{
    private List<ServicioEntity> lstItems;
    private Context _ctx;

    public ItemAdapter(List<ServicioEntity> lstItems, Context _ctx) {
        this.lstItems = lstItems;
        this._ctx = _ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.items_app, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ServicioEntity servicioEntity = lstItems.get(position);
        holder.tvNombreCocinero.setText(servicioEntity.getNombre());
        Utils.loadImage(servicioEntity.getImagen(), holder.ivImagenCocinero);
    }

    @Override
    public int getItemCount() {
        return lstItems.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivImagenCocinero;
        private TextView tvNombreCocinero;

        public ViewHolder(View itemView){
            super(itemView);
            this.ivImagenCocinero = (ImageView) itemView.findViewById(R.id.iv_ImagenCocinero);
            this.tvNombreCocinero = (TextView) itemView.findViewById(R.id.tv_NombreCocinero);
        }
    }
}
