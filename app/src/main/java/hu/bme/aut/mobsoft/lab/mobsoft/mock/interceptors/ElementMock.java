package hu.bme.aut.mobsoft.lab.mobsoft.mock.interceptors;

import android.net.Uri;

import hu.bme.aut.mobsoft.lab.mobsoft.network.NetworkConfig;
import hu.bme.aut.mobsoft.lab.mobsoft.repository.MemoryRepository;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static hu.bme.aut.mobsoft.lab.mobsoft.mock.interceptors.MockHelper.makeResponse;

public class ElementMock {
	public static Response process(Request request) {
		Uri uri = Uri.parse(request.url().toString());

		String responseString;
		int responseCode;
		Headers headers = request.headers();


		if (uri.getPath().equals(NetworkConfig.ENDPOINT_ADDRESS + "/?s=a&type=movie&page=1") && request.method().equals("GET")) {
			MemoryRepository memoryRepository = new MemoryRepository();
			memoryRepository.open(null);
			//responseString = GsonHelper.getGson().toJson(memoryRepository.getFavourites());
			responseCode = 200;
		} else if (uri.getPath().equals(NetworkConfig.ENDPOINT_ADDRESS + "?i=tt0364725") && request.method().equals("GET")) {

			responseCode = 200;
		} else {
			responseString = "ERROR";
			responseCode = 503;
		}

		return makeResponse(request, headers, responseCode, "");// responseString);
	}
}
