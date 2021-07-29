package tk.thesuperlab.jea.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import tk.thesuperlab.jea.entities.Evaluation;
import tk.thesuperlab.jea.entities.Grade;
import tk.thesuperlab.jea.entities.Semester;
import tk.thesuperlab.jea.entities.Subject;

import java.io.IOException;
import java.util.ArrayList;

public class RestUtils {
	public static ArrayList<Evaluation> getPastEvaluations(String bearerToken, String childId) {
		ArrayList<Evaluation> toReturn = new ArrayList<Evaluation>();
		OkHttpClient client = new OkHttpClient();

		Request getEvaluations = new Request.Builder()
				.url("https://www.easistent.com/m/evaluations?filter=past")
				.addHeader("authorization", bearerToken)
				.addHeader("x-child-id", childId)
				.addHeader("x-client-platform", "web")
				.addHeader("x-client-version", "13")
				.get()
				.build();

		try(Response pastEvaluations = client.newCall(getEvaluations).execute()) {
			JSONObject evalObj = new JSONObject(pastEvaluations.body().string());
			JSONArray evalArr = evalObj.getJSONArray("items");

			for(int i = 0; i < evalArr.length(); i++) {
				JSONObject evalToAdd = (JSONObject) evalArr.get(i);

				toReturn.add(new Evaluation(
						evalToAdd.getString("course"),
						evalToAdd.getString("subject"),
						evalToAdd.getString("type"),
						evalToAdd.getString("date"),
						evalToAdd.getString("period"),
						evalToAdd.isNull("grade") ? null : evalToAdd.getString("grade")
				));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

		return toReturn;
	}

	public static ArrayList<Evaluation> getFutureEvaluations(String bearerToken, String childId) {
		ArrayList<Evaluation> toReturn = new ArrayList<Evaluation>();
		OkHttpClient client = new OkHttpClient();

		Request getEvaluations = new Request.Builder()
				.url("https://www.easistent.com/m/evaluations?filter=future")
				.addHeader("authorization", bearerToken)
				.addHeader("x-child-id", childId)
				.addHeader("x-client-platform", "web")
				.addHeader("x-client-version", "13")
				.get()
				.build();

		try (Response futureEvaluations = client.newCall(getEvaluations).execute()) {
			JSONObject evalObj = new JSONObject(futureEvaluations.body().string());
			JSONArray evalArr = evalObj.getJSONArray("items");

			for(int i = 0; i < evalArr.length(); i++) {
				JSONObject evalToAdd = (JSONObject) evalArr.get(i);

				toReturn.add(new Evaluation(
						evalToAdd.getString("course"),
						evalToAdd.getString("subject"),
						evalToAdd.getString("type"),
						evalToAdd.getString("date"),
						evalToAdd.getString("period"),
						evalToAdd.isNull("grade") ? null: evalToAdd.getString("grade")
				));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return toReturn;
	}

	public static String getSchedule(String bearerToken, String childId) {
		String toReturn = "";
		OkHttpClient client = new OkHttpClient();

		Request getSchedule = new Request.Builder()
				.url("https://www.easistent.com/m/timetable/weekly?from=2021-05-24&to=2021-05-30")
				.addHeader("authorization", bearerToken)
				.addHeader("x-child-id", childId)
				.addHeader("x-client-platform", "web")
				.addHeader("x-client-version", "13")
				.get()
				.build();

		try (Response schedule = client.newCall(getSchedule).execute()) {
			toReturn = schedule.body().string();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return toReturn;
	}

	public static ArrayList<Subject> getGrades(String bearerToken, String childId) {
		ArrayList<Subject> toReturn = new ArrayList<Subject>();
		OkHttpClient client = new OkHttpClient();

		Request getGrades = new Request.Builder()
				.url("https://www.easistent.com/m/grades")
				.addHeader("authorization", bearerToken)
				.addHeader("x-child-id", childId)
				.addHeader("x-client-platform", "web")
				.addHeader("x-client-version", "13")
				.get()
				.build();

		try (Response gradesResp = client.newCall(getGrades).execute()) {
			JSONObject subjectsObj = new JSONObject(gradesResp.body().string());
			JSONArray subjectsArr = subjectsObj.getJSONArray("items");

			for(int i = 0; i < subjectsArr.length(); i++) {
				JSONObject subjectToAdd = (JSONObject) subjectsArr.get(i);

				JSONArray semestersArr = subjectToAdd.getJSONArray("semesters");
				ArrayList<Semester> semesters = new ArrayList<Semester>();

				for(int j = 0; j < semestersArr.length(); j++) {
					JSONObject semesterToAdd = (JSONObject) semestersArr.get(j);

					JSONArray gradesArr = semesterToAdd.getJSONArray("grades");
					ArrayList<Grade> grades = new ArrayList<Grade>();

					for(int k = 0; k < gradesArr.length(); k++) {
						JSONObject gradeToAdd = (JSONObject) gradesArr.get(k);

						grades.add(new Grade(
								gradeToAdd.getString("type_name"),
								gradeToAdd.isNull("comment") ? null: gradeToAdd.getString("comment"),
								gradeToAdd.getString("value")
						));
					}

					semesters.add(new Semester(
							semesterToAdd.getInt("id"),
							semesterToAdd.isNull("final_grade") ? null: semesterToAdd.getString("final_grade"),
							grades
					));
				}

				toReturn.add(new Subject(
						subjectToAdd.getString("name"),
						subjectToAdd.getString("short_name"),
						subjectToAdd.getBoolean("is_excused"),
						subjectToAdd.isNull("final_grade") ? null: subjectToAdd.getString("final_grade"),
						subjectToAdd.getString("average_grade"),
						subjectToAdd.getString("grade_rank"),
						semesters
				));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return toReturn;
	}
}