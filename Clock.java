import java.util.Scanner;
import java.io.*;

public class Clock{
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int hour = sc.nextInt(), minute = sc.nextInt(), second = sc.nextInt();
		long curr = System.nanoTime();
		LargePrint.setDigits();
		while (true){
			if (System.nanoTime() - curr >= 1000000000) second++;
			else continue;
			curr = System.nanoTime();
			if (second >= 60) {
				second = 0;
				minute++;
			}
			if (minute >= 60) {
				minute = 0;
				hour++;
			}
			if (hour >= 24) hour = 0;
			LargePrint.printTime(hour, minute, second);
		}
	}
}
