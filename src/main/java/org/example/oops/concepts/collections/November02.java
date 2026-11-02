package org.example.oops.concepts.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class November02 {
    public static void main(String[] args) {







//       //ArrayList
//      An ArrayList is a resizable array that stores multiple elements.
//
//        Unlike a normal Java array, its size can grow or shrink dynamically.
//
//        Real-world example: Imagine maintaining a list of test cases executed in your automation framework.

        ArrayList <String> browsers = new ArrayList<>();
        browsers.add("dhananjay"+"chavan");
        browsers.add("dhananjay"+1);
        System.out.println(browsers);

        for(String browser : browsers){
        if(browser.contains("dhananjay")){
            System.out.println("Dhananjay Is present");
        }}

        browsers.remove(1);
        System.out.println(browsers);

        browsers.remove("dhananjaychavan");
        System.out.println(browsers);

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1 + 2 + 3 + 4 + 5 + 6);
        System.out.println(numbers);
        System.out.println(numbers.size());
        for (int number: numbers){
            System.out.println(number+5);

        }
        numbers.clear();
        System.out.println(numbers);
//ArrayList provides O(1) average-time indexed access,
// while inserting or removing elements in the middle generally takes O(n) because elements may need to shift.

        HashMap<Integer,String> students = new HashMap<>();
        students.put(1,"dhananjay");
        students.put(2,"chavan");
        System.out.println(students);
        System.out.println(students.get(1));

        if(students.containsValue("chavan")){

            System.out.println("Chavan is present");
        }
        else {
            System.out.println("Chavan Is not Present");
        }

        students.put(1,"rajendra");
        System.out.println(students.get(1));

        System.out.println(students.keySet());
        System.out.println(students.values());
        System.out.println(students.entrySet());
//What is Hash Collision?
//Suppose two different keys produce the same bucket index.
//
//This is called a hash collision.
//
//Java handles collisions using:
//- Linked lists in buckets.
//- Red-black trees for sufficiently large collision-heavy buckets, when the table capacity permits treeification.
//HashMap offers expected O(1) lookup and insertion under good hash distribution. Worst-case bucket operations can be O(n), or O(log n) for treeified buckets.





        //HashSet stores only unique elements.
        //
        //Think about an automation framework where you want to store unique test environment names.


        HashSet<String> environments = new HashSet<>();

        environments.add("QA");
        environments.add("UAT");
        environments.add("PROD");
        environments.add("QA");

        System.out.println(environments);






    }
}
