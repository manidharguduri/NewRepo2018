package com.m.g.designpatterns;

import java.util.Objects;


class BStudentId {
    private int id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new RuntimeException("Invalid ID");
        }
        this.id = id;
    }

}

class BStudentName {
    String firstName;
    String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        Objects.requireNonNull(firstName, "First name is not valid");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        Objects.requireNonNull(lastName, " Last name is not valid ");
        this.lastName = lastName;
    }

}


class BStudent {


    private BStudentId studentID;
    private BStudentName studentName;

    private BStudent() {
    }

    public BStudentId getStudentID() {
        return studentID;
    }

    private void setStudentID(BStudentId studentID) {
        this.studentID = studentID;
    }

    public BStudentName getStudentName() {
        return studentName;
    }

    private void setStudentName(BStudentName studentName) {
        this.studentName = studentName;
    }

    static class BStudentBuilder {
        static BStudent bStudent;

        public BStudentBuilder() {
            bStudent = new BStudent();

        }

        public BStudentBuilder withId(int id) {

            BStudentId b = new BStudentId();
            b.setId(id);
            bStudent.setStudentID(b);
            return this;
        }

        public BStudentBuilder withFirstName(String firstName) {
            if (bStudent != null && bStudent.getStudentName() != null) {
                bStudent.getStudentName().setFirstName(firstName);

            } else {
                BStudentName bname = new BStudentName();
                bname.setFirstName(firstName);
                bStudent.setStudentName(bname);

            }
            return this;

        }

        public BStudentBuilder withLastName(String lastName) {
            if (bStudent != null && bStudent.getStudentName() != null) {

                bStudent.getStudentName().setLastName(lastName);

            } else {
                BStudentName bname = new BStudentName();
                bname.setFirstName(lastName);
                bStudent.setStudentName(bname);

            }
            return this;
        }

        public BStudent build() {

            return bStudent;
        }


    }


}

public class BuilderPattern {


    public static void main(String[] args) {

        new BStudent.BStudentBuilder().withId(1).withLastName("gayi").withFirstName("bhallamudi").build();


    }
}