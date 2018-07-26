/**
 * Copyright 2018 Ricoh Company, Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.theta360.cloudupload.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

/**
 * Receive a broadcast of upload result by intent
 */
public class SpecifiedResultReceiver extends BroadcastReceiver {
    public static final String SPECIFED_RESULT = "com.theta360.cloudupload.specified-result";
    public static final String RESULT = "result";;

    private Callback mCallback;

    public SpecifiedResultReceiver(Callback callback) {
        mCallback = callback;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();

        String result = intent.getStringExtra(RESULT);
        if (SPECIFED_RESULT.equals(action)) {
            mCallback.callSpecifiedResultCallback(result);
        }
    }

    public interface Callback {
        void callSpecifiedResultCallback(String result);
    }
}
