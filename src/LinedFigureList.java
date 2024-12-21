import java.util.Arrays;

public class LinedFigureList {
    private Figure[] array;
    private int size;

    public LinedFigureList() {
        array = new Figure[2];
        size = 0;
    }

    public void add(Figure figure) {
        if (size == array.length) {
            resize();
        }
        array[size++] = figure;
    }

    public Figure get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне границ");
        }
        return array[index];
    }

    public void add(int index, Figure figure) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне границ");
        }
        array[index] = figure;
    }
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне границ");
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public int size() {
        return size;
    }

    private void resize() {
        Figure[] newArray = new Figure[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }
    public void clear() {
        array = new Figure[2];
        size = 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
