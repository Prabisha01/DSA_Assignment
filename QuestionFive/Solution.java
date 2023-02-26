//The program creates a list of points by iterating through the height array and adding left and right edge points.
//        It then sorts the list by x coordinate and loops through the sorted list,adding border line points based
//        on whether the current point has a greater or lesser height than the current maximum height.
//        The resulting list is returned as a 2D array. The main method calls this method and prints the resulting array.

package QuestionFive;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[][] height = {{1,4,10},{2,5,15},{5,8,12},{9,11,1},{11,13,15}};
        int[][] borderLine = findBorderLine(height);
        for (int[] point : borderLine) {
            System.out.println(Arrays.toString(point));
        }
    }

    public static int[][] findBorderLine(int[][] height) {
        List<int[]> points = new ArrayList<>();
        int n = height.length;

        //adding left edge points
        for (int i = 0; i < n; i++) {
            points.add(new int[] {height[i][0], height[i][2]});
        }

        //adding right edge points
        for (int i = 0; i < n; i++) {
            points.add(new int[] {height[i][1], 0});
        }

        // Sort points by x coordinate
        Collections.sort(points, new Comparator<int[]>() {
            public int compare(int[] p1, int[] p2) {
                return Integer.compare(p1[0], p2[0]);
            }
        });

        // Find border line points
        List<int[]> borderLine = new ArrayList<>();
        int maxHeight = 0;
        for (int i = 0; i < points.size(); i++) {
            int[] point = points.get(i);
            if (point[1] > maxHeight) {
                borderLine.add(new int[] {point[0], point[1]});
                maxHeight = point[1];
            } else if (point[1] < maxHeight) {
                borderLine.add(new int[] {point[0], point[1]});
                maxHeight = point[1];
            }
        }

        // Convert list to array and return
        return borderLine.toArray(new int[borderLine.size()][]);
    }
}