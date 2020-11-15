public class Printer extends Thread {
    private int num;
    private int nPortions;
    private int sizePortion;
    private int id;
    private Printer next;

    public void setNext(Printer next) {
        this.next = next;
    }

    public Printer(int num, int nPortions, int id, Printer next) {
        this.num = num;
        this.nPortions = nPortions;
        this.id = id;
        this.next = next;
        this.sizePortion = num/ nPortions;
    }

    @Override
    public void run() {
        for (int i = 1; i <= nPortions; i++) {
            startPrintCycle(i);
        }
    }


    private void startPrintCycle(int i) {
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            System.out.println((""  + id).repeat(sizePortion));

            next.interrupt();
        }
    }

}
