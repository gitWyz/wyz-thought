package proxy.dynamicproxy;

/**
 * 具体诉讼人（X程序员）:
 * @author wangyz
 * @date 2022/2/19
 */
public class XProgrammer implements ILawsuit {
    @Override
    public void submit() {
        System.out.println("老板欠 X 程序员工资，申请仲裁!");
    }

    @Override
    public void burden() {
        System.out.println("这是合同书和过去一年的银行工资流水");
    }

    @Override
    public void defend() {
        System.out.println("证据确凿！不需要再说什么了！");
    }

    @Override
    public void finish() {
        System.out.println("诉讼成功！判决老板即日起 7 天内结算工资！");
    }
}
