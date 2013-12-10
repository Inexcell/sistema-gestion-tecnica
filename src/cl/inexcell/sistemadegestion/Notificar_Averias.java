package cl.inexcell.sistemadegestion;

import java.io.File;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class Notificar_Averias extends Activity {
	private static int TAKE_PICTURE = 1;
	private static int SELECT_PICTURE = 2;
	final CharSequence[] opcionCaptura = {
    		"Tomar Fotografía", "Galerría"
    };
	private String name = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		// Activity sin parte superior
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_notificar_averias);
		name = Environment.getExternalStorageDirectory() + "/test.jpg";
	}
	
	/** Boton Guardar Información **/
	public void guardarInformacion (View view){
		String text = "Información guardada con éxito";
		Toast t = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
		t.show();
	}
	
	/** Botón Cámara **/
	public void capturarImagen(View view){
		
		String text = "Captura Almacenada";
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Escoja una Opcion:");
        builder.setIcon(R.drawable.ic_camera);
        builder.setItems(opcionCaptura, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
            	Intent intent =  new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            	int code = TAKE_PICTURE;
            	
            	if (item==TAKE_PICTURE) {
            		
            	    Uri output = Uri.fromFile(new File(name));
            	    intent.putExtra(MediaStore.EXTRA_OUTPUT, output);
            	} else if (item==SELECT_PICTURE){
            	    intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            	    code = SELECT_PICTURE;
            	}
            	startActivityForResult(intent, code);
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
		Toast t = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
		t.show();
	}
	
	/** Boton Volver **/
	public void volver(View view) {
    	finish();
    	
    	// Vibrar al hacer click        
        Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(50);
    }

}
