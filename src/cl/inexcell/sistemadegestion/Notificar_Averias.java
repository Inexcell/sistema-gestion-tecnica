package cl.inexcell.sistemadegestion;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Notificar_Averias extends Activity {
	private String observacion, objeto;
	private Bitmap foto;
	private Spinner s;
	private EditText et;
	private ImageButton ib;
	private String TAG = "Localizar Avería";
	private Bitmap b = null, bmini = null;
	private static int TAKE_PICTURE = 1;
	private static int SELECT_PICTURE = 2;
	final CharSequence[] opcionCaptura = {
    		"Tomar Fotografía"
    };
	final CharSequence[] SpinnerText = {
    		"Cable", "Armario","Caja","Tablero"
    };
	private String name = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		// Activity sin parte superior
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_notificar_averias);
		
		s = (Spinner) findViewById(R.id.Spinner02);
		et = (EditText) findViewById(R.id.editText1);
		ib = (ImageButton) findViewById(R.id.ibtnImagen);
		name = Environment.getExternalStorageDirectory() + "/test.jpg";
	}
	
	/** Boton Guardar Información **/
	public void guardarInformacion (View view){
		observacion = et.getText().toString();
		objeto = SpinnerText[s.getSelectedItemPosition()].toString();
		foto = b;
		
		Drawable d = new BitmapDrawable(getResources(), b);
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(SpinnerText[s.getSelectedItemPosition()]);
        builder.setMessage(et.getText());
        builder.setIcon(d);
        
        AlertDialog alert = builder.create();
        alert.show();
	}
	
	/** Botón Cámara **/
	public void capturarImagen(View view){
		
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
	}
	
	@Override 
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (requestCode == TAKE_PICTURE) {
	    	if (data != null) {
	    		if (data.hasExtra("data")) {
	    		    b = (Bitmap) data.getParcelableExtra("data");
	    		}
	    	} else {
	    			b = BitmapFactory.decodeFile(name);
	    			
	    		}
	    } else if (requestCode == SELECT_PICTURE){
	    	Uri selectedImage = data.getData();
	    	InputStream is;
	    	try {
	    	    is = getContentResolver().openInputStream(selectedImage);
	    	    BufferedInputStream bis = new BufferedInputStream(is);
	    	    b = BitmapFactory.decodeStream(bis);
	    	    
	    	} catch (FileNotFoundException e) {}
	    }
	    bmini = Bitmap.createScaledBitmap(b, 64, 64, true);
	    
	    
	}
	
	/** Boton Volver **/
	public void volver(View view) {
    	finish();
    	
    	// Vibrar al hacer click        
        Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(50);
    }

}
