package my.datsuns.fancyfisher;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

final class FancyFisherNeoForgeHooks {
	private FancyFisherNeoForgeHooks() {
	}

	static void spawnCatchParticles(FishingHook hook) {
		if (hook == null) {
			return;
		}

		Level level = hook.level();
		if (!(level instanceof ServerLevel serverLevel)) {
			return;
		}

		Vec3 position = hook.position();
		double baseX = position.x;
		double baseY = position.y;
		double baseZ = position.z;

		serverLevel.sendParticles(
				ParticleTypes.HAPPY_VILLAGER,
				baseX,
				baseY + 0.2D,
				baseZ,
				FancyFisherParticles.CATCH_HAPPY_COUNT,
				FancyFisherParticles.CATCH_HAPPY_HORIZONTAL_SPREAD,
				FancyFisherParticles.CATCH_HAPPY_VERTICAL_SPREAD,
				FancyFisherParticles.CATCH_HAPPY_HORIZONTAL_SPREAD,
				FancyFisherParticles.CATCH_HAPPY_SPEED
		);

		serverLevel.sendParticles(
				ParticleTypes.SPLASH,
				baseX,
				baseY,
				baseZ,
				FancyFisherParticles.CATCH_SPLASH_COUNT,
				FancyFisherParticles.CATCH_SPLASH_HORIZONTAL_SPREAD,
				FancyFisherParticles.CATCH_SPLASH_VERTICAL_SPREAD,
				FancyFisherParticles.CATCH_SPLASH_HORIZONTAL_SPREAD,
				FancyFisherParticles.CATCH_SPLASH_SPEED
		);

		serverLevel.sendParticles(
				ParticleTypes.CRIT,
				baseX,
				baseY + FancyFisherParticles.CATCH_CRIT_VERTICAL_OFFSET,
				baseZ,
				FancyFisherParticles.CATCH_CRIT_COUNT,
				FancyFisherParticles.CATCH_CRIT_HORIZONTAL_SPREAD,
				FancyFisherParticles.CATCH_CRIT_VERTICAL_SPREAD,
				FancyFisherParticles.CATCH_CRIT_HORIZONTAL_SPREAD,
				FancyFisherParticles.CATCH_CRIT_SPEED
		);

		double angleStep = Mth.TWO_PI / FancyFisherParticles.CATCH_RING_POINTS;
		for (int index = 0; index < FancyFisherParticles.CATCH_RING_POINTS; index++) {
			double angle = angleStep * index;
			double offsetX = Math.cos(angle) * FancyFisherParticles.CATCH_RING_RADIUS;
			double offsetZ = Math.sin(angle) * FancyFisherParticles.CATCH_RING_RADIUS;

			serverLevel.sendParticles(
					ParticleTypes.BUBBLE,
					baseX + offsetX,
					baseY + FancyFisherParticles.CATCH_RING_VERTICAL_OFFSET,
					baseZ + offsetZ,
					2,
					FancyFisherParticles.CATCH_RING_SPREAD,
					FancyFisherParticles.CATCH_RING_SPREAD,
					FancyFisherParticles.CATCH_RING_SPREAD,
					FancyFisherParticles.CATCH_RING_SPEED
			);
		}

		serverLevel.sendParticles(
				ParticleTypes.GLOW,
				baseX,
				baseY + FancyFisherParticles.CATCH_GLOW_VERTICAL_OFFSET,
				baseZ,
				FancyFisherParticles.CATCH_GLOW_COUNT,
				FancyFisherParticles.CATCH_GLOW_HORIZONTAL_SPREAD,
				FancyFisherParticles.CATCH_GLOW_VERTICAL_SPREAD,
				FancyFisherParticles.CATCH_GLOW_HORIZONTAL_SPREAD,
				FancyFisherParticles.CATCH_GLOW_SPEED
		);
	}
}
