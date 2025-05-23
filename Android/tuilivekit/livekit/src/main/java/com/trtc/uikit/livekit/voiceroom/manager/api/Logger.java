package com.trtc.uikit.livekit.voiceroom.manager.api;

import com.tencent.trtc.TRTCCloud;
import com.trtc.tuikit.common.system.ContextProvider;

import org.json.JSONException;
import org.json.JSONObject;

public class Logger {
    private static final String API                         = "TuikitLog";
    private static final String LOG_KEY_API                 = "api";
    private static final String LOG_KEY_PARAMS              = "params";
    private static final String LOG_KEY_PARAMS_LEVEL        = "level";
    private static final String LOG_KEY_PARAMS_MESSAGE      = "message";
    private static final String LOG_KEY_PARAMS_FILE         = "file";
    private static final String LOG_KEY_PARAMS_MODULE       = "module";
    private static final String LOG_KEY_PARAMS_LINE         = "line";
    private static final String LOG_KEY_PARAMS_MODULE_VALUE = "VoiceRoomKit";
    private static final int    LOG_KEY_PARAMS_LINE_VALUE   = 0;
    private static final int    LOG_LEVEL_INFO              = 0;
    private static final int    LOG_LEVEL_WARNING           = 1;
    private static final int    LOG_LEVEL_ERROR             = 2;

    public static void error(String file, String message) {
        log(message, LOG_LEVEL_ERROR, file);
    }

    public static void warn(String file, String message) {
        log(message, LOG_LEVEL_WARNING, file);
    }


    public static void info(String file, String message) {
        log(message, LOG_LEVEL_INFO, file);
    }

    private static void log(String message, int level, String file) {

        try {
            JSONObject paramsJson = new JSONObject();
            paramsJson.put(LOG_KEY_PARAMS_LEVEL, level);
            paramsJson.put(LOG_KEY_PARAMS_MESSAGE, message);
            paramsJson.put(LOG_KEY_PARAMS_MODULE, LOG_KEY_PARAMS_MODULE_VALUE);
            paramsJson.put(LOG_KEY_PARAMS_FILE, file);
            paramsJson.put(LOG_KEY_PARAMS_LINE, LOG_KEY_PARAMS_LINE_VALUE);

            JSONObject loggerJson = new JSONObject();
            loggerJson.put(LOG_KEY_API, API);
            loggerJson.put(LOG_KEY_PARAMS, paramsJson);

            TRTCCloud.sharedInstance(ContextProvider.getApplicationContext())
                    .callExperimentalAPI(loggerJson.toString());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}