package xox.labvorty.shaderite.rendering;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderFrameEvent;
import xox.labvorty.shaderite.shader.PostShaderRunnerHandler;

/**
 * This class handles all post shader running
 * Can only support one post shader
 */

@EventBusSubscriber(value = Dist.CLIENT)
public class PostShaderRunner {
    @SubscribeEvent
    public static void render(RenderFrameEvent.Post event) {
        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;

        if (player != null) {
            if (PostShaderRunnerHandler.run) {
                try {
                    minecraft.gameRenderer.loadEffect(
                            PostShaderRunnerHandler.getShader()
                    );
                    PostShaderRunnerHandler.setShouldRun(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                if (!PostShaderRunnerHandler.shouldRun()) {
                    minecraft.gameRenderer.shutdownEffect();
                    PostShaderRunnerHandler.setShouldRun(true);
                }
            }
        }
    }
}
