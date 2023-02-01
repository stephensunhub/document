package clue.document.util;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * 文件读取工具
 *
 * @author Sun Shipeng
 * @date 2023-01-31 17:26
 */
public class ReadFileUtils {



    public static String readFileString(String filePath) throws IOException {
        return IOUtils.toString(new FileInputStream(filePath));
//        StringBuilder sb = new StringBuilder();
//        FileChannel channel = FileChannel.open(Paths.get(filePath), StandardOpenOption.READ);
//        ByteBuffer buf = ByteBuffer.allocate(4);
//        while(channel.read(buf) != -1){
//            buf.flip();
//            var rr = new String(buf.array());
//            System.out.print(rr);
//            sb.append(rr);
//            buf.clear();
//        }
//        channel.close();
//        return sb.toString();
    }

}
