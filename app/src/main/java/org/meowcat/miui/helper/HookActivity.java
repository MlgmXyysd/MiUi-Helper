package org.meowcat.miui.helper;

import android.content.Context;

import org.meowcat.bugcatcher.MeowCatApplication;
import org.meowcat.notaichi.NoTaiChi;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class HookActivity implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam loadPackageParam) {

        String packageName = loadPackageParam.packageName;
        ClassLoader classLoader = loadPackageParam.classLoader;

        if (packageName.equals("com.miui.securitycore")) {
            findAndHookMethod("com.miui.xspace.XSpaceCompat", classLoader, "pkgHasIcon", Context.class, String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) {
                    NoTaiChi.checkTC(param);
                    XposedBridge.log(MeowCatApplication.TAG + ": We are in com.miui.securitycore/com.miui.xspace.XSpaceCompat.pkgHasIcon(Context,String)Boolean");
                    param.setResult(true);
                }
            });
        }
    }
}
