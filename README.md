<img src="https://github.com/skyways/QuickPermission/blob/master/app/src/main/res/drawable-v24/quickpermission.png"/>

# QuickPermission

[ ![Download](https://api.bintray.com/packages/skyways/QuickPermission/QuickPermission/images/download.svg) ](https://bintray.com/skyways/QuickPermission/QuickPermission/_latestVersion)

This a simple android library that make it easy to request run-time permission.

## installation
```java
 implementation 'com.persion.quickpermissionlib:QuickPermission:0.0.1'
 
 ```
## Add permission to manifest.
 here is an example.
 ```java
 <manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.persion.quickpermission">

  <uses-permission android:name="android.permission.CAMERA"/>

  <application
  ....
 ```

## Usage
```java
 QuickPermission quickPermission;
 
 quickPermission = new QuickPermission(this);
 
   quickPermission.quick(Manifest.permission.CAMERA, 200, new QuickPermissionListener() {
          @Override public void permissionGranted() {
            Toast.makeText(MainActivity.this, "Permission granted", Toast.LENGTH_SHORT).show();
          }

          @Override public void permissionDenied() {
            Toast.makeText(MainActivity.this, "permission denied", Toast.LENGTH_SHORT).show();
          }
            @Override public void showRationale() {
            Toast.makeText(MainActivity.this, "the reason permission is required",
                Toast.LENGTH_SHORT).show();
          }
          
        }));
 
 
 ```
## finally
 
 ```java
  @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    quickPermission.quickResult(requestCode, permissions, grantResults);
  }
 ```

