package one.devos.nautical.dudewhatsmygepeuwu.mixin;

import com.mojang.blaze3d.platform.GlUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.Util;
import one.devos.nautical.dudewhatsmygepeuwu.client.DudeWhatsMyGePeUwuClient;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Supplier;

import static one.devos.nautical.dudewhatsmygepeuwu.client.DudeWhatsMyGePeUwuClient.MOD_NAME;

// stereo im personally going to end you for using yarn mappings,
// i had to slightly painfully translate this all to mojmap :crysis:
// - aubee

@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen {

	protected TitleScreenMixin(Font title) {
		super((Component) title);
	}

	@Shadow @Final private boolean fading;
	@Shadow private long fadeInStart;
	Supplier<String> renderer = GlUtil::getRenderer;

	@Inject(method = "render", at = @At("TAIL"))
	protected void funnyGPU(PoseStack poseStack, int xMouse, int yMouse, float delta, CallbackInfo ci) {

		float f = this.fading ? (float)(Util.getMillis() - this.fadeInStart) / 1000.0F : 1.0F;
		float g = this.fading ? Mth.clamp(f - 1.0F, 0.0F, 1.0F) : 1.0F;
		int l = Mth.ceil(g * 255.0F) << 24;

		drawString(poseStack, this.font,"Current GePeUwu: " + renderer.get().split("/.*$")[0], 2, 2, 16777215 | l);

	}

	@Inject(method = "init", at = @At("TAIL"))
	protected void funnyGPUPrint(CallbackInfo info) {
		DudeWhatsMyGePeUwuClient.LOGGER.info("[" + MOD_NAME + "] Current GePeUwu: " + renderer.get());
	}
}