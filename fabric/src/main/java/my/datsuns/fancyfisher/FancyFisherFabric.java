package my.datsuns.fancyfisher;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Fabric entry point that bootstraps shared Fancy Fisher logic.
 */
public final class FancyFisherFabric implements ModInitializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(FancyFisher.MOD_ID);

	@Override
	public void onInitialize() {
		FancyFisher.init();
		LOGGER.info("Fancy Fisher (Fabric) initialized");
	}
}
