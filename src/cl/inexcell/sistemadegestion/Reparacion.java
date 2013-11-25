package cl.inexcell.sistemadegestion;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Reparacion extends Activity {

	private LinearLayout ll;
	private TextView categoria, nombre, modelo;
	private ImageButton next, prev;
	private Button edit, save;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		// Activity sin parte superior
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_reparacion);
		
		ll = (LinearLayout) findViewById(R.id.info_view);
		categoria = (TextView) findViewById(R.id.category);
		nombre = (TextView) findViewById(R.id.name);
		modelo = (TextView) findViewById(R.id.model);
		next = (ImageButton) findViewById(R.id.next);
		prev = (ImageButton) findViewById(R.id.prev);
		edit = (Button) findViewById(R.id.edit);
		save = (Button) findViewById(R.id.save);
		
		prev.setVisibility(View.INVISIBLE);
		next.setVisibility(View.INVISIBLE);
		edit.setVisibility(View.INVISIBLE);
		save.setVisibility(View.INVISIBLE);
		ll.setVisibility(View.INVISIBLE);	
		
		
				
	}
	
	public void volver(View view) {
    	finish();
    	
    	// Vibrar al hacer click        
        Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(50);
    }
	
	public void guardar(View view) {
		Toast t = Toast.makeText(getApplicationContext(),
                "Información Actualizada Existosamente", Toast.LENGTH_LONG);

		t.show();
    	
    	// Vibrar al hacer click        
        Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(50);
    }
	
	public void buscar_info(View view) {
		prev.setEnabled(false);
		prev.setVisibility(View.VISIBLE);
		next.setVisibility(View.VISIBLE);
		edit.setVisibility(View.VISIBLE);
		save.setVisibility(View.VISIBLE);
		ll.setVisibility(View.VISIBLE);
		Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(50);
		// DO NOTHING
	}
	
	public void siguiente(View view) {
		prev.setEnabled(true);
		next.setEnabled(false);
		
		categoria.setText("Banda Ancha Fija");
		nombre.setText("Equipo Modem");
		modelo.setText("Modelo 411 ZZGT");
		
		Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(50);
		// DO NOTHING
	}
	public void anterior(View view) {
		prev.setEnabled(false);
		next.setEnabled(true);
		
		categoria.setText("Planta Externa");
		nombre.setText("Par Externo");
		modelo.setText("Modelo 001 XTGPP");
		Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(50);
		
		// DO NOTHING
	}

}
