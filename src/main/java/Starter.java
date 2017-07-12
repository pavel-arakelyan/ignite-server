import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;

/**
 * @author pavel.arakelyan on 7/10/17.
 */
public class Starter {

	public static void main(String[] args) {
		IgniteConfiguration cfg = new IgniteConfiguration();
		cfg.setPeerClassLoadingEnabled(true);
//		cfg.setClassLoader(Starter.class.getClassLoader());
		cfg.setClientMode(false);
		Ignition.start(cfg);
	}
}
