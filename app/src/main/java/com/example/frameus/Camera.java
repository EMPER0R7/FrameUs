package com.example.frameus;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.frameus.databinding.ActivityCameraBinding;

public class Camera extends AppCompatActivity {
    ActivityCameraBinding binding;
    public ImageView pst;
    private Button btn;


    static final int REQUEST_IMG_CAPTURE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCameraBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        pst=findViewById(R.id.post);

        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               CaptureImage();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){
//            if(resultCode==REQUEST_IMG_CAPTURE){
              Bitmap img=(Bitmap)  data.getExtras().get("data");
                pst.setImageBitmap(img);
//            }
        }
    }
    //    private boolean CheckPermission(){
//        int cameraPermission= ContextCompat.checkSelfPermission(getApplicationContext(),CAMERA_SERVICE);
//        return cameraPermission== PackageManager.PERMISSION_GRANTED;
//    }
//
//    private void RequestPermission(){
//        int PERMISSION_CODE=200;
//        ActivityCompat.requestPermissions(this,new String[]{
//                Manifest.permission.
//        },PERMISSION_CODE);
//    }

    private void CaptureImage() {

    Intent takePicture=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    if(takePicture.resolveActivity(getPackageManager())!=null){
        startActivityForResult(takePicture,REQUEST_IMG_CAPTURE);
    }

}}