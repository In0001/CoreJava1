public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.method1();
        main.method2();
        main.method3();
    }

    @ExecutionTime
    public void method1() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @ExecutionTime
    public void method2() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void method3() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
