package org.librealsense;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Frame {

    protected long instance;

    protected Frame(long instance) {
        this.instance = instance;
    }

    public ByteBuffer getFrameData() {
        ByteBuffer buffer = Native.rs2GetFrameData(instance);
        buffer.order(ByteOrder.nativeOrder());
        return buffer;
    }

    public void release() {
        Native.rs2ReleaseFrame(instance);
    }

    public int getWidth() {
        return Native.rs2GetFrameWidth(instance);
    }

    public int getHeight() {
        return Native.rs2GetFrameHeight(instance);
    }

    public int getStrideInBytes() {
        return Native.rs2GetFrameStrideInBytes(instance);
    }

    public boolean isExtendableTo(Native.Extension extension) {
        return 1 == Native.rs2IsFrameExtendableTo(instance, extension.ordinal());
    }
}