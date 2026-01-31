package xox.labvorty.shaderite;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

@Mod(Shaderite.MODID)
public class Shaderite {
    public static final String MODID = "shaderite";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Shaderite(IEventBus modEventBus, ModContainer modContainer) {

    }
}
