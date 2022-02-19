package proxy.staticproxy;

/**
 * @author wangyz
 * @date 2022/2/19
 */
public class Main {
    public static void main(String[] args) {
        //X 程序员
        ILawsuit lawsuit = new XProgrammer();
        //程序员请的律师，把自己的事务交于律师来处理
        ProxyLawyer proxyLawyer = new ProxyLawyer(lawsuit);
        //律师开始处理
        proxyLawyer.submit();
        proxyLawyer.burden();
        proxyLawyer.defend();
        proxyLawyer.finish();

    }
}
