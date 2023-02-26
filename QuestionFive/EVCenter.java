package QuestionFive;

import java.util.Arrays;

public class EVCenter {
        public static void main(String[] args) {
            int[][] serviceCenters = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
            int targetMiles = 100;
            int startChargeCapacity = 10;
            int numBatteriesReplaced = countBatteriesReplaced(serviceCenters, targetMiles, startChargeCapacity);
            System.out.println(numBatteriesReplaced); // Output: 2
        }

        public static int countBatteriesReplaced(int[][] serviceCenters, int targetMiles, int startChargeCapacity) {
            int numBatteriesReplaced = 0;
            int currentMile = 0;
            int currentChargeCapacity = startChargeCapacity;
            Arrays.sort(serviceCenters, (a, b) -> a[0] - b[0]); // Sort service centers by distance from source city
            int n = serviceCenters.length;
            int i = 0;
            while (currentMile < targetMiles) {
                int nextMile = (i == n) ? targetMiles : serviceCenters[i][0];
                int distanceToNext = nextMile - currentMile;
                if (distanceToNext > currentChargeCapacity) {
                    currentChargeCapacity = 0;
                    numBatteriesReplaced++;
                } else {
                    currentChargeCapacity -= distanceToNext;
                }
                currentMile = nextMile;
                i++;
            }
            return numBatteriesReplaced;
        }
    }
