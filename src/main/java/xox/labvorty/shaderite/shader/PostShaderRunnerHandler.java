package xox.labvorty.shaderite.shader;

import net.minecraft.resources.ResourceLocation;

public class PostShaderRunnerHandler {
    private static ResourceLocation shader;
    private static boolean shouldRun = true;
    public static boolean run = false;

    /**
     *
     * @param s resourceLocation of post-processing shader
     * Should be passed as ResourceLocation.parse("modid:shaders/post/yourshader.json") or in any similar to it way
     */
    public static void setShader(ResourceLocation s) {
        shader = s;
    }

    /**
     * Do not use, handled internally
     * @see #setRun(boolean)
     *
     * @param s parameter that sets if shader should run now
     */
    public static void setShouldRun(boolean s) {
        shouldRun = s;
    }

    /**
     * Use this to run shaders
     *
     * @param r parameter that sets if shader should run
     */
    public static void setRun(boolean r) {
        run = r;
    }

    public static ResourceLocation getShader() {
        return shader;
    }

    public static boolean shouldRun() {
        return shouldRun;
    }
}
