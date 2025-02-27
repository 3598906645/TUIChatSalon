package com.tencent.liteav.trtcchatsalon.model;

import android.util.Log;

import com.tencent.imsdk.v2.V2TIMGroupInfoResult;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMValueCallback;

import java.util.ArrayList;
import java.util.List;

public class ChatSalonRoomManager {
    private static final String TAG = "ChatSalonRoomManager";

    private static ChatSalonRoomManager sInstance;
    private RoomCallback mRoomCallback;

    public static ChatSalonRoomManager getInstance() {
        if (sInstance == null) {
            synchronized (ChatSalonRoomManager.class) {
                if (sInstance == null) {
                    sInstance = new ChatSalonRoomManager();
                }
            }
        }
        return sInstance;
    }


    public void addCallback(RoomCallback callback) {
        mRoomCallback = callback;
    }

    public void removeCallback() {
        mRoomCallback = null;
    }

    public void createRoom(int roomId, ActionCallback callback) {
        if (mRoomCallback != null) {
            mRoomCallback.onRoomCreate(roomId, callback);
        }
    }

    public void destroyRoom(int roomId, ActionCallback callback) {
        if (mRoomCallback != null) {
            mRoomCallback.onRoomDestroy(roomId, callback);
        }
    }

    public interface RoomCallback {
        void onRoomCreate(int roomId, ActionCallback callback);
        void onRoomDestroy(int roomId, ActionCallback callback);
    }

    public interface ActionCallback {
        void onSuccess();
        void onError(int errorCode, String message);
    }

    public void getGroupInfo(final String roomId, final GetGroupInfoCallback callback) {
        List<String> roomIdList = new ArrayList<>();
        roomIdList.add(roomId);
        Log.i(TAG, "get room id list " + roomIdList);
        V2TIMManager.getGroupManager().getGroupsInfo(roomIdList, new V2TIMValueCallback<List<V2TIMGroupInfoResult>>() {
            @Override
            public void onError(int i, String s) {
                Log.e(TAG, "get group info list fail, code:" + i+ " msg: " + s);
                callback.onFailed(-1, s);
            }

            @Override
            public void onSuccess(List<V2TIMGroupInfoResult> resultList) {
                if (resultList != null && !resultList.isEmpty()) {
                    V2TIMGroupInfoResult result = resultList.get(0);
                    callback.onSuccess(result);
                } else {
                    callback.onFailed(-1, "get groupInfo List is null");
                }
            }
        });
    }

    // 通过房间号获取房间信息的回调
    public interface GetGroupInfoCallback {
        void onSuccess(V2TIMGroupInfoResult result);
        void onFailed(int code, String msg);
    }
}
