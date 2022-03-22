package sorting;

public class Student implements Comparable<Student>
{

	String name;
	int age;
	
	public Student(String name, int no) {
		super();
		this.name = name;
		this.age = no;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	@Override
	public int compareTo(Student o) {
		// TODO 자동 생성된 메소드 스텁
		return this.name.compareTo(o.name);
	}

}
