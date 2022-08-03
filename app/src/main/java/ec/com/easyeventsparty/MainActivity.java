package ec.com.easyeventsparty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ec.com.easyeventsparty.activity.ListadoItemActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView cvChef;
    CardView cvMusica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cvChef = findViewById(R.id.cv_Chef);
        cvMusica = findViewById(R.id.cv_musica);
        cvChef.setOnClickListener(this);
        cvMusica.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cv_Chef:
                Intent intent = new Intent(this, ListadoItemActivity.class);
                startActivity(intent);
                break;
            case R.id.cv_musica:
                break;
        }
    }
}