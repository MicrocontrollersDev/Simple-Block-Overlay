package dev.microcontrollers.simpleblockoverlay.util;

import dev.microcontrollers.simpleblockoverlay.config.SimpleBlockOverlayConfig;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import java.awt.*;

public class ColorUtil {
    /*
     * This method is taken from ClearHitboxes's ColorUtils by Splzh
     * https://github.com/Splzh/ClearHitboxes/blob/main/src/main/java/splash/utils/ColorUtils.java
     * Taken under the MIT License
     * https://github.com/Splzh/ClearHitboxes/blob/main/LICENSE
     * Code has been modified to fit this project.
     */
    public static Color rainbow() {
        double rainbowState = Math.ceil(System.currentTimeMillis()) * SimpleBlockOverlayConfig.CONFIG.instance().speed / 2F;
        rainbowState %= 360;
        return Color.getHSBColor((float) (rainbowState / 360.0F), SimpleBlockOverlayConfig.CONFIG.instance().saturation, SimpleBlockOverlayConfig.CONFIG.instance().brightness);
    }

    public static void setLineColor(Args args, int offset) {
        float red, green, blue;
        if (SimpleBlockOverlayConfig.CONFIG.instance().chroma) {
            Color color = ColorUtil.rainbow();
            red = color.getRed();
            green = color.getGreen();
            blue = color.getBlue();
        } else {
            red = SimpleBlockOverlayConfig.CONFIG.instance().red;
            green = SimpleBlockOverlayConfig.CONFIG.instance().green;
            blue = SimpleBlockOverlayConfig.CONFIG.instance().blue;
        }
        args.set(6 - offset, red / 255F);
        args.set(7 - offset, green / 255F);
        args.set(8 - offset, blue / 255F);
        args.set(9 - offset, SimpleBlockOverlayConfig.CONFIG.instance().alpha / 255F);
    }
}

