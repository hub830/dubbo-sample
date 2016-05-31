
public class Server {
	public static void main(String[] args) {
		int status = 0;
		Ice.Communicator ic = null;
		try {
			// ��ʹ�����ӣ�args���Դ�һЩ��ʹ�������������ӳ�ʱʱ�䣬��ʹ���ͻ����ӳص�������
			ic = Ice.Util.initialize(args);
			// ������ΪSimplePrinterAdapter������������Ҫ��������ʹ��ȱʡ��Э��(TCP/IP�����˿�Ϊ10000������)
			Ice.ObjectAdapter adapter = ic.createObjectAdapterWithEndpoints("SimplePrinterAdapter", "default -p 10000");
			// ʵ����һ��PrinterI����ΪPrinter�ӿڴ���һ���������
			Ice.Object object = new PrinterI();
			// ������Ԫ���ӵ��������У������������ָ������ΪSimplePrinter������������Ψһȷ��һ������Ԫ
			adapter.add(object, Ice.Util.stringToIdentity("SimplePrinter"));
			// �������������������ĺô��ǿ��Եȵ�������Դ��λ���ٴ���
			adapter.activate();
			// �÷������˳�֮ǰ��һֱ����������ļ���
			ic.waitForShutdown();
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