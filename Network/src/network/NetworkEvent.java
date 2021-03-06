package network;

import static network.NetworkProtocol.HANDSHAKE;
import static network.NetworkProtocol.INITIATE;
import static network.NetworkProtocol.POSITION;
import static network.NetworkProtocol.RESPONSE;
import static network.NetworkProtocol.UPDATE;
import static network.NetworkProtocol.VELOCITY;

public class NetworkEvent {
	public final byte category;

	protected byte[] data;
	public final byte type;

	public NetworkEvent(byte category, byte type) {
		this.category = category;
		this.type = type;
	}

	public NetworkEvent(byte[] data) {
		byte[] arraycopy = new byte[data.length];
		System.arraycopy(data, 0, arraycopy, 0, data.length);
		this.data = arraycopy;
		category = data[0];
		type = data[1];
	}

	public NetworkEvent(NetworkEvent recieved) {
		this(recieved.data);
	}

	public boolean isHandshakeInitiateEvent() {
		return category == HANDSHAKE && type == INITIATE;
	}

	public boolean isHandshakeResponseEvent() {
		return category == HANDSHAKE && type == RESPONSE;
	}

	public boolean isUpdatePositionEvent() {
		return category == UPDATE && type == POSITION;
	}

	public boolean isUpdateVelocityEvent() {
		return category == UPDATE && type == VELOCITY;
	}

	public byte[] toByteArray() {
		byte[] arraycopy = new byte[data.length];
		System.arraycopy(data, 0, arraycopy, 0, data.length);
		return arraycopy;
	}
}
