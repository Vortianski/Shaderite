package xox.labvorty.shaderite.utils;

import com.mojang.blaze3d.shaders.Uniform;

public record Mat3x3(
        float m00, float m01, float m02,
        float m10, float m11, float m12,
        float m20, float m21, float m22
) implements UniformValue {
    @Override
    public void apply(Uniform u) {
        u.setMat3x3(
                m00, m01, m02,
                m10, m11, m12,
                m20, m21, m22
        );
    }
}