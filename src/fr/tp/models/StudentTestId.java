package fr.tp.models;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class StudentTestId implements Serializable{

	private static final long serialVersionUID = 1L;

    private Student student;
 
    private Test test;
    
    @ManyToOne
    public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@ManyToOne
	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}
 
    public StudentTestId() {} 
    
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass()) 
            return false;
 
        StudentTestId that = (StudentTestId) o;
        if (student != null ? !student.equals(that.student) : that.student != null) return false;
        if (test != null ? !test.equals(that.test) : that.test != null)
            return false;

        return true;
    }
 
	public int hashCode() {
        int result;
        result = (student != null ? student.hashCode() : 0);
        result = 31 * result + (test != null ? test.hashCode() : 0);
        return result;
    }
}