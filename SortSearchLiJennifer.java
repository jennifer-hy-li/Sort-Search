/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortsearchlijennifer;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Sort and Search Algorithms
 *
 * @author jenniferli
 */
public class SortSearchLiJennifer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        printMenu();
        //action chosen by user
        int option = keyboard.nextInt();
        //List of names from file
        ArrayList<String> names = new ArrayList<String>();
        //repeat until the user wants to quit(9)
        while (option != 9) {
            switch (option) {
                case 1: //if the user chooses option one..
                    //the readFile method is called, 
                    //the names from the file is stored in the 'names' arraylist
                    names = readFile();
                    //call the method to print the arrayList of names
                    printArrayList(names);
                    //display the menu again
                    printMenu();
                    //execute the next option
                    option = keyboard.nextInt();
                    break;
                case 2: //if the user chooses option two...
                    //'empty' is the integer that confirms if the file has been read or not
                    //using the 'names' arrayList
                    int empty = checkForFile(names);
                    //if the arrayList is empty, it means the file hasn't been read yet
                    if (empty == 1) {
                        //display the menu again
                        printMenu();
                        //execute the next option
                        option = keyboard.nextInt();
                        break;
                    } else {//if the file has been read...
                        //sort the list of names using a select sorting ascending algorightm
                        names = selectSortAscend(names);
                        //display the new updated list of names
                        printArrayList(names);
                        //display the menu again
                        printMenu();
                        //execute the next option
                        option = keyboard.nextInt();
                        break;
                    }
                case 3://if the user chooses option three...
                    //check to see if the file has been read or not
                    empty = checkForFile(names);
                    //if the file hasn't been read yet
                    if (empty == 1) {
                        //display the menu again
                        printMenu();
                        //execute the next option
                        option = keyboard.nextInt();
                        break;
                    } else {
                        //update the array to the names in descending order using select sort algorith
                        names = selectSortDescend(names);
                        //display the menu agian
                        printArrayList(names);
                        printMenu();
                        //execute the next option
                        option = keyboard.nextInt();
                        break;
                    }
                case 4://if the user chooses option four...
                    //check to see if the file has been read or not
                    empty = checkForFile(names);
                    //if the file hasn't been read yet
                    if (empty == 1) {
                        //display the menu again
                        printMenu();
                        //execute the next option
                        option = keyboard.nextInt();
                        break;
                    } else {
                        //update the list of names to ascending order using the bubble sort algorithm
                        names = bubbleSortAscend(names);
                        //display the list of updated names
                        printArrayList(names);
                        //display the menu again
                        printMenu();
                        //execute the next option
                        option = keyboard.nextInt();
                        break;
                    }
                case 5://if the user chooses option five...
                    //check to see if the file has been read or not
                    empty = checkForFile(names);
                    //if the file hasn't been read yet
                    if (empty == 1) {
                        //display the menu again
                        printMenu();
                        //execute the next option
                        option = keyboard.nextInt();
                        break;
                    } else {
                        //update the list of names to descending order using the bubble sort algorithm
                        names = bubbleSortDescend(names);
                        //display the list of updated names
                        printArrayList(names);
                        //display the menu again
                        printMenu();
                        //execute the next option
                        option = keyboard.nextInt();
                        break;
                    }
                case 6://if the user chooses option six...
                    //check to see if the file has been read or not
                    empty = checkForFile(names);
                    //if the file hasn't been read yet
                    if (empty == 1) {
                        //display the menu again
                        printMenu();
                        //execute the next option
                        option = keyboard.nextInt();
                        break;
                    } else {
                        //update the list of names to ascending order using the insertion sort algorithm
                        names = insertionSortAscend(names);
                        //display the updated list of names
                        printArrayList(names);
                        //displayt he menu again
                        printMenu();
                        //execute the next option
                        option = keyboard.nextInt();
                        break;
                    }
                case 7://if the user chooses option seven...
                    //check to see if the file has been read or not
                    empty = checkForFile(names);
                    //if the file hasn't been read yet
                    if (empty == 1) {
                        //display the menu again
                        printMenu();
                        //execute the next option
                        option = keyboard.nextInt();
                        break;
                    } else {
                        //update the list of names to descending order using the insertion sort algorithm
                        names = insertionSortDescend(names);
                        //display the new updated list of names
                        printArrayList(names);
                        //display the menu again
                        printMenu();
                        //execute the next option
                        option = keyboard.nextInt();
                        break;
                    }
                case 8:
                    //ask the user for the name they want to binary search for
                    System.out.print("What's the name you're looking for: ");
                    keyboard.nextLine();//gunk
                    //'namelooking' is the name the user wants to look for from the list
                    String nameLooking = keyboard.nextLine();
                    //result is either the index of the name in the list or -1 if the name isn't on the list
                    int result = binarySearch(names, nameLooking);
                    //if the name isn't on the list
                    if (result == -1) {
                        //tell the user the name isn't on the list
                        System.out.println("That name is not on the list");
                    } else {//if the name is on the list
                        //tell the user the index of the list where the name was found
                        System.out.println("The name was found at position: " + result + " in the list");
                    }
                    //display the options menu again
                    printMenu();
                    //execute the next option
                    option = keyboard.nextInt();
                    break;
            }
        }

    }

    /**
     * reads the file, adds the names to an arrayList
     *
     * @return ArrayList<String>, the list of names form the file
     */
    private static ArrayList<String> readFile() {
        //create a new file object for the names file
        File nameFile = new File("names.txt");
        //create a temporary arrayList that will store the file info
        ArrayList<String> fileArrayList = new ArrayList<String>();
        //try to do the following as long as the file exists
        try {
            //create a scanner that will read the file
            Scanner fileReader = new Scanner(nameFile);
            //read each line of the file
            while (fileReader.hasNextLine()) {
                //add each line(name) to the arrayList
                fileArrayList.add(fileReader.nextLine());
            }

        } catch (FileNotFoundException e) {
        }
        //return the arrayList
        return fileArrayList;
    }

    /**
     * Sorts the list of names in ascending order(a-z) using the select sort
     * algorithm
     *
     * @param names, the list of names
     * @return the sorted list of names in ascending order
     */
    private static ArrayList<String> selectSortAscend(ArrayList<String> names) {
        //create an arrayList tp sort the list of names
        ArrayList<String> sortedArray = names;
        //go through each position of the list
        for (int i = 0; i < sortedArray.size() - 1; i++) {
            //set the minimum index to the current position  of the sort
            int minIndex = i;
            //compare each name in the positions above the current position(i) in the list 
            for (int j = i + 1; j < sortedArray.size(); j++) {
                //if the name in the position ahead(j) of the current position(i) in the list, 
                //comes alphabetically before the name in the current position(i), set the name
                //in the position ahead(j) to the minIndex
                if (sortedArray.get(j).compareToIgnoreCase(sortedArray.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            //get the string at the minIndex(the current name that alphabetically comes closest to first)
            String temp = sortedArray.get(minIndex);
            //bring the new found name that's alphabetically closest to 'a' to the front/current search position
            sortedArray.set(minIndex, sortedArray.get(i));
            //switch the names (the new found name that comes before the current name)
            sortedArray.set(i, temp);
        }
        //return the new sorted list
        return sortedArray;
    }

    /**
     * Sorts the list of names in Descending order(z-a) using the select sort
     * algorithm
     *
     * @param names, the list of names
     * @return the sorted list of names in Descending order
     */
    private static ArrayList<String> selectSortDescend(ArrayList<String> names) {
        //create an arrayList tp sort the list of names
        ArrayList<String> sortedArray = names;
        //go through each position of the list
        for (int i = 0; i < sortedArray.size() - 1; i++) {
            //set the maximum index to the current position  of the sort
            int maxIndex = i;
            //compare each name in the positions above the current position(i) in the list 
            for (int j = i + 1; j < sortedArray.size(); j++) {
                //if the name in the position ahead(j) of the current position(i) in the list, 
                //comes alphabetically after the name in the current position(i), set the name
                //in the position ahead(j) to the maxIndex
                if (sortedArray.get(j).compareToIgnoreCase(sortedArray.get(maxIndex)) > 0) {
                    maxIndex = j;
                }
            }
            //get the string at the maxIndex(the current name that alphabetically comes closest to last)
            String temp = sortedArray.get(maxIndex);
            //bring the new found name that's alphabetically closest to 'z' to the front/current search position
            sortedArray.set(maxIndex, sortedArray.get(i));
            //switch the names (the new found name that comes before the current name)
            sortedArray.set(i, temp);
        }
        //return the new sorted list
        return sortedArray;
    }

    /**
     * Sorts the list of names in Ascending order(a-z) using the bubble sort
     * algorithm
     *
     * @param names, the unordered list of names
     * @return sorted list of names
     */
    private static ArrayList<String> bubbleSortAscend(ArrayList<String> names) {
        //they is the arrayList that will be sorted
        ArrayList<String> sortedArray = names;
        //create a temporary string
        String temp;
        //go through each item in the list starting from the end
        for (int i = sortedArray.size() - 1; i > 0; i--) {
            //go through each name that comes before i on the list of names do the following
            for (int j = 0; j < i; j++) {
                //if the name at j(closer to first on the list) comes alphabetically after the name at i(closer to last on the list)
                if (sortedArray.get(j).compareToIgnoreCase(sortedArray.get(j + 1)) > 0) {
                    //set the temp string to the name that comes closer to first on the list
                    temp = sortedArray.get(j);
                    //switch the name that comes alphabetically after i (this would be the name at j) and the name one position above j
                    sortedArray.set(j, sortedArray.get(j + 1));
                    sortedArray.set(j + 1, temp);
                }
            }
        }
        //return the sorted array
        return sortedArray;
    }

    /**
     * Sorts the list of names in Descending order(z-a) using the bubble sort
     * algorithm
     *
     * @param names, unordered list of names
     * @return the sorted list of names
     */
    private static ArrayList<String> bubbleSortDescend(ArrayList<String> names) {
        //they is the arrayList that will be sorted
        ArrayList<String> sortedArray = names;
        //create a temporary string
        String temp;
        //go through each item in the list starting from the end
        for (int i = sortedArray.size() - 1; i > 0; i--) {
            //go through each name that comes before i on the list of names
            for (int j = 0; j < i; j++) {
                //if the name at j(closer to first on the list) comes alphabetically before the name at i(closer to last on the list) do the following
                if (sortedArray.get(j).compareToIgnoreCase(sortedArray.get(j + 1)) < 0) {
                    //set the temp string to the name that comes closer to first on the list
                    temp = sortedArray.get(j);
                    //switch the name that comes alphabetically before i (this would be the name at j) and the name one position above j
                    sortedArray.set(j, sortedArray.get(j + 1));
                    sortedArray.set(j + 1, temp);
                }
            }
        }
        //returnt the sorted list of names
        return sortedArray;
    }

    /**
     * Sorts the list of names in Ascending order(a-z) using the insertion sort
     * algorithm
     *
     * @param names, list of names
     * @return the sorted list of names
     */
    private static ArrayList<String> insertionSortAscend(ArrayList<String> names) {
        //this is the list of names that will be sorted
        ArrayList<String> sortedArray = names;
        //go through each name, skipping the first name
        for (int i = 1; i < sortedArray.size(); i++) {
            //set a stirng called key to the current position of the name list(i)
            String key = sortedArray.get(i);
            //j is always one position below i
            int j = i - 1;
            //repeat while the name at j comes alphabetically after the key(i) do the following
            while (j >= 0 && (sortedArray.get(j).compareToIgnoreCase(key) > 0)) {
                //switch the name at j with the name adjacent name in the position after j
                sortedArray.set(j + 1, sortedArray.get(j));
                //set the position of j to one less
                j--;
            }
            //move the key to the front
            sortedArray.set(j + 1, key);
        }
        //return the sorted list of names
        return sortedArray;
    }

    /**
     * Sorts the list of names in descending order(z-a) using the insertion sort
     * algorithm
     * @param names,the list of names
     * @return sorted list of names
     */
    private static ArrayList<String> insertionSortDescend(ArrayList<String> names) {
        //this is the list of names that will be sorted
        ArrayList<String> sortedArray = names;
        //go through each name, skipping the first name
        for (int i = 1; i < sortedArray.size(); i++) {
            //set a stirng called key to the current position of the name list(i)
            String key = sortedArray.get(i);
            //j is always one position below i
            int j = i - 1;
            //repeat while the name at j comes alphabetically before the key(i) do the following
            while (j >= 0 && (sortedArray.get(j).compareToIgnoreCase(key) < 0)) {
                //switch the name at j with the name adjacent name in the position after j
                sortedArray.set(j + 1, sortedArray.get(j));
                //set the position of j to one less
                j--;
            }
            //move the key to the front
            sortedArray.set(j + 1, key);

        }
        //return the sorted array
        return sortedArray;
    }

    /**
     * Search for a name in the list
     *
     * @param names, the list of names
     * @param searchArgument, the name the user is looking for
     * @return -1 if the name wasn't in the list, the index of the name in the
     * list if the name is found in the list
     */
    private static int binarySearch(ArrayList<String> names, String searchArgument) {
        //the return value if the name isn't found on the list
        int notFound = -1;
        //if the name is in the list do the following
        if (names.contains(searchArgument)) {
            //go through each item in the list and compare the names to see if they're the same
            for (int i = 0; i < names.size(); i++) {
                //if they're the same..
                if (names.get(i).equals(searchArgument)) {
                    //return the position they were found in the list
                    return i;
                }
            }
        }
        //if the list isn't in the name, return -1
        return notFound;
    }

    /**
     * checks to see if the file of names has been read already
     *
     * @param file, the file of names
     * @return 0, if the file has been read, 1 if the file hasn't been read yet
     */
    private static int checkForFile(ArrayList<String> file) {
        //if the object for the file of names is empty..
        if (file.isEmpty()) {
            //let the user know the file hasn't been read yet
            System.out.println("You must load the file first");
            //return 1
            return 1;
        }
        //if the file object has already been read return 0
        return 0;
    }

    /**
     * Prints the list of names
     *
     * @param printList, the list of names
     */
    private static void printArrayList(ArrayList<String> printList) {
        //go through each name in the list
        for (int i = 0; i < printList.size() - 1; i++) {
            //print the name in the current position
            System.out.println(printList.get(i));
        }
    }

    /**
     * display the menu
     */
    private static void printMenu() {
        System.out.printf("Choose:\n 1-Read names from File"
                + "\n 2-Selection sort Ascending"
                + "\n 3-Selection sort Descending"
                + "\n 4-Bubble Sort Ascending"
                + "\n 5-Bubble Sort Descending"
                + "\n 6-Insetion Sort Ascending"
                + "\n 7-Insertion Sort Descending"
                + "\n 8-Binary Search"
                + "\n 9-Exit\n");
    }

}
