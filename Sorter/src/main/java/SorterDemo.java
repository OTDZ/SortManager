public class SorterDemo {

    public static void main(String[] args) {

        LoggerManager.logger.info("Program started");

        SortManager sortManager = new SortManager(2);
        sortManager.runSort();

        LoggerManager.logger.info("Program terminated");
    }

}
