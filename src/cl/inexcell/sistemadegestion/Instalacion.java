package cl.inexcell.sistemadegestion;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Instalacion extends Activity {
	
	private EditText ins_telefono;
    private TextView ins_resultado;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_instalacion);
		
		ins_telefono = (EditText)findViewById(R.id.ins_telefono);
        ins_resultado = (TextView)findViewById(R.id.ins_resultado);
	}
	
	public void desplegar_resultados(View view) {
		String valor1=ins_telefono.getText().toString();
		
		if(valor1.equals("")){
			String resu1 = String.valueOf("Debe ingresar el número del cliente");
			ins_resultado.setText(resu1);
		}
		else
		{
			String resu2 = String.valueOf("Numero de Cliente: "+valor1);
	        ins_resultado.setText(resu2);
		}
    } 
	
	public void desplegar_certificar(View view) {
		String valor1=ins_telefono.getText().toString();
		
		if(valor1.equals("")){
			String resu3 = String.valueOf("Debe ingresar el número del cliente");
			ins_resultado.setText(resu3);
		}
		else
		{
			String resu4 = String.valueOf("Numero de Cliente: "+valor1+". Resultado de la Certificacion");
	        ins_resultado.setText(resu4);
		}
    }
	
	public void volver(View view) {
    	finish();
    	
    	// Vibrar al hacer click        
        Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(50);
    } 

}
