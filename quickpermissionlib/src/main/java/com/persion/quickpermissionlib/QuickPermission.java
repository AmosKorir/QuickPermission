package com.persion.quickpermissionlib;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

/**
 * Created by Korir on 10/15/19.
 * amoskrr@gmail.com
 */
public class QuickPermission {
  private Activity activity;
  private String permission;
  private int permissionCode;
  private QuickPermissionListener permissionListener;

  public QuickPermission() {
  }

  public QuickPermission(Activity activity) {
    this.activity = activity;
  }

  public static QuickPermission newInstance(Activity activity) {
    QuickPermission quickPermission = new QuickPermission();
    quickPermission.setActivity(activity);
    return quickPermission;
  }

  public void onPermissionListener(QuickPermissionListener quickPermissionListener) {
    this.permissionListener = quickPermissionListener;
  }

  private void setActivity(Activity activity) {
    this.activity = activity;
  }

  //request for permission
  public boolean requestPermission(String permission, int permissionCode) {
    if (ContextCompat.checkSelfPermission(activity,
        Manifest.permission.READ_CONTACTS)
        != PackageManager.PERMISSION_GRANTED) {

      ActivityCompat.requestPermissions(activity,
          new String[] { permission },
          permissionCode);
    } else {
      return true;
    }
    return false;
  }

  //check if permission is granted
  //return boolean
  public boolean isGranted(String permission) {
    if (ContextCompat.checkSelfPermission(activity, permission)
        == PackageManager.PERMISSION_GRANTED) {
      return true;
    } else {
      return false;
    }
  }

  public void quick(String permission, int permissionCode,
      QuickPermissionListener permissionListener) {
    this.permissionCode = permissionCode;
    this.permissionListener = permissionListener;
    this.permission = permission;

    if (!isGranted(permission)) {
      requestPermission(permission, permissionCode);
    } else {
      permissionListener.permissionGranted();
    }
  }

  public void quickResult(int requestCode, String[] permissions, int[] grantResults) {

    if (requestCode == permissionCode) {

      if (grantResults.length > 0
          && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
        permissionListener.permissionGranted();
      } else {
        permissionListener.permissionGranted();
      }
      return;
    }
  }
}






