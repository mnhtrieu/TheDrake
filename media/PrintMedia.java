package kapka.thedrake.media;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public abstract class PrintMedia implements Closeable {
	private final PrintWriter writer;

	protected PrintMedia(OutputStream stream) {
		this.writer = new PrintWriter(stream, true);
	}
	
	@Override
	public void close() throws IOException {
		writer.close();		
	}
	
	protected PrintWriter writer() {
		return writer;
	}
}
