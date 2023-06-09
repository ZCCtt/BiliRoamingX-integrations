package app.revanced.bilibili.patches.main;

import app.revanced.bilibili.patches.drawer.DrawerPatch;
import tv.danmaku.bili.MainActivityV2;

public class MainActivityDelegate {
    public static void onCreate(MainActivityV2 activity) {
        DrawerPatch.onMainActivityCreate(activity);
    }

    public static void onStart(MainActivityV2 activity) {
        DrawerPatch.onMainActivityStart(activity);
    }

    public static boolean onBackPressed(MainActivityV2 activity) {
        return DrawerPatch.onMainActivityBackPressed(activity);
    }
}
