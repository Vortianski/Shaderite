package xox.labvorty.shaderite.utils;

import com.mojang.blaze3d.shaders.Uniform;

public record Mat3x2(
        float m00, float m01,
        float m10, float m11,
        float m20, float m21
) implements UniformValue {
    @Override
    public void apply(Uniform u) {
        u.setMat3x2(m00, m01, m10, m11, m20, m21);
    }
}