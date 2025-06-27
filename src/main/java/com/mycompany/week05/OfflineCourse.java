
package com.mycompany.week05;

import com.mycompany.week04.P0021.Utils;
import java.time.LocalDate;
import java.util.Scanner;

/*
    Note: 
 */
public class OfflineCourse extends Course{
    
    private LocalDate begin, end;
    private String campus;

    public OfflineCourse() {
        super();
        this.begin = null;
        this.end = null;
        this.campus = "";
    }
    
    @Override
    public void inputAll(Scanner sc) {
        super.inputAll(sc);
        try{
            boolean isValidBegin = false;
            boolean isValidEnd = false;
            boolean isValidCampus = false;
            
            while(!isValidBegin) {
                begin = Utils.readTime(sc, "Begin: ");
                isValidBegin = begin.isAfter(LocalDate.now());
                if(!isValidBegin) System.out.println("Data input is invalid, begin must be future");
            }

            while(!isValidEnd) {
                end = Utils.readTime(sc, "End: ");
                isValidEnd = begin.isBefore(end);
                if(!isValidEnd) System.out.println("Data input is invalid, end must be after begin");
            }
            
            while(!isValidCampus) {
                campus = Utils.readString(sc, "Campus (HA NOI, DA NANG,...): ");
                isValidCampus = !campus.isEmpty();
                if(!isValidCampus) {
                    System.out.println("Data input is invalid, campus cannot empty");
                }
            }
        } catch(Exception e) {
            System.out.println("Input All OC -> Error -> " + e);
        }
    }
    
    public LocalDate getBegin() {
        return begin;
    }

    public void setBegin(LocalDate begin) {
        this.begin = begin;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }
    
    @Override
    public String toString() {
        return super.toString() + "-" + begin + "-" + end + "-" + campus;
    }
}
