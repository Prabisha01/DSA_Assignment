//In this example, the linked list contains the elements 3, 1, 4, 2. We convert it to an array [3, 1, 4, 2], and sort it using selection sort with the following steps:
//
//        Swap elements at indices 1 and 0. The array becomes [1, 3, 4, 2]. Increment steps to 1.
//        Swap elements at indices 3 and 1. The array becomes [1, 2, 4, 3]. Increment steps to 2.
//        Swap elements at indices 3 and 2. The array becomes [1, 2, 3, 4]. Increment steps to 3.
//        After the third step, the array is sorted in ascending order, and the method returns the step count 3.
//

package QuestionFour;

import java.util.LinkedList;

public class Steps {

    public static int stepsToSortLinkedList(LinkedList<Integer> list) {
        // Convert the linked list to an array
        int n = list.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = list.get(i);
        }

        // Sort the array using selection sort and count the number of steps
        int steps = 0;
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                steps++;
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

        return steps;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(2);
        int steps = stepsToSortLinkedList(list);
        System.out.println("The steps required are: "+steps);

    }

}

