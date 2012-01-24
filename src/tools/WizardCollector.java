package tools;

import gui.MainWindow;

import java.util.ResourceBundle;

public class WizardCollector extends DataCollector {

	private ResourceBundle summary = MainWindow.summary;
	private ResourceBundle menuItems = MainWindow.menuItems;
	private StringBuffer args;
	private StringBuffer extras;
	private StringBuffer options;
	private StringBuffer string;
	public WizardCollector() {
		args = new StringBuffer();
		extras = new StringBuffer();
		options = new StringBuffer();
		string = new StringBuffer();
	}
	@Override
	public String toString() {
		parseOptions();
		return string.toString() + "\n\n" + getCmd();
	}
	public void parseOptions() {
		for(String key : data.keySet()) {
			String value = data.get(key);
			String installAndOrUpdate = summary.getString("install") + " "
					+ menuItems.getString("andOr") + " "
					+ summary.getString("update").toLowerCase() + " ";
			if (key.equals("firstTime"))
				if (value.equals("true"))
					string.append(summary.getString("installSoftmods") + "\n");
				else
					extras.append("min ");
			else if (key.equals("firmware")) {
				args.append(value + " ");
				string.append(summary.getString("current") + " ");
				if (value.equals("O"))
					string.append(summary.getString("less") + "2.2");
				else
					string.append(value);
			} else if (key.equals("region")) {
				string.append(value + "\n");
				if (!getMode().equals("HS"))
					args.append(value + " ");
			} else if (key.equals("newFirmware")) {
				String region = data.get("region");
				string.append(summary.getString("desired") + " " + value
						+ region + "\n");
				args.append(value + " ");
			} else if (key.equals("CH")) {
				appendChannel("photo");
				appendChannel("net");
				appendChannel("weather");
				appendChannel("news");
				appendChannel("mii");
				appendChannel("shop");
				appendChannel("speak");
				extras.append("CH ");
			} else if (key.equals("PHOTO") || key.equals("NET")
					|| key.equals("WEATHER") || key.equals("NEWS")
					|| key.equals("MII") || key.equals("SHOP")
					|| key.equals("SPEAK")) {
				appendChannel(key.toLowerCase());
				extras.append(key + " ");
			} else if (key.equals("theme")) {
				string.append(summary.getString("install") + " DarkWii "
						+ menuItems.getString(value.toLowerCase() + "Theme")
						+ " (");
				extras.append(value + " ");
			} else if (key.equals("effect")) {
				options.append(value + " ");
				if (value.equals("CE:NS"))
					string.append(menuItems.getString("noSpin"));
				else if (value.equals("CE:S"))
					string.append(menuItems.getString("spin"));
				else
					string.append(menuItems.getString("fastSpin"));
				string.append(")\n");
			} else if (key.equals("min"))
				extras.append("min");
			else if (key.equals("HBC")) {
				string.append(installAndOrUpdate + " HomeBrew "
						+ menuItems.getString("channel") + " "
						+ menuItems.getString("andOr") + " BootMii\n");
				extras.append("HBC ");
			} else if (key.equals("REC")) {
				string.append(installAndOrUpdate + " "
						+ menuItems.getString("recommended") + " cIOS"
						+ menuItems.getString("pluralSuffix") + "\n");
				extras.append("REC ");
			} else if (key.equals("YAWMM")) {
				string.append(summary.getString("download")
						+ " Yet Another Wad Manager Mod (YAWMM)\n");
				extras.append("YAWMM ");
			} else if (key.equals("236")) {
				string.append(summary.getString("install") + " cIOS236\n");
				extras.append("236 ");
			} else if (key.equals("Pri")) {
				string.append(installAndOrUpdate + " Priiloader\n");
				extras.append("Pri ");
			} else if (key.equals("activeIOSs")) {
				if (value.equals("UIOS:E"))
					string.append(summary.getString("update") + " "
							+ summary.getString("active") + " IOS"
							+ menuItems.getString("pluralSuffix") + "\n");
				options.append(value + " ");
			} else if (key.equals("usb"))
				extras.append("USB ");
			else if (key.equals("format")) {
				if (value.equals("FAT32") || value.equals("NTFS"))
					string.append(summary.getString("format") + " " + value
							+ "\n");
				extras.append(value + " ");
			} else if (key.equals("loader")) {
				string.append(summary.getString("download") + " ");
				if (value.contains("CFG"))
					string.append("Configurable USB-Loader ");
				if (value.equals("CFG-FLOW"))
					string.append(summary.getString("and") + " ");
				if (value.contains("FLOW"))
					string.append("WiiFlow");
				extras.append(value + " ");
				string.append("\n");
			} else if (key.equals("config")) {
				string.append(summary.getString("config") + " " + value + "\n");
				extras.append(get(key) + "Config ");
			} else if (key.equals("exploit")) {
				String exploit = value;
				extras.append(exploit + " ");
				if (exploit.equals("BOMB"))
					exploit = "LetterBomb";
				string.append(summary.getString("exploit") + " " + exploit
						+ "\n");

			} else if (key.equals("sneekType")) {
				string.append(summary.getString("download") + " " + value
						+ "\n");
				if (value.startsWith("U"))
					if (value.endsWith("DI"))
						args.append("UD ");
					else
						args.append("U ");
				else if (value.endsWith("DI"))
					args.append("SD ");
				else
					args.append("S");
			} else if (key.equals("sdPath"))
				options.append("DRIVE:" + value + "? ");
			else if (key.equals("usbPath"))
				options.append("DRIVEU:" + value + "? ");
		}
		setArgs(args.toString() + extras.toString() + options.toString());
	}

	private void appendChannel(String channel) {
		string.append(summary.getString("install") + " "
				+ menuItems.getString(channel) + menuItems.getString("channel")
				+ "\n");
	}

}
