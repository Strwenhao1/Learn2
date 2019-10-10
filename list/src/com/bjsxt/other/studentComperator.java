package com.bjsxt.other;

import java.util.Comparator;

public class studentComperator implements Comparator<Student> {
    @Override
    public int compare(Student s1,Student s2) {
        if(s1.getCourse()>s2.getCourse()){
            return 1;
        }else if(s1.getCourse()<s2.getCourse()){
            return -1;
        }else {
            return 0;
        }

    }
}
