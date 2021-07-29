package tk.thesuperlab.jea.entities;

import java.util.ArrayList;

public class Semester {
	private int id;
	private String finalGrade;
	private ArrayList<Grade> grades;

	public Semester(int id, String finalGrade, ArrayList<Grade> grades) {
		this.id = id;
		this.finalGrade = finalGrade;
		this.grades = grades;
	}

	public int getId() {
		return id;
	}

	public String getFinalGrade() {
		return finalGrade;
	}

	public ArrayList<Grade> getGrades() {
		return grades;
	}
}
