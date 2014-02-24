package cl.inexcell.sistemadegestion;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

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
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


public class Instalacion extends Activity {

	private Bitmap b = null, bmini = null;
	private String name = "";
	private LocationManager locManager;
	private Location loc;
	private String Lat,Lng;
	
	private ArrayList<String> res, plantaExternaActual, mostrando;
	private ArrayList<itemList> items, items_certify;
	private int decoSelected;
	private EditText Area, Phone;
	private String tipoPlantaExterna = null,seleccionado = null;
	private int opcion = 0;
	private String[] updatear = null;
	
	@SuppressWarnings("unused")
	private String tipoDeco, bandaancha_fab_select,bandaancha_modelo;
	
	@SuppressWarnings("unused")
	private CharSequence[] tmp = null;
	
	@SuppressWarnings("unused")
	private TextView tipoPlanta, parExterno,tvArmario, 
	tipoTerminal, tipoParLocal, tvSatelitalModelo, tvSatelitalTipo,
	bandaAnchaTipo, bandaAnchaModelo,PE_TipoPlanta, PE_TipoParExterno,
	PE_TipoArmario, PE_TipoTerminal, PE_TipoParLocal;
	
	// Certificacion
	private TextView tup,tdown,nom_wifi,num_tel;
	
	public static final int DIALOG_DOWNLOAD_PROGRESS = 0;
	public static final int DIALOG_DOWNLOAD_PROGRESS1 = 1;
    private ProgressDialog mProgressDialog, mProgressDialog1;
    
    // Botones Layout
		
	@SuppressWarnings("unused")
	private Button b1,b2,b3,b4,b5,buscar,finalizar,certificar;
	
    private LinearLayout p1,p2,p3,p4,p5,p6,p7;
    
    //TIPO Y MODELO DE INVENTARIO
    private String tipoInventario = "";
    private String modeloInventario = "";
    private Boolean inventarioCorrecto = false;
    
  //CERTIFICACIÓN DSL
    private Boolean certifyDslCorrecto = false;
    private ImageView ib1;
    
    
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
    
    final CharSequence[] option = {"Editar"};

    // Consulta Cliente
	private String area1;
	private String phone1;


	private TableRow p8_0;
	private TableRow p8_1;
	private TableRow p8_2;

	private TableRow p9_0;

	private ListView p9_1;
	private ListView listView;
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
		finalizar = (Button) findViewById(R.id.ButtonFinalizar);
		certificar = (Button) findViewById(R.id.ButtonCertificarAgain);
		
		
		setupInicial();
		
		//television_Satelital(); 
				
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
	
	public void television_Satelital(){
		listView = (ListView) findViewById(R.id.listviewTv);
		listAdapter adapter = new listAdapter(this, items);
	    listView.setAdapter(adapter);
	    listView.setOnItemClickListener(new OnItemClickListener() {
	    	  @Override
	    	  public void onItemClick(AdapterView<?> parent, View view,
	    	    int position, long id) {
//	    	    Toast.makeText(getApplicationContext(),
//	    	      "Click ListItem Number " + position, Toast.LENGTH_LONG)
//	    	      .show();
	    		  decoSelected = position;
	    		  mostrar_planta_tvsatelital();
	    		  
	    	  }
	    	});
	}
	
//	private ArrayList<itemList> generateData(){
//        ArrayList<itemList> items = new ArrayList<itemList>();
//        for(int i = 1; i <= 7; i++)
//        	items.add(new itemList(String.valueOf(i),"Modelo "+i));
//        
//        return items;
//    }
	
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
//				tvSatelitalTipo = (TextView) findViewById(R.id.tvSatelitalTipo);
//				tvSatelitalModelo = (TextView) findViewById(R.id.tvSatelitalModelo);
				
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
				p7 = (LinearLayout) findViewById(R.id.panelCertificacion1);
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
				p7.setVisibility(View.VISIBLE);
				
				ib1 = (ImageView) findViewById(R.id.nro_telefono_ok);
	}
	
	/*
	 * Funcion de boton buscar cliente
	 */
	
	public void buscar_cliente(final View view) throws Exception
	{
		setupInicial();
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
			
			
			// TODO: Realizar validacion Cliente 
			//Toast.makeText(getApplicationContext(), XMLParser.getReturnCode(tarea.get().toString()), Toast.LENGTH_LONG).show();
			
			
			// Seleccionar objetos de Botones en Layout
			
		}
	}
	
	public void dibujar(){
		Consulta_PlantasExternas tarea1 = new Consulta_PlantasExternas();
		tarea1.execute();
		
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(Area.getWindowToken(), 0);
		
		b1.setVisibility(View.VISIBLE);
		b2.setVisibility(View.VISIBLE);
		b3.setVisibility(View.VISIBLE);
		b4.setVisibility(View.VISIBLE);
		b5.setVisibility(View.VISIBLE);
		
		// Animacion
		
		b2.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.accelerate));
		b3.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.accelerate));
		b4.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.accelerate));
		b5.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.accelerate));
		
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
   			p9_1 = (ListView) findViewById(R.id.listviewCertify);
   			
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
			
//			startDownload();
//       		muestra_descarga(0);
//       		
//       		startUpload();
//       		muestra_carga(0);
			
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
			//LLAMAR AL ASINCRÓNICO PARA CERTIFICAcion DSL
            
            Consulta_Certify_DSL tarea = new Consulta_Certify_DSL();
            tarea.execute(); 
		
   		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	public void mostrar_planta_tvsatelital(){
		
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
	        	
	        	Toast.makeText(Instalacion.this, equipos[item]+" seleccionado", Toast.LENGTH_SHORT).show();
	        	tipoInventario = "MODEM";
	        	modeloInventario = equipos[item].toString();
	        	//HACER EL UPDATE
	        	
	        	Consulta_Upd_Inventario updateInventory = new Consulta_Upd_Inventario();
	        	updateInventory.execute();
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
	        	tipoPlantaExterna = "ARMARIO";
	        	if(opc_planta[item] == "Editar"){
	        		opcion = 0;
	        		mostrar_armario(view);
	        	}
	        	if(item == 0 ){
	        		if(tvArmario.getText().toString().compareTo("--") == 0){
	        			Toast.makeText(getApplicationContext(), "No puede georeferenciar si el número no tiene armario registrado", Toast.LENGTH_LONG).show();
	        			return;
	        		}
	        		//Toast.makeText(getApplicationContext(), "Geo", Toast.LENGTH_LONG).show();
	        		opcion = 1;
	        		locManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
	        		loc = locManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
	        		Log.i("LOCALIZACION", loc.getLatitude()+"\n"+loc.getLongitude());
	        		if(loc != null){
	        			Lat = String.valueOf(loc.getLatitude());
	        			Lng = String.valueOf(loc.getLongitude());
	        		}
	        		Consulta_UpdatePlantasExternas x = new Consulta_UpdatePlantasExternas();
		        	x.execute();
	        		
	        	}
	        	if(item == 2){
	        		if(tvArmario.getText().toString().compareTo("--") == 0){
	        			Toast.makeText(getApplicationContext(), "No puede enviar fotografía si el número no tiene armario registrado", Toast.LENGTH_LONG).show();
	        			return;
	        		}
	        		opcion = 2;
	        		name = Environment.getExternalStorageDirectory() + "/test.jpg";
	        		Intent intent =  new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	            	int code = 1;            		
	            	Uri output = Uri.fromFile(new File(name));
	            	intent.putExtra(MediaStore.EXTRA_OUTPUT, output);	            	
	            	startActivityForResult(intent, code);
	        	}
	        	
	        }
	    });
	    AlertDialog alert = builder.create();
	    alert.show();
	}
	
	@Override 
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (requestCode == 1) {
	    	if (data != null) {
	    		if (data.hasExtra("data")) {
	    		    b = (Bitmap) data.getParcelableExtra("data");
	    		}
	    	} else {
	    			b = BitmapFactory.decodeFile(name);
	    			
	    		}
	    } 
	    try{
	    b = Bitmap.createScaledBitmap(b, 640, 480, true);
	    bmini = Bitmap.createScaledBitmap(b, 64, 64, true);
	    }catch(Exception ex){
	    	Toast.makeText(getApplicationContext(), "ERROR FOTO", Toast.LENGTH_LONG).show();
	    }
	    
	    Consulta_UpdatePlantasExternas x = new Consulta_UpdatePlantasExternas();
    	x.execute();
	    
	}
	
	/** Boton para cambiar la planta en seccion PLANTA EXTERNA **/
	public void mostrar_planta2(View view){
		Consulta_PlantasExternas cpe = new Consulta_PlantasExternas();
		tipoPlantaExterna = "PLANTA";
		cpe.execute();
		
//		AlertDialog.Builder builder = new AlertDialog.Builder(this);
//	    builder.setTitle("Seleccione Planta Externa");
//	    builder.setIcon(R.drawable.ic_planta_ext);
//	    builder.setItems(plantas_ext, new DialogInterface.OnClickListener() {
//	        public void onClick(DialogInterface dialog, int item) {
//	            // Do something with the selection
//	            //mDoneButton.setText(fabricantes[item]);
//	        	Toast.makeText(Instalacion.this, "Planta Actualizada", Toast.LENGTH_SHORT).show();
//	        	tipoPlanta.setText(plantas_ext[item]);
//	        }
//	    });
//	    AlertDialog alert = builder.create();
//	    alert.show();
	}
	
	public void mostrar_cajaterminal(final View view){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
	    builder.setTitle("Seleccione Opción");
	    builder.setIcon(R.drawable.ic_planta);
	    builder.setItems(opc_planta, new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int item) {
	            // Do something with the selection
	            //mDoneButton.setText(fabricantes[item]);
	        	tipoPlantaExterna = "CAJA";
	        	if(opc_planta[item] == "Editar"){
	        		opcion = 0;
	        		mostrar_cajaterminal1(view);
	        	}
	        	if(item == 0){
	        		if(tipoTerminal.getText().toString().compareTo("--") == 0){
	        			Toast.makeText(getApplicationContext(), "No puede georeferenciar si el número no tiene armario registrado", Toast.LENGTH_LONG).show();
	        			return;
	        		}
	        		opcion = 1;
	        		locManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
	        		loc = locManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
	        		Log.i("LOCALIZACION", loc.getLatitude()+"\n"+loc.getLongitude());
	        		if(loc != null){
	        			Lat = String.valueOf(loc.getLatitude());
	        			Lng = String.valueOf(loc.getLongitude());
	        		}
	        		else{
	        			loc = locManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
	        			Lat = String.valueOf(loc.getLatitude());
	        			Lng = String.valueOf(loc.getLongitude());
	        		}
	        		Consulta_UpdatePlantasExternas x = new Consulta_UpdatePlantasExternas();
		        	x.execute();
	        		
	        	}
	        	if(item == 2){
	        		if(tipoTerminal.getText().toString().compareTo("--") == 0){
	        			Toast.makeText(getApplicationContext(), "No puede enviar fotografía si el número no tiene armario registrado", Toast.LENGTH_LONG).show();
	        			return;
	        		}
	        		opcion = 2;
	        		name = Environment.getExternalStorageDirectory() + "/test.jpg";
	        		Intent intent =  new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	            	int code = 1;            		
	            	Uri output = Uri.fromFile(new File(name));
	            	intent.putExtra(MediaStore.EXTRA_OUTPUT, output);	            	
	            	startActivityForResult(intent, code);
	        	}
	        	
	        }
	    });
	    AlertDialog alert = builder.create();
	    alert.show();
	}
	
	public void mostrar_cajaterminal1(View view){
		Consulta_PlantasExternas cpe = new Consulta_PlantasExternas();
		tipoPlantaExterna = "CAJA";
		cpe.execute();
//		AlertDialog.Builder builder = new AlertDialog.Builder(this);
//	    builder.setTitle("Seleccione Caja Terminal");
//	    builder.setIcon(R.drawable.ic_cajaterminal);
//	    builder.setItems(caja_terminal, new DialogInterface.OnClickListener() {
//	        public void onClick(DialogInterface dialog, int item) {
//	            // Do something with the selection
//	            //mDoneButton.setText(fabricantes[item]);
//	        	Toast.makeText(Instalacion.this, "Caja Terminal Actualizado", Toast.LENGTH_SHORT).show();
//	        	tipoTerminal.setText(caja_terminal[item].subSequence(5, caja_terminal[item].length()));
//	        }
//	    });
//	    AlertDialog alert = builder.create();
//	    alert.show();
	}
	
	public void mostrar_parexterno(View view){
		Consulta_PlantasExternas cpe = new Consulta_PlantasExternas();
		tipoPlantaExterna = "CABLE"; //"CABLE"
		cpe.execute();
//		AlertDialog.Builder builder = new AlertDialog.Builder(this);
//	    builder.setTitle("Seleccione Par Externo");
//	    builder.setIcon(R.drawable.ic_parexterno);
//	    builder.setItems(par_externo, new DialogInterface.OnClickListener() {
//	        public void onClick(DialogInterface dialog, int item) {
//	            // Do something with the selection
//	            //mDoneButton.setText(fabricantes[item]);
//	        	Toast.makeText(Instalacion.this, "Par Externo Actualizado", Toast.LENGTH_SHORT).show();
//	        	parExterno.setText(par_externo[item].subSequence(4, par_externo[item].length()));
//	        }
//	    });
//	    AlertDialog alert = builder.create();
//	    alert.show();
	}
	
	public void mostrar_armario(View view){
		Consulta_PlantasExternas cpe = new Consulta_PlantasExternas();
		tipoPlantaExterna = "ARMARIO"; //"CABLE"
		cpe.execute();
//		AlertDialog.Builder builder = new AlertDialog.Builder(this);
//	    builder.setTitle("Seleccione Armario");
//	    builder.setIcon(R.drawable.ic_armario);
//	    builder.setItems(armario, new DialogInterface.OnClickListener() {
//	        public void onClick(DialogInterface dialog, int item) {
//	            // Do something with the selection
//	            //mDoneButton.setText(fabricantes[item]);
//	        	Toast.makeText(Instalacion.this, "Armario Actualizado", Toast.LENGTH_SHORT).show();
//	        	tvArmario.setText(armario[item]);
//	        }
//	    });
//	    AlertDialog alert = builder.create();
//	    alert.show();
	}
		
	public void mostrar_parlocal(View view){
		Consulta_PlantasExternas cpe = new Consulta_PlantasExternas();
		tipoPlantaExterna = "PAR LOCAL"; //"CABLE"
		cpe.execute();
//		AlertDialog.Builder builder = new AlertDialog.Builder(this);
//	    builder.setTitle("Seleccione Par Local");
//	    builder.setIcon(R.drawable.ic_parlocal);
//	    builder.setItems(par_local, new DialogInterface.OnClickListener() {
//	        public void onClick(DialogInterface dialog, int item) {
//	            // Do something with the selection
//	            //mDoneButton.setText(fabricantes[item]);
//	        	Toast.makeText(Instalacion.this, par_local[item]+" seleccionado", Toast.LENGTH_SHORT).show();
//	        	tipoParLocal.setText(par_local[item]);
//	        }
//	    });
//	    AlertDialog alert = builder.create();
//	    alert.show();
	}
		
	public void fin_certificar(View view){
		if(certifyDslCorrecto == true)
			Toast.makeText(this, "Certificación realizada exitosamente", Toast.LENGTH_SHORT).show();
		else if(certifyDslCorrecto==false)
			Toast.makeText(this, "Certificación realizada con reparos", Toast.LENGTH_SHORT).show();
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

		@Override
        protected void onPreExecute() {
            super.onPreExecute();
            //showDialog(DIALOG_DOWNLOAD_PROGRESS);
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
//             Log.d("ANDRO_ASYNC",progress[0]);
//             mProgressDialog.setProgress(Integer.parseInt(progress[0]));
        }

        
		@Override
        protected void onPostExecute(String unused) {
//            dismissDialog(DIALOG_DOWNLOAD_PROGRESS);
        }
    }
    
	
	//http://stackoverflow.com/questions/2017414/post-multipart-request-with-android-sdk
	class UploadFileTask extends AsyncTask<String,String,String> {
	
		@SuppressWarnings("unused")
		private Activity activity;
		
		public UploadFileTask(Activity activity){
			this.activity = activity;
		}
		
		
		protected void onPreExecute() {
            super.onPreExecute();
//            showDialog(DIALOG_DOWNLOAD_PROGRESS1);
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
//	        Log.d("ANDRO_ASYNC",progress[0]);
//	        mProgressDialog1.setProgress(Integer.parseInt(progress[0]));
	   }
	    
	    
		protected void onPostExecute(String feed) {
//	    	dismissDialog(DIALOG_DOWNLOAD_PROGRESS1);
//	    	//Toast.makeText(activity, feed, Toast.LENGTH_SHORT).show();
//	    	Toast.makeText(activity, "Consulta Exitosa", Toast.LENGTH_SHORT).show();
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
			this.dialog.setMessage("Buscando...");
			this.dialog.setCanceledOnTouchOutside(false);
 			this.dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
				
				@Override
				public void onCancel(DialogInterface dialog) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "Operación Interrumpida.", Toast.LENGTH_LONG).show();
					Instalacion.this.finish();
				}
			});
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
                 
                  try{
                  //String[] arreglo2 = arreglo1[0].split(";");
                  String[] arreglo3 = arreglo1[0].split(";");
                  bandaAnchaTipo.setText(arreglo3[1]);
                  bandaAnchaModelo.setText(arreglo3[2]);
                  }catch(Exception ex)
                  {
                        bandaAnchaTipo.setText("---");
                        bandaAnchaModelo.setText("---");
                       
                  }
                 
                 
                  //Toast.makeText(getApplicationContext(), "'"+XMLParser.getReturnCode(result)+"'", Toast.LENGTH_LONG).show();
                  Toast.makeText(getApplicationContext(), "Cliente Encontrado", Toast.LENGTH_LONG).show();
                 
                  // TODO
//                     tvSatelitalTipo.setText(arreglo2[1]);
//          tvSatelitalModelo.setText(arreglo2[2]);
                  items = new ArrayList<itemList>();                  
              int cont = 0;
                  for(int i = 0; i < arreglo1.length ;i++){
                        String[] dato = arreglo1[i].split(";");
                        if(dato[0].compareTo(" DECO")==0){
                             //agrego
                             cont++;
                             items.add(new itemList(String.valueOf(cont),dato[2]));
                            
                        }
                  }
                  if(cont == 0){
                        items.add(new itemList("--","No hay datos"));
                  }
                       
                  television_Satelital();
           
                  dibujar();
                 
                  } catch (Exception e) {
                       Toast.makeText(Instalacion.this, "El N° ingresado no pertenece a la compañía.", Toast.LENGTH_SHORT).show();
                       e.printStackTrace();
                      
                       /** TEST
                       */
                       if(Phone.getText().toString().compareTo("2594995")==0 || Phone.getText().toString().compareTo("22872755")==0)
                             dibujar();
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
 			this.dialog.setCanceledOnTouchOutside(false);
 			this.dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
				
				@Override
				public void onCancel(DialogInterface dialog) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "Operación Interrumpida.", Toast.LENGTH_LONG).show();
					Instalacion.this.finish();
				}
			});
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
   	    			
   	    			CharSequence[] fab = res.toArray(new CharSequence[res.size()]);
   	    			ListarFabricantesTVSat(fab);
   	    			
   	    			
   	    			
 				} catch (Exception e) {
 					e.printStackTrace();
 				}
   	    	}
   	    	else
   	    	{
   	    		//test_wsdl.setText("Error!");
   	    		Toast.makeText(getApplicationContext(), "Error en la conexión del servicio. Revise su conexión de Internet o 3G.", Toast.LENGTH_LONG).show();
   	    		Instalacion.this.finish();
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
 			this.dialog.setCanceledOnTouchOutside(false);
 			this.dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
				
				@Override
				public void onCancel(DialogInterface dialog) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "Operación Interrumpida.", Toast.LENGTH_LONG).show();
					Instalacion.this.finish();
				}
			});
 		    this.dialog.show();
             //super.onPreExecute();
         }
   		 
   	    protected String doInBackground(String... params) {
   	    	
 			String respuesta = null;
   			
   			try {
   				TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
   				String IMEI = telephonyManager.getDeviceId();
   				String IMSI =  telephonyManager.getSimSerialNumber();
   				
   				respuesta = SoapRequestMovistar.getModel("DECO", tipoDeco,  IMEI,IMSI);
   				
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
   	    		Instalacion.this.finish();
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
 			this.dialog.setCanceledOnTouchOutside(false);
 			this.dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
				
				@Override
				public void onCancel(DialogInterface dialog) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "Operación Interrumpida.", Toast.LENGTH_LONG).show();
					Instalacion.this.finish();
				}
			});
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
   	    		Instalacion.this.finish();
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
 			this.dialog.setCanceledOnTouchOutside(false);
 			this.dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
				
				@Override
				public void onCancel(DialogInterface dialog) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "Operación Interrumpida.", Toast.LENGTH_LONG).show();
					Instalacion.this.finish();
				}
			});
 		    this.dialog.show();
             //super.onPreExecute();
         }
   		 
   	    protected String doInBackground(String... params) {
   	    	
 			String respuesta = null;
   			
   			try {
   				TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
   				String IMEI = telephonyManager.getDeviceId();
   				String IMSI =  telephonyManager.getSimSerialNumber();
   				
   				respuesta = SoapRequestMovistar.getModel("MODEM", bandaancha_fab_select,  IMEI,IMSI);
   				
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
   	    			if(fab.length != 0){
   	    				String asd = fab[0].toString();
   	    				if(asd.compareTo("")==0){
   	    					Toast.makeText(getApplicationContext(), "No hay modelos para el fabricante "+bandaancha_fab_select+".", Toast.LENGTH_LONG).show();
   	    					return;
   	    				}
   	    				else
   	    					ListarModelosBandaAncha(fab);
   	    			
   	    			}
   	    			
 				} catch (Exception e) {
 					e.printStackTrace();
 				}
   	    	}
   	    	else
   	    	{
   	    		Toast.makeText(getApplicationContext(), "Error en la conexión del servicio. Revise su conexión de Internet o 3G.", Toast.LENGTH_LONG).show();
   	    		Instalacion.this.finish();
   	    	}
   	    }
   	}
   	
   	/*
   	 * Consultar Plantas Externas
   	 */
   	
private class Consulta_UpdatePlantasExternas extends AsyncTask<String,Integer,String> {
   		
   		private final ProgressDialog dialog = new ProgressDialog(Instalacion.this);
   		
 		protected void onPreExecute() {
 			this.dialog.setMessage("Consultando Datos de Cliente y Planta Externas");
 			this.dialog.setCanceledOnTouchOutside(false);
 			this.dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
				
				@Override
				public void onCancel(DialogInterface dialog) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "Operación Interrumpida.", Toast.LENGTH_LONG).show();
					Instalacion.this.finish();
				}
			});
 		    this.dialog.show();
             //super.onPreExecute();
         }
   		 
   	    protected String doInBackground(String... params) {
   	    	
 			String res = null;
   			
   			try {
   				TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
   				String IMEI = telephonyManager.getDeviceId();
   				String IMSI =  telephonyManager.getSimSerialNumber();
   				
   				if(opcion == 0){//Actualizar Aparato
   					res = SoapRequestMovistar.setOutsidePlantUpgrade(updatear[3], updatear[2], tipoPlantaExterna, null, null, null, IMEI, IMSI);
   				}
   				if(opcion == 1){//Georeferenciar
   					String lat = Lat;
   					String lng = Lng;
   					Lat = null;
   					Lng = null;
   							
   					if(lat == null || lng == null)
   						return null;
   					
   					for(int i = 0; i < plantaExternaActual.size(); i++){
   						if(plantaExternaActual.get(i).split(";")[1].contains(tipoPlantaExterna) && plantaExternaActual.get(i).split(";")[0].compareTo("Element")==0 ){
   							String Id = plantaExternaActual.get(i).split(";")[3];
   							String Value = plantaExternaActual.get(i).split(";")[2];
   							res = SoapRequestMovistar.setOutsidePlantUpgrade(Id, Value, tipoPlantaExterna, lat, lng, null, IMEI, IMSI);
   							break;
   						}
   					}
   				}
   				if(opcion == 2){//Enviar Foto
   					
   					Bitmap foto = b;
   					b = null;
   					ArrayList<String> a = plantaExternaActual;
   					for(int i = 0; i < a.size(); i++){
   						if(plantaExternaActual.get(i).split(";")[1].contains(tipoPlantaExterna) && plantaExternaActual.get(i).split(";")[0].compareTo("Element")==0 ){
   							String Id = plantaExternaActual.get(i).split(";")[3];
   							String Value = plantaExternaActual.get(i).split(";")[2];
   							res = SoapRequestMovistar.setOutsidePlantUpgrade(Id, Value, tipoPlantaExterna,
   																				null, null, 
   																				Funciones.encodeTobase64(foto), 
   																				IMEI, IMSI);
   							break;
   						}
   					}
   				}
   				
   				
   			} catch (Exception e1) {
   				e1.printStackTrace();
   			}   		

   	        return res;
   	    }
   	    

 		protected void onPostExecute(String result) {
 			
 			if (this.dialog.isShowing()) {
 		        this.dialog.dismiss();
 		     }
   			
   	    	if (result != null)
   	    	{
   	    		try {
   	    			String returns = XMLParser.getReturnCode(result);
   	    			returns = returns.replace("[", "").replace("]", "");
   	    			
   	    			int code = Integer.valueOf(returns);
   	    			if(code == 0 && opcion == 0){
   	    					tipoPlantaExterna = null;
   	    					seleccionado = null;
   	    					Consulta_PlantasExternas a = new Consulta_PlantasExternas();
   	    					a.execute();
//   	    				int encontrado = 0;
//   	    				for(int i = 0; i < plantaExternaActual.size(); i++){
//   	   						if(plantaExternaActual.get(i).split(";")[1].contains(tipoPlantaExterna) && plantaExternaActual.get(i).split(";")[0].compareTo("Element")==0 ){
//   	   							plantaExternaActual.set(i, updatear[0]+";"+updatear[1]+";"+updatear[2]+";"+updatear[3]);
//   	   							encontrado++;
//   	   							break;
//   	   						}
//   	   					}
//   	    				
//   	    				if(encontrado == 0)
//   	    					plantaExternaActual.add(updatear[0]+";"+updatear[1]+";"+updatear[2]+";"+updatear[3]);
//   	    				
//   	    				Toast.makeText(getApplicationContext(), "Se Actualizó Correctamente", Toast.LENGTH_LONG).show();
//   	    				if(tipoPlantaExterna.compareTo("PLANTA")==0){   	    					
//   	    					tipoPlantaExterna = null;
//   	    					
//   	    					
//   	    					tipoPlanta.setText(seleccionado);
//   	    					seleccionado = null;
//   	    				}
//   	    				if(tipoPlantaExterna.compareTo("CABLE")==0){
//   	    					tipoPlantaExterna = null;
//   	    					parExterno.setText(seleccionado);
//   	    					seleccionado = null;
//   	    				}
//   	    				if(tipoPlantaExterna.compareTo("ARMARIO")==0){
//   	    					tipoPlantaExterna = null;
//   	    					tvArmario.setText(seleccionado);
//   	    					seleccionado = null;
//   	    				}
//   	    				if(tipoPlantaExterna.compareTo("PAR LOCAL")==0){
//   	    					tipoPlantaExterna = null;
//   	    					tipoParLocal.setText(seleccionado);
//   	    					seleccionado = null;
//   	    				}
//   	    				if(tipoPlantaExterna.compareTo("CAJA")==0){
//   	    					tipoPlantaExterna = null;
//   	    					tipoTerminal.setText(seleccionado);
//   	    					seleccionado = null;
//   	    				}
   	    			}else if (code == 0 && opcion != 0){
   	    				Toast.makeText(getApplicationContext(), "Se Actualizó Correctamente", Toast.LENGTH_LONG).show();
   	    			}
   	    			else{
   	    				Toast.makeText(getApplicationContext(), "No se pudo actualizar." , Toast.LENGTH_LONG).show();
   	    			}
   	    
   	    			
   	    			
   	    			
   	    			
   	    			
 				} catch (Exception e) {
 					e.printStackTrace();
 				}
   	    	}
   	    	else
   	    	{
   	    		//test_wsdl.setText("Error!");
   	    		Toast.makeText(getApplicationContext(), "Error en la conexión del servicio. Revise su conexión de Internet o 3G.", Toast.LENGTH_LONG).show();
   	    		Instalacion.this.finish();
   	    	}
   	    }
   	}
   	
   	private class Consulta_PlantasExternas extends AsyncTask<String,Integer,String> {
   		
   		private final ProgressDialog dialog = new ProgressDialog(Instalacion.this);
   		
 		protected void onPreExecute() {
 			this.dialog.setMessage("Consultando Datos de Cliente y Planta Externas");
 			this.dialog.setCanceledOnTouchOutside(false);
 			this.dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
				
				@Override
				public void onCancel(DialogInterface dialog) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "Operación Interrumpida.", Toast.LENGTH_LONG).show();
					Instalacion.this.finish();
				}
			});
 		    this.dialog.show();
             //super.onPreExecute();
         }
   		 
   	    protected String doInBackground(String... params) {
   	    	
 			String res = null;
   			
   			try {
   				TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
   				String IMEI = telephonyManager.getDeviceId();
   				String IMSI =  telephonyManager.getSimSerialNumber();
   				
   				res = SoapRequestMovistar.getOutsidePlant(Area.getText().toString(), Phone.getText().toString(),tipoPlantaExterna, IMEI,IMSI);
   				
   			} catch (Exception e1) {
   				e1.printStackTrace();
   			}
   			
   	        return res;
   	    }
   	    

 		protected void onPostExecute(String result) {
 			
 			if (this.dialog.isShowing()) {
 		        this.dialog.dismiss();
 		     }
   			
   	    	if (result != null)
   	    	{
   	    		try {
//   	    			
//   	    			
//   	    			PE_TipoPlanta.setText(XMLParser.getOutsidePlant(resultado[0]).replace("[", "").replace("]", ""));
   	    			String returns = XMLParser.getReturnCode(result);
   	    			returns = returns.replace("[", "").replace("]", "");
   	    			
   	    			int code = Integer.valueOf(returns);
   	    			if(code == 0){
   	    				llenarPlantaExterna(tipoPlantaExterna, XMLParser.getOutsidePlant(result));
   	    			}
   	    			else{
   	    				if(tipoPlantaExterna == null)
   	    					Toast.makeText(getApplicationContext(), "No hay plantas externas para este número.", Toast.LENGTH_LONG).show();
   	    				if(tipoPlantaExterna != null)
   	    					Toast.makeText(getApplicationContext(), "No Hay Datos para "+tipoPlantaExterna+" para este número." , Toast.LENGTH_LONG).show();
   	    			}
   	    				
   	    			
 				} catch (Exception e) {
 					e.printStackTrace();
 				}
   	    	}
   	    	else
   	    	{
   	    		//test_wsdl.setText("Error!");
   	    		Toast.makeText(getApplicationContext(), "Error en la conexión del servicio. Revise su conexión de Internet o 3G.", Toast.LENGTH_LONG).show();
   	    		Instalacion.this.finish();
   	    	}
   	    }
   	}
   	
   	public void llenarPlantaExterna(String tipo, ArrayList<String> r){
   		plantaExternaActual = r;
   		if(tipoPlantaExterna == null){   			
   			for(int i = 0; i < r.size(); i++){
   				String[] campos = r.get(i).replace("[", "").replace("]", "").split(";");
   				if(campos[0].compareTo("Element")!= 0)
   					continue;
   				
   				if(campos[1].compareTo("PLANTA")==0){
   					tipoPlanta.setText(campos[2]);
   				}
   				if(campos[1].compareTo("CABLE")==0){
   					parExterno.setText(campos[2]);
   				}
   				if(campos[1].compareTo("ARMARIO")==0){
   					tvArmario.setText(campos[2]);
   				}
   				if(campos[1].compareTo("PAR LOCAL")==0){
   					tipoParLocal.setText(campos[2]);
   				}
   				if(campos[1].compareTo("CAJA")==0){
   					tipoTerminal.setText(campos[2]);
   				}
   				
   				
   			}
		}
   		else{
   			List<String> listItems = new ArrayList<String>();
   			mostrando = new ArrayList<String>();
			int cont = 0;
			for(int i = 0; i < r.size(); i++){
			//final CharSequence[] i = {"planta1","planta2"};//dividir res
				String[] campos = r.get(i).replace("[", "").replace("]", "").split(";");
   				if(campos[0].compareTo("Element")== 0)
   					continue;
   				listItems.add(campos[2]);   				
				mostrando.add(r.get(i).replace("[", "").replace("]", ""));
   				cont++;
			}
			
			if(cont == 0){
				Toast.makeText(getApplicationContext(), "No hay resultados para "+tipoPlantaExterna, Toast.LENGTH_LONG).show();
				tipoPlantaExterna = null;
				return;
			}
				
			final CharSequence[] item = listItems.toArray(new CharSequence[listItems.size()]);
			AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
		    builder1.setTitle("Seleccione una elemento");
		    builder1.setIcon(R.drawable.ic_fabricante);
		    builder1.setItems(item, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int i) {
		            
		        	//Toast.makeText(Instalacion.this, item[i]+" seleccionado", Toast.LENGTH_SHORT).show();
		        	seleccionado = item[i].toString();
		        	updatear = mostrando.get(i).split(";");
		        	//Log.i("", "");
		        	opcion = 0;
		        	Consulta_UpdatePlantasExternas cupe = new Consulta_UpdatePlantasExternas();
		        	cupe.execute();
		        	//Actualizar con el dato seleccionado XML-006
		        	
		        	
		        }
		    });
		    AlertDialog alert = builder1.create();
		    alert.show();
   		}
   			
//		if(tipoPlantaExterna.compareTo("PLANTA") == 0){
//			List<String> listItems = new ArrayList<String>();
//			
//			for(int i = 0; i < r.size(); i++){
//			//final CharSequence[] i = {"planta1","planta2"};//dividir res
//				String[] campos = r.get(i).replace("[", "").replace("]", "").split(";");
//   				if(campos[0].compareTo("Element")== 0)
//   					continue;
//   				listItems.add(campos[2]);
//   				
//			}
//			final CharSequence[] item = listItems.toArray(new CharSequence[listItems.size()]);
//			AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
//		    builder1.setTitle("Seleccione Fabricante de DECO");
//		    builder1.setIcon(R.drawable.ic_fabricante);
//		    builder1.setItems(item, new DialogInterface.OnClickListener() {
//		        public void onClick(DialogInterface dialog, int i) {
//		            
//		        	Toast.makeText(Instalacion.this, item[i]+" seleccionado", Toast.LENGTH_SHORT).show();
//		        	
//		        	//Actualizar con el dato seleccionado XML-006        	
//		        	
//		        }
//		    });
//		    AlertDialog alert = builder1.create();
//		    alert.show();
//		}
//		if(tipoPlantaExterna.compareTo("CABLE") == 0){
//			final CharSequence[] i = {"cable1","cable2"};//dividir res
//			AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
//		    builder1.setTitle("Seleccione Fabricante de DECO");
//		    builder1.setIcon(R.drawable.ic_fabricante);
//		    builder1.setItems(i, new DialogInterface.OnClickListener() {
//		        public void onClick(DialogInterface dialog, int item) {
//		            
//		        	Toast.makeText(Instalacion.this, i[item]+" seleccionado", Toast.LENGTH_SHORT).show();
//		        	
//		        	//Actualizar con el dato seleccionado XML-006        	
//		        	
//		        }
//		    });
//		    AlertDialog alert = builder1.create();
//		    alert.show();
//		}
//		if(tipoPlantaExterna.compareTo("ARMARIO") == 0){
//			final CharSequence[] i = {"armario1","armario2"};//dividir res
//			AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
//		    builder1.setTitle("Seleccione Fabricante de DECO");
//		    builder1.setIcon(R.drawable.ic_fabricante);
//		    builder1.setItems(i, new DialogInterface.OnClickListener() {
//		        public void onClick(DialogInterface dialog, int item) {
//		            
//		        	Toast.makeText(Instalacion.this, i[item]+" seleccionado", Toast.LENGTH_SHORT).show();
//		        	
//		        	//Actualizar con el dato seleccionado XML-006        	
//		        	
//		        }
//		    });
//		    AlertDialog alert = builder1.create();
//		    alert.show();
//		}
//		if(tipoPlantaExterna.compareTo("PAR LOCAL") == 0){
//			final CharSequence[] i = {"parlocal1","parlocal2"};//dividir res
//			AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
//		    builder1.setTitle("Seleccione Fabricante de DECO");
//		    builder1.setIcon(R.drawable.ic_fabricante);
//		    builder1.setItems(i, new DialogInterface.OnClickListener() {
//		        public void onClick(DialogInterface dialog, int item) {
//		            
//		        	Toast.makeText(Instalacion.this, i[item]+" seleccionado", Toast.LENGTH_SHORT).show();
//		        	
//		        	//Actualizar con el dato seleccionado XML-006        	
//		        	
//		        }
//		    });
//		    AlertDialog alert = builder1.create();
//		    alert.show();
//		}
//		if(tipoPlantaExterna.compareTo("CAJA") == 0){
//			final CharSequence[] i = {"caja1","caja2"};//dividir res
//			AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
//		    builder1.setTitle("Seleccione Fabricante de DECO");
//		    builder1.setIcon(R.drawable.ic_fabricante);
//		    builder1.setItems(i, new DialogInterface.OnClickListener() {
//		        public void onClick(DialogInterface dialog, int item) {
//		            
//		        	Toast.makeText(Instalacion.this, i[item]+" seleccionado", Toast.LENGTH_SHORT).show();
//		        	
//		        	//Actualizar con el dato seleccionado XML-006        	
//		        	
//		        }
//		    });
//		    AlertDialog alert = builder1.create();
//		    alert.show();
//		}
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
		        	//tvSatelitalTipo.setText(fab[item]);
		        	//mostrar_equipos_tvsatelital(view);
		        	tipoDeco = fab[item].toString();
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
		        	
		        	//mostrar_equipos_tvsatelital(view);
		        	
		        	tipoInventario = "DECO";
		        	modeloInventario = fab[item].toString();
		        	
		        	Consulta_Upd_Inventario updateInventory = new Consulta_Upd_Inventario();
		        	updateInventory.execute();
		        	
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
		        	//bandaAnchaTipo.setText(((String) fab[item]).replace("\n",""));
		        	//mostrar_equipos_tvsatelital(view);		        	
		        	bandaancha_fab_select = ((String) fab[item]).replace("\n","");
		        	
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
		        	modeloInventario = ((String) fab[item]).replace("\n","");
		        	tipoInventario = "MODEM";
		        	Consulta_Upd_Inventario cui = new Consulta_Upd_Inventario();
		        	cui.execute();
		        	//bandaAnchaModelo.setText(((String) fab[item]).replace("\n",""));
		        	//mostrar_equipos_tvsatelital(view);
		        	
		        }
		    });
		    AlertDialog alert = builder1.create();
		    alert.show();
   	}
   	
   	/*
   	 * Consulta Asincronica Actualizar Inventario
   	 */
   	
   	private class Consulta_Upd_Inventario extends AsyncTask<String,Integer,String> {
   		
   		private final ProgressDialog dialog = new ProgressDialog(Instalacion.this);
   		
 		protected void onPreExecute() {
 			this.dialog.setMessage("Actualizando Equipo del Cliente");
 			this.dialog.setCanceledOnTouchOutside(false);
 			this.dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
				
				@Override
				public void onCancel(DialogInterface dialog) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "Operación Interrumpida.", Toast.LENGTH_LONG).show();
					Instalacion.this.finish();
				}
			});
 		    this.dialog.show();
             //super.onPreExecute();
         }
   		 
   	    protected String doInBackground(String... params) {
   	    	
 			String respuesta = null;
   			
   			try {
   				inventarioCorrecto = false;
   				TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
   				String IMEI = telephonyManager.getDeviceId();
   				String IMSI =  telephonyManager.getSimSerialNumber();
   				
   				respuesta = SoapRequestMovistar.setInventoryUpdate(Area.getText().toString(), Phone.getText().toString(),tipoInventario, modeloInventario, IMEI, IMSI);
   				if(Integer.valueOf(XMLParser.setUpdateInventory(respuesta).get(0)) == 0)
				{	//Actualizó correctamente									
					inventarioCorrecto = true;
				}						
   				else
   				{
   					inventarioCorrecto = false;   					
   				}
   				
   			} catch (Exception e1) {
   				e1.printStackTrace();
   			}   			
   	        return respuesta;
   	    }
   	    

 		protected void onPostExecute(String result) {
 			
 			if (this.dialog.isShowing()) {
 		        this.dialog.dismiss();
 		     }   
 			if(inventarioCorrecto == true)
 			{
 				Toast.makeText(getApplicationContext(), "Inventario Actualizado", Toast.LENGTH_LONG).show();
 				if(tipoInventario == "DECO")
 				{
 					items.get(decoSelected).setDescription(modeloInventario);
 					television_Satelital();
 				}
 				else if(tipoInventario == "MODEM")
 				{
 					bandaAnchaModelo.setText(modeloInventario); 					
 				}
 			}
 			else
 			{
 				Toast.makeText(getApplicationContext(), "Error al Actualizar Inventario", Toast.LENGTH_LONG).show();
 				
 			}
   	    }
   	}
   	
	
	/*
   	 * Consulta Asincronica CERTIFY DSL
   	 */
   	
   	private class Consulta_Certify_DSL extends AsyncTask<String,Integer,String> {
   		
   		private final ProgressDialog dialog = new ProgressDialog(Instalacion.this);
   		
 		protected void onPreExecute() {
 			this.dialog.setMessage("Midiendo descarga y certificando línea telefónica");
 			this.dialog.setCanceledOnTouchOutside(false);
 			this.dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
				
				@Override
				public void onCancel(DialogInterface dialog) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "Operación Interrumpida.", Toast.LENGTH_LONG).show();
					Instalacion.this.finish();
				}
			});
 		    this.dialog.show();
             //super.onPreExecute();
         }
   		 
   	    protected String doInBackground(String... params) {
   	    	
 			String respuesta = null;
   			
   			try {   
   				
   				startDownload();
   	       		muestra_descarga(0);
   	       		
   	       		startUpload();
   	       		muestra_carga(0);
   				
   				
   				TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
   				String IMEI = telephonyManager.getDeviceId();
   				String IMSI =  telephonyManager.getSimSerialNumber();
   				certifyDslCorrecto = false;
   				respuesta = SoapRequestMovistar.getCertifyDSL(Area.getText().toString(), Phone.getText().toString(),IMEI, IMSI);
//   				if(Integer.valueOf(XMLParser.getCertifyDsl(respuesta).get(0)) == 0)
//				{	//Actualizó correctamente									
//					certifyDslCorrecto = true;
//				}						
//   				else
//   				{
//   					certifyDslCorrecto = false;   					
//   				}
   				res = XMLParser.getCertification(respuesta);
   				if(res.get(0).split(";")[0].compareTo("0")==0){
   					certifyDslCorrecto = true;
   				}
   				
   				
   			} catch (Exception e1) {
   				e1.printStackTrace();
   			}   			
   	        return respuesta;
   	    }
   	    

 		protected void onPostExecute(String result) {
 			
 			if (this.dialog.isShowing()) {
 		        this.dialog.dismiss();
 		     }   
 			if(certifyDslCorrecto == true)
 			{ 				 
 				items_certify = new ArrayList<itemList>();
 				Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ok); 		
 				ib1.setImageBitmap(bmp);
 				//String linea="";
 				for(int i = 1; i<res.size();i++){ 						
 					if(res.get(i).split(";")[1].compareTo("OK") == 0)
 						items_certify.add(new itemList(res.get(i).split(";")[0],"",R.drawable.ok));
 					else{
 						items_certify.add(new itemList(res.get(i).split(";")[0],"",R.drawable.error));
 						certifyDslCorrecto = false;
 					}
 				}
 				
 				
 				listView = (ListView) findViewById(R.id.listviewCertify);
 				listAdapter adapter = new listAdapter(getApplicationContext(), items_certify);
 				
 			    listView.setAdapter(adapter);
 			    listView.setOnItemClickListener(new OnItemClickListener() {
 			    	  @Override
 			    	  public void onItemClick(AdapterView<?> parent, View view,
 			    	    int position, long id) {
// 			    	    Toast.makeText(getApplicationContext(),
// 			    	      "Click ListItem Number " + position, Toast.LENGTH_LONG)
// 			    	      .show();
 			    		  decoSelected = position;
 			    		  Toast.makeText(getApplicationContext(), res.get(position+1).split(";")[0]+":\n"+res.get(position+1).split(";")[3], Toast.LENGTH_LONG).show();
 			    		  
 			    	  }
 			    	});
 			   if(certifyDslCorrecto == false)
 	 			{
 				   Bitmap bmp2 = BitmapFactory.decodeResource(getResources(), R.drawable.error);
 				   ib1.setImageBitmap(bmp2);
 				   //finalizar.setEnabled(false);
 				   //Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
 	 			}
 				
 				//Toast.makeText(getApplicationContext(), "asd1"+linea, Toast.LENGTH_LONG).show();
 			}
 			else
 			{ 				
 				Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.error); 				 				 
 				ib1.setImageBitmap(bmp);
 				finalizar.setEnabled(false);
 				Toast.makeText(getApplicationContext(), "No se pudo realizar la certificacion.", Toast.LENGTH_LONG).show();
 				
 			}
 			//Toast.makeText(getApplicationContext(), "Certificación Finalizada", Toast.LENGTH_SHORT).show();
   	    }
   	}

}
