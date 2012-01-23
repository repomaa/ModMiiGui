package tools;

import gui.MainWindow;

import java.util.ResourceBundle;

public class WizardCollector extends DataCollector {
	
	private ResourceBundle summary = MainWindow.summary;
	private ResourceBundle menuItems = MainWindow.menuItems;
	
	@Override
	public String toString() {
		StringBuffer args = new StringBuffer();
		StringBuffer options = new StringBuffer();
		StringBuffer sb = new StringBuffer();
		String installAndOrUpdate = summary.getString("install") + " " + menuItems.getString("andOr") + " " + summary.getString("update").toLowerCase() + " ";
		for(String key : data.keySet()) {
			if(key.equals("firstTime"))
				if(data.get("firstTime").equals("true"))
					sb.append(summary.getString("installSoftmods") + "\n");
				else {
					
				}
			else if(key.equals("firmware")) {
				String firmware = data.get(key);
				args.append(firmware + " ");
				sb.append(summary.getString("current") + " ");
				if(firmware.equals("O"))
					sb.append(summary.getString("less") + "2.2");
				else
					sb.append(firmware);
				String region = data.get("region");
				if(region != null) {
					sb.append(region + "\n");
					if(!getMode().equals("HS"))
						args.append(region + " ");
				}
			}
			else if(key.equals("newFirmware")) {
				String newFirmware = data.get(key);
				String region = data.get("region");
				sb.append(summary.getString("desired") + " " + newFirmware + region + "\n");
				args.append(newFirmware + " ");
			}
			else if(key.equals("PHOTO") || key.equals("NET") || key.equals("WEATHER") || key.equals("NEWS") || key.equals("MII") || key.equals("SHOP") || key.equals("SPEAK")) {
				sb.append(summary.getString("install") + " " + menuItems.getString(key.toLowerCase()) + " " + menuItems.getString("channel") + "\n");
				args.append(key + " ");
			}
			else if(key.equals("theme")) {
				sb.append(summary.getString("install") + " DarkWii " + menuItems.getString(data.get(key).toLowerCase() + "Theme") + " (");
				args.append(data.get("theme") + " ");
				options.append(data.get("effect") + " ");
				if(data.get("effect").equals("CE:NS"))
					sb.append(menuItems.getString("noSpin"));
				else if(data.get("effect").equals("CE:S"))
					sb.append(menuItems.getString("spin"));
				else sb.append(menuItems.getString("fastSpin"));
				sb.append(")\n");
			}
			else if(key.equals("min"))
				args.append("min ");
			else if(key.equals("HBC")) {
				sb.append(installAndOrUpdate + " HomeBrew " + menuItems.getString("channel") + " " + menuItems.getString("andOr") + " BootMii\n");
				args.append("HBC ");
			}
			else if(key.equals("REC")) {
				sb.append(installAndOrUpdate + " " + menuItems.getString("recommended") + " cIOS" + menuItems.getString("pluralSuffix") + "\n");
				args.append("REC ");
			}
			else if(key.equals("YAWMM")) {
				sb.append(summary.getString("download") + " Yet Another Wad Manager Mod (YAWMM)\n");
				args.append("YAWMM ");
			}
			else if(key.equals("236")) {
				sb.append(summary.getString("install") + " cIOS236\n");
				args.append("236 ");
			}
			else if(key.equals("Pri")) {
				sb.append(installAndOrUpdate + " Priiloader\n");
				args.append("Pri ");
			}
			else if(key.equals("activeIOSs")) {
				if(get(key).equals("UIOS:E"))
					sb.append(summary.getString("update") + " " + summary.getString("active") + " IOS" + menuItems.getString("pluralSuffix"));
				options.append(get(key) + " ");
			}
			else if(key.equals("usb"))
				args.append("USB ");
			else if(key.equals("format")) {
				if(get(key).equals("FAT32") || get(key).equals("NTFS"))
					sb.append(summary.getString("format") + " " + get(key) + "\n");
				args.append(get(key) + " ");
			}
			else if(key.equals("loader")) {
				sb.append(summary.getString("download") + " ");
				String loader = (String)get(key);
				if(loader.contains("CFG"))
					sb.append("Configurable USB-Loader ");
				if(loader.equals("CFG-FLOW"))
					sb.append(summary.getString("and") + " ");
				if(loader.contains("FLOW"))
					sb.append("WiiFlow");
				args.append(loader + " ");
				sb.append("\n");
			}
			else if(key.equals("config")) {
				sb.append(summary.getString("config") + " " + get(key) + "\n");
				args.append(get(key) + "Config ");
			}
			else if(key.equals("exploit")) {
				String exploit = (String)get(key);
				args.append(exploit + " ");
				if(exploit.equals("BOMB"))
					exploit = "LetterBomb";
				sb.append(summary.getString("exploit") + " " + exploit + "\n");
				
			}
		}
		setArgs(args.toString() + options.toString());
		return sb.toString() + "\n\n" + getCmd();	
	}

}
