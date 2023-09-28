package xyz.hydroxa.vulpine_machinery.item.custom.gunpart.cores;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.phys.EntityHitResult;
import xyz.hydroxa.vulpine_machinery.item.custom.gunpart.CoreItem;
import xyz.hydroxa.vulpine_machinery.item.custom.gunpart.CoreProperties;
import xyz.hydroxa.vulpine_machinery.world.ModDamageSource;

import java.util.Timer;
import java.util.TimerTask;

public class AssassinCoreItem extends CoreItem {
    public static final int BASE_DURATION = 200;
    public static final int BASE_COUNTDOWN = 600;
    public static final int BASE_AMPLIFIER = 7;

    public AssassinCoreItem(Item.Properties pProperties, CoreProperties properties) {
        super(pProperties, properties);
    }

    @Override
    public void onEntityHit(Projectile entity, Entity owner, EntityHitResult hitResult, float baseDamage) {
        hitResult.getEntity().hurt(ModDamageSource.shot_with_gun(entity, owner), 0);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (hitResult.getEntity() instanceof LivingEntity live) {
                    live.addEffect(new MobEffectInstance(MobEffects.POISON, BASE_DURATION, BASE_AMPLIFIER));
                }
            }
        }, 50 * BASE_COUNTDOWN);
    }
}