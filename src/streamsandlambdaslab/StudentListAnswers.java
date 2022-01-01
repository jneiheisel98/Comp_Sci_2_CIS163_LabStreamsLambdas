package streamsandlambdaslab;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentListAnswers {
    //-----------------------------------------------------------------
    //  Creates an array of Contact objects, sorts them, then prints
    //  them.
    //-----------------------------------------------------------------
    public static void main(String[] args) {

        // TODO 1: Answer the following question:
        // Can Collections.sort be used with a regular array like the
        // one below? Why or why not?
        //		Student[] friends = new Student[8];


        // Answer: No, it can't be used with a regular array because
        // Collections.sort requires the input to be of type List<E>
        // or one of its subclasses.


        ArrayList<Student> friends = new ArrayList<Student>();

        friends.add(new Student("John", "Smith", "610-555-7384"));
        friends.add(new Student("Sarah", "Barnes", "610-555-7384"));
        friends.add(new Student("Mark", "Riley", "733-555-2969"));
        friends.add(new Student("Laura", "Getz", "663-555-3984"));
        friends.add(new Student("Laura", "Apple", "663-555-3984"));
        friends.add(new Student("Laura", "Zimmer", "663-555-3984"));
        friends.add(new Student("Larry", "Barnes", "464-555-3489"));
        friends.add(new Student("Mike", "Barnes", "610-555-7384"));
        friends.add(new Student("Frank", "Phelps", "322-555-2284"));
        friends.add(new Student("Mario", "Guzman", "804-555-9066"));
        friends.add(new Student("Marsha", "Grant", "243-555-2837"));

        // Sort using the compareTo function in the Student class
        Collections.sort(friends);
        System.out.println("TODO 1 Start of list " + friends);


        // This sorts by last name using a separate class
        Collections.sort(friends, new SortByLastNameNumber());


        /*********************************************************************
         * TODO 2: Below this line, the Collections.sort() has an
         * error. This method should sort by phone number, but it does
         * not! To correct the problem, complete the compare method in
         * the SortByPhoneNumber class.
         *
         */
        Collections.sort(friends, new SortByPhoneNumber());
        System.out.println("TODO 2" + friends);


        /*********************************************************************
         * TODO 3: Complete this an inner class to sort by
         * phone number.
         *  Answer to 3: return o1.getPhone().compareTo(o2.getPhone());
         */

        Collections.sort(friends, new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                return o1.getPhone().compareTo(o2.getPhone());
            }
        });
        System.out.println("TODO 3" + friends);


        /*********************************************************************
         * TODO 4: Complete this an inner class to sort by
         * last name (and first name if last names are the same). Use
         * another inner class just like in 3a.
         *     Answer to 4:
         *      int compareLastName = o1.getLastName().compareTo(o2.getLastName());
         *      if (compareLastName == 0) {
         *          return o1.getFirstName().compareTo(
         *          o2.getFirstName());
         *      } else {
         *          return compareLastName;
         *      }
         */
        Collections.sort(friends, new Comparator<Student>() {
            public int compare(Student o1, Student o2) {

                if (o1.getLastName().compareTo(o2.getLastName())==0){
                    return o1.getFirstName().compareTo(o2.getFirstName());
                }
                else{
                    return o1.getLastName().compareTo(o2.getLastName());
                }

            }
        });
        System.out.println("TODO 4" + friends);


        /*********************************************************************
         * TODO 5: Complete this lambda function to sort by phone number
         *
         *  Answer to 5: Collections.sort(friends, (o1, o2) -> o1.getPhone().compareTo(o2.getPhone()));
         */

        Collections.sort(friends, (o1, o2) -> o1.getPhone().compareTo(o2.getPhone()));
        System.out.println("TODO 5" + friends);


        /*********************************************************************
         * TODO 6: Complete this lambda function to sort by last name
         *
         *  Answer to 6:  {
         *
         *             int compareLastName = o1.getLastName().compareTo(
         *                     o2.getLastName());
         *             if (compareLastName == 0) {
         *                 return o1.getFirstName().compareTo(
         *                         o1.getFirstName());
         *             } else {
         *                 return compareLastName;
         *             }
         *         }
         */
        Collections.sort(friends, (j, k) -> {
                int compareLastname = j.getLastName().compareTo(k.getLastName());
                if(compareLastname==0){
                    return j.getFirstName().compareTo(k.getFirstName());
                }
                else{
                    return j.getLastName().compareTo(k.getLastName());
                }});

            System.out.println("TODO 6" + friends);


        /*********************************************************************
         * TODO 7: Complete this Stream function to filter by Barnes as the
         * last name. The code for the stream has been started for you,
         * but it doesn't filter properly! Your task is to fix the
         * code.
         *
         *   Answer to 7: .filter(arg -> arg.getLastName().equals("Barnes"))
         *
         */
        ArrayList<Student> lista = (ArrayList<Student>) friends.stream()
                .filter(arg -> arg.getLastName().equals("Barnes"))
                .collect(Collectors.toList());
        System.out.println("TODO 7" + lista);


        /*********************************************************************
         * TODO 8: Complete this Stream function to filter by 610 as part of
         * a phone number. The code for the stream has been started for
         * you. Your task is to complete the code.
         *
         *   Answer to 8:    .filter(arg -> arg.getPhone().contains("610"))
         */
        ArrayList<Student> listb = (ArrayList<Student>) friends.stream()
                .filter(arg -> arg.getPhone().contains("610"))
                .collect(Collectors.toList());
        System.out.println("TODO 8" + listb);


        /*********************************************************************
         * TODO 9: Complete this Stream function to capitalize all names.
         * This one is difficult!
         *
         *   Answer to 9: .map(arg -> {
         *                     arg.setFirstName(arg.getFirstName().toUpperCase());
         *                     arg.setLastName(arg.getLastName().toUpperCase());
         *                     return arg;
         *                 })
         */


        ArrayList<Student> listc = (ArrayList<Student>) friends.stream()
                //.filter(arg -> arg.getLastName().equals("Barnes"))
                .map(arg->{
                    arg.setFirstName(arg.getFirstName().toUpperCase());
                    arg.setLastName(arg.getLastName().toUpperCase());
                    return arg;
                })
                .collect(Collectors.toList());

        System.out.println("TODO 9" + listc);
        System.out.println("TODO 9" + friends);


        /*********************************************************************
         * TODO 10: Walk through the code below, and make sure you
         * understand what is happening at least conceptually
         */

        Collections.sort(friends,
                Comparator.comparing(Student::getPhone));
        System.out.println("TODO 10a" + friends);

        Collections.sort(friends,
                Comparator.comparing(Student::getFirstName));
        System.out.println("TODO 10b" + friends);


    }

}
