package nettylearn.multhandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class InboundHandler2 extends ChannelInboundHandlerAdapter {

//    private static Logger logger = Logger.getLogger(InboundHandler2.class);

    @Override
    // 读取Client发送的信息，并打印出来
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        logger.info("InboundHandler2.channelRead: ctx :" + ctx);
        ByteBuf result = (ByteBuf) msg;
        byte[] result1 = new byte[result.readableBytes()];
        result.readBytes(result1);
        String resultStr = new String(result1);

        System.out.println("come to inbound2");
        System.out.println("Inbound2 said:" + resultStr.length());
        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//        logger.info("InboundHandler2.channelReadComplete");
        ctx.flush();
    }

}