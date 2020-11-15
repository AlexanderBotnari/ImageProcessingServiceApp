package config;

public class ConfigurationProvider {

	public String get(String key) {
		if(key.equals("path.originals")) {
			return "images/originals/";
		}else if(key.equals("path.processed")) {
			return "images/processed/";
		}
		return null;
	}
	
    private static class SingletonHolder {
        private static final ConfigurationProvider INSTANCE = new ConfigurationProvider();
    }

    public static ConfigurationProvider getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
