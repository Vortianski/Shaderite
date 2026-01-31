package xox.labvorty.shaderite.mixins;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.shaders.Uniform;
import net.minecraft.client.renderer.PostChain;
import net.minecraft.client.renderer.PostPass;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import oshi.util.tuples.Pair;
import xox.labvorty.shaderite.shader.ShaderUniformBinder;
import xox.labvorty.shaderite.utils.*;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * This is a mixin that handles all uniform values
 */

@Mixin(PostChain.class)
public class PostChainMixin {
    @Shadow
    private final List<PostPass> passes = Lists.newArrayList();

    @Inject(method = "process", at = @At("HEAD"))
    private void steptracker$setUniform(float tickDelta, CallbackInfo ci) {
        Map<String, Supplier<?>> suppliers = ShaderUniformBinder.getSuppliers();

        for (Map.Entry<String, Supplier<?>> entry : suppliers.entrySet()) {
            Object value = entry.getValue().get();

            if (value instanceof Float val) {
                shaderite$setUniform(entry.getKey(), val);
            } else if (value instanceof float[] val) {
                shaderite$setUniform(entry.getKey(), val);
            } else if (value instanceof Integer val) {
                shaderite$setUniform(entry.getKey(), val);
            } else if (value instanceof int[] val) {
                shaderite$setUniform(entry.getKey(), val);
            } else if (value instanceof Vector3f val) {
                shaderite$setUniform(entry.getKey(), val);
            } else if (value instanceof Vector4f val) {
                shaderite$setUniform(entry.getKey(), val);
            } else if (value instanceof Matrix3f val) {
                shaderite$setUniform(entry.getKey(), val);
            } else if (value instanceof Matrix4f val) {
                shaderite$setUniform(entry.getKey(), val);
            } else if (value instanceof Mat2x2 val) {
                shaderite$setUniform(entry.getKey(), val);
            } else if (value instanceof Mat2x3 val) {
                shaderite$setUniform(entry.getKey(), val);
            } else if (value instanceof Mat2x4 val) {
                shaderite$setUniform(entry.getKey(), val);
            } else if (value instanceof Mat3x2 val) {
                shaderite$setUniform(entry.getKey(), val);
            } else if (value instanceof Mat3x3 val) {
                shaderite$setUniform(entry.getKey(), val);
            } else if (value instanceof Mat3x4 val) {
                shaderite$setUniform(entry.getKey(), val);
            } else if (value instanceof Mat4x2 val) {
                shaderite$setUniform(entry.getKey(), val);
            } else if (value instanceof Mat4x3 val) {
                shaderite$setUniform(entry.getKey(), val);
            } else if (value instanceof Mat4x4 val) {
                shaderite$setUniform(entry.getKey(), val);
            }
        }

        Map<Pair<String, String>, Supplier<?>> suppliersSpecific = ShaderUniformBinder.getSuppliersSpecific();

        for (Map.Entry<Pair<String, String>, Supplier<?>> entry : suppliersSpecific.entrySet()) {
            Object value = entry.getValue().get();

            if (value instanceof Float val) {
                shaderite$setUniformSpecific(entry.getKey().getA(), entry.getKey().getB(), val);
            } else if (value instanceof float[] val) {
                shaderite$setUniformSpecific(entry.getKey().getA(), entry.getKey().getB(), val);
            } else if (value instanceof Integer val) {
                shaderite$setUniformSpecific(entry.getKey().getA(), entry.getKey().getB(), val);
            } else if (value instanceof int[] val) {
                shaderite$setUniformSpecific(entry.getKey().getA(), entry.getKey().getB(), val);
            } else if (value instanceof Vector3f val) {
                shaderite$setUniformSpecific(entry.getKey().getA(), entry.getKey().getB(), val);
            } else if (value instanceof Vector4f val) {
                shaderite$setUniformSpecific(entry.getKey().getA(), entry.getKey().getB(), val);
            } else if (value instanceof Matrix3f val) {
                shaderite$setUniformSpecific(entry.getKey().getA(), entry.getKey().getB(), val);
            } else if (value instanceof Matrix4f val) {
                shaderite$setUniformSpecific(entry.getKey().getA(), entry.getKey().getB(), val);
            } else if (value instanceof Mat2x2 val) {
                shaderite$setUniformSpecific(entry.getKey().getA(), entry.getKey().getB(), val);
            } else if (value instanceof Mat2x3 val) {
                shaderite$setUniformSpecific(entry.getKey().getA(), entry.getKey().getB(), val);
            } else if (value instanceof Mat2x4 val) {
                shaderite$setUniformSpecific(entry.getKey().getA(), entry.getKey().getB(), val);
            } else if (value instanceof Mat3x2 val) {
                shaderite$setUniformSpecific(entry.getKey().getA(), entry.getKey().getB(), val);
            } else if (value instanceof Mat3x3 val) {
                shaderite$setUniformSpecific(entry.getKey().getA(), entry.getKey().getB(), val);
            } else if (value instanceof Mat3x4 val) {
                shaderite$setUniformSpecific(entry.getKey().getA(), entry.getKey().getB(), val);
            } else if (value instanceof Mat4x2 val) {
                shaderite$setUniformSpecific(entry.getKey().getA(), entry.getKey().getB(), val);
            } else if (value instanceof Mat4x3 val) {
                shaderite$setUniformSpecific(entry.getKey().getA(), entry.getKey().getB(), val);
            } else if (value instanceof Mat4x4 val) {
                shaderite$setUniformSpecific(entry.getKey().getA(), entry.getKey().getB(), val);
            }
        }
    }

    @Unique
    private void shaderite$setUniform(String uniform, float... values) {
        for (PostPass postpass : this.passes) {
            var u = postpass.getEffect().safeGetUniform(uniform);
            switch (values.length) {
                case 1 -> u.set(values[0]);
                case 2 -> u.set(values[0], values[1]);
                case 3 -> u.set(values[0], values[1], values[2]);
                case 4 -> u.set(values[0], values[1], values[2], values[3]);
                default -> throw new IllegalArgumentException("Unsupported uniform length: " + values.length);
            }
        }
    }

    @Unique
    private void shaderite$setUniformSpecific(String shader, String uniform, float... values) {
        for (PostPass postpass : this.passes) {
            if (postpass.getEffect().getName().equals(shader)) {
                var u = postpass.getEffect().safeGetUniform(uniform);
                switch (values.length) {
                    case 1 -> u.set(values[0]);
                    case 2 -> u.set(values[0], values[1]);
                    case 3 -> u.set(values[0], values[1], values[2]);
                    case 4 -> u.set(values[0], values[1], values[2], values[3]);
                    default -> throw new IllegalArgumentException("Unsupported uniform length: " + values.length);
                }
            }
        }
    }

    @Unique
    private void shaderite$setUniform(String uniform, int... values) {
        for (PostPass postpass : this.passes) {
            var u = postpass.getEffect().safeGetUniform(uniform);
            switch (values.length) {
                case 1 -> u.set(values[0]);
                case 2 -> u.set(values[0], values[1]);
                case 3 -> u.set(values[0], values[1], values[2]);
                case 4 -> u.set(values[0], values[1], values[2], values[3]);
                default -> throw new IllegalArgumentException("Unsupported uniform length: " + values.length);
            }
        }
    }

    @Unique
    private void shaderite$setUniformSpecific(String shader, String uniform, int... values) {
        for (PostPass postpass : this.passes) {
            if (postpass.getEffect().getName().equals(shader)) {
                var u = postpass.getEffect().safeGetUniform(uniform);
                switch (values.length) {
                    case 1 -> u.set(values[0]);
                    case 2 -> u.set(values[0], values[1]);
                    case 3 -> u.set(values[0], values[1], values[2]);
                    case 4 -> u.set(values[0], values[1], values[2], values[3]);
                    default -> throw new IllegalArgumentException("Unsupported uniform length: " + values.length);
                }
            }
        }
    }

    @Unique
    public void shaderite$setUniform(String uniform, Vector3f vector3f) {
        for (PostPass postpass : this.passes) {
            Uniform u = postpass.getEffect().getUniform(uniform);
            if (u != null) {
                u.set(vector3f);
            }
        }
    }

    @Unique
    public void shaderite$setUniformSpecific(String shader, String uniform, Vector3f vector3f) {
        for (PostPass postpass : this.passes) {
            if (postpass.getEffect().getName().equals(shader)) {
                Uniform u = postpass.getEffect().getUniform(uniform);
                if (u != null) {
                    u.set(vector3f);
                }
            }
        }
    }

    @Unique
    public void shaderite$setUniform(String uniform, Vector4f vector4f) {
        for (PostPass postpass : this.passes) {
            Uniform u = postpass.getEffect().getUniform(uniform);
            if (u != null) {
                u.set(vector4f);
            }
        }
    }

    @Unique
    public void shaderite$setUniformSpecific(String shader, String uniform, Vector4f vector4f) {
        for (PostPass postpass : this.passes) {
            if (postpass.getEffect().getName().equals(shader)) {
                Uniform u = postpass.getEffect().getUniform(uniform);
                if (u != null) {
                    u.set(vector4f);
                }
            }
        }
    }

    @Unique
    public void shaderite$setUniform(String uniform, Matrix3f matrix3f) {
        for (PostPass postpass : this.passes) {
            Uniform u = postpass.getEffect().getUniform(uniform);
            if (u != null) {
                u.set(matrix3f);
            }
        }
    }

    @Unique
    public void shaderite$setUniformSpecific(String shader, String uniform, Matrix3f matrix3f) {
        for (PostPass postpass : this.passes) {
            if (postpass.getEffect().getName().equals(shader)) {
                Uniform u = postpass.getEffect().getUniform(uniform);
                if (u != null) {
                    u.set(matrix3f);
                }
            }
        }
    }

    @Unique
    public void shaderite$setUniform(String uniform, Matrix4f matrix4f) {
        for (PostPass postpass : this.passes) {
            Uniform u = postpass.getEffect().getUniform(uniform);
            if (u != null) {
                u.set(matrix4f);
            }
        }
    }

    @Unique
    public void shaderite$setUniformSpecific(String shader, String uniform, Matrix4f matrix4f) {
        for (PostPass postpass : this.passes) {
            if (postpass.getEffect().getName().equals(shader)) {
                Uniform u = postpass.getEffect().getUniform(uniform);
                if (u != null) {
                    u.set(matrix4f);
                }
            }
        }
    }

    @Unique
    public void shaderite$setUniform(String uniform, Mat2x2 mat2x2) {
        for (PostPass postpass : this.passes) {
            Uniform u = postpass.getEffect().getUniform(uniform);
            if (u != null) {
                mat2x2.apply(u);
            }
        }
    }

    @Unique
    public void shaderite$setUniformSpecific(String shader, String uniform, Mat2x2 mat2x2) {
        for (PostPass postpass : this.passes) {
            if (postpass.getEffect().getName().equals(shader)) {
                Uniform u = postpass.getEffect().getUniform(uniform);
                if (u != null) {
                    mat2x2.apply(u);
                }
            }
        }
    }

    @Unique
    public void shaderite$setUniform(String uniform, Mat2x3 mat2x3) {
        for (PostPass postpass : this.passes) {
            Uniform u = postpass.getEffect().getUniform(uniform);
            if (u != null) {
                mat2x3.apply(u);
            }
        }
    }

    @Unique
    public void shaderite$setUniformSpecific(String shader, String uniform, Mat2x3 mat2x3) {
        for (PostPass postpass : this.passes) {
            if (postpass.getEffect().getName().equals(shader)) {
                Uniform u = postpass.getEffect().getUniform(uniform);
                if (u != null) {
                    mat2x3.apply(u);
                }
            }
        }
    }

    @Unique
    public void shaderite$setUniform(String uniform, Mat2x4 mat2x4) {
        for (PostPass postpass : this.passes) {
            Uniform u = postpass.getEffect().getUniform(uniform);
            if (u != null) {
                mat2x4.apply(u);
            }
        }
    }

    @Unique
    public void shaderite$setUniformSpecific(String shader, String uniform, Mat2x4 mat2x4) {
        for (PostPass postpass : this.passes) {
            if (postpass.getEffect().getName().equals(shader)) {
                Uniform u = postpass.getEffect().getUniform(uniform);
                if (u != null) {
                    mat2x4.apply(u);
                }
            }
        }
    }

    @Unique
    public void shaderite$setUniform(String uniform, Mat3x2 mat3x2) {
        for (PostPass postpass : this.passes) {
            Uniform u = postpass.getEffect().getUniform(uniform);
            if (u != null) {
                mat3x2.apply(u);
            }
        }
    }

    @Unique
    public void shaderite$setUniformSpecific(String shader, String uniform, Mat3x2 mat3x2) {
        for (PostPass postpass : this.passes) {
            if (postpass.getEffect().getName().equals(shader)) {
                Uniform u = postpass.getEffect().getUniform(uniform);
                if (u != null) {
                    mat3x2.apply(u);
                }
            }
        }
    }

    @Unique
    public void shaderite$setUniform(String uniform, Mat3x3 mat3x3) {
        for (PostPass postpass : this.passes) {
            Uniform u = postpass.getEffect().getUniform(uniform);
            if (u != null) {
                mat3x3.apply(u);
            }
        }
    }

    @Unique
    public void shaderite$setUniformSpecific(String shader, String uniform, Mat3x3 mat3x3) {
        for (PostPass postpass : this.passes) {
            if (postpass.getEffect().getName().equals(shader)) {
                Uniform u = postpass.getEffect().getUniform(uniform);
                if (u != null) {
                    mat3x3.apply(u);
                }
            }
        }
    }

    @Unique
    public void shaderite$setUniform(String uniform, Mat3x4 mat3x4) {
        for (PostPass postpass : this.passes) {
            Uniform u = postpass.getEffect().getUniform(uniform);
            if (u != null) {
                mat3x4.apply(u);
            }
        }
    }

    @Unique
    public void shaderite$setUniformSpecific(String shader, String uniform, Mat3x4 mat3x4) {
        for (PostPass postpass : this.passes) {
            if (postpass.getEffect().getName().equals(shader)) {
                Uniform u = postpass.getEffect().getUniform(uniform);
                if (u != null) {
                    mat3x4.apply(u);
                }
            }
        }
    }

    @Unique
    public void shaderite$setUniform(String uniform, Mat4x2 mat4x2) {
        for (PostPass postpass : this.passes) {
            Uniform u = postpass.getEffect().getUniform(uniform);
            if (u != null) {
                mat4x2.apply(u);
            }
        }
    }

    @Unique
    public void shaderite$setUniformSpecific(String shader, String uniform, Mat4x2 mat4x2) {
        for (PostPass postpass : this.passes) {
            if (postpass.getEffect().getName().equals(shader)) {
                Uniform u = postpass.getEffect().getUniform(uniform);
                if (u != null) {
                    mat4x2.apply(u);
                }
            }
        }
    }

    @Unique
    public void shaderite$setUniform(String uniform, Mat4x3 mat4x3) {
        for (PostPass postpass : this.passes) {
            Uniform u = postpass.getEffect().getUniform(uniform);
            if (u != null) {
                mat4x3.apply(u);
            }
        }
    }

    @Unique
    public void shaderite$setUniformSpecific(String shader, String uniform, Mat4x3 mat4x3) {
        for (PostPass postpass : this.passes) {
            if (postpass.getEffect().getName().equals(shader)) {
                Uniform u = postpass.getEffect().getUniform(uniform);
                if (u != null) {
                    mat4x3.apply(u);
                }
            }
        }
    }

    @Unique
    public void shaderite$setUniform(String uniform, Mat4x4 mat4x4) {
        for (PostPass postpass : this.passes) {
            Uniform u = postpass.getEffect().getUniform(uniform);
            if (u != null) {
                mat4x4.apply(u);
            }
        }
    }

    @Unique
    public void shaderite$setUniformSpecific(String shader, String uniform, Mat4x4 mat4x4) {
        for (PostPass postpass : this.passes) {
            if (postpass.getEffect().getName().equals(shader)) {
                Uniform u = postpass.getEffect().getUniform(uniform);
                if (u != null) {
                    mat4x4.apply(u);
                }
            }
        }
    }
}