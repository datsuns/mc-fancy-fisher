package my.datsuns.fancyfisher;

import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/**
 * Fabric-specific helpers for Fancy Fisher effects.
 */
public final class FancyFisherFabricHooks {
	private FancyFisherFabricHooks() {
	}

	public static void spawnCatchParticles(FishingBobberEntity bobberEntity) {
		World world = bobberEntity.getEntityWorld();
		if (!(world instanceof ServerWorld serverWorld)) {
			return;
		}

		Vec3d position = bobberEntity.getEntityPos();
		double baseX = position.x;
		double baseY = position.y;
		double baseZ = position.z;

		serverWorld.spawnParticles(
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

		serverWorld.spawnParticles(
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

		serverWorld.spawnParticles(
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

		double angleStep = MathHelper.TAU / FancyFisherParticles.CATCH_RING_POINTS;
		for (int index = 0; index < FancyFisherParticles.CATCH_RING_POINTS; index++) {
			double angle = angleStep * index;
			double offsetX = Math.cos(angle) * FancyFisherParticles.CATCH_RING_RADIUS;
			double offsetZ = Math.sin(angle) * FancyFisherParticles.CATCH_RING_RADIUS;

			serverWorld.spawnParticles(
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

		serverWorld.spawnParticles(
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
