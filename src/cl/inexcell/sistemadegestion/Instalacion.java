package cl.inexcell.sistemadegestion;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class Instalacion extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_instalacion);
	}
	
	public void cerrar(View view) {
    	finish();
    } 

}
