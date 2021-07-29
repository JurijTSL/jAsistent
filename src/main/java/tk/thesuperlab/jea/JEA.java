package tk.thesuperlab.jea;

import okhttp3.*;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import tk.thesuperlab.jea.entities.Evaluation;
import tk.thesuperlab.jea.entities.Grade;
import tk.thesuperlab.jea.entities.Semester;
import tk.thesuperlab.jea.entities.Subject;
import tk.thesuperlab.jea.exceptions.IncorrectCredentialsException;
import tk.thesuperlab.jea.utils.RestUtils;

import java.util.ArrayList;

public class JEA {
	private String uporabniskoIme;
	private String geslo;

	String bearerToken;
	String childId;

	public JEA(String uporabniskoIme, String geslo) throws IncorrectCredentialsException {
		this.uporabniskoIme = uporabniskoIme;
		this.geslo = geslo;

		try {
			getAccessToken();
		} catch(IncorrectCredentialsException e) {
			throw new IncorrectCredentialsException();
		}
	}

	public void klic() {
		System.out.println(RestUtils.getSchedule(bearerToken, childId));
	}

	private void getAccessToken() throws IncorrectCredentialsException {
		OkHttpClient client = new OkHttpClient();

		RequestBody body = new FormBody.Builder()
				.add("uporabnik", uporabniskoIme)
				.add("geslo", geslo)
				.build();

		Request request = new Request.Builder()
				.url("https://www.easistent.com/p/ajax_prijava")
				.post(body)
				.build();

		try (Response response = client.newCall(request).execute()) {
			String easistentResponse = response.body().string();
			JSONObject jsonDocument = new JSONObject(easistentResponse);
			String authStatus = jsonDocument.getString("status");

			if(authStatus.equals("ok")) {
				Request getWebsite = new Request.Builder().url("https://www.easistent.com").addHeader("Cookie", response.headers().get("Set-Cookie")).build();

				try (Response easistentWebsite = client.newCall(getWebsite).execute()) {
					String eaWebsite = easistentWebsite.body().string();
					Document website = Jsoup.parse(eaWebsite, "utf-8");

					Elements metaElements = website.select("meta");
					for (int i = 0; i < metaElements.size(); i++) {
						if(metaElements.get(i).attr("name").equals("access-token")) {
							bearerToken = metaElements.get(i).attr("content");
						} else if(metaElements.get(i).attr("name").equals("x-child-id")) {
							childId = metaElements.get(i).attr("content");
						}
					}
				}
			} else {
				throw new IncorrectCredentialsException();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
