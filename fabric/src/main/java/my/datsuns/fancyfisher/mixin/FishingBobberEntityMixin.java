package my.datsuns.fancyfisher.mixin;

import my.datsuns.fancyfisher.FancyFisherFabricHooks;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FishingBobberEntity.class)
abstract class FishingBobberEntityMixin {
	@Inject(method = "use", at = @At("RETURN"))
	private void fancyfisher$spawnCatchParticles(ItemStack fishingRod, CallbackInfoReturnable<Integer> cir) {
		if (cir.getReturnValueI() <= 0) {
			return;
		}

		FancyFisherFabricHooks.spawnCatchParticles((FishingBobberEntity) (Object) this);
	}
}
