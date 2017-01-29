package com.example.android.androidsensortestcode;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
/*
* created by yuvaram singh
* yuvaramsingh94@gmail.com
* */
public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager senseManager;
    // initialization of textview
    TextView xValue;
    TextView yValue;
    TextView zValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        senseManager = (SensorManager)this.getSystemService(SENSOR_SERVICE); // initialization of sensorManager

        Sensor linearAcceleration;


        // use this link to know more
        //https://developer.android.com/guide/topics/sensors/sensors_motion.html

        linearAcceleration = senseManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION); // initialization of LINEAR_ACCELERATION

        //TYPE_LINEAR_ACCELERATION can be changed with the desired value
        //eg
        //TYPE_ACCELEROMETER
        //TYPE_GRAVITY
        //TYPE_GYROSCOPE
        //etc

        senseManager.registerListener(this,linearAcceleration,SensorManager.SENSOR_DELAY_NORMAL);

    }



    @Override
    public void onSensorChanged(SensorEvent event) {
        /*
        * you can see the log message printed to the android monitor
        * */
        Log.v("MainActivity","Value of X: "+event.values[0]);
        Log.v("MainActivity","Value of Y: "+event.values[1]);
        Log.v("MainActivity","Value of Z: "+event.values[2]);

        xValue = (TextView)findViewById(R.id.xTextView);
        yValue = (TextView)findViewById(R.id.yTextView);
        zValue = (TextView)findViewById(R.id.zTextView);

        xValue.setText(Float.toString(event.values[0]));
        yValue.setText(Float.toString(event.values[1]));
        zValue.setText(Float.toString(event.values[2]));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}