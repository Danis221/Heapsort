package HeapSort;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.*;
import static HeapSort.ArrayCreator.arrayCreator;

public class HeapSort {
    private static int count;
    public static void sort(int[] arr)
    {
        int n = arr.length;

        long time1 = System.nanoTime();
        // Построение кучи (перегруппируем массив)
        for (int i = n/2-1; i >= 0; i--) {
            heapify(arr, n, i);
        }
// 13 11 12 5 6 7
        // Один за другим извлекаем элементы из кучи

        for (int i = n-1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }

        long time2 = System.nanoTime();
        long time = time2 - time1;
        System.out.println( count + " " + arr.length + " : " + time );
        System.out.println(count == arr.length);
    }

    // Процедура для преобразования в двоичную кучу поддерева с корневым узлом i, что является
// индексом в arr[]. n - размер кучи
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2*i + 1; // левый = 2*i + 1
        int r = 2*i + 2; // правый = 2*i + 2

        // Если левый дочерний элемент больше корня
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
            count+=1;
        }

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
            count+=1;
        }

        // Если самый большой элемент не корень
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            count+=1;
            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, n, largest);
        }
    }

    /* Вспомогательная функция для вывода на экран массива размера n */
    private static void printArray(int[] arr) {
        int n = arr.length;
        for (int i=0; i<n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Управляющая программа
    public static void main(String[] args) throws FileNotFoundException {
        int[] arr = arrayCreator(new File("C:\\Users\\danis\\Desktop\\work\\repo\\src\\HeapSort\\Files\\Fiel50.txt"));
        sort(arr);
        System.out.println("Sorted array is");
        System.out.println();
        //printArray(arr);
    }
}
