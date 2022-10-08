package com.youku.ribut.core.socket.websocket.response;


import com.youku.ribut.core.socket.java_websocket.framing.Framedata;
import com.youku.ribut.core.socket.websocket.dispatcher.IResponseDispatcher;
import com.youku.ribut.core.socket.websocket.dispatcher.ResponseDelivery;

/**
 * 接收到 Pong
 * <p>
 * Created by ZhangKe on 2019/3/28.
 */
public class PongResponse implements Response<Framedata> {

    private Framedata framedata;

    PongResponse() {
    }

    @Override
    public Framedata getResponseData() {
        return framedata;
    }

    @Override
    public void setResponseData(Framedata responseData) {
        this.framedata = responseData;
    }

    @Override
    public void onResponse(IResponseDispatcher dispatcher, ResponseDelivery delivery) {
        dispatcher.onPong(this.framedata, delivery);
    }

    @Override
    public void release() {
        framedata = null;
        ResponseFactory.releasePongResponse(this);
    }

    @Override
    public String toString() {
        return String.format("[@PongResponse%s->Framedata:%s]",
                hashCode(),
                framedata == null ?
                        "null" :
                        framedata.toString());
    }
}
