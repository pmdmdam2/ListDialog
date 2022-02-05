package items.dialog.org.listdialog.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import items.dialog.org.listdialog.dialogs.ListDialogFragment;
import items.dialog.org.listdialog.R;
import items.dialog.org.listdialog.interfaces.RespuestaDialogo;

/**
 * Actividad para implementar un cuadro de diálogo con lista simple
 */
public class ListDialogActivity extends AppCompatActivity implements RespuestaDialogo {
    private Button btColor;
    private int color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_dialog);
        final ListDialogFragment ldf = new ListDialogFragment();
        btColor = findViewById(R.id.btColor);
        btColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ldf.show(getSupportFragmentManager(), null);
            }
        });
    }

    /**
     * Método de la interfaz de callback para que el cuadro de diálogo se comunique
     * con la actividad
     * @param color
     */
    @Override
    public void onRespuesta(int color) {
        this.color=color;
        Toast.makeText(this, getString(R.string.color_elegido) + " " +
                        (color==0?getString(R.string.rojo):color==1?getString(R.string.verde):getString(R.string.azul)),
                Toast.LENGTH_LONG).show();
    }
}
