package xyz.hydroxa.vulpine_machinery.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xyz.hydroxa.vulpine_machinery.VulpineMachineryMod;
import xyz.hydroxa.vulpine_machinery.client.AmmoHudOverlay;
import xyz.hydroxa.vulpine_machinery.item.custom.WeaponItem;
import xyz.hydroxa.vulpine_machinery.networking.ModMessages;
import xyz.hydroxa.vulpine_machinery.networking.packet.ReloadC2SPacket;
import xyz.hydroxa.vulpine_machinery.util.KeyBinding;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = VulpineMachineryMod.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        private static boolean reloadWasDown = false;
//        @SubscribeEvent
//        public static void onKeyInput(InputEvent.Key event) {
//            if (reloadWasDown || KeyBinding.RELOAD_WEAPON_KEY.isDown()) {
//                reloadWasDown = KeyBinding.RELOAD_WEAPON_KEY.isDown();
//
//                LocalPlayer player = Minecraft.getInstance().player;
//                if (player != null) {
//                    ItemStack item = player.getMainHandItem();
//                    InteractionHand hand = InteractionHand.MAIN_HAND;
//
//                    if (!(item.getItem() instanceof WeaponItem)) {
//                        item = player.getOffhandItem();
//                        hand = InteractionHand.OFF_HAND;
//                    }
//
//                    if (item.getItem() instanceof WeaponItem wi) {
//                        if (!player.isUsingItem()) {
//                            if (reloadWasDown) {
//                                if (wi.canReload(player, item)) {
//                                    wi.setReloading(item, true);
//                                    player.startUsingItem(hand);
//                                }
//                            } else {
//                                wi.setReloading(item, false);
//                                player.stopUsingItem();
//                            }
//                        }
//                    }
//                }
//
//                //ModMessages.sendToServer(new ReloadC2SPacket(reloadWasDown));
//            }
//        }
    }
    @Mod.EventBusSubscriber(modid = VulpineMachineryMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
//        @SubscribeEvent
//        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
//            event.register(KeyBinding.RELOAD_WEAPON_KEY);
//        }

        @SubscribeEvent
        public static void registerGuiOverlays(RegisterGuiOverlaysEvent guiOverlaysEvent) {
            guiOverlaysEvent.registerAboveAll("ammo", AmmoHudOverlay.HUD_AMMO);
        }
    }
}
