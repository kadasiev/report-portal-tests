package api;

import static util.TestDataReader.getValue;

import io.restassured.RestAssured;

public class BaseApi {

  static {
    RestAssured.baseURI = getValue("baseURL");
  }
}
