package com.dgk.mvvm.activity.src

/**
 *
 * @author Guangkuo
 * @date 2021/8/7 10:29
 * @email dingguangkuo@163.com
 */
fun mvvmManifest(className: String, useCustomTitle: Boolean, packageName: String) = """
<manifest xmlns:android="http://schemas.android.com/apk/res/android">
    <application>
${
    if (useCustomTitle) {
        """
            <activity
                android:name="${packageName}.${className}Activity"
                android:label="$className"
                android:screenOrientation="portrait"
                android:theme="@style/Theme.Common.HaveTitle" />
        """
    } else {
        """
            <activity
                android:name="${packageName}.${className}Activity"
                android:screenOrientation="portrait" />
        """
    }
}
    </application>
</manifest>
"""