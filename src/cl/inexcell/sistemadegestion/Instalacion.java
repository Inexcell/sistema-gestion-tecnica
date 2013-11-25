package cl.inexcell.sistemadegestion;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Instalacion extends Activity {
	
	private EditText ins_telefono;
    private TextView ins_resultado;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		// Activity sin parte superior
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_instalacion);
		
		//ins_telefono = (EditText)findViewById(R.id.ins_telefono);
        //ins_resultado = (TextView)findViewById(R.id.ins_resultado);
        
        Button btnBusquedaCliente = (Button) findViewById(R.id.btnBusquedaCliente);
		Button btnPlantaExterna = (Button) findViewById(R.id.btnPlantaExterna);
		Button btnTVSatelital = (Button) findViewById(R.id.btnTVSatelital);
		Button btnBandaAncha = (Button) findViewById(R.id.btnBandaAncha);
		Button btnCertificacion = (Button) findViewById(R.id.btnCertificacion);

		View panelBusquedaCliente = findViewById(R.id.panelBusquedaCliente);
		panelBusquedaCliente.setVisibility(View.VISIBLE);
		//panelBusquedaCliente.setVisibility(View.GONE);

		View panelPlantaExterna = findViewById(R.id.panelPlantaExterna);
		panelPlantaExterna.setVisibility(View.GONE);

		View panelTVSatelital = findViewById(R.id.panelTVSatelital);
		panelTVSatelital.setVisibility(View.GONE);
		
		View panelBandaAncha = findViewById(R.id.panelBandaAncha);
		panelBandaAncha.setVisibility(View.GONE);
		
		View panelCertificacion = findViewById(R.id.panelCertificacion);
		panelCertificacion.setVisibility(View.GONE);

		btnBusquedaCliente.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// DO STUFF
				View panelBusquedaCliente = findViewById(R.id.panelBusquedaCliente);
				panelBusquedaCliente.setVisibility(View.VISIBLE);

				View panelPlantaExterna = findViewById(R.id.panelPlantaExterna);
				panelPlantaExterna.setVisibility(View.GONE);

				View panelTVSatelital = findViewById(R.id.panelTVSatelital);
				panelTVSatelital.setVisibility(View.GONE);
				
				View panelBandaAncha = findViewById(R.id.panelBandaAncha);
				panelBandaAncha.setVisibility(View.GONE);
				
				View panelCertificacion = findViewById(R.id.panelCertificacion);
				panelCertificacion.setVisibility(View.GONE);

			}
		});

		btnPlantaExterna.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// DO STUFF
				View panelBusquedaCliente= findViewById(R.id.panelBusquedaCliente);
				panelBusquedaCliente.setVisibility(View.GONE);

				View panelPlantaExterna = findViewById(R.id.panelPlantaExterna);
				panelPlantaExterna.setVisibility(View.VISIBLE);

				View panelTVSatelital = findViewById(R.id.panelTVSatelital);
				panelTVSatelital.setVisibility(View.GONE);
				
				View panelBandaAncha = findViewById(R.id.panelBandaAncha);
				panelBandaAncha.setVisibility(View.GONE);
				
				View panelCertificacion = findViewById(R.id.panelCertificacion);
				panelCertificacion.setVisibility(View.GONE);

			}
		});

		btnTVSatelital.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// DO STUFF
				View panelBusquedaCliente = findViewById(R.id.panelBusquedaCliente);
				panelBusquedaCliente.setVisibility(View.GONE);

				View panelPlantaExterna = findViewById(R.id.panelPlantaExterna);
				panelPlantaExterna.setVisibility(View.GONE);

				View panelTVSatelital = findViewById(R.id.panelTVSatelital);
				panelTVSatelital.setVisibility(View.VISIBLE);
				
				View panelBandaAncha = findViewById(R.id.panelBandaAncha);
				panelBandaAncha.setVisibility(View.GONE);
				
				View panelCertificacion = findViewById(R.id.panelCertificacion);
				panelCertificacion.setVisibility(View.GONE);

			}
		});
		
		btnBandaAncha.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// DO STUFF
				View panelBusquedaCliente = findViewById(R.id.panelBusquedaCliente);
				panelBusquedaCliente.setVisibility(View.GONE);

				View panelPlantaExterna = findViewById(R.id.panelPlantaExterna);
				panelPlantaExterna.setVisibility(View.GONE);

				View panelTVSatelital = findViewById(R.id.panelTVSatelital);
				panelTVSatelital.setVisibility(View.GONE);
				
				View panelBandaAncha = findViewById(R.id.panelBandaAncha);
				panelBandaAncha.setVisibility(View.VISIBLE);
				
				View panelCertificacion = findViewById(R.id.panelCertificacion);
				panelCertificacion.setVisibility(View.GONE);

			}
		});
		
		btnCertificacion.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// DO STUFF
				View panelBusquedaCliente = findViewById(R.id.panelBusquedaCliente);
				panelBusquedaCliente.setVisibility(View.GONE);

				View panelPlantaExterna = findViewById(R.id.panelPlantaExterna);
				panelPlantaExterna.setVisibility(View.GONE);

				View panelTVSatelital = findViewById(R.id.panelTVSatelital);
				panelTVSatelital.setVisibility(View.GONE);
				
				View panelBandaAncha = findViewById(R.id.panelBandaAncha);
				panelBandaAncha.setVisibility(View.GONE);
				
				View panelCertificacion = findViewById(R.id.panelCertificacion);
				panelCertificacion.setVisibility(View.VISIBLE);

			}
		});
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
