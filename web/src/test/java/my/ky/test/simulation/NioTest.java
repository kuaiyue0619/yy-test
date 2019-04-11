package my.ky.test.simulation;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * <ul>
 * <li>nio测试</li>
 * <li>User:ky Date:2019/4/3 Time:10:59</li>
 * </ul>
 */
public class NioTest {

    @Test
    public void testFileChannel() {
        File fromFile = new File("E:/11.txt");
        File toFile = new File("E:/11.bak.txt");
        this.copyFileWithFileChannel(fromFile, toFile);
    }

    private void copyFileWithFileChannel(File fromFile, File toFile) {
        try (FileInputStream in = new FileInputStream(fromFile);
             FileOutputStream out = new FileOutputStream(toFile);
             FileChannel inFileChannel = in.getChannel();
             FileChannel outFileChannel = out.getChannel()) {

            inFileChannel.transferTo(0, inFileChannel.size(), outFileChannel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
