package com.example.projetsession;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.FileUtils;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.projetsession.retrofit.InterfaceServeur;
import com.example.projetsession.retrofit.RetrofitInstance;

import java.io.File;
import java.security.Permissions;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class SauvegarderPhoto extends AppCompatActivity {
    Button btnUpload,btnGallery;
    ImageView imgHolder;
    String part_image;
    ProgressDialog dp;
    final int REQUEST_GALLERY = 9544;

  private static final int PERMISSIONS_REQUEST = 100;
  private int PICK_IMAGE_FROM_GALLERY_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sauvegarder_photo);


        if (ContextCompat.checkSelfPermission(SauvegarderPhoto.this,
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(SauvegarderPhoto.this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},PERMISSIONS_REQUEST);
        }



        btnGallery = findViewById(R.id.btngallery);
        btnUpload = findViewById(R.id.btnupload);
        imgHolder = findViewById(R.id.imgholder);
        dp = new ProgressDialog(this);
        dp.setMessage("loading...");

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Open gallery"),REQUEST_GALLERY);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RESULT_OK){
            if(requestCode == REQUEST_GALLERY){
                Uri dataimage = data.getData();
                String[] imagearray = {MediaStore.Images.Media.DATA};
                Cursor cursor = getContentResolver().query(dataimage,imagearray,
                        null,null,null);
                if(cursor != null){
                    cursor.moveToFirst();
                    int indeximage = cursor.getColumnIndex(imagearray[0]);
                    part_image = cursor.getString(indeximage);

                    if(part_image != null){
                        File image = new File(part_image);
                        imgHolder.setImageBitmap(BitmapFactory.decodeFile(image.getAbsolutePath()));

                    }
                }
            }
        }
    }



/*
    private void uploadFile(Uri fileUri) {
        // create upload service client
        InterfaceServeur service =
                RetrofitInstance.getInstance().create(InterfaceServeur.class);

        // https://github.com/iPaulPro/aFileChooser/blob/master/aFileChooser/src/com/ipaulpro/afilechooser/utils/FileUtils.java
        // use the FileUtils to get the actual file by uri
        File file = FileUtils.getFile(this, fileUri);

        // create RequestBody instance from file
        RequestBody requestFile =
                RequestBody.create(
                        MediaType.parse(getContentResolver().getType(fileUri)),
                        file
                );

        // MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("picture", file.getName(), requestFile);

        // add another part within the multipart request
        String descriptionString = "hello, this is description speaking";
        RequestBody description =
                RequestBody.create(
                        MultipartBody.FORM, descriptionString);

        // finally, execute the request
        Call<ResponseBody> call = service.uploadImage(description, body);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call,
                                   Response<ResponseBody> response) {
                Log.v("Upload", "success");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("Upload error:", t.getMessage());
            }
        });
    }

*/




}