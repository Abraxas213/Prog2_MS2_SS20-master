import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class WriterThread extends Thread {

	private BlockingQueue<String> queue;
	private ArrayList<PrintWriter> printWriter;
	private boolean isRunning = true;

	public WriterThread(ArrayList<PrintWriter> printWriter, BlockingQueue<String> queue) {
		super();
		this.queue = queue;
		this.printWriter = printWriter;
	}

	@Override
	public void run() {

		while (isRunning) {
			try {

				String message = queue.take();

				synchronized (printWriter) {
					for (PrintWriter printWriter : printWriter) {
						try {
							printWriter.println(message);
							printWriter.flush();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void quit() {
		isRunning = false;
		interrupt();
		System.out.println("End");
	}

	public boolean isRunning() {
		// TODO interrupt()
		return isRunning;
	}

}
