package proxy.staticproxy;

/**
 * @author wangyz
 * @date 2022/2/19
 */
public class ProxyLawyer implements ILawsuit{
    private final ILawsuit lawsuit;
    public ProxyLawyer(ILawsuit lawsuit) {
        this.lawsuit = lawsuit;
    }

    @Override
    public void submit() {
        lawsuit.submit();
    }

    @Override
    public void burden() {
        lawsuit.burden();
    }

    @Override
    public void defend() {
        lawsuit.defend();
    }

    @Override
    public void finish() {
        lawsuit.finish();
    }
}
