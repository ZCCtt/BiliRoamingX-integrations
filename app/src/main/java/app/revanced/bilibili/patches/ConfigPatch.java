package app.revanced.bilibili.patches;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;

import app.revanced.bilibili.settings.Settings;
import app.revanced.bilibili.utils.BVUtils;

@Keep
public class ConfigPatch {
    @Nullable
    public static Boolean getAb(String key, @Nullable Boolean defValue, @Nullable Boolean origin) {
        //LogHelper.debug(() -> String.format("ConfigPatch, ab of %s: %s, default: %s", key, origin, defValue));
        if ("ff_switch_account_enable".equals(key))
            return Boolean.TRUE;
        else if ("ff_player_fav_new".equals(key) && Settings.OLD_FAV.getBoolean())
            return Boolean.FALSE;
        else if ("ff_unite_detail2".equals(key)/*>=7.39.0*/ || "ff_unite_player".equals(key)/*<7.39.0*/) {
            String playerVersion = Settings.PLAYER_VERSION.getString();
            if ("1".equals(playerVersion))
                return Boolean.FALSE;
            else if ("2".equals(playerVersion))
                return Boolean.TRUE;
            return origin;
        }
        return origin;
    }

    @Nullable
    public static String getConfig(String key, @Nullable String defValue, @Nullable String origin) {
        //LogHelper.debug(() -> String.format("ConfigPatch, config of %s: %s, default: %s", key, origin, defValue));
        if (Settings.ENABLE_AV.getBoolean() && "bv.enable_bv".equals(key))
            return "0";
        else if (Settings.ENABLE_AV.getBoolean() && "bv.pattern_rule_av_only".equals(key))
            return BVUtils.avOrBvPattern;
        return origin;
    }
}
