package xox.labvorty.shaderite.utils;

import com.mojang.blaze3d.shaders.Uniform;

public record Mat4x2(
        float m00, float m01, float m02, float m03,
        float m10, float m11, float m12, float m13
) implements UniformValue {
    @Override
    public void apply(Uniform u) {
        u.setMat4x2(m00, m01, m02, m03, m10, m11, m12, m13);
    }
}
