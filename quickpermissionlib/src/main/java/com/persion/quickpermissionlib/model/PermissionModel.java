package com.persion.quickpermissionlib.model;

/**
 * Created by Korir on 10/15/19.
 * amoskrr@gmail.com
 */
public class PermissionModel {
  public String persmission;
  public String permissionCode;

  public PermissionModel() {
  }

  private PermissionModel(Builder builder) {
    setPersmission(builder.persmission);
    setPermissionCode(builder.permissionCode);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getPersmission() {
    return persmission;
  }

  public void setPersmission(String persmission) {
    this.persmission = persmission;
  }

  public String getPermissionCode() {
    return permissionCode;
  }

  public void setPermissionCode(String permissionCode) {
    this.permissionCode = permissionCode;
  }

  public static final class Builder {
    private String persmission;
    private String permissionCode;

    private Builder() {
    }

    public Builder withPersmission(String val) {
      persmission = val;
      return this;
    }

    public Builder withPermissionCode(String val) {
      permissionCode = val;
      return this;
    }

    public PermissionModel build() {
      return new PermissionModel(this);
    }
  }
}
