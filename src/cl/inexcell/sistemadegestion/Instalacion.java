package cl.inexcell.sistemadegestion;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Vibrator;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


public class Instalacion extends Activity {
	
	private EditText Area, Phone;
	
	private TextView tipoPlanta, parExterno,tvArmario, 
	tipoTerminal, tipoParLocal, tvSatelitalModelo, tvSatelitalTipo,
	bandaAnchaTipo, bandaAnchaModelo;
	
	// Certificacion
	private TextView tup,tdown,nom_wifi,num_tel;
	
	public static final int DIALOG_DOWNLOAD_PROGRESS = 0;
	public static final int DIALOG_DOWNLOAD_PROGRESS1 = 1;
    private ProgressDialog mProgressDialog, mProgressDialog1;
    
    // Botones Layout
		
	private Button b1,b2,b3,b4,b5,buscar;
	
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

    // Consulta Cliente
	private String area1;
	private String phone1;


	private TableRow p8_0;
	private TableRow p8_1;
	private TableRow p8_2;

	private TableRow p9_0;

	private TableRow p9_1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Activity sin parte superior
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_instalacion);
		
		// Keyboard Focusable
		Area = (EditText) findViewById(R.id.txtTelefonoArea);
		Phone = (EditText) findViewById(R.id.txtTelefonoNumero);
		buscar = (Button) findViewById(R.id.ButtonBuscar);
		
		setupInicial();
		
				
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
		
		///////////////////////////////////////////////
		
		Area.setOnKeyListener(new View.OnKeyListener() {
	        @Override
	        public boolean onKey(View view, int i, KeyEvent keyEvent) {
	            if (keyEvent.getAction() == KeyEvent.ACTION_UP) {
	                if (Area.getText().length() == 2) {
	                    Phone.requestFocus();
	                }
	            }
	            return false;
	        }
	    });
		
		Phone.setOnKeyListener(new View.OnKeyListener()
		    {
				public boolean onKey(View v, int keyCode, KeyEvent event)
		        {
		 
		        // Comprobamos que se ha pulsado la tecla enter.
		        if ((event.getAction() == KeyEvent.ACTION_DOWN) &&(keyCode == KeyEvent.KEYCODE_ENTER))
		        {
	        		buscar.performClick();
	        		//Toast.makeText(getApplicationContext(), "Consulta exitosa", Toast.LENGTH_LONG).show();
	        		return true;
		        }
		 
		        return false;
			}
		});
		
		
			
		
				
	}
	
	/*
	 * Valores iniciales al iniciar el Activity
	 */
	
	public void setupInicial(){
				// Text Views en los que se muestra informacion
				//// Seccion PLANTA EXTERNA
				tipoPlanta = (TextView) findViewById(R.id.TipoPlanta);
				parExterno = (TextView) findViewById(R.id.TipoParExterno);
				tvArmario = (TextView) findViewById(R.id.TipoArmario);
				tipoTerminal = (TextView) findViewById(R.id.TipoTerminal);
				tipoParLocal = (TextView) findViewById(R.id.TipoParLocal);
				
				// Seccion TV Satelital
				tvSatelitalTipo = (TextView) findViewById(R.id.tvSatelitalTipo);
				tvSatelitalModelo = (TextView) findViewById(R.id.tvSatelitalModelo);
				
				// Seccion Banda Ancha
				bandaAnchaTipo = (TextView) findViewById(R.id.bandaAnchaTipo);
				bandaAnchaModelo = (TextView) findViewById(R.id.bandaAnchaModelo);
				
				// Seccion Certificacion
				
				
				
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
	
	/*
	 * Funcion de boton buscar cliente
	 */
	
	public void buscar_cliente(final View view) throws Exception
	{
		
		Area = (EditText) findViewById(R.id.txtTelefonoArea);
		area1 = Area.getText().toString();
				
		Phone = (EditText) findViewById(R.id.txtTelefonoNumero);
		phone1 = Phone.getText().toString(); 		
		
		Consulta_Cliente tarea = new Consulta_Cliente();
		
		if((area1.matches("") && phone1.matches("")) || area1.matches("") || phone1.matches(""))
		{
			//Toast.makeText(getApplicationContext(), "Ingrese Area y Número de Telefono por favor.", Toast.LENGTH_LONG).show();
			new AlertDialog.Builder(this)
		    .setTitle("Error Consulta Cliente")
		    .setIcon(R.drawable.ic_warning1)
		    .setMessage("Ingrese Número de Area y Teléfono por favor.")
		    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // continue with delete
		        }
		     })
		     .show();
			
		}
		//XMLParser.getReturnCode(tarea.get().toString()) == "[1]"
		else if(tarea.execute() != null)
		{
			InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(Area.getWindowToken(), 0);
			
			// TODO: Realizar validacion Cliente 
			//Toast.makeText(getApplicationContext(), XMLParser.getReturnCode(tarea.get().toString()), Toast.LENGTH_LONG).show();
			
			
			// Seleccionar objetos de Botones en Layout
			b1.setVisibility(View.VISIBLE);
			b2.setVisibility(View.VISIBLE);
			b3.setVisibility(View.VISIBLE);
			b4.setVisibility(View.VISIBLE);
			b5.setVisibility(View.VISIBLE);
			
			// Animacion
			
			b2.setAnimation(AnimationUtils.loadAnimation(view.getContext(), R.anim.accelerate));
			b3.setAnimation(AnimationUtils.loadAnimation(view.getContext(), R.anim.accelerate));
			b4.setAnimation(AnimationUtils.loadAnimation(view.getContext(), R.anim.accelerate));
			b5.setAnimation(AnimationUtils.loadAnimation(view.getContext(), R.anim.accelerate));
			
			///////////////////////////////////////////////////////////////////////////////////
	
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
			
	
			/** Boton busqueda cliente **/
			b1.setOnClickListener(new OnClickListener() {
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
	
			/** Boton planta externa **/
			b2.setOnClickListener(new OnClickListener() {
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
	
			/** Boton TV satelital **/
			b3.setOnClickListener(new OnClickListener() {
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
			
			/** Boton banda ancha **/
			b4.setOnClickListener(new OnClickListener() {
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
			
			/** Boton Certificar **/
			b5.setOnClickListener(new OnClickListener() {
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
	}
	
	
	public void certificar1(View view){
		
		try
   		{
			p7 = (LinearLayout) findViewById(R.id.panelCertificacion1);
   			p7.setVisibility(View.GONE);
   			
   			// Definir visibilidad de objetos Buttons
   			p6 = (LinearLayout) findViewById(R.id.panelCertificacion2);
   			p6.setAnimation(AnimationUtils.loadAnimation(view.getContext(), R.anim.accelerate1));
   			p6.setVisibility(View.VISIBLE);
   			
   			p8_0 = (TableRow) findViewById(R.id.Cert0);
   			p8_1 = (TableRow) findViewById(R.id.Cert1);
   			p8_2 = (TableRow) findViewById(R.id.Cert2);
   			
   			p9_0 = (TableRow) findViewById(R.id.Cert3_0);
   			p9_1 = (TableRow) findViewById(R.id.Cert3_1);
   			
   			p8_1.setVisibility(View.GONE);
			p8_2.setVisibility(View.GONE);
   			
   			p8_0.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					
					if(p8_1.getVisibility()== View.VISIBLE && p8_2.getVisibility()== View.VISIBLE)
					{
						p8_1.setVisibility(View.GONE);
						p8_2.setVisibility(View.GONE);
					}
					else
					{
						p8_1.setVisibility(View.VISIBLE);
						p8_2.setVisibility(View.VISIBLE);
					}
				}
   			});
   			
   			p9_1.setVisibility(View.GONE);
   			p9_0.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					
					if(p9_1.getVisibility()== View.VISIBLE)
					{
						p9_1.setVisibility(View.GONE);
					}
					else
					{
						p9_1.setVisibility(View.VISIBLE);
					}
				}
   			});

			tdown = (TextView)findViewById(R.id.tBajada);
			tup = (TextView)findViewById(R.id.tSubida);
			
			Area = (EditText) findViewById(R.id.txtTelefonoArea);
			Phone = (EditText) findViewById(R.id.txtTelefonoNumero);		
			
			nom_wifi = (TextView) findViewById(R.id.NombreWifi);
			num_tel = (TextView) findViewById(R.id.NroTelefono);
	
			// Definir visibilidad de objetos Buttons
			p6.setAnimation(AnimationUtils.loadAnimation(view.getContext(), R.anim.accelerate1));
			p6 = (LinearLayout) findViewById(R.id.panelCertificacion2);
			p7 = (LinearLayout) findViewById(R.id.panelCertificacion1);
	
			p6.setVisibility(View.VISIBLE);
			p7.setVisibility(View.INVISIBLE);
			
			startDownload();
       		muestra_descarga(0);
       		
       		startUpload();
       		muestra_carga(0);
			
			WifiManager wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
			WifiInfo wifiInfo = wifiManager.getConnectionInfo();
			
			
			// Nombre Wifi
			if(wifiInfo.getSSID() == "<unknown ssid>"){
				nom_wifi.setText("");
			}
			else
			{
				nom_wifi.setText(wifiInfo.getSSID());
			}
			
			// Numero Telefono
			num_tel.setText("("+Area.getText().toString()+") "+Phone.getText().toString());
		
   		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	public void mostrar_planta_tvsatelital(final View view){
		
		Consulta_Fab_TVSatelital tarea = new Consulta_Fab_TVSatelital();
		tarea.execute();

	}
	
	public void mostrar_planta_bandaancha(final View view){
		
		Consulta_Fab_BandaAncha tarea = new Consulta_Fab_BandaAncha();
		tarea.execute();
	}
	
	public void mostrar_equipos_bandaancha(View view){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
	    builder.setTitle("Seleccione Equipo");
	    builder.setIcon(R.drawable.ic_equipo);
	    builder.setItems(equipos, new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int item) {
	            // Do something with the selection
	            //mDoneButton.setText(fabricantes[item]);
	        	bandaAnchaModelo.setText(equipos[item]);
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
	
	/** Boton para cambiar la planta en seccion PLANTA EXTERNA **/
	public void mostrar_planta2(View view){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
	    builder.setTitle("Seleccione Planta Externa");
	    builder.setIcon(R.drawable.ic_planta_ext);
	    builder.setItems(plantas_ext, new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int item) {
	            // Do something with the selection
	            //mDoneButton.setText(fabricantes[item]);
	        	Toast.makeText(Instalacion.this, "Planta Actualizada", Toast.LENGTH_SHORT).show();
	        	tipoPlanta.setText(plantas_ext[item]);
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
	        	Toast.makeText(Instalacion.this, "Caja Terminal Actualizado", Toast.LENGTH_SHORT).show();
	        	tipoTerminal.setText(caja_terminal[item].subSequence(5, caja_terminal[item].length()));
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
	        	Toast.makeText(Instalacion.this, "Par Externo Actualizado", Toast.LENGTH_SHORT).show();
	        	parExterno.setText(par_externo[item].subSequence(4, par_externo[item].length()));
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
	        	Toast.makeText(Instalacion.this, "Armario Actualizado", Toast.LENGTH_SHORT).show();
	        	tvArmario.setText(armario[item]);
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
	        	tipoParLocal.setText(par_local[item]);
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
	
	/*
	 * Clases Asincronas de Certificacion, importadas de Certificar_Wifi.java
	 */
	
	// Clase Asincrona para descargar archivo    
    private void startDownload() {
        String url = "http://alumnos.inf.utfsm.cl/~abastias/upload/upload/test.jpg";
        new DownloadFileAsync().execute(url);
    }
    
    // Clase Asincrona para subir archivo
    @SuppressLint("SdCardPath")
	private void startUpload() {
    	String archivo_seleccionado = "/sdcard/test.jpg";
    	new UploadFileTask(Instalacion.this).execute(archivo_seleccionado);
    }


	@SuppressLint("SdCardPath")
	class DownloadFileAsync extends AsyncTask<String, String, String> 
	{

        @SuppressWarnings("deprecation")
		@Override
        protected void onPreExecute() {
            super.onPreExecute();
            showDialog(DIALOG_DOWNLOAD_PROGRESS);
        }

        @Override
        protected String doInBackground(String... aurl) {
            int count;

        try {

	        URL url = new URL(aurl[0]);
	        URLConnection conexion = url.openConnection();
	        conexion.connect();
	
	        int lenghtOfFile = conexion.getContentLength();
	        Log.d("ANDRO_ASYNC", "Largo del archivo: " + lenghtOfFile);
	
	        InputStream input = new BufferedInputStream(url.openStream());
	        OutputStream output = new FileOutputStream("/sdcard/test.jpg");
	
	        byte data[] = new byte[1024];
	
	        long total = 0;
        
        	long tiempoInicio_down = System.currentTimeMillis();
        
            while ((count = input.read(data)) != -1) {
                total += count;
                publishProgress(""+(int)((total*100)/lenghtOfFile));
                output.write(data, 0, count);
            }
            
            long tiempoFin_down = System.currentTimeMillis();
            long tiempo_down = tiempoFin_down - tiempoInicio_down; 
            
            muestra_descarga(tiempo_down);

            output.flush();
            output.close();
            input.close();
        } catch (Exception e) {}
        return null;

        }
        

		protected void onProgressUpdate(String... progress) {
             Log.d("ANDRO_ASYNC",progress[0]);
             mProgressDialog.setProgress(Integer.parseInt(progress[0]));
        }

        @SuppressWarnings("deprecation")
		@Override
        protected void onPostExecute(String unused) {
            dismissDialog(DIALOG_DOWNLOAD_PROGRESS);
        }
    }
    
	
	//http://stackoverflow.com/questions/2017414/post-multipart-request-with-android-sdk
	class UploadFileTask extends AsyncTask<String,String,String> {
	
		private Activity activity;
		
		public UploadFileTask(Activity activity){
			this.activity = activity;
		}
		
		@SuppressWarnings("deprecation")
		protected void onPreExecute() {
            super.onPreExecute();
            showDialog(DIALOG_DOWNLOAD_PROGRESS1);
        }
		
	    protected String doInBackground(String... path) {
            
	    	String outPut = null;
	    	long tiempo_up = 0, tiempoInicio_up,tiempoFin_up;
	    	
	    	try {
	    		
	    		for (String sdPath : path) {
		    		Bitmap bitmapOrg = BitmapFactory.decodeFile(sdPath);
	                ByteArrayOutputStream bao = new ByteArrayOutputStream();
	                 
	                //Resize the image
	                double width = bitmapOrg.getWidth();
	                double height = bitmapOrg.getHeight();
	                double ratio = 400/width;
	                int newheight = (int)(ratio*height);
	                 
	                System.out.println("———-width" + width);
	                System.out.println("———-height" + height);
	                 
	                bitmapOrg = Bitmap.createScaledBitmap(bitmapOrg, 400, newheight, true);
	                 
	                //Here you can define .PNG as well
	                bitmapOrg.compress(Bitmap.CompressFormat.JPEG, 95, bao);
	                byte[] ba = bao.toByteArray();
	                String ba1 = Base64.encodeToString(ba, TRIM_MEMORY_COMPLETE);
	                 
	                System.out.println("uploading image now ——–" + ba1);
		    		
		    		
		    		
		    		tiempoInicio_up = System.currentTimeMillis();
		    		
		    		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	                //nameValuePairs.add(new BasicNameValuePair("image", path[0]));
		    		nameValuePairs.add(new BasicNameValuePair("image", ba1));
			    	
		    		HttpClient httpclient = new DefaultHttpClient();
	                HttpPost httppost = new HttpPost("http://alumnos.inf.utfsm.cl/~abastias/upload/upload1.php");
	                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	                 
	                HttpResponse response = httpclient.execute(httppost);
	                HttpEntity entity = response.getEntity();                
	
	                // print responce
	                outPut = EntityUtils.toString(entity);
	                Log.i("GET RESPONSE—-", outPut);
	                 
	                //is = entity.getContent();
	                Log.e("log_tag ******", "good connection");	            
		            tiempoFin_up = System.currentTimeMillis();
		            
		            tiempo_up = tiempoFin_up - tiempoInicio_up;
		            
		            muestra_carga(tiempo_up);
	    		}
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    	
			return outPut;
        }      
	
	
		protected void onProgressUpdate(String... progress) {
	        Log.d("ANDRO_ASYNC",progress[0]);
	        mProgressDialog1.setProgress(Integer.parseInt(progress[0]));
	   }
	    
	    @SuppressWarnings("deprecation")
		protected void onPostExecute(String feed) {
	    	dismissDialog(DIALOG_DOWNLOAD_PROGRESS1);
	    	//Toast.makeText(activity, feed, Toast.LENGTH_SHORT).show();
	    	Toast.makeText(activity, "Consulta Exitosa", Toast.LENGTH_SHORT).show();
	    }
	 }
	

	 @SuppressWarnings("rawtypes")
	 class FileUploadResponseHandler implements ResponseHandler {
	
	    @Override
	    public Object handleResponse(HttpResponse response)
	            throws ClientProtocolException, IOException {
	
	        HttpEntity r_entity = response.getEntity();
	        String responseString = EntityUtils.toString(r_entity);
	        Log.d("UPLOAD", responseString);
	
	        return responseString;
	    }
	
	}

	
	// Dialog Descarga
    @Override
    protected Dialog onCreateDialog(int id) 
    {
        switch (id) 
        {
	        case DIALOG_DOWNLOAD_PROGRESS:
	            mProgressDialog = new ProgressDialog(this);
	            mProgressDialog.setTitle("Certificación Wifi");
	            mProgressDialog.setIcon(R.drawable.ic_wifi);
	            mProgressDialog.setMessage("Midiendo Descarga ...");
	            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
	            mProgressDialog.setCancelable(true);
	            mProgressDialog.show();
	            return mProgressDialog;
	            
	        case DIALOG_DOWNLOAD_PROGRESS1:
	            mProgressDialog1 = new ProgressDialog(this);
	            mProgressDialog1.setTitle("Certificación Wifi");
	            mProgressDialog1.setIcon(R.drawable.ic_wifi);
	            mProgressDialog1.setMessage("Midiendo Descarga y Subida");
	            mProgressDialog1.setProgressStyle(ProgressDialog.STYLE_SPINNER);
	            mProgressDialog1.setCancelable(true);
	            mProgressDialog1.show();
	            return mProgressDialog1;
	        default:
	            return null;
      
        }
    }
    
	public void muestra_descarga(long tiempo_down) 
	{
		//String resultado=String.valueOf(tiempo_down);
		//long size_jpg = 1065297;
		long size_jpg = 56237;
		float bw;
		bw = (float)(size_jpg*8)/(float) (tiempo_down*1000);
		DecimalFormat df = new DecimalFormat("0.00");
		String res_bw = df.format(bw);
        tdown.setText(""+res_bw+" Mbps");
	}
	
	public void muestra_carga(long tiempo_down) 
	{
		//String resultado=String.valueOf(tiempo_down);
		//long size_jpg = 239125;
		long size_jpg = 56237;
		float bw;
		bw = (float)(size_jpg*8)/(float) (tiempo_down*1000);
		DecimalFormat df = new DecimalFormat("0.00");
		String res_bw = df.format(bw);
        tup.setText(""+res_bw+" Mbps");
	}
	
	// Tarea Asincrona de getCustomer
  	private class Consulta_Cliente extends AsyncTask<String,Integer,String> {
  		
  		private final ProgressDialog dialog = new ProgressDialog(Instalacion.this);
  		
		protected void onPreExecute() {
			this.dialog.setMessage("Consultando Datos del Cliente");
		    this.dialog.show();
            //super.onPreExecute();
        }
  		 
  	    protected String doInBackground(String... params) {
  	    	
			String respuesta = null;
  			
  			try {
  				TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
  				String IMEI = telephonyManager.getDeviceId();
  				String IMSI =  telephonyManager.getSimSerialNumber();
  				
  				//respuesta = SoapRequestMovistar.getCustomer("72", "2462223",IMEI,IMSI);
  				respuesta = SoapRequestMovistar.getCustomer(Area.getText().toString(), Phone.getText().toString(),IMEI,IMSI);
  			} catch (Exception e1) {
  				e1.printStackTrace();
  			}

  	        return respuesta;
  	    }
  	    

		protected void onPostExecute(String result) {
			
			if (this.dialog.isShowing()) {
		        this.dialog.dismiss();
		     }
  			
  	    	if (result != null)
  	    	{
  	    		try {
  	    			String res = XMLParser.getCustomer(result);
  	    			
  	    			String res1_1 = res.replace("[", "");
  	    			String res1_2 = res1_1.replace("]", "");
  	    			String[] arreglo1 = res1_2.split(",");
  	    			
  	    			String[] arreglo2 = arreglo1[1].split(";");
  	    			String[] arreglo3 = arreglo1[0].split(";");
  	    			
  	    			Toast.makeText(getApplicationContext(), "'"+XMLParser.getReturnCode(result)+"'", Toast.LENGTH_LONG).show();
  	    			
    				// TODO
    				tvSatelitalTipo.setText(arreglo2[1]);
  	    			tvSatelitalModelo.setText(arreglo2[2]);
  	    			
  	    			bandaAnchaTipo.setText(arreglo3[1]);
  	    			bandaAnchaModelo.setText(arreglo3[2]);
  	    			
  	    			
				} catch (Exception e) {
					e.printStackTrace();
				}
  	    	}
  	    	else
  	    	{
  	    		//test_wsdl.setText("Error!");
  	    		Toast.makeText(getApplicationContext(), "Error en la conexión del servicio. Revise su conexión de Internet o 3G.", Toast.LENGTH_LONG).show();
  	    	}
  	    }
  	}
  	
  	/*
  	 * Consulta Asincronica de Lista de Fabricantes de TV Satelital 
  	 */
  	
   	private class Consulta_Fab_TVSatelital extends AsyncTask<String,Integer,String> {
   		
   		private final ProgressDialog dialog = new ProgressDialog(Instalacion.this);
   		
 		protected void onPreExecute() {
 			this.dialog.setMessage("Consultando Datos de Fabricante del Equipo");
 		    this.dialog.show();
             //super.onPreExecute();
         }
   		 
   	    protected String doInBackground(String... params) {
   	    	
 			String respuesta = null;
   			
   			try {
   				TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
   				String IMEI = telephonyManager.getDeviceId();
   				String IMSI =  telephonyManager.getSimSerialNumber();
   				
   				respuesta = SoapRequestMovistar.getVendor("DECO",IMEI,IMSI);
   				
   			} catch (Exception e1) {
   				e1.printStackTrace();
   			}

   	        return respuesta;
   	    }
   	    

 		protected void onPostExecute(String result) {
 			
 			if (this.dialog.isShowing()) {
 		        this.dialog.dismiss();
 		     }
   			
   	    	if (result != null)
   	    	{
   	    		try {
   	    			ArrayList<String> res = XMLParser.getVendor(result);
   	    			
   	    			final CharSequence[] fab = res.toArray(new CharSequence[res.size()]);
   	    			ListarFabricantesTVSat(fab);
   	    			
   	    			
   	    			
 				} catch (Exception e) {
 					e.printStackTrace();
 				}
   	    	}
   	    	else
   	    	{
   	    		//test_wsdl.setText("Error!");
   	    		Toast.makeText(getApplicationContext(), "Error en la conexión del servicio. Revise su conexión de Internet o 3G.", Toast.LENGTH_LONG).show();
   	    	}
   	    }
   	}
   	
   	/*
   	 * Consulta Asincronica Lista de Modelos DECO
   	 */
   	
   	private class Consulta_Mod_TVSatelital extends AsyncTask<String,Integer,String> {
   		
   		private final ProgressDialog dialog = new ProgressDialog(Instalacion.this);
   		
 		protected void onPreExecute() {
 			this.dialog.setMessage("Consultando Datos de Modelo del Equipo");
 		    this.dialog.show();
             //super.onPreExecute();
         }
   		 
   	    protected String doInBackground(String... params) {
   	    	
 			String respuesta = null;
   			
   			try {
   				TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
   				String IMEI = telephonyManager.getDeviceId();
   				String IMSI =  telephonyManager.getSimSerialNumber();
   				
   				respuesta = SoapRequestMovistar.getModel("DECO", tvSatelitalTipo.getText().toString(),  IMEI,IMSI);
   				
   			} catch (Exception e1) {
   				e1.printStackTrace();
   			}

   	        return respuesta;
   	    }
   	    

 		protected void onPostExecute(String result) {
 			
 			if (this.dialog.isShowing()) {
 		        this.dialog.dismiss();
 		     }
   			
   	    	if (result != null)
   	    	{
   	    		try {
   	    			ArrayList<String> res = XMLParser.getModel(result);
   	    			
   	    			final CharSequence[] fab = res.toArray(new CharSequence[res.size()]);
   	    			ListarModelosTVSat(fab);
   	    			
   	    			
   	    			
 				} catch (Exception e) {
 					e.printStackTrace();
 				}
   	    	}
   	    	else
   	    	{
   	    		//test_wsdl.setText("Error!");
   	    		Toast.makeText(getApplicationContext(), "Error en la conexión del servicio. Revise su conexión de Internet o 3G.", Toast.LENGTH_LONG).show();
   	    	}
   	    }
   	}
   	
   	/*
   	 * Consulta Asincronica de Lista de Fabricantes MODEM
   	 */
   	
   	private class Consulta_Fab_BandaAncha extends AsyncTask<String,Integer,String> {
   		
   		private final ProgressDialog dialog = new ProgressDialog(Instalacion.this);
   		
 		protected void onPreExecute() {
 			this.dialog.setMessage("Consultando Datos de Fabricante del Equipo");
 		    this.dialog.show();
             //super.onPreExecute();
         }
   		 
   	    protected String doInBackground(String... params) {
   	    	
 			String respuesta = null;
   			
   			try 
   			{
   				TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
   				String IMEI = telephonyManager.getDeviceId();
   				String IMSI =  telephonyManager.getSimSerialNumber();
   				
   				respuesta = SoapRequestMovistar.getVendor("MODEM",IMEI,IMSI);
   				
   			} catch (Exception e1) {
   				e1.printStackTrace();
   			}

   	        return respuesta;
   	    }
   	    

 		protected void onPostExecute(String result) {
 			
 			if (this.dialog.isShowing()) {
 		        this.dialog.dismiss();
 		     }
   			
   	    	if (result != null)
   	    	{
   	    		try {
   	    			ArrayList<String> res = XMLParser.getVendor(result);
   	    			
   	    			final CharSequence[] fab = res.toArray(new CharSequence[res.size()]);
   	    			ListarFabricantesBandaAncha(fab);
   	    			
 				} catch (Exception e) {
 					e.printStackTrace();
 				}
   	    	}
   	    	else
   	    	{
   	    		//test_wsdl.setText("Error!");
   	    		Toast.makeText(getApplicationContext(), "Error en la conexión del servicio. Revise su conexión de Internet o 3G.", Toast.LENGTH_LONG).show();
   	    	}
   	    }
   	}
   	
   	/*
   	 * Consulta Asincronica Lista de Modelos MODEM
   	 */
   	
   	private class Consulta_Mod_BandaAncha extends AsyncTask<String,Integer,String> {
   		
   		private final ProgressDialog dialog = new ProgressDialog(Instalacion.this);
   		
 		protected void onPreExecute() {
 			this.dialog.setMessage("Consultando Datos de Modelo del Equipo");
 		    this.dialog.show();
             //super.onPreExecute();
         }
   		 
   	    protected String doInBackground(String... params) {
   	    	
 			String respuesta = null;
   			
   			try {
   				TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
   				String IMEI = telephonyManager.getDeviceId();
   				String IMSI =  telephonyManager.getSimSerialNumber();
   				
   				respuesta = SoapRequestMovistar.getModel("MODEM", bandaAnchaTipo.getText().toString(),  IMEI,IMSI);
   				
   			} catch (Exception e1) {
   				e1.printStackTrace();
   			}

   	        return respuesta;
   	    }
   	    

 		protected void onPostExecute(String result) {
 			
 			if (this.dialog.isShowing()) {
 		        this.dialog.dismiss();
 		     }
   			
   	    	if (result != null)
   	    	{
   	    		try {
   	    			ArrayList<String> res = XMLParser.getModel(result);
   	    			
   	    			final CharSequence[] fab = res.toArray(new CharSequence[res.size()]);
   	    			ListarModelosTVSat(fab);
   	    			
   	    			
   	    			
 				} catch (Exception e) {
 					e.printStackTrace();
 				}
   	    	}
   	    	else
   	    	{
   	    		//test_wsdl.setText("Error!");
   	    		Toast.makeText(getApplicationContext(), "Error en la conexión del servicio. Revise su conexión de Internet o 3G.", Toast.LENGTH_LONG).show();
   	    	}
   	    }
   	}
   	
   	/*
   	 * Listar fabricantes de TV Satelital
   	 */
   	
   	public void ListarFabricantesTVSat(final CharSequence[] fab)
   	{
   		AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
		    builder1.setTitle("Seleccione Fabricante de DECO");
		    builder1.setIcon(R.drawable.ic_fabricante);
		    builder1.setItems(fab, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int item) {
		            // Do something with the selection
		            //mDoneButton.setText(fabricantes[item]);
		        	Toast.makeText(Instalacion.this, fab[item]+" seleccionado", Toast.LENGTH_SHORT).show();
		        	tvSatelitalTipo.setText(fab[item]);
		        	//mostrar_equipos_tvsatelital(view);
		        	
		        	Consulta_Mod_TVSatelital tarea = new Consulta_Mod_TVSatelital();
		    		tarea.execute();
		        	
		        }
		    });
		    AlertDialog alert = builder1.create();
		    alert.show();
   	}
   	
   	/*
   	 * Listar Modelos de TV Satelital
   	 */
   	
   	public void ListarModelosTVSat(final CharSequence[] fab)
   	{
   		AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
		    builder1.setTitle("Seleccione Modelo de DECO");
		    builder1.setIcon(R.drawable.ic_fabricante);
		    builder1.setItems(fab, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int item) {
		            // Do something with the selection
		            //mDoneButton.setText(fabricantes[item]);
		        	Toast.makeText(Instalacion.this, fab[item]+" seleccionado", Toast.LENGTH_SHORT).show();
		        	tvSatelitalModelo.setText(fab[item]);
		        	//mostrar_equipos_tvsatelital(view);
		        	
		        }
		    });
		    AlertDialog alert = builder1.create();
		    alert.show();
   	}
   	
   	/*
   	 * Listar Fabricantes de DECO
   	 */
   	
   	public void ListarFabricantesBandaAncha(final CharSequence[] fab)
   	{
   		AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
		    builder1.setTitle("Seleccione Fabricante de MODEM");
		    builder1.setIcon(R.drawable.ic_fabricante);
		    builder1.setItems(fab, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int item) {
		            // Do something with the selection
		            //mDoneButton.setText(fabricantes[item]);
		        	Toast.makeText(Instalacion.this, ((String) fab[item]).replace("\n","")+" seleccionado", Toast.LENGTH_SHORT).show();
		        	bandaAnchaTipo.setText(((String) fab[item]).replace("\n",""));
		        	//mostrar_equipos_tvsatelital(view);
		        	
		        	Consulta_Mod_BandaAncha tarea = new Consulta_Mod_BandaAncha();
		    		tarea.execute();
		        }
		    });
		    AlertDialog alert = builder1.create();
		    alert.show();
   	}
   	
   	/*
   	 * Listar Modelos de DECOS
   	 */
   	
   	public void ListarModelosBandaAncha(final CharSequence[] fab)
   	{
   		AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
		    builder1.setTitle("Seleccione Modelo de MODEM");
		    builder1.setIcon(R.drawable.ic_fabricante);
		    builder1.setItems(fab, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int item) {
		            // Do something with the selection
		            //mDoneButton.setText(fabricantes[item]);
		        	Toast.makeText(Instalacion.this, ((String) fab[item]).replace("\n","")+" seleccionado", Toast.LENGTH_SHORT).show();
		        	bandaAnchaModelo.setText(((String) fab[item]).replace("\n",""));
		        	//mostrar_equipos_tvsatelital(view);
		        	
		        }
		    });
		    AlertDialog alert = builder1.create();
		    alert.show();
   	}
   	

}
