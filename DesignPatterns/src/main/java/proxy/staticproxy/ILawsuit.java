package proxy.staticproxy;

/**
 * 诉讼接口类:
 * @author wangyz
 * @date 2022/2/19
 */
public interface ILawsuit {
    /**
     * 提交申请
     */
    void submit();

    /**
     * 举行举证
     */
    void burden();

    /**
     * 开始辩护
     */
    void defend();

    /**
     * 诉讼完成
     */
    void finish();
}
