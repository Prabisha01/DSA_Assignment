package QuestionEight;
//The program takes two inputs: an integer array "arr" and an integer "k". It then initializes two variables:
//        "missingCount" (which keeps track of the number of missing even numbers encountered so far) and "prevNum"
//        (which stores the previous even number encountered in the array).
public class MissingNumber {
    public static int findKthMissingEvenNumber(int[] arr, int k) {
        int missingCount = 0;
        int prevNum = -2;

        for (int num : arr) {
            int diff = num - prevNum;
            int evensBetween = diff / 2 - 1;

            if (missingCount + evensBetween >= k) {
                return prevNum + 2 * (k - missingCount);
            }

            missingCount += evensBetween;
            prevNum = num;
        }

        return prevNum + 2 * (k - missingCount);
    }
    // prints the resulting k-th missing even number.
    public static void main(String[] args) {
        int[] arr = {0, 2, 6, 18, 22};
        int k = 6;
        int kthMissingEvenNumber = findKthMissingEvenNumber(arr, k);
        System.out.println(kthMissingEvenNumber);
    }
}
