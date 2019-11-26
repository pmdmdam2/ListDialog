package items.dialog.org.listdialog.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import items.dialog.org.listdialog.R;
import items.dialog.org.listdialog.interfaces.RespuestaDialogo;

/**
 * Fragmento para implementar el cuadro de diálogo
 */
public class ListDialogFragment extends DialogFragment {
    private RespuestaDialogo respuesta;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        respuesta = (RespuestaDialogo)getActivity();
        builder.setTitle(R.string.pick_color)
                .setItems(R.array.colors_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //el parámetro which contiene el índice del elemento seleccionado
                        respuesta.onRespuesta(which);
                    }
                });
        return builder.create();
    }
}
