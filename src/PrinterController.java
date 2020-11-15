import java.util.Arrays;

public class PrinterController {
    public static void main(String[] args) throws InterruptedException {
        int N_PRINTERS = 4;
        int N_NUMBERS = 100;
        int N_PORTIONS = 10;

        Printer printers[] = getPrinters(N_PRINTERS, N_PORTIONS, N_NUMBERS);

       Arrays.stream(printers).forEach(Printer::start);
       printers[0].interrupt();


    }

    private static Printer[] getPrinters(int nPrinters, int portions, int num) {
        Printer[] printers = new Printer[nPrinters];
        printers[nPrinters-1] = new Printer(num, portions, nPrinters-1, null);

        for (int i = nPrinters-2; i >= 0; i--) {
            printers[i] = new Printer(num,portions, i, printers[i+1]);
        }

        printers[nPrinters-1].setNext(printers[0]);

        return printers;
    }


}
