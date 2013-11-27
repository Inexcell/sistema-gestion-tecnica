package cl.inexcell.sistemadegestion;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class Notificar_Averias extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		// Activity sin parte superior
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_notificar_averias);
	}
	
	/** Boton Guardar Informaci�n **/
	public void guardarInformacion (View view){
		String text = "Informaci�n guardada con �xito";
		Toast t = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
		t.show();
	}
	
	/** Bot�n C�mara **/
	public void capturarImagen(View view){
		String text = "Captura Almacenada";
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
