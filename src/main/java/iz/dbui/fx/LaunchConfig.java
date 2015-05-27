package iz.dbui.fx;

import iz.dbui.base.AppData;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author iz_j
 *
 */
@XmlRootElement
public class LaunchConfig implements AppData {
	public int port = 8888;
	public boolean autoStart = false;

	public LaunchConfig() {
	}

	public LaunchConfig(int port, boolean autoStart) {
		super();
		this.port = port;
		this.autoStart = autoStart;
	}

}
