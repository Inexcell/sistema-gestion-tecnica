package cl.inexcell.sistemadegestion;

import java.util.List;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
 
@SuppressLint("UseValueOf")
public class Certificar_Wifi extends Activity {
     
    TextView mainText;
    WifiManager mainWifi;
    WifiReceiver receiverWifi;
    List<ScanResult> wifiList;
    StringBuilder sb = new StringBuilder();
     
    public void onCreate(Bundle savedInstanceState) {
         
       super.onCreate(savedInstanceState);
        
       setContentView(R.layout.activity_certificar_wifi);
       mainText = (TextView) findViewById(R.id.mainText);
        
       // Initiate wifi service manager
       mainWifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        
       // Check for wifi is disabled
       if (mainWifi.isWifiEnabled() == false)
            {   
                // If wifi disabled then enable it
                Toast.makeText(getApplicationContext(), "Wifi esta desactivado. Activelo en las opciones de su Smartphone por favor", 
                Toast.LENGTH_LONG).show();
                 
                mainWifi.setWifiEnabled(true);
            } 
        
       // wifi scaned value broadcast receiver 
       receiverWifi = new WifiReceiver();
        
       // Register broadcast receiver 
       // Broacast receiver will automatically call when number of wifi connections changed
       registerReceiver(receiverWifi, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
       mainWifi.startScan();
       mainText.setText("Buscando redes inalambricas ...");
    }
 
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 0, 0, "Actualizar");
        return super.onCreateOptionsMenu(menu);
    }
 
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        mainWifi.startScan();
        mainText.setText("Buscando Redes Inalambricas");
        return super.onMenuItemSelected(featureId, item);
    }
 
    protected void onPause() {
        unregisterReceiver(receiverWifi);
        super.onPause();
    }
 
    protected void onResume() {
        registerReceiver(receiverWifi, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        super.onResume();
    }
     
    // Broadcast receiver class called its receive method 
    // when number of wifi connections changed
     
    class WifiReceiver extends BroadcastReceiver {
         
        // This method call when number of wifi connections changed
        public void onReceive(Context c, Intent intent) {
             
            sb = new StringBuilder();
            wifiList = mainWifi.getScanResults(); 
            sb.append("Se han encontrado "+wifiList.size()+" redes inalambricas:\n\n");
             
            for(int i = 0; i < wifiList.size(); i++){
                 
                sb.append(new Integer(i+1).toString() + ".\n");
                sb.append((wifiList.get(i)).toString().split(",")[0]+"\n");
                //sb.append((wifiList.get(i)).toString().split(",")[1]+"\n");
                //sb.append((wifiList.get(i)).toString().split(",")[2]+"\n");
                sb.append((wifiList.get(i)).toString().split(",")[3]+" dBm\n");
                sb.append((wifiList.get(i)).toString().split(",")[4]+" GHz\n");
                //sb.append((wifiList.get(i)).toString());
                sb.append("\n");
            }
             
            mainText.setText(sb);  
        }
         
    }
    
    public void volver(View view) {
    	finish();
    	
    	// Vibrar al hacer click        
        Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(50);
    }
}