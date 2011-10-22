package hudson.plugins.ircbot.v2;

import hudson.plugins.im.IMChat;
import hudson.plugins.im.IMException;
import hudson.plugins.im.IMMessageListener;

/**
 * Representation of an IRC channel.
 * 
 * @author kutzi
 */
public class IRCChannel implements IMChat {

	private final String channelName;
	private final PircListener listener;
    private IRCConnection connection;

	public IRCChannel(String channelName, IRCConnection connection, PircListener listener) {
		this.channelName = channelName;
		this.connection = connection;
		this.listener = listener;
	}
	
	//@Override
	public String getNickName(String senderId) {
		return senderId;
	}
	
	//@Override
	public String getIMId(String senderId) {
		return senderId;
	}

	//@Override
	public boolean isMultiUserChat() {
		return true;
	}

	//@Override
	public void addMessageListener(IMMessageListener listener) {
		this.listener.addMessageListener(this.channelName, listener);
	}
	
	//@Override
	public void removeMessageListener(IMMessageListener listener) {
		this.listener.removeMessageListener(this.channelName, listener);
	}

	//@Override
	public void sendMessage(String message) throws IMException {
		this.connection.send(channelName, message);
	}
}
