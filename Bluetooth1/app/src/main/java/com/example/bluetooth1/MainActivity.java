package com.example.bluetooth1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    Button connect;

    private static final int REQUEST_ENABLE_BT = 1;
    private static final UUID MY_UUID = UUID.fromString("d64ea317-c4e8-4af4-89a7-b75901ea707e");
    private static final String APP_NAME = "Bluetooth1";
    
    // Constants that indicate the current connection state
    public static final int STATE_NONE = 0;       // we're doing nothing
    public static final int STATE_LISTEN = 1;     // now listening for incoming connections
    public static final int STATE_CONNECTING = 2; // now initiating an outgoing connection
    public static final int STATE_CONNECTED = 3;  // now connected to a remote device

    BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connect = (Button) findViewById(R.id.connect);

        // Check if there is a default Bluetooth Adapter

        if (bluetoothAdapter == null) {
            // Device doesn't support Bluetooth
            Log.d("BLUETOOTH_DEVICES","Your device does not support the Bluetooth Protocol.");
        } else {
            Log.d("BLUETOOTH_DEVICES", "Bluetooth is supported on this device.");

            // Check the Bluetooth Adapter is enabled.

            if (!bluetoothAdapter.isEnabled()) {
                Log.d("BLUETOOTH_DEVICES", "The Bluetooth Adapter is not enabled, starting enable.");
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            } else {
                Log.d("BLUETOOTH_DEVICES","Your Bluetooth Adapter is enabled and ready.");
            }

            // Check for paired devices on the local device.

            Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();

            if (pairedDevices.size() > 0) {
                // There are paired devices. Get the name and address of each paired device.
                for (final BluetoothDevice device : pairedDevices) {
                    String deviceName = device.getName();
                    String deviceHardwareAddress = device.getAddress(); // MAC address

                    Log.d("BLUETOOTH_DEVICES", "PAIRED device name is: " + deviceName);
                    Log.d("BLUETOOTH_DEVICES", "PAIRED device HW Address is: " + deviceHardwareAddress);

                    //Try and Connect to device by clicking connect button.

                    connect.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ClientThread mClientThread;
                            mClientThread = new ClientThread();
                            mClientThread.start();
                        }
                    });
                 }
            } else {
                Log.d("BLUETOOTH_DEVICES", "There are no paired bluetooth devices, starting discovery.");
                // bluetoothAdapter.startDiscovery();
            }
        }
    }

    public class ClientThread extends Thread {
        private final BluetoothSocket mmSocket;
        private final BluetoothDevice mmDevice;

        private class ConnectThread extends Thread {
            private final BluetoothSocket mmSocket;
            private final BluetoothDevice mmDevice;

            public ConnectThread(BluetoothDevice device) {
                mmDevice = device;
                BluetoothSocket tmp = null;

                // Get a BluetoothSocket for a connection with the
                // given BluetoothDevice
                try {
                    tmp = device.createRfcommSocketToServiceRecord(MY_UUID);
                } catch (IOException e) {
                    Log.e(TAG, "create() failed", e);
                }
                mmSocket = tmp;
            }

            public void run() {
                Log.i(TAG, "BEGIN mConnectThread");
                setName("ConnectThread");

                // Always cancel discovery because it will slow down a connection
                mAdapter.cancelDiscovery();

                // Make a connection to the BluetoothSocket
                try {
                    // This is a blocking call and will only return on a
                    // successful connection or an exception
                    mmSocket.connect();
                } catch (IOException e) {
                    e.printStackTrace();
                    connectionFailed();
                    // Close the socket
                    try {
                        mmSocket.close();
                    } catch (IOException e2) {
                        Log.e(TAG, "unable to close() socket during connection failure", e2);
                    }
                    // Start the service over to restart listening mode
                    BluetoothCommandService.this.start();
                    return;
                }

                // Reset the ConnectThread because we're done
                synchronized (BluetoothCommandService.this) {
                    mConnectThread = null;
                }

                // Start the connected thread
                connected(mmSocket, mmDevice);
            }

            public void cancel() {
                try {
                    mmSocket.close();
                } catch (IOException e) {
                    Log.e(TAG, "close() of connect socket failed", e);
                }
            }
        }
    }
}



