package xox.labvorty.shaderite.utils;

import com.mojang.blaze3d.shaders.Uniform;

@FunctionalInterface
public interface UniformValue {
    void apply(Uniform uniform);
}
