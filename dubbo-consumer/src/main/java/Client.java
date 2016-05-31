
public class Client {
	public static void main(String[] args) {
		int status = 0;
		Ice.Communicator ic = null;
		try {
			// ��ʹ��
			ic = Ice.Util.initialize(args);
			// ����Զ�̷���Ԫ�����ơ�����Э�顢IP���˿ڣ���ȡPrinter��Զ�̴�������ʹ�õ�stringToProxy��ʽ
			Ice.ObjectPrx base = ic.stringToProxy("SimplePrinter:default -p 10000");
			// ͨ��checkedCast����ת������ȡPrinter�ӿڵ�Զ�̣���ͬʱ�����ݴ�������ƻ�ȡ�ķ���Ԫ�Ƿ�Printer�Ĵ���ӿڣ���������򷵻�null����
			Demo.PrinterPrx printer = Demo.PrinterPrxHelper.checkedCast(base);
			if (printer == null)
				throw new Error("Invalid proxy");
			// ��Hello World��������ˣ��÷���˴�ӡ��������Ϊ����������ջ��ڷ������ִ��
			printer.printString("Hello Worldaaaaa!");
		} catch (Ice.LocalException e) {
			e.printStackTrace();
			status = 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			status = 1;
		}
		if (ic != null) {
			// Clean up
			//
			try {
				ic.destroy();
			} catch (Exception e) {
				System.err.println(e.getMessage());
				status = 1;
			}
		}
		System.exit(status);
	}
}