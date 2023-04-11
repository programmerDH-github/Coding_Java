package com.bside.BSIDE14_3.common.domain;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class StatusCode implements Serializable {
  private static final long serialVersionUID = -6868102093961669882L;
  public static final int OK = 200;
  public static final int CREATED = 201;
  public static final int NO_CONTENT = 204;
  public static final int BAD_REQUEST = 400;
  public static final int UNAUTHORIZED = 401;
  public static final int FORBIDDEN = 403;
  public static final int NOT_FOUND = 404;
  public static final int INTERNAL_SERVER_ERROR = 500;
  public static final int SERVICE_UNAVAILABLE = 503;
  public static final int DB_ERROR = 600;
}
