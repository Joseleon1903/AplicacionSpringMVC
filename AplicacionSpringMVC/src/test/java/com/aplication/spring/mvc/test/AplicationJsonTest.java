package com.aplication.spring.mvc.test;

public class AplicationJsonTest {

	public static void main(String[] args) {
//		System.out.println("Inciando el metodo main AplicationJsonTest...");
//		String output = null;
//		URL url;
//		URL url2;
//		try {
//			url = new URL("http://localhost:8081/AplicacionWebRestHtml/rest/motivoEstado/buscarListaMotivosEstadoSistema");
//			url2 = new URL("http://localhost:8081/AplicacionWebRestHtml/rest/motivoEstado/buscarListaMotivosEstadoSistemaArray");
//			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//			conn.setRequestMethod("GET");
//			conn.setRequestProperty("Accept", "application/json");
//			if (conn.getResponseCode() != 200) {
//				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
//			}
//			System.out.println("URL 1: " + url.toString());
//			System.out.println("URL 2: " + url2.toString());
//			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
//			System.out.println("Consultado respuesta entera..");
//			System.out.println("*********************-----------------------End--------------------***************************");
//			System.out.println("***************************" + url.toString());
//			manejandoJsonJavaApi(output, url2);
//			System.out.println("*********************-----------------------End--------------------***************************");
//			System.out.println("***************************" + url2.toString());
//			manejandoJsonJavaApi2(output, url);
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

//	public static void manejandoJsonJavaApi(String output, URL url) throws JsonSyntaxException, IOException {
//
//		InputStream inputStream = url.openStream();
//		JsonReader rdr = Json.createReader(inputStream);
//		 JsonObject obj = rdr.readObject();
//		JsonArray results = rdr.readArray();
//		 //JsonArray results = rdr.readArray();
//		for (JsonObject result : results.getValuesAs(JsonObject.class)) {
//			System.out.print(result.getJsonNumber("motivoId"));
//			System.out.print(": ");
//			System.out.println(result.getString("descripcion"));
//			System.out.println("-----------");
//		}
//	}
//
//	public static void manejandoJsonJavaApi2(String output, URL url) throws JsonSyntaxException, IOException {
//
//		InputStream inputStream = url.openStream();
//		JsonReader rdr = Json.createReader(inputStream);
//		JsonObject obj = rdr.readObject();
//		JsonArray results = obj.getJsonArray("respuesta");
//		for (JsonObject result : results.getValuesAs(JsonObject.class)) {
//			System.out.print(result.getJsonNumber("motivoId"));
//			System.out.print(": ");
//			System.out.println(result.getString("descripcion"));
//			System.out.println("-----------");
//		}
//	}

}
