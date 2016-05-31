import Demo._PrinterDisp;
import Ice.Current;

public class PrinterI extends _PrinterDisp {

	@Override
	public void printString(String s, Current __current) {
		// TODO Auto-generated method stub
		System.out.println(s);
		
	}
}