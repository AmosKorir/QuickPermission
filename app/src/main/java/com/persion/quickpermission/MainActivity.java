package com.persion.quickpermission;

import android.Manifest;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.persion.quickpermissionlib.QuickPermission;
import com.persion.quickpermissionlib.QuickPermissionListener;

public class MainActivity extends AppCompatActivity {
  QuickPermission quickPermission;
  Button permissionButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    quickPermission = new QuickPermission(this);
    permissionButton = findViewById(R.id.permissionBtn);

    permissionButton.setOnClickListener(v -> quickPermission.quick(Manifest.permission.CAMERA, 200, new QuickPermissionListener() {
      @Override public void permissionGranted() {
        Toast.makeText(MainActivity.this, "Permission granted", Toast.LENGTH_SHORT).show();
      }

      @Override public void permissionDenied() {
        Toast.makeText(MainActivity.this, "permission denied", Toast.LENGTH_SHORT).show();
      }
    }));
  }

  @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    quickPermission.quickResult(requestCode, permissions, grantResults);
  }
}
