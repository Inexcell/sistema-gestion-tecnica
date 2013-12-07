package cl.inexcell.sistemadegestion;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Instalacion extends Activity {
	
	private EditText editText;
	private Button b1,b2,b3,b4,b5;
	//private Button mDoneButton;
    //private TextView txtResultado;
    private LinearLayout p1,p2,p3,p4,p5,p6,p7;
    
    final CharSequence[] fabricantes = {
    		"Fabricante 1", "Fabricante 2", "Fabricante 3", 
            "Fabricante 4", "Fabricante 5", "Fabricante 6"
    };
    
    final CharSequence[] plantas_ext = {
    		"Planta 1", "Planta 2", "Planta 3", 
            "Planta 4", "Planta 5", "Planta 6"
    };
    
    final CharSequence[] equipos = {
    		"Equipo 1", "Equipo 2", "Equipo 3", 
            "Equipo 4", "Equipo 5", "Equipo 6"
    };
    
    final CharSequence[] opc_planta = {
    		"Georefenciar", "Editar", "Tomar Fotografía" 
    };
    
    final CharSequence[] par_externo = {
    		"Par Externo 1", "Par Externo 2", "Par Externo 3",
    		"Par Externo 4", "Par Externo 5", "Par Externo 6"
    };
    
    final CharSequence[] caja_terminal = {
    		"Caja Terminal 1", "Caja Terminal 2", "Caja Terminal 3",
    		"Caja Terminal 4", "Caja Terminal 5", "Caja Terminal 6"
    };
    
    final CharSequence[] armario = {
    		"Armario 1", "Armario 2", "Armario 3",
    		"Armario 4", "Armario 5", "Armario 6"
    };
    
    final CharSequence[] par_local = {
    		"Par Local 1", "Par Local 2", "Par Local 3",
    		"Par Local 4", "Par Local 5", "Par Local 6"
    };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		// Activity sin parte superior
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_instalacion);
		
		// Keyboard Focusable
		final EditText editText = (EditText) findViewById(R.id.txtTelefonoArea);
		final EditText editText1 = (EditText) findViewById(R.id.txtTelefonoNumero);
		
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
		
		editText.setOnKeyListener(new View.OnKeyListener() {
	        @Override
	        public boolean onKey(View view, int i, KeyEvent keyEvent) {
	            if (keyEvent.getAction() == KeyEvent.ACTION_UP) {
	                if (editText.getText().length() == 2) {
	                    editText1.requestFocus();
	                }
	            }
	            return false;
	        }
	    });
		
		
		// Seleccionar objetos de Botones en Layout
		b1 = (Button) findViewById(R.id.btnBusquedaCliente);
		b2 = (Button) findViewById(R.id.btnPlantaExterna);
		b3 = (Button) findViewById(R.id.btnTVSatelital);
		b4 = (Button) findViewById(R.id.btnBandaAncha);
		b5 = (Button) findViewById(R.id.btnCertificacion);
		
		// Seleccionar objetos de LinearLayout
		p1 = (LinearLayout) findViewById(R.id.panelBusquedaCliente);
		p2 = (LinearLayout) findViewById(R.id.panelPlantaExterna);
		p3 = (LinearLayout) findViewById(R.id.panelTVSatelital);
		p4 = (LinearLayout) findViewById(R.id.panelBandaAncha);
		p5 = (LinearLayout) findViewById(R.id.panelCertificacion);
		
		
		p6 = (LinearLayout) findViewById(R.id.panelCertificacion2);
		
		// Definir visibilidad de objetos Buttons
		b1.setVisibility(View.VISIBLE);
		b2.setVisibility(View.INVISIBLE);
		b3.setVisibility(View.INVISIBLE);
		b4.setVisibility(View.INVISIBLE);
		b5.setVisibility(View.INVISIBLE);
		
		// Definir visibilidad de objetos LinearLayout
		p1.setVisibility(View.VISIBLE);
		p2.setVisibility(View.INVISIBLE);
		p3.setVisibility(View.INVISIBLE);
		p4.setVisibility(View.INVISIBLE);
		p5.setVisibility(View.INVISIBLE);
		p6.setVisibility(View.INVISIBLE);
		
	}
	
	public void buscar_cliente(View view){
		
		editText = (EditText) findViewById(R.id.txtTelefonoArea);
		
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
		
		
		Button btnBusquedaCliente = (Button) findViewById(R.id.btnBusquedaCliente);
		Button btnPlantaExterna = (Button) findViewById(R.id.btnPlantaExterna);
		Button btnTVSatelital = (Button) findViewById(R.id.btnTVSatelital);
		Button btnBandaAncha = (Button) findViewById(R.id.btnBandaAncha);
		Button btnCertificacion = (Button) findViewById(R.id.btnCertificacion);
		
		// Seleccionar objetos de Botones en Layout
		btnBusquedaCliente.setVisibility(View.VISIBLE);
		btnPlantaExterna.setVisibility(View.VISIBLE);
		btnTVSatelital.setVisibility(View.VISIBLE);
		btnBandaAncha.setVisibility(View.VISIBLE);
		btnCertificacion.setVisibility(View.VISIBLE);

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
	
	public void certificar1(View view){
		
		p6 = (LinearLayout) findViewById(R.id.panelCertificacion2);
		p7 = (LinearLayout) findViewById(R.id.panelCertificacion1);
		
		// Definir visibilidad de objetos Buttons
		p6.setVisibility(View.VISIBLE);
		p7.setVisibility(View.INVISIBLE);
		
	}
	
	public void mostrar_planta(final View view){
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleccione Fabricante");
        builder.setIcon(R.drawable.ic_fabricante);
        builder.setItems(fabricantes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                // Do something with the selection
                //mDoneButton.setText(fabricantes[item]);
            	Toast.makeText(Instalacion.this, fabricantes[item]+" seleccionado", Toast.LENGTH_SHORT).show();
            	mostrar_equipos(view);
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
	}
	
	public void mostrar_equipos(View view){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleccione Equipo");
        builder.setIcon(R.drawable.ic_equipo);
        builder.setItems(equipos, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                // Do something with the selection
                //mDoneButton.setText(fabricantes[item]);
            	Toast.makeText(Instalacion.this, equipos[item]+" seleccionado", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
	}
	
	public void mostrar_armario1(final View view){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleccione Opción");
        builder.setIcon(R.drawable.ic_planta);
        builder.setItems(opc_planta, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                // Do something with the selection
                //mDoneButton.setText(fabricantes[item]);
            	if(opc_planta[item] == "Editar"){
            		mostrar_armario(view);
            	}
            	else{
            		
            	}
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
	}
	
	public void mostrar_planta2(View view){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleccione Planta Externa");
        builder.setIcon(R.drawable.ic_planta_ext);
        builder.setItems(plantas_ext, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                // Do something with the selection
                //mDoneButton.setText(fabricantes[item]);
            	Toast.makeText(Instalacion.this, plantas_ext[item]+" seleccionada", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
	}
	
	public void mostrar_cajaterminal(final View view){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleccione Opción");
        builder.setIcon(R.drawable.ic_planta);
        builder.setItems(opc_planta, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                // Do something with the selection
                //mDoneButton.setText(fabricantes[item]);
            	if(opc_planta[item] == "Editar"){
            		mostrar_cajaterminal1(view);
            	}
            	else{
            		
            	}
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
	}
	
	public void mostrar_cajaterminal1(View view){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleccione Caja Terminal");
        builder.setIcon(R.drawable.ic_cajaterminal);
        builder.setItems(caja_terminal, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                // Do something with the selection
                //mDoneButton.setText(fabricantes[item]);
            	Toast.makeText(Instalacion.this, caja_terminal[item]+" seleccionado", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
	}
	
	public void mostrar_parexterno(View view){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleccione Par Externo");
        builder.setIcon(R.drawable.ic_parexterno);
        builder.setItems(par_externo, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                // Do something with the selection
                //mDoneButton.setText(fabricantes[item]);
            	Toast.makeText(Instalacion.this, par_externo[item]+" seleccionado", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
	}
	
	public void mostrar_armario(View view){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleccione Armario");
        builder.setIcon(R.drawable.ic_armario);
        builder.setItems(armario, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                // Do something with the selection
                //mDoneButton.setText(fabricantes[item]);
            	Toast.makeText(Instalacion.this, armario[item]+" seleccionado", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
	}
	
	public void mostrar_parlocal(View view){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleccione Par Local");
        builder.setIcon(R.drawable.ic_parlocal);
        builder.setItems(par_local, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                // Do something with the selection
                //mDoneButton.setText(fabricantes[item]);
            	Toast.makeText(Instalacion.this, par_local[item]+" seleccionado", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
	}
	
	public void fin_certificar(View view){
		Toast.makeText(this, "Certificación realizada exitosamente", Toast.LENGTH_SHORT).show();
		
		finish();
	}
	
	public void volver(View view) {
    	finish();
    	
    	// Vibrar al hacer click        
        Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(50);
    } 

}
