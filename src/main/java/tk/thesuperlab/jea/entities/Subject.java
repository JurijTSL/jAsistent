package tk.thesuperlab.jea.entities;

import java.util.ArrayList;

public class Subject {
	private String name;
	private String abbreviation;
	private boolean isExcused;
	private String finalGrade;
	private String averageGrade;
	private String gradeRank;
	private ArrayList<Semester> semesters;

	public Subject(String name, String abbreviation, boolean isExcused, String finalGrade, String averageGrade, String gradeRank, ArrayList<Semester> semesters) {
		this.name = name;
		this.abbreviation = abbreviation;
		this.isExcused = isExcused;
		this.finalGrade = finalGrade;
		this.averageGrade = averageGrade;
		this.gradeRank = gradeRank;
		this.semesters = semesters;
	}

	public String getName() {
		return name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public boolean isExcused() {
		return isExcused;
	}

	public String getFinalGrade() {
		return finalGrade;
	}

	public String getAverageGrade() {
		return averageGrade;
	}

	public String getGradeRank() {
		return gradeRank;
	}

	public ArrayList<Semester> getSemesters() {
		return semesters;
	}
}
