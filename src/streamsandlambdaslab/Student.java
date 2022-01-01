package streamsandlambdaslab;

public class Student  implements Comparable<Student>
{
	private String firstName, lastName, phone;

	public Student (String first, String last, String telephone) {
		firstName = first;
		lastName = last;
		phone = telephone;
	}

	public String toString () {
		return "\n" + lastName + ", " + firstName + "\t" + phone;
	}

	public boolean equals (Object other) {
		return (lastName.equals(((Student)other).getLastName()) &&
				firstName.equals(((Student)other).getFirstName()));
	}

	@Override
	public int compareTo (Student other) {
		return this.firstName.compareTo(other.firstName);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
