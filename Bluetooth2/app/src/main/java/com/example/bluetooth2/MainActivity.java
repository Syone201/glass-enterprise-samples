package com.example.bluetooth2;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    Button connect;
    ConnectThread mConnectThread;
    BluetoothAdapter mAdapter = BluetoothAdapter.getDefaultAdapter();
    BluetoothDevice device;
    private String TAG = "BLUETOOTH_DEVICES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connect = (Button) findViewById(R.id.connect);

        if (mAdapter == null) {
            // Device doesn't support Bluetooth
            Log.d(TAG,"Your device does not support the Bluetooth Protocol.");
        } else {
            Log.d(TAG, "Bluetooth is supported on this device.");

            // Check the Bluetooth Adapter is enabled.

            if (!mAdapter.isEnabled()) {
                Log.d(TAG, "The Bluetooth Adapter is not enabled, starting enable.");

            } else {
                Log.d(TAG,"Your Bluetooth Adapter is enabled and ready.");
            }

            connect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Button clicked, starting connect process.");
                    mConnectThread = new ConnectThread(device);
                    mConnectThread.start();
                }
            });
        }
    }
}

class ConnectThread extends Thread {

    private final BluetoothSocket mmSocket;
    private final BluetoothDevice mmDevice;
    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private String TAG = "BLUETOOTH_DEVICES";

    public ConnectThread(BluetoothDevice device) {
        BluetoothSocket tmp = null;
        mmDevice = device;

        try {
            Log.e(TAG, "starting connect");
            tmp = device.createRfcommSocketToServiceRecord(MY_UUID);
        } catch (IOException e) {
            Log.e("BLUETOOTH_DEVICES", "open socket() failed.", e);
        }
        mmSocket = tmp;
    }

    public void run() {
        // Cancel discovery because it otherwise slows down the connection.
        BluetoothAdapter mAdapter = null;
        assert mAdapter != null;
        mAdapter.cancelDiscovery();

        try {
            // Connect to the remote device through the socket. This call blocks
            // until it succeeds or throws an exception.
            Log.e(TAG, "connect() call started.");
            mmSocket.connect();
        } catch (IOException connectException) {
            // Unable to connect; close the socket and return.
            try {
                mmSocket.close();
            } catch (IOException closeException) {
                Log.e(TAG, "Could not close the client socket", closeException);
            }
            return;
        }

        // The connection attempt succeeded. Perform work associated with
        // the connection in a separate thread.
        //manageMyConnectedSocket(mmSocket);
    }

    // Closes the client socket and causes the thread to finish.
    public void cancel() {
        try {
            mmSocket.close();
        } catch (IOException e) {
            Log.e(TAG, "Could not close the client socket", e);
        }
    }
}