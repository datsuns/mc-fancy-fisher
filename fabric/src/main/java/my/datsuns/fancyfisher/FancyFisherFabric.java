package my.datsuns.fancyfisher;

import net.fabricmc.api.ModInitializer;

/**
 * Fabric entrypoint for Fancy Fisher.
 */
public final class FancyFisherFabric implements ModInitializer {
	@Override
	public void onInitialize() {
		FancyFisher.init();
	}
}
