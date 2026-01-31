package xox.labvorty.shaderite.shader;

import oshi.util.tuples.Pair;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * This class is used to bind shaderUniforms to some data accessors
 * <p></p>
 * To prevent any errors bind unforms to shaders at:
 * @see net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
 * <p></p>
 * Suppliers should point to public static or easily accessible values to prevent issues
 */
public class ShaderUniformBinder {
    private static final Map<String, Supplier<?>> suppliers = new HashMap<>();
    private static final Map<Pair<String, String>, Supplier<?>> suppliersSpecific = new HashMap<>();

    /**
     * Used to bind uniforms to unspecified shaders
     * For example UTime will be applied to all shaders that have this uniform
     *
     * @param uniform uniform name
     * @param uniformSupplier supplier
     */
    public static void bind(String uniform, Supplier<?> uniformSupplier) {
        suppliers.put(uniform, uniformSupplier);
    }

    /**
     * Used to bind uniform to specific shader
     *
     * @param shader shader name. Should be passed as modid:shadername
     * @param uniform uniform name
     * @param uniformSupplier supplier
     */
    public static void bindSpecific(String shader, String uniform, Supplier<?> uniformSupplier) {
        suppliersSpecific.put(
                new Pair<>(shader, uniform),
                uniformSupplier
        );
    }

    public static Map<String, Supplier<?>> getSuppliers() {
        return suppliers;
    }

    public static Map<Pair<String, String>, Supplier<?>> getSuppliersSpecific() {
        return suppliersSpecific;
    }
}
