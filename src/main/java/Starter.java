import com.hazelcast.config.Config;
import com.hazelcast.config.UserCodeDeploymentConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

/**
 * @author pavel.arakelyan on 7/10/17.
 */
public class Starter {

	public static void main(String[] args) {
//		IgniteConfiguration cfg = new IgniteConfiguration();
//		cfg.setPeerClassLoadingEnabled(true);
////		cfg.setClassLoader(Starter.class.getClassLoader());
//		cfg.setClientMode(false);
//		Ignition.start(cfg);
		Config config = new Config();
		config.setClassLoader(Thread.currentThread().getContextClassLoader());
		UserCodeDeploymentConfig distCLConfig = config.getUserCodeDeploymentConfig();
		distCLConfig.setEnabled( true )
				.setClassCacheMode( UserCodeDeploymentConfig.ClassCacheMode.ETERNAL )
				.setProviderMode( UserCodeDeploymentConfig.ProviderMode.LOCAL_AND_CACHED_CLASSES );
//				.setBlacklistedPrefixes( "com.foo" )
//				.setProviderFilter( "HAS_ATTRIBUTE:lite" );
		HazelcastInstance hzInstance = Hazelcast.newHazelcastInstance(config);
	}
}
