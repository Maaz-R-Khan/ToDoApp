package com.example.todoapp;

public class myDOB {
    private  int day;
    private  int month;
    private  int year;
    myDOB(int _day, int _month, int _year){
        this.day = _day;
        this.month = _month;
        this.year = _year;
    }
    myDOB(myDOB dob){
        this.day = dob.day;
        this.month = dob.month;
        this.year = dob.year;
    }
    @Override
    public String toString() {
        String date = this.month + "/"+ this.day + "/"+ year;
        return date;
    }

    @Override
    protected myDOB clone() throws CloneNotSupportedException {
        myDOB obj = new myDOB(this.day,this.month,this.year);
        return obj;
    }


    public boolean equals(myDOB obj) {
        /*boolean equal = false;
        if(obj.year == this.year && obj.day == this.day && obj.month == this.month)
            equal = true;
        else
            equal = false;
        return equal;
        */
        return (obj.day == this.day &&
                obj.month == this.month &&
                obj.year == this.year);

    }


}
