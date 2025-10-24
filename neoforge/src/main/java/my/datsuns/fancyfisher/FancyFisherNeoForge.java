package my.datsuns.fancyfisher;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.ItemFishedEvent;

@Mod(FancyFisher.MOD_ID)
public final class FancyFisherNeoForge {
	public FancyFisherNeoForge(IEventBus modEventBus, ModContainer modContainer) {
		FancyFisher.init();
		NeoForge.EVENT_BUS.addListener(FancyFisherNeoForge::onItemFished);
	}

	private static void onItemFished(ItemFishedEvent event) {
		if (event.getDrops().isEmpty()) {
			return;
		}

		FancyFisherNeoForgeHooks.spawnCatchParticles(event.getHookEntity());
	}
}
