package com.imlz.sharecore;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShareUtil {

    private Context mContext;
    private Intent mIntent;
    private ArrayList<ActivityResolveInfo> mActivities = new ArrayList<ActivityResolveInfo>();

    public ShareUtil(Context context, ArrayList<Uri> uris)
    {
        mContext = context;
        mIntent = computeSharingIntent(uris);
        loadActivities();
    }


    private Intent computeSharingIntent(ArrayList<Uri> uris) {
        final Intent intent = new Intent();
        int size = uris.size();
        final String mimeType = "image/*";
        if (size > 1) {
            intent.setAction(Intent.ACTION_SEND_MULTIPLE).setType(mimeType);
            intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);
        } else {
            intent.setAction(Intent.ACTION_SEND).setType(mimeType);
            intent.putExtra(Intent.EXTRA_STREAM, uris.get(0));
        }
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        return intent;
    }

    private void loadActivities() {
        if (mIntent != null) {
            mActivities.clear();
            List<ResolveInfo> resolveInfos = mContext.getPackageManager()
                    .queryIntentActivities(mIntent, 0);
            final int resolveInfoCount = resolveInfos.size();
            for (int i = 0; i < resolveInfoCount; i++) {
                ResolveInfo resolveInfo = resolveInfos.get(i);
                mActivities.add(new ActivityResolveInfo(resolveInfo));
            }
        }
    }

    public Intent getBaseIntent(String activityName) {
        if (mIntent == null) {
            return null;
        }

        for(int index = 0; index < mActivities.size(); index ++)
        {
            ActivityResolveInfo chosenActivity = mActivities.get(index);
            if(activityName.equals(chosenActivity.resolveInfo.activityInfo.name))
            {
                ComponentName chosenName = new ComponentName(
                        chosenActivity.resolveInfo.activityInfo.packageName,
                        chosenActivity.resolveInfo.activityInfo.name);
                Intent choiceIntent = new Intent(mIntent);
                choiceIntent.setComponent(chosenName);

                choiceIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                return choiceIntent;
            }
        }
        return null;
    }

//	public void startAct(int index) {
//		Intent launchIntent = getBaseIntent(index);
//		if (launchIntent != null) {
//			launchIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
//			mContext.startActivity(launchIntent);
//		}
//	}

    /**
     * Represents an activity.
     */
    public final class ActivityResolveInfo implements
            Comparable<ActivityResolveInfo> {

        /**
         * The {@link ResolveInfo} of the activity.
         */
        public final ResolveInfo resolveInfo;

        /**
         * Weight of the activity. Useful for sorting.
         */
        public float weight;

        /**
         * Creates a new instance.
         *
         * @param resolveInfo
         *            activity {@link ResolveInfo}.
         */
        public ActivityResolveInfo(ResolveInfo resolveInfo) {
            this.resolveInfo = resolveInfo;
        }

        @Override
        public int hashCode() {
            return 31 + Float.floatToIntBits(weight);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            ActivityResolveInfo other = (ActivityResolveInfo) obj;
            if (Float.floatToIntBits(weight) != Float
                    .floatToIntBits(other.weight)) {
                return false;
            }
            return true;
        }

        public int compareTo(ActivityResolveInfo another) {
            return Float.floatToIntBits(another.weight)
                    - Float.floatToIntBits(weight);
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            builder.append("resolveInfo:").append(resolveInfo.toString());
            builder.append("; weight:").append(new BigDecimal(weight));
            builder.append("]");
            return builder.toString();
        }
    }


    public static String buildTransaction(final String type) {
        return (type == null) ? String.valueOf(System.currentTimeMillis()) : type + System.currentTimeMillis();
    }


    public static byte[] bmpToByteArray(final Bitmap bmp, final boolean needRecycle) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, output);
        if (needRecycle) {
            bmp.recycle();
        }
        byte[] result = output.toByteArray();
        try {
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }



}