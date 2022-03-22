import java.util.Stack;
import java.util.Vector;

public class Main {
    static final int MAX_ALLOWED_SUM_WEIGHT = 100;
    static final Integer[] WEIGHTS = new Integer[]{39, 82, 51, 26, 3, 27, 10, 58, 81, 3, 36, 5, 9, 56, 68, 41, 33, 59, 11, 9, 58, 25, 91, 28, 56, 97, 21, 48, 30, 22, 7, 75, 88, 85, 76, 53, 28, 94, 48, 58, 69, 53, 85, 98, 45, 42, 63, 46, 1, 84, 31, 30, 37, 62, 65, 70, 47, 44, 22, 25, 41, 10, 57, 45, 31, 37, 81, 15, 3, 93, 96, 4, 16, 90, 46, 66, 98, 17, 12, 16, 47, 23, 93, 97, 62, 41, 70, 5, 2, 62, 16, 58, 68, 25, 49, 13, 91, 90, 10, 34};
    static final Integer[] VALUES = new Integer[]{18, 57, 85, 51, 77, 45, 58, 25, 20, 14, 88, 33, 26, 19, 1, 5, 90, 88, 43, 2, 6, 10, 51, 100, 90, 60, 34, 79, 91, 27, 84, 1, 86, 39, 82, 97, 39, 58, 4, 10, 96, 78, 62, 7, 43, 51, 81, 9, 62, 27, 42, 61, 99, 65, 95, 71, 58, 5, 76, 8, 8, 82, 48, 54, 21, 87, 23, 68, 22, 4, 12, 71, 78, 43, 85, 62, 12, 70, 38, 12, 89, 75, 88, 11, 89, 62, 44, 54, 36, 38, 42, 37, 35, 84, 41, 91, 34, 34, 55, 28};
    static final int SIZE = VALUES.length;
    static int best_sum = 0;
    static Object best_items = new Vector<>();
    static Stack<Integer> current_indices = new Stack<>();
    static int weight_when_best_sum = 0;

    static void compute_max(int current_index, int current_values_sum, int current_weights_sum) {
        if (current_index == SIZE) {
            if (current_values_sum > best_sum) {
                best_sum = current_values_sum;
                best_items = current_indices.clone();
                weight_when_best_sum = current_weights_sum;
            }
        } else {
            for (int i = current_index + 1; i < SIZE; i++) {
                int new_current_weights_sum = current_weights_sum + WEIGHTS[i];
                if (new_current_weights_sum <= MAX_ALLOWED_SUM_WEIGHT) {
                    int new_current_values_sum = current_values_sum + VALUES[i];
                    current_indices.push(i);
                    if (new_current_values_sum > best_sum) {
                        best_sum = new_current_values_sum;
                        best_items = current_indices.clone();
                        weight_when_best_sum = new_current_weights_sum;
                    }
                    compute_max(i, current_values_sum + VALUES[i], new_current_weights_sum);
                    current_indices.pop();
                }
            }
        }
    }

    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        compute_max(0, 0, 0);
        System.out.println("Best value you can get: " + best_sum);
        System.out.println("Indices of best value: " + best_items);
        System.out.println("Total weight when best value: " + weight_when_best_sum);
        System.out.println((System.currentTimeMillis() - time1) + " milliseconds elapsed.");
    }
}
