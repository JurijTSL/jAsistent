package tk.thesuperlab.jea.entities;

public class Evaluation {
	private String course;
	private String description;
	private String type;
	private String date;
	private String period;
	private String grade;

	public Evaluation(String course, String description, String type, String date, String period, String grade) {
		this.course = course;
		this.description = description;
		this.type = type;
		this.date = date;
		this.period = period;
		this.grade = grade;
	}

	public String getCourse() {
		return course;
	}

	public String getDescription() {
		return description;
	}

	public String getType() {
		return type;
	}

	public String getDate() {
		return date;
	}

	public String getPeriod() {
		return period;
	}

	public String getGrade() {
		return grade;
	}
}
