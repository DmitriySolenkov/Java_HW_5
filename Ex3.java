import java.util.Arrays;

public class Ex3 {
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int index = 0; index < array.length; index++) {
            array[index] = ((int) (Math.random() * 21));
        }
        System.out.println(Arrays.toString(array));

        sorting(array);
    }

    public static void sorting(int[] array) {
        int temp;
        int size = array.length - 1;
        for (int i = (array.length / 2); i >= 0; i--) {
            heapify(array, i, size);
        }
        ;
        for (int i = size; i >= 0; i--) {
            temp = array[0];
            array[0] = array[size];
            array[size] = temp;
            size--;
            heapify(array, 0, size);
        }
        System.out.println(Arrays.toString(array));
    }

    public static void heapify(int[] array, int i, int size) {
        int a = 2 * i;
        int b = 2 * i + 1;
        int max;
        if (a <= size && array[a] > array[i]) {
            max = a;
        } else {
            max = i;
        }
        if (b <= size && array[b] > array[max]) {
            max = b;
        }
        if (max != i) {
            int temp = array[i];
            array[i] = array[max];
            array[max] = temp;
            heapify(array, max, size);
        }
    }
}
