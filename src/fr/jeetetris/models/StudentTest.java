package fr.jeetetris.models;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "student_test")
@AssociationOverrides({ @AssociationOverride(name = "id.student", joinColumns = @JoinColumn(name = "user_id")),
		@AssociationOverride(name = "id.test", joinColumns = @JoinColumn(name = "test_id")) })
public class StudentTest {

	private StudentTestId id = new StudentTestId();

	private String studentIdentifier;

	@EmbeddedId
	public StudentTestId getId() {
		return id;
	}

	public void setId(StudentTestId id) {
		this.id = id;
	}

	@Transient
	public Student getStudent() {
		return getId().getStudent();
	}

	public void setStudent(Student student) {
		getId().setStudent(student);
	}

	@Transient
	public Test getTest() {
		return getId().getTest();
	}

	public void setTest(Test test) {
		getId().setTest(test);
	}

	public String getStudentIdentifier() {
		return studentIdentifier;
	}

	public void setStudentIdentifier(String studentIdentifier) {
		this.studentIdentifier = studentIdentifier;
	}


	public StudentTest() {
		super();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		StudentTest that = (StudentTest) o;
		if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null)
			return false;

		return true;

	}

	@Override
	public int hashCode() {
		return (getId() != null ? getId().hashCode() : 0);
	}
}
