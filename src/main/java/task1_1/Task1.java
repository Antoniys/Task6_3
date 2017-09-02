package task1_1;

import org.apache.log4j.Logger;

import java.util.Scanner;

public class Task1 {

    final static Logger logger = Logger.getLogger(Task1.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number : ");
        int scannerNumber = scanner.nextInt();
        System.out.println();
        logger.info("inputted number : " + scannerNumber);
        checkError(scannerNumber);
        getBinaryNumberSystem(scannerNumber);
        getOctalNumberSystem(scannerNumber);
        getHexadecimalNumberSystem(scannerNumber);
    }


    public static void checkError(int scannerNumber) {
        if (scannerNumber < 0) {
            logger.error(new IllegalArgumentException("Number isn't correct!!!!"));
        }
    }

    public static void getBinaryNumberSystem(int scannerNumber) {
        StringBuilder sb = new StringBuilder();

        int x = 1;
        for (int i = 0; i < 32; i++) {
            sb.append((scannerNumber & x) == 0 ? "0" : "1");
            x <<= 1;
        }
        sb.reverse();
        int index = sb.indexOf("1");
        logger.info("Got binary number : " + sb.delete(0, index));
    }

    public static void getOctalNumberSystem(int scannerNumber) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (scannerNumber < 8) {
                sb.append(scannerNumber);
                break;
            }
            sb.append(scannerNumber % 8);
            scannerNumber /= 8;
        }
        logger.info("Got octal number : " + sb.reverse());
    }

    public static void getHexadecimalNumberSystem(int scannerNumber) {
        StringBuilder sb = new StringBuilder();
        int x;
        while (true) {
            if (scannerNumber < 16 && scannerNumber > 9) {
                caseOfLetter(scannerNumber, sb);
                break;
            }
            if (scannerNumber < 16 && scannerNumber < 10) {
                sb.append(scannerNumber);
                break;
            }
            x = scannerNumber % 16;
            if (x > 9) {
                caseOfLetter(x, sb);
            } else {
                sb.append(x);
            }
            scannerNumber /= 16;
        }
        logger.info("Got hexadecimal number : " + sb.reverse());
    }

    public static void caseOfLetter(int x, StringBuilder sb) {
        switch (x) {
            case 10:
                sb.append("A");
                break;
            case 11:
                sb.append("B");
                break;
            case 12:
                sb.append("C");
                break;
            case 13:
                sb.append("D");
                break;
            case 14:
                sb.append("E");
                break;
            case 15:
                sb.append("F");
                break;
        }
    }
}
