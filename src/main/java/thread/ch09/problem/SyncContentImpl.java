package thread.ch09.problem;

import java.io.DataInputStream;
import java.io.EOFException;
import java.net.URL;

public class SyncContentImpl implements Content {
	private byte[] contentBytes;
	
	public SyncContentImpl(String urlStr) {
		System.out.println(Thread.currentThread().getName() + ": Getting " + urlStr);
			
		try {			
			URL url = new URL(urlStr);
			byte[] buffer = new byte[1];
			int index = 0;
			
			DataInputStream in = new DataInputStream(url.openStream());
			try {
				while(true) {
					int c = in.readUnsignedByte();
					if(buffer.length <= index) {
						byte[] largeBuffer = new byte[buffer.length * 2];
						System.arraycopy(buffer, 0, largeBuffer, 0, index);
						buffer = largeBuffer;
						System.out.println("Enlarging buffer to " + buffer.length);
					}
					buffer[index++] = (byte)c;
					System.out.print("Getring " + index + " bytes from " + urlStr);
				}
			} catch (EOFException e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				if(in != null) {
					in.close();
				}
			}
			contentBytes = new byte[index];
			System.arraycopy(buffer, 0, contentBytes, 0, index);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public byte[] getBytes() {
		return contentBytes;
	}
}
