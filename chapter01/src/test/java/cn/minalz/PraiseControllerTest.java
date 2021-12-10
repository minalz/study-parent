package cn.minalz;

import cn.minalz.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CoreApplication.class)
public class PraiseControllerTest {

    @Autowired
    RedisUtil redisUtil;

    @Test
    public void test01() {
        int n = 100;
        create(n);
    }

    @Test
    public void test02() {
        redisUtil.setBit("test", 1, true);
        System.out.println(redisUtil.bitCount("test"));
        System.out.println("-------------------");
        redisUtil.setBit("test", 3, true);
        System.out.println(redisUtil.bitCount("test"));
    }

    /**
     * 创建bitmap数组
     */
    public byte[] create(int n){
        byte[] bits = new byte[getIndex(n) + 1];

        for(int i = 0; i < n; i++){
            add(bits, i);
        }

        System.out.println(contains(bits, 11));

        int index = 1;
        for(byte bit : bits){
            System.out.println("-------" + index++ + "-------");
            showByte(bit);

        }

        return bits;
    }

    /**
     * 标记指定数字（num）在bitmap中的值，标记其已经出现过<br/>
     * 将1左移position后，那个位置自然就是1，然后和以前的数据做|，这样，那个位置就替换成1了
     * @param bits
     * @param num
     */
    public void add(byte[] bits, int num){
        bits[getIndex(num)] |= 1 << getPosition(num);
    }

    /**
     * 判断指定数字num是否存在<br/>
     * 将1左移position后，那个位置自然就是1，然后和以前的数据做&，判断是否为0即可
     * @param bits
     * @param num
     * @return
     */
    public boolean contains(byte[] bits, int num){
        return (bits[getIndex(num)] & 1 << getPosition(num)) != 0;
    }

    /**
     * num/8得到byte[]的index
     * @param num
     * @return
     */
    public int getIndex(int num){
        return num >> 3;
    }

    /**
     * num%8得到在byte[index]的位置
     * @param num
     * @return
     */
    public int getPosition(int num){
        return num & 0x07;
    }

    /**
     * 重置某一数字对应在bitmap中的值<br/>
     * 对1进行左移，然后取反，最后与byte[index]作与操作。
     * @param bits
     * @param num
     */
    public void clear(byte[] bits, int num){
        bits[getIndex(num)] &= ~(1 << getPosition(num));
    }

    /**
     * 打印byte类型的变量<br/>
     * 将byte转换为一个长度为8的byte数组，数组每个值代表bit
     */

    public void showByte(byte b){
        byte[] array = new byte[8];
        for(int i = 7; i >= 0; i--){
            array[i] = (byte)(b & 1);
            b = (byte)(b >> 1);
        }

        for (byte b1 : array) {
            System.out.print(b1);
            System.out.print(" ");
        }

        System.out.println();
    }

}
