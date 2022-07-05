public class SorterDemo {

    public static void main(String[] args) {

        DisplayManager displayManager = new DisplayManager();
        SortManager sortManager = new SortManager(displayManager);
        sortManager.runSort();

    }

}
