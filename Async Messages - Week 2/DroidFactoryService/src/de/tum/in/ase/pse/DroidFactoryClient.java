package de.tum.in.ase.pse;



import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public final class DroidFactoryClient {

	private final RestTemplate rest;
	private static final String BASE_URL = "http://localhost:8080/droid/";
	private static final String R_2 = "r2";
	private static final String THREE_PO = "3po";

	public DroidFactoryClient() {
		this.rest = new RestTemplate();
	}


	public Droid produceR2() {
		var request = createHttpEntity(Droids.R2);
		return rest.postForObject(BASE_URL + R_2, request, Droid.class);
	}

	public Droid produce3PO() {
		var request = createHttpEntity(Droids.THREE_PO);
		return rest.postForObject(BASE_URL + THREE_PO, request, Droid.class);
	}

	//TODO 2.2: remove the old methods for producing droids and implement the async version
	public void produceR2Async(InboxClient client) {

	}

	//TODO 2.2: remove the old methods for producing droids and implement the async version
	public void produce3POAsync(InboxClient client) {

	}

	private HttpEntity<String> createHttpEntity(Droids droid) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new HttpEntity<>(Serialization.serializeDroid(droid), headers);
	}


}
