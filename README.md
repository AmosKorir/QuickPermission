# QuickPermission

[ ![Download](https://api.bintray.com/packages/skyways/QuickPermission/QuickPermission/images/download.svg) ](https://bintray.com/skyways/QuickPermission/QuickPermission/_latestVersion)

This a simple android library that make it easy to request run-time permission.

installation


Usage
```
 QuickPermission quickPermission;
 
 quickPermission = new QuickPermission(this);
 
   quickPermission.quick(Manifest.permission.CAMERA, 200, new QuickPermissionListener() {
          @Override public void permissionGranted() {
            Toast.makeText(MainActivity.this, "Permission granted", Toast.LENGTH_SHORT).show();
          }

          @Override public void permissionDenied() {
            Toast.makeText(MainActivity.this, "permission denied", Toast.LENGTH_SHORT).show();
          }
        }));
 
 
 ```
 finally
 
 ```
  @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    quickPermission.quickResult(requestCode, permissions, grantResults);
  }
 ```

