package com.m.g.java.eight;

import java.util.Optional;

public class OptionalBasicUsage {

    public static void main(String[] args) {
        OStudent mani = new OStudent();
        Optional.ofNullable(mani.getLeader()).ifPresent(ld ->
                System.out.println("mani leader :: " + mani.getLeader().leaderName)
        );

    }
}


class OStudent {
    int id;
    String studentName;
    OLeader leader;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public OLeader getLeader() {
        return leader;
    }

    public void setLeader(OLeader leader) {
        this.leader = leader;
    }
}

class OLeader {
    String leaderName;

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }
}