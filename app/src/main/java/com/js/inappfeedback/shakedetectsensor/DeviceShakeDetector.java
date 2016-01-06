package com.js.inappfeedback.shakedetectsensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by sowmia on 17/12/15.
 */
public class DeviceShakeDetector  implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mSensor;
    private DeviceShakeListener mDeviceShakeListener;


    private long mLastTime;
    private float last_x;
    private float last_y;
    private float last_z;
    private float SHAKE_THRESHOLD =100;
    private Context mContext;

    public DeviceShakeDetector(Context context, DeviceShakeListener mDeviceShakeListener) {
        this.mContext = context;
        this.mDeviceShakeListener = mDeviceShakeListener;
        mSensorManager = (SensorManager)context.getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener((SensorEventListener) this, mSensor ,20);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        long currentTime = System.currentTimeMillis();
        if(currentTime - mLastTime >100){
            long diffTime = (currentTime - mLastTime);
            mLastTime = currentTime;

            float x = event.values[SensorManager.DATA_X];
            float y = event.values[SensorManager.DATA_Y];
            float z = event.values[SensorManager.DATA_Z];

            float speed = Math.abs(x+y+z - last_x - last_y - last_z) / diffTime * 10000;

            if (speed >= SHAKE_THRESHOLD) {
                Log.d("sensor", "shake detected w/ speed: " + speed);
                Toast.makeText(mContext, "shake detected w/ speed: " + speed, Toast.LENGTH_SHORT).show();
                if(mDeviceShakeListener != null){
                    mDeviceShakeListener.onShakeOfDevice();
                }
            }
            last_x = x;
            last_y = y;
            last_z = z;
        }
    }



    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public interface DeviceShakeListener{
        public void onShakeOfDevice();
    }
}
