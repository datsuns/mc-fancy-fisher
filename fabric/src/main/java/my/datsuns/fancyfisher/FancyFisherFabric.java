package my.datsuns.fancyfisher;

import net.fabricmc.api.ModInitializer;

public final class FancyFisherFabric implements ModInitializer {
	@Override
	public void onInitialize() {
		FancyFisher.init();
	}
}
