package tk.thesuperlab.jea.entities;

public class Grade {
	private String typeName;
	private String comment;
	private String value;

	public Grade(String typeName, String comment, String value) {
		this.typeName = typeName;
		this.comment = comment;
		this.value = value;
	}

	public String getTypeName() {
		return typeName;
	}

	public String getComment() {
		return comment;
	}

	public String getValue() {
		return value;
	}
}
